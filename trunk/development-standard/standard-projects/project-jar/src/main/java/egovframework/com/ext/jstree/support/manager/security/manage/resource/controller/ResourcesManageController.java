package egovframework.com.ext.jstree.support.manager.security.manage.resource.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.service.ResourcesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;

@Controller
@RequestMapping(value = "/rest/admin/manage/resources")
public class ResourcesManageController extends GenericAbstractController
{
    
    @Resource(name = "resourcesManageService")
    private ResourcesManageService resourceManageService;
    
    @ResponseBody
    @RequestMapping(value = "/getResourcesInfo", method = RequestMethod.GET)
    public List<ResourcesManageVo> getResourcesInfo(@Validated ResourcesManageVo resourcesManageVo,
            BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return resourceManageService.getResourcesInfo(resourcesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/getResourceInfo", method = RequestMethod.GET)
    public ResourcesManageVo getResourceInfo(@Validated ResourcesManageVo resourcesManageVo,
            BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return resourceManageService.getResourceInfo(resourcesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/insertResourcesInfo", method = RequestMethod.POST)
    public ResourcesManageVo insertResourcesInfo(@Validated ResourcesManageVo resourcesManageVo,
            BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return resourceManageService.insertResourcesInfo(resourcesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/updateResourcesInfo", method = RequestMethod.POST)
    public ResourcesManageVo updateResourcesInfo(@Validated ResourcesManageVo resourcesManageVo,
            BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return returnValue(resourceManageService.updateResourcesInfo(resourcesManageVo));
    }
    
    @ResponseBody
    @RequestMapping(value = "/deleteResourcesInfo", method = RequestMethod.POST)
    public ResourcesManageVo deleteResourcesInfo(@Validated ResourcesManageVo resourcesManageVo,
            BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return returnValue(resourceManageService.deleteResourcesInfo(resourcesManageVo));
    }
    
    private ResourcesManageVo returnValue(int resultCount){
        ResourcesManageVo result = new ResourcesManageVo();
        result.setStatus(resultCount);
        return result;
    }
}
