package standard.mvc.component.business.baroboard.user.note.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 5. 16.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: UserNoteByUser.java
 * 	Description : 회원별 수/발신 쪽지 정보에 사용되는 VO 
 * 	Infomation	: 회원별 수/발신 쪽지 정보에 사용되는 VO
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
public class UserNoteByUser extends ComprehensiveTree {

	private int userId;
	private int noteDetailId;
	private int noteTypeCode;
	private String receDispDt;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNoteDetailId() {
		return noteDetailId;
	}

	public void setNoteDetailId(int noteDetailId) {
		this.noteDetailId = noteDetailId;
	}

	public int getNoteTypeCode() {
		return noteTypeCode;
	}

	public void setNoteTypeCode(int noteTypeCode) {
		this.noteTypeCode = noteTypeCode;
	}

	public String getReceDispDt() {
		return receDispDt;
	}

	public void setReceDispDt(String receDispDt) {
		this.receDispDt = receDispDt;
	}

	@Override
    public String getSqlMapSelector() {
        return this.getClass().getName();
    }

}