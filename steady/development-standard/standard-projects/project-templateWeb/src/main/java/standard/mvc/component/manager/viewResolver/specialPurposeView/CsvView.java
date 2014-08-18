package standard.mvc.component.manager.viewResolver.specialPurposeView;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.AbstractView;
import org.springframework.web.util.WebUtils;

import standard.mvc.component.util.DateUtils;


public class CsvView extends AbstractView {
    
    private static final String CSV_UTF8_HEADER = "\ufeff";
    
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (null == model) {
            throw new IOException();
        }
        
        boolean isImportExport = false;
        
        Object isImportExportTemp = model.get("importExport");
        if (null != isImportExportTemp) {
        	isImportExport = true;
        }
        
        String fileName = (String) model.get("fileName");
        Locale locale = (Locale) WebUtils.getSessionAttribute(request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        if (null == locale) {
            locale = Locale.KOREAN;
        }
        String now = DateUtils.dateTimeToString(new Date());
        
        // 다운로드 헤더 적용.
        response.setHeader("Content-Type", "text/csv; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + "_" + now + ".csv;");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");
        response.setCharacterEncoding("utf-8");
        
        PrintWriter out = response.getWriter();
        out.write(CSV_UTF8_HEADER);
        
        if (isImportExport) {
        	Appendable csvString = (Appendable) model.get("csvString");
        	out.write(csvString.toString());
        } else {
        	@SuppressWarnings("unchecked")
            List<CsvViewForLog> list = (List<CsvViewForLog>) model.get("list");
        	if (list.size() < 1) {
                return;
            }
        	
        	out.write(list.get(0).getHeader(getApplicationContext(), locale));
            out.write("\n");
            
            for (CsvViewForLog csvViewForLog : list) {
                out.write(csvViewForLog.getCsvData(getApplicationContext(), locale));
                out.write("\n");
            }
        }
        
        out.flush();
        out.close();
    }
}
