package egovframework.com.ext.jstree.support.manager.security.login.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.security.login.dao.UserInfoDao;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserRole;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService
{
    
    @Autowired
    UserInfoDao userInfoDao;
    
    @Resource(name = "CoreService")
    CoreService coreService;
    
    @Override
    public void updateUserInfo(UserInfo userInfo) throws Exception
    {
        coreService.alterNode(userInfo);
    }
    
    @Override
    public UserRole getUserRole(UserInfo userInfo) throws Exception
    {
        UserRole role = new UserRole();
        role.setEmail(userInfo.getC_id());
        return userInfoDao.getUserRole(role);
    }
}
