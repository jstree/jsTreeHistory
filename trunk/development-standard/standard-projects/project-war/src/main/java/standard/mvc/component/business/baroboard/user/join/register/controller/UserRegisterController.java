package standard.mvc.component.business.baroboard.user.join.register.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import standard.mvc.component.business.baroboard.user.join.register.service.UserRegisterService;
import standard.mvc.component.business.baroboard.user.vo.User;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @ author 오권우
 * 
 * @since 2015. 6. 02.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserRegisterController.java
 * Description : 회원가입- 사용자 등록 Controller 
 * Information : 회원가입- 사용자 등록 컨트롤러
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 6. 02.      오권우        최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Controller
@RequestMapping(value = "/user/join/register")
public class UserRegisterController extends GenericAbstractController {

	@Autowired
    private UserRegisterService userRegisterService;
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/save.do")
	public String UserRegister(Map<String , String> params, HttpServletRequest req) throws Exception{
		String mailId = req.getParameter("mailId");
		String mailUrl = req.getParameter("mailUrl");
		
		
		User user = new User();
	    user.setC_title(req.getParameter("nickName"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(mailId + "@" + mailUrl );
        
		userRegisterService.userRegister(user);
        return "{}";
	}
}