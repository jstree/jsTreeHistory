package egovframework.com.ext.jstree.support.manager.viewResolver.specialPurposeView;


import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class CloseDialogView extends AbstractView {
    
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (null == model) {
            response.sendRedirect("/");
            return;
        }
        
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
        out.println("	parent.document.location.reload();");
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }
    
}
