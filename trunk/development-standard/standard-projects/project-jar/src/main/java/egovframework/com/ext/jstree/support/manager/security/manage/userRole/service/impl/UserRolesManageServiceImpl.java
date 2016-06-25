package egovframework.com.ext.jstree.support.manager.security.manage.userRole.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.security.interceptor.CustomFilterInvocationSecurityMetadataSource;
import egovframework.com.ext.jstree.support.manager.security.login.service.UserInfoService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;
import egovframework.com.ext.jstree.support.manager.security.manage.userRole.service.UserRolesManageService;

@Service(value = "userRolesManageService")
public class UserRolesManageServiceImpl implements UserRolesManageService
{
    
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Autowired
    private UserInfoService userInfoService;
    
    @Autowired
    private CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
    
    @Override
    public List<UserInfo> getWholeUserInfo(UserInfo userInfo) throws Exception
    {
        return userInfoService.getWholeUserInfo(userInfo);
    }
    
    public int updateUserRolesInfo(UserInfo userInfo) throws Exception
    {
        userInfo.join();
        UserInfo user = userInfoService.getUserInfo(userInfo);
        user.setRoles(userInfo.getRoles());
        int result = userInfoService.updateGroupsInfo(user);
        
        customFilterInvocationSecurityMetadataSource.reload();
        return result;
    }
}
