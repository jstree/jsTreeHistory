package standard.mvc.component.business.baroboard.board.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 9. 8
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: BoardComprehensiveTree.java
 * 	Description : 게시판 공통 ComprehensiveTree 
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일            수정자             수정내용
 *  --------      ------------   -----------------------
 *  2015.  9. 8.   전경훈             최초 생성
 *  
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

public class BoardComprehensiveTree extends ComprehensiveTree {
	
	public BoardComprehensiveTree() {}
	
	public BoardComprehensiveTree(String boardID) {
		this.boardID = boardID;
	}
	
	/**
	 * 게시판 ID
	 * - 동적 게시판 구성을 위한 필드
	 */
	/**
	 * TODO : 현재 Jstree 에서 insert 시 인스턴스 복사과정에서 boardID 가 적용안되므로 test 로 임시 고정
	 */
	private String boardID = "test";

	public String getBoardID() {
		return boardID;
	}

	public void setBoardID(String boardID) {
		this.boardID = boardID;
	}
}
