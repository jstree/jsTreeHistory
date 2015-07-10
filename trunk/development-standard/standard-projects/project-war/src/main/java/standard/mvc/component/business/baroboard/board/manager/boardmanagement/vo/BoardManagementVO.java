package standard.mvc.component.business.baroboard.board.manager.boardmanagement.vo;

import javax.validation.constraints.Pattern;

import standard.mvc.component.business.baroboard.validCondition.ValidFormat;
import standard.mvc.component.business.baroboard.validCondition.ValidInput;
import egovframework.com.ext.jstree.springiBatis.core.validation.custom.constraints.Contained;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AlterNode;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * 
 * Modification Information
 * 
 * @author 정원기
 * @since 2015. 6. 24.
 * @version 1.0
 * @see <pre>
 *  Class Name  : BoardManagementVO.java
 *  Description : 게시판 관리 VO
 *  Information :
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 6. 24.     정원기                  최초생성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class BoardManagementVO extends ComprehensiveTree {
	
	private Integer writingCntPerPage;
	private String levelForViewList;
	private String levelForReadContent;
	private String levelForWriting;
	private String levelForReply;
	private String levelForComment;
	private String levelForClipping;
	private String levelForFileUpload;
	private String levelForFileDownload;
	
	@Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
	private Integer commentCntForBanDeletion;
	
	@Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
	private Integer commentCntForBanEditing;
	
	@Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
	private String useAnonymFl;
	
	private String boardTableName;
	private String regDt;
	
	@Override
	public String toString() {
		return "BoardManagementVO [writingCntPerPage=" + writingCntPerPage
				+ ", levelForViewList=" + levelForViewList
				+ ", levelForReadContent=" + levelForReadContent
				+ ", levelForWriting=" + levelForWriting + ", levelForReply="
				+ levelForReply + ", levelForComment=" + levelForComment
				+ ", levelForClipping=" + levelForClipping
				+ ", levelForFileUpload=" + levelForFileUpload
				+ ", levelForFileDownload=" + levelForFileDownload
				+ ", commentCntForBanDeletion=" + commentCntForBanDeletion
				+ ", commentCntForBanEditing=" + commentCntForBanEditing
				+ ", useAnonymFl=" + useAnonymFl + ", boardTableName="
				+ boardTableName + ", regDt=" + regDt + "]";
	}
	public Integer getWritingCntPerPage() {
		
		if( this.writingCntPerPage == null ){
			writingCntPerPage = 0;
		}
		return writingCntPerPage;
	}
	public void setWritingCntPerPage(Integer writingCntPerPage) {
		this.writingCntPerPage = writingCntPerPage;
	}
	public String getLevelForWriting() {
		return levelForWriting;
	}
	public void setLevelForWriting(String levelForWriting) {
		this.levelForWriting = levelForWriting;
	}
	public String getLevelForViewList() {
		return levelForViewList;
	}
	public void setLevelForViewList(String levelForViewList) {
		this.levelForViewList = levelForViewList;
	}
	public String getLevelForReadContent() {
		return levelForReadContent;
	}
	public void setLevelForReadContent(String levelForReadContent) {
		this.levelForReadContent = levelForReadContent;
	}
	public String getLevelForReply() {
		return levelForReply;
	}
	public void setLevelForReply(String levelForReply) {
		this.levelForReply = levelForReply;
	}
	public String getLevelForComment() {
		return levelForComment;
	}
	public void setLevelForComment(String levelForComment) {
		this.levelForComment = levelForComment;
	}
	public String getLevelForClipping() {
		return levelForClipping;
	}
	public void setLevelForClipping(String levelForClipping) {
		this.levelForClipping = levelForClipping;
	}
	public String getLevelForFileUpload() {
		return levelForFileUpload;
	}
	public void setLevelForFileUpload(String levelForFileUpload) {
		this.levelForFileUpload = levelForFileUpload;
	}
	public String getLevelForFileDownload() {
		return levelForFileDownload;
	}
	public void setLevelForFileDownload(String levelForFileDownload) {
		this.levelForFileDownload = levelForFileDownload;
	}
	public Integer getCommentCntForBanDeletion() {
		return commentCntForBanDeletion;
	}
	public void setCommentCntForBanDeletion(Integer commentCntForBanDeletion) {
		this.commentCntForBanDeletion = commentCntForBanDeletion;
	}
	public Integer getCommentCntForBanEditing() {
		return commentCntForBanEditing;
	}
	public void setCommentCntForBanEditing(Integer commentCntForBanEditing) {
		this.commentCntForBanEditing = commentCntForBanEditing;
	}
	public String getUseAnonymFl() {
		return useAnonymFl;
	}
	public void setUseAnonymFl(String useAnonymFl) {
		this.useAnonymFl = useAnonymFl;
	}
	public String getBoardTableName() {
		return boardTableName;
	}
	public void setBoardTableName(String boardTableName) {
		this.boardTableName = boardTableName;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	
    @Override
    public String getSqlMapSelector() {
        return "boardManagement";
    }
}