package standard.mvc.component.business.widget.rss.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import standard.mvc.component.base.controller.GenericAbstractController;
import standard.mvc.component.base.controller.GenericInterfaceController;
import standard.mvc.component.base.dao.hibernate.SearchSupport;

@Controller
@RequestMapping(value = { "**/community" })
public class RssController  extends GenericAbstractController implements GenericInterfaceController<Object>{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static String url = null;

	@RequestMapping(value = { "/component/business/widget/rss/bloter.do" }, method = { RequestMethod.GET, RequestMethod.POST }, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String BloterRssReader() throws IllegalArgumentException, FeedException, IOException {
		
		url = "http://feeds.feedburner.com/bloter";
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
        
        StringBuffer returnHtmlData = new StringBuffer();
        returnHtmlData.append("<ul>");
        /*발행정보*/
        //for(int i=0, j=entries.size(); i<j ; i++) {
        for(int i=0; i<5; i++){
            entry = entries.get(i);
            logger.debug("### getTitle   [" + entry.getTitle() +"]");
            logger.debug("### getUri    [" + entry.getUri() +"]");
            logger.debug("### getDescription  [" + stripTags(entry.getDescription().getValue()) +"]");
            //logger.debug("### getPublishedDate[" + entry.getPublishedDate().getTime() +"]");
            //logger.debug("### getContents[" + entry.getContents());
            logger.debug("========================================{==========");
            
            returnHtmlData.append("<li><a href=\"" + entry.getUri()+ "\"  target=\"_blank\" ");
            returnHtmlData.append("onclick=\"window.open(this.href,'popupName', 'width=800,height=900'); ");
            returnHtmlData.append("return false;\" onkeypress=\"this.oncilck()\"> " + entry.getTitle() + " </a></li>"); 
        }        
        returnHtmlData.append("</ul>");
		return returnHtmlData.toString();
	}
	
	@RequestMapping(value = { "/component/business/widget/rss/zdnet.do" }, method = { RequestMethod.GET, RequestMethod.POST }, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String ZdnetRssReader() throws IllegalArgumentException, FeedException, IOException {
		
		url = "http://zdnetkorea.feedsportal.com/c/34249/f/622755/index.rss";
		URL feedUrl = new URL(url);
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed syndFeed;
		syndFeed = input.build(new XmlReader(feedUrl));
		
        List<SyndEntry> entries = syndFeed.getEntries();        
        SyndEntry entry = null;
        
        StringBuffer returnHtmlData = new StringBuffer();
        returnHtmlData.append("<ul>");
        /*발행정보*/
        //for(int i=0, j=entries.size(); i<j ; i++) {
        for(int i=0; i<5; i++){
            entry = entries.get(i);
            logger.debug("### getTitle   [" + entry.getTitle() +"]");
            logger.debug("### getUri    [" + entry.getUri() +"]");
            logger.debug("### getDescription  [" + stripTags(entry.getDescription().getValue()) +"]");
            //logger.debug("### getPublishedDate[" + entry.getPublishedDate().getTime() +"]");
            //logger.debug("### getContents[" + entry.getContents());
            logger.debug("========================================{==========");
            
            returnHtmlData.append("<li><a href=\"" + entry.getUri()+ "\"  target=\"_blank\" ");
            returnHtmlData.append("onclick=\"window.open(this.href,'popupName', 'width=800,height=900'); ");
            returnHtmlData.append("return false;\" onkeypress=\"this.oncilck()\"> " + entry.getTitle() + " </a></li>");
        }        
        returnHtmlData.append("</ul>");
		return returnHtmlData.toString();
	}
	
	@RequestMapping(value = { "/component/business/widget/rss/google.do" }, method = { RequestMethod.GET, RequestMethod.POST }, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String FaceBookRssReader() throws IllegalArgumentException, FeedException, IOException {
		
		url = "http://www.inews24.com/rss/rss_computing.xml";
		URL feedUrl = new URL(url);
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed syndFeed;
		syndFeed = input.build(new XmlReader(feedUrl));
		
        List<SyndEntry> entries = syndFeed.getEntries();        
        SyndEntry entry = null;
        
        StringBuffer returnHtmlData = new StringBuffer();
        returnHtmlData.append("<ul>");
        /*발행정보*/
        //for(int i=0, j=entries.size(); i<j ; i++) {
        for(int i=0; i<5; i++){
            entry = entries.get(i);
            logger.debug("### getTitle   [" + entry.getTitle() +"]");
            logger.debug("### getLink    [" + entry.getUri() +"]");
            logger.debug("### getDescription  [" + stripTags(entry.getDescription().getValue()) +"]");
            //logger.debug("### getPublishedDate[" + entry.getPublishedDate().getTime() +"]");
            //logger.debug("### getContents[" + entry.getContents());
            logger.debug("========================================{==========");
            
            returnHtmlData.append("<li><a href=\"" + entry.getUri()+ "\"  target=\"_blank\" ");
            returnHtmlData.append("onclick=\"window.open(this.href,'popupName', 'width=800,height=900'); ");
            returnHtmlData.append("return false;\" onkeypress=\"this.oncilck()\"> " + entry.getTitle() + " </a></li>");
        }        
        returnHtmlData.append("</ul>");
		System.out.println(returnHtmlData.toString());
        return returnHtmlData.toString();
	}
	

	public static String stripTags(String text) {
		if (text != null) {
			return text.replaceAll("\\<.*?>","").trim();
		} else {
			return "";
		}
	}
	
	
	@Override
	public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String invokeInsert(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String invokeUpdate(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String invokeDelete(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
}