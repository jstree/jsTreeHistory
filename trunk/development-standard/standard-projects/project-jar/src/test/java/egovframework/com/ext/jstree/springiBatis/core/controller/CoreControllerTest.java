package egovframework.com.ext.jstree.springiBatis.core.controller;

import egovframework.com.ext.jstree.springiBatis.core.mock.MockCoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreServiceImpl;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;

import java.lang.reflect.Field;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
 *  2015. 1. 31.  전경훈           강하형이 만든 MockDao 를 활용하여 테스트케이스1 수정 및 테스트케이스2 작성
 *  2015. 2. 28.  전경훈 			 Core 테스트 추가 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

public class CoreControllerTest {
	private CoreController coreController;

	@Before
	public void setUp() throws Exception {
		coreController = new CoreController();
		CoreServiceImpl coreService = new CoreServiceImpl();
		MockCoreDao<ComprehensiveTree> mockDao = new MockCoreDao<>();
		// 리플렉션으로 coreService 직접 주입
		Field coreControllerField = coreController.getClass().getDeclaredField("coreService");
		coreControllerField.setAccessible(true);
		coreControllerField.set(coreController, coreService);

		Field coreServiceField = coreService.getClass().getDeclaredField("coreDao");
		coreServiceField.setAccessible(true);
		coreServiceField.set(coreService, mockDao);
	}

	@After
	public void after(){

	}

	/*
	 * 테스트 1
	 * getChildNode 테스트 - 정상값
	 */
//	@Test
	public void testCase1() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ModelMap model = new ModelMap();
		
		request.addParameter("c_id", "1");
		ComprehensiveTree tree = new ComprehensiveTree();
		tree.setC_id(1);
		
		List<ComprehensiveTree> list = coreController.getChildNode(tree, model, request);
		assertThat(list, notNullValue());
		assertEquals(3, list.get(0).getC_right());
	}

	/* 
	 * 테스트 2
	 * getChildNode 테스트 - c_id 비정상값
	 * c_ID 는 1 이상이 들어가므로 0이 입력되면 컨트롤러에서 exception 발생해야함
	 */
//	@Test(expected = RuntimeException.class)
	public void testCase2() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ModelMap model = new ModelMap();
		
		request.addParameter("c_id", "0");
		ComprehensiveTree tree = new ComprehensiveTree();
		tree.setC_id(0);
		
		// Exception 발생
		coreController.getChildNode(tree, model, request);
	}
	
	/* 
	 * 테스트 3
	 * alterNodeType 테스트 - 
	 * 현재 spring 버전에서 폴더타입(하위 자식 노드를 가지는 타입)도 하위노드를 가질 수 없는 FILE 같은 타입으로 변경가능(화면에서만, 
	 * 이부분은 biz에 관련된 부분이기때문에 처리할 수 있는 방안을 강구해야함 
	 */
	@Test(expected = RuntimeException.class)
	public void testCase3() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addParameter("c_id", "0");
		ComprehensiveTree t = new ComprehensiveTree();
		t.setC_id(10);
		t.setC_type("folder");
		t.setC_title("testFolder");
		// left right 포지션을 서버에서 설정해야하지 않을까? -> 트랜잭션
		
		ComprehensiveTree t1 = new ComprehensiveTree();
		t1.setC_id(20);
		t1.setC_type("default");
		t1.setC_title("testDefault");
		

		
	}
}
