package standard.mvc.controller.spring.community.springSecurity;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	private static final String AJAX_HEADER_NAME = "X-Requested-With";//header 정보 중 ajax 요청일 시 해더 이름 값
	private static final String AJAX_HEADER_VALUE = "XMLHttpRequest";//header 정보 중 ajax 요청일 시 해더 값

	//private static final Logger logger = LoggerFactory.getLogger(UserController.class);


	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "/user/login";
	}
	
	//TODO : 각 url 은 환경 설정으로 추출 하여 설정 security-context.xml 및 컨트롤러 부분을 공통 적으로 적용이 필요하다.
	@RequestMapping(value = "/access_denied")
	public String json(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if(AJAX_HEADER_VALUE.equals(request.getHeader(AJAX_HEADER_NAME))){//아작스 요청
			response.sendError(HttpServletResponse.SC_FORBIDDEN);//401
		}
		
		
		return "user/accessDenied";
	}
	
	//TODO : 각 url 은 환경 설정으로 추출 하여 설정 security-context.xml 및 컨트롤러 부분을 공통 적으로 적용이 필요하다.
	@RequestMapping(value = "/login/fail")
	public String faleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "/user/login";
	}
	
	
	//TODO : 메소드 인터셉터를 DB에 저장 하기 때문에 오류 발생 시 디버깅이 힘든 단점이 발생한다.
	@RequestMapping(value = "/login/methodInterceptorTest")
	public String methodInterceptorTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "/user/login";
	}
}
