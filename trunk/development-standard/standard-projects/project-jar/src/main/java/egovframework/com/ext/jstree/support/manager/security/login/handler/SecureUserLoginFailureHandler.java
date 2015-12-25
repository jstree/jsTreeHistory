package egovframework.com.ext.jstree.support.manager.security.login.handler;

import java.io.IOException;
import java.text.ParseException;
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
import org.springframework.util.ObjectUtils;

import com.sun.star.uno.RuntimeException;

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
	
	private static final int JOIN_COMPLETE = 4;
	private static final int ACCOUNT_ADMIN = 3;
	
	SecureGeneralSetting secureGeneralSetting;
	SecureUser secureLoggedInUser;
	
	ThreadLocal<SecureGeneralSetting> currentSecureGeneralSetting = new ThreadLocal<SecureGeneralSetting>();
	ThreadLocal<SecureUser> currentSecureLoggedInUser 			  = new ThreadLocal<SecureUser>();
	
	private String loginidname;			// 로그인 id값이 들어오는 input 태그 name
	private String loginpasswdname;		// 로그인 password 값이 들어오는 input 태그 name
	private String loginredirectname;		// 로그인 성공시 redirect 할 URL이 지정되어 있는 input 태그 name
	private String exceptionmsgname;	// 예외 메시지를 request의 Attribute에 저장할 때 사용될 key 값
	private String defaultFailureUrl;		// 화면에 보여줄 URL(로그인 화면)
	
	public String getLoginidname() {
		return loginidname;
	}
	
	public void setLoginidname(String loginidname) {
		this.loginidname = loginidname;
	}
	
	public String getLoginpasswdname() {
		return loginpasswdname;
	}
	
	public void setLoginpasswdname(String loginpasswdname) {
		this.loginpasswdname = loginpasswdname;
	}
	
	public String getLoginredirectname() {
		return loginredirectname;
	}
	
	public void setLoginredirectname(String loginredirectname) {
		this.loginredirectname = loginredirectname;
	}
	
	public String getExceptionmsgname() {
		return exceptionmsgname;
	}
	
	public void setExceptionmsgname(String exceptionmsgname) {
		this.exceptionmsgname = exceptionmsgname;
	}
	
	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}
	
	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}
	
	public SecureUserLoginFailureHandler() throws Exception {
		this.loginidname = "j_username";
		this.loginpasswdname = "j_password";
		this.loginredirectname = "loginRedirect";
		this.exceptionmsgname = "securityexceptionmsg";
		this.defaultFailureUrl = "loginFail";
		
		secureGeneralSetting = this.secureGeneralSettingService.getGeneralSetting();
		this.currentSecureGeneralSetting.set(secureGeneralSetting);
	}
	
	@Override
	public void onAuthenticationFailure( HttpServletRequest request, HttpServletResponse response, AuthenticationException exception ) throws IOException, ServletException
	{
		super.setDefaultFailureUrl(this.defaultFailureUrl);
		
		SecureUser secureLogInUser = new SecureUser();
		secureLogInUser.setEmail( request.getParameter("email") );
		secureLogInUser.setPassword( request.getParameter("password") );
		
		secureLoggedInUser = secureUserLoginDao.getUserInfoByEmail( secureLogInUser );
		this.currentSecureLoggedInUser.set(secureLoggedInUser);
		
		String errMsg = "";
		
		if ( this.currentSecureLoggedInUser.get() == null ) 
		{
			errMsg = "정확한 이메일 주소를 입력하세요.";
		}
		else if( this.currentSecureLoggedInUser.get().getJoinStateCd() != JOIN_COMPLETE )
		{
			errMsg = "회원 가입완료 상태가 아닙니다.";
		}
		else if( this.getJoinTargetDate().after(new Date()) == true )
		{
			errMsg = "로그인 제한일수가 지나지 않았습니다.";
		} 
		else 
		{
			if( this.currentSecureLoggedInUser.get().getLoginFailureCnt() == secureGeneralSetting.getLoginFailureLimitCnt() )
			{
				this.secureUserLoginDao.setUserLoginJoinStateCd(this.currentSecureLoggedInUser.get());
				errMsg = "로그인 실패 제한횟수가 되었습니다.";
			}
			else
			{
				secureUserLoginDao.setUserLoginFailureCntIncrease( this.currentSecureLoggedInUser.get() );
				errMsg = "비밀번호 실패 횟수 : "+ String.valueOf(this.currentSecureLoggedInUser.get().getLoginFailureCnt()+1) +" 회.";
			}
		}
		
		request.getSession().setAttribute("errorMsg", errMsg);
			
		super.onAuthenticationFailure( request, response, exception );
	}

	private Date getJoinTargetDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date joinTargetDate = null;
		try {
			if (this.currentSecureLoggedInUser.get() != null) 
			{
				Date joinDt = sdf.parse(this.currentSecureLoggedInUser.get().getJoinDt());
				int loginLimitDcnt = this.currentSecureGeneralSetting.get().getLoginLimitDcnt();
				joinTargetDate =   DateUtils.addDays(joinDt, loginLimitDcnt);
			} else {
				joinTargetDate =  sdf.parse("00000000000000");
			}
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
		return joinTargetDate;
	}
}