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
package egovframework.com.ext.jstree.support.manager.security.login.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserRole;

/**
 * Modification Information
 * 
 * @ author 김형채
 * 
 * @since 2015. 6. 13.
 * @version 1.0
 * @see <pre>
 * Class Name   : UserLoginDaoImpl.java
 * Description  : 로그인- 로그인 Dao Implements Class 
 * Information  : 로그인- 로그인 Dao Implements Class
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -----------   ------------  -----------------------
 * 2015. 06.13.  김형채 		      최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Repository
public class UserInfoDaoImpl extends EgovComAbstractDAO implements UserInfoDao
{
    @Override
    public UserInfo loadUserByUsername(UserInfo userInfo)
    {
        return (UserInfo) selectByPk("userInfo.loadUserByUsername", userInfo);
    }
    
    @Override
    public UserRole getUserRole(UserRole userRole) throws Exception
    {
        return (UserRole) selectByPk("userRole.getUserRole", userRole);
    }
    
    @Override
    public UserInfo getUserByUuid(UserInfo userInfo)
    {
        return (UserInfo) selectByPk("userInfo.getUserByUuid", userInfo);
    }
    
    @Override
    public void updateUseYnByUuid(UserInfo userInfo) throws Exception
    {
        update("userInfo.updateUseYnByUuid", userInfo);
    }
    
    @Override
    public void updatePassword(UserInfo userInfo) throws Exception
    {
        update("userInfo.updatePassword", userInfo);
    }
}