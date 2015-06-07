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
 * Infomation  : 회원가입- 사용자 등록 컨트롤러
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
		user.setC_position(1);
	    user.setC_title(req.getParameter("nickName"));
        user.setC_type("default");
        user.setRef(2);
        
        user.setUserGrade(1);
        user.setJoinStateCd(2);
        user.setPassword(req.getParameter("password"));
        user.setEmail(mailId + "@" + mailUrl );
        user.setLoginFailureCnt(0);
        
        user.setPasswordFindQuestion("초등학교 이름은");
        user.setPasswordFindAnswer("부원초등학교");
        user.setMailingServiceUseFl("0");
        user.setIndiInfoOpenFl("0");
        //user.setJoinDt("20150425205811");
        
        //user.setPasswordChangeDt("20150425205811")));
        user.setHomepageUrl(" ");
        user.setBlogUrl(" ");
        user.setSign(" ");
        user.setProfilePhoto(" ");
        user.setImageIcon(" ");
        
		userRegisterService.userRegister(user);
        return "{}";
	}
}