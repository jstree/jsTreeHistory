package standard.mvc.component.manager.viewResolver.specialPurposeView;


import java.util.Locale;

import org.springframework.context.ApplicationContext;

/**
 * view 에서 csv로 export 할때 사용한다.
 * 
 * @author kimseokwon 2011. 7. 28.
 * 
 */
public interface CsvViewForLog {
    /**
     * 
     * @return header1, header2
     */
    public String getHeader(ApplicationContext context, Locale locale);
    
    /**
     * 
     * @return value1, value2
     */
    public String getCsvData(ApplicationContext context, Locale locale);
}
