package egovframework.com.ext.jstree.support.manager.scheduler.job.jiraToCrowd;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.Base64;

public class JiraSvcImpl {
	private final String appUsername;
	private final String appPassword;
	private final HttpHost targetHost;
	private final String baseJsonURL;
	private HttpClientContext localContext;

	private final static Logger log = LoggerFactory.getLogger(CrowdSvcImpl.class);

	public JiraSvcImpl(String appUsername, String appPassword, String crowdhost, int port, String protocol) {
		log.trace("");
		this.appUsername = appUsername;
		this.appPassword = appPassword;
		this.targetHost = new HttpHost(crowdhost, port, protocol);
		if (port == 80 || port == 443) {
			this.baseJsonURL = protocol + "://" + crowdhost + "/rest/api/2/";
		} else {
			this.baseJsonURL = protocol + "://" + crowdhost + ":" + port + "/rest/api/2/";
		}
	}
	
	public JsonNode executeGet(String url) throws Exception {
		log.trace("executeGet");

		// Build URL to execute
		HttpGet httpget = new HttpGet(url);
		CloseableHttpClient httpclient = null;
		try {
			HttpClientContext localContext = buildLocalContext(false);
			httpclient = buildClient();

			System.out.println("URL to access:" + url);
			httpget.setHeader("Content-type", "application/json");
			httpget.setHeader("Accept", "application/json");
			CloseableHttpResponse response = httpclient.execute(targetHost, httpget, localContext);

			// create an ObjectMapper instance.
			ObjectMapper mapper = new ObjectMapper();
			// use the ObjectMapper to read the json string and create a tree
			JsonNode node = null;
			try {
				HttpEntity entity = response.getEntity();
				//System.out.println(response.getStatusLine().toString());
				if (entity != null) {
					//System.out.println("Response content length: " + entity.getContentLength());
					node = mapper.readTree(entity.getContent());
				}
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}

			log.debug("Full JSON returned:" + node.toString());
			return node;

		} finally {
			httpclient.close();
		}
	}

	public JsonNode executeXMLGet(String url) throws Exception {
		log.trace("executeGet");
		
		// Build URL to execute
		HttpGet httpget = new HttpGet(url);
		CloseableHttpClient httpclient = null;
		try {
			HttpClientContext localContext = buildLocalContext(false);
			httpclient = buildClient();
			
			System.out.println("URL to access:" + url);
			httpget.setHeader("Content-type", "application/json");
			httpget.setHeader("Accept", "application/json");
			CloseableHttpResponse response = httpclient.execute(targetHost, httpget, localContext);
			
			// create an ObjectMapper instance.
			ObjectMapper mapper = new ObjectMapper();
			// use the ObjectMapper to read the json string and create a tree
			JsonNode node = null;
			try {
				HttpEntity entity = response.getEntity();
				//System.out.println(response.getStatusLine().toString());
				if (entity != null) {
					//System.out.println("Response content length: " + entity.getContentLength());
					node = mapper.readTree(entity.getContent());
				}
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
			
			log.debug("Full JSON returned:" + node.toString());
			return node;
			
		} finally {
			httpclient.close();
		}
	}
	
	public JsonNode executePost(String url, JsonNode body) throws Exception, CrowdPostException {
		log.trace("executePost");

		// Build URL to execute
		HttpPost httppost = new HttpPost(url);
		CloseableHttpClient httpclient = null;
		HttpClientContext localContext = buildLocalContext(false);
		httpclient = buildClient();
		
		System.out.println("URL to access:" + url);
		System.out.println("Body to send to url as post:" + body.toString());
		
		String auth = new String(Base64.encode("admin:1Rose)(*"));
		httppost.setHeader("Authorization", "Basic " + auth);
		httppost.setHeader("Content-Type", "application/json; charset=UTF-8");
		httppost.setHeader("Accept", "application/json");
		httppost.setHeader("X-Atlassian-Token", "nocheck");
		httppost.setHeader("Cache-Control", "no-cache");
		// Add your data
		
		httppost.setEntity(new StringEntity(body.toString(), ContentType.APPLICATION_JSON ));
		
		CloseableHttpResponse response = httpclient.execute(targetHost, httppost, localContext);
		try {
			
			log.info(response.toString());
			JsonNode node = null;
			// create an ObjectMapper instance.
			ObjectMapper mapper = new ObjectMapper();
			// use the ObjectMapper to read the json string and create a tree
			HttpEntity entity = response.getEntity();
			log.info(response.getStatusLine().toString());
			if (entity != null) {
				log.info("Response content length: " + entity.getContentLength());
				if(entity.getContentLength() > 0){
					node = mapper.readTree(entity.getContent());
				}
			}
			EntityUtils.consume(entity);
			log.info("Full JSON returned:" + node.toString());
			if (response.getStatusLine().getStatusCode() != 200) {
				log.warn("Response from Crowd server was some type of error:" + response.getStatusLine().toString());
				throw new CrowdPostException(response.getStatusLine().getStatusCode(), node, response
						.getStatusLine().toString());
			}else if (response.getStatusLine().getStatusCode() != 404) {
				log.warn("Response from Crowd server was some type of error:" + response.getStatusLine().toString());
				throw new CrowdPostException(response.getStatusLine().getStatusCode(), node, response
						.getStatusLine().toString());
			}
			return node;

		} finally {
			response.close();
			httpclient.close();
		}
	}
	
	public JsonNode getAllJiraProject() throws Exception {
		log.trace("pullLastBuild");
		JsonNode node = executeGet(baseJsonURL + "project");
		return node;
	}

	public JsonNode getRoleJiraProject(String projectKey) throws Exception {
		log.trace("pullLastBuild");
		JsonNode node = executeGet(baseJsonURL + "project/" + projectKey + "/role/10001");
		return node;
	}

	protected HttpClientContext buildLocalContext(boolean forceFresh) throws Exception {
		log.trace("buildLocalContext");

		if (this.localContext == null || forceFresh) {

			// Create AuthCache instance
			AuthCache authCache = new BasicAuthCache();
			// Generate BASIC scheme object and add it to the local
			// auth cache
			BasicScheme basicAuth = new BasicScheme();
			authCache.put(targetHost, basicAuth);

			// Add AuthCache to the execution context
			localContext = HttpClientContext.create();
			localContext.setAuthCache(authCache);
			return localContext;
		} else {
			return this.localContext;
		}

	}

	protected CloseableHttpClient buildClient() throws Exception {
		log.trace("buildClient");
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope(targetHost.getHostName(), targetHost.getPort()),
				new UsernamePasswordCredentials(appUsername, appPassword));
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		return httpclient;

	}

}
