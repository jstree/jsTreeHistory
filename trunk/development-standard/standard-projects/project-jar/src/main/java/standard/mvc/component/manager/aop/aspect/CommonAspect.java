package standard.mvc.component.manager.aop.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common Aspect
 *
 * @author whitelife
 * @see Logger
 * @see LoggerFactory
 * @since 2014.08.21
 * @version 0.1
 */
public abstract class CommonAspect {

	/**
	 * Common Logger
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

}
