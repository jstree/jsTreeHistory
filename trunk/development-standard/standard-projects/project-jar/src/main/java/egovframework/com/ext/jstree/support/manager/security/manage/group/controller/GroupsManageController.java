package egovframework.com.ext.jstree.support.manager.security.manage.group.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.security.login.service.UserInfoService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserRole;
import egovframework.com.ext.jstree.support.manager.security.manage.group.service.GroupsManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.RolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.RolesManageVo;

@Controller
@RequestMapping(value = "/rest/admin/manage/groups")
public class GroupsManageController extends GenericAbstractController
{
    @Resource(name = "groupsManageService")
    private GroupsManageService groupsManageService;
    
    @Autowired
    private UserInfoService userInfoService;
    
    @Resource(name = "rolesManageService")
    private RolesManageService rolesManageService;
    
    @ResponseBody
    @RequestMapping(value = "/getGroupsInfo", method = RequestMethod.GET)
    public Map<String, Object> getUserRoleInfo(@Validated ComprehensiveTree comprehensiveTree,
            BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        Map<String, Object> resultMap = new HashMap<String, Object>();
        RolesManageVo rolesManageVo = new RolesManageVo();
        UserInfo userInfo = new UserInfo();
        userInfo.setC_id(comprehensiveTree.getC_id());
        rolesManageVo.setC_id(comprehensiveTree.getC_id());
        
        resultMap.put("wholeUserInfo", groupsManageService.getWholeUserInfo(userInfo));
        resultMap.put("RolesInfo", rolesManageService.getRolesInfo(rolesManageVo));
        
        return resultMap;
    }
    
    @ResponseBody
    @RequestMapping(value = "/updateGroupsInfo", method = RequestMethod.POST)
    public UserRole updateGroupsInfo(@Validated UserInfo userInfo, BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return returnValue(groupsManageService.updateGroupsInfo(userInfo));
    }
    
    @ResponseBody
    @RequestMapping(value = "/insertGroupsInfo", method = RequestMethod.POST)
    public UserRole insertGroupsInfo(@Validated UserInfo userInfo, BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return returnValue(groupsManageService.updateGroupsInfo(userInfo));
    }
    
    @ResponseBody
    @RequestMapping(value = "/deleteGroupsInfo", method = RequestMethod.POST)
    public UserRole deleteGroupsInfo(@Validated UserInfo userInfo, BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return returnValue(groupsManageService.updateGroupsInfo(userInfo));
    }
    
    private UserRole returnValue(int resultCount){
        UserRole result = new UserRole();
        result.setStatus(resultCount);
        return result;
    }
}
