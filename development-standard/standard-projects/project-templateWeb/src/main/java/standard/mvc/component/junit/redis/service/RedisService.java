package standard.mvc.component.junit.redis.service;

import standard.mvc.component.junit.redis.dto.RedisDto;

public interface RedisService {
	
	
	public String getKeyValue(String key) throws Exception;

	public long getDbSize(int dbIndex) throws Exception;
	
	public void dataInsert(RedisDto params);

	public void dataDelete(RedisDto params);

	public void createCategoryData(String string, String jsonString);

}
