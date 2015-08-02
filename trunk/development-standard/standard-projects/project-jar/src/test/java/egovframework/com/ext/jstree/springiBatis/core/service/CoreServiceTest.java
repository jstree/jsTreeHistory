/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.com.ext.jstree.springiBatis.core.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.springiBatis.core.vo.PaginatedComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;
import egovframework.com.ext.jstree.support.util.test.DatabaseOperations;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 2. 26.
 * @version 1.0
 * @see <pre>
 * Class Name  : CoreServiceTest.java
 * Description : JsTree Spring+iBATIS 버젼의 JUnit4 테스트 클래스
 * Infomation  : JsTree 코어 서비스 로직을 검증하는 테스트
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 2. 26.  류강하                 최초 생성
 * 2015. 4. 17.  류강하                 기존 환경을 건드리지 않고 상속 및 확장하여 테스트하도록 변경함. 메이븐 빌드와는 무관하게 동작할 것임.
 * 2015. 4. 19.  류강하                 Leaf Node Add Node 테스트 케이스 추가
 * 2015. 5.  1.  류강하                 시퀀스를 초기화하도록 하여 c_id 검증 단정문 성공하도록 변경(DatabaseOperation의 확장 포인트를 찾기가 어려워 추후에 개선 예정)
 * 2015. 8.  2.  류강하                 getChildNode의 페이징 처리 옵션 테스트 추가
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@DatabaseSetup("CoreServiceTest.xml")
public class CoreServiceTest extends DbUnitTest<ComprehensiveTree> {
    
    private final int INIT_SEQ = 5;
    
    @Before
    public void setUp() throws Exception {
        
        IDatabaseConnection connection = null;
        
        try {
            databaseTester = new DataSourceDatabaseTester(dataSource);
            
            File dataSetFile = new File(getClass().getResource(".").getPath() + getClass().getSimpleName() + ".xml");
            
            IDataSet dataSet = new FlatXmlDataSetBuilder().build(dataSetFile);
            
            connection = databaseTester.getConnection();
            
            DatabaseOperations.INIT_SEQ.execute(connection, dataSet, INIT_SEQ);
            
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    private ComprehensiveTree getInitialLeafNode() {
        
        ComprehensiveTree leafNode = new ComprehensiveTree();
        leafNode.setC_id(3);
        
        return leafNode;
    }
    
    private ComprehensiveTree getInitialLeafNodeStored() throws Exception {
        
        return coreService.getNode( getInitialLeafNode() );
    }
    
    private ComprehensiveTree getInitialBranchNode() {
        
        ComprehensiveTree branchNode = new ComprehensiveTree();
        branchNode.setC_id(4);
        
        return branchNode;
    }
    
    private ComprehensiveTree getInitialBranchNodeStored() throws Exception {
        
        return coreService.getNode( getInitialBranchNode() );
    }
    
    @ExpectedDatabase(value = "CoreServiceTest.xml", assertionMode=DatabaseAssertionMode.NON_STRICT)
    @Test
    public void validateInitialTree() throws Exception {
        
//      I|    L    R
//      1|    1    8 : Root Node
//      2|     2  7  : First Child Node
//      3|      34   : Leaf Node
//      4|      56   : Branch Node
    }
    
    @ExpectedDatabase(value = "CoreServiceTest_addNewLeafNodeToRootNode.xml", assertionMode=DatabaseAssertionMode.NON_STRICT)
    @Test
    public void addNewLeafNodeToFirstChildNode() throws Exception {
        
        //ComprehensiveTree firstChildNode = coreService.getChildNode( getRootNode() ).get(0);
        List<ComprehensiveTree> firstChildNodes = coreService.getChildNode( getRootNode() );
        ComprehensiveTree firstChildNode = firstChildNodes.get(0);
        

        List<ComprehensiveTree> childrenOfFirstChildNode = coreService.getChildNode(firstChildNode);
        
        assertThat(childrenOfFirstChildNode.size(), is(2));
        
        ComprehensiveTree newLeafNode = new ComprehensiveTree();
        newLeafNode.setRef( firstChildNode.getC_id() );
        newLeafNode.setC_position( childrenOfFirstChildNode.size() );
        newLeafNode.setC_title( "New Leaf Node" );
        newLeafNode.setC_type( "default" );
        
        coreService.addNode(newLeafNode);

//      I|    L    R
//      1|    1    10 : Root Node
//      2|     2  9   : First Child Node
//      3|      34    : Leaf Node
//      4|      56    : Branch Node
//      5|      78    : New Leaf Node
    }
    
    @DatabaseSetup("CoreServiceTest_initialJsTreeForPagination.xml")
    @Test
    public void getChildNode() throws Exception {
        
        ComprehensiveTree comprehensiveTree = new ComprehensiveTree();
        
        comprehensiveTree.setC_id(1);
        List<ComprehensiveTree> childNodes = coreService.getChildNode(comprehensiveTree);
        assertThat(childNodes.size(), is(1));
        assertThat(childNodes.get(0).getC_id(), is(2));
        
        comprehensiveTree.setC_id(2);
        childNodes = coreService.getChildNode(comprehensiveTree);
        assertThat(childNodes.size(), is(2));
        assertThat(childNodes.get(0).getC_id(), is(3));
        assertThat(childNodes.get(1).getC_id(), is(4));
        
        comprehensiveTree.setC_id(3);
        childNodes = coreService.getChildNode(comprehensiveTree);
        assertThat(childNodes.size(), is(2));
        assertThat(childNodes.get(0).getC_id(), is(5));
        assertThat(childNodes.get(1).getC_id(), is(6));
        
        comprehensiveTree.setC_id(4);
        childNodes = coreService.getChildNode(comprehensiveTree);
        assertThat(childNodes.size(), is(2));
        assertThat(childNodes.get(0).getC_id(), is(9));
        assertThat(childNodes.get(1).getC_id(), is(12));
        
        comprehensiveTree.setC_id(5);
        childNodes = coreService.getChildNode(comprehensiveTree);
        assertThat(childNodes.size(), is(2));
        assertThat(childNodes.get(0).getC_id(), is(7));
        assertThat(childNodes.get(1).getC_id(), is(8));
        
        comprehensiveTree.setC_id(6);
        childNodes = coreService.getChildNode(comprehensiveTree);
        assertThat(childNodes.size(), is(1));
        assertThat(childNodes.get(0).getC_id(), is(10));
        
        comprehensiveTree.setC_id(7);
        assertThatChildNodesAreNothing(comprehensiveTree);
        
        comprehensiveTree.setC_id(8);
        assertThatChildNodesAreNothing(comprehensiveTree);
        
        comprehensiveTree.setC_id(9);
        assertThatChildNodesAreNothing(comprehensiveTree);
        
        comprehensiveTree.setC_id(10);
        childNodes = coreService.getChildNode(comprehensiveTree);
        assertThat(childNodes.size(), is(3));
        assertThat(childNodes.get(0).getC_id(), is(11));
        assertThat(childNodes.get(1).getC_id(), is(13));
        assertThat(childNodes.get(2).getC_id(), is(14));
        
        comprehensiveTree.setC_id(11);
        assertThatChildNodesAreNothing(comprehensiveTree);
        
        comprehensiveTree.setC_id(12);
        assertThatChildNodesAreNothing(comprehensiveTree);
        
        comprehensiveTree.setC_id(13);
        assertThatChildNodesAreNothing(comprehensiveTree);
        
        comprehensiveTree.setC_id(14);
        assertThatChildNodesAreNothing(comprehensiveTree);
    }
    
    private void assertThatChildNodesAreNothing(ComprehensiveTree comprehensiveTree) throws Exception {
        
        List<ComprehensiveTree> childNodes = coreService.getChildNode(comprehensiveTree);
        assertTrue(childNodes.isEmpty());
    }
    
    @DatabaseSetup("CoreServiceTest_initialJsTreeForPagination.xml")
    @Test
    public void getDescendantNodesPaginatedWithLevel5() throws Exception {
        
        PaginatedComprehensiveTree paginatedComprehensiveTree = new PaginatedComprehensiveTree();
        paginatedComprehensiveTree.setC_level(5);
        
        List<PaginatedComprehensiveTree> descendantNodes = coreService.getChildNode(paginatedComprehensiveTree);
        
        assertThat(descendantNodes.size(), is(10));
        assertThat(descendantNodes.get(0).getC_id(), is(2));
        assertThat(descendantNodes.get(0).getC_title(), is("First Child"));
        assertThat(descendantNodes.get(1).getC_id(), is(3));
        assertThat(descendantNodes.get(1).getC_title(), is("A"));
        assertThat(descendantNodes.get(2).getC_id(), is(5));
        assertThat(descendantNodes.get(2).getC_title(), is("AA"));
        assertThat(descendantNodes.get(3).getC_id(), is(7));
        assertThat(descendantNodes.get(3).getC_title(), is("AAA"));
        assertThat(descendantNodes.get(4).getC_id(), is(8));
        assertThat(descendantNodes.get(4).getC_title(), is("AAB"));
        assertThat(descendantNodes.get(5).getC_id(), is(6));
        assertThat(descendantNodes.get(5).getC_title(), is("AB"));
        assertThat(descendantNodes.get(6).getC_id(), is(10));
        assertThat(descendantNodes.get(6).getC_title(), is("ABA"));
        assertThat(descendantNodes.get(7).getC_id(), is(11));
        assertThat(descendantNodes.get(7).getC_title(), is("ABAA"));
        assertThat(descendantNodes.get(8).getC_id(), is(13));
        assertThat(descendantNodes.get(8).getC_title(), is("ABAB"));
        assertThat(descendantNodes.get(9).getC_id(), is(14));
        assertThat(descendantNodes.get(9).getC_title(), is("ABAC"));
        
        paginatedComprehensiveTree.setCurrentPage(2);
        
        descendantNodes = coreService.getChildNode(paginatedComprehensiveTree);
        
        assertThat(descendantNodes.size(), is(3));
        assertThat(descendantNodes.get(0).getC_id(), is(4));
        assertThat(descendantNodes.get(0).getC_title(), is("B"));
        assertThat(descendantNodes.get(1).getC_id(), is(9));
        assertThat(descendantNodes.get(1).getC_title(), is("BA"));
        assertThat(descendantNodes.get(2).getC_id(), is(12));
        assertThat(descendantNodes.get(2).getC_title(), is("BB"));
    }
    
    @DatabaseSetup("CoreServiceTest_initialJsTreeForPagination.xml")
    @Test
    public void getDescendantNodesPaginatedWithLevel4() throws Exception {
        
        PaginatedComprehensiveTree paginatedComprehensiveTree = new PaginatedComprehensiveTree();
        paginatedComprehensiveTree.setC_level(4);
        
        List<PaginatedComprehensiveTree> descendantNodes = coreService.getChildNode(paginatedComprehensiveTree);
        
        assertThat(descendantNodes.size(), is(10));
        assertThat(descendantNodes.get(0).getC_id(), is(2));
        assertThat(descendantNodes.get(0).getC_title(), is("First Child"));
        assertThat(descendantNodes.get(1).getC_id(), is(3));
        assertThat(descendantNodes.get(1).getC_title(), is("A"));
        assertThat(descendantNodes.get(2).getC_id(), is(5));
        assertThat(descendantNodes.get(2).getC_title(), is("AA"));
        assertThat(descendantNodes.get(3).getC_id(), is(7));
        assertThat(descendantNodes.get(3).getC_title(), is("AAA"));
        assertThat(descendantNodes.get(4).getC_id(), is(8));
        assertThat(descendantNodes.get(4).getC_title(), is("AAB"));
        assertThat(descendantNodes.get(5).getC_id(), is(6));
        assertThat(descendantNodes.get(5).getC_title(), is("AB"));
        assertThat(descendantNodes.get(6).getC_id(), is(10));
        assertThat(descendantNodes.get(6).getC_title(), is("ABA"));
        assertThat(descendantNodes.get(7).getC_id(), is(4));
        assertThat(descendantNodes.get(7).getC_title(), is("B"));
        assertThat(descendantNodes.get(8).getC_id(), is(9));
        assertThat(descendantNodes.get(8).getC_title(), is("BA"));
        assertThat(descendantNodes.get(9).getC_id(), is(12));
        assertThat(descendantNodes.get(9).getC_title(), is("BB"));
        
        paginatedComprehensiveTree.setCurrentPage(2);
        
        descendantNodes = coreService.getChildNode(paginatedComprehensiveTree);
        
        assertTrue(descendantNodes.isEmpty());
    }
    
    @DatabaseSetup("CoreServiceTest_initialJsTreeForPagination.xml")
    @Test
    public void getDescendantNodesPaginatedWithLevel3() throws Exception {
        
        PaginatedComprehensiveTree paginatedComprehensiveTree = new PaginatedComprehensiveTree();
        paginatedComprehensiveTree.setC_level(3);
        
        List<PaginatedComprehensiveTree> descendantNodes = coreService.getChildNode(paginatedComprehensiveTree);
        
        assertThat(descendantNodes.size(), is(7));
        assertThat(descendantNodes.get(0).getC_id(), is(2));
        assertThat(descendantNodes.get(0).getC_title(), is("First Child"));
        assertThat(descendantNodes.get(1).getC_id(), is(3));
        assertThat(descendantNodes.get(1).getC_title(), is("A"));
        assertThat(descendantNodes.get(2).getC_id(), is(5));
        assertThat(descendantNodes.get(2).getC_title(), is("AA"));
        assertThat(descendantNodes.get(3).getC_id(), is(6));
        assertThat(descendantNodes.get(3).getC_title(), is("AB"));
        assertThat(descendantNodes.get(4).getC_id(), is(4));
        assertThat(descendantNodes.get(4).getC_title(), is("B"));
        assertThat(descendantNodes.get(5).getC_id(), is(9));
        assertThat(descendantNodes.get(5).getC_title(), is("BA"));
        assertThat(descendantNodes.get(6).getC_id(), is(12));
        assertThat(descendantNodes.get(6).getC_title(), is("BB"));
    }
}