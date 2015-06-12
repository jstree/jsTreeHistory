package standard.mvc.component.business.baroboard.core.manage.setting.basicSetting.vo;

import javax.validation.constraints.Size;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 5. 30.
 * @version 1.0
 * @see <pre>
 * Class Name  : BasicSetting.java
 * Description : Have To Write Description
 * Infomation  : Have To Write Information
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 5. 30.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class BasicSettingVO extends ComprehensiveTree {
	
	/**
	 * 사이트제목 
	 */
	private String siteTitle;
	
	/**
	 * 기본언어아이디
	 */
	private int basicLanguageId;
	
	/**
	 * 현지시간아이디
	 */
	private int localTimeId;
	
	/**
	 * 시간포맷아이디
	 */
	private int timeFormatId;
	
	/**
	 * 썸네일생성방법아이디
	 */
	private int thumCreatMethodId;
	
	/**
	 * 파비콘적용여부
	 */
	private int faviconUseFl;
	
	/**
	 * 파비콘파일아이디
	 */
	private int faviconFileId;
	
	/**
	 * 모바일아이콘적용여부
	 */
	private int mobileIconApplyFl;
	
	/**
	 * 모바일아이콘파일아이디
	 */
	private int mobileIconFileId;
	
	/**
	 * 레이아웃설정아이디
	 */
	private int layoutId;
	
	/**
	 * 접근금지문구
	 */
	@Size(max = 4000)
	private String accesProhWords;
	
	/**
	 * 회원가입사용여부
	 */
	private int userJoinUseFl;
	
	/**
	 * 하단스크립트
	 */
	@Size(max = 4000)
	private String footerScript;
	
	
	public String getSiteTitle() {
		return siteTitle;
	}


	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}


	public int getBasicLanguageId() {
		return basicLanguageId;
	}


	public void setBasicLanguageId(int basicLanguageId) {
		this.basicLanguageId = basicLanguageId;
	}


	public int getLocalTimeId() {
		return localTimeId;
	}


	public void setLocalTimeId(int localTimeId) {
		this.localTimeId = localTimeId;
	}


	public int getTimeFormatId() {
		return timeFormatId;
	}


	public void setTimeFormatId(int timeFormatId) {
		this.timeFormatId = timeFormatId;
	}


	public int getThumCreatMethodId() {
		return thumCreatMethodId;
	}


	public void setThumCreatMethodId(int thumCreatMethodId) {
		this.thumCreatMethodId = thumCreatMethodId;
	}


	public int getFaviconUseFl() {
		return faviconUseFl;
	}


	public void setFaviconUseFl(int faviconUseFl) {
		this.faviconUseFl = faviconUseFl;
	}


	public int getFaviconFileId() {
		return faviconFileId;
	}


	public void setFaviconFileId(int faviconFileId) {
		this.faviconFileId = faviconFileId;
	}


	public int getMobileIconApplyFl() {
		return mobileIconApplyFl;
	}


	public void setMobileIconApplyFl(int mobileIconApplyFl) {
		this.mobileIconApplyFl = mobileIconApplyFl;
	}


	public int getMobileIconFileId() {
		return mobileIconFileId;
	}


	public void setMobileIconFileId(int mobileIconFileId) {
		this.mobileIconFileId = mobileIconFileId;
	}


	public int getLayoutId() {
		return layoutId;
	}


	public void setLayoutId(int layoutId) {
		this.layoutId = layoutId;
	}


	public String getAccesProhWords() {
		return accesProhWords;
	}


	public void setAccesProhWords(String accesProhWords) {
		this.accesProhWords = accesProhWords;
	}


	public int getUserJoinUseFl() {
		return userJoinUseFl;
	}


	public void setUserJoinUseFl(int userJoinUseFl) {
		this.userJoinUseFl = userJoinUseFl;
	}


	public String getFooterScript() {
		return footerScript;
	}


	public void setFooterScript(String footerScript) {
		this.footerScript = footerScript;
	}


	@Override
    public String getSqlMapSelector() {
        return "basicSetting";
    }
}
