package egovframework.com.ext.jstree.support.manager.security.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.ext.jstree.support.manager.security.login.service.UserInfoService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;

/**
 * Modification Information
 * 
 * @author hyungchae.Kim
 * @since 2016. 4. 29.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: UserInfoManageController.java
 * 	Description : 사용자 정보 관리 컨트롤러
 * 	Infomation	: 사용자 정보 관리 
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일                             수정자                                   수정내용
 *  ------------  --------------   -----------------------
 *  2016. 4. 29.  hyungchae.kim    최초 생성
 *  
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = { "/egovframework/com/etc/jstree/support/manager/security/login" })
public class UserInfoController {
	@Autowired
	UserInfoService userInfoService;
	
    @RequestMapping(value = "/userInfoInsert.do", method = RequestMethod.POST)
    @ResponseBody
	public String userInfoInsert(@Validated UserInfo userInfo,BindingResult bindingResult) throws Exception{
    	if (bindingResult.hasErrors())
			throw new RuntimeException();
    	try {
    		this.userInfoService.insertUserInfo(userInfo);	
		} catch (Exception e) {
			return "{ \"status\" : \"0\" }";
		}    	
		return "{ \"status\" : \"1\" }";
	}
    
    @RequestMapping(value = "/updatePassword.do", method = RequestMethod.POST)
    @ResponseBody
	public String updatePassword(@Validated UserInfo userInfo,BindingResult bindingResult) throws Exception{
    	if (bindingResult.hasErrors())
			throw new RuntimeException();
    	try {
    		this.userInfoService.updatePassword(userInfo);	
		} catch (Exception e) {
			return "{ \"status\" : \"0\" }";
		}    	
		return "{ \"status\" : \"1\" }";
	}
    
    @RequestMapping(value = "/loginSucceeded.do")
    @ResponseBody
	public String loginSucceeded() throws Exception{
		return "{ \"status\" : \"1\" }";
	}
    
    @RequestMapping(value = "/loginFailed.do")
    @ResponseBody
	public String loginFailed() throws Exception{
		return "{ \"status\" : \"0\" }";
	}
    
    @RequestMapping(value = "/logoutSucceeded.do")
    @ResponseBody
	public String logoutSucceeded() throws Exception{
		return "{ \"status\" : \"1\" }";
	}
}
