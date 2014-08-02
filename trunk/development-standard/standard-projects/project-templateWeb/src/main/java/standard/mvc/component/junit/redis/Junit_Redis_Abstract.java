package standard.mvc.component.junit.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import standard.mvc.component.junit.redis.logConfig.JUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class Junit_Redis_Abstract {
		
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Before
	public abstract void start();
	
	@After
	public abstract void end();
	
	@Test
	public abstract void run_Test() throws Exception;
	
	
}
