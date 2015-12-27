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
package egovframework.com.ext.jstree.support.manager.security.login.vo;

import javax.validation.constraints.Size;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 김형채
 * @since 2015. 6. 16.
 * @version 1.0
 * @see <pre>
 * Class Name  : SecureUser.java
 * Description : 바로보드-로그인 DTO
 * Information : 바로보드-로그인  DTO
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                 수정내용
 * ------------  ------------  -----------------------
 * 2015. 6. 16.  김형채                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class SecureUser extends ComprehensiveTree {

    /** 회원등급코드 */
    private int userGradeCd;
    
    /** 회원등급 */
    private String userGrade;
    
    /** 가입상태코드 */
    private int joinStateCd;
    
    /** 가입상태 */
    private String joinState;

    /** 비밀번호 */
    private String password;

    /** 이메일 */
    private String email;

    /** 로그인실패횟수 */
    private int loginFailureCnt;

    /** 비밀번호찾기질문 */
    private String passwordFindQuestion;

    /** 비밀번호찾기답변 */
    private String passwordFindAnswer;
    
	/** 비밀번호찾기질문코드 */
    private int pwdFindQuestionCd;

    /** 비밀번호찾기질문 */
    private String pwdFindQuestion;
    
    /** 비밀번호찾기답변 */
    private String pwdFindAnswer;

    /** 메일링서비스사용여부 */
    private String mailingServiceUseFl;

    /** 개인정보공개여부 */
    private String indiInfoOpenFl;

    /** 가입일시 */
    private String joinDt;

    /** 비밀번호변경일시 */
    private String passwordChangeDt;

    /** 마지막로그인일시 */
    private String lastLoginDt;
    
    /** 홈페이지 */
    private String homepageUrl;

    /** 블로그 */
    private String blogUrl;

    /** 서명 */
    private String sign;

    /** 프로필사진 */
    private String profilePhoto;

    /** 사용자아이콘 */
    private String imageIcon;
    
    /** 가입일자시작 */
    private String joinDeBegi;

    /** 가입일자종료 */
    private String joinDeEnd;

    /** 로그인일자시작 */
    private String loginDeBegi;
    
    /** 로그인일자종료 */
    private String loginDeEnd;
    
    /** 회원가입승인여부 */
    @Size(min = 0, max = 1)
    private String joinApprovalFl;
    
    /** 로그인일시 */
    private String loginDt;
    
    /** 가입일자 */
    private String joinDe;
    
    /** 마지막로그인일자 */
    private String lastLoginDe;
    
    /** 그룹id */
    private int groupId;

	public int getPwdFindQuestionCd()
	{
		return pwdFindQuestionCd;
	}

	public void setPwdFindQuestionCd(int pwdFindQuestionCd)
	{
		this.pwdFindQuestionCd = pwdFindQuestionCd;
	}

	public String getPwdFindQuestion()
	{
		return pwdFindQuestion;
	}

	public void setPwdFindQuestion(String pwdFindQuestion)
	{
		this.pwdFindQuestion = pwdFindQuestion;
	}

	public String getPwdFindAnswer()
	{
		return pwdFindAnswer;
	}

	public void setPwdFindAnswer(String pwdFindAnswer)
	{
		this.pwdFindAnswer = pwdFindAnswer;
	}
    
    public int getUserGradeCd() {
        return userGradeCd;
    }

    public void setUserGradeCd(int userGradeCd) {
        this.userGradeCd = userGradeCd;
    }

    public int getJoinStateCd() {
        return joinStateCd;
    }

    public void setJoinStateCd(int joinStateCd) {
        this.joinStateCd = joinStateCd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLoginFailureCnt() {
        return loginFailureCnt;
    }

    public void setLoginFailureCnt(int loginFailureCnt) {
        this.loginFailureCnt = loginFailureCnt;
    }

    public String getPasswordFindQuestion() {
        return passwordFindQuestion;
    }

    public void setPasswordFindQuestion(String passwordFindQuestion) {
        this.passwordFindQuestion = passwordFindQuestion;
    }

    public String getPasswordFindAnswer() {
        return passwordFindAnswer;
    }

    public void setPasswordFindAnswer(String passwordFindAnswer) {
        this.passwordFindAnswer = passwordFindAnswer;
    }

    public String getMailingServiceUseFl() {
        return mailingServiceUseFl;
    }

    public void setMailingServiceUseFl(String mailingServiceUseFl) {
        this.mailingServiceUseFl = mailingServiceUseFl;
    }

    public String getIndiInfoOpenFl() {
        return indiInfoOpenFl;
    }

    public void setIndiInfoOpenFl(String indiInfoOpenFl) {
        this.indiInfoOpenFl = indiInfoOpenFl;
    }

    public String getJoinDt() {
        return joinDt;
    }

    public void setJoinDt(String joinDt) {
        this.joinDt = joinDt;
    }

    public String getPasswordChangeDt() {
        return passwordChangeDt;
    }

    public void setPasswordChangeDt(String passwordChangeDt) {
        this.passwordChangeDt = passwordChangeDt;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public void setHomepageUrl(String homepageUrl) {
        this.homepageUrl = homepageUrl;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(String imageIcon) {
        this.imageIcon = imageIcon;
    }
    
    public String getJoinDe() {
		return joinDe;
	}

	public void setJoinDe(String joinDe) {
		this.joinDe = joinDe;
	}

	public String getLastLoginDe() {
        return lastLoginDe;
    }

    public void setLastLoginDe(String lastLoginDe) {
        this.lastLoginDe = lastLoginDe;
    }

    public String getLoginDt() {
		return loginDt;
	}

	public void setLoginDt(String loginDt) {
		this.loginDt = loginDt;
	}

	public String getJoinDeBegi() {
		return joinDeBegi;
	}

	public void setJoinDeBegi(String joinDeBegi) {
		this.joinDeBegi = joinDeBegi;
	}

	public String getJoinDeEnd() {
		return joinDeEnd;
	}

	public void setJoinDeEnd(String joinDeEnd) {
		this.joinDeEnd = joinDeEnd;
	}

	public String getLoginDeBegi() {
        return loginDeBegi;
    }

    public void setLoginDeBegi(String loginDeBegi) {
        this.loginDeBegi = loginDeBegi;
    }

    public String getLoginDeEnd() {
		return loginDeEnd;
	}

	public void setLoginDeEnd(String loginDeEnd) {
		this.loginDeEnd = loginDeEnd;
	}

	public String getJoinApprovalFl() {
		return joinApprovalFl;
	}

	public void setJoinApprovalFl(String joinApprovalFl) {
		this.joinApprovalFl = joinApprovalFl;
	}

	public String getLastLoginDt() {
        return lastLoginDt;
    }

    public void setLastLoginDt(String lastLoginDt) {
        this.lastLoginDt = lastLoginDt;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public String getJoinState() {
        return joinState;
    }

    public void setJoinState(String joinState) {
        this.joinState = joinState;
    }
    
    public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

    @Override
    public String getSqlMapSelector() {
        return "secureUser";
    }
}