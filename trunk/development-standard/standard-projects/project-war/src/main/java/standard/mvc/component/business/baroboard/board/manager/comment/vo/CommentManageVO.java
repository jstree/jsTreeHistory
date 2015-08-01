package standard.mvc.component.business.baroboard.board.manager.comment.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import standard.mvc.component.business.baroboard.board.manager.defaultsetting.vo.DefaultSettingVO;

public class CommentManageVO extends ComprehensiveTree{
	
	private String articleId;
	
	private String regId;
	
	private String viewOnlyRegIdFl;
	
	private String regDt;
	
	private String modDt;
	
	private String rootCommentId;
	
	private String isDeletedFl;
	
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
	
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getViewOnlyRegIdFl() {
		return viewOnlyRegIdFl;
	}

	public void setViewOnlyRegIdFl(String viewOnlyRegIdFl) {
		this.viewOnlyRegIdFl = viewOnlyRegIdFl;
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
	
	public String getRegNickName() {
		return regNickName;
	}

	public void setRegNickName(String regNickName) {
		this.regNickName = regNickName;
	}

	public void setModDt(String modDt) {
		this.modDt = modDt;
	}

	public String getRootCommentId() {
		return rootCommentId;
	}

	public void setRootCommentId(String rootCommentId) {
		this.rootCommentId = rootCommentId;
	}

	public String getIsDeletedFl() {
		return isDeletedFl;
	}

	public void setIsDeletedFl(String isDeletedFl) {
		this.isDeletedFl = isDeletedFl;
	}

	public List<DefaultSettingVO> getTableInfo() {
		return tableInfo;
	}

	public void setTableInfo(List<DefaultSettingVO> tableInfo) {
		this.tableInfo = tableInfo;
	}

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

	public List<String> getChk() {
		return chk;
	}

	public void setChk(List<String> chk) {
		this.chk = chk;
	}

	@Override
	public String getSqlMapSelector() {
		return "commentManage";
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
