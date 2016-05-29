package egovframework.com.ext.jstree.support.manager.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.ext.jstree.support.manager.security.login.service.UserInfoService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;

/**
 * Modification Information
 * 
 * @author hyungchae.Kim
 * @since 2016. 4. 29.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: SndngMailController.java
 * 	Description : 발송메일 컨트롤러
 * 	Infomation	: 발송메일  
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일                             수정자                                   수정내용
 *  ------------  --------------   -----------------------
 *  2016. 4. 29.  hyungchae.kim    최초 생성
 *  
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 * 
 */
@Controller
@RequestMapping(value = { "/egovframework/com/etc/jstree/support/manager/mail" })
public class SndngMailController {
	
	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping(value = "/santMailConfirm.do", method = RequestMethod.GET)
	public String santMailConfirm(@RequestParam String uuid) throws Exception{
		String reDirectUrl = "";
		UserInfo userInfo = new UserInfo();
		userInfo.setUuid(uuid);
		if(userInfoService.getUserByUuid(userInfo)  != null) {
			userInfoService.updateUseYnByUuid(userInfo);
			reDirectUrl = "/account/accountSign.do";
		} else {
			reDirectUrl = "/index.do";
		}
		return reDirectUrl;
	}
}