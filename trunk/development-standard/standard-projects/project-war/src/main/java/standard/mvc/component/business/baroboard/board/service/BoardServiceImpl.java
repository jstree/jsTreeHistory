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
		List<Article> list = boardDao.getArticleListByPage(article);
		changeRegDTFormat(list);
		return list;
	}

	@Override
	public List<Article> getAnnounceList(Article article) throws Exception {
		List<Article> list = boardDao.getAnnounceList(article);
		changeRegDTFormat(list);
		return list;
	}
	
	@Override
	public List<Article> searchArticleList(SearchArticle searchArticle) throws Exception {
		List<Article> list = boardDao.searchArticle(searchArticle);
		changeRegDTFormat(list);
		return list;
	}
	
	@Override
	public int getOpenArticleCnt(Article article) throws Exception {
		return boardDao.getOpenArticleCnt(article);
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

	/** DB에 저장되어있는 20150601063125 형식의 날짜형식을 2015-06-01 형식으로 바꿔줌 */
	public void changeRegDTFormat(List<Article> list){
		for(Article article : list) {
			String regDate = article.getRegDt();
			String year = regDate.substring(0, 4);
			String month = regDate.substring(4, 6);
			String day = regDate.substring(6, 8);
			article.setRegDt(year + "-" + month + "-" + day);
		}
	}

}
