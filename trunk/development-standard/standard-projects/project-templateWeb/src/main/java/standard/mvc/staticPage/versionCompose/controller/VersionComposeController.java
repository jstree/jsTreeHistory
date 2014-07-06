package standard.mvc.staticPage.versionCompose.controller;

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
import standard.mvc.dao.hibernate.SearchSupport;

/**
 * 바로보드 소개 > 버젼별 구성 메뉴에 해당하는 컨트롤러
 * @author 류강하
 * @since 2014.06.30
 */
@Controller
@RequestMapping(value = "/community/introduce/04version-compose")
public class VersionComposeController extends GenericAbstractController implements GenericInterfaceController<Object> {

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = "/select.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult, Object parameterBean) {
		
		String viewResolver = "/thymeleaf";
		String site = "/community";
		String menu = "/staticPage";
		String target = "/versionCompose/04version-compose";
		
		return viewResolver + site + menu + target;
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
