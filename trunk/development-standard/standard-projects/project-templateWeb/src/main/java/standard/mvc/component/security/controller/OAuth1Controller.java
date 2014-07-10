package standard.mvc.component.security.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import standard.mvc.component.security.service.OAuth1Service;





@Controller
public class OAuth1Controller {
	
	@Autowired
	private OAuth1Service googleService;

	@RequestMapping(value={"/google/picasa.do","/oauth1"})
	public String photos(Model model) {
		model.addAttribute("photoUrls", googleService.getLastTenPicasaPictureURLs());
		return "/jsp/oauth1/other_server_goole_twitter";
	}

	@RequestMapping("/twitter/test.do")
	public String test(Model model) {
		model.addAttribute("twitterInfo", googleService.getTwiterRestTemplate());
		return "/jsp/oauth1/other_server_goole_twitter";
	}
	
	public void setGoogleService(OAuth1Service googleService) {
		this.googleService = googleService;
	}
	
}
