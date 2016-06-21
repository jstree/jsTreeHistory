package egovframework.com.ext.jstree.support.manager.security.manage.resource.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.aop.util.DateUtils;
import egovframework.com.ext.jstree.support.manager.security.interceptor.CustomFilterInvocationSecurityMetadataSource;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.dao.ResourcesManageDao;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.service.ResourcesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;

@Service(value="resourcesManageService")
public class ResourcesManageServiceImpl implements ResourcesManageService
{
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Resource(name = "resourcesManageDao")
    private ResourcesManageDao resourcesManageDao;
    
    @Autowired
    private CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
    
    public List<ResourcesManageVo> getResourcesInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        return coreService.getChildNode(resourcesManageVo);
    }
    
    public ResourcesManageVo getResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        return coreService.getNode(resourcesManageVo);
    }
    
    public ResourcesManageVo insertResourcesInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        resourcesManageVo.setRegDt(DateUtils.dateToString("yyyyMMddHHmmss", new Date()));
        resourcesManageVo.setModDt(" ");
        resourcesManageVo.setModId(" ");
        ResourcesManageVo result = coreService.addNode(resourcesManageVo);
        customFilterInvocationSecurityMetadataSource.reload();
        return result;
    }
    
    public int updateResourcesInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        resourcesManageVo.setModDt(DateUtils.dateToString("yyyyMMddHHmmss", new Date()));
        int result = coreService.alterNode(resourcesManageVo); 
        return result;
    }
    
    public int deleteResourcesInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        int result = coreService.removeNode(resourcesManageVo); 
        return result;
    }
    
    public List<ResourcesManageVo> getRoleInResoures(ResourcesManageVo resourcesManageVo)
            throws Exception
    {
        return resourcesManageDao.getRoleInResoures(resourcesManageVo);
    }
}
