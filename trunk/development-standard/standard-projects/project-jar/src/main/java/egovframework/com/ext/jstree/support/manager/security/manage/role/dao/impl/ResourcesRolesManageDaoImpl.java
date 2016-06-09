package egovframework.com.ext.jstree.support.manager.security.manage.role.dao.impl;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.support.manager.security.manage.role.dao.ResourcesRolesManageDao;
import egovframework.com.ext.jstree.support.manager.security.manage.role.vo.ResourcesRolesManageVo;

@Repository(value="resourcesRolesManageDao")
public class ResourcesRolesManageDaoImpl extends EgovComAbstractDAO implements ResourcesRolesManageDao
{

    @Override
    public ResourcesRolesManageVo getNodeByRoleId(ResourcesRolesManageVo resourcesRolesManageVo) throws Exception
    {
        return (ResourcesRolesManageVo) selectByPk("rolesResources.getNodeByRoleId", resourcesRolesManageVo);
    }


    
}
