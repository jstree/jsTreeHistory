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
package standard.mvc.component.business.baroboard.user.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 30.
 * @version 1.0
 * @see <pre>
 * Class Name  : User.java
 * Description : 바로보드-회원 DTO
 * Infomation  : 바로보드-회원 DTO
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일        수정자        수정내용
 * -------       ------------  -----------------------
 * 2015. 5. 30.  류강하        최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class User extends ComprehensiveTree {

    /** 회원등급 */
    private int userGrade;

    /** 가입상태코드 */
    private int joinStateCd;

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

    /** 메일링서비스사용여부 */
    private String mailingServiceUseFl;

    /** 개인정보공개여부 */
    private String indiInfoOpenFl;

    /** 가입일시 */
    private String joinDt;

    /** 비밀번호변경일시 */
    private String passwordChangeDt;

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

    /** 가입일자 */
    private String joinDe;
    
    /** 로그인일자 */
    private String loginDe;
    
    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
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

	public String getLoginDe() {
		return loginDe;
	}

	public void setLoginDe(String loginDe) {
		this.loginDe = loginDe;
	}

	@Override
    public String getSqlMapSelector() {
        return "user";
    }
}