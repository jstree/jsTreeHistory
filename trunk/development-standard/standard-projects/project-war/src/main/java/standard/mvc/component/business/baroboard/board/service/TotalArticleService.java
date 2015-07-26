package standard.mvc.component.business.baroboard.board.service;

import java.util.List;

import standard.mvc.component.business.baroboard.board.vo.TotalArticle;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 7. 26
 * @version 1.0
 * @see <pre>
 * Class Name  : TotalArticleService.java
 * Description : 바로보드-게시판 모든 게시물 관리 Service 인터페이스
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 6. 26      전경훈        최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

public interface TotalArticleService {

	/**
	 * 사용자 ID 로 모든 게시판의 글을 조회한다. (페이징처리)
	 * 
	 * @param TotalArticle
	 * @return 글목록 List
	 * @throws Exception
	 */
	public List<TotalArticle> getArticlesByRegIDAndPage(TotalArticle totalArticle) throws Exception;
	
	/**
	 * 사용자 ID 로 모든 게시판의 글 개수를 조회한다.
	 * 
	 * @param TotalArticle
	 * @return 글 수
	 * @throws Exception
	 */
	public int getTotalArticleCountByRegID(TotalArticle totalArticle) throws Exception;
	
	/**
	 * 게시글 제목을 수정한다.
	 * 
	 * @param TotalArticle
	 * @return 업데이트 된 행수
	 * @throws Exception
	 */
	public int updateTitleByBoardIdAndArticleID(TotalArticle totalArticle) throws Exception;
	
	/**
	 * 삭제 Flag 를 업데이트한다.
	 * 
	 * @param TotalArticle
	 * @return 업데이트 된 행수
	 * @throws Exception
	 */
	public int updateIsDeletedFLByBoardIdAndArticleID(TotalArticle totalArticle) throws Exception;
	
	
}
