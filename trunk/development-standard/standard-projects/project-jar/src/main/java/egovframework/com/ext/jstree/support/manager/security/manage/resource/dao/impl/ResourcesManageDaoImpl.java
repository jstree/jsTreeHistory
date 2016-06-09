package egovframework.com.ext.jstree.support.manager.security.manage.resource.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.ext.jstree.support.manager.security.manage.resource.dao.ResourcesManageDao;
import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository(value="resourcesManageDao")
public class ResourcesManageDaoImpl extends EgovAbstractDAO implements ResourcesManageDao
{
    @Override
    public List<ResourcesManageVo> getRoleInResoures(ResourcesManageVo resourcesManageVo) throws Exception
    {
        return list("resources.getRoleInResoures", resourcesManageVo);
    }
}
