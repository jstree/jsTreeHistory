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
		final JiraRestClient restClient = factory.createWithBasicHttpAuthentication(jiraServerUri, "admin", "1"
				+ "Rose)(*");
		
		//CROWD Conf
		String appUsername = "crowd";
		String password = "!crowd098";
		String hosturl = "crowd.ahnlab.com";
		int port = 8095;
		String protocol = "https";
		CrowdSvcImpl crowdSvc = null;
		try {
			crowdSvc = new CrowdSvcImpl(appUsername, password, hosturl, port, protocol);
		} catch (Exception ex) {
			throw ex;
		}

		
		
        for (BasicProject project : restClient.getProjectClient().getAllProjects().get(1000000, TimeUnit.SECONDS)) {
            //System.out.println(project.getKey() + ": " + project.getName());
            
            Iterable<ProjectRole> roleList = restClient.getProjectRolesRestClient().getRoles(project.getSelf()).claim();
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
	
}
