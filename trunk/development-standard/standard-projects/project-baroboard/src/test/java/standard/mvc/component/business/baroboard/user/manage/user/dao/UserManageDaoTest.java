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
package standard.mvc.component.business.baroboard.user.manage.user.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.user.vo.User;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 8. 5.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserManageDaoTest.java
 * Description : 바로보드-회원관리 DAO 테스트 클래스
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 8. 5.   류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@DatabaseSetup("UserManageDaoTest.xml")
public class UserManageDaoTest extends DbUnitTest<User> {
    
    @Autowired
    private UserManageDao userManageDao;

    @ExpectedDatabase(value = "UserManageDaoTest_updateJoinState.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    @Test
    public void updateJoinState() {
        
        User user = new User();
        user.setC_id(3);
        user.setJoinStateCd(4);
        
        userManageDao.updateJoinState(user);
        
        user = new User();
        user.setC_id(4);
        user.setJoinStateCd(6);
        
        userManageDao.updateJoinState(user);
    }
}