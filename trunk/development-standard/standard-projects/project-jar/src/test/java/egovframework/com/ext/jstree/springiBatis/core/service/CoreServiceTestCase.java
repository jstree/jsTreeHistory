package egovframework.com.ext.jstree.springiBatis.core.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.ReflectionUtils;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;
import egovframework.com.ext.jstree.support.util.test.DatabaseOperations;
/**
 * Modification Information
 * 
 * @author 김형채
 * @since 2015. 4. 28.
 * @version 1.0
 * @see <pre>
 * Class Name  : CoreServiceTestCase.java
 * Description : JsTree Spring+iBATIS 버젼의 JUnit4 Spring DbUnit 테스트 클래스
 * Information  : JsTree 코어 서비스 로직을 검증하는 테스트
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               	  수정자                         수정내용
 * ------------  ------------   -----------------------
 * 2015. 4. 30   김형채                   최초 생성
 * 2015. 5. 12   김형채                   @Query 어노테이션  및 주석 삭제
 * 2015. 5. 13   김형채                   MoveNodeException 테스트 케이스 추가
 * 2015. 5. 13   김형채                   testMoveNode 테스트 케이스 수정
 * 2015. 5. 19   김형채                   testAddLeafNode 테스트 케이스 추가
 * 2015. 5. 19   김형채                   testAddNodeByRefIsNull 테스트 케이스 추가
 * 2015. 6. 01   김형채                   DataSet 네이밍 변경
 * 2015. 6. 02   김형채                   testMoveNodeException 예외 클래스 변경
 * 2015. 6. 04     김형채 			testMoveNodeMultiCounterInMyParenitPositionUp 테스트 케이스 추가
 * 2015. 6. 04     김형채 			testMoveNodeMultiCounterInMyParenitPositionDown 테스트 케이스 추가
 * 2015. 6. 04     김형채 			testMoveNodeMultiCounterOutMyParenitPositionUp 테스트 케이스 추가
 * 2015. 6. 04     김형채 			testMoveNodeMultiCounterOutMyParenitPositionDown 테스트 케이스 추가
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebApplicationContextConfig.class, WebMvcConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,DbUnitTestExecutionListener.class })
@DatabaseSetup(value = "CoreServiceTestCase_InitialDataset.xml", type = DatabaseOperation.CLEAN_INSERT)
public class CoreServiceTestCase 
{
	@Resource(name="CoreService")
	private CoreService coreService;

	@Resource(name="CoreDao")
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

	private CoreServiceImpl reflectionCoreService;
	
	MockHttpServletRequest request = new MockHttpServletRequest();
	
    @Resource(name = "dataSource-${Globals.DbType}")
    protected DataSource dataSource;
    protected IDatabaseTester databaseTester;
    private final int INIT_SEQ = 5;
    
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
		rootNode.setC_type(Title.ROOTNODE.getTitle());
		rootNode.setC_title(Type.ROOT.getType());

		firstChild = new ComprehensiveTree();
		firstChild.setC_id(2);
		firstChild.setC_parentid(1);
		firstChild.setC_position(0);
		firstChild.setC_left(2);
		firstChild.setC_right(5);
		firstChild.setC_level(1);
		firstChild.setC_title(Title.FIRSTCHILD.getTitle());
		firstChild.setC_type(Type.DRIVE.getType());

		leafNode = new ComprehensiveTree();
		leafNode.setC_id(3);
		leafNode.setC_parentid(2);
		leafNode.setC_position(0);
		leafNode.setC_left(3);
		leafNode.setC_right(4);
		leafNode.setC_level(2);
		leafNode.setC_title(Title.LEAFNODE.getTitle());
		leafNode.setC_type(Type.DEFAULT.getType());

		branchNode = new ComprehensiveTree();
		branchNode.setC_id(4);
		branchNode.setC_parentid(1);
		branchNode.setC_position(1);
		branchNode.setC_left(6);
		branchNode.setC_right(7);
		branchNode.setC_level(1);
		branchNode.setC_title(Title.BRANCHNODE.getTitle());
		branchNode.setC_type(Type.FOLDER.getType());
	}

	@Before
	public void setUp() throws Exception
	{
		setUpComprehensiveTree();

		setUpReflectionCoreService();

		resetAutoIncrementColumns();
	}

	@Test
	public void testGetChildNode() throws Exception
	{
		comprehensiveTree.setC_id(2);

		l_StoredNodes = coreService.getChildNode(comprehensiveTree);

		assertThat(l_StoredNodes.size()).isEqualTo(2);
	}
	
	@Ignore // TODO
	@Test
	public void testSearchNode() throws Exception
	{
		comprehensiveTree.setSearchStr("");

		l_StoredStrings = coreService.searchNode(comprehensiveTree);

		assertThat(l_StoredStrings.size()).isEqualTo(2);
	}

	@Test
	@ExpectedDatabase(value = "CoreServiceTestCase_AddNode_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT )
	public void testAddFirstChildNode() throws Exception
	{
		comprehensiveTree.setRef(firstChild.getC_id());
		comprehensiveTree.setC_position(2);
		comprehensiveTree.setC_title(Title.LEAFNODE.getTitle());
		comprehensiveTree.setC_type(Type.DEFAULT.getType());

		comprehensiveResultTree = coreService.addNode(comprehensiveTree);
		
		assertThat(comprehensiveResultTree.getId()).isEqualTo(5);
		assertThat(comprehensiveResultTree.getStatus()).isEqualTo(1);
	}
	
	@Test(expected=RuntimeException.class)
	public void testAddLeafNode() throws Exception
	{
		comprehensiveTree.setRef(leafNode.getC_id());
		comprehensiveTree.setC_position(2);
		comprehensiveTree.setC_title(Title.LEAFNODE.getTitle());
		comprehensiveTree.setC_type(Type.DEFAULT.getType());

		comprehensiveResultTree = coreService.addNode(comprehensiveTree);
	}
	
	@Test(expected=RuntimeException.class)
	public void testAddNodeByRefIsNull() throws Exception
	{
		comprehensiveTree.setRef(5);
		comprehensiveTree.setC_position(2);
		comprehensiveTree.setC_title(Title.LEAFNODE.getTitle());
		comprehensiveTree.setC_type(Type.DEFAULT.getType());

		comprehensiveResultTree = coreService.addNode(comprehensiveTree);
	}
	

	@Test
	@ExpectedDatabase(value = "CoreServiceTestCase_RemoveNode_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testReMoveNode() throws Exception
	{
		coreService.removeNode(firstChild);
	}
	
	@Test
	@ExpectedDatabase(value = "CoreServiceTestCase_AlterNode_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testAlterNode() throws Exception
	{
		comprehensiveTree.setC_id(4);
		comprehensiveTree.setC_type(Type.DEFAULT.getType());
		comprehensiveTree.setC_title(Title.LEAFNODE.getTitle());
		
		coreService.alterNode(comprehensiveTree);
	}

	@Test
	@ExpectedDatabase(value = "CoreServiceTestCase_AlterNodeType_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testAlterNodeType() throws Exception
	{
		comprehensiveTree.setC_id(4);
		comprehensiveTree.setC_type(Type.DEFAULT.getType());

		coreService.alterNodeType(comprehensiveTree);
	}
	
	@Test
	@DatabaseSetup(value = "CoreServiceTestCase_MoveNode_InitialDataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@ExpectedDatabase(value = "CoreServiceTestCase_MoveNodePositionUp_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testMoveNodePositionUp() throws Exception
	{
		comprehensiveTree.setC_id(6);
		comprehensiveTree.setRef(2);
		comprehensiveTree.setC_position(0);
		comprehensiveTree.setCopy(0);
		comprehensiveTree.setMultiCounter(0);
		
		coreService.moveNode(comprehensiveTree, request);
	}
	
	@Test
	@DatabaseSetup(value = "CoreServiceTestCase_MoveNode_InitialDataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	public void testMoveNodePositionDown() throws Exception
	{
		comprehensiveTree.setC_id(3);
		comprehensiveTree.setRef(2);
		comprehensiveTree.setC_position(2);
		comprehensiveTree.setCopy(0);
		comprehensiveTree.setMultiCounter(0);
		
		coreService.moveNode(comprehensiveTree, request);
	}
	
	@Test
	@DatabaseSetup(value = "CoreServiceTestCase_MoveNodeMultiCounter_InitialDataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@ExpectedDatabase(value = "CoreServiceTestCase_MoveNodeMultiCounterInMyParentPosotionUp_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testMoveNodeMultiCounterInMyParenitPositionUp() throws Exception
	{
		for (int i = 0; i < 2; i++)
		{
			comprehensiveTree.setC_id(6+i);
			comprehensiveTree.setRef(3);
			comprehensiveTree.setC_position(0+i);
			comprehensiveTree.setCopy(0);
			comprehensiveTree.setMultiCounter(i);
			
			coreService.moveNode(comprehensiveTree, request);
		}
	}
	
	@Test
	@DatabaseSetup(value = "CoreServiceTestCase_MoveNodeMultiCounter_InitialDataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@ExpectedDatabase(value = "CoreServiceTestCase_MoveNodeMultiCounterInMyParentPosotionDown_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testMoveNodeMultiCounterInMyParenitPositionDown() throws Exception
	{
		for (int i = 0; i < 2; i++)
		{
			comprehensiveTree.setC_id(4+i);
			comprehensiveTree.setRef(3);
			comprehensiveTree.setC_position(4+i);
			comprehensiveTree.setCopy(0);
			comprehensiveTree.setMultiCounter(i);
			
			coreService.moveNode(comprehensiveTree, request);
		}
	}
	
	@Test
	@DatabaseSetup(value = "CoreServiceTestCase_MoveNodeMultiCounter_InitialDataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@ExpectedDatabase(value = "CoreServiceTestCase_MoveNodeMultiCounterOutMyParentPosotionUp_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testMoveNodeMultiCounterOutMyParenitPositionUp() throws Exception
	{
		for (int i = 0; i < 2; i++)
		{
			comprehensiveTree.setC_id(6+i);
			comprehensiveTree.setRef(8);
			comprehensiveTree.setC_position(0+i);
			comprehensiveTree.setCopy(0);
			comprehensiveTree.setMultiCounter(i);
			
			coreService.moveNode(comprehensiveTree, request);
		}
	}
	
	
	@Test
	@DatabaseSetup(value = "CoreServiceTestCase_MoveNodeMultiCounter_InitialDataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@ExpectedDatabase(value = "CoreServiceTestCase_MoveNodeMultiCounterOutMyParentPosotionDown_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testMoveNodeMultiCounterOutMyParenitPositionDown() throws Exception
	{
		for (int i = 0; i < 2; i++)
		{
			comprehensiveTree.setC_id(6+i);
			comprehensiveTree.setRef(8);
			comprehensiveTree.setC_position(4+i);
			comprehensiveTree.setCopy(0);
			comprehensiveTree.setMultiCounter(i);
			
			coreService.moveNode(comprehensiveTree, request);
		}
	}
	
	@Test(expected=RuntimeException.class)
	@DatabaseSetup(value = "CoreServiceTestCase_MoveNode_InitialDataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	public void testMoveNodeException() throws Exception
	{
		comprehensiveTree.setC_id(30);
		comprehensiveTree.setRef(1);
		comprehensiveTree.setC_position(0);
		comprehensiveTree.setCopy(0);
		comprehensiveTree.setMultiCounter(0);
		
		coreService.moveNode(comprehensiveTree, request);
	}
	
	@Test
	@ExpectedDatabase(value = "CoreServiceTestCase_MoveNodeCopy_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testMoveNodeCopy() throws Exception
	{
		comprehensiveTree.setC_id(4);
		comprehensiveTree.setRef(2);
		comprehensiveTree.setC_position(3);
		comprehensiveTree.setCopy(1);
		comprehensiveTree.setMultiCounter(0);
		
		coreService.moveNode(comprehensiveTree, request);
	}
	
	@Test
	@DatabaseSetup(value = "CoreServiceTestCase_MoveNode_InitialDataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@ExpectedDatabase(value = "CoreServiceTestCase_MoveNodeMultiCount_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testMoveNodeMultiCountOutMyParent() throws Exception
	{
		for (int i = 0; i < 2; i++)
		{
			comprehensiveTree.setC_id(10+i);
			comprehensiveTree.setRef(6);
			comprehensiveTree.setC_position(2+i);
			comprehensiveTree.setCopy(0);
			comprehensiveTree.setMultiCounter(i);
			
			coreService.moveNode(comprehensiveTree, request);
		}
	}
	
	@Test
	@ExpectedDatabase(value = "CoreServiceTestCase_MoveNodeCopyMultiCounter_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testMoveNodeCopyMultiCounterInMyParent() throws Exception
	{
		for (int i = 0; i < 2; i++)
		{
			comprehensiveTree.setC_id(4);
			comprehensiveTree.setRef(2);
			comprehensiveTree.setC_position(3+i);
			comprehensiveTree.setCopy(1);
			comprehensiveTree.setMultiCounter(i);
			
			coreService.moveNode(comprehensiveTree, request);
		}
	}
	
	@Test
	@ExpectedDatabase(value = "CoreServiceTestCase_MoveNodeFirstChildCopy_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testMoveNodeFirstChildCopy() throws Exception
	{
		comprehensiveTree.setC_id(2);
		comprehensiveTree.setRef(1);
		comprehensiveTree.setC_position(2);
		comprehensiveTree.setCopy(1);
		comprehensiveTree.setMultiCounter(0);
		
		coreService.moveNode(comprehensiveTree, request);
	}
	
	@Test
	@ExpectedDatabase(value = "CoreServiceTestCase_CutMyself_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testCutMyself() throws Exception
	{
		final String relectionMethodName = "cutMyself";

		Method method = reflectionCoreService.getClass().getDeclaredMethod(relectionMethodName, new Class[] { ComprehensiveTree.class, Integer.TYPE, Collection.class });

		ReflectionUtils.makeAccessible(method);

		final int spaceOfTargetNode = 2;
		Collection<Integer> c_idsByChildNodeFromNodeById = new ArrayList<>();

		ReflectionUtils.invokeMethod(method, reflectionCoreService, new Object[] { branchNode, spaceOfTargetNode, c_idsByChildNodeFromNodeById });
	}

	@Test
	@ExpectedDatabase(value = "CoreServiceTestCase_StretchPositionForMyselfFromJstree_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testStretchPositionForMyselfFromJstree() throws Exception
	{
		final String relectionMethodName = "stretchPositionForMyselfFromJstree";

		Method method = reflectionCoreService.getClass().getDeclaredMethod(relectionMethodName, new Class[] { Collection.class, ComprehensiveTree.class });

		ReflectionUtils.makeAccessible(method);

		final int leafNodeId = 3;
		final int branchNodeId = 4;
		Collection<Integer> c_idsByChildNodeFromNodeById = new ArrayList<>(Arrays.asList(leafNodeId, branchNodeId));

		ReflectionUtils.invokeMethod(method, reflectionCoreService, new Object[] { c_idsByChildNodeFromNodeById, firstChild });
	}
	
	@Test
	@ExpectedDatabase(value = "CoreServiceTestCase_StretchLeftRightForMyselfFromJstree_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testStretchLeftRightForMyselfFromJstree() throws Exception
	{
		final String relectionMethodName = "stretchLeftRightForMyselfFromJstree";

		Method method = reflectionCoreService.getClass().getDeclaredMethod(relectionMethodName, new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Collection.class, ComprehensiveTree.class });
		
		ReflectionUtils.makeAccessible(method);
		
		final int spaceOfTargetNode = 2;
		final int rightPositionFromNodeByRef = 7;
		final int copy = 0;
		final int leafNodeId = 3;
		final int branchNodeId = 4;
		
		Collection<Integer> c_idsByChildNodeFromNodeById = new ArrayList<>(Arrays.asList(leafNodeId, branchNodeId));

		ReflectionUtils.invokeMethod(method, reflectionCoreService, new Object[] { spaceOfTargetNode, rightPositionFromNodeByRef, copy, c_idsByChildNodeFromNodeById, comprehensiveTree });
	}

	private void setUpComprehensiveTree()
	{
		comprehensiveTree = new ComprehensiveTree();
		comprehensiveResultTree = new ComprehensiveTree();
	}

	private void resetAutoIncrementColumns() throws Exception
	{
		 IDatabaseConnection connection = null;
	        
	        try {
	            databaseTester = new DataSourceDatabaseTester(dataSource);
	            
	            File dataSetFile = new File(getClass().getResource(".").getPath()+ getClass().getSimpleName() + ".xml");
	            
	            IDataSet dataSet = new FlatXmlDataSetBuilder().build(dataSetFile);
	            
	            connection = databaseTester.getConnection();
	            
	            DatabaseOperations.INIT_SEQ.execute(connection, dataSet, INIT_SEQ);
	            
	        } finally {
	            if (connection != null) {
	                connection.close();
	            }
	        }
	}

	private void setUpReflectionCoreService()
	{
		reflectionCoreService = new CoreServiceImpl();

		final String reflectionFieldName = "coreDao";
		final Class<? extends CoreService> reflectionClass = reflectionCoreService.getClass();
		

		final Field coreServiceField = ReflectionUtils.findField(reflectionClass, reflectionFieldName);

		ReflectionUtils.makeAccessible(coreServiceField);
		ReflectionUtils.setField(coreServiceField, reflectionCoreService, dao);
	}

	enum Title
	{
		ROOTNODE("Root Node"), FIRSTCHILD("First Child"), LEAFNODE("Leaf Node"), BRANCHNODE("Branch Node");

		private String theTitle;

		private Title(String newTitle)
		{
			this.theTitle = newTitle;
		}

		public String getTitle()
		{
			return this.theTitle;
		}
	}

	enum Type
	{
		ROOT("root"), DRIVE("drive"), FOLDER("folder"), DEFAULT("default");

		private String theType;

		private Type(String newType)
		{
			this.theType = newType;
		}

		public String getType()
		{
			return this.theType;
		}
	}
}