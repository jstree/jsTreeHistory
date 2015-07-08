package standard.mvc.component.business.baroboard.board.dao;

import java.util.List;

import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.board.vo.Comment;
import standard.mvc.component.business.baroboard.board.vo.Like;
import standard.mvc.component.business.baroboard.board.vo.SearchArticle;
import standard.mvc.component.business.baroboard.user.vo.User;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 29.
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardDao.java
 * Description : 바로보드-게시판 DAO 인터페이스
 * Information : 바로보드-게시판 DAO 인터페이스
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

public interface BoardDao {
	
	public List<Article> getArticleListByPage(Article article) throws Exception;
	
	public List<Article> getAnnounceList(Article article) throws Exception;

	public List<Article> searchArticle(SearchArticle searchArticle) throws Exception;
	
	public int getOpenArticleCnt(Article article) throws Exception;

	public Article getArticleById(Article article)throws Exception;

	public int countUpViewCnt(Article article) throws Exception;

	public int modifyArticle(Article article) throws Exception;

	public int updateRootArticleID(Article article) throws Exception;

	public int updateCommentRootID(Comment comment) throws Exception;

	public List<Comment> getCommentList(Comment comment) throws Exception;

	public int deleteComment(Comment comment) throws Exception;

	public Like getLikeByArticleIDAndRegID(Like like) throws Exception;

}
