package standard.mvc.security.example.oauth;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

public class OAuthTwitter2Example {
	//static final String REQUEST_TOKEN_URL = "https://nid.naver.com/naver.oauth?mode=req_req_token";
	static final String REQUEST_TOKEN_URL ="https://api.twitter.com/oauth/request_token";
    //static final String AUTHORIZE_URL = "https://nid.naver.com/naver.oauth?mode=auth_req_token";
    static final String AUTHORIZE_URL = "https://api.twitter.com/oauth/authorize";
    //static final String ACCESS_TOKEN_URL = "https://nid.naver.com/naver.oauth?mode=req_acc_token";
    static final String ACCESS_TOKEN_URL = "https://api.twitter.com/oauth/access_token";
    
    static final String CONSUMER_KEY = "HG4CVP4xGFfw3RAaSLn8voxRM";//API key 
    static final String CONSUMER_SECRET = "GScpVLuLZDgJyawo762UQLMoJi8FpY0Qzhs1W5e8hMBIxsSaeM";//API secret
    
    // API prefix (보호된 자원이 있는 URL의 prefix)
    static final String API_URL = "https://api.twitter.com/1.1/account/verify_credentials.json";

    // Service Provider 객체 생성
    static OAuthProvider provider = new DefaultOAuthProvider(REQUEST_TOKEN_URL, ACCESS_TOKEN_URL, AUTHORIZE_URL);   
    // Consumer 객체 생성
    static OAuthConsumer consumer = new DefaultOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
    
    public static void main(String[] args) throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException, IOException, URISyntaxException {         

            // request token 요청 
            //String authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
            String authUrl = provider.retrieveRequestToken(consumer, "http://127.0.0.1/twitter");
            
            System.out.println("아래 URL로 가서 사용자 인증을 하시면 인증코드(verifier)를 얻을 수 있습니다.");
            System.out.println(authUrl);
            
            System.out.print("인증코드 입력 : ");
            Scanner s = new Scanner(System.in);             
            String verifier = s.next();
            
            provider.retrieveAccessToken(consumer, verifier);
            
/*
            // 여기서는 변수에 저장하지만, 실제로 개발을 할 때는 Access Token이 발급된 이후,
            // FileSystem, DB 등 저장공간에 넣어두고, 이후에는 발급절차를 생략할 수 있다. 
                    
            final String ACCESS_TOKEN = consumer.getToken();
            final String TOKEN_SECRET = consumer.getTokenSecret();
                            
            
            // 미리 저장된 Access token 정보는 setTokenWithSecret() 메소드로 지정할 수 있다.
            consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);
*/              
            
            URL url = new URL("https://api.twitter.com/1.1/account/verify_credentials.json");               
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            // oauth_signature 값을 얻습니다.
            consumer.sign(request);         
            
            request.connect();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String tmpStr = "";
            while( (tmpStr = br.readLine()) != null) {
                    System.out.println(tmpStr);
            }
                            
    }
}
