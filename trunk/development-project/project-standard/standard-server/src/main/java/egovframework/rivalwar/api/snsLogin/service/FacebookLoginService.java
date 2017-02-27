package egovframework.rivalwar.api.snsLogin.service;

import org.springframework.social.facebook.api.FacebookProfile;

public interface FacebookLoginService {

    public String getUserIdByLoginAndRegisterProcess(FacebookProfile facebookProfile) throws Exception;

}