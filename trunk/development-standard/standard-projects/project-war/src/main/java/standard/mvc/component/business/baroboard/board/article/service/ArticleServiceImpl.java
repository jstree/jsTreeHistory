package standard.mvc.component.business.baroboard.board.article.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.board.article.vo.Article;
import standard.mvc.component.business.baroboard.board.article.vo.SearchArticle;
import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : ArticleServiceImpl.java
 * Description : 바로보드-게시판-글관리 Service 구현체
 * Infomation  : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 25.      전경훈        최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Service(value = "ArticleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Resource(name = "CoreDao")
	private CoreDao coreDao;

	@Override
	public List<Article> getArticleList(String boardID, int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> searchArticleList(String boardID, SearchArticle searchArticle) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article addArticle(String boardID, Article article) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article alterArticle(String boardID, Article article) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article removeArticle(String boardID, Article article) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
