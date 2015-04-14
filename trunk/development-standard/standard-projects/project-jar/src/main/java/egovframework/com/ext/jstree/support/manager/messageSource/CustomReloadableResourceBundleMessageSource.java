package egovframework.com.ext.jstree.support.manager.messageSource;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

@Service
public class CustomReloadableResourceBundleMessageSource extends ReloadableResourceBundleMessageSource {
	
    public Map<String, Object> getAllMessages(Locale locale) {
        Map<String, Object> data = new HashMap<String, Object>();
        
        PropertiesHolder propertiesHolder = getMergedProperties(locale);
        Properties properties = propertiesHolder.getProperties();
        
        for (Entry<Object, Object> entry : properties.entrySet()) {
            data.put((String) entry.getKey(), entry.getValue());
        }
        return data;
    }
    
    public String getMessage(String code)
    {
        Locale locale = Locale.KOREAN;
        return getMessage(code, null, "", locale);
    }
    
}
