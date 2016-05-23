package egovframework.com.ext.jstree.support.manager.scheduler.job.jiraToCrowd;
import java.util.List;

import javax.naming.AuthenticationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
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
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

public class CrowdSvcImpl {

	private final String appUsername;
	private final String appPassword;
	private final HttpHost targetHost;
	private final String baseJsonURL;
	private HttpClientContext localContext;

	private final static Logger log = LoggerFactory.getLogger(CrowdSvcImpl.class);

	/**
	 * Initialize the service
	 * 
	 * @param appUsername
	 *            Username (appname stored in crowd) for the application not the
	 *            user to authenticate
	 * @param appPassword
	 *            password for the application.
	 * @param crowdhost
	 *            Host including context e.g. localhost. the context "crowd"
	 *            will be added on the end
	 * @param port
	 *            port for the host
	 * @param protocol
	 *            http or https are valid options
	 */
	public CrowdSvcImpl(String appUsername, String appPassword, String crowdhost, int port, String protocol) {
		log.trace("");
		this.appUsername = appUsername;
		this.appPassword = appPassword;
		this.targetHost = new HttpHost(crowdhost, port, protocol);
		if (port == 80 || port == 443) {
			this.baseJsonURL = protocol + "://" + crowdhost + "/crowd/rest/usermanagement/1/";
		} else {
			this.baseJsonURL = protocol + "://" + crowdhost + ":" + port + "/crowd/rest/usermanagement/1/";
		}
	}

	/**
	 * Executes a git and returns the JSON representation of the returned body
	 * 
	 * @param url
	 *            url to execute
	 * @return JsonNode object representing the result
	 * @throws Exception
	 *             Thrown if the call fails
	 */
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
	
	public String invokePutMethod( String data) throws AuthenticationException, ClientHandlerException {
		Client client = Client.create();
		WebResource webResource = client.resource(baseJsonURL+ "group");
		String auth = new String(Base64.encode("integration:!ahnlab098"));
		ClientResponse response = webResource.header("Authorization", "Basic " + auth).type("application/json")
				.accept("application/json").put(ClientResponse.class, data);
		int statusCode = response.getStatus();
		if (statusCode == 401) {
			throw new AuthenticationException("Invalid Username or Password");
		}
		return response.getEntity(String.class);
	}

	public String invokeDeleteMethod(String data) throws AuthenticationException, ClientHandlerException {
		Client client = Client.create();
		WebResource webResource = client.resource(baseJsonURL + "group?groupname=" + data);
		String auth = new String(Base64.encode("integration:!ahnlab098"));
		ClientResponse response = webResource.header("Authorization", "Basic " + auth).type("application/json")
				.accept("application/json").delete(ClientResponse.class);
		int statusCode = response.getStatus();
		if (statusCode == 401) {
			throw new AuthenticationException("Invalid Username or Password");
		}
		return response.getEntity(String.class);
	}
	
	public JsonNode executePost(String url, JsonNode body) throws Exception, CrowdPostException {
		log.trace("executePost");

		// Build URL to execute
		HttpPost httppost = new HttpPost(url);
		CloseableHttpClient httpclient = null;
		try {
			
			HttpClientContext localContext = buildLocalContext(false);
			httpclient = buildClient();

			System.out.println("URL to access:" + url);
			System.out.println("Body to send to url as post:" + body.toString());
			
			String auth = new String(Base64.encode("integration:!ahnlab098"));
			httppost.setHeader("Authorization", "Basic " + auth);
			httppost.setHeader("Content-Type", "application/json; charset=UTF-8");
			httppost.setHeader("Accept", "application/json");
			httppost.setHeader("X-Atlassian-Token", "nocheck");
			httppost.setHeader("Cache-Control", "no-cache");
            // Add your data
			
			httppost.setEntity(new StringEntity(body.toString(), ContentType.APPLICATION_JSON ));

			CloseableHttpResponse response = httpclient.execute(targetHost, httppost, localContext);
			log.info(response.toString());
			
			// create an ObjectMapper instance.
			ObjectMapper mapper = new ObjectMapper();
			// use the ObjectMapper to read the json string and create a tree
			JsonNode node = null;
			try {
				HttpEntity entity = response.getEntity();
				log.info(response.getStatusLine().toString());
				if (entity != null) {
					log.info("Response content length: " + entity.getContentLength());
					node = mapper.readTree(entity.getContent());
				}
				//EntityUtils.consume(entity);
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
			} finally {
				response.close();
			}

			return node;

		} finally {
			httpclient.close();
		}
	}
	
	public JsonNode pushGroup(JsonNode body) throws Exception {
		log.trace("pullLastBuild");
		JsonNode node = executePost(baseJsonURL + "group" , body);
		return node;
	}
	
	public JsonNode pushUser(JsonNode body) throws Exception {
		log.trace("pullLastBuild");
		System.out.println(body.toString());
		JsonNode node = executePost(baseJsonURL + "user" , body);
		return node;
	}

	public JsonNode pullBasicUserInfo(String username) throws Exception {
		log.trace("pullLastBuild");
		JsonNode node = executeGet(baseJsonURL + "user?username=" + username);
		return node;
	}

	public JsonNode pullBasicGroupInfo(String groupname) throws Exception {
		log.trace("pullLastBuild");
		JsonNode node = executeGet(baseJsonURL + "group?groupname=" + groupname);
		return node;
	}
	
	public JsonNode getAllCrowdProject() throws Exception {
		log.trace("pullLastBuild");
		JsonNode node = executeGet(baseJsonURL + "search?entity-type=group");
		return node;
	}


	/**
	 * Convert a json message representing a crowd user into our CrowdUser model
	 * 
	 * @param crowdUser
	 *            CrowdUser model to fill with data from the JsonNode passed in
	 * @param jsonNode
	 *            Json representing a user
	 * @return CrowdUser, object as passed in
	 */
	public CrowdUser crowdJsonToCrowdUser(CrowdUser crowdUser, JsonNode jsonNode) {
		log.trace("crowdJsonToCrowdUser");
		String firstName = jsonNode.get("first-name").asText();
		String lastName = jsonNode.get("last-name").asText();
		String displayName = jsonNode.get("display-name").asText();
		String email = jsonNode.get("email").asText();
		String username = jsonNode.get("name").asText();

		crowdUser.setDisplayName(displayName);
		crowdUser.setEmail(email);
		crowdUser.setFirstName(firstName);
		crowdUser.setLastName(lastName);
		crowdUser.setUsername(username);

		return crowdUser;

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