package standard.mvc.component.business.baroboard.user.article.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import standard.mvc.component.business.baroboard.board.service.BoardService;
import standard.mvc.component.business.baroboard.board.service.TotalArticleService;
import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.board.vo.Comment;
import standard.mvc.component.business.baroboard.board.vo.TotalArticle;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLogin;

/**
 * Modification Information
 * 
 * @ author 전경훈
 * 
 * @since 2015. 7. 26
 * @version 1.0
 * @see <pre>
 * Class Name  : UserArticleController.java
 * Description : 바로보드-사용자 게시글관리 Controller 
 * Information : 사용자 게시글을 관리하는 컨트롤러
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 7. 26.      전경훈      최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Controller
@RequestMapping(value = "/user/article")
public class UserArticleController extends GenericAbstractController {

	@Autowired
	private TotalArticleService totalArticleService;
	
	@Autowired
	private BoardService boardService;
	
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/index.do", method = { RequestMethod.GET })
	public String showIndexPage(ModelMap modelMap, @ModelAttribute TotalArticle totalArticle) throws Exception {
		// TODO : pageNum 검증, boardID 검증
		
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof SecureUserLogin) {
			totalArticle.setRegID( ((SecureUserLogin) user).getId() );
		} else {
			throw new Exception("허가되지 않은 사용자입니다.");
		}
		
		int totPages = ( totalArticleService.getTotalArticleCountByRegID(totalArticle) / totalArticle.getPageSize() ) + 1;
		
		List<TotalArticle> totalArticleList = totalArticleService.getArticlesByRegIDAndPage(totalArticle);
		modelMap.addAttribute("totalArticleList", totalArticleList);
		
		// 좌측 화살표  
		if(totalArticle.getPageNum() > totalArticle.getPageSize()) {
			int leftPage = (((totalArticle.getPageNum() / 10) - 1) * 10) + 1;
			modelMap.addAttribute("leftPage", leftPage);
		}
		
		// a링크 ( 단위 : 10 )
		int startPageNum = ((totalArticle.getPageNum() - 1) / 10 ) * 10 + 1;
		int endPageNum = (totPages - 1) / 10 == (totalArticle.getPageNum() - 1) / 10 ? totPages : ((totalArticle.getPageNum() - 1) / 10 + 1) * 10;
		modelMap.addAttribute("startPageNum", startPageNum);
		modelMap.addAttribute("endPageNum", endPageNum);
		modelMap.addAttribute("currentPageNum", totalArticle.getPageNum());
		
		// 우측 화살표
		if(totPages > ((totalArticle.getPageNum() - 1) / totalArticle.getPageSize() + 1) * 10) {
			int rightPage = ((totalArticle.getPageNum() - 1) / totalArticle.getPageSize() + 1) * 10 + 1;
			modelMap.addAttribute("rightPage",rightPage);
		}
		
		return "/jsp/user/article/index";
	}
	
	@RequestMapping(value = "/readArticlePopup.do")
	public String readArticle(ModelMap modelMap,  TotalArticle totalArticle) throws Exception {
		
		Article article = new Article();
		int userID;
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof SecureUserLogin) {
			userID = ((SecureUserLogin)user).getId();
		} else {
			throw new Exception("허가되지 않은 사용자입니다.");
		}
		
		article.setC_id(totalArticle.getArticleID());
		article.setBoardID(totalArticle.getBoardID());
		article.setRegID(userID);
		
		Article targetArticle = boardService.readArticle(article);
		Comment comment = new Comment();
		comment.setArticleID(article.getC_id());
		List<Comment> commentList = boardService.getCommentList(comment);
		
		modelMap.addAttribute("loginedUserID", userID );
		modelMap.addAttribute("article", targetArticle);
		modelMap.addAttribute("commentList", commentList);
		return "/jsp/user/article/detailView";
	}
}

