package egovframework.com.ext.jstree.support.manager.security.manage.userRole.service;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;


public interface UserRolesManageService
{
    
    public List<UserInfo> getWholeUserInfo(UserInfo userInfo) throws Exception;
    
    public int updateUserRolesInfo(UserInfo userInfo) throws Exception;
}
