package standard.mvc.component.business.baroboard.user.manage.grade.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: UserMenuByGrade.java
 * 	Description : 회원등급별 메뉴 정보에 사용되는 VO 
 * 	Infomation	: 회원등급별 메뉴 정보에 사용되는 VO
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일            수정자             수정내용
 *  --------      ------------   -----------------------
 *  2015.  5. 25.  김대근            최초 생성
 *  
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class UserMenuByGrade extends ComprehensiveTree {

	private int userGradeId;
	private int menuId;
	
	public UserMenuByGrade(){
		this.setRef(2);
		this.setC_type("default");
	}
	
	public int getUserGradeId() {
		return userGradeId;
	}

	public void setUserGradeId(int userGradeId) {
		this.userGradeId = userGradeId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	@Override
    public String getSqlMapSelector() {
        return this.getClass().getName();
    }
}
