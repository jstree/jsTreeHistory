package egovframework.com.ext.jstree.support.manager.scheduler.job.jiraToCrowd;

public class CrowdUserAuthException extends Exception {
private String reason;
	
	private static final long serialVersionUID = 1L;
	
	public CrowdUserAuthException(String reason, String message,Exception ex){
		super(message,ex);
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
