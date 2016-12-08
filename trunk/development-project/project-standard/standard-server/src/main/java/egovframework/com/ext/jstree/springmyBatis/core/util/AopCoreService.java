package egovframework.com.ext.jstree.springmyBatis.core.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
@EnableAspectJAutoProxy
@Component
public class AopCoreService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(public * egovframework.com.ext.jstree.springmyBatis.core.service.CoreServiceImpl.getChildNode(..))")
	private void executeAspect() {
	}

	@Before("executeAspect()")
	@SuppressWarnings({ "rawtypes", "unused" })
	public void beforeExcute(JoinPoint thisJoinPoint) {
		Class clazz = thisJoinPoint.getTarget().getClass();
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        logger.info(className + "." + methodName + "@Before executed.");
	}

	@After("executeAspect()")
	@SuppressWarnings({ "rawtypes", "unused" })
	public void afterExcute(JoinPoint thisJoinPoint) {
		Class clazz = thisJoinPoint.getTarget().getClass();
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        logger.info(className + "." + methodName + "@After executed.");
	}

	@Around("executeAspect()")
	@SuppressWarnings({ "rawtypes", "unused" })
	public Object aroundExcute(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		
		Class clazz = thisJoinPoint.getTarget().getClass();
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        logger.info(className + "." + methodName + "@Around executed.");

		try {
			Object ret = thisJoinPoint.proceed();
			return ret;
		} finally {
			logger.info("@Around executed finally phase");
		}
	}

	@AfterReturning("executeAspect()")
	@SuppressWarnings({ "rawtypes", "unused" })
	public void afterReturningExcute(JoinPoint thisJoinPoint) {
		Class clazz = thisJoinPoint.getTarget().getClass();
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        logger.info(className + "." + methodName + "@AfterReturning executed.");
	}

	@AfterThrowing("executeAspect()")
	@SuppressWarnings({ "rawtypes", "unused" })
	public void afterThrowingExcute(JoinPoint thisJoinPoint) {
		Class clazz = thisJoinPoint.getTarget().getClass();
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        logger.info(className + "." + methodName + "@AfterThrowing executed.");
	}
}
