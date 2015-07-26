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
        
        return coreDao.getNode( getInitialLeafNode() );
    }
    
    private ComprehensiveTree getInitialBranchNode() {
        
        ComprehensiveTree branchNode = new ComprehensiveTree();
        branchNode.setC_id(4);
        
        return branchNode;
    }
    
    private ComprehensiveTree getInitialBranchNodeStored() throws Exception {
        
        return coreDao.getNode( getInitialBranchNode() );
    }
    
    @Test
    public void validateInitialTree() throws Exception {
        
//      I|    L    R
//      1|    1    8 : Root Node
//      2|     2  7  : First Child Node
//      3|      34   : Leaf Node
//      4|      56   : Branch Node
    }
    
    @Test                      
    @ExpectedDatabase(value = "/egovframework/com/ext/jstree/springiBatis/core/service/CoreServiceTest_addNewLeafNodeToRootNode.xml", assertionMode=DatabaseAssertionMode.NON_STRICT)
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
        newLeafNode.setC_type( "default" ); // TODO Enumeration 도입 필요
        
        coreService.addNode(newLeafNode);

//      I|    L    R
//      1|    1    10 : Root Node
//      2|     2  9   : First Child Node
//      3|      34    : Leaf Node
//      4|      56    : Branch Node
//      5|      78    : New Leaf Node
    }
}