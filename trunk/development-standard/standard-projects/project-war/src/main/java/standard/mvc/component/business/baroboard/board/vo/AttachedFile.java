package standard.mvc.component.business.baroboard.board.vo;

import org.springframework.web.multipart.MultipartFile;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 8. 27
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: AttachedFile.java
 * 	Description : 첨부파일 VO 
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일            수정자             수정내용
 *  --------      ------------   -----------------------
 *  2015.  8.  27.   전경훈             최초 생성
 *  
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

public class AttachedFile extends ComprehensiveTree {
	
	/** DB Table Fields */
	private int articleID;
	private String savedFileNM;
	private String extension;
	private String attachFile;
	private String regDt;

	/* Non DB-Column */
	private String boardID;
	private MultipartFile file; 
	
	@Override
	public String getSqlMapSelector() {
		return "attachedFile";
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

	public String getSavedFileNM() {
		return savedFileNM;
	}

	public void setSavedFileNM(String savedFileNM) {
		this.savedFileNM = savedFileNM;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
