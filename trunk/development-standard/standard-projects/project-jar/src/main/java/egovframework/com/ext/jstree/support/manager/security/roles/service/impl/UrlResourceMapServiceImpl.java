package egovframework.com.ext.jstree.support.manager.security.roles.service.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import egovframework.com.ext.jstree.support.manager.security.manage.resource.service.ResourcesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.RolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.RolesManageVo;
import egovframework.com.ext.jstree.support.manager.security.roles.service.SecuredObjectService;

public class UrlResourceMapServiceImpl implements SecuredObjectService<RequestMatcher, List<ConfigAttribute>>
{
    
    @Resource(name = "rolesManageService")
    private RolesManageService rolesManageService;
    
    @Resource(name = "resourcesManageService")
    private ResourcesManageService resourcesManageService;
    
    private String requestMatcherType;
    
    public void setRequestMatcherType(String requestMatcherType)
    {
        this.requestMatcherType = requestMatcherType;
    }
    
    public String getRequestMatcherType()
    {
        return requestMatcherType;
    }
    
    @Override
    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getResourceMap() throws Exception
    {
        LinkedHashMap<RequestMatcher, List<ConfigAttribute>> resultMap = new LinkedHashMap<RequestMatcher, List<ConfigAttribute>>();
        RequestMatcher requestMatcher = null;
        
        ResourcesManageVo resourcesVo = new ResourcesManageVo();
        resourcesVo.setC_id(2);
        List<ResourcesManageVo> resources = resourcesManageService.getResourcesInfo(resourcesVo);
        
        RolesManageVo rolesVo = new RolesManageVo();
        rolesVo.setC_id(2);
        List<RolesManageVo> roles = rolesManageService.getRolesInfo(rolesVo);

        for (ResourcesManageVo resource : resources)
        {
            if (resource.getResourceType().equals("URL"))
            {
                List<ConfigAttribute> configList = new LinkedList<ConfigAttribute>();
                for (RolesManageVo role : roles)
                {
                    List<String> resourceList = role.getResources();
                    if (CollectionUtils.isNotEmpty(resourceList) && resourceList.contains(Integer.toString(resource.getC_id())))
                    {
                        if (requestMatcherType.equalsIgnoreCase("regex"))
                        {
                            requestMatcher = new RegexRequestMatcher(resource.getPattern(), null, false);
                        }
                        else if (requestMatcherType.equalsIgnoreCase("ant"))
                        {
                            requestMatcher = new AntPathRequestMatcher(resource.getPattern());
                        }
                        configList.add(new SecurityConfig(role.getAuthority()));
                    }
                }
                if (CollectionUtils.isNotEmpty(configList))
                {
                    resultMap.put(requestMatcher, configList);
                }
            }
        }
        
        
        return resultMap;
    }
    
}
