package egovframework.com.ext.jstree.support.manager.security.manage.role.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.aop.util.DateUtils;
import egovframework.com.ext.jstree.support.manager.security.interceptor.CustomFilterInvocationSecurityMetadataSource;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.service.ResourcesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.RolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.RolesManageVo;

@Service(value = "rolesManageService")
public class RolesManageServiceImpl implements RolesManageService
{
    
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Resource(name = "resourcesManageService")
    ResourcesManageService resourcesManageService;
    
    @Autowired
    private CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
    
    @Override
    public List<RolesManageVo> getRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        List<RolesManageVo> list = coreService.getChildNode(rolesManageVo);
        for (RolesManageVo vo : list)
        {
            vo.split();
        }
        return list;
    }
    
    @Override
    public RolesManageVo getRoleInfo(RolesManageVo rolesManageVo) throws Exception
    {
        RolesManageVo vo = coreService.getNode(rolesManageVo);
        vo.split();
        return vo;
    }
    
    @Override
    public RolesManageVo insertRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        rolesManageVo.setRegDt(DateUtils.dateToString("yyyyMMddHHmmss", new Date()));
        rolesManageVo.setModDt(" ");
        rolesManageVo.setModId(" ");
        rolesManageVo.join();
        RolesManageVo result = coreService.addNode(rolesManageVo);
        customFilterInvocationSecurityMetadataSource.reload();
        return result;
    }
    
    @Override
    public int updateRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        rolesManageVo.setModDt(DateUtils.dateToString("yyyyMMddHHmmss", new Date()));
        rolesManageVo.join();
        int result = coreService.alterNode(rolesManageVo);
        customFilterInvocationSecurityMetadataSource.reload();
        return result;
        
    }
    
    @Override
    public int deleteRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        int result = coreService.removeNode(rolesManageVo);
        customFilterInvocationSecurityMetadataSource.reload();
        return result;
    }

    @Override
    public List<ResourcesManageVo> getRoleInResoures(ResourcesManageVo resourcesManageVo) throws Exception
    {
        return resourcesManageService.getRoleInResoures(resourcesManageVo);
    }
    
}
