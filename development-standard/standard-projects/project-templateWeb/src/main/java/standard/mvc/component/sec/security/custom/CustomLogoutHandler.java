package standard.mvc.component.sec.security.custom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
/**
 *  Class Name : CustomLogoutHandler.java
 *  Description : security 3.0.1b 간소화 설정으로 확장 커스터 마이징 불가 하며 확장성에 대한 검토가 필요하다. (로그아웃 시 실행될 클래스 )
 *  Modification Information
 * 
 *  @author 최대열
 *  @since 2014.07.10
 *  @version 1.0
 *  @see
 *
 *  <pre>
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.10                 최대열		   최초 생성
 *
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class CustomLogoutHandler extends SimpleUrlLogoutSuccessHandler {
    
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        super.onLogoutSuccess(request, response, authentication);
    }
}
