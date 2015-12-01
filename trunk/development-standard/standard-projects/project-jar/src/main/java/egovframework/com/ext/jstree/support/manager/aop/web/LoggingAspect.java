package egovframework.com.ext.jstree.support.manager.aop.web;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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
        
       // logger.info("*** logBefore() is running!");
        //logger.info("*** hijacked : " + joinPoint.getSignature().getName());
    }
    
    public void logAfter(JoinPoint joinPoint)
    {
        
        //logger.info("*** logAfter() is running!");
       // logger.info("*** hijacked : " + joinPoint.getSignature().getName());
    }
    
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex)
    {
        
       // logger.info("*** logAfterThrowing() is running!");
      //  logger.info("ex message : " + ex.toString());
    }
    
    public void logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        StringBuffer logMessage = new StringBuffer();       
        logMessage.append(proceedingJoinPoint.getSignature().getName());
        logMessage.append("(");
       
        // Collect arguments value
        Object[] args = proceedingJoinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            logMessage.append(args[i]).append(",");
        }
        if (args.length > 0) {
            logMessage.deleteCharAt(logMessage.length() - 1);
        }
       
        logMessage.append(") ");
       
        // Calculate method's elapsed time
        logMessage.append(" [Elapsed Time: " );
        long start = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        logMessage.append(end - start);
       
        logMessage.append(" ms]");
       
        logger.info("Profiling : "+proceedingJoinPoint.getTarget().getClass().getName() +"."+logMessage.toString());
    }
    
}