package egovframework.com.ext.jstree.support.manager.scheduler.job.jiraToCrowd;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.naming.AuthenticationException;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.ServerVersionConstants;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
	
	//JIRA Config
	final AsynchronousJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
	final JiraRestClient jiraRestClient = factory.createWithBasicHttpAuthentication(jiraServerUri, "admin", "1Rose)(*");

	final JiraSvcImpl jiraSvc = new JiraSvcImpl("admin", "1Rose)(*", "works.ahnlab.com", 443, "https");
	
	//CROWD Config
	final CrowdSvcImpl crowdSvc = new CrowdSvcImpl("integration", "!ahnlab098", "172.16.109.18", 8095, "http");
	
	//Logfile Config
	File logFile = FileUtils.getFile("C:\\temp\\" + "log.txt");

	@Scheduled(fixedDelay = 10000000)
	public void execute() throws Exception {

		//JVM Security setting
		System.setProperty("javax.net.ssl.trustStore","C:\\Program Files\\Java\\jdk1.7.0_80\\jre\\lib\\security\\keystore_sha2.jks");
		System.setProperty("javax.net.ssl.keyStorePassword","dksfoq");
		
		//Logfile writer
		ArrayList<Object> logFileWriteBuffer = new ArrayList<>();
		logFileWriteBuffer.add("===" + DateUtils.getCurrentDay().toString() + "===");
		
		try {
			
			// first let's get and print all visible projects (only jira4.3+)
			final int buildNumber = jiraRestClient.getMetadataClient().getServerInfo().claim().getBuildNumber();
			
			
			Set<String> jiraProjects = new HashSet<String>();
			if (buildNumber >= ServerVersionConstants.BN_JIRA_4_3) {
				
				JsonNode getJiraAPIAllProject = jiraSvc.getAllJiraProject();
				if(getJiraAPIAllProject.size() > 0){
					for (int i = 0; i < getJiraAPIAllProject.size(); i++) {
						JsonNode perProject = getJiraAPIAllProject.get(i);
						logFileWriteBuffer.add(perProject.get("name") + "=====" + perProject.get("projectCategory").get("name")); 
						
						if(StringUtils.startsWith(perProject.get("projectCategory").get("name").textValue(), "Z.")){
							//아카이브 처리 규칙
							
						}else{
							jiraProjects.add("Dev_" + perProject.get("name").asText());
							
							////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
							JsonNode perProjectRoles = jiraSvc.getRoleJiraProject(perProject.get("id").textValue());
							JsonNode actors = perProjectRoles.get("actors");
							if(actors.size() > 0){
								for (JsonNode actor : actors) {
									
									if(StringUtils.equals(actor.get("type").asText(), "atlassian-group-role-actor")){
										ObjectMapper mapper = new ObjectMapper();
										ObjectNode node = mapper.getNodeFactory().objectNode();
										node.put("name", actor.get("name").asText());
										JsonNode projectGroupObj = mapper.readValue(mapper.writeValueAsString(node), JsonNode.class);
										crowdSvc.pushNestedGroup(projectGroupObj, "Dev_"+perProject.get("name").asText());
									}else{
										ObjectMapper mapper = new ObjectMapper();
										ObjectNode node = mapper.getNodeFactory().objectNode();
										node.put("name", "Dev_" + perProject.get("name").asText());
										JsonNode projectGroupObj = mapper.readValue(mapper.writeValueAsString(node), JsonNode.class);
										
										crowdSvc.pushUser(projectGroupObj, actor.get("name").asText());
									}
								}
							}
							
							JsonNode allCrowdEntity = crowdSvc.getAllCrowdEntity();
							
							////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
							
						}
						
					}
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
			logFileWriteBuffer.add("===== delete 삭제해야 할 프로젝트 =====");
			deleteProject(logFileWriteBuffer, crowdSubtractProjects);
			//삭제하기 전에 해당 그룹의 사용자를 crowd 에서 삭제한 후 삭제 로직 수행
			
			//등록해야 할 프로젝트 : jiraSubtractProjects
			logFileWriteBuffer.add("===== insert 등록해야 할 프로젝트 =====");
			insertProject(logFileWriteBuffer, jiraSubtractProjects);
			
			FileUtils.writeLines(logFile, logFileWriteBuffer);
		} catch (Exception e) {
			jiraRestClient.close();
		}finally {
			jiraRestClient.close();
		}
		
	}

	private void deleteProject(ArrayList<Object> logFileWriteBuffer, Set<String> crowdSubtractProjects)
			throws AuthenticationException {
		for (String crowdProjectStr : crowdSubtractProjects) {
			logFileWriteBuffer.add(crowdProjectStr);
			System.out.println(crowdSvc.invokeDeleteMethod(crowdProjectStr));
		}
	}

	private void insertProject(ArrayList<Object> logFileWriteBuffer, Set<String> jiraSubtractProjects)
			throws IOException, JsonParseException, JsonMappingException, JsonProcessingException, Exception {
		for (String jiraProjectStr : jiraSubtractProjects) {
			logFileWriteBuffer.add(jiraProjectStr);
			//group 생성
			try {
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode node = mapper.getNodeFactory().objectNode();
				node.put("name", jiraProjectStr);
				node.put("type", "GROUP");
				node.put("description", "Group Description");
				node.put("active", true);
				JsonNode actualObj = mapper.readValue(mapper.writeValueAsString(node), JsonNode.class);
				JsonNode result = crowdSvc.pushGroup(actualObj);
				//System.out.println(result);
				
			} catch (ClientHandlerException e) {
				System.out.println("Error invoking REST method");
				e.printStackTrace();
			} catch (JSONException e) {
				System.out.println("Invalid JSON output");
				e.printStackTrace();
			}
		}
	}
	
}
