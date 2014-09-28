package standard.mvc.component.business.widget.calendar.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.base.controller.GenericAbstractController;
import standard.mvc.component.base.controller.GenericInterfaceController;
import standard.mvc.component.base.dao.hibernate.SearchSupport;
import standard.mvc.component.business.widget.calendar.service.CalendarService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller("CalendarController")
@RequestMapping(value = { "**/widget" })
public class CalendarController extends GenericAbstractController implements
		GenericInterfaceController<Object> {

	@Resource(name = "CalendarService")
	CalendarService calendarService;

	@RequestMapping(value = { "/calendar/init.do" }, method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public String invokeCalendar(ModelMap modelMap) throws JsonProcessingException {
		modelMap.put("result", calendarService.getInitialList());
		return new ObjectMapper().writeValueAsString(modelMap);
	}

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
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
	public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
