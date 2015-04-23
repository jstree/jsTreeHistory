package egovframework.com.ext.jstree.springiBatis.core.dao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.unitils.reflectionassert.ReflectionAssert.assertLenientEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyLenientEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.config.TestWebApplicationContextConfig;
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
 *  2015.04.23    HyungChae.Kim         테스트DB, Spring DbUnit으로 설정변경 및 단위 테스트 추가
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestWebApplicationContextConfig.class, WebMvcConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class
	                    , TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DbUnitConfiguration(databaseConnection = { "dataSource-oracle" },dataSetLoader = ColumnSensingFlatXmlDataSetLoader.class)
@DatabaseSetup(value="/egovframework/com/ext/jstree/springiBatis/core/dao/initialJsTree.xml",type = DatabaseOperation.CLEAN_INSERT)
public class CoreDaoTest
{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired 
	private CoreDao dao;
	
    @Autowired
    private CoreService coreService;

	private ComprehensiveTree comprehensiveTree;
	private ComprehensiveTree comprehensiveResultTree;

	private ComprehensiveTree rootNode;
	private ComprehensiveTree firstChild;
	private ComprehensiveTree leafNode;
	private ComprehensiveTree branchNode;

	private List<ComprehensiveTree> l_StoredNodes;
	private List<String> l_StoredStrings;

	private Collection<Integer> c_idsByChildNodeFromNodeById = null;

	private int spaceOfTargetNode = 2;

	@Before
	public void setUp()
	{
		comprehensiveTree = new ComprehensiveTree();

		rootNode = new ComprehensiveTree();
		rootNode.setC_id(1);
		rootNode.setC_parentid(0);
		rootNode.setC_position(0);
		rootNode.setC_left(1);
		rootNode.setC_right(8);
		rootNode.setC_level(0);
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
	
	@Test
	public void testGetChildNode() throws Exception
	{
		comprehensiveTree.setC_id(1);
		l_StoredNodes = dao.getChildNode(comprehensiveTree);

		firstChild.setChildcount("InChild");
		branchNode.setChildcount("NoChild");

		assertThat(l_StoredNodes.size(), is(2));
		assertLenientEquals(l_StoredNodes.get(0), firstChild);
		assertLenientEquals(l_StoredNodes.get(1), branchNode);
	}

	@Test
	public void testSearchNodeByString() throws Exception
	{
		getAllTree();

		assertThat(l_StoredNodes.size(), is(4));
	}

	@Test
	public void testSearchNodeByPosition() throws Exception
	{
		comprehensiveTree.setC_id(2);
		l_StoredNodes = dao.getChildNode(comprehensiveTree);
		l_StoredStrings = dao.searchNodeByPosition(l_StoredNodes);

		assertThat(l_StoredStrings.size(), is(2));
		assertThat(l_StoredStrings.get(0), is(equalTo("1")));
		assertThat(l_StoredStrings.get(1), is(equalTo("2")));
	}

	@Test
	public void testGetNode() throws Exception
	{
		comprehensiveTree.setC_id(3);
		comprehensiveResultTree = dao.getNode(comprehensiveTree);

		assertLenientEquals(comprehensiveResultTree, leafNode);
	}

	@Test
	public void testGetNodeByRef() throws Exception
	{
		comprehensiveTree.setRef(2);
		comprehensiveResultTree = dao.getNodeByRef(comprehensiveTree);

		assertLenientEquals(comprehensiveResultTree, firstChild);
	}

	@Test
	@ExpectedDatabase(value="/egovframework/com/ext/jstree/springiBatis/core/dao/cutMyselfAfterDataset.xml",assertionMode=DatabaseAssertionMode.NON_STRICT)
	public void testCutMyself() throws Exception
	{
		c_idsByChildNodeFromNodeById = new ArrayList<>();
		c_idsByChildNodeFromNodeById.add(3);

		firstChild.setSpaceOfTargetNode(spaceOfTargetNode);
		firstChild.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);

		dao.cutMyself(firstChild);

		getAllTree();
		
		assertPropertyLenientEquals("c_right", 6, l_StoredNodes.get(0));
		assertPropertyLenientEquals("c_right", 3, l_StoredNodes.get(1));
		assertPropertyLenientEquals("c_left", 4, l_StoredNodes.get(3));
		assertPropertyLenientEquals("c_right", 5, l_StoredNodes.get(3));
	}

	@Test
	public void testStretchPositionForMyselfFromJstree() throws Exception
	{
		comprehensiveTree.setRef(2);
		comprehensiveTree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);

		dao.stretchPositionForMyselfFromJstree(comprehensiveTree);

		comprehensiveTree.setC_id(3);
		comprehensiveResultTree = dao.getNode(comprehensiveTree);

		assertPropertyLenientEquals("c_position", 1, comprehensiveResultTree);
	}

	@Test
	public void testStretchLeftRightForMyselfFromJstree() throws Exception
	{
		comprehensiveTree.setSpaceOfTargetNode(spaceOfTargetNode);
		comprehensiveTree.setRightPositionFromNodeByRef(5);
		comprehensiveTree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
		comprehensiveTree.setCopy(0);

		dao.stretchLeftRightForMyselfFromJstree(comprehensiveTree);

		rootNode.setC_right(10);

		getAllTree();

		assertPropertyLenientEquals("c_right", 10, l_StoredNodes.get(0));
		assertPropertyLenientEquals("c_right", 7, l_StoredNodes.get(1));
		assertPropertyLenientEquals("c_left", 8, l_StoredNodes.get(3));
		assertPropertyLenientEquals("c_right", 9, l_StoredNodes.get(3));
	}

	@Test
	public void testPasteMyselfFromJstree() throws Exception
	{
		c_idsByChildNodeFromNodeById = new ArrayList<>();
		c_idsByChildNodeFromNodeById.add(4);

		comprehensiveTree.setRef(2);
		comprehensiveTree.setIdif(2);
		comprehensiveTree.setSpaceOfTargetNode(spaceOfTargetNode);
		comprehensiveTree.setLdif(-1);
		comprehensiveTree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
		comprehensiveTree.setRightPositionFromNodeByRef(5);
		comprehensiveTree.setIdifLeft(1);
		comprehensiveTree.setIdifRight(1);

		dao.pasteMyselfFromJstree(comprehensiveTree);

		getAllTree();
		
		assertPropertyLenientEquals("c_left", 5, l_StoredNodes.get(4));
		assertPropertyLenientEquals("c_right", 6, l_StoredNodes.get(4));
	}

	@Test
	public void testGetChildNodeByLeftRight() throws Exception
	{
		l_StoredNodes = dao.getChildNodeByLeftRight(firstChild);

		assertLenientEquals(l_StoredNodes.get(0), firstChild);
		assertLenientEquals(l_StoredNodes.get(1), leafNode);
	}

	@Test
	public void testFixCopy() throws Exception
	{
		comprehensiveTree.setC_id(4);
		comprehensiveTree.setFixCopyId(2);

		dao.fixCopy(comprehensiveTree);

		comprehensiveResultTree = dao.getNode(comprehensiveTree);
		
		assertPropertyLenientEquals("c_parentid", 2, comprehensiveResultTree);
	}

	private void getAllTree() throws Exception
	{
		l_StoredNodes = dao.getChildNodeByLeftRight(rootNode);

		Collections.sort(l_StoredNodes, new C_IdAscCompare());
	}

	static class C_IdAscCompare implements Comparator<ComprehensiveTree>
	{
		@Override
		public int compare(ComprehensiveTree tree1, ComprehensiveTree tree2)
		{
			return tree1.getC_id() < tree2.getC_id() ? -1 : tree1.getC_id() > tree2.getC_id() ? 1 : 0;
		}
	}
}
