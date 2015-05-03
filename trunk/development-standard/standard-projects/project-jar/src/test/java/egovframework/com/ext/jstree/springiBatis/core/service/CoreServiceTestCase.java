package egovframework.com.ext.jstree.springiBatis.core.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.github.springtestdbunit.dataset.ReplacementDataSetLoader;

import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.config.TestWebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;
import egovframework.com.ext.jstree.support.util.test.DbTestUtil;

/**
 * Modification Information
 * 
 * @author 김형채
 * @since 2015. 4. 28.
 * @version 1.0
 * @see <pre>
 * Class Name  : CoreServiceTestCase.java
 * Description : JsTree Spring+iBATIS 버젼의 JUnit4 Spring DbUnit 테스트 클래스
 * Infomation  : JsTree 코어 서비스 로직을 검증하는 테스트
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               	  수정자                         수정내용
 * ------------  ------------   -----------------------
 * 2015. 4. 30   김형채                         최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestWebApplicationContextConfig.class, WebMvcConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class, 
                          TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DbUnitConfiguration(databaseConnection = { "dataSource-oracle" }, dataSetLoader = ReplacementDataSetLoader.class)
@DatabaseSetup(value="/egovframework/com/ext/jstree/springiBatis/core/service/initialJsTree.xml", type = DatabaseOperation.CLEAN_INSERT)
public class CoreServiceTestCase {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CoreService coreService;
    
	@Autowired 
	private CoreDao dao;
	
	@Autowired
    private ApplicationContext applicationContext;
    
    private ComprehensiveTree comprehensiveTree;
	private ComprehensiveTree comprehensiveResultTree;
	
	private static ComprehensiveTree rootNode;
	private static ComprehensiveTree firstChild;
	private static ComprehensiveTree leafNode;
	private static ComprehensiveTree branchNode;

	private List<ComprehensiveTree> l_StoredNodes;
	private List<String> l_StoredStrings;
	
	@BeforeClass
	public static void setUpOnce() throws Exception
	{
		rootNode = new ComprehensiveTree();
		rootNode.setC_id(1);
		rootNode.setC_parentid(0);
		rootNode.setC_position(0);
		rootNode.setC_left(1);
		rootNode.setC_right(8);
		rootNode.setC_level(0);
		rootNode.setC_type("root");
		rootNode.setC_title("Root Node");

		firstChild = new ComprehensiveTree();
		firstChild.setC_id(2);
		firstChild.setC_parentid(1);
		firstChild.setC_position(0);
		firstChild.setC_left(2);
		firstChild.setC_right(5);
		firstChild.setC_level(1);
		firstChild.setC_title("First Child");
		firstChild.setC_type("drive");

		leafNode = new ComprehensiveTree();
		leafNode.setC_id(3);
		leafNode.setC_parentid(2);
		leafNode.setC_position(0);
		leafNode.setC_left(3);
		leafNode.setC_right(4);
		leafNode.setC_level(2);
		leafNode.setC_title("Leaf Node");
		leafNode.setC_type("default");

		branchNode = new ComprehensiveTree();
		branchNode.setC_id(4);
		branchNode.setC_parentid(1);
		branchNode.setC_position(1);
		branchNode.setC_left(6);
		branchNode.setC_right(7);
		branchNode.setC_level(1);
		branchNode.setC_title("Branch Node");
		branchNode.setC_type("folder");
	}
	
	@Before
	public void setUp() throws Exception
	{
		final String sequenceName = "S_COMPREHENSIVETREE_SPRING";
		final int startSeqNumber = 5;
		
		DbTestUtil.resetAutoIncrementColumns(applicationContext, sequenceName, startSeqNumber);
		
		comprehensiveTree = new ComprehensiveTree();
	}
	
	@Test
	public void testGetChildNode() throws Exception
	{
		comprehensiveTree.setC_id(2);
		
		l_StoredNodes =  coreService.getChildNode(comprehensiveTree);
		
		assertThat(l_StoredNodes.size(), is(2));
	}
	
	@Test
	public void testSearchNode() throws Exception
	{
		comprehensiveTree.setSearchStr("");
		
		l_StoredStrings = coreService.searchNode(comprehensiveTree);
		
		assertThat(l_StoredStrings.size(), is(2));
	}
	
	@Test
	@ExpectedDatabase(value="/egovframework/com/ext/jstree/springiBatis/core/service/addNodeAfterDataset.xml",assertionMode=DatabaseAssertionMode.NON_STRICT)
	public void testAddNode1() throws Exception
	{
		//param ex : ref=2&c_position=2&c_title=New+Leaf+Node&c_type=default
		
		comprehensiveTree.setRef(firstChild.getC_id());
		comprehensiveTree.setC_position(coreService.getChildNode(firstChild).size());
		comprehensiveTree.setC_title(Title.LEAFTNODE.getTitle());
		comprehensiveTree.setC_type(Type.DEFAULT.getType());
		
		coreService.addNode(comprehensiveTree);
	}
	
	enum Title 
	{
		ROOTNODE("Root Node"), FIRSTCHILD("First Child"), LEAFTNODE("Leaf Node"), BRANCHNODE("Branch Node");
		
		private String theTitle;
		
		private Title(String newTitle)
		{
			this.theTitle = newTitle;
		}
		
		public String getTitle(){
			return this.theTitle;
		}
	}
	
	enum Type 
	{
		NULL(""), DRIVE("drive"), FOLDER("folder"), DEFAULT("default");
		
		private String theType;
		
		private Type(String newType)
		{
			this.theType = newType;
		}
		
		public String getType(){
			return this.theType;
		}
	}
}