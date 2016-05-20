package egovframework.com.ext.jstree.support.manager.security.roles.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

public interface SecuredObjectService<K, V>
{
    LinkedHashMap<K, V> getResourceMap() throws Exception;
}
