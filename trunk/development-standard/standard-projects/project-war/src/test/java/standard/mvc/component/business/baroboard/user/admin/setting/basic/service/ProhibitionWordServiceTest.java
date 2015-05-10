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
package standard.mvc.component.business.baroboard.user.admin.setting.basic.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.user.admin.setting.basic.vo.ProhibitionWord;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

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
 * 2015. 5. 3.  류강하                 최초 생성
 * 2015. 5. 8.  류강하                 리팩토링의 한계를 느껴 spring-test-dbunit을 사용하도록 변경. 중복된 설정을 부모 클래스 이동
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@DatabaseSetup("ProhibitionWordServiceTest.xml")
public class ProhibitionWordServiceTest extends DbUnitTest<ProhibitionWord> {
    
    @Autowired
    private ProhibitionWordService prohibitionWordService;
    
    private static ProhibitionWord emailProhibitionWord;
    private static ProhibitionWord nicknameProhibitionWord;
    
    private final int INIT_SEQ = 5;
    
    @BeforeClass
    public static void setUpOnce() {
        
        emailProhibitionWord = new ProhibitionWord();
        emailProhibitionWord.setRef(3);
        emailProhibitionWord.setC_position(0);
        emailProhibitionWord.setC_title("admin");
        emailProhibitionWord.setC_type("default");
        emailProhibitionWord.setTypeCd("A"); // TODO 필요 없네 이거 c_position으로 사용하면 될 듯
        
        nicknameProhibitionWord = new ProhibitionWord();
        nicknameProhibitionWord.setRef(4);
        nicknameProhibitionWord.setC_position(0);
        nicknameProhibitionWord.setC_title("관리자");
        nicknameProhibitionWord.setC_type("default");
        nicknameProhibitionWord.setTypeCd("B"); // TODO 필요 없네 이거 c_position으로 사용하면 될 듯
    }
    
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
    
    @Test
    public void selectChildrenOfFirstChildNode() throws Exception {
        
        List<ProhibitionWord> childrenOfFirstChildNode = 
                coreService.getChildNode( getFirstChildNodeStored() );
        
        ProhibitionWord emailBranchNode = childrenOfFirstChildNode.get(0);
        
        assertThat(emailBranchNode.getC_id(), is(3));
        assertThat(emailBranchNode.getC_parentid(), is(2));
        assertThat(emailBranchNode.getC_position(), is(0));
        assertThat(emailBranchNode.getC_left(), is(3));
        assertThat(emailBranchNode.getC_right(), is(4));
        assertThat(emailBranchNode.getC_level(), is(2));
        assertThat(emailBranchNode.getC_title(), is(equalTo("이메일")));
        assertThat(emailBranchNode.getC_type(), is(equalTo("folder")));
        assertThat(emailBranchNode.getTypeCd(), is(equalTo("A")));
        
        ProhibitionWord nicknameBranchNode = childrenOfFirstChildNode.get(1);
        
        assertThat(nicknameBranchNode.getC_id(), is(4));
        assertThat(nicknameBranchNode.getC_parentid(), is(2));
        assertThat(nicknameBranchNode.getC_position(), is(1));
        assertThat(nicknameBranchNode.getC_left(), is(5));
        assertThat(nicknameBranchNode.getC_right(), is(6));
        assertThat(nicknameBranchNode.getC_level(), is(2));
        assertThat(nicknameBranchNode.getC_title(), is(equalTo("닉네임")));
        assertThat(nicknameBranchNode.getC_type(), is(equalTo("folder")));
        assertThat(nicknameBranchNode.getTypeCd(), is(equalTo("B")));
    }
    
    private void addEmailProhibitionWord_common() throws Exception {

        prohibitionWordService.addEmailProhibitionWord(emailProhibitionWord);
    }
    
    private void addNicknameProhibitionWord_common() throws Exception {

        prohibitionWordService.addNicknameProhibitionWord(nicknameProhibitionWord);
    }

    @Test
    public void getEmailProhibitionWords() throws Exception {
        
        addEmailProhibitionWord_common();
        
        List<ProhibitionWord> emailProhibitionWords = prohibitionWordService.getEmailProhibitionWords();
        
        assertThat(emailProhibitionWords.size(), is(1));

        ProhibitionWord emailProhibitionWord = emailProhibitionWords.get(0);
        
        assertThat(emailProhibitionWord.getC_id(), is(5));
        assertThat(emailProhibitionWord.getC_parentid(), is(3));
        assertThat(emailProhibitionWord.getC_position(), is(0));
        assertThat(emailProhibitionWord.getC_left(), is(4));
        assertThat(emailProhibitionWord.getC_right(), is(5));
        assertThat(emailProhibitionWord.getC_level(), is(3));
        assertThat(emailProhibitionWord.getC_title(), is(equalTo("admin")));
        assertThat(emailProhibitionWord.getC_type(), is(equalTo("default"))); // TODO Enumeration 도입 필요
        assertThat(emailProhibitionWord.getTypeCd(), is(equalTo("A"))); // TODO 칼럼을 삭제할지 고민
    }
    
    @Test
    public void getNicknameProhibitionWords() throws Exception {
        
        addNicknameProhibitionWord_common();
        
        List<ProhibitionWord> nicknameProhibitionWords = prohibitionWordService.getNicknameProhibitionWords();
        
        assertThat(nicknameProhibitionWords.size(), is(1));

        ProhibitionWord nicknameProhibitionWord = nicknameProhibitionWords.get(0);
        
        assertThat(nicknameProhibitionWord.getC_id(), is(5));
        assertThat(nicknameProhibitionWord.getC_parentid(), is(4));
        assertThat(nicknameProhibitionWord.getC_position(), is(0));
        assertThat(nicknameProhibitionWord.getC_left(), is(6));
        assertThat(nicknameProhibitionWord.getC_right(), is(7));
        assertThat(nicknameProhibitionWord.getC_level(), is(3));
        assertThat(nicknameProhibitionWord.getC_title(), is(equalTo("관리자")));
        assertThat(nicknameProhibitionWord.getC_type(), is(equalTo("default"))); // TODO Enumeration 도입 필요
        assertThat(nicknameProhibitionWord.getTypeCd(), is(equalTo("B"))); // TODO 칼럼을 삭제할지 고민
    }
    
    @Test
    @ExpectedDatabase(value = "/standard/mvc/component/business/baroboard/user/admin/setting/basic/service/ProhibitionWordServiceTest_addEmailProhibitionWord.xml", assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void addEmailProhibitionWord() throws Exception {
        
        addEmailProhibitionWord_common();
    }
    
    @Test
    @ExpectedDatabase(value = "/standard/mvc/component/business/baroboard/user/admin/setting/basic/service/ProhibitionWordServiceTest_addNicknameProhibitionWord.xml", assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void addNicknameProhibitionWord() throws Exception {
        
        addNicknameProhibitionWord_common();
    }
    
    @Test
    public void deleteEmailProhibitionWords() throws Exception {
        
        addEmailProhibitionWord_common();
        
        prohibitionWordService.deleteEmailProhibitionWords();
    }
    
    @Test
    public void deleteNicknameProhibitionWords() throws Exception {
        
        addNicknameProhibitionWord_common();
        
        prohibitionWordService.deleteNicknameProhibitionWords();
    }
    
    @Test
    @ExpectedDatabase(value = "/standard/mvc/component/business/baroboard/user/admin/setting/basic/service/ProhibitionWordServiceTest_addEmailProhibitionWord.xml", assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void saveEmailProhibitionWords() throws Exception {

        List<ProhibitionWord> emailProhibitionWords = new ArrayList<ProhibitionWord>();

        emailProhibitionWords.add( emailProhibitionWord );
        
        int affectedRowCount = prohibitionWordService.saveEmailProhibitionWords( emailProhibitionWords );
        
        assertThat(affectedRowCount, is(emailProhibitionWords.size()));
    }
    
    @Test
    @ExpectedDatabase(value = "/standard/mvc/component/business/baroboard/user/admin/setting/basic/service/ProhibitionWordServiceTest_addNicknameProhibitionWord.xml", assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void saveNicknameProhibitionWords() throws Exception {

        List<ProhibitionWord> nicknameProhibitionWords = new ArrayList<ProhibitionWord>();

        nicknameProhibitionWords.add( nicknameProhibitionWord );
        
        int affectedRowCount = prohibitionWordService.saveNicknameProhibitionWords( nicknameProhibitionWords );
        
        assertThat(affectedRowCount, is(nicknameProhibitionWords.size()));
    }
}