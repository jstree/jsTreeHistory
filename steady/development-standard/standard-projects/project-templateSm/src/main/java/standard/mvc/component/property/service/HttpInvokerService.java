package standard.mvc.component.property.service;

import java.util.Date;
import java.util.Properties;

public interface HttpInvokerService {
	
	public String getRemoteProperty(String sPropertyFileNm, String sKey);
	
	public String getRemoteProperty(String sKey);
	
	public Properties getRemoteProperties(String sPropertyFileNm);
	
	public Date getRemoteModifiedTime(String sPropertyFileNm);
}
