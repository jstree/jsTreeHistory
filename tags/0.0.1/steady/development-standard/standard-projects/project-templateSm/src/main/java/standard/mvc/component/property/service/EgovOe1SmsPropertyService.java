package standard.mvc.component.property.service;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.HeadMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.googlecode.sardine.DavResource;
import com.googlecode.sardine.Sardine;
import com.googlecode.sardine.SardineFactory;

import egovframework.oe1.sms.property.service.EgovOe1SmsPropEntryVO;
import egovframework.oe1.sms.property.service.EgovOe1SmsPropertyVO;


@Service("propertyService")
public class EgovOe1SmsPropertyService {
	Logger log = Logger.getLogger(this.getClass());
    
    private final String _HOST = "http://nas.313.co.kr:5005/web";
    private final String _FOLDER = "/Source/prop/";
    private final String _ID = "KimDaeGun";
    private final String _PW = "rlaeorms2@";
	
    
    /**
     * 
     * @return
     * @throws Exception
     */
	public List<EgovOe1SmsPropertyVO> selectPropertyList() throws Exception {
		Sardine sardine = SardineFactory.begin();
		sardine.setCredentials(_ID, _PW);
		List<DavResource> resources = sardine.list(_HOST + _FOLDER);
		
		List<EgovOe1SmsPropertyVO> returnList = new ArrayList<EgovOe1SmsPropertyVO>();
		EgovOe1SmsPropertyVO addVO = null;
		for (DavResource res : resources){
			if(res.getName().indexOf(".properties") >= 0){
				addVO = new EgovOe1SmsPropertyVO();
	        	
	        	addVO.setBeanNm("propertiesConfig");
	        	addVO.setBeanClassNm("java.util.Properties");
	        	addVO.setPropertyCnt(resources.size());
	        	addVO.setPropertyNm(res.getName());
	        	
	        	returnList.add(addVO);
			}
		}
		
		return returnList;
	}
	
	/**
	 * 
	 * @param sPropertyNm
	 * @return
	 * @throws Exception
	 */
	public EgovOe1SmsPropertyVO selectProperty(String sPropertyNm) throws Exception {
		Properties properties = this.getProperties(sPropertyNm);
		
		EgovOe1SmsPropertyVO returnVO = new EgovOe1SmsPropertyVO();
    	returnVO.setBeanNm("하드코딩");
    	returnVO.setBeanClassNm("java.util.Properties");
    	returnVO.setPropertyNm(sPropertyNm);
    	
    	if(!properties.isEmpty()){
    		Iterator<Object> keyList = properties.keySet().iterator();
    		
    		EgovOe1SmsPropEntryVO addVO = null;
    		String sKey = null;
    		while(keyList.hasNext()){
    			sKey = (String)keyList.next();
    			
    			addVO = new EgovOe1SmsPropEntryVO();
    			addVO.setPropEntryKey(sKey);
    			addVO.setPropEntryValue(properties.getProperty(sKey));
    			
    			returnVO.setProperty(addVO);
    		}
    	}
    	
    	return returnVO;
	}
	
	/**
	 * 
	 * @param propertyVO
	 * @throws Exception
	 */
	public void updateProperty(EgovOe1SmsPropertyVO propertyVO) throws Exception {
		
		String[] keyArr = propertyVO.getPropEntryKey();
		String[] valArr = propertyVO.getPropEntryValue();
		
		
		Sardine sardine = SardineFactory.begin(_ID, _PW);
		InputStream inputStream = sardine.get(_HOST + _FOLDER + propertyVO.getPropertyNm());
		Properties properties = new Properties();
		properties.load(inputStream);
		
		for(int i=0; i<keyArr.length; i++){
			properties.setProperty(keyArr[i], valArr[i]);
		}
		
		String path = this.getClass().getResource("/").getPath() + "/" + propertyVO.getPropertyNm();
		OutputStream outputStream = new FileOutputStream(path); 
		properties.store(outputStream, "");
		
		sardine.put(_HOST + _FOLDER + propertyVO.getPropertyNm(), new FileInputStream(new File(path)));
		
		if(inputStream != null){
			inputStream.close();
		}
		if(outputStream != null){
			outputStream.close();
		}
	}
	
	/**
	 * 
	 * @param propertyVO
	 * @throws Exception
	 */
	public void insertProperties(EgovOe1SmsPropertyVO propertyVO) throws Exception {
		Sardine sardine = SardineFactory.begin(_ID, _PW);
    	String sFileName = propertyVO.getBeanNm() + ".properties";
    	
    	if(!sardine.exists(_HOST + _FOLDER + sFileName)){
    		String[] keyArr = propertyVO.getPropEntryKey();
    		String[] valArr = propertyVO.getPropEntryValue();
    		
    		Properties properties = new Properties();
    		
    		for(int i=0; i<keyArr.length; i++){
    			properties.setProperty(keyArr[i], valArr[i]);
    		}
    		
    		String path = this.getClass().getResource("/").getPath();
    		OutputStream outputStream = new FileOutputStream(path + "/" + sFileName); 
    		properties.store(outputStream, "");
    		
    		sardine.put(_HOST + _FOLDER + sFileName, new FileInputStream(new File(path+ "/" +sFileName)));
    		
    	}else{
    		//존재하면 에러를 내야할까
    	}
	}
	
	/**
	 * 
	 * @param sPropertyNm
	 * @throws Exception
	 */
	public void deleteProperties(String sPropertyNm) throws Exception {
		Sardine sardine = SardineFactory.begin(_ID, _PW);
		if(sardine.exists(_HOST + _FOLDER + sPropertyNm)){
			sardine.delete(_HOST + _FOLDER + sPropertyNm);
		}
	}
	
	/**
	 * 
	 * @param sPropertyFileNm
	 * @return
	 */
	public Properties getProperties(String sPropertyFileNm) throws IOException{
		Sardine sardine = SardineFactory.begin(_ID, _PW);
		InputStream inputStream = sardine.get(_HOST + _FOLDER + sPropertyFileNm);
		
		Properties properties = new Properties();
		properties.load(inputStream);

    	if(inputStream != null){
    		inputStream.close();
    	}
		return properties;
	}
	
	/**
	 * 
	 * @param sPropertyFileNm
	 * @return
	 * @throws Exception
	 */
	public Date getRemoteModifiedTime(String sPropertyFileNm) throws Exception {
		Sardine sardine = SardineFactory.begin();
		sardine.setCredentials(_ID, _PW);
		List<DavResource> resources = sardine.list(_HOST + _FOLDER);
		
		for (DavResource res : resources){
			if(res.getName().equals(sPropertyFileNm)){
	        	return res.getModified();
			}
		}
		
		return null;
	}
}
