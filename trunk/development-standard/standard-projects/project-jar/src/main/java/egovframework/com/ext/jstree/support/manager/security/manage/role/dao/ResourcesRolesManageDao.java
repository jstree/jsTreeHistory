package egovframework.com.ext.jstree.support.manager.security.manage.role.dao;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.ResourcesRolesManageVo;

public interface ResourcesRolesManageDao
{
    public ResourcesRolesManageVo getNodeByRoleId(ResourcesRolesManageVo resourcesRolesManageVo) throws Exception;
}
