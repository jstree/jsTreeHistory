package standard.mvc.controller.spring.community;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import standard.mvc.controller.GenericAbstractController;
import standard.mvc.controller.GenericInterfaceController;
import standard.mvc.dao.hibernate.SearchSupport;

/**
 *  Class Name : TemplateMethodResolveViewSupporter.java
 *  Description : WEBDAV를 활용하여 뷰 리졸버와의 결합을 통한 디자인과 개발을 완전하게 분리하는 목적의 클래스
 *  Modification Information
 * 
 *  @author Dongmin.Lee
 *  @since 2014.06.18
 *  @version 1.0
 *  @see
 *
 *  <pre>
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
@RequestMapping(value = { "/spring" })
public class IndexController extends GenericAbstractController implements GenericInterfaceController<Object>{

	/**
     * 이 함수는 본 클래스를 확장한 커스텀 뷰 리졸버로부터 값을 주입받는다
     * 이 주입값을 사용하여 컨트롤러로부터 넘어온 값이 확장한 클래스의 뷰 리졸버가 처리해야 하는지의 여부를 구분한다.
     * ex1> (컨트롤러)/freemarker/page => (주입값)/freemarker => (비교)freemarker리졸버가 처리  - startwith로 비교
     * ex2> (컨트롤러)/velocity/page     => (주입값)/velocity     => (비교)velocity리졸버가 처리 - startwith로 비교
     * @param String 확장한 클래스로부터 View prefix 프로퍼티로부터 받아온 값을 주입받는다. ( /freemarker )
    */
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
     * XML스키마를 자바클래스(임의)로 생성
     * @param String xml XML스키마
     * @param String ja 생성될JAR파일의 위치
     * @return boolean result 생성여부 True/False
     * @exception Exception
    */
	@Override
	@RequestMapping(value = { "/communityIndex.do" })
	public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return "/jsp/index";
	}


	@Override
	public String invokeInsert(SearchSupport searchSupport, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String invokeUpdate(SearchSupport searchSupport, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String invokeDelete(SearchSupport searchSupport, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}


}
