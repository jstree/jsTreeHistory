package standard.mvc.component.business.baroboard.board.dao;

import java.util.List;

import standard.mvc.component.business.baroboard.board.vo.TotalArticle;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 7. 26
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardDao.java
 * Description : 바로보드-게시판 Total Article DAO 인터페이스
 * Information : 바로보드-게시판 Total Article DAO 인터페이스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일          수정자       수정내용
 * -------      ------------  -----------------------
 * 2015. 7. 26    전경훈       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

public interface TotalArticleDao {
	
	public List<TotalArticle> getTotalArticlesByBoardID(TotalArticle totalArticle) throws Exception;
	
	public List<TotalArticle> getTotalArticlesByRegID(TotalArticle totalArticle) throws Exception;

	public int updateTitleByBoardIdAndArticleID(TotalArticle totalArticle)	throws Exception;

	public int updateIsDeletedFLByBoardIdAndArticleID(TotalArticle totalArticle) throws Exception;
	
}
