/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package standard.mvc.component.dwr.sample.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import standard.mvc.component.base.controller.GenericAbstractController;
import standard.mvc.component.base.controller.GenericInterfaceController;
import standard.mvc.component.base.dao.hibernate.SearchSupport;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2014.08.01
 * @version 1.0
 * @see <pre>
 * Class Name 	: AjaxController.java
 * Description 	: DWR Ajax 샘플 컨트롤러 클래스
 *  
 * << 개정이력(Modification Information) >>
 *  
 * 수정일         수정자             수정내용
 * -------      ------------   -----------------------
 * 2014.08.01   류강하         최초 생성
 * 
 * Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = "/none/jsp/dwr")
public class AjaxController extends GenericAbstractController implements GenericInterfaceController<Object> 
{
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() 
	{
		return null;
	}
	
	@Override
	@RequestMapping(value = "/sample/ajax/smallMenu/index/invokeSelect.do", 
	                method = RequestMethod.GET)
	public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap,
							   HttpServletRequest request, HttpServletResponse response,
							   BindingResult bindingResult, Object parameterBean) 
	{
		String viewResolver = "/jsp";
		String siteCode = "/dwr";
		String menuCodes = "/sample/ajax";
		String componentCode = "/index";
		String targetPage = "/index";
		
		return viewResolver + siteCode + menuCodes + componentCode + targetPage;
	}

	@Override
	public String invokeInsert(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String invokeUpdate(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String invokeDelete(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}