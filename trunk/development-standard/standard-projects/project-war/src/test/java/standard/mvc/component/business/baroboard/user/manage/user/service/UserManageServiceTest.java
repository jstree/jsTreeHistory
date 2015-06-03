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
package standard.mvc.component.business.baroboard.user.manage.user.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.user.vo.User;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 6. 2.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserManageServiceTest.java
 * Description : 바로보드-회원관리 Service 테스트 클래스
 * Infomation  : 바로보드-회원관리 Service 테스트 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 2.   류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@DatabaseSetup("UserManageServiceTest.xml")
public class UserManageServiceTest extends DbUnitTest<User> {

	@Autowired
    private UserManageService userManageService;
	
	@Ignore
	@Test
	public void getUserList() throws Exception {
		
		User userSearch = new User();
		// TODO 류강하 : 검색 조건 추가
		
		List<User> userList = userManageService.getUserList(userSearch);

		assertThat(userList.size(), is(1));
		
		User user = userList.get(0);
		
		assertThat(user.getC_id(), is(3));
        assertThat(user.getC_parentid(), is(2));
        assertThat(user.getC_position(), is(0));
        assertThat(user.getC_left(), is(3));
        assertThat(user.getC_right(), is(4));
        assertThat(user.getC_level(), is(2));
        assertThat(user.getC_title(), is(equalTo("관리자")));
        assertThat(user.getC_type(), is(equalTo("default")));
        assertThat(user.getUserGrade(), is(1));
        assertThat(user.getJoinStateCd(), is(4));
        assertThat(user.getEmail(), is(equalTo("admin@313.co.kr")));
        assertThat(user.getJoinDt(), is(equalTo("20150603222617")));
	}
}