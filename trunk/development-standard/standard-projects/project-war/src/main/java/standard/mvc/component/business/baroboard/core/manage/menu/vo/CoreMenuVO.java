package standard.mvc.component.business.baroboard.core.manage.menu.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * 
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 7. 5.
 * @version 1.0
 * @see <pre>
 * Class Name  : CoreMenuVO.java
 * Description : 바로보드-코어-메뉴 VO
 * Infomation  :
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 7. 5.          손호성                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class CoreMenuVO extends ComprehensiveTree {

	private String menuId;
	private String pageId;
	private String authId;
	private String imageDefault;
	private String imageHover;
	private String imageSelected;
	private String homeFl;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getImageDefault() {
		return imageDefault;
	}

	public void setImageDefault(String imageDefault) {
		this.imageDefault = imageDefault;
	}

	public String getImageHover() {
		return imageHover;
	}

	public void setImageHover(String imageHover) {
		this.imageHover = imageHover;
	}

	public String getImageSelected() {
		return imageSelected;
	}

	public void setImageSelected(String imageSelected) {
		this.imageSelected = imageSelected;
	}

	public String getHomeFl() {
		return homeFl;
	}

	public void setHomeFl(String homeFl) {
		this.homeFl = homeFl;
	}

	@Override
	public String getSqlMapSelector() {
		return "coreMenu";
	}

	@Override
	public String toString() {
		return "CoreMenuVO [menuId=" + menuId + ", pageId=" + pageId
				+ ", authId=" + authId + ", imageDefault=" + imageDefault
				+ ", imageHover=" + imageHover + ", imageSelected="
				+ imageSelected + ", homeFl=" + homeFl + ", getId()=" + getId()
				+ ", isCopied()=" + isCopied() + ", getRef()=" + getRef()
				+ ", getCopy()=" + getCopy() + ", getC_id()=" + getC_id()
				+ ", getC_parentid()=" + getC_parentid() + ", getC_position()="
				+ getC_position() + ", getC_left()=" + getC_left()
				+ ", getC_right()=" + getC_right() + ", getC_level()="
				+ getC_level() + ", getC_title()=" + getC_title()
				+ ", getC_type()=" + getC_type() + ", getMultiCounter()="
				+ getMultiCounter() + ", getSpaceOfTargetNode()="
				+ getSpaceOfTargetNode() + ", getSearchStr()=" + getSearchStr()
				+ ", getChildcount()=" + getChildcount() + ", getState()="
				+ getState() + ", getStatus()=" + getStatus() + ", getIdif()="
				+ getIdif() + ", getLdif()=" + getLdif()
				+ ", getC_idsByChildNodeFromNodeById()="
				+ getC_idsByChildNodeFromNodeById() + ", getFixCopyId()="
				+ getFixCopyId() + ", getFixCopyPosition()="
				+ getFixCopyPosition() + ", getRightPositionFromNodeByRef()="
				+ getRightPositionFromNodeByRef() + ", getNodeById()="
				+ getNodeById() + ", getIdifLeft()=" + getIdifLeft()
				+ ", getIdifRight()=" + getIdifRight() + ", getData()="
				+ getData() + ", getAttr()=" + getAttr() + ", toString()="
				+ super.toString() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}

}
