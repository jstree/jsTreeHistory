package egovframework.com.ext.jstree.support.manager.security.roles.dao.impl;

import java.util.List;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.support.manager.security.roles.dao.SecuredObjectDao;
import egovframework.com.ext.jstree.support.manager.security.roles.vo.SecuredObject;

public class SecuredObjectDaoImpl extends EgovComAbstractDAO implements SecuredObjectDao
{

    @Override
    public List<SecuredObject> getRolesAndUrl(SecuredObject secureObject) throws Exception
    {
        return list("secureObject.getRolesAndUrl",secureObject);
    }

    @Override
    public List<SecuredObject> getRolesAndMethod(SecuredObject secureObject) throws Exception
    {
        // TODO Auto-generated method stub
        return list("secureObject.getRolesAndMethod" ,secureObject);
    }

    @Override
    public List<SecuredObject> getRolesAndPointcut(SecuredObject secureObject) throws Exception
    {
        // TODO Auto-generated method stub
        return list("secureObject.getRolesAndPointcut",secureObject);
    }
    
}
