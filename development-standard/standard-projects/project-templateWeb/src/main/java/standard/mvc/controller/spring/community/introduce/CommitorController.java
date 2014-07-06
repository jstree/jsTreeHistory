package standard.mvc.controller.spring.community.introduce;

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

/**
 * 바로보드 소개 > 커미터 메뉴에 해당하는 컨트롤러
 * 
 * @author 이종렬
 * @since 2014.07.04
 */

//@Controller
@RequestMapping(value = "/community/introduce/15commitor")
public class CommitorController extends GenericAbstractController implements
		GenericInterfaceController<Object> {

	@Override
	@RequestMapping(value = "/select.do", method = RequestMethod.POST)
	public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {

		String viewResolver = "/thymeleaf";
		String site = "/community";
		String menu = "/introduce";
		String target = "/15commitor";

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

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}
}