package standard.mvc.component.business.menu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.menu.service.MenuService;
import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

import com.fasterxml.jackson.core.JsonProcessingException;

import egovframework.com.ext.jstree.springiBatis.core.util.Util_TitleChecker;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author DongMin.Lee
 * @since 2014. 7. 30.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: MenuController.java
 * 	Description : Menu jstree 의 Spring+iBatis 버젼의 컨트롤러 클래스
 * 	Infomation	: Menu jstree Controller 정보. 
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014. 9. 05.  이동민                 최초 생성 - 자식 노드 조회 메서드 추가
 *  2014. 9. 15.  류강하                 '노드 추가' 메서드 추가 및 클래스 리팩토링
 *  2014. 9. 21.  류강하                 '노드 추가' 메서드 추가 완료
 *  2014. 9. 21.  김대근                 removeNode 메소드 추가
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
	public List<MenuComprehensiveTree> getChildNode(MenuComprehensiveTree menuComprehensiveTree)
			throws JsonProcessingException {

		if (menuComprehensiveTree.getC_id() == 0) {
			throw new RuntimeException();
		}

		return menuService.getChildNode(menuComprehensiveTree);
	}

	/**
	 * 노드를 추가한다.
	 * 
	 * @param comprehensiveTree
	 * @param model
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping("/largeMenu/middleMenu/smallMenu/menu/addNode.do")
	public ComprehensiveTree addNode(MenuComprehensiveTree menuComprehensiveTree, HttpServletRequest request)
			throws JsonProcessingException {
		
	    // TODO 공통적 파라미터 값 검증 적용
	    
		String ref = request.getParameter("ref");
		String c_position = request.getParameter("c_position");
		String c_title = request.getParameter("c_title");
		String c_type = request.getParameter("c_type");
		
		if (ref == null || c_position == null || c_title == null || c_type == null) {
			throw new RuntimeException("addNode parameter null");
		} 
		
		if ("0".equals(ref)) {
			throw new RuntimeException("addNode ref value is 0");
		}

		if (Integer.parseInt(c_position) < 0) {
			throw new RuntimeException("addNode c_postion less 0");
		}
		
		if ("drive".equals(c_type)) {
			throw new RuntimeException("addNode c_type value is drive");
		} 
		else if ( !("default".equals(c_type) || "folder".equals(c_type)) ) {
			throw new RuntimeException("addNode c_position value is another");
		}
		
		menuComprehensiveTree.setC_title(Util_TitleChecker.StringReplace(menuComprehensiveTree.getC_title()));
		menuService.addNode(menuComprehensiveTree);

		return menuComprehensiveTree;
	}
	
	@ResponseBody
	@RequestMapping("/largeMenu/middleMenu/smallMenu/menu/removeNode.do")
	public int removeNode(MenuComprehensiveTree menuComprehensiveTree, HttpServletRequest request){
		return menuService.removeNode(menuComprehensiveTree);
	}
	
//    @ResponseBody
//    @RequestMapping("/largeMenu/middleMenu/smallMenu/menu/searchNode.do")
//    public String searchNode(MenuComprehensiveTree menuComprehensiveTree, ModelMap model, HttpServletRequest request)
//            throws JsonProcessingException {
//
//        if (!StringUtils.hasText(menuComprehensiveTree.getSearchStr())) {
//            throw new RuntimeException();
//        }
//
//        return new ObjectMapper().writeValueAsString(menuService.searchNode(menuComprehensiveTree));
//    }
}
