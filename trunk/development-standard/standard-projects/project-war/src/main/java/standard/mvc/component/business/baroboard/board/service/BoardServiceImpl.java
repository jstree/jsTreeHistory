package standard.mvc.component.business.baroboard.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.board.dao.BoardDao;
import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.board.vo.SearchArticle;
import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardServiceImpl.java
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

@Service(value = "BoardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Resource(name = "CoreDao")
	private CoreDao coreDao;

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Article> getArticleList(Article article) throws Exception {
		return boardDao.getArticleListByPage(article);
	}

	@Override
	public List<Article> searchArticleList(SearchArticle searchArticle) throws Exception {
		return null;
	}

	@Override
	public Article addArticle(Article article) throws Exception {
		return coreService.addNode(article);
	}

	@Override
	public Article alterArticle(Article article) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article removeArticle(Article article) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
