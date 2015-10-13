package standard.mvc.component.business.baroboard.core.manage.setting.sms.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class SmsVO extends ComprehensiveTree {

	/**
	 * 
	 */
	public String smsUseFl;
	
	/**
	 * 
	 */
	public String smsId;
	
	/**
	 * 
	 */
	public String smsPassword;
	
	/**
	 * 
	 */
	public String smsSendTargetId;

	/**
	 * 
	 */
	public String smsSubject;
	
	/**
	 * 
	 */
	public String smsContent;
	
	public String getSmsUseFl() {
		return smsUseFl;
	}
	public void setSmsUseFl(String smsUseFl) {
		this.smsUseFl = smsUseFl;
	}
	public String getSmsId() {
		return smsId;
	}
	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}
	public String getSmsPassword() {
		return smsPassword;
	}
	public void setSmsPassword(String smsPassword) {
		this.smsPassword = smsPassword;
	}
	public String getSmsSendTargetId() {
		return smsSendTargetId;
	}
	public void setSmsSendTargetId(String smsSendTargetId) {
		this.smsSendTargetId = smsSendTargetId;
	}
	public String getSmsSubject() {
		return smsSubject;
	}
	public void setSmsSubject(String smsSubject) {
		this.smsSubject = smsSubject;
	}
	public String getSmsContent() {
		return smsContent;
	}
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	@Override
	public String getSqlMapSelector() {
		return "sms";
	}
}
