package egovframework.com.ext.jstree.support.manager.security.manage.group.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.security.login.service.UserInfoService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserRole;
import egovframework.com.ext.jstree.support.manager.security.manage.group.service.GroupsManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.RolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.RolesManageVo;

@Controller
public class GroupsManageController extends GenericAbstractController
{
    @Resource(name = "groupsManageService")
    GroupsManageService groupsManageService;
    
    @Autowired
    UserInfoService userInfoService;
    
    @Resource(name = "rolesManageService")
    RolesManageService rolesManageService;
    
    public Map<String, Object> getUserRoleInfo(ModelMap map) throws Exception
    {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        RolesManageVo securedObject = new RolesManageVo();
        resultMap.put("userRoleInfo", userInfoService.getUserRoleInfo());
        resultMap.put("roleInfo",rolesManageService.getRolesInfo(securedObject));
        
        return resultMap;
    }
    
    
    
    public UserRole mergeGroupsInfo(UserRole userRole) throws Exception
    {
        groupsManageService.mergeGroupsInfo(userRole);
        UserRole result = new UserRole();
        result.setStatus(1);
        return result;
    }
}
