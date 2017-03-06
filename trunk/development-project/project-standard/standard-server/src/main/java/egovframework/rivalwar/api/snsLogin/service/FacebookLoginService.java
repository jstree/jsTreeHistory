package egovframework.rivalwar.api.snsLogin.service;

import egovframework.com.sec.rgm.service.AuthorGroup;
import org.springframework.social.facebook.api.FacebookProfile;

public interface FacebookLoginService {

    public String getUserIdByLoginAndRegisterProcess(FacebookProfile facebookProfile, AuthorGroup authorGroup) throws Exception;

}