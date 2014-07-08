package standard.mvc.security.custom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.LoggerListener;

public class CustomLoginLogger extends LoggerListener {
	private static final Log logger = LogFactory.getLog(CustomLoginLogger.class);
	
    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent abstractAuthenticationEvent) {
    	logger.info("[CustomLoginLogger=====Authentication logger]");
        super.onApplicationEvent(abstractAuthenticationEvent);
    }
}
