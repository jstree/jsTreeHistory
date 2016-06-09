package egovframework.com.ext.jstree.support.manager.security.manage.resource.dao;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.security.manage.resource.vo.ResourcesManageVo;

public interface ResourcesManageDao
{
    public List<ResourcesManageVo> getRoleInResoures(ResourcesManageVo resourcesManageVo) throws Exception;
}
