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

import standard.mvc.component.business.baroboard.user.vo.User;


/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 6. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserDao.java
 * Description : 바로보드-회원 DAO 인터페이스
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 25.   류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface UserDao {

    /**
     * 닉네임으로 회원을 조회한다.
     * 
     * @param 회원 DTO
     * @return 회원 DTO
     */
    User selectUserByNickname(User user);
    
    /**
     * 이메일로 회원을 조회한다.
     * 
     * @param 회원 DTO
     * @return 회원 DTO
     */
    User selectUserByEmail(User user);
    
    /**
     * 회원의 비밀번호를 갱신한다.
     * 
     * @param user 회원 DTO
     * @return affectedRowCount
     */
    int updateUserPassword(User user);
}