package egovframework.com.ext.jstree.support.manager.security.login.handler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import egovframework.com.ext.jstree.support.manager.security.login.dao.SecureUserLoginDao;
import egovframework.com.ext.jstree.support.manager.security.login.service.SecureGeneralSettingService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureGeneralSetting;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUser;
import egovframework.com.ext.jstree.support.util.DateUtils;

/**
 * Modification Information
 * 
 * @ author 김형채
 * 
 * @since 2015. 6. 12.
 * @version 1.0
 * @see <pre>
 * Class Name  : SecureUserLoginFailureHandler.java
 * Description : 로그인- 로그인 SecureUserLoginFailureHandler 
 * Information  : 로그인- 로그인 SecureUserLoginFailureHandler
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -----------   ------------  -----------------------
 * 2015. 06.12.  김형채 		      최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Component
public class SecureUserLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler
{
	@Autowired
    private SecureUserLoginDao secureUserLoginDao;
	
	@Autowired
	private SecureGeneralSettingService secureGeneralSettingService; 
	
	@Override
	public void onAuthenticationFailure( HttpServletRequest request, HttpServletResponse response, AuthenticationException exception ) throws IOException, ServletException
	{
		SecureUser secureLogInUser = new SecureUser();
		secureLogInUser.setEmail( request.getParameter("email") );
		secureLogInUser.setPassword( request.getParameter("password") );
		
		final int ACCOUNTLOCKED = 5;
		final String LOGINURL = "/user/login/index.do";
		super.setDefaultFailureUrl(LOGINURL);
		
		try
		{
			SecureUser secureLoggedInUser = secureUserLoginDao.getUserInfoByEmail( secureLogInUser );
			SecureGeneralSetting secureGeneralSetting = this.secureGeneralSettingService.getGeneralSetting();
			
			ShaPasswordEncoder encoder=new ShaPasswordEncoder(256);
			String secureLogInUserPassword = encoder.encodePassword(secureLogInUser.getPassword(), null);
			
			Date joinTargetDate = null;
			
			if ( secureLoggedInUser != null ) 
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				Date joinDt = sdf.parse(secureLoggedInUser.getJoinDt());
				int loginLimitDcnt = secureGeneralSetting.getLoginLimitDcnt();
				joinTargetDate = DateUtils.addDays(joinDt, loginLimitDcnt);
			}
			
			if ( secureLoggedInUser == null ) 
			{
				request.getSession().setAttribute("errorCode", "1");
			}
			else if ( StringUtils.equals(secureLoggedInUser.getPassword(), secureLogInUserPassword) == false ) 
			{
				secureUserLoginDao.setUserLoginFailureCntIncrease( secureLoggedInUser );
				secureLoggedInUser = secureUserLoginDao.getUserInfoByEmail( secureLoggedInUser );
				if( secureLoggedInUser.getLoginFailureCnt() == secureGeneralSetting.getLoginFailureLimitCnt() )
				{
					final int ACCOUNTADMIN = 3;
					SecureUser secureUser = new SecureUser();
					secureUser.setC_id( ACCOUNTADMIN );
					this.secureUserLoginDao.setUserLoginJoinStateCd(secureUser);
					
					request.getSession().setAttribute("errorCode", "2");
				}
				else
				{
					request.getSession().setAttribute("errorCode", "3");
					request.getSession().setAttribute("loginFailureCnt", String.valueOf(secureLoggedInUser.getLoginFailureCnt()));
				}
			}
			else if( secureLoggedInUser.getJoinStateCd() == ACCOUNTLOCKED )
			{
				request.getSession().setAttribute("errorCode", "2");
			}
			else if( joinTargetDate.after(new Date()) == true )
			{
				request.getSession().setAttribute("errorCode", "4");
			}
		} 
		catch ( Exception e )
		{
			throw new RuntimeException( e.getMessage() );
		}
		
		super.onAuthenticationFailure( request, response, exception );
	}
}