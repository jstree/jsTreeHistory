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
package egovframework.com.ext.jstree.support.manager.security.login.vo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @ author 김형채
 * 
 * @since 2015. 6. 12.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserInfo.java
 * Description : 로그인- 로그인 Vo 
 * Information  : 로그인- 로그인 Vo
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -----------   ------------  -----------------------
 * 2015. 06.10.  김형채 		      최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

public class UserInfo extends ComprehensiveTree implements UserDetails
{
    private static final long serialVersionUID = -6673037937422246017L;
    
    private String password;
    
    private String email;
    
    private int loginFailureCnt;
    
    private String joinDt;
    
    private String lastLoginDt;
    
    private List<UserRole> authorities;
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public int getLoginFailureCnt()
    {
        return loginFailureCnt;
    }
    
    public void setLoginFailureCnt(int loginFailureCnt)
    {
        this.loginFailureCnt = loginFailureCnt;
    }
    
    public String getJoinDt()
    {
        return joinDt;
    }
    
    public void setJoinDt(String joinDt)
    {
        this.joinDt = joinDt;
    }
    
    public String getLastLoginDt()
    {
        return lastLoginDt;
    }
    
    public void setLastLoginDt(String lastLoginDt)
    {
        this.lastLoginDt = lastLoginDt;
    }
    
    public void setAuthorities(List<UserRole> authorities)
    {
        this.authorities = authorities;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return authorities;
    }
    
    @Override
    public String getPassword()
    {
        return password;
    }
    
    @Override
    public String getUsername()
    {
        return email;
    }
    
    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked()
    {
        return loginFailureCnt < 4;
    }
    
    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }
    
    @Override
    public boolean isEnabled()
    {
        return true;
    }
    
    @Override
    public String getSqlMapSelector()
    {
        return "userInfo";
    }
}
