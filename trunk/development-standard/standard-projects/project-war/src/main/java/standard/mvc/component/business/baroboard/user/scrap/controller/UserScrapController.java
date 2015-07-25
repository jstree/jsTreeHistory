package standard.mvc.component.business.baroboard.user.scrap.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import standard.mvc.component.business.baroboard.board.vo.Comment;
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
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="CoreService")
	private CoreService coreService;
	
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
		//SecureUserLogin secureUserLogin =(SecureUserLogin)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//userScrap.setUserId(secureUserLogin.getUserId());
	
		userScrap.setUserId(3);
		int boardId = userScrap.getBoardId();
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
		
		modelMap.addAttribute("boardId", boardId);
		
        return "/jsp/user/scrap/index";
	}
	
	
	@RequestMapping(value = "/delete.do")
	@ResponseBody
	public String scapDelete(ModelMap model, @ModelAttribute Article article) throws Exception {
		UserScrap userScrap = new UserScrap();
		
		userScrap = userScrapService.getDeleteScrapId(article.getC_id());
		coreService.removeNode(userScrap);
		
		return "{}"; 
	}
	
	@RequestMapping(value = "/readScrapPopup.do")
	public String readArticle(ModelMap modelMap,  UserScrap userScrap) throws Exception {
		
		Article article = new Article();
		article.setC_id(userScrap.getBoardId());
		
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String isGuestUser = "";
		int loginedUserID;
		if(user instanceof String) {
			String userStr = (String)user;
			if(userStr.equals("anonymousUser")) {
				isGuestUser = "1";	// 게스트
			} else {
				throw new Exception("허가되지 않은 사용자입니다.");
			}
		} else {
			isGuestUser = "0";		// 일반사용자
			SecureUserLogin loginedUser = (SecureUserLogin) user;
			loginedUserID = loginedUser.getId();
			modelMap.addAttribute("loginedUserID", loginedUserID);
		}
		
		Article targetArticle = boardService.readArticle(article);
		Comment comment = new Comment();
		comment.setArticleID(article.getC_id());
		List<Comment> commentList = boardService.getCommentList(comment);
		
		modelMap.addAttribute("isGuestUser", isGuestUser);
		modelMap.addAttribute("article", targetArticle);
		modelMap.addAttribute("commentList", commentList);
		return "/jsp/user/scrap/detailView";
	}
	
}