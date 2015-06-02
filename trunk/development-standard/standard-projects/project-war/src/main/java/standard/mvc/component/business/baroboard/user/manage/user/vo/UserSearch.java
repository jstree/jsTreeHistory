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
package standard.mvc.component.business.baroboard.user.manage.user.vo;

import javax.validation.constraints.Size;

import standard.mvc.component.business.baroboard.user.vo.User;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 31.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserSearch.java
 * Description : 바로보드-회원관리-회원검색 DTO
 * Infomation  : 바로보드-회원관리-회원검색 DTO
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일        수정자        수정내용
 * -------       ------------  -----------------------
 * 2015. 5. 31.  류강하        최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class UserSearch extends User {

    /** 가입일자시작 */
    private String joinDeBegi;

    /** 가입일자종료 */
    private String joinDeEnd;

    /** 로그인일자시작 */
    private String loginDeStart;
    
    /** 로그인일자종료 */
    private String loginDeEnd;
    
    /** 회원가입승인여부 */
    @Size(min = 0, max = 1)
    private String joinApprovalFl;

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

	public String getLoginDeStart() {
		return loginDeStart;
	}

	public void setLoginDeStart(String loginDeStart) {
		this.loginDeStart = loginDeStart;
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
}