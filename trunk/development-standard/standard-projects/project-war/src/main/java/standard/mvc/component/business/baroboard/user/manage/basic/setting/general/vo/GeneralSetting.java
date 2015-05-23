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
package standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo;

import java.util.List;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 19.
 * @version 1.0
 * @see <pre>
 * Class Name  : GeneralSetting.java
 * Description : 바로보드-회원관리-기본설정-일반설정 DTO
 * Infomation  : 바로보드-회원관리-기본설정-일반설정 DTO
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
public class GeneralSetting extends ComprehensiveTree {

    /** 비밀번호보안수준코드 */
    private int passwordSecurityLevelCd;
    
    /** 비밀번호보안수준코드명 */
    private String passwordSecurityLevelCdNm;

    /** 웹마스터이름 */
    private String webMasterNm;

    /** 웹마스터이메일 */
    private String webMasterEmail;
    
    /** 회원가입승인여부 */
    private String joinApprovalFl;

    /** 이메일인증사용여부 */
    private String emailAuthUseFl;

    /** 비밀번호변경일수 */
    private int passwordChangeDcnt;

    /** 로그인제한일수 */
    private int loginLimitDcnt;

    /** 로그인실패제한횟수 */
    private int loginFailureLimitCnt;
    
    /** 웹마스터이메일 계정 */
    private String webMasterEmailAccount;
    
    /** 웹마스터이메일 호스트 */
    private String webMasterEmailHost;
    
    /** 닉네임 금지단어 */
    private String nicknameProhibitionWords;
    
    public int getPasswordSecurityLevelCd() {
        return passwordSecurityLevelCd;
    }

    public void setPasswordSecurityLevelCd(int passwordSecurityLevelCd) {
        this.passwordSecurityLevelCd = passwordSecurityLevelCd;
    }

    public String getPasswordSecurityLevelCdNm() {
        return passwordSecurityLevelCdNm;
    }

    public void setPasswordSecurityLevelCdNm(String passwordSecurityLevelCdNm) {
        this.passwordSecurityLevelCdNm = passwordSecurityLevelCdNm;
    }

    public String getWebMasterNm() {
        return webMasterNm;
    }

    public void setWebMasterNm(String webMasterNm) {
        this.webMasterNm = webMasterNm;
    }

    public String getWebMasterEmail() {
        return webMasterEmail;
    }

    public void setWebMasterEmail(String webMasterEmail) {
        this.webMasterEmail = webMasterEmail;
    }

    public String getJoinApprovalFl() {
        return joinApprovalFl;
    }

    public void setJoinApprovalFl(String joinApprovalFl) {
        this.joinApprovalFl = joinApprovalFl;
    }

    public String getEmailAuthUseFl() {
        return emailAuthUseFl;
    }

    public void setEmailAuthUseFl(String emailAuthUseFl) {
        this.emailAuthUseFl = emailAuthUseFl;
    }

    public int getPasswordChangeDcnt() {
        return passwordChangeDcnt;
    }

    public void setPasswordChangeDcnt(int passwordChangeDcnt) {
        this.passwordChangeDcnt = passwordChangeDcnt;
    }

    public int getLoginLimitDcnt() {
        return loginLimitDcnt;
    }

    public void setLoginLimitDcnt(int loginLimitDcnt) {
        this.loginLimitDcnt = loginLimitDcnt;
    }

    public int getLoginFailureLimitCnt() {
        return loginFailureLimitCnt;
    }

    public void setLoginFailureLimitCnt(int loginFailureLimitCnt) {
        this.loginFailureLimitCnt = loginFailureLimitCnt;
    }

    public String getWebMasterEmailAccount() {
        return webMasterEmailAccount;
    }

    public void setWebMasterEmailAccount(String webMasterEmailAccount) {
        this.webMasterEmailAccount = webMasterEmailAccount;
    }

    public String getWebMasterEmailHost() {
        return webMasterEmailHost;
    }

    public void setWebMasterEmailHost(String webMasterEmailHost) {
        this.webMasterEmailHost = webMasterEmailHost;
    }

    public String getNicknameProhibitionWords() {
        return nicknameProhibitionWords;
    }

    public void setNicknameProhibitionWords(String nicknameProhibitionWords) {
        this.nicknameProhibitionWords = nicknameProhibitionWords;
    }

    @Override
    public String getSqlMapSelector() {

        return "generalSetting";
    }
}