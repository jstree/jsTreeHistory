package standard.mvc.component.business.baroboard.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.board.vo.AttachedFile;
import standard.mvc.component.business.baroboard.board.vo.Comment;
import standard.mvc.component.business.baroboard.board.vo.Like;
import standard.mvc.component.business.baroboard.board.vo.SearchArticle;
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
 * Information : 바로보드-게시판 DAO 구현 클래스
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticleListByPage(Article article) throws Exception {
		return list(article.getSqlMapSelector() + "." + "getArticleListByPage", article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAnnounceList(Article article) throws Exception {
		return list(article.getSqlMapSelector() + "." + "getAnnounceList", article);
	}

	@Override
	public int getOpenArticleCnt(Article article) throws Exception {
		return (int)selectByPk(article.getSqlMapSelector() + "." + "getOpenArticleCnt", article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> searchArticle(SearchArticle searchArticle)
			throws Exception {
		return list(searchArticle.getSqlMapSelector() + "." +"searchArticle", searchArticle);
	}

	@Override
	public Article getArticleById(Article article) throws Exception {
		return (Article)selectByPk(article.getSqlMapSelector() + "." + "getArticleById", article);
	}

	@Override
	public int countUpViewCnt(Article article) throws Exception {
		return update(article.getSqlMapSelector() + "." + "countUpViewCnt", article);
	}

	@Override
	public int modifyArticle(Article article) throws Exception {
		return update(article.getSqlMapSelector() + "." + "modifyArticle", article);
	}

	@Override
	public int updateRootArticleID(Article article) throws Exception {
		return update(article.getSqlMapSelector() + "." + "updateRootArticleID", article);
	}

	@Override
	public int updateCommentRootID(Comment comment) throws Exception {
		return update(comment.getSqlMapSelector() + "." + "updateCommentRootID", comment);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getCommentList(Comment comment) throws Exception {
		return list(comment.getSqlMapSelector() + "." + "getCommentList", comment);
	}

	@Override
	public int deleteComment(Comment comment) throws Exception {
		return update(comment.getSqlMapSelector() + "." + "deleteComment", comment);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Like getLikeByArticleIDAndRegID(Like like) throws Exception {
		List<Like> resultList = list(like.getSqlMapSelector() + "." + "getLikeByArticleIDAndRegID", like);
		return resultList.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AttachedFile> getAttachedFilesInfoByArticleID(AttachedFile attachedFile) throws Exception {
		return list(attachedFile.getSqlMapSelector() + "." + "getAttachedFilesInfoByArticleID", attachedFile);
	}

}