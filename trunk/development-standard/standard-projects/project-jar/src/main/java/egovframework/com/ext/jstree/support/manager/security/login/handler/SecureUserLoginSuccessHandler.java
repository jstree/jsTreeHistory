package egovframework.com.ext.jstree.support.manager.security.login.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
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
    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    UserInfoService userInfoService;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException
    {
        SecureUserLogin secureUserLogin = (SecureUserLogin) authentication.getPrincipal();
        secureUserLogin = (SecureUserLogin) userDetailsService
                .loadUserByUsername(secureUserLogin.getUsername());
        try
        {
            secureUserLogin.setLastLoginDt(DateUtils.format("yyyyMMddHHmmss", DateUtils.getCurrentDay()));
            secureUserLogin.setLoginFailureCnt(0);
            userInfoService.updateUserInfo(secureUserLogin);
        }
        catch (Exception e)
        {
            throw new RuntimeException();
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}