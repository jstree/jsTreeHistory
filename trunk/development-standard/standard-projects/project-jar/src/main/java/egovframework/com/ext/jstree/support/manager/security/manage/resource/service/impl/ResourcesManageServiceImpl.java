package egovframework.com.ext.jstree.support.manager.security.manage.resource.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.aop.util.DateUtils;
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
    
    public List<ResourcesManageVo> getResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        return coreService.getChildNode(resourcesManageVo);
    }
    
    public ResourcesManageVo getResourceInfoDetail(ResourcesManageVo resourcesManageVo) throws Exception
    {
        return coreService.getNode(resourcesManageVo);
    }
    
    public ResourcesManageVo insertResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        resourcesManageVo.setRegDt(DateUtils.dateToString("yyyyMMddHHmmss", new Date()));
        resourcesManageVo.setModDt(" ");
        resourcesManageVo.setModId(" ");
        return coreService.addNode(resourcesManageVo);
    }
    
    public int updateResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        resourcesManageVo.setModDt(DateUtils.dateToString("yyyyMMddHHmmss", new Date()));
        return coreService.alterNode(resourcesManageVo);
    }
    
    public int deleteResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        return coreService.removeNode(resourcesManageVo);
    }
    
    public List<ResourcesManageVo> getRoleInResoures(ResourcesManageVo resourcesManageVo)
            throws Exception
    {
        return resourcesManageDao.getRoleInResoures(resourcesManageVo);
    }
}
