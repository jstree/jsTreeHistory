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

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.ext.jstree.support.manager.security.login.dao.SecureUserLoginDao;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureGeneralSetting;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUser;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLogin;
import egovframework.com.ext.jstree.support.util.DateUtils;

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
    private SecureUserLoginDao secureUserLoginDao;
	
	@Autowired
	private SecureGeneralSettingService secureGeneralSettingService; 

	@Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		SecureUser secureLogInUser = new SecureUser();
		secureLogInUser.setEmail(email);
		
		try 
		{
			secureLogInUser = secureUserLoginDao.getUserInfoByEmail(secureLogInUser);
			
			if ( secureLogInUser == null )
			{
				throw new RuntimeException( this.egovMessageSource.getMessage("bb.login.error.010") );
			}
			
			final int JOINCOMPLETE = 4;
			if ( secureLogInUser.getJoinStateCd() !=  JOINCOMPLETE)
			{
				new RuntimeException( this.egovMessageSource.getMessage("bb.login.error.011") );
			}
			
			SecureGeneralSetting secureGeneralSetting = secureGeneralSettingService.getGeneralSetting();
			
			if ( secureLogInUser.getLoginFailureCnt() == secureGeneralSetting.getLoginFailureLimitCnt() )
			{
				new RuntimeException( this.egovMessageSource.getMessage("bb.login.error.012") );
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Date joinDt = sdf.parse(secureLogInUser.getJoinDt());
			int loginLimitDcnt = secureGeneralSetting.getLoginLimitDcnt();
			Date joinTargetDate = DateUtils.addDays(joinDt, loginLimitDcnt);
			
			if( joinTargetDate.after(new Date()) == true )
			{
				new RuntimeException( this.egovMessageSource.getMessage("bb.login.error.013") );
			}
		} 
		catch (Exception e) 
		{
			throw new RuntimeException(e.getMessage());
		}
		
		SecureUserLogin secureLoggedInUser = new SecureUserLogin();
		
		secureLoggedInUser.setUserid(secureLogInUser.getC_id());
		secureLoggedInUser.setUsername(secureLogInUser.getEmail());
		secureLoggedInUser.setPassword(secureLogInUser.getPassword());
		secureLoggedInUser.setPasswordChangeDt(secureLogInUser.getPasswordChangeDt());
		secureLoggedInUser.setUserGradeCd(secureLogInUser.getUserGradeCd());
		secureLoggedInUser.setC_title(secureLogInUser.getC_title());
		
		return secureLoggedInUser;
	}
}
