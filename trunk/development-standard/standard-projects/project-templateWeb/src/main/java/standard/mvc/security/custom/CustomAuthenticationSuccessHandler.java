package standard.mvc.security.custom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private RequestCache requestCache = new HttpSessionRequestCache();
	
	private static final String AJAX_HEADER_NAME = "X-Requested-With";//header 정보 중 ajax 요청일 시 해더 이름 값
	private static final String AJAX_HEADER_VALUE = "XMLHttpRequest";//header 정보 중 ajax 요청일 시 해더 값
	
	/**
	 * 인증 성공 시 ajax 요청인 경우 별도 redirect 로직 삭제 및 인증 요소 초기화 작업
	 */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {    	
    	if(AJAX_HEADER_VALUE.equals(request.getHeader(AJAX_HEADER_NAME))){//아작스 요청
            successAuthenticationByAjaxCall(request, response);
        }else{//폼 방식 요청
        	super.onAuthenticationSuccess(request, response, authentication);	
        }
        
    }

	
    private void successAuthenticationByAjaxCall(HttpServletRequest request,
			HttpServletResponse response) {
		SavedRequest savedRequest = requestCache.getRequest(request, response);

		if (savedRequest == null) {
			clearAuthenticationAttributes(request);
		    return;
		}
		String targetUrlParameter = getTargetUrlParameter();
		if (isAlwaysUseDefaultTargetUrl() || (targetUrlParameter != null && StringUtils.hasText(request.getParameter(targetUrlParameter)))) {
		    requestCache.removeRequest(request, response);
		    clearAuthenticationAttributes(request);

		    return;
		}
		
		clearAuthenticationAttributes(request);
	}
    
}
