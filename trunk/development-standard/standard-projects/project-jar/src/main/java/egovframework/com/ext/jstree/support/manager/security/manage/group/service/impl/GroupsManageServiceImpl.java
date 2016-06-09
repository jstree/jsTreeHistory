package egovframework.com.ext.jstree.support.manager.security.manage.group.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.security.login.service.UserInfoService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserRole;
import egovframework.com.ext.jstree.support.manager.security.manage.group.service.GroupsManageService;

@Service(value="groupsManageService")
public class GroupsManageServiceImpl implements GroupsManageService
{
 
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Autowired
    UserInfoService userInfoService;
    
    @Override
    public List<UserRole> getGroupsInfo(UserRole userRole) throws Exception
    {
        return coreService.getChildNode(userRole);
    }

    @Override
    public int deleteGroupsInfo(UserRole userRole) throws Exception
    {
        return coreService.removeNode(userRole);
    }
    
    public int mergeGroupsInfo(UserRole userRole) throws Exception
    {
        UserInfo userInfo = new UserInfo();
        userInfo.setC_id(userRole.getEmail());
        UserRole resultVo = userInfoService.getUserRole(userInfo);
        if (resultVo == null)
        {
            coreService.addNode(userRole);
        }
        else
        {
            resultVo.setEmail(userRole.getEmail());
            resultVo.setRoleId(userRole.getRoleId());
            coreService.alterNode(resultVo);
        }
        return 1;
    }
}
