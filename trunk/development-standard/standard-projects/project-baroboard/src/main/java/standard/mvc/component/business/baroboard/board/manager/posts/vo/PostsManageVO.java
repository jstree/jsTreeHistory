package standard.mvc.component.business.baroboard.board.manager.posts.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import standard.mvc.component.business.baroboard.board.manager.defaultsetting.vo.DefaultSettingVO;

public class PostsManageVO extends ComprehensiveTree{

	private int regId;
	
	private String content;

	private String allowCommentFl;

	private String allowTrackbackFl;

	private String allowReplyFl;

	private String alertResponseFl;

	private String openArticleFl;

	private String announcementFl;

	private int viewCnt;
	
	private int likeCnt;

	private String isDeletedFl;
	
	private String rootArticleId;
	
	private String regDt;

	private String modDt;
	
	private String regNickName;
	
	private List<DefaultSettingVO> tableInfo;

	private String boardId;
	
	private String boardName;
	
	private String fromDt;
	
	private String toDt;
	
	private int pageSize = 10;
	
	private String pageNo = "1";
	
	private int recordsPerPage = 10;
	
	private List<String> chk = new ArrayList<String>();
	
	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public List<String> getChk() {
		return chk;
	}

	public void setChk(List<String> chk) {
		this.chk = chk;
	}

	public List<DefaultSettingVO> getTableInfo() {
		return tableInfo;
	}

	public void setTableInfo(List<DefaultSettingVO> tableInfo) {
		this.tableInfo = tableInfo;
	}

	public String getFromDt() {
		return fromDt;
	}

	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}

	public String getToDt() {
		return toDt;
	}

	public void setToDt(String toDt) {
		this.toDt = toDt;
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

	public String getAllowCommentFl() {
		return allowCommentFl;
	}

	public void setAllowCommentFl(String allowCommentFl) {
		this.allowCommentFl = allowCommentFl;
	}

	public String getAllowTrackbackFl() {
		return allowTrackbackFl;
	}

	public void setAllowTrackbackFl(String allowTrackbackFl) {
		this.allowTrackbackFl = allowTrackbackFl;
	}

	public String getAllowReplyFl() {
		return allowReplyFl;
	}

	public void setAllowReplyFl(String allowReplyFl) {
		this.allowReplyFl = allowReplyFl;
	}

	public String getAlertResponseFl() {
		return alertResponseFl;
	}

	public void setAlertResponseFl(String alertResponseFl) {
		this.alertResponseFl = alertResponseFl;
	}

	public String getOpenArticleFl() {
		return openArticleFl;
	}

	public void setOpenArticleFl(String openArticleFl) {
		this.openArticleFl = openArticleFl;
	}

	public String getAnnouncementFl() {
		return announcementFl;
	}

	public void setAnnouncementFl(String announcementFl) {
		this.announcementFl = announcementFl;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public String getIsDeletedFl() {
		return isDeletedFl;
	}

	public void setIsDeletedFl(String isDeletedFl) {
		this.isDeletedFl = isDeletedFl;
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

	public String getRootArticleId() {
		return rootArticleId;
	}

	public void setRootArticleId(String rootArticleId) {
		this.rootArticleId = rootArticleId;
	}
	
	public String getRegNickName() {
		return regNickName;
	}

	public void setRegNickName(String regNickName) {
		this.regNickName = regNickName;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		if(StringUtils.isNotEmpty(pageNo)){
			this.pageNo = pageNo;			
		}
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	@Override
	public String getSqlMapSelector() {
		return "postsManage";
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}