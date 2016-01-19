package egovframework.com.ext.jstree.support.manager.security.login.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import egovframework.com.ext.jstree.support.manager.security.login.service.UserInfoService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLogin;
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
    private String loginidname; // 로그인 id값이 들어오는 input 태그 name
    
    private String loginpasswdname; // 로그인 password 값이 들어오는 input 태그 name
    
    private String loginredirectname; // 로그인 성공시 redirect 할 URL이 지정되어 있는 input태그
                                      // name
    
    private String exceptionmsgname; // 예외 메시지를 request의 Attribute에 저장할 때 사용될
                                     // key 값
    
    private String defaultFailureUrl; // 화면에 보여줄 URL(로그인 화면)
    
    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    UserInfoService userInfoService;
    
    public String getLoginidname()
    {
        return loginidname;
    }
    
    public void setLoginidname(String loginidname)
    {
        this.loginidname = loginidname;
    }
    
    public String getLoginpasswdname()
    {
        return loginpasswdname;
    }
    
    public void setLoginpasswdname(String loginpasswdname)
    {
        this.loginpasswdname = loginpasswdname;
    }
    
    public String getLoginredirectname()
    {
        return loginredirectname;
    }
    
    public void setLoginredirectname(String loginredirectname)
    {
        this.loginredirectname = loginredirectname;
    }
    
    public String getExceptionmsgname()
    {
        return exceptionmsgname;
    }
    
    public void setExceptionmsgname(String exceptionmsgname)
    {
        this.exceptionmsgname = exceptionmsgname;
    }
    
    public String getDefaultFailureUrl()
    {
        return defaultFailureUrl;
    }
    
    public void setDefaultFailureUrl(String defaultFailureUrl)
    {
        this.defaultFailureUrl = defaultFailureUrl;
    }
    
    public SecureUserLoginFailureHandler()
    {
        this.loginidname = "j_username";
        this.loginpasswdname = "j_password";
        this.loginredirectname = "loginRedirect";
        this.exceptionmsgname = "securityexceptionmsg";
        this.defaultFailureUrl = "loginFail";
    }
    
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException
    {
        SecureUserLogin secureUserLogin = null;
        
        String userName = StringUtils.defaultString(request.getParameter(loginidname), null);
        if (userName != null)
        {
            secureUserLogin = (SecureUserLogin) userDetailsService.loadUserByUsername(userName);
        }
        try
        {
            if (secureUserLogin != null)
            {
                secureUserLogin.setLoginFailureCnt(secureUserLogin.getLoginFailureCnt() + 1);
                userInfoService.updateUserInfo(secureUserLogin);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException();
        }
        
        super.setDefaultFailureUrl(this.defaultFailureUrl);
        super.onAuthenticationFailure(request, response, exception);
    }
}