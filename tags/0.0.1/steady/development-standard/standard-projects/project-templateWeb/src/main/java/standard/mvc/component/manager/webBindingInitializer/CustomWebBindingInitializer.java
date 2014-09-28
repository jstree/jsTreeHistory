package standard.mvc.component.manager.webBindingInitializer;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class CustomWebBindingInitializer implements WebBindingInitializer {
     
    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor(true));
        
        binder.registerCustomEditor(Integer.TYPE, new CustomNumberEditor(Integer.class, true) {
            public void setValue(Object obj) {
                super.setValue(obj == null ? -1 : obj);
            }
        });
        
        binder.registerCustomEditor(Long.TYPE, new CustomNumberEditor(Long.class, true) {
            public void setValue(Object obj) {
                super.setValue(obj == null ? -1 : obj);
            }
        });
    }
    
}
