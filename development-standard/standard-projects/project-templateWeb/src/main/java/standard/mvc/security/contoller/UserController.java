package standard.mvc.security.contoller;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import standard.mvc.component.base.controller.GenericAbstractController;
import egovframework.com.cmm.util.EgovUserDetailsHelper;


@Controller
public class UserController extends GenericAbstractController{

	private static final String AJAX_HEADER_NAME = "X-Requested-With";//header 정보 중 ajax 요청일 시 해더 이름 값
	private static final String AJAX_HEADER_VALUE = "XMLHttpRequest";//header 정보 중 ajax 요청일 시 해더 값

	private static final Log logger = LogFactory.getLog(UserController.class);
	
	
	@RequestMapping(value = {"/login.do"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "/jsp/user/login";
	}
	
	//TODO : 각 url 은 환경 설정으로 추출 하여 설정 security-context.xml 및 컨트롤러 부분을 공통 적으로 적용이 필요하다.
	@RequestMapping(value = "/access_denied.do")
	public String access_denied(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if(AJAX_HEADER_VALUE.equals(request.getHeader(AJAX_HEADER_NAME))){//아작스 요청
			response.sendError(HttpServletResponse.SC_FORBIDDEN);//401
		}
		
		
		return "/jsp/user/accessDenied";
	}
	
	//TODO : 각 url 은 환경 설정으로 추출 하여 설정 security-context.xml 및 컨트롤러 부분을 공통 적으로 적용이 필요하다.
	@RequestMapping(value = "/login/fail.do")
	public String faleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "/user/login";
	}
	
	
	//TODO : 메소드 인터셉터를 DB에 저장 하기 때문에 오류 발생 시 디버깅이 힘든 단점이 발생한다.
	@RequestMapping(value = "/login/methodInterceptorTest.do")
	public String methodInterceptorTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "/user/login";
	}

	
	@RequestMapping(value = "/login/userInfoLog.do")
	public String userInfoLog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("[EgovUserDetailsHelper INFO 사용자 정보]"+EgovUserDetailsHelper.getAuthenticatedUser());
		logger.info("[EgovUserDetailsHelper INFO 사용자 정보]"+EgovUserDetailsHelper.getAuthorities());
		logger.info("[EgovUserDetailsHelper INFO 사용자 정보]"+EgovUserDetailsHelper.isAuthenticated());
		return "/user/login";
	}
	

	
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}
}
