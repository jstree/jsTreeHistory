package standard.mvc.component.business.menu.service;

import java.lang.reflect.Method;

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

import standard.mvc.component.base.exception.GenericServiceRuntimeException;
import egovframework.com.ext.jstree.springiBatis.core.annotation.ExecutionSwitching;
import egovframework.com.ext.jstree.springiBatis.core.constant.ExecutionOrder;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

@Aspect
@Configuration
@EnableAspectJAutoProxy
@Component
public class MenuCallBackAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(public * egovframework.com.ext.jstree.springiBatis.core.service.CoreServiceImpl.getChildNode(..))")
	private void executeAspect() {
	}

	@Before("executeAspect()")
	public void beforeExcute(JoinPoint thisJoinPoint) {
		Class clazz = thisJoinPoint.getTarget().getClass();
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
//        logger.info(className + "." + methodName + "@Before executed.");
        logger.info(className + "." + methodName + "@Before not executed.");
//        executeAdvice(thisJoinPoint, ExecutionOrder.BEFORE.value());
	}

	@After("executeAspect()")
	public void afterExcute(JoinPoint thisJoinPoint) {
		Class clazz = thisJoinPoint.getTarget().getClass();
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
//        logger.info(className + "." + methodName + "@After executed.");
        logger.info(className + "." + methodName + "@After not executed.");
//        executeAdvice(thisJoinPoint, ExecutionOrder.AFTER.value());
	}

	@Around("executeAspect()")
	public Object aroundExcute(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		
		Class clazz = thisJoinPoint.getTarget().getClass();
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        logger.info(className + "." + methodName + "@Around executed.");

		try {
			executeAdvice(thisJoinPoint, ExecutionOrder.BEFORE.value());
			Object ret = thisJoinPoint.proceed();
			executeAdvice(thisJoinPoint, ExecutionOrder.AFTER.value());
			
			return ret;
		} finally {
			System.out.println("****");
		}
	}

	@AfterReturning("executeAspect()")
	public void afterReturningExcute(JoinPoint thisJoinPoint) {
		Class clazz = thisJoinPoint.getTarget().getClass();
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        logger.info(className + "." + methodName + "@AfterReturning executed.");
	}

	@AfterThrowing("executeAspect()")
	public void afterThrowingExcute(JoinPoint thisJoinPoint) {
		Class clazz = thisJoinPoint.getTarget().getClass();
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        logger.info(className + "." + methodName + "@AfterThrowing executed.");
	}
	
	private void executeAdvice(JoinPoint thisJoinPoint, String executionOrder) {
		Object[] signatures = thisJoinPoint.getArgs();
        for (Object signature : signatures) {

        	Object parameter = null;
        	if (signature instanceof ComprehensiveTree) {
        		parameter = signature;
				continue;
			}
        	
        	try {
        		
        		Class<? extends Object> claxx = signature.getClass();
				if (claxx.isAnnotationPresent(ExecutionSwitching.class)) {

					String order = claxx.getAnnotation(ExecutionSwitching.class).order();
        			if (order.equals(executionOrder) || order.equals(ExecutionOrder.AROUND.value())) {
        				Method method = claxx.getMethod(executionOrder, ComprehensiveTree.class);
        				
        				if (!Boolean.TYPE.getName().equals(method.getReturnType().getName())) {
        					method.invoke(signature, parameter);
        					return;
						}
        				
        				boolean isSucceed = (boolean) method.invoke(signature, parameter);
        				if (!isSucceed) {
        					throw new GenericServiceRuntimeException(claxx.getSimpleName() + "." + method.getName() + " returned " + isSucceed);
						}
        			}
        			
        		}
				
        	} catch (Exception e) {
        		throw new GenericServiceRuntimeException(e.getMessage(), e);
			}
        	
		}
	}
}
