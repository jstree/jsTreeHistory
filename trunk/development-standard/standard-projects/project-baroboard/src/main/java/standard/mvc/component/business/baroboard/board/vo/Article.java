package standard.mvc.component.business.baroboard.board.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

@JsonIgnoreProperties({"attachedFiles"})
public class Article extends BoardComprehensiveTree {

	public Article() {}
	
	public Article(String boardID) {
		super(boardID);
	}
	
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
	private String isDeletedFL = "0";

	/* 생성일시 */
	private String regDt;

	/* 수정일시 */
	private String modDt;
	
	/* 테이블에는 없지만 DTO로서 필요한 필드 */

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
	
	/* 현재 Row Number */
	private int rnum;
	
	/* 전체 게시글 수 */
	private int totCnt;
	
	/* 첨부파일 리스트 
	 * jackson json 으로 return 시, 이 필드는 빠진다. */
	private transient List<AttachedFile> attachedFiles;

	/* 파일 첨부 YN */
	private String hasAttachedFileFL;
	
	/* 글 수정시 기존 첨부파일 리스트 */
	private List<String> existing_files;
	
	/* Root Context Path */
	private String contextPath;

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
	
	public List<String> getExisting_files() {
		return existing_files;
	}

	public void setExisting_files(List<String> existing_files) {
		this.existing_files = existing_files;
	}

	public String getHasAttachedFileFL() {
		return hasAttachedFileFL;
	}

	public void setHasAttachedFileFL(String hasAttachedFileFL) {
		this.hasAttachedFileFL = hasAttachedFileFL;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public List<AttachedFile> getAttachedFiles() {
		return attachedFiles;
	}

	public void setAttachedFiles(List<AttachedFile> attachedFiles) {
		this.attachedFiles = attachedFiles;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getTotCnt() {
		return totCnt;
	}

	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
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