package standard.mvc.component.business.baroboard.user.join.login.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import standard.mvc.component.business.baroboard.user.join.register.service.UserRegisterService;
import standard.mvc.component.business.baroboard.user.vo.User;
import standard.mvc.component.business.community.log.service.LogUrlSerivce;
import standard.mvc.component.business.community.menu.service.MenuMngSerivce;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @ author 김형채
 * 
 * @since 2015. 6. 10.
 * @version 1.0
 * @see <pre>
 * Class Name  : LoginController.java
 * Description : 로그인- 로그인 Controller 
 * Infomation  : 로그인- 로그인 컨트롤러
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -----------   ------------  -----------------------
 * 2015. 06.10.  김형채 		      최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Controller
@RequestMapping(value = "/user/join")
public class LoginController extends GenericAbstractController {
	
	@Resource(name = "menuMngService")
	private MenuMngSerivce menuMngService;
	
	@Resource(name = "logUrlService")
	private LogUrlSerivce logUrlService;
	
	@RequestMapping("/login.do")
	public String login(ModelMap model) throws Exception {
		model.addAttribute("menuList", menuMngService.getCommunityMenu());
		model.addAttribute("logUrl", logUrlService.getLogUrl());
        return "/jsp/user/join/login/index";
	}
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() 
	{
		return null;
	}

	
}