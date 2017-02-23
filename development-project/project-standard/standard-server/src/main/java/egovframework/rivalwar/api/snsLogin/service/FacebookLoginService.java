package egovframework.rivalwar.api.snsLogin.service;

import org.springframework.social.facebook.api.FacebookProfile;

public interface FacebookLoginService {

    public long getUserIdByLoginAndRegisterProcess(FacebookProfile facebookProfile) throws Exception;

    public boolean getIsNickname(String userId);
}