package standard.mvc.component.business.baroboard.board.vo;


/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 7. 26
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: TotalArticle.java
 * 	Description : 모든 게시글 VO 
 * 	Infomation	: 모든 게시글 VO
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일            수정자             수정내용
 *  --------      ------------   -----------------------
 *  2015.  7. 26   전경훈             최초 생성
 *  
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

public class TotalArticle extends BoardComprehensiveTree {

	public TotalArticle() {}
	
	public TotalArticle(String boardID) {
		super(boardID);
	}
	
	/* DB Columns */
	
	private String boardID;
	
	private int articleID;
	
	private int regID;
	
	private String isDeletedFL;
	
	private String regDt;
	
	/* Non-DB Columns */
	
 	private int pageSize = 10;
	
	private int pageNum = 1;
	
	@Override
	public String getSqlMapSelector() {
		return "totalArticle";
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getBoardID() {
		return boardID;
	}

	public void setBoardID(String boardID) {
		this.boardID = boardID;
	}

	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public int getRegID() {
		return regID;
	}

	public void setRegID(int regID) {
		this.regID = regID;
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
	
}
