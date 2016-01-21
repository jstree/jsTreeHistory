package egovframework.com.ext.jstree.support.manager.scheduler.job.jiraToCrowd;


import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;


@Component
public class ReversSync {

	// @Scheduled(fixedDelay=10000000)
	// public void execute()
	// {
	public static void main(String[] args) throws URISyntaxException, IOException {
		Client client = Client.create();			
		client.addFilter(new HTTPBasicAuthFilter("admin", "1Rose)(*"));
		WebResource webResource = client.resource("https://works.ahnlab.com:8080");			
		String input="";		
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

		String output = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");
		System.out.println(output);

	}
}
