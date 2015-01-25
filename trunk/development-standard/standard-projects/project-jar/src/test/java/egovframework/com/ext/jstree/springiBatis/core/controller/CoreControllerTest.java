package egovframework.com.ext.jstree.springiBatis.core.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 1. 24.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: CoreControllerTest.java
 * 	Description : jstree Spring+iBatis 버젼의 컨트롤러 junit 테스트 클래스
 * 	Infomation	: jstree Controller 정보. 
 * 
 * 			Test Case 1 : 특정메소드 파라미터 검증 테스트	
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2015. 1. 24.  전경훈           최초 생성 및 테스트케이스 1 작성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */


public class CoreControllerTest {
	
	private CoreController controller;
	private ComprehensiveTree tree;
	
	@Before
	public void setUp(){
		controller = new CoreController();
		tree = new ComprehensiveTree();
	}
	
	@Test
	public void testCase1() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest("POST","/alterNode.do");
		ModelMap modelMap = new ModelMap();
		request.addParameter("c_id", "322");
		request.addParameter("c_type", "folder");
		tree.setC_id(322);
		tree.setC_type("folder");
		
		controller.alterNodeType(tree, modelMap, request);
	}

}
