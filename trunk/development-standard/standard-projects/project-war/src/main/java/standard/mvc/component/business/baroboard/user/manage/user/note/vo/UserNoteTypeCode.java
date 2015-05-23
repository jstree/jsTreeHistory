package standard.mvc.component.business.baroboard.user.manage.user.note.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 5. 16.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: UserNoteDetail.java
 * 	Description : 회원쪽지 유형 정보에 사용되는 VO 
 * 	Infomation	: 회원쪽지 유형 정보에 사용되는 VO
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일            수정자             수정내용
 *  --------      ------------   -----------------------
 *  2015.  5. 23.  김대근            최초 생성
 *  
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class UserNoteTypeCode extends ComprehensiveTree {

	@Override
    public String getSqlMapSelector() {
        return this.getClass().getName();
    }
}
