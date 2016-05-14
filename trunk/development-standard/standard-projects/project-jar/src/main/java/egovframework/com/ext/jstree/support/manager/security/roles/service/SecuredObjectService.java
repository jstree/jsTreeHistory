package egovframework.com.ext.jstree.support.manager.security.roles.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

public interface SecuredObjectService
{
    LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getRolesAndUrl() throws Exception;

    LinkedHashMap<String, List<ConfigAttribute>> getRolesAndMethod() throws Exception;

    LinkedHashMap<String, List<ConfigAttribute>> getRolesAndPointcut() throws Exception;
}
