package egovframework.com.ext.jstree.support.manager.security.manage.role.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import edu.emory.mathcs.backport.java.util.Arrays;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.aop.util.DateUtils;
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.RolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.RolesManageVo;

@Service(value = "rolesManageService")
public class RolesManageServiceImpl implements RolesManageService
{
    
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Override
    public List<RolesManageVo> getRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        List<RolesManageVo> list = coreService.getChildNode(rolesManageVo);
        for (RolesManageVo vo : list)
        {
            if (CollectionUtils.isNotEmpty(vo.getResources()))
            {
                vo.setResources(Arrays.asList(StringUtils.split(vo.getResourcesStr(), ",")));
            }
        }
        return list;
    }
    
    @Override
    public RolesManageVo getRolesInfoDetail(RolesManageVo rolesManageVo) throws Exception
    {
        RolesManageVo vo = coreService.getNode(rolesManageVo);
        if (CollectionUtils.isNotEmpty(vo.getResources()))
        {
            vo.setResources(Arrays.asList(StringUtils.split(vo.getResourcesStr(), ",")));
        }
        return vo;
    }
    
    @Override
    public RolesManageVo insertRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        rolesManageVo.setRegDt(DateUtils.dateToString("yyyyMMddHHmmss", new Date()));
        rolesManageVo.setModDt(" ");
        rolesManageVo.setModId(" ");
        rolesManageVo.setResourcesStr(StringUtils.join(rolesManageVo.getResources(), ","));
        return coreService.addNode(rolesManageVo);
    }
    
    @Override
    public int updateRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        rolesManageVo.setModDt(DateUtils.dateToString("yyyyMMddHHmmss", new Date()));
        rolesManageVo.setResourcesStr(StringUtils.join(rolesManageVo.getResources(), ","));
        return coreService.alterNode(rolesManageVo);
    }
    
    @Override
    public int deleteRolesInfo(RolesManageVo rolesManageVo) throws Exception
    {
        return coreService.removeNode(rolesManageVo);
    }
    
}
