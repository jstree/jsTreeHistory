package standard.mvc.component.business.baroboard.user.scrap.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import standard.mvc.component.business.baroboard.user.scrap.service.UserScrapService;
import standard.mvc.component.business.baroboard.user.scrap.vo.UserScrap;
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
@RequestMapping(value = "/user/scrap/")
public class UserScrapController extends GenericAbstractController {

	@Autowired
    private UserScrapService userScrapService;
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/index.do", method = {RequestMethod.GET})
	public String scrapList(ModelMap modelMap, @ModelAttribute UserScrap userScrap) throws Exception{
		int totalPageCount = userScrapService.getScrapListTotalCnt(userScrap) / userScrap.getPageSize() + 1;
		
		List<UserScrap> scrapList = userScrapService.scrapList(userScrap); 
		modelMap.addAttribute("scrapList", scrapList);
		
		// 좌측 화살표  
		if(userScrap.getPageNum() > userScrap.getPageSize()) {
			int leftPage = (((userScrap.getPageNum() / 10) - 1) * 10) + 1;
			modelMap.addAttribute("leftPage", leftPage);
		}
		
		// a링크 ( 단위 : 10 )
		int startPageNum = ((userScrap.getPageNum() - 1) / 10 ) * 10 + 1;
		int endPageNum = (totalPageCount - 1) / 10 == (userScrap.getPageNum() - 1) / 10 ? totalPageCount : ((userScrap.getPageNum() - 1) / 10 + 1) * 10;
		modelMap.addAttribute("startPageNum", startPageNum);
		modelMap.addAttribute("endPageNum", endPageNum);
		modelMap.addAttribute("currentPageNum", userScrap.getPageNum());
		
		// 우측 화살표
		if(totalPageCount > ((userScrap.getPageNum() - 1) / userScrap.getPageSize() + 1) * 10) {
			int rightPage = ((userScrap.getPageNum() - 1) / userScrap.getPageSize() + 1) * 10 + 1;
			modelMap.addAttribute("rightPage",rightPage);
		}
        return "/jsp/user/scrap/index";
	}
	
	@RequestMapping(value = "/getScrapPopup.do")
	public String getScapDetailView(ModelMap modelMap, @ModelAttribute UserScrap userScrap) throws Exception {
		UserScrap resultScrap = userScrapService.getScrapDetailView(userScrap);
		modelMap.addAttribute("userScrap", resultScrap);
		return "/jsp/user/scrap/getScrapPopup";
	}
	
	@RequestMapping(value = "/delete.do", method = {RequestMethod.GET})
	public String scapDelete(ModelMap model, UserScrap userScrap) throws Exception {
		userScrapService.scrapDelete(userScrap);
		return "/jsp/user/scrap/index";
	}
	
	/*
	@RequestMapping(value = "/view.do", method = {RequestMethod.POST})
	public String scapView(ModelMap model, HttpServletRequest req) throws Exception {
		return "/jsp/user/scrap/view";
	}
	*/
	
	
	
	@RequestMapping(value = "/save.do", method = {RequestMethod.POST})
	public String scrapViewDetail(HttpServletRequest req) throws Exception{
		
        return "/jsp/user/join/login/index";
	}
}