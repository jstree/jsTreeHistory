package egovframework.com.ext.jstree.support.manager.security.login.service;

import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLogin;

public interface UserInfoService
{
    void updateUserInfo(SecureUserLogin secureUserLogin) throws Exception;
}
