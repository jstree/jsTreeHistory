package standard.mvc.component.business.widget.rss.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

@Controller
public class RssController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/RssController",  method=RequestMethod.POST)
	public String RssReader(@RequestParam String url, Map<String, Object> model) throws IllegalArgumentException, FeedException, IOException {
	
		URL feedUrl = new URL(url);
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed syndFeed;
		syndFeed = input.build(new XmlReader(feedUrl));
		/*RSS 헤더 정보*/
		/*
        logger.debug("### getFeedType  [" + syndFeed.getFeedType() +"]");
        logger.debug("### getLanguage  [" + syndFeed.getLanguage() +"]");
        logger.debug("### getTitle   [" + syndFeed.getTitle() +"]");
        logger.debug("### getPublishedDate  [" + syndFeed.getPublishedDate() +"]");
		*/
		
        List<SyndEntry> entries = syndFeed.getEntries();        
        SyndEntry entry = null;
        
        /*발행정보*/
        for(int i=0, j=entries.size(); i<j ; i++) {
            entry = entries.get(i);
            logger.debug("### getTitle   [" + entry.getTitle() +"]");
            logger.debug("### getUri    [" + entry.getUri() +"]");
            logger.debug("### getDescription  [" + stripTags(entry.getDescription().getValue()) +"]");
            //logger.debug("### getPublishedDate[" + entry.getPublishedDate().getTime() +"]");
            //logger.debug("### getContents[" + entry.getContents());
            logger.debug("==================================================");
            
            Map<String, String> xmlMap = new HashMap<String, String>();
            xmlMap.put("Title", entry.getTitle());
            xmlMap.put("Uri", entry.getUri());
            xmlMap.put("Description", entry.getDescription().getValue());
            
            model.put("xmlMap", xmlMap);
            
            /*카테고리*/
            StringBuffer cate = new StringBuffer();
            if(entry.getCategories()!=null && entry.getCategories().size()>0){
            	for(int ii=0,jj=entry.getCategories().size(); ii<jj; ii++){
            		SyndCategoryImpl ss = (SyndCategoryImpl)(entry.getCategories().get(ii));
            		cate.append(ss.getName().replace(" ", "")).append(",");
            	}
            }
            logger.debug("### category  [" + cate.toString() +"]");
        }        
        	
		return "/test";
	}
	
	public static String stripTags(String text) {
		if (text != null) {
			return text.replaceAll("\\<.*?>","").trim();
		} else {
			return "";
		}
	}
}
