package standard.mvc.component.business.community.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import standard.mvc.component.business.menu.service.MenuMngSerivce;

@Controller
public class CommunityController {

	@Resource(name = "menuMngService")
    private MenuMngSerivce menuMngService;

	@RequestMapping(value = "/index.do")
	public String index(
			@RequestParam(value = "link", defaultValue = "index") String link,
			ModelMap model) {

		model.addAttribute("menuList", menuMngService.getCommunityMenu());
		return "/jsp/community/" + link;
	}
}
