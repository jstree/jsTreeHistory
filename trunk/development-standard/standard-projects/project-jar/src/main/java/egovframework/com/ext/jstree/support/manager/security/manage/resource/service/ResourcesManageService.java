package egovframework.com.ext.jstree.support.manager.security.manage.resource.service;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;

public interface ResourcesManageService
{
    public List<ResourcesManageVo> getResourcesInfo(ResourcesManageVo resourcesManageVo) throws Exception;
    
    public ResourcesManageVo getResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception;
    
    public ResourcesManageVo insertResourcesInfo(ResourcesManageVo resourcesManageVo) throws Exception;
    
    public int updateResourcesInfo(ResourcesManageVo resourcesManageVo) throws Exception;
    
    public int deleteResourcesInfo(ResourcesManageVo resourcesManageVo) throws Exception;
    
    public List<ResourcesManageVo> getRoleInResoures(ResourcesManageVo resourcesManageVo) throws Exception;
}
