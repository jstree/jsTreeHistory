package standard.mvc.component.business.baroboard.user.scrap.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.board.service.BoardService;
import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.user.scrap.service.UserScrapService;
import standard.mvc.component.business.baroboard.user.scrap.vo.UserScrap;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLogin;

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
	private BoardService boardService;
	
	@Autowired
    private UserScrapService userScrapService;
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/index.do", method = {RequestMethod.GET})
	public String scrapList(ModelMap modelMap, @ModelAttribute UserScrap userScrap) throws Exception{
		/*
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		SecureUserLogin user = (SecureUserLogin) (authentication == null ? null : authentication.getPrincipal());
		userScrap.setUserId(user.getUserid());
		
		System.out.println("=======================");
		System.out.println("userId : " + userScrap.getUserId());
		System.out.println("=======================");
		//int userId = 0;
		*/
		userScrap.setUserId(3);
		String boardId = userScrap.getBoardId();
		int totalPageCount = userScrapService.getScrapListTotalCnt(userScrap) / userScrap.getPageSize() + 1;
		
		int postingId = userScrap.getPostingId();
		
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
		
		modelMap.addAttribute("boardId", boardId);
		
        return "/jsp/user/scrap/index";
	}
	
	
	@RequestMapping(value = "/delete.do", method = {RequestMethod.GET})
	@ResponseBody
	public String scapDelete(ModelMap model, @ModelAttribute Article article) throws Exception {
		UserScrap userScrap = new UserScrap();
		
		//userScrap.setPostingId(article.getC_id());
		//coreService.removeNode(userScrap);
		return "/jsp/user/scrap/index";
	}
	
	@RequestMapping(value = "/readScrap.do")
	public String readArticle(ModelMap modelMap,  UserScrap userScrap) throws Exception {
		Article article = new Article();
		article.setC_id(userScrap.getPostingId());
		article.setBoardID(userScrap.getBoardId());
		
		Article targetArticle = boardService.readArticle(article);

		modelMap.addAttribute("article", targetArticle);
		return "/jsp/user/scrap/detailView";
	}
	
}