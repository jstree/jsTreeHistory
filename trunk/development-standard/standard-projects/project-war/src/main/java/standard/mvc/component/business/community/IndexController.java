package standard.mvc.component.business.community;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import standard.mvc.component.business.community.menu.service.MenuService;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.mvc.dao.hibernate.SearchSupport;

/**
 * Modification Information
 * 
 * @author Jongryul.Lee
 * @since 2014.11.16
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: CommunityController.java
 * 	Description : jsTree, SiteMesh 를 사용한 페이지 호출 컨트롤러 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.11.16    Jongryul.Lee           최초 생성
 *  2014.11.17    Hoseong.Son    1. index 메소드 requestMapping "/index.do" => "/menu.do"
 *                               2. @PathVariable("path") 추가
 *  2014.11.18    Hoseong.Son    1. index.do requestMapping 분리
 *                               2. requestMapping /{path}.do => /대분류(major)/소분류(minor).do
 *  2014.11.20    Hoseong.Son    1. index(..) 메소드 제거                                                     
 *  2015.01.30    전경훈           1. handleError404 메소드 추가
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
public class IndexController extends GenericAbstractController{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "MenuService")
	private MenuService menuService;
	
	@RequestMapping(value = { "/{component}/{action}.do" })
	public String execute(ModelMap model, @PathVariable("component") String component,
			@PathVariable("action") String action, SearchSupport searchSupport, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult) throws Exception {
		StringBuffer sb = new StringBuffer("/jsp/community");
		sb.append("/");
		sb.append(component);
		sb.append("/");
		sb.append(action);
		sb.append("/");
		sb.append(action);

		logger.info("path : {}", new Object[] { sb });
		model.addAttribute("menuList", menuService.getMenuList());
		model.addAttribute("actionTarget", getParameterParser(request).get("actionTarget"));
		return sb.toString();
	}

	@RequestMapping(value = "/index.do")
	public String execute(ModelMap model) throws Exception {
		model.addAttribute("menuList", menuService.getMenuList());
		return ":index";
	}

	@RequestMapping(value = "/common/error.do")
	public String handleError() throws Exception {
		return "/jsp/community/common/error";
	}
	
	@RequestMapping(value = "/common/404error.do")
	public String handle404Error(ModelMap model) throws Exception {
		model.addAttribute("menuList", menuService.getMenuList());
		return "/jsp/community/common/404error";
	}
}
