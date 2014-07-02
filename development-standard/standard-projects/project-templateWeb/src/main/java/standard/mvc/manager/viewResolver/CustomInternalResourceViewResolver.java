package standard.mvc.manager.viewResolver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import standard.mvc.util.StringUtils;

public class CustomInternalResourceViewResolver extends InternalResourceViewResolver {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private HttpClient httpClient;
	
	@Value("${webDav.viewResolver.use}")
	String WEBDAV_USE;
	@Value("${viewResolver.internelResorce.use}")
	String WEBDAV_VIEWRESOLVER_USE;
	@Value("${webDav.viewResolver.use.id}")
	String USER_NAME;
	@Value("${webDav.viewResolver.use.pass}")
	String PASSWORD;
	@Value("${webDav.viewResolver.use.baseUrl}")
	String NETWORK_BASE_FOLDER;
	@Value("${webDav.viewResolver.use.subUrl}")
	String NETWORK_SUB_FOLDER;
	@Value("${viewResolver.internelResorce.use.prefixUrl}")
	String NETWORK_PREFIX_FOLDER;
	@Value("${viewResolver.internelResorce.use.suffixExtension}")
	String NETWORK_VIEW_SUFFIX;

	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		
		if( !StringUtils.getBoolean(WEBDAV_USE) ){
			//webDav를 통한 디자인 분리를 사용하지 않을때
			return super.resolveViewName(viewName, locale);
		}
		if( !StringUtils.getBoolean(WEBDAV_VIEWRESOLVER_USE) ){
			//설정한 뷰 리졸버를 사용하지 않을때
			return null;
		}
		if(StringUtils.isEmpty(viewName) || null == locale){
			return null;
		}else{
			if( !StringUtils.startsWith(viewName, NETWORK_PREFIX_FOLDER) ){
				//설정된 뷰 리졸버가 프리픽스가 아니라면
				return null;
			}
		}
		
		//WebDav 셋업
		HostConfiguration hostConfiguration = new HostConfiguration();
		hostConfiguration.setHost(NETWORK_BASE_FOLDER);

		HttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
		HttpConnectionManagerParams httpConnectionManagerParams = new HttpConnectionManagerParams();

		int maxHostConnections = 200;
		httpConnectionManagerParams.setMaxConnectionsPerHost(hostConfiguration, maxHostConnections);

		httpConnectionManager.setParams(httpConnectionManagerParams);

		httpClient = new HttpClient(httpConnectionManager);
		httpClient.setHostConfiguration(hostConfiguration);

		Credentials credentials = new UsernamePasswordCredentials(USER_NAME, PASSWORD);
		httpClient.getState().setCredentials(AuthScope.ANY, credentials);

		try {

			//WebDav 연결
			GetMethod getMethod = new GetMethod(NETWORK_BASE_FOLDER + NETWORK_SUB_FOLDER + viewName
					+ NETWORK_VIEW_SUFFIX);
			httpClient.executeMethod(getMethod);

			
			if (getMethod.getStatusCode() == 200) {

				//연결 후 해당 파일에 대한 마지막 변경 시간을 가져온다.
				Header header = getMethod.getResponseHeader("Last-Modified");
				String headerLastModifiedValue = header.getValue();
				Date headerLastModifiedDate = DateUtil.parseDate(headerLastModifiedValue);
				
				//파일을 덮어쓰기전 해당 파일이 존재하는지 확인한다.
				File localViewFile = getLocalViewFile(viewName);
				
				//파일이 존재한다면
				if(localViewFile.isFile()){
					long localViewLastModifiedValue = localViewFile.lastModified();
					Date localViewLastModifiedDate = new Date();
					localViewLastModifiedDate.setTime(localViewLastModifiedValue);
					int compareResult = localViewLastModifiedDate.compareTo(headerLastModifiedDate);
					if(compareResult < 0){
						//외부 시스템의 파일이 갱신 되어 
						//현재 내 로컬파일의 파일보다 최신임
						SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
						logger.debug("local file date =" + simpleFormatter.format(localViewLastModifiedDate));
						logger.debug("remote file date =" + simpleFormatter.format(headerLastModifiedDate));
						try {
							//파일을 WAS 로컬로 복사
							InputStream inputStream = getMethod.getResponseBodyAsStream();
							FileUtils.copyInputStreamToFile(inputStream, localViewFile);
						} catch (IOException e) {
							//복사 도중에 IOException 이 난다면.
							//해당 로컬 파일을 삭제.
							localViewFile.delete();
							logger.error(this.getClass().getName() + " IOException Catch! => " + viewName + NETWORK_VIEW_SUFFIX);
							//다음 리졸버로 넘겨버림
							return null;
						}
					}
				}else{
					try {
						//파일이 없으므로 WAS로컬로 복사
						InputStream inputStream = getMethod.getResponseBodyAsStream();
						FileUtils.copyInputStreamToFile(inputStream, localViewFile);
						
					} catch (IOException e) {
						//복사 도중에 IOException 이 난다면.
						//해당 로컬 파일을 삭제.
						localViewFile.delete();
						logger.error(this.getClass().getName() + " IOException Catch! => " + viewName + NETWORK_VIEW_SUFFIX);
						//다음 리졸버로 넘겨버림
						return null;
					}
				}
				return super.resolveViewName(viewName, locale);

			} else if (getMethod.getStatusCode() == 404) {
				return getLocalViewSearchORnull(viewName, locale);

			} else {
				return getLocalViewSearchORnull(viewName, locale);
			}
			// TODO : 향후에는 좀더 디테일한 status code 컨트롤을 할 수 있으므로
			// 아래와 같이 status code를 남겨둔다.
			/*
			 * 0.1 Informational 1xx 100 Continue 101 Switching Protocols
			 * 
			 * Successful 2xx 200 OK 201 Created 202 Accepted 203
			 * Non-Authoritative Information 204 No Content 205 Reset
			 * Content 206 Partial Content
			 * 
			 * Redirection 3xx 300 Multiple Choices 301 Moved Permanently
			 * 302 Found 303 See Other 304 Not Modified 305 Use Proxy 306
			 * (Unused) 307 Temporary Redirect
			 * 
			 * Client Error 4xx 400 Bad Request 401 Unauthorized 402 Payment
			 * Required 403 Forbidden 404 Not Found 405 Method Not Allowed
			 * 406 Not Acceptable 407 Proxy Authentication Required 408
			 * Request Timeout 409 Conflict 410 Gone 411 Length Required 412
			 * Precondition Failed 413 Request Entity Too Large 414
			 * Request-URI Too Long 415 Unsupported Media Type 416 Requested
			 * Range Not Satisfiable 417 Expectation Failed
			 * 
			 * Server Error 5xx 500 Internal Server Error 501 Not
			 * Implemented 502 Bad Gateway 503 Service Unavailable 504
			 * Gateway Timeout 505 HTTP Version Not Supported
			 */

		} catch (HttpException e) {
			return getLocalViewSearchORnull(viewName, locale);
		} catch (Exception e) {
			return getLocalViewSearchORnull(viewName, locale);
		} finally {
			logger.debug( this.getClass().getName() + "resolver catch!");
		}

	}

	private File getLocalViewFile(String viewName) {
		String contextRealPath = getServletContext().getRealPath("/");
		viewName = viewName.replace("/", SystemUtils.FILE_SEPARATOR);
		String localViewFullPath = contextRealPath + "WEB-INF" + viewName + NETWORK_VIEW_SUFFIX;
		File localViewFile = new File(localViewFullPath);
		return localViewFile;
	}

	private View getLocalViewSearchORnull(String viewName, Locale locale)
			throws Exception {
		File localViewFile = getLocalViewFile(viewName);
		if (localViewFile.isFile()) {
			return super.resolveViewName(viewName, locale);
		} else {
			return null;
		}
	}

}
