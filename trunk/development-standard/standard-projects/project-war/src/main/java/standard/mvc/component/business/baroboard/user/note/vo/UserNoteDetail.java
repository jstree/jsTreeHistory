package standard.mvc.component.business.baroboard.user.note.vo;

import java.util.List;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 5. 16.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: UserNoteDetail.java
 * 	Description : 회원쪽지 정보에 사용되는 VO 
 * 	Infomation	: 회원쪽지 정보에 사용되는 VO
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일            수정자             수정내용
 *  --------      ------------   -----------------------
 *  2015.  5. 16.  김대근            최초 생성
 *  
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class UserNoteDetail extends ComprehensiveTree{

	private String content;
	
	private List<UserNoteByUser> userNoteByUserList;
	
	private List<UserNoteAttachFile> userNoteAttachFileList;
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public List<UserNoteByUser> getUserNoteByUserList() {
		return userNoteByUserList;
	}

	public void setUserNoteByUserList(List<UserNoteByUser> userNoteByUserList) {
		this.userNoteByUserList = userNoteByUserList;
	}

	public List<UserNoteAttachFile> getUserNoteAttachFileList() {
		return userNoteAttachFileList;
	}

	public void setUserNoteAttachFileList(List<UserNoteAttachFile> userNoteAttachFileList) {
		this.userNoteAttachFileList = userNoteAttachFileList;
	}

	@Override
    public String getSqlMapSelector() {
        return this.getClass().getName();
    }
}
