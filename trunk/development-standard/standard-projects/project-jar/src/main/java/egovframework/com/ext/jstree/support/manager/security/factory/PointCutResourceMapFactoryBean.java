package egovframework.com.ext.jstree.support.manager.security.factory;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

import egovframework.com.ext.jstree.support.manager.security.roles.service.SecuredObjectService;

public class PointCutResourceMapFactoryBean implements FactoryBean<LinkedHashMap<String, List<ConfigAttribute>>>
{
    
    @Resource(name="pointcutResourceMapService")
    SecuredObjectService<String, List<ConfigAttribute>> pointcutResourceMapService;
    
    private LinkedHashMap<String, List<ConfigAttribute>> resultMap;
    
    
    @Override
    public LinkedHashMap<String, List<ConfigAttribute>> getObject() throws Exception
    {
        if(resultMap == null){
            init();
        }
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
        resultMap = pointcutResourceMapService.getResourceMap();
    }
    
}
