package standard.mvc.component.business.baroboard.board.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.board.dao.BoardDao;
import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.board.vo.Comment;
import standard.mvc.component.business.baroboard.board.vo.Like;
import standard.mvc.component.business.baroboard.board.vo.SearchArticle;
import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLogin;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardServiceImpl.java
 * Description : 바로보드-게시판-글관리 Service 구현체
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 25.      전경훈        최초 생성
 * 2015. 6. 14.		 전경훈		 addArticle 추가
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Service(value = "BoardService")
public class BoardServiceImpl implements BoardService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
	public Article getArticleById(Article article) throws Exception {
		return boardDao.getArticleById(article);
	}
	
	@Override
	public int getOpenArticleCnt(Article article) throws Exception {
		return boardDao.getOpenArticleCnt(article);
	}

	@Override
	public Article addArticle(Article article) throws Exception {
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(article.getIsGuestFL().equals("0")) {	// 일반 사용자
			SecureUserLogin userLogin = (SecureUserLogin) user;
			article.setRegID(userLogin.getId());
			
		} else {									// 게스트 사용자
			if(user instanceof String) {
				String userStr = (String)user;
				if(! userStr.equals("anonymousUser")) {
					throw new Exception("허가되지 않은 사용자입니다.");
				} 
			}
		}
		
		this.setupArticleParameters(article);
		
		Article insertedArticle = coreService.addNode(article);
		insertedArticle.setC_id(insertedArticle.getId());
		boardDao.updateRootArticleID(insertedArticle);
		
		return insertedArticle;
	}
	
	@Override
	public Article addReplyArticle(Article article) throws Exception {
		this.setupArticleParameters(article);
		return coreService.addNode(article);
	}
	
	@Override
	public Article removeArticle(Article article) throws Exception {
		article = coreDao.getNode(article);
		Article result = null;
		
		if(coreDao.removeNode(article) == 1) {
			result = article;
		}
		return result;
	}

	@Override
	public Article readArticle(Article article) throws Exception {
		this.countUpViewCnt(article);
		// TODO : 권한체크
//		article.setUserID(23);
		Article resultArticle = this.getArticleById(article);
		this.changeRegDTFormatForReadArticle(resultArticle);
		return resultArticle;
	}

	@Override
	public Article modifyArticle(Article article) throws Exception {
		Article result = null;
		article.setContent(this.unescapeHtml(article.getContent()));
		
		
		article.setModDt(this.getTodayFor14Digits());
		int resultInt = boardDao.modifyArticle(article);  
		if(resultInt == 1){
			result = article;
		}
		
		return result;
		
	}

	private int countUpViewCnt(Article article) throws Exception {
		return boardDao.countUpViewCnt(article);
	}
	
	@Override
	public Comment addComment(Comment comment) throws Exception {
		comment.setC_type("folder");
		comment.setRegID(this.getLoginedUserID());
//		comment.setRegID(23); // TODO : FOR TEST ONLY
		comment.setRegDT(this.getTodayFor14Digits());
		Comment insertedComment = null;
		
		if("1".equals(comment.getIsRoot())) {
			comment.setRef(2);
			insertedComment = coreService.addNode(comment);
			insertedComment.setC_id(insertedComment.getId());
			boardDao.updateCommentRootID(comment);
			
		} else {
			insertedComment = coreService.addNode(comment);
		}
		return insertedComment;
	}

	private String getTodayFor14Digits() {
		Date today = new Date();
		String formattedDate = DateFormatUtils.format(today, "yyyyMMddHHmmss");
		return formattedDate;
	}

	@Override
	public List<Comment> getCommentList(Comment comment) throws Exception {
		List<Comment> commentList = boardDao.getCommentList(comment);
		changeRegDTFormatForComment(commentList);
		/* 글 볼수 있는 권한 체크 */
		for(Comment c : commentList) {
			if("1".equals(comment.getViewOnlyRegIDFL()) && comment.getRegID() == this.getLoginedUserID() )	{ // TODO : 세션 붙이면 개인인증 확인, 게시글 RegID 확인 
				c.setViewForRegOnlyFL("1");
			} else {
				c.setViewForRegOnlyFL("0");
			}
		}
		return commentList;
	}

	@Override
	public Comment deleteComment(Comment comment) throws Exception {
		// TODO : 권한체크
		boardDao.deleteComment(comment);
		return comment;
	}

	@Override
	public Like likeArticle(Like like) throws Exception {
		// TODO : 권한체크
		like.setRegID(this.getLoginedUserID());
		like.setRef(2);
		return coreService.addNode(like);
	}

	@Override
	public Like cancelLikeArticle(Like like) throws Exception {
		// TODO : 권한체크
		like.setRegID(this.getLoginedUserID());
		Like targetLike = boardDao.getLikeByArticleIDAndRegID(like);
		coreService.removeNode(targetLike);
		return like;
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
	
	/** DB에 저장되어있는 20150601063125 형식의 날짜형식을 2015-06-10 06:31:25 형식으로 바꿔줌 */
	public void changeRegDTFormatForComment(List<Comment> list){
		for(Comment comment : list) {
			String org = comment.getRegDT();
			String formattedDate = 
					org.substring(0,4)
					+ "-"
					+ org.substring(4, 6)
					+ "-"
					+ org.substring(6, 8)
					+ " "
					+ org.substring(8, 10)
					+ ":"
					+ org.substring(10, 12)
					+ ":"
					+ org.substring(12, 14);
			comment.setRegDT(formattedDate);
		}
	}

	/**  DB에 저장되어있는 20150601063125 형식의 날짜형식을 2015-06-10 06:31:25 형식으로 바꿔줌 */
	public void changeRegDTFormatForReadArticle(Article article) {
		String org = article.getRegDt();
		String formattedDate = 
				org.substring(0,4)
				+ "-"
				+ org.substring(4, 6)
				+ "-"
				+ org.substring(6, 8)
				+ " "
				+ org.substring(8, 10)
				+ ":"
				+ org.substring(10, 12)
				+ ":"
				+ org.substring(12, 14);
		article.setRegDt(formattedDate);
	}

	/* escaped 된 html 을 원래 html로 변환함 */
	public String unescapeHtml(String str) {
		return StringEscapeUtils.unescapeHtml4(str);
	}
	
	/* 글 추가를 위한 공통 파라미터 설정 */
	private void setupArticleParameters(Article article) {
		article.setRef(2);
		article.setC_type("default");
		article.setC_type("folder");
		article.setContent(this.unescapeHtml(article.getContent()));
		article.setRegDt(this.getTodayFor14Digits());
	}
	
	/* 사용자 ID 가져오기 - 게스트사용자일 경우 0을 리턴 */
	private int getLoginedUserID() throws Exception {
		int loginedUserID;
		
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof String) { // 익명 사용자
			String userStr = (String)user;
			if(userStr.equals("anonymousUser")) {
				loginedUserID = 0;
			} else {
				throw new Exception("허가되지 않은 사용자입니다.");
			}
		} else {	// 로그인 사용자
			SecureUserLogin loginedUser = (SecureUserLogin) user;
			loginedUserID = loginedUser.getId();
		}
		
		return loginedUserID;
	}
}