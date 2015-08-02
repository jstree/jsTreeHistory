package egovframework.com.ext.jstree.springiBatis.core.dao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.unitils.reflectionassert.ReflectionAssert.assertLenientEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyLenientEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.springiBatis.core.vo.PaginatedComprehensiveTree;
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
 *  2015.04.23    HyungChae.Kim         테스트DB, Spring DbUnit으로 설정변경 및 단위 테스트 추가
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@WebAppConfiguration
@ContextConfiguration(classes = { WebApplicationContextConfig.class, WebMvcConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class CoreDaoTest
{
	@Autowired 
	private CoreDao dao;

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
		rootNode.setC_type("root");

		firstChild = new ComprehensiveTree();
		firstChild.setC_id(2);
		firstChild.setC_parentid(1);
		firstChild.setC_position(0);
		firstChild.setC_left(2);
		firstChild.setC_right(7);
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
		branchNode.setC_parentid(2);
		branchNode.setC_position(1);
		branchNode.setC_left(5);
		branchNode.setC_right(6);
		branchNode.setC_level(2);
		branchNode.setC_title("Branch Node");
		branchNode.setC_type("folder");
	}
	
	@Test
	@DatabaseSetup("initialJsTree.xml")
	public void testGetChildNode() throws Exception
	{
		comprehensiveTree.setC_id(1);
		
		l_StoredNodes = dao.getChildNode(comprehensiveTree);

		firstChild.setChildcount("InChild");
		branchNode.setChildcount("NoChild");

		assertThat(l_StoredNodes.size(), is(1));
		assertLenientEquals(l_StoredNodes.get(0), firstChild);
	}

	@Test
	@DatabaseSetup("initialJsTree.xml")
	public void testSearchNodeByString() throws Exception
	{
		comprehensiveTree.setC_title("");
		
		l_StoredNodes = dao.searchNodeByString(comprehensiveTree);

		assertThat(l_StoredNodes.size(), is(4));
	}

	@Test
	@DatabaseSetup("initialJsTree.xml")
	public void testSearchNodeByPosition() throws Exception
	{
		comprehensiveTree.setC_id(2);
		
		l_StoredNodes = dao.getChildNode(comprehensiveTree);
		l_StoredStrings = dao.searchNodeByPosition(l_StoredNodes);

		assertThat(l_StoredStrings.size(), is(4));
		assertThat(l_StoredStrings.get(0), is(equalTo("3")));
		assertThat(l_StoredStrings.get(1), is(equalTo("4")));
	}

	@Test
	@DatabaseSetup("initialJsTree.xml")
	public void testGetNode() throws Exception
	{
		comprehensiveTree.setC_id(3);
		
		comprehensiveResultTree = dao.getNode(comprehensiveTree);

		assertLenientEquals(comprehensiveResultTree, leafNode);
	}

	@Test
	@DatabaseSetup("initialJsTree.xml")
	public void testGetNodeByRef() throws Exception
	{
		comprehensiveTree.setRef(2);
		
		comprehensiveResultTree = dao.getNodeByRef(comprehensiveTree);

		assertLenientEquals(comprehensiveResultTree, firstChild);
	}

	@Test
	@DatabaseSetup("initialJsTree.xml")
	@ExpectedDatabase(value="cutMyselfAfterDataset.xml",assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testCutMyself() throws Exception
	{
		c_idsByChildNodeFromNodeById = new ArrayList<>();
		c_idsByChildNodeFromNodeById.add(3);

		firstChild.setSpaceOfTargetNode(spaceOfTargetNode);
		firstChild.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);

		dao.cutMyself(firstChild);
	}

	@Test
	@DatabaseSetup("initialJsTree.xml")
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
	@DatabaseSetup("initialJsTree.xml")
	@ExpectedDatabase(value="stretchLeftRightForMyselfFromJstreeAfterDataset.xml",assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testStretchLeftRightForMyselfFromJstree() throws Exception
	{
		comprehensiveTree.setSpaceOfTargetNode(spaceOfTargetNode);
		comprehensiveTree.setRightPositionFromNodeByRef(5);
		comprehensiveTree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
		comprehensiveTree.setCopy(0);

		dao.stretchLeftRightForMyselfFromJstree(comprehensiveTree);
	}

	@Test
	@DatabaseSetup("initialJsTree.xml")
	@ExpectedDatabase(value="pasteMyselfFromJstreeAfterDataset.xml",assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
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
	}

	@Test
	@DatabaseSetup("initialJsTree.xml")
	public void testGetChildNodeByLeftRight() throws Exception
	{
		l_StoredNodes = dao.getChildNodeByLeftRight(firstChild);

		assertLenientEquals(l_StoredNodes.get(0), firstChild);
		assertLenientEquals(l_StoredNodes.get(1), leafNode);
	}

	@Test
	@DatabaseSetup("initialJsTree.xml")
	public void testFixCopy() throws Exception
	{
		comprehensiveTree.setC_id(4);
		comprehensiveTree.setFixCopyId(2);

		dao.fixCopy(comprehensiveTree);

		comprehensiveResultTree = dao.getNode(comprehensiveTree);
		
		assertPropertyLenientEquals("c_parentid", 2, comprehensiveResultTree);
	}
	
	@Test
	@DatabaseSetup("initialJsTree.xml")
	public void testFixCopyIf() throws Exception
	{
		comprehensiveTree.setC_id(4);
		comprehensiveTree.setFixCopyId(4);
		comprehensiveTree.setFixCopyPosition(0);

		dao.fixCopyIF(comprehensiveTree);

		comprehensiveResultTree = dao.getNode(comprehensiveTree);
		
		assertPropertyLenientEquals("c_position", 0, comprehensiveResultTree);
	}
	
	@Test
	@DatabaseSetup("initialJsTree.xml")
	public void testAlterNode() throws Exception
	{
		comprehensiveTree.setC_id(4);
		comprehensiveTree.setC_type("default");
		comprehensiveTree.setC_title("leaf Node");

		dao.alterNode(comprehensiveTree);

		comprehensiveResultTree = dao.getNode(comprehensiveTree);
		
		assertPropertyLenientEquals("c_type", "default", comprehensiveResultTree);
		assertPropertyLenientEquals("c_title", "leaf Node", comprehensiveResultTree);
	}
	
	@Test
	@DatabaseSetup("initialJsTree.xml")
	@ExpectedDatabase(value="removeNodeAfterDataset.xml",assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testRemoveNode() throws Exception
	{
        int spaceOfTargetNode = firstChild.getC_right() - firstChild.getC_left()+1;
        
        firstChild.setSpaceOfTargetNode(spaceOfTargetNode);
        
        dao.removeNode(firstChild);
	}
	
	@Test
	@DatabaseSetup("initialJsTree.xml")
	public void testAlterNodeType() throws Exception
	{
		comprehensiveTree.setC_id(4);
		comprehensiveTree.setC_type("default");

		dao.alterNodeType(comprehensiveTree);

		comprehensiveResultTree = dao.getNode(comprehensiveTree);
		
		assertPropertyLenientEquals("c_type", "default", comprehensiveResultTree);
	}
	
	@Test
	@DatabaseSetup("initialJsTree.xml")
	public void testEnterMyselfFixPosition() throws Exception
	{
		comprehensiveTree.setC_id(4);
		comprehensiveTree.setRef(2);
		comprehensiveTree.setC_position(1);

		dao.enterMyselfFixPosition(comprehensiveTree);

		comprehensiveResultTree = dao.getNode(comprehensiveTree);
		
		assertPropertyLenientEquals("c_parentid", 2, comprehensiveResultTree);
		assertPropertyLenientEquals("c_position", 1, comprehensiveResultTree);
	}
	
	@Test
    @DatabaseSetup("initialJsTreeForPagination.xml")
    public void getCountOfDescendantNodes() {
        
        ComprehensiveTree comprehensiveTree = new ComprehensiveTree();
        
        comprehensiveTree.setC_level(2);
        int countOfDescendantNodes = dao.getCountOfDescendantNodes(comprehensiveTree);
        assertThat(countOfDescendantNodes, is(3));
        
        comprehensiveTree.setC_level(3);
        countOfDescendantNodes = dao.getCountOfDescendantNodes(comprehensiveTree);
        assertThat(countOfDescendantNodes, is(7));
        
        comprehensiveTree.setC_level(4);
        countOfDescendantNodes = dao.getCountOfDescendantNodes(comprehensiveTree);
        assertThat(countOfDescendantNodes, is(10));
        
        comprehensiveTree.setC_level(5);
        countOfDescendantNodes = dao.getCountOfDescendantNodes(comprehensiveTree);
        assertThat(countOfDescendantNodes, is(13));
    }
	
	@Test
	@DatabaseSetup("initialJsTreeForPagination.xml")
    public void getDescendantNodesPaginated() {
	    
	    PaginatedComprehensiveTree comprehensiveTree = new PaginatedComprehensiveTree();
	    comprehensiveTree.setC_level(5);
	    
	    comprehensiveTree.setBeginningRowOfRange(0);
	    comprehensiveTree.setEndRowOfRange(10);
	    
	    List<PaginatedComprehensiveTree> descendantNodes = dao.getDescendantNodesPaginated(comprehensiveTree);
	    
	    assertThat(descendantNodes.size(), is(10));
	    assertThat(descendantNodes.get(0).getC_id(), is(2));
	    assertThat(descendantNodes.get(1).getC_id(), is(3));
	    assertThat(descendantNodes.get(2).getC_id(), is(5));
	    assertThat(descendantNodes.get(3).getC_id(), is(7));
	    assertThat(descendantNodes.get(4).getC_id(), is(8));
	    assertThat(descendantNodes.get(5).getC_id(), is(6));
	    assertThat(descendantNodes.get(6).getC_id(), is(10));
	    assertThat(descendantNodes.get(7).getC_id(), is(11));
	    assertThat(descendantNodes.get(8).getC_id(), is(13));
	    assertThat(descendantNodes.get(9).getC_id(), is(14));
	    
	    comprehensiveTree.setBeginningRowOfRange(10);
        comprehensiveTree.setEndRowOfRange(20);
        
        descendantNodes = dao.getDescendantNodesPaginated(comprehensiveTree);
        
        assertThat(descendantNodes.size(), is(3));
        assertThat(descendantNodes.get(0).getC_id(), is(4));
        assertThat(descendantNodes.get(1).getC_id(), is(9));
        assertThat(descendantNodes.get(2).getC_id(), is(12));
	}
}