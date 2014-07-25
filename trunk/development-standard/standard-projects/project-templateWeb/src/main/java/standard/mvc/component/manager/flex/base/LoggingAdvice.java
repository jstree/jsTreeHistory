package standard.mvc.component.manager.flex.base;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {

	private Log logger;

	public void setLogCategory(String loggerName) {
		this.logger = LogFactory.getLog(loggerName);
	}

	public void beforeLogging(JoinPoint joinPoint) {
		if (this.logger != null && this.logger.isDebugEnabled()) {
			this.logger.debug("before : " + buildLogMessage(joinPoint));
		}
	}

	protected String buildLogMessage(JoinPoint joinPoint) {
		String signatureName = joinPoint.getSignature().getName();
		String argsString = StringUtils.join(joinPoint.getArgs());
		return String.format("%s(%s)", signatureName, argsString);
	}

	public void affterReturning(JoinPoint joinPoint, Object ret) {
		if (this.logger != null && this.logger.isDebugEnabled()) {
			this.logger.debug("after : " + buildLogMessage(joinPoint, ret));
		}
	}

	protected String buildLogMessage(JoinPoint joinPoint, Object ret) {
		return String.format("%s\n\treturn value: ",
				buildLogMessage(joinPoint), ret);
	}

	public void throwing(JoinPoint joinPoint, Exception ex) {
		if (this.logger != null && this.logger.isWarnEnabled()) {
			this.logger.warn(
					"throw : " + buildExceptionLogMessage(joinPoint, ex), ex);
		}
	}

	protected String buildExceptionLogMessage(JoinPoint joinPoint, Exception ex) {
		return String.format("%s\n\texception : ", buildLogMessage(joinPoint),
				ex);
	}

}
