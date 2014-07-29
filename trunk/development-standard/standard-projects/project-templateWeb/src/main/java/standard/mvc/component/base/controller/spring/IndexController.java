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
package standard.mvc.component.base.controller.spring;

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
 * @author Dongmin.Lee
 * @since 2014.06.18
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: TemplateMethodResolveViewSupporter.java
 * 	Description 	: WEBDAV를 활용하여 뷰 리졸버와의 결합을 통한 디자인과 개발을 
 * 					: 완전하게 분리하는 목적의 클래스
 * 	Infomation	: 
 * 	요청 URL 형태 > /sitemesh /community 
 * 					> /defaultMenuBig/defaultMenuMiddle/defaultMenuSmall 
 *  				> /index /action.do
 * 	depths => 풀URL ( 특이케이스 ) 규칙에서 어긋난
 * 	depth0 => 템플릿엔진 선택 ex) /sitemesh , /tiles , /none
 * 	depth1 => 사이트명 ( 하나의 컨텍스트에서도 여러사이트를 운용가능 )->contextPath
 * 	depth2 => Spring,Struts 등 서블릿 컨텍스트 해당 URL
 * 	depth3 => Mybatis, Hibernate 등 ORAM 해당 URL
 * 	depth4 => 대메뉴
 * 	depth5 => 중메뉴 ( 리퀘스트 맵핑에서 대/중/소 ) 구분하여 처리할것.
 * 	depth6 => 소메뉴
 * 	depth7 => 게시판번호 혹은 액션대상.
 * 	depth8 => 액션처리(select,update,delete,insert)
 * 
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.06.18    Dongmin.Lee      최초 생성
 * 
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = { "**/community" })
public class IndexController extends GenericAbstractController implements
		GenericInterfaceController<Object> {

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		return null;
	}

	/**
	 * indexPage 요청을 처리한다.
	 * 
	 * @param SearchSupport
	 * @param ModelMap
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @param BindingResult
	 * @param Object
	 * @return String ViewResolver에 넘겨주는 URL String 객체
	 * @exception none
	 */
	@Override
	@RequestMapping(
			value = { "/largeMenu/middleMenu/smallMenu/index/invokeSelect.do" },
			method = { RequestMethod.GET, RequestMethod.POST })
	public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {

		String viewResolver = "/jsp";
		String siteCode = "/community";
		String menuCodes = "";
		String componentCode = "/index";
		String targetPage = "/index";
		// templateEngine not use external view url.
		return viewResolver + siteCode + menuCodes + componentCode + targetPage;

	}

	@Override
	public String invokeInsert(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String invokeUpdate(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String invokeDelete(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
