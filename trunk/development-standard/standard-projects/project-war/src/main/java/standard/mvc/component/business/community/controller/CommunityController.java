package standard.mvc.component.business.community.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import standard.mvc.component.business.community.menu.service.MenuMngSerivce;

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
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
public class CommunityController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "menuMngService")
	private MenuMngSerivce menuMngService;

	@RequestMapping(value = { "/{major}/{minor}.do" })
	public String execute(ModelMap model, @PathVariable("major") String major,
			@PathVariable("minor") String minor) throws Exception {
		StringBuffer sb = new StringBuffer("/jsp/community");
		sb.append("/");
		sb.append(major);
		sb.append("/");
		sb.append(minor);
		sb.append("/");
		sb.append(minor);

		logger.info("path : {}", new Object[] { sb });
		model.addAttribute("menuList", menuMngService.getCommunityMenu());
		return sb.toString();
	}

	@RequestMapping(value = "/index.do")
	public String execute(ModelMap model) throws Exception {
		model.addAttribute("menuList", menuMngService.getCommunityMenu());
		return "/jsp/community/index/index";
	}

	@RequestMapping(value = "/common/error.do")
	public String handleError() throws Exception {

		return "/jsp/community/common/error";
	}
	
	@RequestMapping(value = "/common/404error.do")
	public String handle404Error(ModelMap model) throws Exception {
		model.addAttribute("menuList", menuMngService.getCommunityMenu());
		return "/jsp/community/common/404error";
	}
}
