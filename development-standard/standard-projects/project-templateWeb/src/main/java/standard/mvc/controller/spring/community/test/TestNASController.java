package standard.mvc.controller.spring.community.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestNASController {
	@RequestMapping(value = "test/nas")
	public String nasTest(ModelMap modelMap) {
		modelMap.addAttribute("nasFile", "/Source/Script/ajax/ajax.js");
		return ":nas";
	}
	
	@RequestMapping(value = "test/pennori")
	public String thymeleafSample(ModelMap map){
		map.addAttribute("jkw", "pennori");
		return "/freemarker/test";
	}

}
