package egovframework.com.ext.jstree.support.manager.security.manage.role.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.ext.jstree.support.manager.security.manage.resource.service.ResourcesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.ResourcesRolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.RolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.ResourcesRolesManageVo;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.RolesManageVo;

@Controller
public class RolesManageController
{
    @Resource(name = "rolesManageService")
    private RolesManageService rolesManageService;
    
    @Resource(name = "resourcesRolesManageService")
    private ResourcesRolesManageService resourcesRolesManageService;
    
    @Resource(name = "resourcesManageService")
    ResourcesManageService resourcesManageService;
    
    @ResponseBody
    @RequestMapping(value = "/getRolesInfo", method = RequestMethod.GET)
    public List<RolesManageVo> getRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        return rolesManageService.getRolesInfo(rolesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/getRolesInfoDetail", method = RequestMethod.GET)
    public RolesManageVo getRolesInfoDetail(RolesManageVo rolesManageVo) throws Exception
    {
        return rolesManageService.getRolesInfoDetail(rolesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/insertRolesInfo", method = RequestMethod.POST)
    public RolesManageVo insertRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        return rolesManageService.insertRolesInfo(rolesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/updateRolesInfo", method = RequestMethod.POST)
    public int updateRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        return rolesManageService.updateRolesInfo(rolesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/deleteRolesInfo", method = RequestMethod.POST)
    public int deleteRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        rolesManageVo.setSqlMapSelector("roles");
        return rolesManageService.deleteRolesInfo(rolesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/getRoleInResoures", method = RequestMethod.GET)
    public List<ResourcesManageVo> getRoleInResoures(ResourcesManageVo resourcesManageVo)
            throws Exception
    {
        return resourcesManageService.getRoleInResoures(resourcesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/updateRoleInResources", method = RequestMethod.GET)
    public ResourcesRolesManageVo updateRoleInResources(List<ResourcesRolesManageVo> resourcesRolesManageList) throws Exception
    {
        resourcesRolesManageService.updateRoleInResources(resourcesRolesManageList);
        ResourcesRolesManageVo resourcesRolesManageVo = new ResourcesRolesManageVo();
        resourcesRolesManageVo.setStatus(1);
        return resourcesRolesManageVo;
    }
}
