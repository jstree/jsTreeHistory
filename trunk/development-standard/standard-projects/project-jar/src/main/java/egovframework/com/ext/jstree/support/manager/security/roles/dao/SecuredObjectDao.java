package egovframework.com.ext.jstree.support.manager.security.roles.dao;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.security.roles.vo.SecuredObject;

public interface SecuredObjectDao
{
    List<SecuredObject> getRolesAndUrl(SecuredObject secureObject) throws Exception;

    List<SecuredObject> getRolesAndMethod(SecuredObject secureObject) throws Exception;

    List<SecuredObject> getRolesAndPointcut(SecuredObject secureObject) throws Exception;
}
