package standard.mvc.manager.viewResolver.specialPurposeView;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.NoSuchMessageException;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.AbstractView;
import org.springframework.web.util.WebUtils;

public class UploadMaxErrorView extends AbstractView {
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String code = "ALERT_FILEUPLOAD_SIZE_EXCEED";
        
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
        out.println("parent.tgAlert('"+ getMessage(code, "", locale)+ "', function() {parent.modalUnBlock()});");
        
        out.println("</script></body></html>");
     }
    
    private String getMessage(String code, String defaultMessage, Locale locale) {
        try {
            return getApplicationContext().getMessage(code, null, defaultMessage, locale);
        } catch (NoSuchMessageException e) {
            return code;
        }
    }
    
}
