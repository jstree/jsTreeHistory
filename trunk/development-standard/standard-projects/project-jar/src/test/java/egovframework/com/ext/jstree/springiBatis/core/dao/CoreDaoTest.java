package egovframework.com.ext.jstree.springiBatis.core.dao;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.unitils.dbunit.annotation.ExpectedDataSet;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;

/**
 * Modification Information
 * 
 * @author Hoseong.Son
 * @since 2015.02.27
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: CoreDaoTest.java
 * 	Description : DBUnit + Spring 연동 Dao 테스트
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2015.02.27    Hoseong.Son           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebApplicationContextConfig.class,
		WebMvcConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
public class CoreDaoTest {

	@Autowired
	private WebApplicationContext context;
	@Resource(name = "CoreDao")
	private CoreDao dao;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * xml dataset 을 읽지 못함. 버전 별로 API 가 다름. 좀더 학습 필요.
	 * 
	 * @throws Exception
	 */
	@Ignore
	@Test
	@ExpectedDataSet(value = "/egovframework/com/ext/jstree/springiBatis/core/dao/expectedDataSet.xml")
	public void test() throws Exception {
		ComprehensiveTree comprehensiveTree = new ComprehensiveTree();
		comprehensiveTree.setC_id(2);
		ComprehensiveTree result = dao.getNode(comprehensiveTree);
		Assert.assertEquals(comprehensiveTree.getC_id(), result.getC_id());
	}

}
