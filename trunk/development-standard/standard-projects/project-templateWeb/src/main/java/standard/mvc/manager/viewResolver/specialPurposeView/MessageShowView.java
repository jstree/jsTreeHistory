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

public class MessageShowView extends AbstractView {
    
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
        
        String code = (String) model.get("code");
        String messageText = (String) model.get("message");
        Object defaultMessageObject = model.get("defaultMessage");
        
        String defaultMessage = "";
        if (null != defaultMessageObject) {
            defaultMessage = (String) defaultMessageObject;
        }
        
        Object[] args = (Object[]) model.get("args");
        
        // 웹 브라우저가 페이지 내용을 캐시하지 못하게 HTTP Header를 세팅한다.
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "must-revalidate, no-store, no-cache");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<script type=\"text/javascript\">");
        
        out.println("function end(url, message, isPopUp) {");
        out.println("   if(message != '') alert(message);");
        
        out.println("   if(url != '') {");
        out.println("       if(opener && isPopUp == '1') {");
        out.println("           opener.window.location.href = url;");
        out.println("           window.close();");
        out.println("       } else {");
        out.println("           window.location.href = url;");
        out.println("       }");
        out.println("   } else {");
        out.println("       if(isPopUp == '1') window.close();");
        out.println("       history.go(-1);");
        out.println("   }");
        out.println("}");
        
        // 값 넣어주기
        String url = "";
        String message = "";
        String isPopUp = "";
        
        if (model.containsKey("returnUrl")) {
            url = (String) model.get("returnUrl");
        }
        
        if (null != messageText) {
            message = messageText;
        }
        
        if (null != code) {
            if (null == args) {
                message = getMessage(code, defaultMessage, locale).replaceAll("\n", "\\\\n");
            } else {
                message = getMessage(code, args, defaultMessage, locale).replaceAll("\n", "\\\\n");
            }
        }
        
        if (model.containsKey("popupClose")) {
            isPopUp = "1";
        }
        
        out.println("end('" + url + "', '" + message + "', '" + isPopUp + "');");
        
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
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
