package egovframework.com.ext.jstree.support.atlassian;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

import org.junit.Test;

import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.domain.BasicIssue;
import com.atlassian.jira.rest.client.domain.Issue;
import com.atlassian.jira.rest.client.domain.IssueLink;
import com.atlassian.jira.rest.client.domain.SearchResult;
import com.atlassian.jira.rest.client.internal.jersey.JerseyJiraRestClientFactory;


public class JiraRestApiTest {

	@Test
	public void test() throws MalformedURLException {
		JerseyJiraRestClientFactory f = new JerseyJiraRestClientFactory();
		JiraRestClient jc;
		try {
			String httpsURL = "https://works.ahnlab.com:8080/";
		    URI myurl = new URI(httpsURL);
			jc = f.createWithBasicHttpAuthentication(myurl, "admin", "1Rose)(*");
			SearchResult r = jc.getSearchClient().searchJql("component = \" _휴가.부재\"", null);
			
			Iterator<? extends BasicIssue> it = r.getIssues().iterator();
			while (it.hasNext()) {

				Issue issue = jc.getIssueClient().getIssue(((BasicIssue) it.next()).getKey(), null);

				System.out.println("Epic: " + issue.getKey() + " " + issue.getSummary());

				Iterator<IssueLink> itLink = issue.getIssueLinks().iterator();
				while (itLink.hasNext()) {

					IssueLink issueLink = (IssueLink) itLink.next();
					Issue issueL = jc.getIssueClient().getIssue((issueLink).getTargetIssueKey(), null);

					System.out.println(issueLink.getIssueLinkType().getDescription() + ": " + issueL.getKey() + " "
							+ issueL.getSummary() + " " + issueL.getFieldByName("Story Points").getValue());

				}

			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
