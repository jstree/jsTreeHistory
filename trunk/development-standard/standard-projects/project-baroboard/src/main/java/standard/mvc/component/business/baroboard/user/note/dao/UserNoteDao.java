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
package standard.mvc.component.business.baroboard.user.note.dao;

import java.util.List;
import java.util.Map;

import standard.mvc.component.business.baroboard.user.note.vo.UserNoteByUser;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 9. 06.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserManageDao.java
 * Description : 바로보드-쪽지 DAO 인터페이스
 * Information : 바로보드-쪽지 DAO 인터페이스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 9. 06.   김대근                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface UserNoteDao {

    /**
     * 검색 조건에 부합하는 회원 총 수를 조회한다.
     * 
     * @param paramMap 회원 DTO, 페이징 처리 관련 속성을 담은 Map
     * @return 검색 조건에 부합하는 회원 총 수
     * @throws Exception
     */
    int selectCountOfUser(Map<String, Object> paramMap) throws Exception;
    
    /**
     * 페이징 처리된, 검색 조건에 부합하는 회원 목록을 조회한다.
     * 
     * @param paramMap 회원 DTO, 페이징 처리 관련 속성을 담은 Map
     * @return 회원 DTO List
     * @throws Exception
     */
    List<UserNoteByUser> selectUserListPaginated(Map<String, Object> paramMap) throws Exception;
}