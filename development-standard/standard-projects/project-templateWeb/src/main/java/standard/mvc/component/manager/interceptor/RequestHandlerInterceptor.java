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

public class RequestHandlerInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private Properties configFile;

	// set private localVariable
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		setLogging(request, true);
		ParameterParser parameterParser = setUrlVariable(request,
				new ModelAndView(), true);
		setSearchSupport(request, parameterParser);

		return true;
	}

	/**
	 * @param request
	 * @return
	 * @throws MalformedURLException
	 * @see <pre>
	 * 	depths => 풀URL
	 * 	depth0 => 템플릿엔진 선택 ex) /sitemesh , /tiles , /none
	 * 	depth1 => 사이트명 ( 하나의 컨텍스트에서도 여러사이트를 운용가능 )
	 * 	depth2 => Spring,Struts 등 서블릿 컨텍스트 해당 URL
	 * 	depth3 => Mybatis, Hibernate 등 ORAM 해당 URL
	 * 	depth4 => 대메뉴
	 * 	depth5 => 중메뉴 ( 리퀘스트 맵핑에서 대/중/소 ) 구분하여 처리할것.
	 * 	depth6 => 소메뉴
	 * 	depth7 => 게시판번호 혹은 액션대상.
	 * 	depth8 => 액션처리(select,update,delete,insert)
	 * </pre>
	 */
	private ParameterParser setUrlVariable(HttpServletRequest request,
			ModelAndView modelAndView, Boolean checkPreHandle)
			throws MalformedURLException {

		ParameterParser parameterParser = new ParameterParser(request);
		URL url = new URL(request.getRequestURL().toString());
		String hostUrl = url.getProtocol() + "://" + url.getHost();
		String depths = url.getPath();
		String[] depthArray = StringUtils.split(depths, "/");

		String contextRootPath = request.getContextPath();
		String depth0 = new StringBuilder().append(depthArray[0]).toString();
		String depth1 = new StringBuilder().append(depthArray[1]).toString();
		String depth2 = new StringBuilder().append(depthArray[2]).toString();
		String depth3 = new StringBuilder().append(depthArray[3]).toString();
		String depth4 = new StringBuilder().append(depthArray[4]).toString();
		String depth5 = new StringBuilder().append(depthArray[5]).toString();
		String depth6 = new StringBuilder().append(depthArray[6]).toString();
		String depth7 = new StringBuilder().append(depthArray[7]).toString();
		String depth8 = new StringBuilder().append(depthArray[8]).toString();

		if (checkPreHandle) {
			request.setAttribute("hostUrl", hostUrl);
			request.setAttribute("contextRootPath", contextRootPath);
			request.setAttribute("depth0", depth0);
			request.setAttribute("depth1", depth1);
			request.setAttribute("depth2", depth2);
			request.setAttribute("depth3", depth3);
			request.setAttribute("depth4", depth4);
			request.setAttribute("depth5", depth5);
			request.setAttribute("depth6", depth6);
			request.setAttribute("depth7", depth7);
			request.setAttribute("depth8", depth8);
		} else {
			modelAndView.addObject("hostUrl", hostUrl);
			modelAndView.addObject("contextRootPath", contextRootPath);
			modelAndView.addObject("depth0", depth0);
			modelAndView.addObject("depth1", depth1);
			modelAndView.addObject("depth2", depth2);
			modelAndView.addObject("depth3", depth3);
			modelAndView.addObject("depth4", depth4);
			modelAndView.addObject("depth5", depth5);
			modelAndView.addObject("depth6", depth6);
			modelAndView.addObject("depth7", depth7);
			modelAndView.addObject("depth8", depth8);
		}
		return parameterParser;
	}

	/**
	 * @param request
	 */
	private void setLogging(HttpServletRequest request, Boolean checkPreHandle) {
		if (checkPreHandle) {
			logger.info("{} preHandle start {}", new Object[] {
					"========================", this.getClass().getName() });
		} else {
			logger.info("{} postHandle start {}", new Object[] {
					"========================", this.getClass().getName() });
		}
		Method[] methods = HttpServletRequest.class.getMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			String returnType = method.getReturnType().getName();
			Class<?>[] parameterType = method.getParameterTypes();
			if (!"void".equals(returnType) && 0 == parameterType.length) {
				try {
					logger.debug("{} {} : {}", new Object[] { "success",
							methodName, method.invoke(request).toString() });
				} catch (Exception e) {
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
	private void setSearchSupport(HttpServletRequest request,
			ParameterParser parameterParser) {

		SearchSupport searchSupport = SearchSupport.getInstance();
		searchSupport.setPageNo(parameterParser.getInt("page", 1));
		searchSupport.setPageSize(parameterParser.getInt("rows", 50));

		if (StringUtils.isEmpty(parameterParser.get("order"))) {
			searchSupport.setOrder(Order.desc("c_id"));
		} else {
			searchSupport.setOrder(Order.desc(parameterParser.get("order")));
		}
		request.setAttribute("searchSupport", searchSupport);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		setLogging(request, true);

		if (null == modelAndView) {
			return;
		}
		View view = modelAndView.getView();
		String viewName = modelAndView.getViewName();
		if (view instanceof org.springframework.web.servlet.view.RedirectView
				|| (null != viewName && viewName.startsWith("redirect:"))
				|| (null != viewName && viewName.equals(":move"))
				|| (null != viewName && viewName.equals(":exit"))) {
			return;
		}

		setUrlVariable(request, new ModelAndView(), true);

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
		TemplateHashModel staticModel = wrapper.getStaticModels();
		modelAndView.addObject("StringEscapeUtils",
				staticModel.get("org.apache.commons.lang.StringEscapeUtils"));

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

	}

}
