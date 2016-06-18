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
package egovframework.com.ext.jstree.support.manager.security.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.ext.jstree.support.manager.security.login.dao.UserInfoDao;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserRole;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.RolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.RolesManageVo;

/**
 * Modification Information
 * 
 * @ author 김형채
 * 
 * @since 2015. 6. 16.
 * @version 1.0
 * @see <pre>
 * Class Name   : SecureUserLoginServiceImpl.java
 * Description  : 로그인- 로그인 Service 
 * Information  : 로그인- 로그인 Service
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -----------   ------------  -----------------------
 * 2015. 06.16.  김형채 		      최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Service
public class SecureUserLoginServiceImpl implements UserDetailsService
{
    @Autowired
    private UserInfoDao userInfoDao;
    
    @Autowired
    private UserInfoService userInfoService;
    
    @Resource(name = "rolesManageService")
    private RolesManageService rolesManageService;
    
    @Resource(name = "egovMessageSource")
    private EgovMessageSource egovMessageSource;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws RuntimeException
    {
        UserInfo secureLogInUser = new UserInfo();
        secureLogInUser.setEmail(email);
        
        secureLogInUser = userInfoDao.loadUserByUsername(secureLogInUser);
        
        try
        {
            setRoles(secureLogInUser);
        }
        catch (Exception e)
        {
            List<UserRole> roles = new ArrayList<UserRole>();
            UserRole userRole = new UserRole();
            userRole.setRole("ROLE_ANONYMOUS");
            roles.add(userRole);
            secureLogInUser.setAuthorities(roles);
        }
        
        return secureLogInUser;
    }
    
    private void setRoles(UserInfo userInfo) throws Exception
    {
        List<UserRole> roles = new ArrayList<UserRole>();
        String[] roleArr = StringUtils.split(userInfo.getRoles(), ",");
        
        for (String role : roleArr)
        {
            RolesManageVo param = new RolesManageVo();
            param.setC_id(Integer.parseInt(role));
            RolesManageVo result = rolesManageService.getRolesInfoDetail(param);
            UserRole userRole = new UserRole();
            userRole.setRole(result.getAuthority());
            roles.add(userRole);
        }
        userInfo.setAuthorities(roles);
    }
}
