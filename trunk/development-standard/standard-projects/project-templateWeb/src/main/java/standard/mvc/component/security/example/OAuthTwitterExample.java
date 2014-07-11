package standard.mvc.component.security.example;


import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthConstants;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
/**
 *  Class Name : OAuthTwitterExample.java
 *  Description : OAuth1 -> twitter 연동 흐름을 확인하기 위한 샘플 코드
 *  Modification Information
 * 
 *  @author 최대열
 *  @since 2014.07.10
 *  @version 1.0
 *  @see
 *
 *  <pre>
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.10                 최대열		   최초 생성
 *
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class OAuthTwitterExample {
	@SuppressWarnings("resource")
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
//		JsonObject root = (JsonObject) new JsonParser().parse(response.getBody());
//		JsonArray users = root.get("name").getAsJsonArray();
//		Iterator<JsonElement> userIter = users.iterator();
//		while (userIter.hasNext()) {
//			JsonObject user = userIter.next().getAsJsonObject();
//			long userId = user.get("id").getAsLong();
//			String name = user.get("name").getAsString();
//			String screenName = user.get("screen_name").getAsString();
//			OAuthRequest unblock = new OAuthRequest(Verb.POST, "https://api.twitter.com/1.1/blocks/destroy.json");
//			unblock.addQuerystringParameter("user_id", ""+userId);
//			service.signRequest(accessToken, unblock);
//			unblock.send();
// 
//			System.out.println(userId + ":" + name + ":" + screenName);
//		}
 
	}
}
