package standard.mvc.component.security.controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import standard.mvc.component.base.controller.GenericAbstractController;
import standard.mvc.component.security.service.OAuth1Service;



/**
 *  Class Name : OAuth1Controller.java
 *  Description : oauth1 연동 테스트를 위한 컨트롤러 (google, twitter)
 *  Modification Information
 * 
 *  @author 최대열
 *  @since 2014.07.10
 *  @version 1.0
 *  @see
 *
 *  <pre>
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.10                 최대열		   최초 생성
 *
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@RequestMapping("/oauth1")
@Controller
public class OAuth1Controller extends GenericAbstractController{
	
	
	@Autowired
	private OAuth1Service oauth1Service;//oauth1 서비스 예제(google, twitter)
	
	
	/**
	 * google/picasa 사이트에서 이미지 URL 을 얻어옴
	 * @param model
	 * @return
	 */
	@RequestMapping("/google/picasa.do")
	public String google(Model model) {
		model.addAttribute("photoUrls", oauth1Service.getLastTenPicasaPictureURLs());
		return "/jsp/standard/security/oauth1/example_goole_twitter";
	}

	/**
	 * 트위터에서 로그인 사용자 정보를 JSON 형태로 얻어옴
	 * @param model
	 * @return
	 */
	@RequestMapping("/twitter/userinfo.do")
	public String twitter(Model model) {
		model.addAttribute("twitterInfo", oauth1Service.getTwiterRestTemplate());
		return "/jsp/standard/security/oauth1/example_goole_twitter";
	}

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
