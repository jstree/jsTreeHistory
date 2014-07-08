package standard.mvc.security.example.oauth;


import java.util.Iterator;
import java.util.Scanner;

import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OAuthTwitterExample {
	public static void main(String[] args) {
		final String CONSUMER_KEY = "HG4CVP4xGFfw3RAaSLn8voxRM";
		final String CONSUMER_SECRET = "GScpVLuLZDgJyawo762UQLMoJi8FpY0Qzhs1W5e8hMBIxsSaeM";
 
		OAuthService service = new ServiceBuilder()
									.provider(TwitterApi.SSL.class)
									.apiKey(CONSUMER_KEY)
									.apiSecret(CONSUMER_SECRET)
									.callback(OAuthConstants.OUT_OF_BAND)
									.build();
 
		Scanner in = new Scanner(System.in);
 
		Token requestToken = service.getRequestToken();
		System.out.println(service.getAuthorizationUrl(requestToken));
		System.out.println(service.getAuthorizationUrl(requestToken) + "?" + requestToken.getRawResponse());
		System.out.print(">>");
		Verifier verifier = new Verifier(in.nextLine());
		System.out.println();
 
		Token accessToken = service.getAccessToken(requestToken, verifier);
		System.out.println(accessToken);
		
		//OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/blocks/list.json");
		OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
		
		service.signRequest(accessToken, request);
		Response response = request.send();
		System.out.println("return body:"+response.getBody());
		JsonObject root = (JsonObject) new JsonParser().parse(response.getBody());
		JsonArray users = root.get("name").getAsJsonArray();
		Iterator<JsonElement> userIter = users.iterator();
		while (userIter.hasNext()) {
			JsonObject user = userIter.next().getAsJsonObject();
			long userId = user.get("id").getAsLong();
			String name = user.get("name").getAsString();
			String screenName = user.get("screen_name").getAsString();
			OAuthRequest unblock = new OAuthRequest(Verb.POST, "https://api.twitter.com/1.1/blocks/destroy.json");
			unblock.addQuerystringParameter("user_id", ""+userId);
			service.signRequest(accessToken, unblock);
			unblock.send();
 
			System.out.println(userId + ":" + name + ":" + screenName);
		}
 
	}
}
