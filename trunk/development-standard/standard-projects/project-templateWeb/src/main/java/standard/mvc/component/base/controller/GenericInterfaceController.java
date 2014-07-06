package standard.mvc.component.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import standard.mvc.component.base.dao.hibernate.SearchSupport;

public interface GenericInterfaceController<T> {

	
	public String invokeSelect(@RequestAttribute("searchSupport") SearchSupport searchSupport, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult, T parameterBean);
	public String invokeInsert(@RequestAttribute("searchSupport") SearchSupport searchSupport, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult, T parameterBean);
	public String invokeUpdate(@RequestAttribute("searchSupport") SearchSupport searchSupport, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult, T parameterBean);
	public String invokeDelete(@RequestAttribute("searchSupport") SearchSupport searchSupport, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult, T parameterBean);
}
