package standard.mvc.component.business.baroboard.board.service;

import java.util.List;

import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.board.vo.SearchArticle;
import standard.mvc.component.business.baroboard.user.vo.User;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardService.java
 * Description : 바로보드-게시판 Service 인터페이스
 * Information : 
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
	 * 페이지 순서로 글 목록을 조회한다. 공지글은 제외한다.
	 * 
	 * @param Article
	 * @return 글목록 List
	 * @throws Exception
	 */
	public List<Article> getArticleList(Article article) throws Exception;
	
	/**
	 * 공지글을 조회한다.
	 * 
	 * @param Article
	 * @return 공지글목록 List
	 * @throws Exception
	 */
	public List<Article> getAnnounceList(Article article) throws Exception;
	
	
	/**
	 * 조건에 맞는 글을 검색한다.
	 * 
	 * @param SearchArticle VO
	 * @return 글목록 List
	 * @throws Exception
	 */
	public List<Article> searchArticleList(SearchArticle searchArticle) throws Exception;
	
	/**
	 * ID 로 글을 검색한다.
	 * 
	 * @param Article VO
	 * @return Article VO
	 * @throws Exception
	 */
	public Article getArticleById(Article article) throws Exception;
	
	/**
	 * 공개된 글 개수를 조회한다.
	 * - 페이징 처리용
	 * 
	 * @param SearchArticle VO
	 * @return 글목록개수(int)
	 * @throws Exception
	 */
	public int getOpenArticleCnt(Article article) throws Exception;
	
	/**
	 * 글을 추가한다.
	 * 
	 * @param Article
	 * @return Article
	 * @throws Exception
	 */
	public Article addArticle(Article article) throws Exception;
	
	/**
	 * 답글을 추가한다.
	 * 
	 * @param Article
	 * @return Article
	 * @throws Exception
	 */
	public Article addReplyArticle(Article article) throws Exception;
	
	/**
	 * 글을 삭제한다.
	 * 
	 * @param Article
	 * @return Article
	 * @throws Exception
	 * 
	 */
	public Article removeArticle(Article article) throws Exception;
	
	/**
	 * 글을 가져온다. 글의 카운트 숫자를 1 더한다.
	 * 
	 * @param Article
	 * @return Article
	 * @throws Exception
	 * 
	 */
	public Article readArticle(Article article) throws Exception;
	
	/**
	 * 글을 수정한다.
	 * 
	 * @param Article
	 * @return Article
	 * @throws Exception
	 * 
	 */
	public Article modifyArticle(Article article) throws Exception;

	
	
}
