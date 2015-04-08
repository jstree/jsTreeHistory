package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.zip.GZIPInputStream;

import javax.servlet.http.Cookie;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;

public class SvnDataImporter implements Job
{
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public void execute(JobExecutionContext arg0) throws JobExecutionException
    {
        
        String url = "http://www.313.co.kr/fecru/rest-service-fe/search-v1/queryAsRows/standardSvn";
        String query = "?query=";
        query += "select revisions where date in [ 2014-12-10, 2014-12-12 ] "; 
        query += "return path , dir , revision , author , date , comment , csid , isBinary , totalLines , ";
        query += "linesAdded , linesRemoved , isAdded , isDeleted , isCopied , isMoved , tags , reviews";
        try
        {
            
            SyndFeed syndFeed = getSyndFeedForUrl(url + query);
            System.out.println("RSS title: " + syndFeed.getTitle());
            System.out.println("RSS author: " + syndFeed.getAuthor());

            @SuppressWarnings("rawtypes")
            List entries = syndFeed.getEntries();
            for (int i = 0; i < entries.size(); i++) {
                SyndEntry entry = (SyndEntry) entries.get(i);
                System.out.println("--- Entry " + i);
                System.out.println(entry.getTitle());
                System.out.println(entry.getAuthor());
                System.out.println(entry.getDescription().getValue());
                System.out.println(entry.getLink());
            }
        }
        catch (IllegalArgumentException | IOException | FeedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public SyndFeed getSyndFeedForUrl(String url) throws MalformedURLException, IOException, IllegalArgumentException,
            FeedException
    {
        
        SyndFeed feed = null;
        InputStream is = null;
        
        try
        {
            URLConnection openConnection = new URL(url).openConnection();
            openConnection.setRequestProperty("Cookie","FEAUTH=admin:1:9368d6e5998c5f2019f1c08085fe7a0c6c53df6c");
            openConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded; charset=utf-8");
            openConnection.setDoOutput(true);
            openConnection.setUseCaches(false);
            is = openConnection.getInputStream();
            if ("gzip".equals(openConnection.getContentEncoding()))
            {
                is = new GZIPInputStream(is);
            }
            InputSource source = new InputSource(is);
            SyndFeedInput input = new SyndFeedInput();
            feed = input.build(source);
            
        }
        catch (Exception e)
        {
            logger.error("Exception occured when building the feed object out of the url", e);
        }
        finally
        {
            if (is != null) is.close();
        }
        
        return feed;
    }
    
    public SyndFeed getSyndFeedFromLocalFile(String filePath) throws MalformedURLException, IOException,
            IllegalArgumentException, FeedException
    {
        
        SyndFeed feed = null;
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(filePath);
            InputSource source = new InputSource(fis);
            SyndFeedInput input = new SyndFeedInput();
            feed = input.build(source);
        }
        finally
        {
            fis.close();
        }
        
        return feed;
    }
    
}