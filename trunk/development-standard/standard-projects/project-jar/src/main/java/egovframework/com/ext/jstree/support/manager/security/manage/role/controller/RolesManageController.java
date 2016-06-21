package egovframework.com.ext.jstree.support.manager.security.manage.role.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.RolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.RolesManageVo;

@Controller
@RequestMapping(value = "/rest/admin/manage/roles")
public class RolesManageController extends GenericAbstractController
{
    @Resource(name = "rolesManageService")
    private RolesManageService rolesManageService;
    
    @ResponseBody
    @RequestMapping(value = "/getRolesInfo", method = RequestMethod.GET)
    public List<RolesManageVo> getRolesInfo(@Validated RolesManageVo rolesManageVo, BindingResult bindingResult)
            throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return rolesManageService.getRolesInfo(rolesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/getRoleInfo", method = RequestMethod.GET)
    public RolesManageVo getRoleInfo(@Validated RolesManageVo rolesManageVo, BindingResult bindingResult)
            throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return rolesManageService.getRoleInfo(rolesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/insertRoleInfo", method = RequestMethod.POST)
    public RolesManageVo insertRolesInfo(@Validated RolesManageVo rolesManageVo, BindingResult bindingResult)
            throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return rolesManageService.insertRolesInfo(rolesManageVo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/updateRoleInfo", method = RequestMethod.POST)
    public RolesManageVo updateRoleInfo(@Validated RolesManageVo rolesManageVo, BindingResult bindingResult)
            throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        rolesManageService.updateRolesInfo(rolesManageVo);
        
        return returnValue();
    }
    
    @ResponseBody
    @RequestMapping(value = "/deleteRoleInfo", method = RequestMethod.POST)
    public RolesManageVo deleteRolesInfo(@Validated RolesManageVo rolesManageVo, BindingResult bindingResult)
            throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        rolesManageService.deleteRolesInfo(rolesManageVo);
        
        return returnValue();
    }
    
    @ResponseBody
    @RequestMapping(value = "/getRoleInResoures", method = RequestMethod.GET)
    public List<ResourcesManageVo> getRoleInResoures(@Validated ResourcesManageVo resourcesManageVo,
            BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return rolesManageService.getRoleInResoures(resourcesManageVo);
    }
    
    private RolesManageVo returnValue(){
        RolesManageVo result = new RolesManageVo();
        result.setStatus(1);
        return result;
    }
    
}
