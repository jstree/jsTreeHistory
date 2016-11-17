package egovframework.rivalwar.sns.controller;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.ext.jstree.support.mvc.GenericAbstractController;

@Controller
@RequestMapping(value = { "/api/sns/facebook" })
public class RivalWarFaceBook extends GenericAbstractController{
	private Facebook facebook;
	private ConnectionRepository connectionRepository;
	
	@Inject
	public RivalWarFaceBook(Facebook facebook, ConnectionRepository connectionRepository) {
		this.facebook = facebook;
		this.connectionRepository = connectionRepository;
	}
	
	@RequestMapping("/connect.do")
	public String facebookLoginAfter(ModelMap model) {
		if(connectionRepository.findPrimaryConnection(Facebook.class)!= null){
			model.addAttribute("facebookProfile" , facebook.userOperations().getUserProfile());
		}
		return "rivalWar/api/sns/facebook";
	}
	
	@IncludedInfo(name = "jsTree Facebook", listUrl = "/api/sns/facebook/login.do", order = 3400, gid = 313)
	@RequestMapping("/login.do")
	public String facebookLogin(ModelMap model){
		return "rivalWar/api/sns/facebookLogin";
	}
	
}
