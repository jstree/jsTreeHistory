package egovframework.com.ext.jstree.support.manager.mvc.exception;

import org.springframework.core.NestedRuntimeException;

public class GenericServiceRuntimeException extends NestedRuntimeException {
	
	private static final long serialVersionUID = 1L;

	public GenericServiceRuntimeException(final String msg) {
		super(msg);
	}

	public GenericServiceRuntimeException(final String msg, final Throwable cause) {
		super(msg, cause);
	}

}
