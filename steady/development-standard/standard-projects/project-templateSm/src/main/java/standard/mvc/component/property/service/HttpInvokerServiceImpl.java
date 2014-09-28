package standard.mvc.component.property.service;


import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public class HttpInvokerServiceImpl implements HttpInvokerService{
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
    private EgovOe1SmsPropertyService egovOe1SmsPropertyService;

	public String getRemoteProperty(String sPropertyFileNm, String sKey) {
		try {
			Properties properties = egovOe1SmsPropertyService.getProperties(sPropertyFileNm + ".properties");
			
			return properties.getProperty(sKey);
			
		} catch (Exception e) {
			log.error(e + "[HttpInvokerService.getRemoteProperty()]");
		}
		return null;
	}

	public String getRemoteProperty(String sKey) {
		// TODO Auto-generated method stub
		return null;
	}

	public Properties getRemoteProperties(String sPropertyFileNm) {
		try {
			return egovOe1SmsPropertyService.getProperties(sPropertyFileNm + ".properties");
		} catch (IOException e) {
			log.error(e + "[HttpInvokerService.getRemoteProperties()]");
		}
		return null;
	}

	public Date getRemoteModifiedTime(String sPropertyFileNm) {
		try {
			return egovOe1SmsPropertyService.getRemoteModifiedTime(sPropertyFileNm);
		} catch (Exception e) {
			log.error(e + "[HttpInvokerService.getRemoteModifiedTime()]");
		}
		return null;
	}

	
	

}
