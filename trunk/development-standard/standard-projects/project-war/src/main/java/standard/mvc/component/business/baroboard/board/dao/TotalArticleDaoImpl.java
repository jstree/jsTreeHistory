package standard.mvc.component.business.baroboard.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.baroboard.board.vo.TotalArticle;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 7. 26.
 * @version 1.0
 * @see <pre>
 * Class Name  : TotalArticleDaoImpl.java
 * Description : 바로보드-게시판 TotalArticleDao 구현 클래스
 * Information : 바로보드-게시판 TotalArticleDao 구현 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일          수정자       수정내용
 * -------      ------------  -----------------------
 * 2015. 7. 26      전경훈       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Repository
public class TotalArticleDaoImpl extends EgovComAbstractDAO implements TotalArticleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TotalArticle> getTotalArticlesByBoardID(TotalArticle totalArticle) throws Exception {
		return list(totalArticle.getSqlMapSelector() + "." +"getTotalArticlesByBoardID", totalArticle);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TotalArticle> getArticlesByRegIDAndPage(TotalArticle totalArticle) throws Exception {
		return list(totalArticle.getSqlMapSelector() + "." +"getArticlesByRegIDAndPage", totalArticle);
	}

	@Override
	public int updateTitleByBoardIdAndArticleID(TotalArticle totalArticle) throws Exception {
		return update(totalArticle.getSqlMapSelector() + "." + "updateTitleByBoardIdAndArticleID", totalArticle);
	}

	@Override
	public int updateIsDeletedFLByBoardIdAndArticleID(TotalArticle totalArticle) throws Exception {
		return update(totalArticle.getSqlMapSelector() + "." + "updateIsDeletedFLByBoardIdAndArticleID", totalArticle);
	}

	@Override
	public int getTotalArticleCountByRegID(TotalArticle totalArticle) throws Exception {
		return (int)selectByPk(totalArticle.getSqlMapSelector() + "." + "getTotalArticleCountByRegID", totalArticle);
	}

}
