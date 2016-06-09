package egovframework.com.ext.jstree.support.manager.security.manage.role.service;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.ResourcesRolesManageVo;


public interface ResourcesRolesManageService
{
	public int updateRoleInResources (List<ResourcesRolesManageVo> resourcesRolesManageList) throws Exception;
    
}
