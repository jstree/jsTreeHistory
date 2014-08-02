package standard.mvc.component.junit.redis.dao;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.data.redis.support.collections.DefaultRedisList;
import org.springframework.data.redis.support.collections.RedisList;
import org.springframework.stereotype.Repository;


@Named(value="redisDao")
public class RedisDao {
	
	private  StringRedisTemplate template;   
	
	private  ValueOperations<String, String> valueOps;
	private  RedisAtomicLong postIdCounter;
	private  RedisAtomicLong userIdCounter;
	private RedisList<String> users;
	private  RedisList<String> timeline;

    //@Value("#{systemProperties['redis.use']}")
    private String redisUse;
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Inject
	private JedisConnectionFactory connectionFactory;

	@Inject
	public RedisDao(StringRedisTemplate template){
		//this.redisUse = System.getProperty("redis.use");		
		this.template = template;
		//log.info("=============DI class=================>" + this.template.getClass().getName());
		String ping = this.template.getConnectionFactory().getConnection().ping();
		//System.out.println("redisPingTest========>" + ping);
		log.debug("redisPingTest========>" + ping);
		valueOps = this.template.opsForValue();
		users = new DefaultRedisList<String>(KeyUtils.users(), this.template);
		timeline = new DefaultRedisList<String>(KeyUtils.timeline(), this.template);
		userIdCounter = new RedisAtomicLong(KeyUtils.globalUid(), this.template.getConnectionFactory());
		postIdCounter = new RedisAtomicLong(KeyUtils.globalPid(), this.template.getConnectionFactory());	
	}
	
	/* 1건의 데이터를 가져온다*/
	public String get(String key){
		String returnValue = "";
		try{
			returnValue =  this.valueOps.get(key);
		}catch(Exception e){
			throw e;
		}finally{}
		return returnValue;
	}
	
	  /** db size를 구합니다. */
    public Long getDbSize(int dbIndex) {
    	long dbSize = 0;
    	try{
        	//this.template.getConnectionFactory().getConnection().select(dbIndex);
        	//this.template.getConnectionFactory().getConnection().flushAll();//이거 사용하면 데이터 다날라감-_-...
    		//log.info(this.connectionFactory.getClass().getName());
    		this.connectionFactory.setDatabase(dbIndex);
        	dbSize = this.template.getConnectionFactory().getConnection().dbSize();
    	}catch(Exception e){
    		throw e;
    	}finally{}
        return dbSize;
    }
    
    /* 데이터 삽입 트랜잭션은 차후 service 영역에서 처리 */
    public void set(String key , String value){
    	try{
    		this.valueOps.set(key, value);	
    	}catch(Exception e){
    		throw e;
    	}finally{}
    }

    /* 데이터 삭제 트랜잭션은 차후 service 영역에서 처리 예정 */
    public void del(String key){
    	try{
    		this.template.delete(key);
    	}catch(Exception e){
    		throw e;
    	}finally{}
    }
	

}
