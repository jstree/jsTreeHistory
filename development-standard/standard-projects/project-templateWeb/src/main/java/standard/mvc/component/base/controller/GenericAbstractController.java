package standard.mvc.component.base.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springmodules.validation.commons.DefaultBeanValidator;

import standard.mvc.component.base.dao.hibernate.SearchSupport;
import standard.mvc.component.manager.messageSource.MessageSupport;
import standard.mvc.component.util.Paginator;
import standard.mvc.component.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class GenericAbstractController {

	@Autowired
	private MessageSupport messageSupport;
	@Autowired
	private DefaultBeanValidator defaultBeanValidator;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public <T> T invokeBeanValidate(T clazz, BindingResult bindingResult) {
		defaultBeanValidator.validate(clazz, bindingResult);
		if (bindingResult.hasErrors()) { // 만일 validation 에러가 있으면...
			logger.error(clazz.getClass() + " validate error");
			return clazz;
		}
		return clazz;
	}

	public abstract Map<String, Map<String, Object>> bindTypes();

	protected void viewForAdd(ModelMap modelMap, Object obj,
			HttpServletRequest request) {
		viewForAdd(modelMap, obj, "add", request);
	}

	protected void viewForEdit(ModelMap modelMap, Object obj,
			HttpServletRequest request) {
		viewForAdd(modelMap, obj, "edit", request);
	}

	protected void viewForSetting(ModelMap modelMap, Object obj,
			HttpServletRequest request) {
		viewForAdd(modelMap, obj, "setting", request);
	}

	protected void viewForList(ModelMap modelMap, String id, int total,
			List<?> lists, SearchSupport searchSupport,
			List<String> hiddenColumns, Class<?> clazz,
			HttpServletRequest request) {

		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls()
				.create();
		modelMap.addAttribute("total", total);
		modelMap.addAttribute("list", lists);
		modelMap.addAttribute("listId", id);

		modelMap.addAttribute("mode", "list");
		modelMap.addAttribute("hiddenColumns", hiddenColumns);
		Paginator paginator = new Paginator(searchSupport.getPageSize(),
				searchSupport.getPageNo(), total);
		modelMap.addAttribute("paginator", paginator);

		modelMap.addAllAttributes(bindTypes());

	}

	/**
	 * 일반적인 CLI에서는 사용되지 않는 케이스를 잡음.
	 */
	protected void viewForList(ModelMap modelMap, String id, int total,
			List<?> lists, SearchSupport searchSupport,
			List<String> hiddenColumns) {
		modelMap.addAttribute("total", total);
		modelMap.addAttribute("list", lists);
		modelMap.addAttribute("listId", id);

		modelMap.addAttribute("mode", "list");
		modelMap.addAttribute("hiddenColumns", hiddenColumns);
		Paginator paginator = new Paginator(searchSupport.getPageSize(),
				searchSupport.getPageNo(), total);
		modelMap.addAttribute("paginator", paginator);

		modelMap.addAllAttributes(bindTypes());

	}

	/**
	 * devices 가 null 인 경우 아래 처리를 하지 않음.
	 */
	protected void viewForAdd(ModelMap modelMap, Object obj, String mode,
			HttpServletRequest request) {
		modelMap.addAttribute("obj", obj);
		modelMap.addAttribute("mode", mode);

		modelMap.addAllAttributes(bindTypes());
	}

	protected void viewForCsv(ModelMap modelMap, List<?> lists, String fileName) {
		modelMap.addAttribute("fileName", fileName);
		modelMap.addAttribute("list", lists);
	}

	// @ExceptionHandler(Exception.class)
	// public void CliException(Exception ex, HttpServletResponse response,
	// HttpServletRequest request) throws IOException {
	//
	// response.setHeader("Expires", "-1");
	// response.setHeader("Cache-Control",
	// "must-revalidate, no-store, no-cache");
	// response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	// response.setHeader("Pragma", "no-cache");
	//
	// response.setContentType("text/html; charset=utf-8");
	// PrintWriter out = response.getWriter();
	//
	// out.println("<!DOCTYPE html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head><body>");
	// out.println("<script type=\"text/javascript\" src=\"/ajaxpm/string.js\"></script>");
	// out.println("<script type=\"text/javascript\" src=\"/files/js/jquery.js\"></script>");
	// out.println("<script type=\"text/javascript\" src=\"/files/js/jquery-ui.min.js\"></script>");
	// out.println("<script type=\"text/javascript\" src=\"/files/js/jquery.sprintf.js\"></script>");
	// out.println("<script type=\"text/javascript\" src=\"/files/js/underscore.js\"></script>");
	// out.println("<script type=\"text/javascript\">");
	//
	// out.println("parent.tmWaringCloseDialog(getMessage(\"" + ex.getMessage()
	// + "\"))");
	//
	// out.println("</script></body></html>");
	// }

	@ExceptionHandler(Exception.class)
	public void cliValidationException(Exception ex,
			HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control",
				"must-revalidate, no-store, no-cache");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");

		PrintWriter out = response.getWriter();

		if (StringUtils.equals(request.getHeader("tgCustomHeader"), "ajax")) {
			response.setContentType("application/json; charset=UTF-8");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", false);
			// map.put("message", messageSupport.getMessage(ex.getMessage(),
			// ex.getArgs(), "", request));

			Gson gson = new GsonBuilder().serializeNulls().create();
			out.println(gson.toJson(map));
			out.flush();
			out.close();
			return;
		} else {
			response.setContentType("text/html; charset=utf-8");

			out.println("<!DOCTYPE html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head><body>");
			out.println("<script type=\"text/javascript\" src=\"/ajaxpm/string.js\"></script>");
			out.println("<script type=\"text/javascript\" src=\"/files/js/jquery.js\"></script>");
			out.println("<script type=\"text/javascript\" src=\"/files/js/jquery.sprintf.js\"></script>");
			out.println("<script type=\"text/javascript\" src=\"/files/js/underscore.js\"></script>");
			out.println("<script type=\"text/javascript\">");

			// if(null != ex.getArgs()){
			// String message = messageSupport.getMessage(ex.getMessage(),
			// ex.getArgs(), ex.getMessage(), request);
			// out.println("parent.tgWarning(\"" + message + "\")");
			// out.println("</script></body></html>");
			// }else{
			// out.println("parent.tgWarning(getMessage(\"" + ex.getMessage() +
			// "\"))");
			// out.println("</script></body></html>");
			// }
		}

	}

	@ExceptionHandler(RuntimeException.class)
	public void cliClientException(RuntimeException ex,
			HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control",
				"must-revalidate, no-store, no-cache");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head><body>");
		out.println("<script type=\"text/javascript\" src=\"/ajaxpm/string.js\"></script>");
		out.println("<script type=\"text/javascript\" src=\"/files/js/jquery.js\"></script>");
		out.println("<script type=\"text/javascript\" src=\"/files/js/jquery.sprintf.js\"></script>");
		out.println("<script type=\"text/javascript\" src=\"/files/js/underscore.js\"></script>");
		out.println("<script type=\"text/javascript\">");
		out.println("alert('fail system command : "
				+ StringUtils.remove(ex.getMessage(), "'") + "');");

		out.println("</script></body></html>");
		// ModelAndView mnv = new ModelAndView("exceptionHandler");
		// mnv.addObject("data", e.getMessage());
		//
		// return mnv;
	}

}
