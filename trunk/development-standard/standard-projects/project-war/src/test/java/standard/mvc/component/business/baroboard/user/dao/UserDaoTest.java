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
package standard.mvc.component.business.baroboard.user.dao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.user.vo.User;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 6. 24.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserDaoTest.java
 * Description : 바로보드-회원 DAO 테스트 클래스
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
@DatabaseSetup("UserDaoTest.xml")
public class UserDaoTest extends DbUnitTest<User> {

    @Autowired
    private UserDao userDao;

    @Resource(name = "CoreService")
    CoreService coreService;
    
    @Test
    public void selectUserByNickname() {
        
        User notExistUser = new User();
        notExistUser.setC_title("회원_정보");
        
        User userStored = userDao.selectUserByNickname(notExistUser);
        
        assertThat(userStored, is(nullValue()));
        
        User user = new User();
        user.setC_title("어쭈구리");
        
        userStored = userDao.selectUserByNickname(user);
        
        compareUserInfo(userStored);
    }
    
    @Test
    public void selectUserByEmail() {
        
        User notExistUser = new User();
        notExistUser.setEmail("nothing");
        
        User userStored = userDao.selectUserByEmail(notExistUser);
        
        assertThat(userStored, is(nullValue()));
        
        User user = new User();
        user.setEmail("admin@313.co.kr");
        
        userStored = userDao.selectUserByEmail(user);
        
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
    public void updateUserPassword() throws Exception {
        
        String passwordChangeDt = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        
        User user = new User();
        user.setC_id(3);
        user.setPassword("69c60d07173540130a5136868d4133faafd5b38a41d0d8550db99b55cdb80e8d");
        user.setPasswordChangeDt( passwordChangeDt );
        
        userDao.updateUserPassword(user);
        
        User userStored = coreService.getNode(user);
        
        assertThat(userStored.getC_id(), is(3));
        assertThat(userStored.getC_parentid(), is(2));
        assertThat(userStored.getC_position(), is(0));
        assertThat(userStored.getC_left(), is(3));
        assertThat(userStored.getC_right(), is(4));
        assertThat(userStored.getC_level(), is(2));
        assertThat(userStored.getC_title(), is(equalTo("어쭈구리")));
        assertThat(userStored.getC_type(), is(equalTo("default")));
        assertThat(userStored.getUserGradeCd(), is(4));
        assertThat(userStored.getJoinStateCd(), is(4));
        assertThat(userStored.getPwdFindQuestionCd(), is(3));
        assertThat(userStored.getPassword(), is(equalTo("69c60d07173540130a5136868d4133faafd5b38a41d0d8550db99b55cdb80e8d")));
        assertThat(userStored.getEmail(), is(equalTo("admin@313.co.kr")));
        assertThat(userStored.getLoginFailureCnt(), is(0));
        assertThat(userStored.getPwdFindAnswer(), is(equalTo("부원초등학교")));
        assertThat(userStored.getMailingServiceUseFl(), is(equalTo("1")));
        assertThat(userStored.getIndiInfoOpenFl(), is(equalTo("1")));
        assertThat(userStored.getJoinDt(), is(equalTo("20150625004822")));
        assertThat(userStored.getPasswordChangeDt(), is(equalTo(passwordChangeDt)));
        assertThat(userStored.getHomepageUrl(), is(equalTo(" ")));
        assertThat(userStored.getBlogUrl(), is(equalTo(" ")));
        assertThat(userStored.getSign(), is(equalTo(" ")));
        assertThat(userStored.getProfilePhoto(), is(equalTo(" ")));
        assertThat(userStored.getImageIcon(), is(equalTo(" ")));
    }
}