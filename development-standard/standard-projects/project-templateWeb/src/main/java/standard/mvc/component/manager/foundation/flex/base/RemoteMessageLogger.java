package standard.mvc.component.manager.foundation.flex.base;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.flex.core.MessageInterceptor;
import org.springframework.flex.core.MessageProcessingContext;

import flex.messaging.messages.Message;
import flex.messaging.messages.RemotingMessage;

public class RemoteMessageLogger implements MessageInterceptor {

	protected final Log logger = LogFactory.getLog(getClass());

	public Message postProcess(MessageProcessingContext context,
			Message inputMessage, Message outputMessage) {

		logMessage("inputMessage", inputMessage);
		logMessage("outputMessage", outputMessage);

		return outputMessage;
	}

	private void logMessage(String preMessage, Message message) {
		if (logger.isDebugEnabled()) {

			logger.debug("= Flex RemoteObject Message Log =");

			if (message instanceof RemotingMessage) {
				RemotingMessage roMessage = (RemotingMessage) message;
				logger.debug(preMessage
						+ "\n"
						+ ToStringBuilder.reflectionToString(roMessage,
								ToStringStyle.MULTI_LINE_STYLE));
			}
		}
	}

	public Message preProcess(MessageProcessingContext context,
			Message inputMessage) {
		return inputMessage;
	}

}
