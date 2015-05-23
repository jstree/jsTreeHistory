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
package standard.mvc.component.business.baroboard.user.manage.basic.setting.contents.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.contents.service.BasicContentsService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.contents.vo.BasicContents;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 8.
 * @version 1.0
 * @see <pre>
 * Class Name  : BasicContentsServiceTest.java
 * Description : 바로보드-회원관리-기본 컨텐츠 설정 Service 테스트 클래스
 * Infomation  : 바로보드-회원관리-기본 컨텐츠 설정 Service 테스트 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 5. 8.  류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@DatabaseSetup("BasicContentsServiceTest.xml")
public class BasicContentsServiceTest extends DbUnitTest<BasicContents> {
    
    @Autowired
    private BasicContentsService basicContentsService;
    
    @Test
    public void getBasicContents() throws Exception {
        
        BasicContents basicContents = basicContentsService.getBasicContents();
        
        assertThat(basicContents.getC_id(), is(3));
        assertThat(basicContents.getC_parentid(), is(2));
        assertThat(basicContents.getC_position(), is(0));
        assertThat(basicContents.getC_left(), is(3));
        assertThat(basicContents.getC_right(), is(4));
        assertThat(basicContents.getC_level(), is(2));
        assertThat(basicContents.getC_title(), is(equalTo("회원_가입")));
        assertThat(basicContents.getC_type(), is(equalTo("default"))); // TODO Enumeration 도입 필요
        assertThat(basicContents.getCompanyIntr(), is(equalTo("바로컴퍼니입니다.")));
        assertThat(basicContents.getTermsOfUse(), is(equalTo("일단 한 번 써봐. 공짜야.")));
        assertThat(basicContents.getPrivacyPolicy(), is(equalTo("아무 것도 책임지지 않습니다.")));
    }
    
    @Test
    @ExpectedDatabase(value = "BasicContentsServiceTest_saveBasicContents.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void saveBasicContents() throws Exception {
        
        BasicContents basicContents = basicContentsService.getBasicContents();
        
        basicContents.setCompanyIntr("회사 소개입니다.");
        basicContents.setTermsOfUse("이용 약관입니다.");
        basicContents.setPrivacyPolicy("개인정보취급방침입니다.");
        
        basicContentsService.saveBasicContents(basicContents);
    }
}