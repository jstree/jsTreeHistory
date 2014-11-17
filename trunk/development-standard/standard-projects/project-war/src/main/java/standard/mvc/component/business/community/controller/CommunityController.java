package standard.mvc.component.business.community.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import standard.mvc.component.business.menu.service.MenuMngSerivce;

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
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
public class CommunityController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "menuMngService")
	private MenuMngSerivce menuMngService;

	@RequestMapping(value = "/menu.do")
	public String index(
			@RequestParam(value = "link", defaultValue = "menu") String link,
			ModelMap model) {

		model.addAttribute("menuList", menuMngService.getCommunityMenu());
		return "/jsp/community/" + link;
	}

	@RequestMapping(value = { "/{path}.do" })
	public String execute(ModelMap model, @PathVariable("path") String path)
			throws Exception {
		StringBuffer sb = new StringBuffer("/jsp/community");
		sb.append("/");
		sb.append(null == path ? "index" : path);
		sb.append("/");
		sb.append(null == path ? "index" : path);

		logger.info("path : {}", new Object[] { sb });

		return sb.toString();
	}

	@RequestMapping(value = "/common/error.do")
	public String handleError() throws Exception {

		return "/jsp/community/common/error";
	}
}
