package egovframework.com.ext.jstree.support.manager.security.login.handler;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.security.login.dao.SecureUserLoginDao;
import egovframework.com.ext.jstree.support.manager.security.login.service.SecureGeneralSettingService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureGeneralSetting;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUser;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLogin;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLoginState;
import egovframework.com.ext.jstree.support.util.DateUtils;

/**
 * Modification Information
 * 
 * @ author 김형채
 * 
 * @since 2015. 6. 12.
 * @version 1.0
 * @see <pre>
 * Class Name  : SecureUserLoginSuccessHandler.java
 * Description : 로그인- 로그인 SecureUserLoginSuccessHandler 
 * Information  : 로그인- 로그인 SecureUserLoginSuccessHandler
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
public class SecureUserLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
{
	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Autowired
    private SecureUserLoginDao secureUserLoginDao;
	
	@Autowired
	private SecureGeneralSettingService secureGeneralSettingService; 

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException
	{
		SecureUserLogin secureUserLogin = (SecureUserLogin) authentication.getPrincipal();
		
		try
		{
			this.setPasswordChangePage(secureUserLogin);
			
			this.setUserLastLoginDt(secureUserLogin);
			
			this.setUserLoginFailureCntZero(secureUserLogin);
			
	        this.addUserLoginState(request, secureUserLogin);
		} 
		catch( Exception e )
		{
			throw new RuntimeException( e.getMessage() );
		}
		
		
		request.getSession().setAttribute("secureUserLogin", secureUserLogin);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

	private void setPasswordChangePage(SecureUserLogin secureUserlogin) throws Exception
	{
		SecureGeneralSetting secureGeneralSetting = secureGeneralSettingService.getGeneralSetting();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date passwordChangeDt = sdf.parse(secureUserlogin.getPasswordChangeDt());
		int passwordChangeDcont = secureGeneralSetting.getPasswordChangeDcnt();
		Date passwordTargetDate = DateUtils.addDays(passwordChangeDt, passwordChangeDcont);
		
		if ( passwordTargetDate.before(new Date()) == true )
		{
			final String passwordChangePage = "/user/info/index.do?email="+secureUserlogin.getEmail();
			super.setDefaultTargetUrl(passwordChangePage);
		}
	}

	private void setUserLastLoginDt( SecureUserLogin secureUserlogin ) throws Exception
	{
		Date currentDay = DateUtils.getCurrentDay();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentDate = sdf.format(currentDay);
		
		SecureUser user = new SecureUser();
		user.setC_id(secureUserlogin.getId());
		user.setLoginDt(currentDate);
		
		this.secureUserLoginDao.setUserLastLoginDt(user);
	}

	private void setUserLoginFailureCntZero( SecureUserLogin secureUserlogin ) throws Exception
	{
		SecureUser user = new SecureUser();
		user.setC_id(secureUserlogin.getId());
		
		this.secureUserLoginDao.setUserLoginFailureCntZero(user);
	}

	private void addUserLoginState(HttpServletRequest request, SecureUserLogin secureUserlogin ) throws Exception
	{
		Date currentDay      = DateUtils.getCurrentDay();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentDate = sdf.format(currentDay);
		
		SecureUserLoginState userLoginState = new SecureUserLoginState();
		userLoginState.setRef(2);
		userLoginState.setC_type("default");
		userLoginState.setC_title("로그인");
		userLoginState.setUserId(secureUserlogin.getId());
		userLoginState.setIpAddress(request.getRemoteAddr());
		userLoginState.setMacAddress(getMacAddress(request.getRemoteAddr()));
		userLoginState.setLoginDt(currentDate);
		
		this.coreService.addNode(userLoginState);
	}
		
	private String getMacAddress(String ip)
	{
		StringBuilder sb = new StringBuilder();
		final String defaultMacAddress = "0A-1B-2C-3D-4E-5F";
		sb.append(defaultMacAddress);
		try 
		{
			InetAddress address = InetAddress.getByName(ip);
			
			NetworkInterface network = NetworkInterface.getByInetAddress(address);
			
			if ( network != null )
			{
				byte[] mac = network.getHardwareAddress();
				
				if ( mac.length > 0 )
				{
					sb = new StringBuilder();
					
					for (int i = 0; i < mac.length; i++) 
					{
						sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
					}	
				}
			}
		} 
		catch (UnknownHostException e) 
		{
			return sb.toString();
		} 
		catch (SocketException e)
		{
			return sb.toString();
		}
		
		return sb.toString();
    }
}