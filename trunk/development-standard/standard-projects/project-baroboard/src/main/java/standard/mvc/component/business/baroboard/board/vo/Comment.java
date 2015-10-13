package standard.mvc.component.business.baroboard.board.vo;


/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 7. 4
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: Comment.java
 * 	Description : 코멘트 VO 
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일            수정자             수정내용
 *  --------      ------------   -----------------------
 *  2015.  7. 4.   전경훈             최초 생성
 *  
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

public class Comment extends BoardComprehensiveTree {

	public Comment() {}
	
	public Comment(String boardID) {
		super(boardID);
	}

	private int articleID;
	private int rootCommentID;
	private int regID;
	private String viewOnlyRegIDFL;
	private String isDeletedFL;
	private String regDT;
	private String modDT;
	
	/* DB 필드는 아니지만 로직상 필요한 파라미터 */
	private String isRoot;
	
	/* 글쓴이 닉네임 */
	private String regNickName;

	private String viewForRegOnlyFL;
	
	@Override
	public String getSqlMapSelector() {
		return "comment";
	}


	public String getViewForRegOnlyFL() {
		return viewForRegOnlyFL;
	}
	public void setViewForRegOnlyFL(String viewForRegOnlyFL) {
		this.viewForRegOnlyFL = viewForRegOnlyFL;
	}
	public String getRegNickName() {
		return regNickName;
	}
	public void setRegNickName(String regNickName) {
		this.regNickName = regNickName;
	}
	public String getIsRoot() {
		return isRoot;
	}
	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}
	public String getIsDeletedFL() {
		return isDeletedFL;
	}
	public void setIsDeletedFL(String isDeletedFL) {
		this.isDeletedFL = isDeletedFL;
	}
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public int getRootCommentID() {
		return rootCommentID;
	}
	public void setRootCommentID(int rootCommentID) {
		this.rootCommentID = rootCommentID;
	}
	public int getRegID() {
		return regID;
	}
	public void setRegID(int regID) {
		this.regID = regID;
	}
	public String getViewOnlyRegIDFL() {
		return viewOnlyRegIDFL;
	}
	public void setViewOnlyRegIDFL(String viewOnlyRegIDFL) {
		this.viewOnlyRegIDFL = viewOnlyRegIDFL;
	}
	public String getRegDT() {
		return regDT;
	}
	public void setRegDT(String regDT) {
		this.regDT = regDT;
	}
	public String getModDT() {
		return modDT;
	}
	public void setModDT(String modDT) {
		this.modDT = modDT;
	}
	
	
	
}
