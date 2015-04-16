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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.config.TestWebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;

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
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestWebApplicationContextConfig.class, WebMvcConfig.class })
public class CoreServiceTest {

    @Autowired
    private CoreService coreService;
    
    @Autowired
    private CoreDao coreDao;
    
    @Resource(name = "dataSource-${Globals.DbType}")
    private DataSource testDataSource;
    
    private IDatabaseTester databaseTester;
    
    @Before
    public void setUp() throws Exception {
        
        IDatabaseConnection connection = null;
        
        try {
            databaseTester = new DataSourceDatabaseTester(testDataSource);
            
            File xmlInputFile = new File(this.getClass().getResource(".").getPath() + "initialJsTree.xml");
            
            ReplacementDataSet dataSet = new ReplacementDataSet(new FlatXmlDataSetBuilder().build(xmlInputFile));
            dataSet.addReplacementObject("null", null);
            
            connection = databaseTester.getConnection();
            
            DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
            
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    @Test
    public void validateInitialTree() throws Exception {
        
        ComprehensiveTree nodeForSearching = new ComprehensiveTree();
        nodeForSearching.setSearchStr("");
        
        List<ComprehensiveTree> allNodes = coreDao.searchNodeByString(nodeForSearching);
        
        assertThat(allNodes.size(), is(4));
        
        ComprehensiveTree rootNode = new ComprehensiveTree();
        rootNode.setC_id(1);
        
        ComprehensiveTree rootNodeStored = coreDao.getNode(rootNode);
        
        assertThat(rootNodeStored.getC_id(), is(1));
        assertThat(rootNodeStored.getC_parentid(), is(0));
        assertThat(rootNodeStored.getC_position(), is(0));
        assertThat(rootNodeStored.getC_left(), is(1));
        assertThat(rootNodeStored.getC_right(), is(8));
        assertThat(rootNodeStored.getC_level(), is(0));
        assertThat(rootNodeStored.getC_title(), is(equalTo("Root Node")));
        assertThat(rootNodeStored.getC_type(), is(nullValue()));
        
        ComprehensiveTree firstChildNode = new ComprehensiveTree();
        firstChildNode.setC_id(2);

        ComprehensiveTree firstChildNodeStored = coreDao.getNode(firstChildNode);
        
        assertThat(firstChildNodeStored.getC_id(), is(2));
        assertThat(firstChildNodeStored.getC_parentid(), is(1));
        assertThat(firstChildNodeStored.getC_position(), is(0));
        assertThat(firstChildNodeStored.getC_left(), is(2));
        assertThat(firstChildNodeStored.getC_right(), is(7));
        assertThat(firstChildNodeStored.getC_level(), is(1));
        assertThat(firstChildNodeStored.getC_title(), is(equalTo("First Child")));
        assertThat(firstChildNodeStored.getC_type(), is(equalTo("drive")));
        
        ComprehensiveTree leafNode = new ComprehensiveTree();
        leafNode.setC_id(3);
        
        ComprehensiveTree leafNodeStored = coreDao.getNode(leafNode);
        
        assertThat(leafNodeStored.getC_id(), is(3));
        assertThat(leafNodeStored.getC_parentid(), is(2));
        assertThat(leafNodeStored.getC_position(), is(0));
        assertThat(leafNodeStored.getC_left(), is(3));
        assertThat(leafNodeStored.getC_right(), is(4));
        assertThat(leafNodeStored.getC_level(), is(2));
        assertThat(leafNodeStored.getC_title(), is(equalTo("Leaf Node")));
        assertThat(leafNodeStored.getC_type(), is(equalTo("default")));
        
        ComprehensiveTree branchNode = new ComprehensiveTree();
        branchNode.setC_id(4);
        
        ComprehensiveTree branchNodeStored = coreDao.getNode(branchNode);
        
        assertThat(branchNodeStored.getC_id(), is(4));
        assertThat(branchNodeStored.getC_parentid(), is(2));
        assertThat(branchNodeStored.getC_position(), is(1));
        assertThat(branchNodeStored.getC_left(), is(5));
        assertThat(branchNodeStored.getC_right(), is(6));
        assertThat(branchNodeStored.getC_level(), is(2));
        assertThat(branchNodeStored.getC_title(), is(equalTo("Branch Node")));
        assertThat(branchNodeStored.getC_type(), is(equalTo("folder")));
    }
}