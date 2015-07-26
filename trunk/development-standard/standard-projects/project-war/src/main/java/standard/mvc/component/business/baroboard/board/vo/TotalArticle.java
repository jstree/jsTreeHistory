package standard.mvc.component.business.baroboard.board.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

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

public class TotalArticle extends ComprehensiveTree {

	private String boardID;
	
	private int articleID;
	
	private int regID;
	
	private String isDeletedFL;
	
	private String regDT;
	
	@Override
	public String getSqlMapSelector() {
		return "totalArticle";
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

	public String getRegDT() {
		return regDT;
	}

	public void setRegDT(String regDT) {
		this.regDT = regDT;
	}
	
}
