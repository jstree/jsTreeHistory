package egovframework.com.ext.jstree.support.manager.security.factory;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

import egovframework.com.ext.jstree.support.manager.security.roles.service.SecuredObjectService;

public class UrlResourceMapFactoryBean implements FactoryBean<LinkedHashMap<RequestMatcher, List<ConfigAttribute>>>
{
    
    @Resource
    SecuredObjectService securedObjectService;
    
    private LinkedHashMap<RequestMatcher, List<ConfigAttribute>> resultMap;
    
    
    @Override
    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getObject() throws Exception
    {
        if(resultMap == null){
            init();
        }
        
        System.out.println("_______________________________"+resultMap);
        return resultMap;
    }
    
    @Override
    public Class<?> getObjectType()
    {
        return LinkedHashMap.class;
    }
    
    @Override
    public boolean isSingleton()
    {
        return true;
    }
    
    public void init() throws Exception
    {
    	System.out.println("_--------------------------------------------_");
        resultMap = securedObjectService.getRolesAndUrl();
        
    }
    
}
