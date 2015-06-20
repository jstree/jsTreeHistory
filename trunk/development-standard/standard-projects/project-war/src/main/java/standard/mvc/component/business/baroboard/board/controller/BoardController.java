package standard.mvc.component.business.baroboard.board.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.board.service.BoardService;
import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.board.vo.SearchArticle;
import standard.mvc.component.business.baroboard.user.manage.user.service.UserManageService;
import standard.mvc.component.business.baroboard.user.vo.User;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @ author 전경훈
 * 
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardController.java
 * Description : 바로보드-게시판 Controller 
 * Information : 게시판의 글, 코멘트 등을 관리하는 컨트롤러
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 26.      전경훈      최초 생성
 * 2015. 6.  3.      전경훈      showIndexPage, searchArticle 추가  
 * 2015. 6. 13.      전경훈      submitNewArticle 추가
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Controller
@RequestMapping(value = "/board")
public class BoardController extends GenericAbstractController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;

	@Autowired
	private UserManageService userManageService;
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/index.do", method = { RequestMethod.GET })
	public String showIndexPage(ModelMap modelMap, @ModelAttribute Article article) throws Exception {
		// TODO : pageNum 검증, boardID 검증
		String boardID = article.getBoardID();
		int totPages = boardService.getOpenArticleCnt(article) / article.getPageSize() + 1;
		
		List<Article> articleList = boardService.getArticleList(article);
		modelMap.addAttribute("articleList", articleList);
		
		// 1페이지일 경우, 공지사항을 보여준다.
		if(article.getPageNum() == 1) {
			List<Article> announceList = boardService.getAnnounceList(article);
			modelMap.addAttribute("announceList", announceList);
		}
		
		// 좌측 화살표  
		if(article.getPageNum() > article.getPageSize()) {
			int leftPage = (((article.getPageNum() / 10) - 1) * 10) + 1;
			modelMap.addAttribute("leftPage", leftPage);
		}
		
		// a링크 ( 단위 : 10 )
		int startPageNum = ((article.getPageNum() - 1) / 10 ) * 10 + 1;
		int endPageNum = (totPages - 1) / 10 == (article.getPageNum() - 1) / 10 ? totPages : ((article.getPageNum() - 1) / 10 + 1) * 10;
		modelMap.addAttribute("startPageNum", startPageNum);
		modelMap.addAttribute("endPageNum", endPageNum);
		modelMap.addAttribute("currentPageNum", article.getPageNum());
		
		// 우측 화살표
		if(totPages > ((article.getPageNum() - 1) / article.getPageSize() + 1) * 10) {
			int rightPage = ((article.getPageNum() - 1) / article.getPageSize() + 1) * 10 + 1;
			modelMap.addAttribute("rightPage",rightPage);
		}
		
		modelMap.addAttribute("boardID", boardID);
		modelMap.addAttribute("pageName", "테스트게시판");
		return "/jsp/board/index";
	}

	@RequestMapping(value = "/searchArticle.do", method = { RequestMethod.GET })
	public String searchArticle(ModelMap modelMap, @ModelAttribute SearchArticle searchArticle) throws Exception {
		
		List<Article> searchedArticleList = boardService.searchArticleList(searchArticle);
		
		modelMap.addAttribute("searchKeyword", searchArticle.getSearchKeyword());
		modelMap.addAttribute("type", searchArticle.getType());
		modelMap.addAttribute("articleList", searchedArticleList);
		return "/jsp/board/searchArticle";
	}
	
	@RequestMapping(value = "/readArticle.do")
	public String readArticle(ModelMap modelMap, @ModelAttribute Article article) throws Exception {
		Article targetArticle = boardService.getArticleById(article);
		
		modelMap.addAttribute("article", targetArticle);
		return "/jsp/board/readArticle";
	}

	@RequestMapping(value = "/newArticle.do")
	public String newArticle(ModelMap modelMap) {

		return "/jsp/board/newArticle";
	}

	@RequestMapping(value = "/submitNewArticle.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Article submitNewArticle(@ModelAttribute Article article) throws Exception {
		return boardService.addArticle(article);
	}

	@RequestMapping(value = "/modifyArticle.do")
	public String modifyArticle(ModelMap modelMap, @ModelAttribute Article article) throws Exception {

		return "jsp/board/modifyArticle";
	}

	@RequestMapping(value = "/submitModifiedArticle.do")
	public Article submitModifiedArticle(ModelMap modelMap, @ModelAttribute Article article) throws Exception {

		return null;
	}

	@RequestMapping(value = "/deleteArticle.do")
	public Article deleteArticle(ModelMap modelMap, @ModelAttribute Article article) throws Exception {

		return null;
	}
	
	@RequestMapping(value = "/getUserInfoPopup.do")
	public String getUserInfoByID(ModelMap modelMap, @ModelAttribute User user) throws Exception {
		User resultUser = userManageService.getUserInfoByID(user);
		modelMap.addAttribute("user", resultUser);
		return "/jsp/board/getUserInfoPopup";
	}
	
}
