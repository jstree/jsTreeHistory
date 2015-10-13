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

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.baroboard.user.note.vo.UserNoteByUser;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 9. 06.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserManageDaoImpl.java
 * Description : 바로보드-쪽지 DAO 클래스
 * Information : 바로보드-쪽지 DAO 클래스
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
@Repository
public class UserNoteDaoImpl extends EgovComAbstractDAO implements UserNoteDao {

    @Override
    public int selectCountOfUser(Map<String, Object> paramMap) throws Exception {
        
    	UserNoteByUser userNoteByUser = (UserNoteByUser) paramMap.get("user");
        
        return (int) getSqlMapClientTemplate().queryForObject(userNoteByUser.getSqlMapSelector() + "." + "selectCountOfUser", paramMap);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<UserNoteByUser> selectUserListPaginated(Map<String, Object> paramMap) throws Exception {
        
    	UserNoteByUser userNoteByUser = (UserNoteByUser) paramMap.get("user");
        
        return list(userNoteByUser.getSqlMapSelector() + "." + "selectUserListPaginated", paramMap);
    }
}