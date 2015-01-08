package egovframework.com.ext.jstree.support.manager.foundation.flex.base;

public class FlexException extends RuntimeException {

	/**
	 * 
	 */
	public static final String FAILED_LOGIN = "FAILED_LOGIN";
	public static final String FAILED_AUTH = "FAILED_AUTH";
	public static final String ERROR_DATABASE = "ERROR_DATABASE";
	public static final String ERROR_SQL = "ERROR_SQL";
	public static final String ERROR_ETC = "ERROR_ETC";
	private static final long serialVersionUID = -9044530054426786811L;

	public FlexException() {

		super(ERROR_ETC);
	}

	public FlexException(String message) {

		super(message);
	}
}
