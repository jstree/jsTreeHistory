package standard.mvc.component.junit.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import standard.mvc.component.junit.redis.dto.RedisDto;
import standard.mvc.component.junit.redis.service.RedisService;


/**
 * Modification Information
 * 
 * @author 유창근
 * @since 2014.08.02
 * @version 1.0
 * @see <pre>
 * Class Name 	: Junit_Redis.java
 * Description 	: Redis Junit 테스트 클래스
 *  
 * << 개정이력(Modification Information) >>
 *  
 * 수정일              수정자         수정내용
 * -------      		  ------------   -----------------------
 * 2014.08.01   유창근         최초 생성
 * 
 * Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@ContextConfiguration(locations = {
		"classpath:standard/mvc/component/junit/redis/config/servlet-context.xml",
		"classpath:standard/mvc/component/junit/redis/config/context-redis.xml"
})
public class Junit_Redis extends Junit_Redis_Abstract {
	
	@Inject
	private RedisService redisService;
	
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		log.info("=================Redis Junit Test Start=================");
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
		log.info("=================Redis Junit Test End=================");
	}

	@Override
	public void run_Test() throws Exception {
		// TODO Auto-generated method stub
		log.info("=================Redis Junit Test Contents=================");
		log.info("=====DI Class===>" + this.redisService.getClass().getName());
		
		
		//insert test
		RedisDto params = new RedisDto();
		params.setKey("test1");
		params.setValue("foobared");
		this.redisService.dataInsert(params);
		
		
		//result test
		log.info("redisGet ValueTest====>" + this.redisService.getKeyValue("test1"));
		
	}
	
}
