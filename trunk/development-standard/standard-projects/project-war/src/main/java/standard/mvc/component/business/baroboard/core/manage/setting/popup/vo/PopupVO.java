package standard.mvc.component.business.baroboard.core.manage.setting.popup.vo;

import javax.validation.constraints.Min;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 6. 16.
 * @version 1.0
 * @see <pre>
 * Class Name  : Popup.java
 * Description : 바로보드 - 일반설정 - 팝업설정 VO
 * Information : Have To Write Information
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 6. 16.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class PopupVO extends ComprehensiveTree {

	private String popupContent; 
	private String writngDe; 
	private String expiryDe; 
	private String applyFl; 
	@Min(1)
	private Integer rePopupTerm; 
	private Integer layerLeft; 
	private Integer layerTop; 
	private Integer layerWidth;
	private Integer layerHeight; 
	public String getPopupContent() {
		return popupContent;
	}
	public void setPopupContent(String popupContent) {
		this.popupContent = popupContent;
	}
	public String getWritngDe() {
		return writngDe;
	}
	public void setWritngDe(String writngDe) {
		this.writngDe = writngDe;
	}
	public String getExpiryDe() {
		return expiryDe;
	}
	public void setExpiryDe(String expiryDe) {
		this.expiryDe = expiryDe;
	}
	public String getApplyFl() {
		return applyFl;
	}
	public void setApplyFl(String applyFl) {
		this.applyFl = applyFl;
	}
	public Integer getRePopupTerm() {
		return rePopupTerm;
	}
	public void setRePopupTerm(Integer rePopupTerm) {
		this.rePopupTerm = rePopupTerm;
	}
	public Integer getLayerLeft() {
		return layerLeft;
	}
	public void setLayerLeft(Integer layerLeft) {
		this.layerLeft = layerLeft;
	}
	public Integer getLayerTop() {
		return layerTop;
	}
	public void setLayerTop(Integer layerTop) {
		this.layerTop = layerTop;
	}
	public Integer getLayerWidth() {
		return layerWidth;
	}
	public void setLayerWidth(Integer layerWidth) {
		this.layerWidth = layerWidth;
	}
	public Integer getLayerHeight() {
		return layerHeight;
	}
	public void setLayerHeight(Integer layerHeight) {
		this.layerHeight = layerHeight;
	}
	/*****
, C_POPUP_CONTENT AS popupContent 
, C_WRITNG_DE AS writngDe 
, C_EXPIRY_DE AS expiryDe 
, C_APPLY_FL AS applyFl 
, C_RE_POPUP_TERM AS rePopupTerm 
, C_LAYER_LEFT AS layerLeft 
, C_LAYER_TOP AS layerTop 
, C_LAYER_WIDTH AS layerWidt 
, C_LAYER_HEIGHT AS layerHeight
	 */
	
	@Override
	public String getSqlMapSelector() {
		return "popup";
	}
}
