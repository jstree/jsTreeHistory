package egovframework.com.ext.jstree.support.manager.security.roles.service.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

import egovframework.com.ext.jstree.support.manager.security.manage.resource.service.ResourcesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.RolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.RolesManageVo;
import egovframework.com.ext.jstree.support.manager.security.roles.dao.SecuredObjectDao;
import egovframework.com.ext.jstree.support.manager.security.roles.service.SecuredObjectService;
import egovframework.com.ext.jstree.support.manager.security.roles.vo.SecuredObject;

public class PointCutResourceMapServiceImpl implements SecuredObjectService<String, List<ConfigAttribute>>
{
    
    @Resource(name = "rolesManageService")
    private RolesManageService rolesManageService;
    
    @Resource(name = "resourcesManageService")
    private ResourcesManageService resourcesManageService;
    
    public LinkedHashMap<String, List<ConfigAttribute>> getResourceMap() throws Exception
    {
        LinkedHashMap<String, List<ConfigAttribute>> resultMap = new LinkedHashMap<String, List<ConfigAttribute>>();
        
        ResourcesManageVo resourcesVo = new ResourcesManageVo();
        resourcesVo.setC_id(2);
        List<ResourcesManageVo> resources = resourcesManageService.getResourceInfo(resourcesVo);
        
        RolesManageVo rolesVo = new RolesManageVo();
        rolesVo.setC_id(2);
        List<RolesManageVo> roles = rolesManageService.getRolesInfo(rolesVo);
        
        for (ResourcesManageVo resource : resources)
        {
            if (resource.getResourceType().equals("POINTCUT"))
            {
                List<ConfigAttribute> configList = new LinkedList<ConfigAttribute>();
                for (RolesManageVo role : roles)
                {
                    List<String> list = role.getResources();
                    if (list.contains(Integer.toString(resource.getC_id())))
                    {
                        configList.add(new SecurityConfig(role.getAuthority()));
                    }
                }
                if (CollectionUtils.isNotEmpty(configList))
                {
                    resultMap.put(resource.getPattern(), configList);
                }
            }
        }
        return resultMap;
    }
    
}
