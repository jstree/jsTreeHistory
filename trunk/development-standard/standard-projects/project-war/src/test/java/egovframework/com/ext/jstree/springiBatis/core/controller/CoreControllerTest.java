package egovframework.com.ext.jstree.springiBatis.core.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;

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


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebApplicationContextConfig.class, WebMvcConfig.class })
public class CoreControllerTest {
	

    @Autowired
    private ApplicationContext applicationContext;
	
    @Autowired
	private CoreController controller;
    
    @Autowired
	private ComprehensiveTree tree;
	
	@Before
	public void setUp(){
		
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

	@After
	public void after(){
		
	}
}
