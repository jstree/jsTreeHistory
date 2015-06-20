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

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.baroboard.user.vo.User;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 6. 16.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserManageDaoImpl.java
 * Description : 바로보드-회원관리 DAO 클래스
 * Information : 바로보드-회원관리 DAO 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 16.   류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Repository
public class UserManageDaoImpl extends EgovComAbstractDAO implements UserManageDao {

    @Override
    public int selectCountOfUser(Map<String, Object> paramMap) throws Exception {
        
        User user = (User) paramMap.get("user");
        
        return (int) getSqlMapClientTemplate().queryForObject(user.getSqlMapSelector() + "." + "selectCountOfUser", paramMap);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<User> selectUserListPaginated(Map<String, Object> paramMap) throws Exception {
        
        User user = (User) paramMap.get("user");
        
        return list(user.getSqlMapSelector() + "." + "selectUserListPaginated", paramMap);
    }

	@Override
	public User getUserInfoByID(User user) throws Exception {
		return (User)selectByPk(user.getSqlMapSelector() + "." + "getUserInfoByID", user);
	}
}