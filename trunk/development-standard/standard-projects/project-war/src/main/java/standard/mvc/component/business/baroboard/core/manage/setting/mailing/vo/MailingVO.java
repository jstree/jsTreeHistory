package standard.mvc.component.business.baroboard.core.manage.setting.mailing.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class MailingVO extends ComprehensiveTree {

	/**
	 * 이메일내용
	 */
	private String emailCn;

	/**
	 * 관리자 이름
	 */
	private String managerNm;

	/**
	 * 관리자 이메일 아이디
	 */
	private String managerEmailId;

	/**
	 * 관리자 이메일 URL
	 */
	private String managerEmailUrl;

	/**
	 * 자동 전송 여부
	 */
	private String autoSendFl;

	/**
	 * 이메일 전송 대상 ID
	 */
	private int emailSendTargetId;

	public String getEmailCn() {
		return emailCn;
	}

	public void setEmailCn(String emailCn) {
		this.emailCn = emailCn;
	}

	public String getManagerNm() {
		return managerNm;
	}

	public void setManagerNm(String managerNm) {
		this.managerNm = managerNm;
	}

	public String getManagerEmailId() {
		return managerEmailId;
	}

	public void setManagerEmailId(String managerEmailId) {
		this.managerEmailId = managerEmailId;
	}

	public String getManagerEmailUrl() {
		return managerEmailUrl;
	}

	public void setManagerEmailUrl(String managerEmailUrl) {
		this.managerEmailUrl = managerEmailUrl;
	}

	public String getAutoSendFl() {
		return autoSendFl;
	}

	public void setAutoSendFl(String autoSendFl) {
		this.autoSendFl = autoSendFl;
	}

	public int getEmailSendTargetId() {
		return emailSendTargetId;
	}

	public void setEmailSendTargetId(int emailSendTargetId) {
		this.emailSendTargetId = emailSendTargetId;
	}

	@Override
	public String getSqlMapSelector() {
		return "mailing";
	}

}
