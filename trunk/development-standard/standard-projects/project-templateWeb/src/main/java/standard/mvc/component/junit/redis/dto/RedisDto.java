package standard.mvc.component.junit.redis.dto;

import org.apache.ibatis.type.Alias;



@Alias("redis.RedisDto")
public class RedisDto {
	
	
	private String key;
	private String value;
	private int dbIndex;
		
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getDbIndex() {
		return dbIndex;
	}
	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
			sb.append("key : ").append(this.getKey()).append(" , \n");
			sb.append("value : ").append(this.getValue()).append(" , \n");
			sb.append("dbIndex : ").append(this.getDbIndex()).append(" , \n");
		sb.append("}");
		return sb.toString();
	}
	
}
