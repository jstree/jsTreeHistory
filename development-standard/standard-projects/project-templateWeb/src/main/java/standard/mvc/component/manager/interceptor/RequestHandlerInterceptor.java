package standard.mvc.component.manager.interceptor;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import standard.mvc.util.DateUtils;
import standard.mvc.util.StringUtils;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;

public class RequestHandlerInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private Properties configFile;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
    	logger.debug("{} start {}", new Object[]{"============================================", this.getClass().getName()});
		
    	Method[] methods = HttpServletRequest.class.getMethods();
		
		for (Method method : methods) {

			String methodName = method.getName();
			String returnType = method.getReturnType().getName();
			Class<?>[] parameterType = method.getParameterTypes();

			if (!"void".equals(returnType) && 0 == parameterType.length) {

				try {
					
					logger.debug("{} {} : {}", new Object[]{"success", methodName, method.invoke(request).toString()});
					
				} catch (Exception e) {
					
					logger.debug("{} {} : {}", new Object[]{"fail", methodName, e.getMessage()});
					
				}
								
			}
		
		}
		
		logger.debug("{} end {}", new Object[]{"============================================", this.getClass().getName()});
		
		return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
        if (null == modelAndView) {
            return;
        }
        
        View view = modelAndView.getView();
        String viewName = modelAndView.getViewName();
        if (view instanceof org.springframework.web.servlet.view.RedirectView || (null != viewName && viewName.startsWith("redirect:")) || (null != viewName && viewName.equals(":move")) || (null != viewName && viewName.equals(":exit"))) {
            return;
        }
        
        URL url = new URL(request.getRequestURL().toString());
        String depths = url.getPath();
        
        String hostUrl = url.getProtocol() + "://" + url.getHost();
        
        BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
        TemplateHashModel staticModel = wrapper.getStaticModels();
        modelAndView.addObject("StringEscapeUtils", staticModel.get("org.apache.commons.lang.StringEscapeUtils"));
        
        // 잡다한 값들
        Date now = new Date();
        modelAndView.addObject("hostUrl", hostUrl);
        modelAndView.addObject("prevWeek", DateUtils.addWeeks(now, -1));
        modelAndView.addObject("yesterday", DateUtils.addDays(now, -1));
        modelAndView.addObject("today", now);
        modelAndView.addObject("tommorow", DateUtils.addDays(now, 1));
        modelAndView.addObject("nextWeek", DateUtils.addWeeks(now, 1));
        modelAndView.addObject("nextMonth", DateUtils.addMonths(now, 1));
        
        //modelAndView.addObject("imageHost", configFile.get("imageHost"));
        modelAndView.addObject("queryString", request.getQueryString());
        
        // 장비의 기본정보들 넣어줌
        modelAndView.addObject("platform", "");
        modelAndView.addObject("language", "KOREAN");
        modelAndView.addObject("applyCount", "");
        
        // 로그인인경우 하위메뉴 불필요.
        if (StringUtils.isEmpty(depths) || StringUtils.equals(depths, "/") 
                || StringUtils.startsWith(depths, "/login") || StringUtils.startsWith(depths, "/login") || StringUtils.startsWith(depths, "/ajax") || StringUtils.startsWith(depths, "/bundle") 
                || StringUtils.startsWith(depths, "/rest") || StringUtils.startsWith(depths, "/rest") || StringUtils.startsWith(depths, "/error") || StringUtils.startsWith(depths, "/pm/error")
                || StringUtils.startsWith(depths, "/data")) {
            return;
        }
        
        // URL 패턴 => /policy/TG/그룹번호 or 장비번호/system/admin/user
        //String[] depthArray = StringUtils.split(depths, "/");   //[policy, VTN, 1573605, 1, separateNetworkProfile, manageNetwork, exception]
      
//        String depth0 = new StringBuilder().append(depthArray[0]).append("/").append(depthArray[1]).append("/").append(depthArray[2]).append("/").append(depthArray[3]).toString();
//        String depthFirst = depthArray[0];
//        String depthMiddle = new StringBuilder().append(depthArray[1]).append("/").append(depthArray[2]).append("/").append(depthArray[3]).toString();
//        String depth1 = "";
//        String depth2 = "";
//        String depth3 = "";
//        String depth4 = "";
//        String deviceType = depthArray[1];
//        
//        if (depthArray.length > 4) {
//            depth1 = depthArray[4];
//        }
//        
//        if (depthArray.length > 5) {
//            depth2 = depthArray[5];
//        }
//        
//        if (depthArray.length > 6) {
//            depth3 = depthArray[6];
//        }
//        
//        if (depthArray.length > 7) {
//            depth4 = depthArray[7];
//        }
        
        
        // url parser
//        modelAndView.addObject("depthFirst", depthFirst); // policy
//        modelAndView.addObject("depthMiddle", depthMiddle); // VTN/G1/0
//        modelAndView.addObject("depths", depths);
//        modelAndView.addObject("depth0", depth0); // policy/VTN/G1/0
//        modelAndView.addObject("depth1", depth1);
//        modelAndView.addObject("depth2", depth2);
//        modelAndView.addObject("depth3", depth3);
//        modelAndView.addObject("depth4", depth4);
//        modelAndView.addObject("deviceType", deviceType); // VTN
//        modelAndView.addObject("currentUrl", url.getFile());
    }
}
