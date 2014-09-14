package standard.mvc.component.business.menu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import standard.mvc.component.business.menu.service.MenuService;
import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author DongMin.Lee
 * @since 2014. 7. 30.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: MenuController.java
 * 	Description : jstree 의 Spring+iBatis 버젼의 컨트롤러 클래스
 * 	Infomation	: jstree Controller 정보. 
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014. 9. 05.  이동민        		최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = { "**/**/community" })
public class MenuController {

	@Resource(name = "MenuService")
	MenuService menuService;

	/**
	 * 자식노드를 요청한다.
	 * 
	 * @param menuComprehensiveTree
	 * @param model
	 * @param request
	 * @return String
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping("/largeMenu/middleMenu/smallMenu/menu/invokeSelect.do")
	public String getChildNode(MenuComprehensiveTree menuComprehensiveTree, ModelMap model, HttpServletRequest request)
			throws JsonProcessingException {

		if (menuComprehensiveTree.getC_id() == 0) {
			throw new RuntimeException();
		}

		return new ObjectMapper().writeValueAsString(menuService.getChildNode(menuComprehensiveTree));
	}

	@ResponseBody
	@RequestMapping("/largeMenu/middleMenu/smallMenu/menu/searchNode.do")
	public String searchNode(MenuComprehensiveTree menuComprehensiveTree, ModelMap model, HttpServletRequest request)
			throws JsonProcessingException {

		if (!StringUtils.hasText(menuComprehensiveTree.getSearchStr())) {
			throw new RuntimeException();
		}

		return new ObjectMapper().writeValueAsString(menuService.searchNode(menuComprehensiveTree));
	}
}
