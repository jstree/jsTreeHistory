package standard.mvc.component.sec.security.custom;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
/**
 *  Class Name : CustomAuthenticationFailureHandler.java
 *  Description : security 3.0.1b 간소화 설정으로 확장 커스터 마이징 불가 하며 확장성에 대한 검토가 필요하다. (인증 실패 시 실행 핸들러)
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
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	private static final String AJAX_HEADER_NAME = "X-Requested-With";//header 정보 중 ajax 요청일 시 해더 이름 값
	private static final String AJAX_HEADER_VALUE = "XMLHttpRequest";//header 정보 중 ajax 요청일 시 해더 값
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);

	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
    	if(logger.isInfoEnabled()){
    		logger.info("[CustomAuthenticationFailureHandler onAuthenticationFailure exception=================]"+exception.getCause()+exception.getMessage());
    	}
    	
    	if(AJAX_HEADER_VALUE.equals(request.getHeader(AJAX_HEADER_NAME))){//아작스 요청
    		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);//401
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
        
    }
}
