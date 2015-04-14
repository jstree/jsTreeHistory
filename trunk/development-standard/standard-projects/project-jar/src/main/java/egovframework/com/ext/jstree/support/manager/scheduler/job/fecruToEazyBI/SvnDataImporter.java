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
import java.util.Locale;
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
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVWriter;

@Component
public class SvnDataImporter
{
private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource(name="messageSource")
    ReloadableResourceBundleMessageSource messageSource;
    
    @Scheduled(cron = "0 * * * * *")
    public void execute()
    {
        try
        {
            String getMsg = messageSource.getMessage("ahnlab.fisheye.baseurl" , null , Locale.getDefault() );
            String authUrlAddr = getMsg + "/rest-service/auth-v1/login?userName=admin&password=love0618";
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
                String queryUrl = "http://www.313.co.kr/fecru/rest-service-fe/repositories-v1";
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
        
        String queryUrl = "http://www.313.co.kr/fecru/rest-service-fe/search-v1/queryAsRows/" + repositoryName;
        String query = "?query=";
        query += URLEncoder.encode("select revisions where date in [ 2014-12-10, 2014-12-12 ] ", "UTF-8");
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
            //csv export setting
            Map<String, Object> csvDataMap = null;
            HashSet<Map<String, Object>> csvDataList = new HashSet<Map<String, Object>>();

            //head setting
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
                        String commentLowerText = commentText.toLowerCase();
                        
                        Pattern patternBT = Pattern.compile("BT", Pattern.CASE_INSENSITIVE);
                        Matcher matcherBT = patternBT.matcher(commentLowerText);
                        if (matcherBT.find())
                        {
                            logger.info("이슈 번호");
                            csvDataMap.put("BT", "존재함");
                        }
                        else
                        {
                            logger.info("이슈 번호가 없음.");
                            csvDataMap.put("BT", "N/A");
                        }
                        
                        Pattern patternRV = Pattern.compile("RV", Pattern.CASE_INSENSITIVE);
                        Matcher matcherRV = patternRV.matcher(commentLowerText);
                        if (matcherRV.find())
                        {
                            logger.info("리뷰 여부");
                            csvDataMap.put("RV", "리뷰함");
                        }
                        else
                        {
                            logger.info("리뷰 여부가 없음.");
                            csvDataMap.put("RV", "N/A");
                        }
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
                CSVWriter cw = new CSVWriter(new OutputStreamWriter(new FileOutputStream("C:\\Temp\\test.csv"),
                        "EUC-KR"), ',', '"');
                try
                {
                    for (Map<String, Object> m : csvDataList)
                    {
                        // 배열을 이용하여 row를 CSVWriter 객체에 write
                        cw.writeNext(new String[] { String.valueOf(m.get("repositoryName")), String.valueOf(m.get("revision")), String.valueOf(m.get("author"))
                                , String.valueOf(m.get("date")), String.valueOf(m.get("BT")), String.valueOf(m.get("RV"))});
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    // 무조건 CSVWriter 객체 close
                    cw.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    private Element getRootNodeFromUrl(String url) throws JDOMException, IOException, MalformedURLException
    {
        SAXBuilder builder = new SAXBuilder();
        Document jdomdoc = builder.build(new URL(url));
        Element root = jdomdoc.getRootElement();
        return root;
    }
}