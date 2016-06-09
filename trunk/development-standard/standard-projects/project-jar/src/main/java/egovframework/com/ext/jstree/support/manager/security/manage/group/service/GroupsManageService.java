package egovframework.com.ext.jstree.support.manager.security.manage.group.service;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.security.roles.vo.SecuredObject;


public interface GroupsManageService
{
    
    public List<SecuredObject> getGroupsInfo(SecuredObject securedObject) throws Exception;
    
    public SecuredObject insertGroupsInfo(SecuredObject securedObject) throws Exception;
    
    public int updateGroupsInfo(SecuredObject securedObject) throws Exception;
    
    public int deleteGroupsInfo(SecuredObject securedObject) throws Exception;
}
