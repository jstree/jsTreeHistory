package standard.mvc.component.security.custom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.LoggerListener;
/**
 *  Class Name : CustomLoginLogger.java
 *  Description : security 3.0.1b 간소화 설정으로 확장 커스터 마이징 불가 하며 확장성에 대한 검토가 필요하다. (인증 시도한 사용자에 대한 로그 클래스)
 *  Modification Information
 * 
 *  @author 최대열
 *  @since 2014.07.10
 *  @version 1.0
 *  @see
 *
 *  <pre>
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.10                 최대열		   최초 생성
 *
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class CustomLoginLogger extends LoggerListener {
	private static final Log logger = LogFactory.getLog(CustomLoginLogger.class);
	
    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent abstractAuthenticationEvent) {
    	logger.info("[CustomLoginLogger=====Authentication logger]");
        super.onApplicationEvent(abstractAuthenticationEvent);
    }
}
