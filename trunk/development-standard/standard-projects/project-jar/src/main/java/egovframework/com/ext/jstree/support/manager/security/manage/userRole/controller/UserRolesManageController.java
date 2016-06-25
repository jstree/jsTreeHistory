package egovframework.com.ext.jstree.support.manager.security.manage.userRole.controller;

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
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.RolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.RolesManageVo;
import egovframework.com.ext.jstree.support.manager.security.manage.userRole.service.UserRolesManageService;

@Controller
@RequestMapping(value = "/rest/admin/manage/userrole")
public class UserRolesManageController extends GenericAbstractController
{
    @Resource(name = "userRolesManageService")
    private UserRolesManageService userRolesManageService;
    
    @Autowired
    private UserInfoService userInfoService;
    
    @Resource(name = "rolesManageService")
    private RolesManageService rolesManageService;
    
    @ResponseBody
    @RequestMapping(value = "/getUserRolesInfo", method = RequestMethod.GET)
    public Map<String, Object> getUserRolesInfo(@Validated ComprehensiveTree comprehensiveTree,
            BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        Map<String, Object> resultMap = new HashMap<String, Object>();
        RolesManageVo rolesManageVo = new RolesManageVo();
        UserInfo userInfo = new UserInfo();
        userInfo.setC_id(comprehensiveTree.getC_id());
        rolesManageVo.setC_id(comprehensiveTree.getC_id());
        
        resultMap.put("wholeUserInfo", userRolesManageService.getWholeUserInfo(userInfo));
        resultMap.put("RolesInfo", rolesManageService.getRolesInfo(rolesManageVo));
        
        return resultMap;
    }
    
    @ResponseBody
    @RequestMapping(value = "/updateUserRolesInfo", method = RequestMethod.POST)
    public UserRole updateUserRolesInfo(@Validated UserInfo userInfo, BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return returnValue(userRolesManageService.updateUserRolesInfo(userInfo));
    }
    
    @ResponseBody
    @RequestMapping(value = "/insertUserRolesInfo", method = RequestMethod.POST)
    public UserRole insertUserRolesInfo(@Validated UserInfo userInfo, BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return returnValue(userRolesManageService.updateUserRolesInfo(userInfo));
    }
    
    @ResponseBody
    @RequestMapping(value = "/deleteUserRolesInfo", method = RequestMethod.POST)
    public UserRole deleteUserRolesInfo(@Validated UserInfo userInfo, BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) throw new RuntimeException();
        
        return returnValue(userRolesManageService.updateUserRolesInfo(userInfo));
    }
    
    private UserRole returnValue(int resultCount){
        UserRole result = new UserRole();
        result.setStatus(resultCount);
        return result;
    }
}
