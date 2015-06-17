package standard.mvc.component.business.baroboard.board.manager.defaultsetting.vo;

import javax.validation.constraints.Pattern;

import standard.mvc.component.business.baroboard.core.manage.setting.validCondition.ValidFormat;
import standard.mvc.component.business.baroboard.core.manage.setting.validCondition.ValidInput;
import egovframework.com.ext.jstree.springiBatis.core.validation.custom.constraints.Contained;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AlterNode;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * 
 * Modification Information
 * 
 * @author 정원기
 * @since 2015. 6. 15.
 * @version 1.0
 * @see <pre>
 *  Class Name  : DefaultSettingVO.java
 *  Description : 게시판 기본설정 VO
 *  Information :
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 6. 15.     정원기                  최초생성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class DefaultSettingVO extends ComprehensiveTree {

    @Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
    private String useLikeFl;
    
    @Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
    private String viewContentInListFl;
    
    @Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
    private String viewAttachInListFl;
    
    @Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
    private String useSnsLinkFl;
    
    @Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
    private String blockDoubtRequestFl;
    
    @Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
    private String useWrittingAnonymFl;
    
    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
    private String maxLengthInTitle;
    
    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
    private String minLengthInContent;
    
    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
    private String commentCntForBanEditing;
    
    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
    private String commentCntForBanDeletion;
    
    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
    private String maxLengthInContent;
    
    private String spamKeywords;
    
    
	public String getCommentCntForBanEditing() {
		return commentCntForBanEditing;
	}

	public void setCommentCntForBanEditing(String commentCntForBanEditing) {
		this.commentCntForBanEditing = commentCntForBanEditing;
	}

	public String getCommentCntForBanDeletion() {
		return commentCntForBanDeletion;
	}

	public void setCommentCntForBanDeletion(String commentCntForBanDeletion) {
		this.commentCntForBanDeletion = commentCntForBanDeletion;
	}

	public String getBlockDoubtRequestFl() {
		return blockDoubtRequestFl;
	}

	public void setBlockDoubtRequestFl(String blockDoubtRequestFl) {
		this.blockDoubtRequestFl = blockDoubtRequestFl;
	}

	public String getUseWrittingAnonymFl() {
		return useWrittingAnonymFl;
	}

	public void setUseWrittingAnonymFl(String useWrittingAnonymFl) {
		this.useWrittingAnonymFl = useWrittingAnonymFl;
	}

	public String getUseLikeFl() {
		return useLikeFl;
	}

	public void setUseLikeFl(String useLikeFl) {
		this.useLikeFl = useLikeFl;
	}

	public String getViewContentInListFl() {
		return viewContentInListFl;
	}

	public void setViewContentInListFl(String viewContentInListFl) {
		this.viewContentInListFl = viewContentInListFl;
	}

	public String getViewAttachInListFl() {
		return viewAttachInListFl;
	}

	public void setViewAttachInListFl(String viewAttachInListFl) {
		this.viewAttachInListFl = viewAttachInListFl;
	}

	public String getMaxLengthInTitle() {
		return maxLengthInTitle;
	}

	public void setMaxLengthInTitle(String maxLengthInTitle) {
		this.maxLengthInTitle = maxLengthInTitle;
	}

	public String getMinLengthInContent() {
		return minLengthInContent;
	}

	public void setMinLengthInContent(String minLengthInContent) {
		this.minLengthInContent = minLengthInContent;
	}

	public String getMaxLengthInContent() {
		return maxLengthInContent;
	}

	public void setMaxLengthInContent(String maxLengthInContent) {
		this.maxLengthInContent = maxLengthInContent;
	}

	public String getUseSnsLinkFl() {
		return useSnsLinkFl;
	}

	public void setUseSnsLinkFl(String useSnsLinkFl) {
		this.useSnsLinkFl = useSnsLinkFl;
	}

	public String getSpamKeywords() {
		return spamKeywords;
	}

	public void setSpamKeywords(String spamKeywords) {
		this.spamKeywords = spamKeywords;
	}

    @Override
    public String getSqlMapSelector() {
        return "defaultSetting";
    }
    
	@Override
	public String toString() {
		return "GeneralSettingVO [useLikeFl=" + useLikeFl
				+ ", viewContentInListFl=" + viewContentInListFl
				+ ", viewAttachInListFl=" + viewAttachInListFl
				+ ", maxLengthInTitle=" + maxLengthInTitle
				+ ", minLengthInContent=" + minLengthInContent
				+ ", commentCntForBanEditing=" + commentCntForBanEditing
				+ ", commentCntForBanDeletion=" + commentCntForBanDeletion
				+ ", maxLengthInContent=" + maxLengthInContent
				+ ", useSnsLinkFl=" + useSnsLinkFl + ", blockDoubtRequestFl="
				+ blockDoubtRequestFl + ", useWrittingAnonymFl="
				+ useWrittingAnonymFl + ", spamKeywords=" + spamKeywords + "]";
	}
}