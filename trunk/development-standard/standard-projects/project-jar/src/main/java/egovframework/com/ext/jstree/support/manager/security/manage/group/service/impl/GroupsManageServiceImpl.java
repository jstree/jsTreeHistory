package egovframework.com.ext.jstree.support.manager.security.manage.group.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.security.login.service.UserInfoService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserRole;
import egovframework.com.ext.jstree.support.manager.security.manage.group.service.GroupsManageService;

@Service(value = "groupsManageService")
public class GroupsManageServiceImpl implements GroupsManageService
{
    
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Autowired
    UserInfoService userInfoService;
    
    @Override
    public List<UserInfo> getGroupsInfo(UserInfo userInfo) throws Exception
    {
        return userInfoService.getChildNode(userInfo);
    }
    
    public int updateGroupsInfo(UserInfo userInfo) throws Exception
    {
        List<UserRole> roleList = (List<UserRole>) userInfo.getAuthorities();
        List<String> result = new ArrayList<String>();
        for (UserRole userRole : roleList)
        {
            result.add(userRole.getRole());
        }
        userInfo.setRoles(StringUtils.join(result, ","));
        userInfoService.updateGroupsInfo(userInfo);
        return 1;
    }
}
