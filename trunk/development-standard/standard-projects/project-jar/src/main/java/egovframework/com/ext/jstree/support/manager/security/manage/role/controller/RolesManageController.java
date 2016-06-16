package egovframework.com.ext.jstree.support.manager.security.manage.role.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.service.ResourcesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.RolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.RolesManageVo;

@Controller
public class RolesManageController extends GenericAbstractController
{
    @Resource(name = "rolesManageService")
    private RolesManageService rolesManageService;
    
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
    public RolesManageVo updateRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        rolesManageService.updateRolesInfo(rolesManageVo);
        
        RolesManageVo result = new RolesManageVo();
        result.setStatus(1);
        return result;
    }
    
    @ResponseBody
    @RequestMapping(value = "/deleteRolesInfo", method = RequestMethod.POST)
    public RolesManageVo deleteRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        rolesManageService.deleteRolesInfo(rolesManageVo);

        RolesManageVo result = new RolesManageVo();
        result.setStatus(1);
        return result;
    }
    
    @ResponseBody
    @RequestMapping(value = "/getRoleInResoures", method = RequestMethod.GET)
    public List<ResourcesManageVo> getRoleInResoures(ResourcesManageVo resourcesManageVo)
            throws Exception
    {
        return resourcesManageService.getRoleInResoures(resourcesManageVo);
    }
    
}
