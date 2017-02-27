/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Simple little @Controller that invokes Facebook and renders the result.
 * The injected {@link Facebook} reference is configured with the required authorization credentials for the current user behind the scenes.
 * @author Keith Donald
 */
package egovframework.com.uss.ion.fbk.web;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovUserDetailsService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.ext.jstree.support.util.StringUtils;
import egovframework.com.uat.uia.service.EgovLoginService;
import egovframework.rivalwar.api.snsLogin.service.FacebookLoginService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.fdl.security.userdetails.EgovUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Facebook을 처리하는 Controller Class 구현
 * @author 표준프레임워크센터
 * @since 2014.11.10
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일     	수정자          		      수정내용
 *  -----------    --------------------    ---------------------------
 *  2014.11.10		표준프레임워크센터		      최초 생성
 *  </pre>
 */
@Controller
public class EgovFacebookController {

	private final Facebook facebook;

	@Autowired
	private FacebookLoginService facebookLoginService;

	@Inject
	public EgovFacebookController(Facebook facebook) {
		this.facebook = facebook;
	}

	@Inject
	private ConnectionRepository connectionRepository;

	/** EgovLoginService */
	@Resource(name = "loginService")
	private EgovLoginService loginService;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/**
	 * EgovPropertyService
	 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	static EgovUserDetailsService egovUserDetailsService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * facebook 연동을 위한 목록을 보여준다.
	 * @return String - 리턴 Url
	 */
	@IncludedInfo(name="Facebook 연동",order = 831 ,gid = 50)
	@RequestMapping(value = "/uss/ion/fbk/facebook.do", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) throws Exception {

		//original code = return "egovframework/com/uss/ion/fbk/EgovFacebookHome";

		Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
		if (connection == null) {
			return "redirect:/connect/facebook";
		}

		FacebookProfile facebookAccount = connection.getApi().userOperations().getUserProfile();
		String resultString = facebookLoginService.getUserIdByLoginAndRegisterProcess(facebookAccount);
		if(StringUtils.isEmpty(resultString)){
			//최초 가입 되었기때문에 닉네임 셋팅 요청
			logger.info("==================1");
			throw new RuntimeException("resultString is empty");
		}else{
			if(StringUtils.equals(resultString, "joinedAccount")){
				logger.info("==================2");
				// 1. 일반 로그인 처리
				LoginVO loginVO = new LoginVO();
				loginVO.setUserSe("GNR");
				loginVO.setId(facebookAccount.getId());
				loginVO.setPassword(propertiesService.getString("tempPassword"));
				LoginVO resultVO = loginService.actionLogin(loginVO);
				logger.info(resultVO.getId() + "<===========");
				if (resultVO != null && resultVO.getId() != null && !resultVO.getId().equals("")) {

					// 2-1. 로그인 정보를 세션에 저장
					request.getSession().setAttribute("loginVO", resultVO);

					return "redirect:/uat/uia/actionMain.do";
				} else {
					logger.info("==================3");
					model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
					return "egovframework/com/uat/uia/EgovLoginUsr";
				}

			}else{
				//"plzGiveMeyourNickName";
				logger.info("==================4");
				return "egovframework/com/uss/ion/fbk/EgovFacebookHome";
			}
		}
	}

	/**
	 * facebook 담벼락 목록을 보여준다.
	 * @return String - 리턴 Url
	 */
	@IncludedInfo(name = "RivalWar Admin Facebook Login",
			listUrl = "/uss/ion/fbk/facebookSignin.do",
			order = 7002,
			gid = 3131)
	@RequestMapping(value="/uss/ion/fbk/feed.do", method=RequestMethod.GET)
	public String showFeed(Model model) {
		model.addAttribute("feed", facebook.feedOperations().getFeed());
		return "egovframework/com/uss/ion/fbk/EgovFacebookFeed";
	}

	/**
	 * facebook 담벼락 내용을 입력한다.
	 * @return String - 리턴 Url
	 */
	@RequestMapping(value="/uss/ion/fbk/feed.do", method=RequestMethod.POST)
	public String postUpdate(String message) {
		facebook.feedOperations().updateStatus(message);
		return "redirect:/uss/ion/fbk/feed.do";
	}

	/**
	 * facebook 앨범 목록을 보여준다.
	 * @return String - 리턴 Url
	 */
	@RequestMapping(value="/uss/ion/fbk/albums.do", method=RequestMethod.GET)
	public String showAlbums(Model model) {
		model.addAttribute("albums", facebook.mediaOperations().getAlbums());
		return "egovframework/com/uss/ion/fbk/EgovFacebookAlbums";
	}

	/**
	 * facebook 앨범을 보여준다.
	 * @return String - 리턴 Url
	 */
	@RequestMapping(value="/uss/ion/fbk/album/{albumId}", method=RequestMethod.GET)
	public String showAlbum(@PathVariable("albumId") String albumId, Model model) {
		model.addAttribute("album", facebook.mediaOperations().getAlbum(albumId));
		model.addAttribute("photos", facebook.mediaOperations().getPhotos(albumId));
		return "egovframework/com/uss/ion/fbk/EgovFacebookAlbum";
	}

	/**
	 * facebook profile을 보여준다.
	 * @return String - 리턴 Url
	 */
	@RequestMapping(value="/uss/ion/fbk/profile.do", method=RequestMethod.GET)
	public String profile(Model model) {
		Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
		if (connection == null) {
			return "redirect:/connect/facebook";
		}
		model.addAttribute("profile", connection.getApi().userOperations().getUserProfile());
		return "egovframework/com/uss/ion/fbk/EgovFacebookProfile";
	}

}
