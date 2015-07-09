package standard.mvc.component.business.baroboard.user.login;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.user.service.UserService;
import standard.mvc.component.business.baroboard.user.vo.PasswordFindQuestion;
import standard.mvc.component.business.baroboard.user.vo.User;
import standard.mvc.component.business.community.log.service.LogUrlSerivce;
import standard.mvc.component.business.community.menu.service.MenuMngSerivce;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @author 김형채
 * 
 * @since 2015. 6. 16.
 * @version 1.0
 * @see <pre>
 * Class Name  : SecureUserLoginController.java
 * Description : 로그인- 로그인 SecureUserLoginController 
 * Information : 로그인- 로그인 SecureUserLoginController
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -----------   ------------  -----------------------
 * 2015. 06.16.  김형채 		      최초 생성
 * 2015. 06.24.  김형채 		      상태코드 수정
 * 2015. 06.24.  김형채 		      상태코드 분기추가
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Controller
@RequestMapping(value = "/user/login")
public class SecureUserLoginController extends GenericAbstractController 
{
	@Resource(name = "menuMngService")
	private MenuMngSerivce menuMngService;
	
	@Resource(name = "logUrlService")
	private LogUrlSerivce logUrlService;
	
	@Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index.do")
	public String login( ModelMap model, HttpServletRequest request) throws Exception 
	{
		String errorCode = (String) request.getSession().getAttribute("errorCode");
		
		final String EMAILNOTFOUND = "1";
		final String ACCOUNTLOCKED = "2";
		final String WRONGPASSWORD = "3";
		final String LOGINLIMITDAY = "4";
		
		if ( StringUtils.isNotBlank(errorCode) )
		{
			if( StringUtils.equals(EMAILNOTFOUND, errorCode) )
			{
				model.addAttribute("errorMsg", this.egovMessageSource.getMessage("bb.login.error.002")); 
			}
			else if( StringUtils.equals(ACCOUNTLOCKED, errorCode) )
			{
				model.addAttribute("errorMsg", this.egovMessageSource.getMessage("bb.login.error.008"));
			}
			else if( StringUtils.equals(WRONGPASSWORD , errorCode) )
			{
				Object[] args = {new String((String) request.getSession().getAttribute("loginFailureCnt"))};
				model.addAttribute("errorMsg", this.egovMessageSource.getMessage("bb.login.error.003", args));
				
			}
			else if( StringUtils.equals(LOGINLIMITDAY, errorCode) )
			{
				model.addAttribute("errorMsg", this.egovMessageSource.getMessage("bb.login.error.009"));
			}
			
			request.getSession().removeAttribute("errorCode");
			request.getSession().removeAttribute("loginFailureCnt");
		}
		
		model.addAttribute("menuList", menuMngService.getCommunityMenu());
		model.addAttribute("logUrl", logUrlService.getLogUrl());
        return "/jsp/user/login/index";
	}
	
	@RequestMapping("/initPassword.do")
	public String initPassword(ModelMap model) throws Exception 
	{
		model.addAttribute("menuList", menuMngService.getCommunityMenu());
		model.addAttribute("logUrl", logUrlService.getLogUrl());
		return "/jsp/user/login/initPassword";
	}
	
	@RequestMapping("/findPasswordQuestion.do")
	@ResponseBody
	public User findPasswordQuestion( @RequestParam("email") String email ) throws Exception 
	{
		Assert.notNull(email, "'email' must not be null");
		
		User user = new User();
		user.setEmail(email);
		user = this.userService.findUserByEmail(user);
		List<PasswordFindQuestion> findQuestions = this.userService.getPasswordFindQuestions();
		
		for (PasswordFindQuestion passwordFindQuestion : findQuestions)
		{
			if( passwordFindQuestion.getC_id() == user.getPwdFindQuestionCd() )
			{
				user.setPwdFindQuestion(passwordFindQuestion.getC_title());
			}
		}
		
		return user;
	}
	
	@RequestMapping(value = "/checkPasswordAnswer.do" ,method = RequestMethod.POST )
	@ResponseBody
	public User checkPasswordAnswer( @RequestParam("email") String email,  @RequestParam("answer") String answer) throws Exception 
	{
		Assert.notNull(email, "'email' must not be null");
		Assert.notNull(answer, "'answer' must not be null");
		
		User user = new User();
        user.setEmail(email);
		
		user = this.userService.findUserByEmail(user);
		
		final int FAILURE = 0;
		final int SUCCESS = 1;
		final int SHA256 = 256;
		
		if( StringUtils.equals(answer, user.getPwdFindAnswer()) )
		{
			ShaPasswordEncoder encoder=new ShaPasswordEncoder(SHA256);
			String encoderUserEmail = encoder.encodePassword(user.getEmail(), null);
			
			user.setPassword(encoderUserEmail);
			
			int returnCnt = userService.initUserPassword(user);
			
			if ( returnCnt > 0 ) user.setStatus(SUCCESS); 
			else                 user.setStatus(FAILURE);
		}
		else
		{
			user.setStatus(FAILURE);
		}
		return user;
	}
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() 
	{
		return null;
	}
}