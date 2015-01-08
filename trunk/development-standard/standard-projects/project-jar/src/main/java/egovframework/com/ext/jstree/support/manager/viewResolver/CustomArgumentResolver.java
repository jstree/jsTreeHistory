package egovframework.com.ext.jstree.support.manager.viewResolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CustomArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public Object resolveArgument(MethodParameter arg0, ModelAndViewContainer arg1, NativeWebRequest arg2, WebDataBinderFactory arg3) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean supportsParameter(MethodParameter arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    
}
