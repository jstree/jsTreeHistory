package standard.mvc.component.business.baroboard.board.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 8. 24.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: ArticleAttachedFile.java
 * 	Description : 게시글 첨부 파일정보 VO 
 * 	Information	: 게시글 첨부 파일정보 VO 
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일            수정자             수정내용
 *  -----------      ------------   -----------------------
 *  2015.  8. 24.       전경훈            최초 생성
 *  
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class ArticleAttachedFile extends ComprehensiveTree {
	
	private int articleID;
	private String orgFileName;
	private String fileName;
	
	
	
	
	
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
