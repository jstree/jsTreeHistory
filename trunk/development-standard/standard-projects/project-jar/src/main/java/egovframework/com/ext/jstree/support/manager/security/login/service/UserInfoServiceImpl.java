package egovframework.com.ext.jstree.support.manager.security.login.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.mail.service.SndngMailService;
import egovframework.com.ext.jstree.support.manager.security.login.dao.UserInfoDao;
import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService
{
    @Autowired
    UserInfoDao userInfoDao;
    
    @Resource(name = "CoreService")
    CoreService coreService;
    
    @Autowired
    SndngMailService sndngMailService;
    
    @Override
    public UserInfo insertUserInfo(UserInfo userInfo) throws Exception
    {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
        userInfo.setPassword(encoder.encodePassword(userInfo.getPassword(), "313"));
        String uuid = UUID.randomUUID().toString().replace("-", "");
        userInfo.setUuid(uuid);
        userInfo.setRef(2);
        userInfo.setC_type("default");
        userInfo.setC_title("사용자");
        userInfo.setUseYN("N");
        // sndngMailService.sendEmail(userInfo);
        return coreService.addNode(userInfo);
    }
    
    @Override
    public void updateUserInfo(UserInfo userInfo) throws Exception
    {
        coreService.alterNode(userInfo);
    }
    
    @Override
    public String updatePassword(UserInfo userInfo) throws Exception
    {
        String status = "";
        UserInfo rtnUserInfo = userInfoDao.loadUserByUsername(userInfo);
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
        userInfo.setOldPassword(encoder.encodePassword(userInfo.getOldPassword(), "313"));
        if ((userInfo.getOldPassword()).equals(rtnUserInfo.getPassword()) && rtnUserInfo.getPassword() != null)
        {
            userInfo.setNewPassword(encoder.encodePassword(userInfo.getNewPassword(), "313"));
            userInfoDao.updatePassword(userInfo);
            status = "{ \"status\" : \"1\" }";
        }
        else
        {
            status = "{ \"status\" : \"0\" }";
        }
        return status;
    }
    
    @Override
    public UserInfo getUserByUuid(UserInfo userInfo) throws Exception
    {
        return userInfoDao.getUserByUuid(userInfo);
    }
    
    @Override
    public void updateUseYnByUuid(UserInfo userInfo) throws Exception
    {
        userInfoDao.updateUseYnByUuid(userInfo);
    }
    
    public int updateGroupsInfo(UserInfo userInfo) throws Exception
    {
        UserInfo vo = coreService.getNode(userInfo);
        vo.setRoles(userInfo.getRoles());
        return coreService.alterNode(vo);
    }
    
    public List<UserInfo> getChildNode(UserInfo userInfo) throws Exception
    {
        return coreService.getChildNode(userInfo);
    }
}
