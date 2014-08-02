package standard.mvc.component.junit.redis.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import standard.mvc.component.junit.redis.dao.RedisDao;
import standard.mvc.component.junit.redis.dto.RedisDto;
import standard.mvc.component.junit.redis.service.RedisService;

@Service(value="redisService")
public class RedisServiceImpl implements RedisService {
	
	@Inject
	private RedisDao redisDao;
	
	@Override
	public String getKeyValue(String key) throws Exception {
		// TODO Auto-generated method stub
		return this.redisDao.get(key);
	}
	

	@Override
	public long getDbSize(int dbIndex) throws Exception {
		// TODO Auto-generated method stub
		return this.redisDao.getDbSize(dbIndex);
	}


	@Override
	public void dataInsert(RedisDto params) {
		// TODO Auto-generated method stub
		this.redisDao.set(params.getKey(), params.getValue());
	}


	@Override
	public void dataDelete(RedisDto params) {
		// TODO Auto-generated method stub
		this.redisDao.del(params.getKey());
	}


	@Override
	public void createCategoryData(String key, String value) {
		// TODO Auto-generated method stub
		this.redisDao.set(key, value);
	}
	
	
}
