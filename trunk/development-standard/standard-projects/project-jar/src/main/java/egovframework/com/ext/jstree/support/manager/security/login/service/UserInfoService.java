package egovframework.com.ext.jstree.support.manager.security.login.service;

import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserRole;

public interface UserInfoService
{
	public UserInfo insertUserInfo(UserInfo userInfo) throws Exception;
	
	public void updateUserInfo(UserInfo userInfo) throws Exception;
    
	public UserRole getUserRole(UserInfo userInfo) throws Exception;
    
    public String updatePassword(UserInfo userInfo) throws Exception;
    
    public UserInfo getUserByUuid(UserInfo userInfo) throws Exception;
    
    void updateUseYnByUuid(UserInfo userInfo) throws Exception;
}
