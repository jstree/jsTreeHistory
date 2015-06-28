package egovframework.com.ext.jstree.support.manager.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.ext.jstree.support.manager.mvc.dao.hibernate.SearchSupport;
import egovframework.com.ext.jstree.support.util.StringUtils;

public abstract class GenericAbstractController
{
    
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    @Autowired
    private DefaultBeanValidator defaultBeanValidator;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public <T> T invokeBeanValidate(T clazz, BindingResult bindingResult)
    {
        defaultBeanValidator.validate(clazz, bindingResult);
        if (bindingResult.hasErrors())
        { // 만일 validation 에러가 있으면...
            logger.error(clazz.getClass() + " validate error");
            return clazz;
        }
        return clazz;
    }
    
    public abstract Map<String, Map<String, Object>> bindTypes();
    
    protected String getView(SearchSupport searchSupport, ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response,
            BindingResult bindingResult, Object parameterBean)
    {
        invokeBeanValidate(parameterBean, bindingResult);
        modelMap.addAllAttributes(bindTypes());
        
        String viewResolver = (String) request.getAttribute("viewResolver");
        String siteCode = (String) request.getAttribute("siteCode");
        String largeMenu = (String) request.getAttribute("largeMenu");
        String middleMenu = (String) request.getAttribute("middleMenu");
        String smallMenu = (String) request.getAttribute("smallMenu");
        String componentCode = (String) request.getAttribute("componentCode");
        String action = (String) request.getAttribute("actionTarget");
        
        String menuCodes = "";
        if (null != largeMenu && !largeMenu.equals("largeMenu"))
        {
            menuCodes = menuCodes + largeMenu + "/";
        }
        if (null != middleMenu && !middleMenu.equals("middleMenu"))
        {
            menuCodes = menuCodes + middleMenu + "/";
        }
        if (null != smallMenu && !smallMenu.equals("smallMenu"))
        {
            menuCodes = menuCodes + smallMenu + "/";
        }
        
        // templateEngine not use external view url.
        return "/" + viewResolver + "/" + siteCode + "/" + menuCodes
                + componentCode + "/" + action;
    }
    
    @ExceptionHandler(Exception.class)
    public void defenceException(Exception ex, HttpServletResponse response,
            HttpServletRequest request) throws IOException
    {
        if (logger.isDebugEnabled()) {
            ex.printStackTrace();
        }
        
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control",
                           "must-revalidate, no-store, no-cache");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        
        PrintWriter out = response.getWriter();
        
        if (StringUtils.equals(request.getHeader("customHeader"), "ajax"))
        {
            response.setContentType("application/json; charset=UTF-8");
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("result", false);
            map.put("message",
                    egovMessageSource.getMessage(ex.getMessage(),
                                              ex.getStackTrace(), "", request));
            
            Gson gson = new GsonBuilder().serializeNulls().create();
            out.println(gson.toJson(map));
            out.flush();
            out.close();
            return;
        }
        else
        {
            response.setContentType("text/html; charset=utf-8");
            
            out.println("<!DOCTYPE html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head><body>");
            out.println("<script type=\"text/javascript\" src=\"/ajaxpm/string.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"/files/js/jquery.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"/files/js/jquery.sprintf.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"/files/js/underscore.js\"></script>");
            out.println("<script type=\"text/javascript\">");
            
            if (null != ex.getStackTrace())
            {
                String message = egovMessageSource.getMessage(ex.getMessage(),
                                                           ex.getStackTrace(),
                                                           ex.getMessage(),
                                                           request);
                out.println("parent.warning(\"" + message + "\")");
                out.println("</script></body></html>");
            }
            else
            {
                out.println("parent.warning(getMessage(\"" + ex.getMessage()
                        + "\"))");
                out.println("</script></body></html>");
            }
        }
        
    }
    
    @ExceptionHandler(RuntimeException.class)
    public void defenceRuntimeException(RuntimeException ex,
            HttpServletResponse response, HttpServletRequest request)
            throws IOException
    {
        if (logger.isDebugEnabled()) {
            ex.printStackTrace();
        }
        
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control",
                           "must-revalidate, no-store, no-cache");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        
        PrintWriter out = response.getWriter();
        
        if (StringUtils.equals(request.getHeader("customHeader"), "ajax")) {
            
            response.setContentType("application/json; charset=UTF-8");
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("result", false);
            map.put("message",
                    egovMessageSource.getMessage(ex.getMessage(),
                                              ex.getStackTrace(), "", request));
            
            Gson gson = new GsonBuilder().serializeNulls().create();
            out.println(gson.toJson(map));
            out.flush();
            out.close();
            return;
        }
        else {
            response.setContentType("text/html; charset=utf-8");
            
            out.println("<!DOCTYPE html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head><body>");
            out.println("<script type=\"text/javascript\" src=\"/ajaxpm/string.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"/files/js/jquery.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"/files/js/jquery.sprintf.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"/files/js/underscore.js\"></script>");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('fail system command : "
                    + StringUtils.remove(ex.getMessage(), "'") + "');");
            
            out.println("</script></body></html>");
        }
    }
    
}
