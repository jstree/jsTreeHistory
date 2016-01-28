package egovframework.com.ext.jstree.support.manager.security.login.service;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.security.login.vo.UserRole;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;

public interface UserInfoService
{
    void updateUserInfo(UserInfo userInfo) throws Exception;
    
    UserRole getUserRole(UserInfo userInfo) throws Exception;
}
