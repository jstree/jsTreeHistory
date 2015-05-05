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
package standard.mvc.component.business.baroboard.user.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import standard.mvc.component.business.baroboard.user.join.service.ProhibitionWordService;
import standard.mvc.component.business.baroboard.user.join.vo.ProhibitionWord;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;
import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;
import egovframework.com.ext.jstree.support.util.test.DatabaseOperations;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 3.
 * @version 1.0
 * @see <pre>
 * Class Name  : ProhibitionWordServiceTest.java
 * Description : 바로보드-회원관리-금지단어 Service 테스트 클래스
 * Infomation  : 바로보드-회원관리-금지단어 Service 테스트 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 5.  3.  류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebApplicationContextConfig.class, WebMvcConfig.class })
public class ProhibitionWordServiceTest extends DbUnitTest<ProhibitionWord> {
    
    @Autowired
    private ProhibitionWordService prohibitionWordService;
    
    private final String SCHEMA = "STANDARD_DB";
    private final String TABLE_NAME = "T_USER_PROH_WORD";
    private final File INIT_DATA_SET = new File(this.getClass().getResource(".").getPath() + TABLE_NAME + "_initial.xml");
    private final int INIT_SEQ = 5;
    
    @Before
    public void setUp() throws Exception {
        
        IDatabaseConnection connection = null;
        
        try {
            databaseTester = new DataSourceDatabaseTester(testDataSource, SCHEMA);
            
            IDataSet dataSet = new FlatXmlDataSetBuilder().build(INIT_DATA_SET);
            
            connection = databaseTester.getConnection();
            
            DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
            DatabaseOperations.INIT_SEQ.execute(connection, dataSet, INIT_SEQ);
            
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    @Test
    public void validateInitialTree() throws Exception {
        
        IDataSet actualDb = databaseTester.getConnection().createDataSet();
        ITable actualTable = actualDb.getTable(TABLE_NAME);
        
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(INIT_DATA_SET);
        ITable expectedTable = expectedDataSet.getTable(TABLE_NAME);
        
        Assertion.assertEquals(expectedTable, actualTable);
    }
    
    @Test
    public void selectChildrenOfFirstChildNode() throws Exception {
        
        List<ProhibitionWord> childrenOfFirstChildNode = 
                prohibitionWordService.getChildNode( getFirstChildNodeStored() );
        
        ProhibitionWord emailBranchNode = childrenOfFirstChildNode.get(0);
        
        assertThat(emailBranchNode.getC_id(), is(3));
        assertThat(emailBranchNode.getC_parentid(), is(2));
        assertThat(emailBranchNode.getC_position(), is(0));
        assertThat(emailBranchNode.getC_left(), is(3));
        assertThat(emailBranchNode.getC_right(), is(4));
        assertThat(emailBranchNode.getC_level(), is(2));
        assertThat(emailBranchNode.getC_title(), is(equalTo("이메일")));
        assertThat(emailBranchNode.getC_type(), is(equalTo("folder")));
        assertThat(emailBranchNode.getC_type_cd(), is(equalTo("A")));
        
        ProhibitionWord nicknameBranchNode = childrenOfFirstChildNode.get(1);
        
        assertThat(nicknameBranchNode.getC_id(), is(4));
        assertThat(nicknameBranchNode.getC_parentid(), is(2));
        assertThat(nicknameBranchNode.getC_position(), is(1));
        assertThat(nicknameBranchNode.getC_left(), is(5));
        assertThat(nicknameBranchNode.getC_right(), is(6));
        assertThat(nicknameBranchNode.getC_level(), is(2));
        assertThat(nicknameBranchNode.getC_title(), is(equalTo("닉네임")));
        assertThat(nicknameBranchNode.getC_type(), is(equalTo("folder")));
        assertThat(nicknameBranchNode.getC_type_cd(), is(equalTo("B")));
    }
    
    @Ignore
    @Test
    public void getEmailProhibitionWords() throws Exception {
        
        List<ComprehensiveTree> emailProhibitionWords = prohibitionWordService.getEmailProhibitionWords();
        
        assertThat(emailProhibitionWords, is(nullValue()));
    }
    
    @Ignore
    @Test
    public void getNicknameProhibitionWords() throws Exception {
        
        List<ComprehensiveTree> emailProhibitionWords = prohibitionWordService.getNicknameProhibitionWords();
        
        assertThat(emailProhibitionWords, is(nullValue()));
    }
    
    private void addEmailProhibitionWord_common() throws Exception {
        
        ProhibitionWord prohibitionWord = new ProhibitionWord();
        prohibitionWord.setRef(3);
        prohibitionWord.setC_position(0);
        prohibitionWord.setC_title("admin");
        prohibitionWord.setC_type("default");
        prohibitionWord.setC_type_cd("A"); // TODO 필요 없네 이거 c_position으로 사용하면 될 듯
        
        prohibitionWordService.addEmailProhibitionWord(prohibitionWord);
    }
    
    private void addNicknameProhibitionWord_common() throws Exception {
        
        ProhibitionWord prohibitionWord = new ProhibitionWord();
        prohibitionWord.setRef(4);
        prohibitionWord.setC_position(0);
        prohibitionWord.setC_title("관리자");
        prohibitionWord.setC_type("default");
        prohibitionWord.setC_type_cd("B"); // TODO 필요 없네 이거 c_position으로 사용하면 될 듯
        
        prohibitionWordService.addNicknameProhibitionWord(prohibitionWord);
    }
    
    @Test
    public void addEmailProhibitionWord() throws Exception {
        
        addEmailProhibitionWord_common();
        
        IDataSet actualDb = databaseTester.getConnection().createDataSet();
        ITable actualTable = actualDb.getTable(TABLE_NAME);
        
        File dataSet = new File(this.getClass().getResource(".").getPath() + TABLE_NAME + "_addEmailProhibitionWord.xml");
        
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(dataSet);
        ITable expectedTable = expectedDataSet.getTable(TABLE_NAME);
        
        Assertion.assertEquals(expectedTable, actualTable);
    }
    
    @Test
    public void addNicknameProhibitionWord() throws Exception {
        
        addNicknameProhibitionWord_common();
        
        IDataSet actualDb = databaseTester.getConnection().createDataSet();
        ITable actualTable = actualDb.getTable(TABLE_NAME);
        
        File dataSet = new File(this.getClass().getResource(".").getPath() + TABLE_NAME + "_addNicknameProhibitionWord.xml");
        
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(dataSet);
        ITable expectedTable = expectedDataSet.getTable(TABLE_NAME);
        
        Assertion.assertEquals(expectedTable, actualTable);
    }
    
    @Ignore
    @Test
    public void deleteEmailProhibitionWords() throws Exception {
        
        addEmailProhibitionWord_common();
        
        prohibitionWordService.deleteEmailProhibitionWords();
        
        IDataSet actualDb = databaseTester.getConnection().createDataSet();
        ITable actualTable = actualDb.getTable(TABLE_NAME);
        
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(INIT_DATA_SET);
        ITable expectedTable = expectedDataSet.getTable(TABLE_NAME);
        
        Assertion.assertEquals(expectedTable, actualTable);
    }
    
    @Ignore
    @Test
    public void deleteNicknameProhibitionWords() throws Exception {
        
        prohibitionWordService.deleteNicknameProhibitionWords();
        
        IDataSet actualDb = databaseTester.getConnection().createDataSet();
        ITable actualTable = actualDb.getTable(TABLE_NAME);
        
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(INIT_DATA_SET);
        ITable expectedTable = expectedDataSet.getTable(TABLE_NAME);
        
        Assertion.assertEquals(expectedTable, actualTable);
    }
    
    @Ignore
    @Test
    public void addEmailProhibitionWords() throws Exception {

        fail();
    }
    
    @Ignore
    @Test
    public void saveEmailProhibitionWords() throws Exception {
        
        fail();
    }
    
    @Ignore
    @Test
    public void addNicknameProhibitionWords() throws Exception {
        
        fail();
    }
}