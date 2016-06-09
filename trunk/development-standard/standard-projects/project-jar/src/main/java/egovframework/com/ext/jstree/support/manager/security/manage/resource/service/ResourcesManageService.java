package egovframework.com.ext.jstree.support.manager.security.manage.resource.service;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;

public interface ResourcesManageService
{
    public List<ResourcesManageVo> getResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception;
    
    public ResourcesManageVo getResourceInfoDetail(ResourcesManageVo resourcesManageVo) throws Exception;
    
    public ResourcesManageVo insertResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception;
    
    public int updateResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception;
    
    public int deleteResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception;
    
    public List<ResourcesManageVo> getRoleInResoures(ResourcesManageVo resourcesManageVo) throws Exception;
}
