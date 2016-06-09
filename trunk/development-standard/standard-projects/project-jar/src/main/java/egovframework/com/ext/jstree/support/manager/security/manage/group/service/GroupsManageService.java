package egovframework.com.ext.jstree.support.manager.security.manage.group.service;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.security.login.vo.UserRole;
import egovframework.com.ext.jstree.support.manager.security.roles.vo.SecuredObject;


public interface GroupsManageService
{
    
    public List<UserRole> getGroupsInfo(UserRole userRole) throws Exception;
    
    public int deleteGroupsInfo(UserRole userRole) throws Exception;
    
    public int mergeGroupsInfo(UserRole userRole) throws Exception;
}
