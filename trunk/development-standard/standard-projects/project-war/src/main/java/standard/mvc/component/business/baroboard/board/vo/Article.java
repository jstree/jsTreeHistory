package standard.mvc.component.business.baroboard.board.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 24.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: Article.java
 * 	Description : 게시글 VO 
 * 	Infomation	: 게시글 VO
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일            수정자             수정내용
 *  --------      ------------   -----------------------
 *  2015.  5. 24.   전경훈             최초 생성
 *  
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

public class Article extends ComprehensiveTree {

	/* 루트글 번호 */
	private int rootArticleID;
	
	/* 글쓴이 */
	private int regID;
	
	/* 내용 */
	private String content;

	/* 코멘트허용여부 */
	private String allowCommentFL = "0";

	/* 엮인글 허용여부 */
	private String allowTrackbackFL = "0";

	/* 댓글허용여부 */
	private String allowReplyFL = "0";

	/* 알림여부 */
	private String alertResponseFL = "0";

	/* 글공개여부 */
	private String openArticleFL = "0";

	/* 공지글 여부 */
	private String announcementFL = "0";

	/* 조회수 */
	private int viewCnt;

	/* 삭제여부 */
	private String isDeletedFL;

	/* 게스트글 여부 */
	private String isGuestFL;
	
	/* 게스트 글 닉네임 */
	private String guestNickName;
	
	/* 게스트 글 비밀번호 */
	private String guestPW;
	
	
	/* TODO : 첨부파일 */

	/* 생성일시 */
	private String regDt;

	/* 수정일시 */
	private String modDt;
	
	/* 테이블에는 없지만 DTO로서 필요한 필드 */
	/* 게시판 ID */
	private String boardID;

	/* 페이지 */
	private int pageNum = 1;

	/* 페이지 사이즈 */
	private int pageSize = 10;

	/* 코멘트개수 */
	private int commentCnt;

	/* 글 총개수 */
	private int totArticleCnt;
	
	/* 글쓴이 닉네임 */
	private String regNickName;
	
	/* 좋아요 수 */
	private int likeCnt;
	
	/* 해당 글 좋아요 여부 */
	private String likeFL;

	/* 해당 사용자 ID */
	private int userID;
	
	
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("C_ID : " + this.getC_id());
		b.append("\n");
		b.append("C_title : " + this.getC_title());
		b.append("\n");
		b.append("regId :" + this.getRegID());
		b.append("\n");

		b.append("content :" + this.getContent());
		b.append("\n");

		b.append("allowCommentFL :" + this.allowCommentFL);
		b.append("\n");

		b.append("allowTrackbackFL :" + this.allowTrackbackFL);
		b.append("\n");

		b.append("alertResponseFL :" + this.alertResponseFL);
		b.append("\n");

		b.append("openArticleFL :" + this.openArticleFL);
		b.append("\n");

		b.append("allowTrackbackFL :" + this.allowTrackbackFL);
		b.append("\n");

		return b.toString();
	}
	
	@Override
	public String getSqlMapSelector() {
		return "board";
	}

	public String getIsGuestFL() {
		return isGuestFL;
	}

	public void setIsGuestFL(String isGuestFL) {
		this.isGuestFL = isGuestFL;
	}

	public String getGuestNickName() {
		return guestNickName;
	}

	public void setGuestNickName(String guestNickName) {
		this.guestNickName = guestNickName;
	}

	public String getGuestPW() {
		return guestPW;
	}

	public void setGuestPW(String guestPW) {
		this.guestPW = guestPW;
	}

	public int getLikeCnt() {
		return likeCnt;
	}


	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getLikeFL() {
		return likeFL;
	}

	public void setLikeFL(String likeFL) {
		this.likeFL = likeFL;
	}

	public int getRootArticleID() {
		return rootArticleID;
	}

	public void setRootArticleID(int rootArticleID) {
		this.rootArticleID = rootArticleID;
	}
	
	public int getRegID() {
		return regID;
	}

	public void setRegID(int regID) {
		this.regID = regID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAllowCommentFL() {
		return allowCommentFL;
	}

	public void setAllowCommentFL(String allowCommentFL) {
		this.allowCommentFL = allowCommentFL;
	}

	public String getAllowReplyFL() {
		return allowReplyFL;
	}

	public void setAllowReplyFL(String allowReplyFL) {
		this.allowReplyFL = allowReplyFL;
	}

	public String getAlertResponseFL() {
		return alertResponseFL;
	}

	public void setAlertResponseFL(String alertResponseFL) {
		this.alertResponseFL = alertResponseFL;
	}

	public String getOpenArticleFL() {
		return openArticleFL;
	}

	public void setOpenArticleFL(String openArticleFL) {
		this.openArticleFL = openArticleFL;
	}

	public String getAnnouncementFL() {
		return announcementFL;
	}

	public void setAnnouncementFL(String announcementFL) {
		this.announcementFL = announcementFL;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getIsDeletedFL() {
		return isDeletedFL;
	}

	public void setIsDeletedFL(String isDeletedFL) {
		this.isDeletedFL = isDeletedFL;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getModDt() {
		return modDt;
	}

	public void setModDt(String modDt) {
		this.modDt = modDt;
	}

	public String getBoardID() {
		return boardID;
	}

	public void setBoardID(String boardID) {
		this.boardID = boardID;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotArticleCnt() {
		return totArticleCnt;
	}

	public void setTotArticleCnt(int totArticleCnt) {
		this.totArticleCnt = totArticleCnt;
	}

	public String getAllowTrackbackFL() {
		return allowTrackbackFL;
	}

	public void setAllowTrackbackFL(String allowTrackbackFL) {
		this.allowTrackbackFL = allowTrackbackFL;
	}
	
	public String getRegNickName() {
		return regNickName;
	}

	public void setRegNickName(String regNickName) {
		this.regNickName = regNickName;
	}
}
