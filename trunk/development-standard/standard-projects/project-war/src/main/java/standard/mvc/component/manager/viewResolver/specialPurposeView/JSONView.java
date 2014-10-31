package standard.mvc.component.manager.viewResolver.specialPurposeView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.NoSuchMessageException;
import org.springframework.web.servlet.view.AbstractView;


import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (null == model) {
            throw new IOException();
        }
        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        
        PrintWriter out = response.getWriter();
        
        Object chartValue = model.get("chartValue");
        if (null != chartValue && chartValue instanceof String) {
            out.println(chartValue);
            out.flush();
            return;
        }
        
        Object value = model.get("result");
        
        // boolean type 인 경우
        if (value instanceof Boolean) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("result", value);
            
            if (null != model.get("code")) {
            	String code = (String) model.get("code");
            	String message = getMessage(code);
            	map.put("message", message);
            }
            
            Gson gson = new GsonBuilder().serializeNulls().create();
            out.println(gson.toJson(map));
            out.flush();
            return;
        }
        
        value = model.get("value");
        
        if (value instanceof String) {
            value = getMessage(value.toString());
        }
        
        
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
			
            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return ( clazz.getAnnotation(GsonExclude.class) != null );
            }

            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getAnnotation(GsonExclude.class) != null;
            }
            
		}).setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").serializeNulls().create();
        out.println(gson.toJson(value));
        out.flush();
    }
    
    private String getMessage(String code) {
        try {
            return getApplicationContext().getMessage(code, null, Locale.KOREAN);
        } catch (NoSuchMessageException e) {
            return code;
        }
    }
    
}
