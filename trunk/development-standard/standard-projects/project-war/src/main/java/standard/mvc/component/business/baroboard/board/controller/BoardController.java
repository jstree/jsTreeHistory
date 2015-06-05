package standard.mvc.component.business.baroboard.board.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import standard.mvc.component.business.baroboard.board.service.BoardService;
import standard.mvc.component.business.baroboard.board.vo.Article;
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
 * Infomation  : 게시판의 글, 코멘트 등을 관리하는 컨트롤러
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 26.      전경훈        최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Controller
@RequestMapping(value = "/board")
public class BoardController extends GenericAbstractController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "BoardService")
	private BoardService boardService;

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/index.do", method = { RequestMethod.GET })
	public String showIndexPage(ModelMap modelMap, @ModelAttribute Article article) throws Exception {
		
		// TODO : pageNo 검증
		List<Article> announceList = boardService.getAnnounceList(article);
		List<Article> articleList = boardService.getArticleList(article);
		
		logger.debug("-- ArticleList Size--");
		logger.debug(articleList.size()+"  사이즈");
		
		modelMap.addAttribute("announceList", announceList);
		modelMap.addAttribute("articleList", articleList);
		modelMap.addAttribute("pageName", "테스트게시판");
		return "/jsp/board/index";
	}

	@RequestMapping(value = "/readArticle.do")
	public String readArticle(ModelMap modelMap, @ModelAttribute Article article) throws Exception {

		return "/jsp/board/readArticle";
	}

	@RequestMapping(value = "/newArticle.do")
	public String addArticle(ModelMap modelMap) {

		return "/jsp/board/newArticle";
	}

	@RequestMapping(value = "/submitNewArticle.do")
	public Article submitNewArticle(ModelMap modelMap, @ModelAttribute Article article) throws Exception {

		return null;
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

	// TODO : 검색조건
}
