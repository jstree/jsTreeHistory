package egovframework.com.ext.jstree.support.manager.security.manage.group.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.security.login.service.UserInfoService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;
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
    
    @ResponseBody
    @RequestMapping(value="/getResourceInfo", method=RequestMethod.GET)
    public Map<String, Object> getUserRoleInfo(ModelMap map) throws Exception
    {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        RolesManageVo securedObject = new RolesManageVo();
        UserInfo userInfo = new UserInfo();
        userInfo.setC_id(2);
        resultMap.put("userRoleInfo", userInfoService.getChildNode(userInfo));
        resultMap.put("roleInfo",rolesManageService.getRolesInfo(securedObject));
        
        return resultMap;
    }
    
    @ResponseBody
    @RequestMapping(value="/updateGroupsInfo", method=RequestMethod.POST)
    public UserRole mergeGroupsInfo(UserInfo userInfo) throws Exception
    {
        groupsManageService.updateGroupsInfo(userInfo);
        UserRole result = new UserRole();
        result.setStatus(1);
        return result;
    }
}
