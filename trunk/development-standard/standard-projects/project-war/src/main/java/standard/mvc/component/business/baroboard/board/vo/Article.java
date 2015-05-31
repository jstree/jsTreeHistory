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

public class Article extends ComprehensiveTree{

	/* 글쓴이 */
	private int regId;
	
	/* 내용 */
	private String content;
	
	/* 코멘트허용여부 */
	private String allowCommentFL;
	
	/* 댓글허용여부 */
	private String allowReplyFL;
	
	/* 알림여부 */
	private String alertResponseFL;
	
	/* 글공개여부 */
	private String openArticleFL;
	
	/* 공지글 여부 */
	private String announcementFL;
	
	/* 조회수 */
	private int viewCnt;
	
	/* 삭제여부 */
	private String isDeletedFL;
	
	/* 생성일시 */
	private String regDt;
	
	/* 수정일시 */
	private String modDt;
	
	/* 테이블에는 없지만 DTO로서 필요한 필드 */
	/* 게시판 ID */
	private String boardID;
	
	/* 페이지 */
	private int pageNum;
	
	@Override
	public String getSqlMapSelector() {
		return "board";
	}
	
	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
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
}
