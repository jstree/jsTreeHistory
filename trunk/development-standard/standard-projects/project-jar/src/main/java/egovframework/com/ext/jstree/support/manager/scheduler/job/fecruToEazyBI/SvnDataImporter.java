package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVWriter;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.ext.jstree.support.util.DateUtils;
import egovframework.com.ext.jstree.support.util.StringUtils;

@Component
public class SvnDataImporter
{
    @Resource(name = "egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Scheduled(cron = "0 12 17 * * *")
    public void execute()
    {
        try
        {
            String authUrlAddr = egovMessageSource.getMessage("ahnlab.fisheye.baseurl")
                    + "/rest-service/auth-v1/login?userName=" + egovMessageSource.getMessage("ahnlab.fisheye.id")
                    + "&password=" + egovMessageSource.getMessage("ahnlab.fisheye.pass");
            Element authRootNode = getRootNodeFromUrl(authUrlAddr);
            Element authRootChildNode = authRootNode.getChild("token");
            String authToken = authRootChildNode.getText();
            if (authToken.isEmpty())
            {
                logger.error("Fisheye error thorw : not auth");
            }
            else
            {
                logger.info("auth token check : " + authToken);
                String queryUrl = egovMessageSource.getMessage("ahnlab.fisheye.baseurl")
                        + "/rest-service-fe/repositories-v1";
                String query = "?FEAUTH=" + authToken;
                String url = queryUrl + query;
                logger.info(url);
                
                Element root = getRootNodeFromUrl(url);
                @SuppressWarnings("unchecked")
                List<Element> repositorys = root.getChildren("repository");
                for (Element repository : repositorys)
                {
                    logger.info(repository.getText() + repository.getAttributeValue("repositoryState"));
                    logger.info(repository.getText() + repository.getAttributeValue("name"));
                    logger.info(repository.getText() + repository.getAttributeValue("finishedFullSlurp"));
                    logger.info(repository.getText() + repository.getAttributeValue("enabled"));
                    repositoryCheckOut(authToken, repository.getAttributeValue("name"));
                }
                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void repositoryCheckOut(String authToken, String repositoryName) throws UnsupportedEncodingException,
            JDOMException, IOException, MalformedURLException
    {
        logger.info("auth token check : " + authToken);
        
        // 일주일에 한번 매주 일요일 새벽 ( 오전 ) 에 부하가 없을것으로 사료되어.
        // 스케쥴러를 조정하고 일주일치 데이터를 export 하는것으로 합니다.
        
        String startDate = egovMessageSource.getMessage("ahnlab.fisheye.start.date");
        String endDate = egovMessageSource.getMessage("ahnlab.fisheye.end.date");
        if (startDate.equals("N/A") || startDate.isEmpty() || endDate.equals("N/A") || endDate.isEmpty())
        {
            // 검색 날짜 선정이 안된 경우 ( 최초 실행을 위한 코드 )
            startDate = DateUtils.format("yyyy-MM-dd", DateUtils.getWeekDate(DateUtils.getCurrentDay(), -1));
            endDate = DateUtils.format("yyyy-MM-dd", DateUtils.getCurrentDay());
        }
        
        String queryUrl = egovMessageSource.getMessage("ahnlab.fisheye.baseurl")
                + "/rest-service-fe/search-v1/queryAsRows/" + repositoryName;
        String query = "?query=";
        query += URLEncoder.encode("select revisions where date in [ " + startDate + ", " + endDate + " ] ", "UTF-8");
        query += URLEncoder
                .encode("return path , dir , revision , author , date , comment , csid , isBinary , totalLines , ",
                        "UTF-8");
        query += URLEncoder
                .encode("linesAdded , linesRemoved , isAdded , isDeleted , isCopied , isMoved , tags , reviews",
                        "UTF-8");
        query += "&FEAUTH=" + authToken;
        String url = queryUrl + query;
        logger.info(url);
        
        Element rootNode = getRootNodeFromUrl(url);
        
        @SuppressWarnings("unchecked")
        List<Element> rowNodes = rootNode.getChildren("row");
        if (null == rowNodes)
        {
            logger.error("no search data !");
        }
        else
        {
            // csv export setting
            Map<String, Object> csvDataMap = null;
            HashSet<Map<String, Object>> csvDataList = new HashSet<Map<String, Object>>();
            
            // head setting
            Element headingsNode = rootNode.getChild("headings");
            @SuppressWarnings("unchecked")
            List<Element> headList = headingsNode.getChildren("heading");
            
            for (Element rowNode : rowNodes)
            {
                @SuppressWarnings("unchecked")
                List<Element> itemList = rowNode.getChildren("item");
                csvDataMap = new HashMap<String, Object>();
                for (int i = 0; i < itemList.size(); i++)
                {
                    csvDataMap.put("repositoryName", repositoryName);
                    
                    String heading = headList.get(i).getText();
                    Element itemText = itemList.get(i);
                    logger.info(heading + " == " + itemText.getText());
                    
                    if (heading.equals("path"))
                    {
                        String revisionText = itemText.getText();
                        String revisionLowerText = revisionText.toLowerCase();
                        csvDataMap.put("path", revisionLowerText);
                    }
                    
                    if (heading.equals("revision"))
                    {
                        String revisionText = itemText.getText();
                        String revisionLowerText = revisionText.toLowerCase();
                        csvDataMap.put("revision", revisionLowerText);
                    }
                    
                    if (heading.equals("author"))
                    {
                        String authorText = itemText.getText();
                        String authorLowerText = authorText.toLowerCase();
                        csvDataMap.put("author", authorLowerText);
                    }
                    
                    if (heading.equals("date"))
                    {
                        String dateText = itemText.getText();
                        String dateLowerText = dateText.toLowerCase();
                        csvDataMap.put("date", dateLowerText);
                    }
                    
                    if (heading.equals("comment"))
                    {
                        String commentText = itemText.getText();
                        
                        //RV 포맷이 있는지.
                        int checkPointRV = test(commentText, "RV", "end");
                        checkPointRV = (checkPointRV < 0)?commentText.length():checkPointRV;
                        String filterRVstr = StringUtils.substring(commentText, checkPointRV);
                        logger.info("returnStr = " + filterRVstr);
                        
                        //RV가 있더라도 : 구분자가 있는지
                        int checkPointRVDelimiter = test(filterRVstr, ":", "start");
                        checkPointRVDelimiter = (checkPointRVDelimiter < 0)?commentText.length():checkPointRVDelimiter;
                        String filterRVDelimiterStr = StringUtils.substring(filterRVstr, checkPointRVDelimiter);
                        logger.info("returnStr = " + filterRVDelimiterStr);
                        
                        //RV와 구분자가 있더라도 잘 닫았는지.
                        int checkPointRVDivid = test(filterRVDelimiterStr, "]", "start");
                        checkPointRVDivid = (checkPointRV < 0)?1:checkPointRVDivid;
                        String filterRVDividStr = StringUtils.substring(filterRVDelimiterStr, 1, checkPointRVDivid);
                        String filterRVTrimDividStr = filterRVDividStr.trim();
                        logger.info("patternDelimiterReturnStr = " + filterRVTrimDividStr);
                        
                        if(StringUtils.lowerCase(filterRVTrimDividStr).equals("na") || StringUtils.lowerCase(filterRVTrimDividStr).equals("n/a")){
                            csvDataMap.put("RV", "N/A");
                        }else if(filterRVTrimDividStr.isEmpty()){
                            csvDataMap.put("RV", "N/A");
                        }else{
                            csvDataMap.put("RV", filterRVTrimDividStr);
                        }
                        
                        
                        //BT 포맷이 있는지.
                        int checkPointBT = test(commentText, "BT", "end");
                        checkPointBT = (checkPointBT < 0)?commentText.length():checkPointBT;
                        String filterBTstr = StringUtils.substring(commentText, checkPointBT);
                        logger.info("returnStr = " + filterBTstr);
                        
                        //BT가 있더라도 : 구분자가 있는지
                        int checkPointDelimiter = test(filterBTstr, ":", "start");
                        checkPointDelimiter = (checkPointDelimiter < 0)?commentText.length():checkPointDelimiter;
                        String filterDelimiterstr = StringUtils.substring(filterBTstr, checkPointDelimiter);
                        logger.info("returnStr = " + filterDelimiterstr);
                        
                        //BT와 구분자가 있더라도 잘 닫았는지.
                        int checkPointDivid = test(filterBTstr, "]", "start");
                        checkPointDivid = (checkPointDivid < 0)?2:checkPointDivid;
                        String filterDividstr = StringUtils.substring(filterDelimiterstr, 1, checkPointDivid-1);
                        String filterTrimdividStr = filterDividstr.trim();
                        logger.info("patternDelimiterReturnStr = " + filterTrimdividStr);
                        
                        
                        //여러개의 이슈를 연결하였는지 하나만 했는지 
                        int checkPointMuiltiIssue = test2(filterTrimdividStr, ",", "start");
                        checkPointMuiltiIssue = (checkPointMuiltiIssue < 0)?0:checkPointMuiltiIssue;
                        String filterPointMuiltiIssueStr = StringUtils.substring(filterTrimdividStr, 0, checkPointMuiltiIssue);
                        String filterPointMuiltiIssueTrimStr = filterPointMuiltiIssueStr.trim();
                        logger.info("filterPointMuiltiIssueTrimStr = " + filterPointMuiltiIssueTrimStr);
                        

                        //전위 이슈를 가져와서 - 구분후 숫자로만 되 있는지 검사 
                        int checkPointIssueNumber = test(filterPointMuiltiIssueStr, "-", "start");
                        checkPointIssueNumber = (checkPointIssueNumber < 0)?filterPointMuiltiIssueStr.length()-1:checkPointIssueNumber;
                        String filterPointIssueNumber = StringUtils.substring(filterPointMuiltiIssueStr, checkPointIssueNumber+1);
                        String filterPointIssueTrimNumber = filterPointIssueNumber.trim();
                        logger.info("filterPointIssueTrimNumber = " + filterPointIssueTrimNumber);
                        //정규 표현식 검증.
                        if(regMatch("^[_0-9a-zA-Z-]+-[0-9]*$", filterPointMuiltiIssueTrimStr) && regMatch("^[0-9]*$", filterPointIssueTrimNumber)){
                            csvDataMap.put("BT", filterTrimdividStr);
                        }else{
                            csvDataMap.put("BT", "N/A");
                        }
                        
                        csvDataMap.put("SVNLOG", filterRVTrimDividStr + " / " + filterTrimdividStr);
                        
                    }// if end
                }// inner for end
                csvDataList.add(csvDataMap);
                
            }// outer for end
            try
            {
                /**
                 * csv 파일을 쓰기위한 설정 설명 D:\\test.csv : csv 파일저장할 위치+파일명 EUC-KR :
                 * 한글깨짐설정을 방지하기위한 인코딩설정(UTF-8로 지정해줄경우 한글깨짐) ',' : 배열을 나눌 문자열 '"'
                 * : 값을 감싸주기위한 문자
                 **/
                CSVWriter cw = new CSVWriter(new OutputStreamWriter(new FileOutputStream(
                        egovMessageSource.getMessage("ahnlab.fisheye.export.path") + repositoryName + "_" + startDate
                                + "-" + endDate + ".csv"), "EUC-KR"), ',', '"');
                try
                {
                    for (Map<String, Object> m : csvDataList)
                    {
                        // 배열을 이용하여 row를 CSVWriter 객체에 write
                        cw.writeNext(new String[] { String.valueOf(m.get("repositoryName")),  String.valueOf(m.get("path")),
                                String.valueOf(m.get("revision")), String.valueOf(m.get("author")),
                                String.valueOf(m.get("date")), String.valueOf(m.get("RV")) ,String.valueOf(m.get("BT")), String.valueOf(m.get("SVNLOG")) });
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    cw.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    private boolean regMatch(String regEx, String filterPointMuiltiIssueTrimStr)
    {
        if(Pattern.matches(regEx, filterPointMuiltiIssueTrimStr)){
            return true;
        }else{
            return false;
        }
    }
    
    private Element getRootNodeFromUrl(String url) throws JDOMException, IOException, MalformedURLException
    {
        SAXBuilder builder = new SAXBuilder();
        Document jdomdoc = builder.build(new URL(url));
        Element root = jdomdoc.getRootElement();
        return root;
    }
    
    private int test(String originStr, String checkStr, String matchPoint)
    {
        String lowerStr = originStr.toLowerCase();
        Pattern patternObj = Pattern.compile(checkStr, Pattern.CASE_INSENSITIVE);
        Matcher matcherObj = patternObj.matcher(lowerStr);
        int checkPointValue = 0;
        if (matcherObj.find())
        {
            checkPointValue = (matchPoint.equals("end"))?matcherObj.end():matcherObj.start();
            logger.info("checkPoint = " + checkPointValue);
        }else{
            checkPointValue = -1;
        }
        return checkPointValue;
    }
    
    private int test2(String originStr, String checkStr, String matchPoint)
    {
        String lowerStr = originStr.toLowerCase();
        Pattern patternObj = Pattern.compile(checkStr, Pattern.CASE_INSENSITIVE);
        Matcher matcherObj = patternObj.matcher(lowerStr);
        int checkPointValue = 0;
        if (matcherObj.find())
        {
            //muilti issue
            checkPointValue = (matchPoint.equals("end"))?matcherObj.end():matcherObj.start();
            logger.info("checkPoint = " + checkPointValue);
        }else{
            //single issue
            checkPointValue = lowerStr.length();
            System.out.println("checkPoint = " + checkPointValue);
        }
        return checkPointValue;
    }
}