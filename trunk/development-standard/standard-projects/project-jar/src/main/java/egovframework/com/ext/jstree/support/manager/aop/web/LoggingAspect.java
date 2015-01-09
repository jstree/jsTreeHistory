package egovframework.com.ext.jstree.support.manager.aop.web;

import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Aspect
public class LoggingAspect
{
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    // @Before("execution(* sdk.spring.service..*(..))")
    public void logBefore(JoinPoint joinPoint)
    {
        
        logger.info("*** logBefore() is running!");
        logger.info("*** hijacked : " + joinPoint.getSignature().getName());
    }
    
    public void logAfter(JoinPoint joinPoint)
    {
        
        logger.info("*** logAfter() is running!");
        logger.info("*** hijacked : " + joinPoint.getSignature().getName());
    }
    
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex)
    {
        
        logger.info("*** logAfterThrowing() is running!");
        logger.info("ex message : " + ex.toString());
    }
    
    public void logAround(JoinPoint joinPoint)
    {
        
        logger.info("*** logAround() is running!");
        logger.info("*** hijacked : " + joinPoint.getSignature().getName());
    }
}