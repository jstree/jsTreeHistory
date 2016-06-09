package egovframework.com.ext.jstree.support.manager.security.manage.group.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.aop.util.DateUtils;
import egovframework.com.ext.jstree.support.manager.security.manage.group.service.GroupsManageService;
import egovframework.com.ext.jstree.support.manager.security.roles.vo.SecuredObject;

@Service(value="groupsManageService")
public class GroupsManageServiceImpl implements GroupsManageService
{
 
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Override
    public List<SecuredObject> getGroupsInfo(SecuredObject securedObject) throws Exception
    {
        return coreService.getChildNode(securedObject);
    }

    @Override
    public SecuredObject insertGroupsInfo(SecuredObject securedObject) throws Exception
    {
        securedObject.setRegDt(DateUtils.dateToString("yyyyMMddHHmmss", new Date()));
        securedObject.setModDt(" ");
        securedObject.setModId(" ");
        return coreService.addNode(securedObject);
    }

    @Override
    public int updateGroupsInfo(SecuredObject securedObject) throws Exception
    {
        securedObject.setModDt(DateUtils.dateToString("yyyyMMddHHmmss", new Date()));
        return coreService.alterNode(securedObject);
    }

    @Override
    public int deleteGroupsInfo(SecuredObject securedObject) throws Exception
    {
        return coreService.removeNode(securedObject);
    }
}
