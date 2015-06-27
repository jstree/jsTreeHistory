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

import java.io.File;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.user.vo.User;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;
import egovframework.com.ext.jstree.support.util.test.DatabaseOperations;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 6. 24.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserServiceTest.java
 * Description : 바로보드-회원 Service 테스트 클래스
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 24.   류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class UserServiceTest extends DbUnitTest<User> {

    @Autowired
    private UserService userService;
    
    private final int INIT_SEQ = 4;
    
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
    
    @DatabaseSetup("UserServiceTest.xml")
    @Test
    public void findUserByNickname() throws Exception {
        
        User notExistUser = new User();
        notExistUser.setC_title("nothing");
        
        User userStored = userService.findUserByNickname(notExistUser);
        
        assertThat(userStored, is(nullValue()));
        
        User user = new User();
        user.setC_title("어쭈구리");
        
        userStored = userService.findUserByNickname(user);
        
        compareUserInfo(userStored);
    }
    
    @DatabaseSetup("UserServiceTest.xml")
    @Test
    public void findUserByEmail() throws Exception {
        
        User notExistUser = new User();
        notExistUser.setC_title("nothing");
        
        User userStored = userService.findUserByEmail(notExistUser);
        
        assertThat(userStored, is(nullValue()));
        
        User user = new User();
        user.setEmail("admin@313.co.kr");
        
        userStored = userService.findUserByEmail(user);
        
        compareUserInfo(userStored);
    }
    
    private void compareUserInfo(User user) {
        
        assertThat(user.getC_id(), is(3));
        assertThat(user.getC_parentid(), is(2));
        assertThat(user.getC_position(), is(0));
        assertThat(user.getC_left(), is(3));
        assertThat(user.getC_right(), is(4));
        assertThat(user.getC_level(), is(2));
        assertThat(user.getC_title(), is(equalTo("어쭈구리")));
        assertThat(user.getC_type(), is(equalTo("default")));
        assertThat(user.getUserGradeCd(), is(4));
        //assertThat(userStored.getUserGrade(), is(equalTo("관리자")));
        assertThat(user.getJoinStateCd(), is(4));
        assertThat(user.getJoinState(), is(equalTo("가입완료")));
        assertThat(user.getPwdFindQuestionCd(), is(3));
        assertThat(user.getPwdFindQuestion(), is(equalTo("초등학교 이름은")));
        assertThat(user.getPassword(), is(equalTo("045babdcd2118960e8c8b8e0ecf65b734686e1b18f58710c9646779f49e942ae")));
        assertThat(user.getEmail(), is(equalTo("admin@313.co.kr")));
        assertThat(user.getLoginFailureCnt(), is(0));
        assertThat(user.getPwdFindAnswer(), is(equalTo("부원초등학교")));
        assertThat(user.getMailingServiceUseFl(), is(equalTo("1")));
        assertThat(user.getIndiInfoOpenFl(), is(equalTo("1")));
        assertThat(user.getJoinDt(), is(equalTo("20150625004822")));
        assertThat(user.getPasswordChangeDt(), is(equalTo("20150625004822")));
        assertThat(user.getLastLoginDt(), is(equalTo("20150625004000")));
        assertThat(user.getHomepageUrl(), is(equalTo(" ")));
        assertThat(user.getBlogUrl(), is(equalTo(" ")));
        assertThat(user.getSign(), is(equalTo(" ")));
        assertThat(user.getProfilePhoto(), is(equalTo(" ")));
        assertThat(user.getImageIcon(), is(equalTo(" ")));
    }
    
    @Test
    public void encryptPassword() throws Exception {
        
        String password = "abracadabra";
        
        String encryptedPassword = userService.encryptPassword(password);

        assertThat(encryptedPassword, is(equalTo("045babdcd2118960e8c8b8e0ecf65b734686e1b18f58710c9646779f49e942ae")));
    }
    
    @Ignore
    @DatabaseSetup("UserServiceTest.xml")
    @ExpectedDatabase(value = "UserServiceTest_addUser.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    @Test
    public void addUser() throws Exception {

        User user = new User();
        //user.setC_position(c_position); // TODO 류강하 : 
        user.setC_title("때찌때찌");
        user.setUserGradeCd(5);
        user.setJoinStateCd(3);
        user.setPwdFindQuestionCd(5);
        user.setPassword("맴매맴매");
        user.setEmail("never@goggle.com");
        user.setPwdFindAnswer("스파게티");
        user.setMailingServiceUseFl("0");
        user.setIndiInfoOpenFl("0");
        user.setJoinDt("20150625103922");
        user.setPasswordChangeDt("20150625103922");
        user.setHomepageUrl(" ");
        user.setBlogUrl(" ");
        user.setSign(" ");
        user.setProfilePhoto(" ");
        user.setImageIcon(" ");
        
        userService.addUser(user);
    }
    
    @Ignore
    @DatabaseSetup("UserServiceTest.xml")
    @ExpectedDatabase(value = "UserServiceTest_initUserPassword.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    @Test
    public void initUserPassword() throws Exception {
        
        User user = new User();
        user.setC_id(3);
        user.setPassword("초필살비밀번호");
        
        userService.initUserPassword(user);
    }
}