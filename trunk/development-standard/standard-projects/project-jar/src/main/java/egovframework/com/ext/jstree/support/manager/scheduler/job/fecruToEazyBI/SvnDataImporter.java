package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreAddService;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.util.DateUtils;
import egovframework.com.ext.jstree.support.util.StringUtils;

@Component
public class SvnDataImporter
{
    @Resource(name = "egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    @Resource(name = "CoreService")
    CoreService coreService;
    
    @Resource(name = "CoreAddService")
    CoreAddService coreAddService;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public static String storeStartDate = "N/A";
    public static String storePropertiesDate = "N/A";
    
    @Scheduled(cron = "0 0 * * * *")
    public void execute()
    {
        //여기서 스톱.
        if(storePropertiesDate.equals(egovMessageSource.getMessage("ahnlab.fisheye.start.date"))){
            //프로퍼티 값이랑 저장된 값이랑 동일하므로 변경사항 없음.
        }else{
            storeStartDate = egovMessageSource.getMessage("ahnlab.fisheye.start.date");
            storePropertiesDate = egovMessageSource.getMessage("ahnlab.fisheye.start.date");
        }
        
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
                    
                    String startDate = egovMessageSource.getMessage("ahnlab.fisheye.start.date");
                    logger.info(" 초기 설정 프로퍼티를 가져옵니다. =" + startDate);
                    
                    if (storeStartDate.equals("N/A"))
                    {
                        if (startDate.equals("N/A") || startDate.isEmpty())
                        {
                            logger.info("최초 실행이면서.");
                            storeStartDate = DateUtils.format("yyyy-MM-dd", DateUtils.getCurrentDay());
                            logger.info("프로퍼티에 설정된 값도 없습니다.");
                            
                            BTRV_Result btrvSearchNode = new BTRV_Result();
                            btrvSearchNode.setRef(2);
                            btrvSearchNode.setC_position(0);
                            btrvSearchNode.setC_title("ahnlab");
                            btrvSearchNode.setSearchStr("ahnlab");
                            btrvSearchNode.setC_type("default");
                            btrvSearchNode.setC_resultstring("fail");
                            btrvSearchNode.setOrderString("check");
                            List<String> results = coreService.searchNode(btrvSearchNode);
                            logger.info("실패한 내역을 찾습니다. =" + results.size());
                            if (!results.isEmpty())
                            {
                                logger.info("실패한 내역이 있고 최초 실행이고 프로퍼티 설정값도 없어서 실패한 날짜부터 작업을 시작합니다.");
                                BTRV_Result btrvSearchResultNode = new BTRV_Result();
                                btrvSearchNode.setC_id(Integer.parseInt(StringUtils.remove(results.get(0), "#node_")));
                                btrvSearchResultNode = coreService.getNode(btrvSearchNode);
                                coreService.removeNode(btrvSearchResultNode);
                                storeStartDate = btrvSearchResultNode.getC_resultdate();
                                logger.info("실패한 노드를 가져와서 저장합니다. =" + storeStartDate);
                                processFire(authToken, repository);
                            }
                            else
                            {
                                logger.info("실패한 내역이 없고 최초 실행이고 프로퍼티 설정값도 없어서 성공한 날짜부터 작업을 시작합니다");
                                BTRV_Result getDBResult = new BTRV_Result();
                                getDBResult.setRef(2);
                                getDBResult.setC_position(0);
                                getDBResult.setC_title("ahnlab");
                                getDBResult.setSearchStr("ahnlab");
                                getDBResult.setC_type("default");
                                getDBResult.setC_resultstring("done");
                                getDBResult.setOrderString("check");
                                List<String> orderResults = coreService.searchNode(getDBResult);
                                if (!orderResults.isEmpty())
                                {
                                    getDBResult.setC_id(Integer.parseInt(StringUtils.remove(orderResults
                                            .get(orderResults.size()), "#node_")));
                                    String dbOrderDate = coreService.getNode(getDBResult).getC_resultdate();
                                    logger.info("데이터베이스에서 가져온 가장 최근 날짜" + dbOrderDate);
                                    storeStartDate = dbOrderDate;
                                    processFire(authToken, repository);
                                }
                                else
                                {
                                    logger.info("최초 실행이지만, 데이터도 없고, 프로퍼티도 비어있는 경우엔 1년 뒤 부터 처리한다. ");
                                    storeStartDate = DateUtils.format("yyyy-MM-dd", DateUtils.getPreDate(DateUtils
                                            .getCurrentDay(), 365));
                                    processFire(authToken, repository);
                                }
                                
                            }
                        }
                        else
                        {
                            logger.info("최초 실행이면서.");
                            logger.info("프로퍼티에 설정된 값이 있습니다." + startDate);
                            storeStartDate = startDate;
                            processFire(authToken, repository);
                        }
                    }
                    else
                    {
                        logger.info("이미 실행이 진행중인 상태임.");
                        processFire(authToken, repository);
                    }
                    
                }
                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void processFire(String authToken, Element repository) throws Exception
    {
        logger.info("====>" + storeStartDate);
        
        
        Date nowDate = DateUtils.getCurrentDay();
        Date preDate = DateUtils.getPreDate(nowDate, 1);
        String preDateString = DateUtils.format("yyyy-MM-dd", preDate);
        if(storeStartDate.equals(preDateString)){
            logger.info("어제까지의 데이터가 수집되었음. 종료함.");
        }else{
            // 해당 날짜의 작업이 이미 실행됬다면 건너뛰게 함.
            BTRV_Result btrvResultSearchNode = new BTRV_Result();
            btrvResultSearchNode.setRef(2);
            btrvResultSearchNode.setC_position(0);
            btrvResultSearchNode.setC_title("ahnlab");
            btrvResultSearchNode.setC_type("default");
            btrvResultSearchNode.setC_resultstring("done");
            btrvResultSearchNode.setC_resultdate(storeStartDate);
            List<String> resultsSet = coreService.searchNode(btrvResultSearchNode);
            if (resultsSet.isEmpty())
            {
                logger.info("해당 데이터가 없으므로. 작업을 진행함." + storeStartDate);
                Date storeTempDate = DateUtils.getDate(storeStartDate);
                String fisheyeEndDate= DateUtils.format("yyyy-MM-dd", DateUtils.getNextDate(storeTempDate, 1));
                repositoryCheckOut(authToken, repository.getAttributeValue("name"), storeStartDate, fisheyeEndDate);
            }
            else
            {
                logger.info("해당 데이터가 이미 있고 작업이 진행됬었음." + storeStartDate);
            }
            Date storeTempDate = DateUtils.getDate(storeStartDate);
            storeStartDate = DateUtils.format("yyyy-MM-dd", DateUtils.getNextDate(storeTempDate, 1));
            logger.info("작업 후 날짜를 증가시킵니다. " + storeStartDate);
        }
        
    }
    
    @Transactional(readOnly = false, rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
    private void repositoryCheckOut(String authToken, String repositoryName, String startDate, String endDate)
            throws Exception
    {
        logger.info("auth token check : " + authToken);
        
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
                        
                        // RV 포맷이 있는지.
                        int checkPointRV = test(commentText, "RV", "end");
                        checkPointRV = (checkPointRV < 0) ? commentText.length() : checkPointRV;
                        String filterRVstr = StringUtils.substring(commentText, checkPointRV);
                        logger.info("returnStr = " + filterRVstr);
                        
                        // RV가 있더라도 : 구분자가 있는지
                        int checkPointRVDelimiter = test(filterRVstr, ":", "start");
                        checkPointRVDelimiter = (checkPointRVDelimiter < 0) ? commentText.length()
                                : checkPointRVDelimiter;
                        String filterRVDelimiterStr = StringUtils.substring(filterRVstr, checkPointRVDelimiter);
                        logger.info("returnStr = " + filterRVDelimiterStr);
                        
                        // RV와 구분자가 있더라도 잘 닫았는지.
                        int checkPointRVDivid = test(filterRVDelimiterStr, "]", "start");
                        checkPointRVDivid = (checkPointRV < 0) ? 1 : checkPointRVDivid;
                        String filterRVDividStr = StringUtils.substring(filterRVDelimiterStr, 1, checkPointRVDivid);
                        String filterRVTrimDividStr = filterRVDividStr.trim();
                        logger.info("patternDelimiterReturnStr = " + filterRVTrimDividStr);
                        
                        if (StringUtils.lowerCase(filterRVTrimDividStr).equals("na")
                                || StringUtils.lowerCase(filterRVTrimDividStr).equals("n/a"))
                        {
                            csvDataMap.put("RV", "N/A");
                        }
                        else if (filterRVTrimDividStr.isEmpty())
                        {
                            csvDataMap.put("RV", "N/A");
                        }
                        else
                        {
                            csvDataMap.put("RV", filterRVTrimDividStr);
                        }
                        
                        // BT 포맷이 있는지.
                        int checkPointBT = test(commentText, "BT", "end");
                        checkPointBT = (checkPointBT < 0) ? commentText.length() : checkPointBT;
                        String filterBTstr = StringUtils.substring(commentText, checkPointBT);
                        logger.info("returnStr = " + filterBTstr);
                        
                        // BT가 있더라도 : 구분자가 있는지
                        int checkPointDelimiter = test(filterBTstr, ":", "start");
                        checkPointDelimiter = (checkPointDelimiter < 0) ? commentText.length() : checkPointDelimiter;
                        String filterDelimiterstr = StringUtils.substring(filterBTstr, checkPointDelimiter);
                        logger.info("returnStr = " + filterDelimiterstr);
                        
                        // BT와 구분자가 있더라도 잘 닫았는지.
                        int checkPointDivid = test(filterBTstr, "]", "start");
                        checkPointDivid = (checkPointDivid < 0) ? 2 : checkPointDivid;
                        String filterDividstr = StringUtils.substring(filterDelimiterstr, 1, checkPointDivid - 1);
                        String filterTrimdividStr = filterDividstr.trim();
                        logger.info("patternDelimiterReturnStr = " + filterTrimdividStr);
                        
                        // 여러개의 이슈를 연결하였는지 하나만 했는지
                        int checkPointMuiltiIssue = test2(filterTrimdividStr, ",", "start");
                        checkPointMuiltiIssue = (checkPointMuiltiIssue < 0) ? 0 : checkPointMuiltiIssue;
                        String filterPointMuiltiIssueStr = StringUtils.substring(filterTrimdividStr, 0,
                                                                                 checkPointMuiltiIssue);
                        String filterPointMuiltiIssueTrimStr = filterPointMuiltiIssueStr.trim();
                        logger.info("filterPointMuiltiIssueTrimStr = " + filterPointMuiltiIssueTrimStr);
                        
                        // 전위 이슈를 가져와서 - 구분후 숫자로만 되 있는지 검사
                        int checkPointIssueNumber = test(filterPointMuiltiIssueStr, "-", "start");
                        checkPointIssueNumber = (checkPointIssueNumber < 0) ? filterPointMuiltiIssueStr.length() - 1
                                : checkPointIssueNumber;
                        String filterPointIssueNumber = StringUtils.substring(filterPointMuiltiIssueStr,
                                                                              checkPointIssueNumber + 1);
                        String filterPointIssueTrimNumber = filterPointIssueNumber.trim();
                        logger.info("filterPointIssueTrimNumber = " + filterPointIssueTrimNumber);
                        // 정규 표현식 검증.
                        if (regMatch("^[_0-9a-zA-Z-]+-[0-9]*$", filterPointMuiltiIssueTrimStr)
                                && regMatch("^[0-9]*$", filterPointIssueTrimNumber))
                        {
                            csvDataMap.put("BT", filterTrimdividStr);
                        }
                        else
                        {
                            csvDataMap.put("BT", "N/A");
                        }
                        
                        csvDataMap.put("SVNLOG", StringUtils.substring(commentText, 0, 3999));
                        
                    }// if end
                }// inner for end
                csvDataList.add(csvDataMap);
                
            }// outer for end
            for (Map<String, Object> m : csvDataList)
            {
                BTRV_ComprehensiveTree btrv_comprehensiveTree = new BTRV_ComprehensiveTree();
                btrv_comprehensiveTree.setRef(2);
                btrv_comprehensiveTree.setC_position(0);
                btrv_comprehensiveTree.setC_title("ahnlab");
                btrv_comprehensiveTree.setC_type("default");
                
                btrv_comprehensiveTree.setC_project((String) m.get("repositoryName"));
                btrv_comprehensiveTree.setC_path((String) m.get("path"));
                btrv_comprehensiveTree.setC_rev((String) m.get("revision"));
                btrv_comprehensiveTree.setC_author((String) m.get("author"));
                btrv_comprehensiveTree.setC_commitdate((String) m.get("date"));
                btrv_comprehensiveTree.setC_rv((String) m.get("RV"));
                btrv_comprehensiveTree.setC_bt((String) m.get("BT"));
                btrv_comprehensiveTree.setC_svnlog((String) m.get("SVNLOG"));
                coreService.addNode(btrv_comprehensiveTree);
            }
            BTRV_Result btrv_result = new BTRV_Result();
            btrv_result.setRef(2);
            btrv_result.setC_position(0);
            btrv_result.setC_title("ahnlab");
            btrv_result.setC_type("default");
            btrv_result.setC_resultdate(startDate);
            btrv_result.setC_resultstring("done");
            coreService.addNode(btrv_result);
        }
    }
    
    private boolean regMatch(String regEx, String filterPointMuiltiIssueTrimStr)
    {
        if (Pattern.matches(regEx, filterPointMuiltiIssueTrimStr))
        {
            return true;
        }
        else
        {
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
            checkPointValue = (matchPoint.equals("end")) ? matcherObj.end() : matcherObj.start();
            logger.info("checkPoint = " + checkPointValue);
        }
        else
        {
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
            // muilti issue
            checkPointValue = (matchPoint.equals("end")) ? matcherObj.end() : matcherObj.start();
            logger.info("checkPoint = " + checkPointValue);
        }
        else
        {
            // single issue
            checkPointValue = lowerStr.length();
            System.out.println("checkPoint = " + checkPointValue);
        }
        return checkPointValue;
    }
}