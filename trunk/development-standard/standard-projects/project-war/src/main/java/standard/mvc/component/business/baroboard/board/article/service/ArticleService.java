package standard.mvc.component.business.baroboard.board.article.service;

import java.util.List;

import standard.mvc.component.business.baroboard.board.article.vo.Article;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : ArticleService.java
 * Description : 바로보드-게시판-글관리 Service 인터페이스
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

public interface ArticleService {

	/**
	 * 글 목록을 조회한다.
	 * 
	 * @param 게시판ID, 페이지번호, 페이지크기
	 * @return 글목록 List
	 * @throws Exception
	 */
	List<Article> getArticleList(String boardID, int pageNum, int pageSize) throws Exception;

	/**
	 * 글을 추가한다.
	 * 
	 * @param 게시판ID, 글VO(Article)
	 * @return 글목록 List
	 * @throws Exception
	 */
	int 
	
	
	
	
}
