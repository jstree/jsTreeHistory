package egovframework.com.ext.jstree.support.manager.security.manage.role.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.dao.ResourcesRolesManageDao;
import egovframework.com.ext.jstree.support.manager.security.manage.role.service.ResourcesRolesManageService;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.ResourcesRolesManageVo;

@Service(value = "resourcesRolesManageService")
public class ResourcesRolesManageServiceImpl implements ResourcesRolesManageService
{
    
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Resource(name = "resourcesRolesManageDao")
    private ResourcesRolesManageDao resourcesRolesManageDao;
    
    @Override
    public int updateRoleInResources(List<ResourcesRolesManageVo> resourcesRolesManageList) throws Exception
    {
        for (ResourcesRolesManageVo resourcesRolesManageVo : resourcesRolesManageList)
        {
            ResourcesRolesManageVo resultVo = resourcesRolesManageDao.getNodeByRoleId(resourcesRolesManageVo);
            
            if (resultVo == null)
            {
                coreService.addNode(resourcesRolesManageVo);
            }
            else
            {
                resultVo.setResourcesId(resourcesRolesManageVo.getResourcesId());
                resultVo.setRolesId(resourcesRolesManageVo.getRolesId());
                coreService.alterNode(resourcesRolesManageVo);
            }
        }
        return 1;
    }
}
