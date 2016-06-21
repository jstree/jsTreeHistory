package egovframework.com.ext.jstree.support.manager.security.manage.group.service;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;


public interface GroupsManageService
{
    
    public List<UserInfo> getWholeUserInfo(UserInfo userInfo) throws Exception;
    
    public int updateGroupsInfo(UserInfo userInfo) throws Exception;
}
