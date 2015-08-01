package standard.mvc.component.business.baroboard.board.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 24.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: SearchArticle.java
 * 	Description : 글검색 VO 
 * 	Infomation	: 글검색 VO
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

public class SearchArticle extends ComprehensiveTree {

	public static final String TYPE_TITLE = "title";
	public static final String TYPE_CONTENT = "content";
	public static final String TYPE_TITLE_CONTENT = "title_content";
	public static final String TYPE_NICKNAME = "nickName";
	public static final String TYPE_USER_ID = "user_id";

	/**
	 * 검색 키워드
	 */
	private String searchKeyword;

	/**
	 * 검색 타입
	 */
	private String type;

	/**
	 * 게시판ID
	 */
	private String boardID;
	
	
	/* NON DB FIELD */
	/* 페이지 */
	private int pageNum = 1;

	/* 페이지 사이즈 */
	private int pageSize = 10;
	
	@Override
	public String getSqlMapSelector() {
		return "board";
	};

	@Override
	public String toString(){
		return "searchKeyword : " + this.searchKeyword
				+ "\ntype : " + this.type
				+ "\nboardID : " + this.boardID;
				
	}
	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBoardID() {
		return boardID;
	}

	public void setBoardID(String boardID) {
		this.boardID = boardID;
	}

}
