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
 * 바로보드 소개 > 실행환경 메뉴에 해당하는 컨트롤러
 * @author 류강하
 * @since 2014.06.30
 */
@Controller
@RequestMapping(value = "/community/introduce/06runtime")
public class RuntimeController extends GenericAbstractController implements GenericInterfaceController<Object> {

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = "/select.do", method = RequestMethod.POST)
	public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult, Object parameterBean) {
		
		String viewResolver = "/thymeleaf";
		String site = "/community";
		String menu = "/introduce";
		String target = "/06runtime";
		
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
