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
package standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.GeneralSetting;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.PasswordSecurityLevel;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 19.
 * @version 1.0
 * @see <pre>
 * Class Name  : GeneralSettingServiceTest.java
 * Description : 바로보드-회원관리-기본설정-일반설정  Service 테스트 클래스
 * Infomation  : 바로보드-회원관리-기본설정-일반설정  Service 테스트 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 19.      류강하       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class GeneralSettingServiceTest extends DbUnitTest<GeneralSetting> {

    @Autowired
    private GeneralSettingService generalSettingService;
    
    @Test
    public void getPasswordSecurityLevel() throws Exception {
        
        List<PasswordSecurityLevel> passwordSecurityLevels = generalSettingService.getPasswordSecurityLevel();
        
        assertThat(passwordSecurityLevels.size(), is(3));
        
        PasswordSecurityLevel lowLevel = passwordSecurityLevels.get(0);
        
        assertThat(lowLevel.getC_id(), is(3));
        assertThat(lowLevel.getC_parentid(), is(2));
        assertThat(lowLevel.getC_position(), is(0));
        assertThat(lowLevel.getC_left(), is(3));
        assertThat(lowLevel.getC_right(), is(4));
        assertThat(lowLevel.getC_level(), is(2));
        assertThat(lowLevel.getC_title(), is(equalTo("낮음 (비밀번호 4자 이상)")));
        assertThat(lowLevel.getC_type(), is(equalTo("default")));
        
        PasswordSecurityLevel middleLevel = passwordSecurityLevels.get(1);
        
        assertThat(middleLevel.getC_id(), is(4));
        assertThat(middleLevel.getC_parentid(), is(2));
        assertThat(middleLevel.getC_position(), is(1));
        assertThat(middleLevel.getC_left(), is(5));
        assertThat(middleLevel.getC_right(), is(6));
        assertThat(middleLevel.getC_level(), is(2));
        assertThat(middleLevel.getC_title(), is(equalTo("보통 (비밀번호 6자 이상, 영문자/숫자 조합)")));
        assertThat(middleLevel.getC_type(), is(equalTo("default")));
        
        PasswordSecurityLevel highLevel = passwordSecurityLevels.get(2);
        
        assertThat(highLevel.getC_id(), is(5));
        assertThat(highLevel.getC_parentid(), is(2));
        assertThat(highLevel.getC_position(), is(2));
        assertThat(highLevel.getC_left(), is(7));
        assertThat(highLevel.getC_right(), is(8));
        assertThat(highLevel.getC_level(), is(2));
        assertThat(highLevel.getC_title(), is(equalTo("높음 (비밀번호 8자 이상, 영문자/숫자/특수문자 조합)")));
        assertThat(highLevel.getC_type(), is(equalTo("default")));
    }
    
    @Test
    @DatabaseSetup("GeneralSettingServiceTest.xml")
    public void getGeneralSetting() throws Exception {
        
        GeneralSetting generalSetting = generalSettingService.getGeneralSetting();
        
        assertThat(generalSetting.getC_id(), is(3));
        assertThat(generalSetting.getC_parentid(), is(2));
        assertThat(generalSetting.getC_position(), is(0));
        assertThat(generalSetting.getC_left(), is(3));
        assertThat(generalSetting.getC_right(), is(4));
        assertThat(generalSetting.getC_level(), is(2));
        assertThat(generalSetting.getC_title(), is(equalTo("회원가입")));
        assertThat(generalSetting.getC_type(), is(equalTo("default")));
        assertThat(generalSetting.getPasswordSecurityLevelCd(), is(1));
        assertThat(generalSetting.getWebMasterNm(), is(equalTo("바로보드 관리자")));
        assertThat(generalSetting.getWebMasterEmail(), is(equalTo("313@313.co.kr")));
        assertThat(generalSetting.getJoinApprovalFl(), is(equalTo("0")));
        assertThat(generalSetting.getEmailAuthUseFl(), is(equalTo("0")));
        assertThat(generalSetting.getPasswordChangeDcnt(), is(0));
        assertThat(generalSetting.getLoginLimitDcnt(), is(0));
        assertThat(generalSetting.getLoginFailureLimitCnt(), is(0));
    }
}