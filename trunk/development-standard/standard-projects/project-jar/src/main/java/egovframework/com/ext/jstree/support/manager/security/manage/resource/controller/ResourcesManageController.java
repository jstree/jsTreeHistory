package egovframework.com.ext.jstree.support.manager.security.manage.resource.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.ext.jstree.support.manager.security.manage.resource.service.ResourcesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;

@Controller
@RequestMapping(value="/admin/manage/resource")
public class ResourcesManageController
{
    
    @Resource(name="resourcesManageService")
    private ResourcesManageService resourceManageService;
    
    
    @ResponseBody
    @RequestMapping(value="/getResourceInfo", method=RequestMethod.GET)
    public List<ResourcesManageVo> getResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        return resourceManageService.getResourceInfo(resourcesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value="/getResourceInfoDetail", method=RequestMethod.GET)
    public ResourcesManageVo getResourceInfoDetail(ResourcesManageVo resourcesManageVo) throws Exception
    {
        return resourceManageService.getResourceInfoDetail(resourcesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value="/insertResourceInfo", method=RequestMethod.POST)
    public ResourcesManageVo insertResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        return resourceManageService.insertResourceInfo(resourcesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value="/updateResourceInfo", method=RequestMethod.POST)
    public int updateResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        return resourceManageService.updateResourceInfo(resourcesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value="/deleteResourceInfo", method=RequestMethod.POST)
    public int deleteResourceInfo(ResourcesManageVo resourcesManageVo) throws Exception
    {
        return resourceManageService.deleteResourceInfo(resourcesManageVo);
    }
}
