package standard.mvc.staticPage.baro.controller;

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
 *  Class Name : BaroController.java<br />
 *  Description : 바로보드 소개 > 바로보드란? 메뉴에 해당하는 컨트롤러 클래스<br />
 *  @author 류강하
 *  @since 2014.06.30
 *  @version 1.0
 *  @see
 *
 *  <pre>
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.08    류강하      주석을 형식에 맞게 수정하고...
 *
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = "/community/introduce/baro")
public class BaroController extends GenericAbstractController implements GenericInterfaceController<Object> {

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = "/select.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult, Object parameterBean) {
		
		String viewResolverName = "/thymeleaf";
		String siteName = "/community";
		String menuName = "/staticPage/baro";
		String pageName = "/baro";
		
		return viewResolverName + siteName + menuName + pageName;
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
