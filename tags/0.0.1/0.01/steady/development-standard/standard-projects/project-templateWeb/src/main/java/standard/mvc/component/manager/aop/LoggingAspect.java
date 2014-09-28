package standard.mvc.component.manager.aop;


import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
//@Aspect
public class LoggingAspect {
 
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    //@Before("execution(* sdk.spring.service..*(..))")
    public void logBefore(JoinPoint joinPoint) {
 
        logger.info("*** logBefore() is running!");
        logger.info("*** hijacked : " + joinPoint.getSignature().getName());
    }

    public void logAfter(JoinPoint joinPoint) {
    	
    	logger.info("*** logAfter() is running!");
    	logger.info("*** hijacked : " + joinPoint.getSignature().getName());
    }
}