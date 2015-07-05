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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Modification Information
 * 
 * @ author 김형채
 * 
 * @since 2015. 6. 12.
 * @version 1.0
 * @see <pre>
 * Class Name  : SecureUserLogin.java
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

public class SecureUserLogin implements UserDetails
{
	private static final long serialVersionUID = -6673037937422246017L;
	
	private int id;
	private String password;
	private String passwordChangeDt;
	private int userGradeCd;
	private String nickName;
	private String email;
	private String username;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public String getUsername()
	{
		return this.username;
	}
	
	public void setUsername(String username)
	{
		 this.email = username;
		 this.username = username;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String getPassword()
	{
		return this.password;
	}
	
	public String getPasswordChangeDt()
	{
		return passwordChangeDt;
	}

	public void setPasswordChangeDt(String passwordChangeDt)
	{
		this.passwordChangeDt = passwordChangeDt;
	}
	
    public int getUserGradeCd()
	{
		return userGradeCd;
	}

	public void setUserGradeCd(int userGradeCd)
	{
		this.userGradeCd = userGradeCd;
	}
	
	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
		this.username = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
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
}
