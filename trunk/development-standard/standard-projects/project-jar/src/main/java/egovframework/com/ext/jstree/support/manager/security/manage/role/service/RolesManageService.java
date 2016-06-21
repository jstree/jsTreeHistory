package egovframework.com.ext.jstree.support.manager.security.manage.role.service;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.RolesManageVo;


public interface RolesManageService
{
 
    public List<RolesManageVo> getRolesInfo(RolesManageVo rolesManageVo) throws Exception;
    
    public RolesManageVo getRoleInfo(RolesManageVo rolesManageVo) throws Exception;
    
    public RolesManageVo insertRolesInfo(RolesManageVo rolesManageVo) throws Exception;
    
    public int updateRolesInfo(RolesManageVo rolesManageVo) throws Exception;
    
    public int deleteRolesInfo(RolesManageVo rolesManageVo) throws Exception;
    
    public List<ResourcesManageVo> getRoleInResoures(ResourcesManageVo resourcesManageVo) throws Exception;

}
