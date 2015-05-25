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
package standard.mvc.component.business.baroboard.user.manage.basic.setting.joinfield.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.joinfield.vo.JoinField;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : JoinFieldServiceTest.java
 * Description : 바로보드-회원관리-기본설정-회원가입필드  Service 테스트 클래스
 * Infomation  : 바로보드-회원관리-기본설정-회원가입필드  Service 테스트 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 25.      류강하       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@DatabaseSetup("JoinFieldServiceTest.xml")
public class JoinFieldServiceTest extends DbUnitTest<JoinField> {

    @Autowired
    private JoinFieldService joinFieldService;
    
    @Test
    public void getJoinFields() throws Exception {
        
        List<JoinField> joinFields = joinFieldService.getJoinFields();
        
        assertThat(joinFields.size(), is(9));
        
        JoinField email = joinFields.get(0);
        
        assertThat(email.getC_id(), is(3));
        assertThat(email.getC_parentid(), is(2));
        assertThat(email.getC_position(), is(0));
        assertThat(email.getC_left(), is(3));
        assertThat(email.getC_right(), is(4));
        assertThat(email.getC_level(), is(2));
        assertThat(email.getC_title(), is(equalTo("이메일 주소")));
        assertThat(email.getC_type(), is(equalTo("default")));
        assertThat(email.getUseFl(), is(equalTo("1")));
        assertThat(email.getInfoOpenFl(), is(equalTo("1")));
        assertThat(email.getEsseInputFl(), is(equalTo("1")));
        
        JoinField password = joinFields.get(1);
        
        assertThat(password.getC_id(), is(4));
        assertThat(password.getC_parentid(), is(2));
        assertThat(password.getC_position(), is(1));
        assertThat(password.getC_left(), is(5));
        assertThat(password.getC_right(), is(6));
        assertThat(password.getC_level(), is(2));
        assertThat(password.getC_title(), is(equalTo("비밀번호")));
        assertThat(password.getC_type(), is(equalTo("default")));
        assertThat(password.getUseFl(), is(equalTo("1")));
        assertThat(password.getInfoOpenFl(), is(equalTo("0")));
        assertThat(password.getEsseInputFl(), is(equalTo("1")));
        
        JoinField nickname = joinFields.get(2);
        
        assertThat(nickname.getC_id(), is(5));
        assertThat(nickname.getC_parentid(), is(2));
        assertThat(nickname.getC_position(), is(2));
        assertThat(nickname.getC_left(), is(7));
        assertThat(nickname.getC_right(), is(8));
        assertThat(nickname.getC_level(), is(2));
        assertThat(nickname.getC_title(), is(equalTo("닉네임")));
        assertThat(nickname.getC_type(), is(equalTo("default")));
        assertThat(nickname.getUseFl(), is(equalTo("1")));
        assertThat(nickname.getInfoOpenFl(), is(equalTo("1")));
        assertThat(nickname.getEsseInputFl(), is(equalTo("1")));
        
        JoinField passwordFinding = joinFields.get(3);
        
        assertThat(passwordFinding.getC_id(), is(6));
        assertThat(passwordFinding.getC_parentid(), is(2));
        assertThat(passwordFinding.getC_position(), is(3));
        assertThat(passwordFinding.getC_left(), is(9));
        assertThat(passwordFinding.getC_right(), is(10));
        assertThat(passwordFinding.getC_level(), is(2));
        assertThat(passwordFinding.getC_title(), is(equalTo("비밀번호 찾기 질문/답변")));
        assertThat(passwordFinding.getC_type(), is(equalTo("default")));
        assertThat(passwordFinding.getUseFl(), is(equalTo("1")));
        assertThat(passwordFinding.getInfoOpenFl(), is(equalTo("0")));
        assertThat(passwordFinding.getEsseInputFl(), is(equalTo("1")));
        
        JoinField homepage = joinFields.get(4);
        
        assertThat(homepage.getC_id(), is(7));
        assertThat(homepage.getC_parentid(), is(2));
        assertThat(homepage.getC_position(), is(4));
        assertThat(homepage.getC_left(), is(11));
        assertThat(homepage.getC_right(), is(12));
        assertThat(homepage.getC_level(), is(2));
        assertThat(homepage.getC_title(), is(equalTo("홈페이지")));
        assertThat(homepage.getC_type(), is(equalTo("default")));
        assertThat(homepage.getUseFl(), is(equalTo("1")));
        assertThat(homepage.getInfoOpenFl(), is(equalTo("1")));
        assertThat(homepage.getEsseInputFl(), is(equalTo("1")));
        
        JoinField blog = joinFields.get(5);
        
        assertThat(blog.getC_id(), is(8));
        assertThat(blog.getC_parentid(), is(2));
        assertThat(blog.getC_position(), is(5));
        assertThat(blog.getC_left(), is(13));
        assertThat(blog.getC_right(), is(14));
        assertThat(blog.getC_level(), is(2));
        assertThat(blog.getC_title(), is(equalTo("블로그")));
        assertThat(blog.getC_type(), is(equalTo("default")));
        assertThat(blog.getUseFl(), is(equalTo("1")));
        assertThat(blog.getInfoOpenFl(), is(equalTo("1")));
        assertThat(blog.getEsseInputFl(), is(equalTo("1")));
        
        JoinField sign = joinFields.get(6);
        
        assertThat(sign.getC_id(), is(9));
        assertThat(sign.getC_parentid(), is(2));
        assertThat(sign.getC_position(), is(6));
        assertThat(sign.getC_left(), is(15));
        assertThat(sign.getC_right(), is(16));
        assertThat(sign.getC_level(), is(2));
        assertThat(sign.getC_title(), is(equalTo("서명")));
        assertThat(sign.getC_type(), is(equalTo("default")));
        assertThat(sign.getUseFl(), is(equalTo("1")));
        assertThat(sign.getInfoOpenFl(), is(equalTo("1")));
        assertThat(sign.getEsseInputFl(), is(equalTo("1")));
        
        JoinField profilePhoto = joinFields.get(7);
        
        assertThat(profilePhoto.getC_id(), is(10));
        assertThat(profilePhoto.getC_parentid(), is(2));
        assertThat(profilePhoto.getC_position(), is(7));
        assertThat(profilePhoto.getC_left(), is(17));
        assertThat(profilePhoto.getC_right(), is(18));
        assertThat(profilePhoto.getC_level(), is(2));
        assertThat(profilePhoto.getC_title(), is(equalTo("프로필사진")));
        assertThat(profilePhoto.getC_type(), is(equalTo("default")));
        assertThat(profilePhoto.getUseFl(), is(equalTo("1")));
        assertThat(profilePhoto.getInfoOpenFl(), is(equalTo("1")));
        assertThat(profilePhoto.getEsseInputFl(), is(equalTo("1")));
        
        JoinField imageIcon = joinFields.get(8);
        
        assertThat(imageIcon.getC_id(), is(11));
        assertThat(imageIcon.getC_parentid(), is(2));
        assertThat(imageIcon.getC_position(), is(8));
        assertThat(imageIcon.getC_left(), is(19));
        assertThat(imageIcon.getC_right(), is(20));
        assertThat(imageIcon.getC_level(), is(2));
        assertThat(imageIcon.getC_title(), is(equalTo("사용자아이콘")));
        assertThat(imageIcon.getC_type(), is(equalTo("default")));
        assertThat(imageIcon.getUseFl(), is(equalTo("1")));
        assertThat(imageIcon.getInfoOpenFl(), is(equalTo("1")));
        assertThat(imageIcon.getEsseInputFl(), is(equalTo("1")));
    }
    
    @Test
    @ExpectedDatabase(value = "JoinFieldServiceTest_saveJoinFields.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void saveJoinFields() throws Exception {
        
        List<JoinField> joinFields = new ArrayList<JoinField>();
        
        JoinField email = new JoinField();
        email.setC_id(3);
        email.setUseFl("1");
        email.setInfoOpenFl("0");
        email.setEsseInputFl("1");
        
        joinFields.add(email);
        
        JoinField password = new JoinField();
        password.setC_id(4);
        password.setUseFl("1");
        password.setInfoOpenFl("0");
        password.setEsseInputFl("1");
        
        joinFields.add(password);
        
        JoinField nickname = new JoinField();
        nickname.setC_id(5);
        nickname.setUseFl("1");
        nickname.setInfoOpenFl("1");
        nickname.setEsseInputFl("1");
        
        joinFields.add(nickname);
        
        JoinField passwordFinding = new JoinField();
        passwordFinding.setC_id(6);
        passwordFinding.setUseFl("0");
        passwordFinding.setInfoOpenFl("0");
        passwordFinding.setEsseInputFl("0");
        
        joinFields.add(passwordFinding);
        
        JoinField homepage = new JoinField();
        homepage.setC_id(7);
        homepage.setUseFl("0");
        homepage.setInfoOpenFl("0");
        homepage.setEsseInputFl("0");
        
        joinFields.add(homepage);
        
        JoinField blog = new JoinField();
        blog.setC_id(8);
        blog.setUseFl("0");
        blog.setInfoOpenFl("0");
        blog.setEsseInputFl("0");
        
        joinFields.add(blog);
        
        JoinField sign = new JoinField();
        sign.setC_id(9);
        sign.setUseFl("0");
        sign.setInfoOpenFl("0");
        sign.setEsseInputFl("0");
        
        joinFields.add(sign);
        
        JoinField profilePhoto = new JoinField();
        profilePhoto.setC_id(10);
        profilePhoto.setUseFl("0");
        profilePhoto.setInfoOpenFl("0");
        profilePhoto.setEsseInputFl("0");
        
        joinFields.add(profilePhoto);
        
        JoinField imageIcon = new JoinField();
        imageIcon.setC_id(11);
        imageIcon.setUseFl("0");
        imageIcon.setInfoOpenFl("0");
        imageIcon.setEsseInputFl("0");
        
        joinFields.add(imageIcon);
        
        assertThat(joinFields.size(), is(9));
        
        int affectedRowCount = joinFieldService.saveJoinFields(joinFields);
        
        assertThat(joinFields.size(), is(affectedRowCount));
    }
}