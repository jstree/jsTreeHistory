package standard.mvc.component.business.baroboard.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.baroboard.board.vo.Article;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 29.
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardDaoImpl.java
 * Description : 바로보드-게시판 DAO 구현 클래스
 * Infomation  : 바로보드-게시판 DAO 구현 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일          수정자       수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 29.      전경훈       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Repository
public class BoardDaoImpl extends EgovComAbstractDAO implements BoardDao {

	private static final String TABLE_PREFIX = "T_BOARD_";
	
	private void makeTableNameByBoardID(Article article){
		article.setBoardID(TABLE_PREFIX+article.getBoardID());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticleListByPage(Article article) throws Exception {
//		makeTableNameByBoardID(article);
		return list(article.getSqlMapSelector() + "." + "getArticleListByPage", article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAnnounceList(Article article) throws Exception {
		makeTableNameByBoardID(article);
		return list(article.getSqlMapSelector() + "." + "getAnnounceList", article);
	}

}
