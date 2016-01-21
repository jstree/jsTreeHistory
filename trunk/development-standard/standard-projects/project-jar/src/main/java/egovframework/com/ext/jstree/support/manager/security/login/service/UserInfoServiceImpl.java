package egovframework.com.ext.jstree.support.manager.security.login.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.security.login.dao.SecureUserDao;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUser;

@Service
public class UserInfoServiceImpl implements UserInfoService
{

    @Autowired
    SecureUserDao secureUserLoginDao;

    @Resource(name="CoreService")
    CoreService coreService;
    @Override
    public void updateUserInfo(SecureUser secureUserLogin) throws Exception
    {
        coreService.alterNode(secureUserLogin);
    }
}
