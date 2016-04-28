package egovframework.com.ext.jstree.support.manager.scheduler.job.jiraToCrowd;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.BasicProject;
import com.atlassian.jira.rest.client.api.domain.ProjectRole;
import com.atlassian.jira.rest.client.api.domain.RoleActor;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.fasterxml.jackson.databind.JsonNode;

import egovframework.com.ext.jstree.support.util.StringUtils;

@Component
public class ReversSync {

	@Scheduled(fixedDelay = 10000000)
	public void execute() throws Exception {
		
		//JIRA Conf
		final AsynchronousJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
		URI jiraServerUri = new URI("https://works.ahnlab.com:8080");
		final JiraRestClient jiraRestClient = factory.createWithBasicHttpAuthentication(jiraServerUri, "admin", "1"
				+ "Rose)(*");
		
		//CROWD Conf
		String crowdUsername = "crowd";
		String crowdpassword = "!crowd098";
		String crowdHosturl = "crowd.ahnlab.com";
		int crowdPort = 8095;
		String crowdProtocol = "https";
		CrowdSvcImpl crowdSvc = null;
		try {
			crowdSvc = new CrowdSvcImpl(crowdUsername, crowdpassword, crowdHosturl, crowdPort, crowdProtocol);
		} catch (Exception ex) {
			throw ex;
		}

		Iterable<BasicProject> jiraProjects = jiraRestClient.getProjectClient().getAllProjects().get(60, TimeUnit.SECONDS);
		
        for (BasicProject jiraProject : jiraProjects) {
            
        	System.out.println("check jiraProject Key : Name " + jiraProject.getKey() + ": " + jiraProject.getName());
        	//TODO : 프로젝트 그룹이 존재하는지 확인.
        	String DevProject = "Dev_" + jiraProject.getKey();
			JsonNode DevJiraCrowdSyncGroupNode = crowdSvc.pullBasicGroupInfo(StringUtils.deleteWhitespace(DevProject));
			if(DevJiraCrowdSyncGroupNode.has("reason")){
				//reason 노드가 존재함. ( 404 )
				//crowd에 입력을 요함.
				System.out.println("404 need crowd input");
			}else{
				// 이미 존재함. 확인하고 그냥 넘어갈것.
				System.out.println("200 = " + DevJiraCrowdSyncGroupNode.toString());
			}
        }
	}

	private void imsi(final JiraRestClient jiraRestClient, CrowdSvcImpl crowdSvc, BasicProject project)
			throws Exception {
		Iterable<ProjectRole> roleList = jiraRestClient.getProjectRolesRestClient().getRoles(project.getSelf()).claim();
		for (ProjectRole projectRole : roleList) {
			//System.out.println(projectRole.getName() + ":" + projectRole.getId());
			
			//TODO : 프로젝트 그룹이 존재하는지 확인.
			JsonNode jsonGroup = crowdSvc.pullBasicGroupInfo(StringUtils.deleteWhitespace(projectRole.getName()));
			System.out.println(jsonGroup.toString());
			//TODO : 존재하면
				
			//TODO : 존재하지 않으면
			
			Iterable<RoleActor> actors = projectRole.getActors();
			for (RoleActor roleActor : actors) {
				
				//System.out.println(roleActor.getName() + "=" + roleActor.getType() + "=" + roleActor.getId());
				//System.out.println("============ crowd search ===============");
				
				String trimString = StringUtils.deleteWhitespace(roleActor.getName());
				JsonNode jsonUser = crowdSvc.pullBasicUserInfo(trimString);
				//System.out.println(jsonUser.toString());
			}
		}
	}
	
}
