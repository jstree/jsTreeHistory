package standard.mvc.component.business.baroboard.user.manage.grade.vo;

import java.util.HashMap;
import java.util.List;



import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.util.StringUtils;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: UserGradeManage.java
 * 	Description : 회원등급관리 정보에 사용되는 VO 
 * 	Infomation	: 회원등급관리 정보에 사용되는 VO
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
public class UserGradeManage extends ComprehensiveTree {

	private String pointByGradeUseFl;
	private int pointByGrade;
	private String iconFileNm;
	private String storeFileNm;
	
	private String[] accessMenuList;
	private List<UserMenuByGrade> userMenuByGradeList;
	
	public UserGradeManage(){
		this.setRef(2);
		this.setC_type("default");
	}
	
	public String getPointByGradeUseFl() {
		return pointByGradeUseFl;
	}

	public void setPointByGradeUseFl(String pointByGradeUseFl) {
		if(StringUtils.isBlank(pointByGradeUseFl)){
			this.pointByGradeUseFl = "0";
		}
		this.pointByGradeUseFl = pointByGradeUseFl;
	}

	public int getPointByGrade() {
		return pointByGrade;
	}

	public void setPointByGrade(int pointByGrade) {
		this.pointByGrade = pointByGrade;
	}

	public String getIconFileNm() {
		return iconFileNm;
	}

	public void setIconFileNm(String iconFileNm) {
		this.iconFileNm = iconFileNm;
	}

	public String getStoreFileNm() {
		return storeFileNm;
	}

	public void setStoreFileNm(String storeFileNm) {
		this.storeFileNm = storeFileNm;
	}

	public List<UserMenuByGrade> getUserMenuByGradeList() {
		return userMenuByGradeList;
	}

	public void setUserMenuByGradeList(List<UserMenuByGrade> userMenuByGradeList) {
		this.userMenuByGradeList = userMenuByGradeList;
	}

	public String[] getAccessMenuList() {
		return accessMenuList;
	}

	public void setAccessMenuList(String[] accessMenuList) {
		this.accessMenuList = accessMenuList;
	}

	@Override
    public String getSqlMapSelector() {
        return this.getClass().getName();
    }
	
	public HashMap<String, String> getAttr() {
		HashMap<String, String> parentAttr = super.getAttr();
		parentAttr.put("position", String.valueOf(this.getC_position()));
		return parentAttr;
	}
}
