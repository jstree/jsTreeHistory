package egovframework.com.ext.jstree.support.manager.scheduler.job.jiraToCrowd;


import java.io.File;
import java.net.URI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.BasicProject;
import com.atlassian.jira.rest.client.internal.ServerVersionConstants;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Sets;
import com.sun.jersey.api.client.ClientHandlerException;

import egovframework.com.ext.jstree.support.util.DateUtils;
import egovframework.com.ext.jstree.support.util.StringUtils;
@Component
public class ReversSync {
	
	private static URI jiraServerUri = URI.create("https://works.ahnlab.com");
	
	@Scheduled(fixedDelay = 10000000)
	public void execute() throws Exception {

		System.setProperty("javax.net.ssl.trustStore","C:\\Program Files\\Java\\jdk1.7.0_80\\jre\\lib\\security\\keystore_sha2.jks");
		System.setProperty("javax.net.ssl.keyStorePassword","dksfoq");
		
		//JIRA Conf
		final AsynchronousJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
		final JiraRestClient jiraRestClient = factory.createWithBasicHttpAuthentication(jiraServerUri, "admin", "1Rose)(*");
		
		//CROWD Conf
		final CrowdSvcImpl crowdSvc = new CrowdSvcImpl("integration", "!ahnlab098", "172.16.109.18", 8095, "http");
		
		File logFile = FileUtils.getFile("C:\\temp\\" + "log.txt");
		ArrayList<Object> lines = new ArrayList<>();

		try {
			
			//초기화
			Iterable<BasicProject> jiraAllProjects = null;
			
			// first let's get and print all visible projects (only jira4.3+)
			final int buildNumber = jiraRestClient.getMetadataClient().getServerInfo().claim().getBuildNumber();
			
			
			Set<String> jiraProjects = new HashSet<String>();
			if (buildNumber >= ServerVersionConstants.BN_JIRA_4_3) {
				jiraAllProjects = jiraRestClient.getProjectClient().getAllProjects().claim();
				
				
				lines.add("===" + DateUtils.getCurrentDay().toString() + "===");
				for (BasicProject worksProject : jiraAllProjects) {
					lines.add(worksProject.getName());
					jiraProjects.add("Dev_" + worksProject.getName().toString());
				}
			}

			Set<String>crowdProjects = new HashSet<String>();
			JsonNode crowdAllProjects = crowdSvc.getAllCrowdProject();
			JsonNode groups = crowdAllProjects.get("groups");
			if( groups.size() > 0 ){
				for (int i = 0; i < groups.size(); i++) {
					JsonNode node = groups.get(i);
					JsonNode nameStr = node.get("name");
					if(StringUtils.contains(nameStr.toString(), "Dev_")){
						crowdProjects.add(StringUtils.replace(nameStr.toString(), "\"", ""));
					}
				}
			}
			
			Set<String> intersectionProjects = Sets.intersection(jiraProjects, crowdProjects);
			Set<String> crowdSubtractProjects = Sets.difference(crowdProjects, intersectionProjects);
			Set<String> jiraSubtractProjects = Sets.difference(jiraProjects, intersectionProjects);
			
			System.out.println("===== intersection 교집합 =====");
			for (String intersectionProject : intersectionProjects) {
				System.out.println(intersectionProject);
			}
			
			//삭제해야 할 프로젝트 : crowdSubtractProjects
			lines.add("===== delete 삭제해야 할 프로젝트 =====");
			for (String crowdProjectStr : crowdSubtractProjects) {
				lines.add(crowdProjectStr);
			}
			
			//등록해야 할 프로젝트 : jiraSubtractProjects
			lines.add("===== insert 등록해야 할 프로젝트 =====");
			for (String jiraProjectStr : jiraSubtractProjects) {
				lines.add(jiraProjectStr);
				//group 생성
				//////////////////////////////////////////////////////////////////////////////////////
				
				try {
					ObjectMapper mapper = new ObjectMapper();
					ObjectNode node = mapper.getNodeFactory().objectNode();
					node.put("name", jiraProjectStr);
					node.put("type", "GROUP");
					node.put("description", "Group Description");
					node.put("active", true);
					JsonNode actualObj = mapper.readValue(mapper.writeValueAsString(node), JsonNode.class);
					JsonNode result = crowdSvc.pushGroup(actualObj);
					System.out.println(result);
					
				} catch (ClientHandlerException e) {
					System.out.println("Error invoking REST method");
					e.printStackTrace();
				} catch (JSONException e) {
					System.out.println("Invalid JSON output");
					e.printStackTrace();
				}
			}
			

			//group 삭제
			//System.out.println(crowdSvc.invokeDeleteMethod("Dev_M2"));
			/*
			try {
				ObjectMapper mapper = new ObjectMapper();
			    ObjectNode node = mapper.getNodeFactory().objectNode();
			    ObjectMapper mapper2 = new ObjectMapper();
			    ObjectNode node2 = mapper2.getNodeFactory().objectNode();
			    node.put("name", "my_username");
			    node.put("first-name", "My");
			    node.put("last-name", "Username");
			    node.put("display-name", "Username");
			    node.put("email", "Username");
			    
			    node2.put("value", "my_password");
			    
			    node.put("password", node2);
			    node.put("active", true);
			    
			    
			    System.out.println(mapper.writeValueAsString(node));
			    JsonNode actualObj = mapper.readValue(mapper.writeValueAsString(node), JsonNode.class);
				
			    JsonNode result = crowdSvc.pushUser(actualObj);
			    System.out.println(result);
	            
			} catch (ClientHandlerException e) {
				System.out.println("Error invoking REST method");
				e.printStackTrace();
			} catch (JSONException e) {
				System.out.println("Invalid JSON output");
				e.printStackTrace();
			}
			*/
			///////////////////////////////////////////////////////////////////////////////////////
			
			
			
			
			
			FileUtils.writeLines(logFile, lines);
		} catch (Exception e) {
			jiraRestClient.close();
		}finally {
			jiraRestClient.close();
		}
		
	}
	
}
