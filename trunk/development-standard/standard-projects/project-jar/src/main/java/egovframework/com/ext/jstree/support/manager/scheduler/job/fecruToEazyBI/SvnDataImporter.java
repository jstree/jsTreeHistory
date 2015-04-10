package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SvnDataImporter implements Job
{
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public void execute(JobExecutionContext arg0) throws JobExecutionException
    {
        
        try
        {
            String authUrlAddr = "http://www.313.co.kr/fecru/rest-service/auth-v1/login?userName=admin&password=love0618";
            Element authRootNode = getRootNodeFromUrl(authUrlAddr);
            Element authRootChildNode =authRootNode.getChild("token");
            String authToken = authRootChildNode.getText();
            if(authToken.isEmpty()){
                logger.error("Fisheye error thorw : not auth");
            }else{
                //repository list getter;
                //repositoryCheckOut(authToken);
                logger.info("auth token check : " + authToken);
                String queryUrl = "http://www.313.co.kr/fecru/rest-service-fe/repositories-v1";
                String query = "?FEAUTH=" + authToken;
                String url = queryUrl + query;
                logger.info(url);
                
                Element root = getRootNodeFromUrl(url);
                @SuppressWarnings("unchecked")
                List<Element> repositorys =root.getChildren("repository");
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void repositoryCheckOut(String authToken, String repositoryName) throws UnsupportedEncodingException, JDOMException, IOException,
            MalformedURLException
    {
        logger.info("auth token check : " + authToken);
        
        String queryUrl = "http://www.313.co.kr/fecru/rest-service-fe/search-v1/queryAsRows/" + repositoryName;
        String query = "?query=";
        query += URLEncoder.encode("select revisions where date in [ 2014-12-10, 2014-12-12 ] ", "UTF-8");
        query += URLEncoder.encode("return path , dir , revision , author , date , comment , csid , isBinary , totalLines , ", "UTF-8");
        query += URLEncoder.encode("linesAdded , linesRemoved , isAdded , isDeleted , isCopied , isMoved , tags , reviews", "UTF-8");
        query += "&FEAUTH=" + authToken;
        String url = queryUrl + query;
        logger.info(url);
        
        Element rootNode = getRootNodeFromUrl(url);
        
        
        @SuppressWarnings("unchecked")
        List<Element> rowNodes =rootNode.getChildren("row");
        if(null ==rowNodes){
            logger.error("no search data !");
        }
        else{
            Element headingsNode = rootNode.getChild("headings");
            @SuppressWarnings("unchecked")
            List<Element> headList = headingsNode.getChildren("heading");
            for (Element rowNode : rowNodes)
            {
                @SuppressWarnings("unchecked")
                List<Element> itemList=rowNode.getChildren("item");
                for(int i=0;i<itemList.size(); i++){
                    String heading = headList.get(i).getText();
                    if(heading.equals("comment")){
                        
                    }
                    Element person_E=itemList.get(i);
                    logger.info(heading + " == " + person_E.getText());
                }
            }
        }
    }

    private Element getRootNodeFromUrl(String url) throws JDOMException, IOException, MalformedURLException
    {
        SAXBuilder builder = new SAXBuilder(); 
        Document jdomdoc = builder.build(new URL(url));
        Element root= jdomdoc.getRootElement();
        return root;
    }
}