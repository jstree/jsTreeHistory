package standard.mvc.security.custom;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

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
