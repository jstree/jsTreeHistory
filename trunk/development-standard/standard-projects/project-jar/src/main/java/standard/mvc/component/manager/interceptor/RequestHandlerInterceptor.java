package standard.mvc.component.manager.interceptor;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import standard.mvc.component.base.dao.hibernate.SearchSupport;
import standard.mvc.component.util.DateUtils;
import standard.mvc.component.util.ParameterParser;
import standard.mvc.component.util.StringUtils;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;

public class RequestHandlerInterceptor extends HandlerInterceptorAdapter
{
    
    @Autowired
    private Properties configFile;
    
    // set private localVariable
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception
    {
        //setLogging(request, true);
        //setUrlVariable(request, new ModelAndView(), true);
        //setSearchSupport(request);
        return true;
    }
    
    /**
     * @param request
     * @return
     * @throws MalformedURLException
     * @see <pre>
     * requestUrl => 풀URL
     * contextPath => ContextPath
     * templateEngine => 템플릿엔진 선택 ex) /sitemesh , /tiles , /none
     * viewResolver => ViewResolver 선택 ex) /freemarker , /jsp , /velocity
     * siteCode => 사이트명 ( 하나의 컨텍스트에서도 여러사이트를 운용가능 )
     * largeMenu => 대메뉴
     * middleMenu => 중메뉴 ( 리퀘스트 맵핑에서 대/중/소 ) 구분하여 처리할것.
     * smallMenu => 소메뉴
     * componentCode => 컴포넌트, 게시판번호 혹은 액션대상.
     * actionTarget => 액션처리(select,update,delete,insert)
     * </pre>
     */
    private void setUrlVariable(HttpServletRequest request,
            ModelAndView modelAndView, Boolean checkPreHandle)
            throws MalformedURLException
    {
        URL url = new URL(request.getRequestURL().toString());
        String hostUrl = url.getProtocol() + "://" + url.getHost();
        String requestUrl = url.getPath();
        String[] urlArray = StringUtils.split(requestUrl, "/");
        
        String contextRootPath = request.getContextPath();
        String contextPath = new StringBuilder().append(urlArray[0]).toString();
        String templateEngine = "";
        String viewResolver = "";
        String siteCode = "";
        String largeMenu = "";
        String middleMenu = "";
        String smallMenu = "";
        String componentCode = "";
        String actionTarget = "";
        if (contextRootPath.replaceFirst("/", "").equals(contextPath))
        {
            // contextPath를 사용하는 경우임.
            templateEngine = new StringBuilder().append(urlArray[1]).toString();
            if(templateEngine.equals("egovframework")){
                return;
            }
            viewResolver = new StringBuilder().append(urlArray[2]).toString();
            siteCode = new StringBuilder().append(urlArray[3]).toString();
            largeMenu = new StringBuilder().append(urlArray[4]).toString();
            middleMenu = new StringBuilder().append(urlArray[5]).toString();
            smallMenu = new StringBuilder().append(urlArray[6]).toString();
            componentCode = new StringBuilder().append(urlArray[7]).toString();
            actionTarget = new StringBuilder().append(urlArray[8].replace(".do", "")).toString();
        }
        else
        {
            // rootContext를 사용하는 경우임.
            contextPath = contextRootPath;
            templateEngine = new StringBuilder().append(urlArray[0]).toString();
            if(templateEngine.equals("egovframework")){
                return;
            }
            viewResolver = new StringBuilder().append(urlArray[1]).toString();
            siteCode = new StringBuilder().append(urlArray[2]).toString();
            largeMenu = new StringBuilder().append(urlArray[3]).toString();
            middleMenu = new StringBuilder().append(urlArray[4]).toString();
            smallMenu = new StringBuilder().append(urlArray[5]).toString();
            componentCode = new StringBuilder().append(urlArray[6]).toString();
            actionTarget = new StringBuilder().append(urlArray[7]).toString();
        }
        
        if (checkPreHandle)
        {
            request.setAttribute("hostUrl", hostUrl);
            request.setAttribute("contextRootPath", contextRootPath);
            request.setAttribute("contextPath", contextPath);
            request.setAttribute("templateEngine", templateEngine);
            request.setAttribute("viewResolver", viewResolver);
            request.setAttribute("siteCode", siteCode);
            request.setAttribute("largeMenu", largeMenu);
            request.setAttribute("middleMenu", middleMenu);
            request.setAttribute("smallMenu", smallMenu);
            request.setAttribute("componentCode", componentCode);
            request.setAttribute("actionTarget", actionTarget);
        }
        else
        {
            modelAndView.addObject("hostUrl", hostUrl);
            modelAndView.addObject("contextRootPath", contextRootPath);
            modelAndView.addObject("contextPath", contextPath);
            modelAndView.addObject("templateEngine", templateEngine);
            modelAndView.addObject("viewResolver", viewResolver);
            modelAndView.addObject("siteCode", siteCode);
            modelAndView.addObject("largeMenu", largeMenu);
            modelAndView.addObject("middleMenu", middleMenu);
            modelAndView.addObject("smallMenu", smallMenu);
            modelAndView.addObject("componentCode", componentCode);
            modelAndView.addObject("actionTarget", actionTarget);
        }
    }
    
    /**
     * @param request
     */
    private void setLogging(HttpServletRequest request, Boolean checkPreHandle)
    {
        if (checkPreHandle)
        {
            logger.info("{} preHandle start {}", new Object[] {
                    "========================", this.getClass().getName() });
        }
        else
        {
            logger.info("{} postHandle start {}", new Object[] {
                    "========================", this.getClass().getName() });
        }
        Method[] methods = HttpServletRequest.class.getMethods();
        for (Method method : methods)
        {
            String methodName = method.getName();
            String returnType = method.getReturnType().getName();
            Class<?>[] parameterType = method.getParameterTypes();
            if (!"void".equals(returnType) && 0 == parameterType.length)
            {
                try
                {
                    logger.debug("{} {} : {}", new Object[] { "success",
                            methodName, method.invoke(request).toString() });
                }
                catch (Exception e)
                {
                    logger.debug("{} {} : {}", new Object[] { "fail",
                            methodName, e.getMessage() });
                }
            }
        }
    }
    
    /**
     * @param request
     * @param parameterParser
     */
    private void setSearchSupport(HttpServletRequest request)
    {
        ParameterParser parameterParser = new ParameterParser(request);
        SearchSupport searchSupport = SearchSupport.getInstance();
        searchSupport.setPageNo(parameterParser.getInt("page", 1));
        searchSupport.setPageSize(parameterParser.getInt("rows", 50));
        
        if (StringUtils.isEmpty(parameterParser.get("order")))
        {
            searchSupport.setOrder(Order.desc("c_id"));
        }
        else
        {
            searchSupport.setOrder(Order.desc(parameterParser.get("order")));
        }
        request.setAttribute("searchSupport", searchSupport);
    }
    
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception
    {
        /*
        setLogging(request, true);
        
        if (null == modelAndView) { return; }
        View view = modelAndView.getView();
        String viewName = modelAndView.getViewName();
        if (view instanceof org.springframework.web.servlet.view.RedirectView
                || (null != viewName && viewName.startsWith("redirect:"))
                || (null != viewName && viewName.equals(":move"))
                || (null != viewName && viewName.equals(":exit"))) { return; }
        
        setUrlVariable(request, new ModelAndView(), true);
        
        BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
        TemplateHashModel staticModel = wrapper.getStaticModels();
        modelAndView.addObject("StringEscapeUtils", staticModel
                .get("org.apache.commons.lang.StringEscapeUtils"));
        
        // 잡다한 값들
        Date now = new Date();
        modelAndView.addObject("prevWeek", DateUtils.addWeeks(now, -1));
        modelAndView.addObject("yesterday", DateUtils.addDays(now, -1));
        modelAndView.addObject("today", now);
        modelAndView.addObject("tommorow", DateUtils.addDays(now, 1));
        modelAndView.addObject("nextWeek", DateUtils.addWeeks(now, 1));
        modelAndView.addObject("nextMonth", DateUtils.addMonths(now, 1));
        modelAndView.addObject("queryString", request.getQueryString());
        modelAndView.addObject("language", LocaleContextHolder.getLocale());
        */
        
    }
    
}
