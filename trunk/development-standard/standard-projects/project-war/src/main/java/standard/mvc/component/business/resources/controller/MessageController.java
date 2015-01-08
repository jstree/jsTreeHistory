package standard.mvc.component.business.resources.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

import egovframework.com.ext.jstree.support.manager.messageSource.CustomReloadableResourceBundleMessageSource;
import egovframework.com.ext.jstree.support.manager.messageSource.MessageSupport;

@Controller
@RequestMapping(value = { "/bundle" })
public class MessageController {
    
    @Autowired
    private MessageSupport messageSupport;
    
    /**
     * 다국어 처리용 파일.
     */
    @RequestMapping(value = "/string.js")
    public String message(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        Locale locale = (Locale) WebUtils.getSessionAttribute(request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        if(null == locale){
            locale = Locale.KOREAN;
        }
        CustomReloadableResourceBundleMessageSource bundle = (CustomReloadableResourceBundleMessageSource) messageSupport.getMessageSource();
        
        modelMap.addAttribute("datas", bundle.getAllMessages(locale));
        
        response.setContentType("text/javascript; charset=UTF-8");
        return "/bundle/string";
    }
}