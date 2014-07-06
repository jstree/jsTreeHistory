package standard.mvc.staticPage.releasenote.controller;

/*
 * 릴리즈 노트 컨트롤러
 * @author JeonKyungHun
 * 
 */

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import standard.mvc.controller.GenericAbstractController;
import standard.mvc.controller.GenericInterfaceController;
import standard.mvc.dao.hibernate.SearchSupport;


@Controller
@RequestMapping(value = "/community/introduce/02release-note")
public class ReleasenoteController extends GenericAbstractController implements GenericInterfaceController<Object> {

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@RequestMapping(value = "/select.do", method = RequestMethod.POST)
	public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		String viewResolver = "/thymeleaf";
		String site= "/community";
		String menu = "/staticPage/releaseNote";
		String target = "/02release-note";
		
		return viewResolver + site + menu + target;
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
