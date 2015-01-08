package standard.mvc.component.manager.viewResolver.specialPurposeView;

import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.NoSuchMessageException;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.AbstractView;
import org.springframework.web.util.WebUtils;

import egovframework.com.ext.jstree.support.util.StringUtils;


public class ExitView extends AbstractView {
    
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (null == model) {
            response.sendRedirect("/");
            return;
        }
        
        Locale locale = (Locale) WebUtils.getSessionAttribute(request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        if (null == locale) {
            locale = Locale.KOREAN;
        }
        
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "must-revalidate, no-store, no-cache");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head><body><script type=\"text/javascript\">");
        
        String url = (String) model.get("url");
        String type = (String) model.get("type");
        Object obj = model.get("code");
        Object[] args = (Object[]) model.get("args");
        
        String code = "";
        if (null != obj) {
            code = (String) model.get("code");
        }
        
        switch (type) {
        case "alert":
            out.println("alert('" + getMessage(code, "", locale) + "');");
            break;
        
        case "iframeAlert":
            if (null == args) {
                out.println("parent.tgWarning('" + getMessage(code, "", locale) + "');");
            } else {
                out.println("parent.tgWarning('" + getMessage(code, args, "", locale) + "');");
            }
            break;
        
        case "alertString":
            out.println("alert('" + code + "');");
            break;
            
        case "confirmIframe":
            
            if (!StringUtils.isEmpty(code)) {
                out.println("parent.tgConfirm('" + getMessage(code, "", locale) + "', {}, function() {parent.location.href = '" + url + "'}, function() {parent.modalUnBlock()});");
            } else {
                out.println("parent.location.href = '" + url + "'");
            }
            break;
        
        case "moveForIframe":
            
            if (!StringUtils.isEmpty(code)) {
                out.println("parent.tgWarning('" + getMessage(code, "", locale) + "', function() {parent.location.href = '" + url + "'});");
            } else {
                out.println("parent.location.href = '" + url + "'");
            }
            break;
            
        case "moveForIframeOpener":
            
            if (!StringUtils.isEmpty(code)) {
                out.println("parent.opener.tgWarning('" + getMessage(code, "", locale) + "', function() {parent.opener.location.href = '" + url + "'}););");
                out.println("parent.window.close();");
            } else {
                out.println("parent.opener.location.href = '" + url + "';");
                out.println("parent.window.close();");
            }
            break;
        
        case "actionOk":
            String actionType = (String) model.get("actionType");
            String actionKey = (String) model.get("actionKey");
            Object actionKeyObject = model.get("actionKey");
            
            if (!StringUtils.isEmpty(actionKey)) {
                if (actionKeyObject instanceof Long) {
                    actionKey = String.valueOf(actionKeyObject);
                } else if (actionKeyObject instanceof String) {
                    actionKey = actionKeyObject.toString();
                }
            } else {
            	actionKey = "";
            }
            
            out.println("parent.submitComplete('" + actionType + "', false, '" + actionKey + "');");
            break;
            
        case "customScript":
            String scriptName = (String) model.get("scriptName");
            out.println("parent." + scriptName + ";");
            break;
            
        case "reloadForIframeOpener":
            if (!StringUtils.isEmpty(code)) {
                out.println("parent.opener.tgAlert('"+ getMessage(code, "", locale)+"');");
            }
            out.println("parent.opener.location.reload()");
            break;  
            
        case "reloadForOpener":
            if (!StringUtils.isEmpty(code)) {
                out.println("parent.opener.tgWarning('" + getMessage(code, "", locale) + "', function() { parent.opener.location.reload(); }););");
                out.println("parent.window.close();");
            } else {
                out.println("parent.opener.location.reload();");
                out.println("parent.window.close();");
            }
            break;  
            
        case "reloadForIframe": 
            if (!StringUtils.isEmpty(code)) {
                if (null == args) {
                    out.println("parent.tgWarning('" + getMessage(code, "", locale) + "', function() {parent.location.reload(); });");
                } else {
                    out.println("parent.tgWarning('" + getMessage(code, args, "", locale) + "', function() {parent.location.reload(); });");
                }
            } else {
            	out.println("parent.location.href = '" + request.getHeader("Referer") +"'");
            }
            break;
            
        case "reloadForIframeLayer": 
            if (!StringUtils.isEmpty(code)) {
            	out.println("parent.parent.tgWarning('"+ getMessage(code, "", locale) + "', function() {parent.parent.location.reload(); });");
            } else {
            	out.println("parent.parent.location.reload()");
            }
            break;
            
            
        case "reload":
            if (!StringUtils.isEmpty(code)) {
                out.println("alert('"+ getMessage(code, "", locale)+"');");
            }
            out.println("location.href = '" + request.getHeader("Referer") +"'");
            break;
            
        case "deleteProfileForIframe":
            if (!StringUtils.isEmpty(code)) {
                out.println("parent.tgAlert('"+ getMessage(code, "", locale)+"');");
            }
            
            String preUrl = request.getHeader("Referer");
            String[] opernerUrlArray = preUrl.split("/");
            opernerUrlArray[6] = String.valueOf(1);
            String moveUrl = StringUtils.join(opernerUrlArray, "/");
            
            out.println("parent.location.href = '" + moveUrl +"'");
            break;
            
        case "importOk":
        	int errorCount = (Integer) model.get("errorCount");
        	@SuppressWarnings("unchecked")
			List<Integer> errorLines =  (List<Integer>) model.get("errorLines");
            out.println("parent.parent.importCompleteTM(" + errorCount + ", \"" + errorLines.toString() + "\");");
            break;
        
        default:
            break;
        }
        
        out.println("</script></body></html>");
        
    }
    
    private String getMessage(String code, String defaultMessage, Locale locale) {
        try {
            return getApplicationContext().getMessage(code, null, defaultMessage, locale);
        } catch (NoSuchMessageException e) {
            return code;
        }
    }
    
    private String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        try {
            return getApplicationContext().getMessage(code, args, defaultMessage, locale);
        } catch (NoSuchMessageException e) {
            return code;
        }
    }
}
