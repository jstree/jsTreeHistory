package standard.mvc.component.business.baroboard.user.note.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 5. 16.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: UserNoteAttachFile.java
 * 	Description : 회원쪽지에 첨부되는 파일정보에 사용되는 VO 
 * 	Infomation	: 회원쪽지에 첨부되는 파일정보에 사용되는 VO
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
public class UserNoteAttachFile extends ComprehensiveTree {

	private int noteDetailId;
	private String storeFileNm;
	
	public int getNoteDetailId() {
		return noteDetailId;
	}
	
	public void setNoteDetailId(int noteDetailId) {
		this.noteDetailId = noteDetailId;
	}

	public String getStoreFileNm() {
		return storeFileNm;
	}

	public void setStoreFileNm(String storeFileNm) {
		this.storeFileNm = storeFileNm;
	}

	@Override
    public String getSqlMapSelector() {
        return this.getClass().getName();
    }
}
