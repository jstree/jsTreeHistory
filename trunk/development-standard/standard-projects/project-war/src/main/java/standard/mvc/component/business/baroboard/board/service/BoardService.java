package standard.mvc.component.business.baroboard.board.service;

import java.util.List;

import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.board.vo.SearchArticle;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardService.java
 * Description : 바로보드-게시판 Service 인터페이스
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

public interface BoardService {

	/**
	 * 페이지 순서로 글 목록을 조회한다.
	 * 
	 * @param 게시판ID, 페이지번호, 페이지크기
	 * @return 글목록 List
	 * @throws Exception
	 */
	public List<Article> getArticleList(String boardID, int pageNum, int pageSize) throws Exception;
	
	/**
	 * 조건에 맞는 글을 검색한다.
	 * 
	 * @param 게시판ID, SearchArticle VO
	 * @return 글목록 List
	 * @throws Exception
	 */
	public List<Article> searchArticleList(String boardID, SearchArticle searchArticle) throws Exception;
	
	/**
	 * 글을 추가한다.
	 * 
	 * @param 게시판ID, 글VO(Article)
	 * @return Article
	 * @throws Exception
	 */
	public Article addArticle(String boardID, Article article) throws Exception;
	
	/**
	 * 글을 수정한다.
	 * 
	 * @param 게시판ID, 글VO(Article)
	 * @return Article
	 * @throws Exception
	 */
	public Article alterArticle(String boardID, Article article) throws Exception;
	
	/**
	 * 글을 삭제한다.
	 * 
	 * @param 게시판ID, 글VO(Article)
	 * @return Article
	 * @throws Exception
	 * 
	 */
	public Article removeArticle(String boardID, Article article) throws Exception;
	
}
