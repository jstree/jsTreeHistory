package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
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
public class BTRV_Importer
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
    
    @Scheduled(cron = "0 59 16 28 08 ?")
    public void execute()
    {
        //여기서 스톱.
        if(storePropertiesDate.equals(egovMessageSource.getMessage("ahnlab.fisheye.start.date"))){
            //프로퍼티 값이랑 저장된 값이랑 동일하므로 변경사항 없음.
        }else{
            if(storeStartDate.equals("N/A")){
                
            }else{
                storeStartDate = egovMessageSource.getMessage("ahnlab.fisheye.start.date");
            }
            storePropertiesDate = egovMessageSource.getMessage("ahnlab.fisheye.start.date");
        }
        
        try
        {
            //logger.info("----------------------------- 인증시작 ---------------------------------");
            String authUrlAddr = egovMessageSource.getMessage("ahnlab.fisheye.baseurl")
                    + "/rest-service/auth-v1/login?userName=" + egovMessageSource.getMessage("ahnlab.fisheye.id")
                    + "&password=" + egovMessageSource.getMessage("ahnlab.fisheye.pass");
            Element authRootNode = getRootNodeFromUrl(authUrlAddr);
            Element authRootChildNode = authRootNode.getChild("token");
            
            String authToken = authRootChildNode.getText();
                    
            if (authToken.isEmpty())
            {
                //logger.error("Fisheye error thorw : not auth");
            }
            else
            {
                //logger.info("----------------------------- 레파지토리 가져오기 ---------------------------------");
                //logger.info("auth token check : " + authToken);
                String queryUrl = egovMessageSource.getMessage("ahnlab.fisheye.baseurl")
                        + "/rest-service-fe/repositories-v1";
                String query = "?FEAUTH=" + authToken;
                String url = queryUrl + query;
                logger.info(url);
                
                Element root = getRootNodeFromUrl(url);
                if(root.getName().equals("blank")){
                    
                }else{
                    
                    @SuppressWarnings("unchecked")
                    List<Element> repositorys = root.getChildren("repository");
                    for (Element repository : repositorys)
                    {
                        //logger.info("----------------------------- 레파지토리 반복 ---------------------------------");
                        //logger.info(repository.getText() + repository.getAttributeValue("repositoryState"));
                        //logger.info(repository.getText() + repository.getAttributeValue("name"));
                        //logger.info(repository.getText() + repository.getAttributeValue("finishedFullSlurp"));
                        //logger.info(repository.getText() + repository.getAttributeValue("enabled"));
                        
                        String startDate = egovMessageSource.getMessage("ahnlab.fisheye.start.date");
                        //logger.info(" 초기 설정 프로퍼티를 가져옵니다. =" + startDate);
                        
                        if (storeStartDate.equals("N/A"))
                        {
                            if (startDate.equals("N/A") || startDate.isEmpty())
                            {
                                //logger.info("최초 실행이면서.");
                                storeStartDate = DateUtils.format("yyyy-MM-dd", DateUtils.getCurrentDay());
                                //logger.info("프로퍼티에 설정된 값도 없습니다.");
                                
                                BTRV_Result btrvSearchNode = new BTRV_Result();
                                btrvSearchNode.setRef(2);
                                btrvSearchNode.setC_position(0);
                                btrvSearchNode.setC_title("ahnlab");
                                btrvSearchNode.setSearchStr("ahnlab");
                                btrvSearchNode.setC_type("default");
                                btrvSearchNode.setC_resultstring("fail");
                                btrvSearchNode.setOrderString("check");
                                List<String> results = coreService.searchNode(btrvSearchNode);
                                //logger.info("실패한 내역을 찾습니다. =" + results.size());
                                if (!results.isEmpty())
                                {
                                    //logger.info("실패한 내역이 있고 최초 실행이고 프로퍼티 설정값도 없어서 실패한 날짜부터 작업을 시작합니다.");
                                    BTRV_Result btrvSearchResultNode = new BTRV_Result();
                                    btrvSearchNode.setC_id(Integer.parseInt(StringUtils.remove(results.get(0), "#node_")));
                                    btrvSearchResultNode = coreService.getNode(btrvSearchNode);
                                    coreService.removeNode(btrvSearchResultNode);
                                    storeStartDate = btrvSearchResultNode.getC_resultdate();
                                    //logger.info("실패한 노드를 가져와서 저장합니다. =" + storeStartDate);
                                    processFire(authToken, repository);
                                }
                                else
                                {
                                    //logger.info("실패한 내역이 없고 최초 실행이고 프로퍼티 설정값도 없어서 성공한 날짜부터 작업을 시작합니다");
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
                                        //logger.info("데이터베이스에서 가져온 가장 최근 날짜" + dbOrderDate);
                                        storeStartDate = dbOrderDate;
                                        processFire(authToken, repository);
                                    }
                                    else
                                    {
                                        //logger.info("최초 실행이지만, 데이터도 없고, 프로퍼티도 비어있는 경우엔 1년 뒤 부터 처리한다. ");
                                        storeStartDate = DateUtils.format("yyyy-MM-dd", DateUtils.getPreDate(DateUtils
                                                                                                             .getCurrentDay(), 365));
                                        processFire(authToken, repository);
                                    }
                                    
                                }
                            }
                            else
                            {
                                //logger.info("최초 실행이면서.");
                                //logger.info("프로퍼티에 설정된 값이 있습니다." + startDate);
                                storeStartDate = startDate;
                                processFire(authToken, repository);
                            }
                        }
                        else
                        {
                            //logger.info("이미 실행이 진행중인 상태임.");
                            processFire(authToken, repository);
                        }
                        
                    }
                    Date nowDate = DateUtils.getCurrentDay();
                    Date preDate = DateUtils.getPreDate(nowDate, 1);
                    Date compareStoreStartDate = DateUtils.getDate(storeStartDate);
                    if(preDate.compareTo(compareStoreStartDate) <= 0){
                        //logger.info("어제까지의 데이터가 수집되었음. 종료함.");
                    }else{
                        
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
                            BTRV_Result btrv_result = new BTRV_Result();
                            btrv_result.setRef(2);
                            btrv_result.setC_position(0);
                            btrv_result.setC_title("ahnlab");
                            btrv_result.setC_type("default");
                            btrv_result.setC_resultdate(storeStartDate);
                            btrv_result.setC_resultstring("done");
                            coreService.addNode(btrv_result);
                        }
                        Date storeTempDate = DateUtils.getDate(storeStartDate);
                        storeStartDate = DateUtils.format("yyyy-MM-dd", DateUtils.getNextDate(storeTempDate, 1));
                        //logger.info("작업 후 날짜를 증가시킵니다. " + storeStartDate);
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            logger.info("종료됨" + storeStartDate);
            this.execute();
        }
    }
    
    private void processFire(String authToken, Element repository) throws Exception
    {
        //logger.info("====>" + storeStartDate);
        
        
        Date nowDate = DateUtils.getCurrentDay();
        Date preDate = DateUtils.getPreDate(nowDate, 1);
        Date compareStoreStartDate = DateUtils.getDate(storeStartDate);
        if(preDate.compareTo(compareStoreStartDate) <= 0){
            //logger.info("어제까지의 데이터가 수집되었음. 종료함.");
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
                //logger.info("해당 데이터가 없으므로. 작업을 진행함." + storeStartDate);
                Date storeTempDate = DateUtils.getDate(storeStartDate);
                String fisheyeEndDate= DateUtils.format("yyyy-MM-dd", DateUtils.getNextDate(storeTempDate, 1));
                repositoryCheckOut(authToken, repository.getAttributeValue("name"), storeStartDate, fisheyeEndDate);
            }
            else
            {
                //logger.info("해당 데이터가 이미 있고 작업이 진행됬었음." + storeStartDate);
            }
        }
        
    }
    
    @Transactional(readOnly = false, rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
    private void repositoryCheckOut(String authToken, String repositoryName, String startDate, String endDate)
            throws Exception
    {
        //logger.info("auth token check : " + authToken);
        
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
        //logger.info(url);
        
        Element rootNode = getRootNodeFromUrl(url);
        if(rootNode.getName().equals("blank")){
            logger.error("500 error");
        }else{
            
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
                ArrayList<String> filterCheckRev = new ArrayList<String>();
                
                // head setting
                Element headingsNode = rootNode.getChild("headings");
                @SuppressWarnings("unchecked")
                List<Element> headList = headingsNode.getChildren("heading");
                
                for (Element rowNode : rowNodes)
                {
                    @SuppressWarnings("unchecked")
                    List<Element> itemList = rowNode.getChildren("item");
                    csvDataMap = new HashMap<String, Object>();
                    String tempRev = "";
                    
                    for (int i = 0; i < itemList.size(); i++)
                    {
                        csvDataMap.put("repositoryName", repositoryName);
                        
                        String heading = headList.get(i).getText();
                        Element itemText = itemList.get(i);
                        //logger.info(heading + " == " + itemText.getText());
                        
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
                            tempRev = revisionLowerText;
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
                            
                            if(checkLimitBTFormat(commentText)){            
                                csvDataMap = checkBT(commentText, csvDataMap);
                            }else{
                                csvDataMap.put("BT", "N/A");
                            }
                            if(checkLimitRVFormat(commentText)){            
                                csvDataMap = checkRV(commentText, csvDataMap);
                            }else{
                                csvDataMap.put("RV", "N/A");
                            }
                            
                            csvDataMap.put("SVNLOG", StringUtils.substring(commentText, 0, 254));
                            
                        }// if end
                    }// inner for end
                    
                    if(filterCheckRev.contains(tempRev)){
                        
                    }else{
                        filterCheckRev.add(tempRev);
                        csvDataList.add(csvDataMap);
                    }
                    
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
            }
        }
        
    }
    
    
    private Element getRootNodeFromUrl(String url)
    {
        try
        {
            SAXBuilder builder = new SAXBuilder();
            Document jdomdoc = builder.build(new URL(url));
            Element root = jdomdoc.getRootElement();
            return root;
        }
        catch (JDOMException | IOException e)
        {
            return new Element("blank");
        }
    }
    
    public static Boolean checkLimitBTFormat(String commentText){
        String lowerStr = commentText.toLowerCase();
        Pattern oldPatternObj = Pattern.compile("BT:", Pattern.CASE_INSENSITIVE);
        Matcher oldMatcherObj = oldPatternObj.matcher(lowerStr);
        Pattern newPatternObj = Pattern.compile("BT]", Pattern.CASE_INSENSITIVE);
        Matcher newMatcherObj = newPatternObj.matcher(lowerStr);
        
        if (oldMatcherObj.find() || newMatcherObj.find())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Boolean checkLimitRVFormat(String commentText){
        String lowerStr = commentText.toLowerCase();
        Pattern oldPatternObj = Pattern.compile("RV:", Pattern.CASE_INSENSITIVE);
        Matcher oldMatcherObj = oldPatternObj.matcher(lowerStr);
        Pattern newPatternObj = Pattern.compile("RV]", Pattern.CASE_INSENSITIVE);
        Matcher newMatcherObj = newPatternObj.matcher(lowerStr);
        
        if (oldMatcherObj.find() || newMatcherObj.find())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static Map<String, Object> checkBT(String commentText, Map<String, Object> csvDataMap)
    {
        //기존포맷
        //BT 포맷이 있는지.
        int checkPointOldBT = matchPointWithSoftCheck(commentText, "BT", "end");
        String filterOldBTstr = StringUtils.substring(commentText, checkPointOldBT);
        
        //BT가 있더라도 : 구분자가 있는지
        int checkPointOldBTDelimiter = matchPointWithSoftCheck(filterOldBTstr, ":", "start");
        int checkPointOldBTDelimiterreverseChecker = matchPointWithSoftCheck(filterOldBTstr, "]", "start");
        String filterOldBTDelimiterStr = "";
        if(checkPointOldBTDelimiter > checkPointOldBTDelimiterreverseChecker){
            //뒤집어진 상태
        }else{
            //정상인 상태.
            filterOldBTDelimiterStr = StringUtils.substring(filterOldBTstr, checkPointOldBTDelimiter);
        }
        System.out.println("returnStr = " + filterOldBTDelimiterStr);
        
        //BT와 구분자가 있더라도 잘 닫았는지.
        int checkPointOldBTDivid = matchPointWithSoftCheck(filterOldBTDelimiterStr, "]", "start");
        String filterDividOldBTStr = StringUtils.substring(filterOldBTDelimiterStr, 1, checkPointOldBTDivid-1);
        String filterTrimOldBTDividStr = filterDividOldBTStr.trim();
        System.out.println("patternDelimiterReturnStr = " + filterTrimOldBTDividStr);
        
        if(filterTrimOldBTDividStr.isEmpty()){
            //BT 포맷이 있는지.
            int checkPointBT = matchPointWithHardCheck(commentText, "BT]", "end");
            String filterBTstr = StringUtils.substring(commentText, checkPointBT);
            
            int checkPointBTDivid = matchPointWithHardCheck(ltrim(filterBTstr), " ", "end");
            
            String filterBTDividStr = StringUtils.substring(filterBTstr, 1, checkPointBTDivid);
            String filterBTTrimDividStr = filterBTDividStr.trim();
            
            int checkPointBTMarkDivid = matchPointWithSoftCheck(filterBTTrimDividStr, "RV]", "start");
            String filterBTMarkDividStr = "";
            String filterBTMarkTrimDividStr = "";
            if(filterBTTrimDividStr.length() == checkPointBTMarkDivid){
                filterBTMarkDividStr = StringUtils.substring(filterBTTrimDividStr, 0, checkPointBTMarkDivid);
                filterBTMarkTrimDividStr = filterBTMarkDividStr.trim();
            }else{
                filterBTMarkDividStr = StringUtils.substring(filterBTTrimDividStr, 0, checkPointBTMarkDivid-1);
                filterBTMarkTrimDividStr = filterBTMarkDividStr.trim();
            }
            
            //여러개의 이슈를 연결하였는지 하나만 했는지 
            //int checkPointMuiltiIssue = matchPointWithSoftCheck(filterBTMarkTrimDividStr, ",", "start");
            //String filterPointMuiltiIssuetr = StringUtils.substring(filterBTMarkTrimDividStr, 0, checkPointMuiltiIssue);
            //String filterPointMuiltiIssueTrimStr = filterPointMuiltiIssuetr.trim();
            
            //전위 이슈를 정규표현식으로 검증
            //if(regMatch("^[_0-9a-zA-Z-]+-[0-9]*$", filterPointMuiltiIssueTrimStr)){
            csvDataMap.put("BT", filterBTMarkTrimDividStr.toUpperCase());
            //}else{
            //    csvDataMap.put("BT", "N/A");
            //}
            
        }else{
            csvDataMap.put("BT", "N/A");
        }
        return csvDataMap;
    }

    public static Map<String, Object> checkRV(String commentText, Map<String, Object> csvDataMap)
    {
        //기존포맷인지 체크
        //RV 포맷이 있는지.
        int checkPointOldSpecRV = matchPointWithSoftCheck(commentText, "RV", "end");
        String filterOldRVstr = StringUtils.substring(commentText, checkPointOldSpecRV);
        
        //RV가 있더라도 : 구분자가 있는지
        int checkPointOldRVDelimiter = matchPointWithSoftCheck(filterOldRVstr, ":", "start");
        String filterOldRVDelimiterStr = StringUtils.substring(filterOldRVstr, checkPointOldRVDelimiter);
        System.out.println("returnStr = " + filterOldRVDelimiterStr);
        
        //RV와 구분자가 있더라도 잘 닫았는지.
        int checkPointOldRVDivid = matchPointWithSoftCheck(filterOldRVDelimiterStr, "]", "start");
        String filterOldRVDividStr = StringUtils.substring(filterOldRVDelimiterStr, 1, checkPointOldRVDivid);
        String filterOldRVTrimDividStr = filterOldRVDividStr.trim();
        System.out.println("patternDelimiterReturnStr = " + filterOldRVTrimDividStr);
        
        if(filterOldRVDelimiterStr.isEmpty()){
            //RV 포맷이 있는지.
            int checkPointRV = matchPointWithHardCheck(commentText, "RV]", "end");
            String filterRVstr = StringUtils.substring(commentText, checkPointRV);
            
            //RV의 기록 데이터를 가져온다.
            String filterRVDividStr = "";
            String filterRVTrimDividStr = "";

            int checkPointRVMarkDivid = matchPointWithSoftCheck(ltrim(filterRVstr), " ", "start");
            
            if(ltrim(filterRVstr).length() == checkPointRVMarkDivid){
                filterRVDividStr = StringUtils.substring(filterRVstr, 1, filterRVstr.length());
                filterRVTrimDividStr = filterRVDividStr.trim();
            }else if(matchPointWithOnlyCheck(filterRVstr, "N/A") || matchPointWithOnlyCheck(filterRVstr, "NA")){
                filterRVTrimDividStr = "N/A";
            }else{
                int checkPointRVDivid = matchPointWithHardCheck(ltrim(filterRVstr), " ", "end");
                filterRVDividStr = StringUtils.substring(filterRVstr, 1, checkPointRVDivid);
                filterRVTrimDividStr = filterRVDividStr.trim();
            }
            
            if(StringUtils.lowerCase(filterRVTrimDividStr).equals("na") || StringUtils.lowerCase(filterRVTrimDividStr).equals("n/a")){
                csvDataMap.put("RV", "N/A");
            }
            else if(filterRVTrimDividStr.isEmpty()){
                csvDataMap.put("RV", "N/A");;
            }else{
                csvDataMap.put("RV", filterRVTrimDividStr);
            }
        }else{
            csvDataMap.put("RV", "N/A");
        }
        return csvDataMap;
    }
    
    public static boolean regMatch(String regEx, String filterPointMuiltiIssueTrimStr)
    {
        if(Pattern.matches(regEx, filterPointMuiltiIssueTrimStr)){
            return true;
        }else{
            return false;
        }
    }

    public static int matchPointWithHardCheck(String originStr, String checkStr, String matchPoint)
    {
        String lowerStr = originStr.toLowerCase();
        Pattern patternObj = Pattern.compile(checkStr, Pattern.CASE_INSENSITIVE);
        Matcher matcherObj = patternObj.matcher(lowerStr);
        int checkPointValue = 0;
        if (matcherObj.find())
        {
            checkPointValue = (matchPoint.equals("end"))?matcherObj.end():matcherObj.start();
        }else{
            throw new RuntimeException();
        }
        return checkPointValue;
    }
    
    public static int matchPointWithSoftCheck(String originStr, String checkStr, String matchPoint)
    {
        String lowerStr = originStr.toLowerCase();
        Pattern patternObj = Pattern.compile(checkStr, Pattern.CASE_INSENSITIVE);
        Matcher matcherObj = patternObj.matcher(lowerStr);
        int checkPointValue = 0;
        if (matcherObj.find())
        {
            //muilti issue
            checkPointValue = (matchPoint.equals("end"))?matcherObj.end():matcherObj.start();
        }else{
            //single issue
            checkPointValue = lowerStr.length();
        }
        return checkPointValue;
    }
    public static boolean matchPointWithOnlyCheck(String originStr, String checkStr)
    {
        String lowerStr = originStr.toLowerCase();
        Pattern patternObj = Pattern.compile(checkStr, Pattern.CASE_INSENSITIVE);
        Matcher matcherObj = patternObj.matcher(lowerStr);
        if (matcherObj.find())
        {
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * 
     * @param s
     * @return
     */
    public static String ltrim(String s) 
    {
            char[] val = s.toCharArray();           
            int st  = 0;
            int len = s.length();
            while (st < len && val[st] <= ' ') 
            {
                    st++;
            }
            return s.substring(st, len);
    }
}
