package egovframework.com.ext.jstree.support.manager.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import egovframework.com.ext.jstree.support.manager.mvc.dao.hibernate.SearchSupport;

public interface GenericInterfaceController<T> {

	public String invokeSelect(
			@RequestAttribute("searchSupport") SearchSupport searchSupport,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult,
			T parameterBean);

	public String invokeInsert(
			@RequestAttribute("searchSupport") SearchSupport searchSupport,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult,
			T parameterBean);

	public String invokeUpdate(
			@RequestAttribute("searchSupport") SearchSupport searchSupport,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult,
			T parameterBean);

	public String invokeDelete(
			@RequestAttribute("searchSupport") SearchSupport searchSupport,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult,
			T parameterBean);
}