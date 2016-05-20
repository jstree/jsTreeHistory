package egovframework.com.ext.jstree.support.manager.security.roles.service.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

import egovframework.com.ext.jstree.support.manager.security.roles.dao.SecuredObjectDao;
import egovframework.com.ext.jstree.support.manager.security.roles.service.SecuredObjectService;
import egovframework.com.ext.jstree.support.manager.security.roles.vo.SecuredObject;

public class MethodResourceMapServiceImpl implements SecuredObjectService<String, List<ConfigAttribute>> {

	private SecuredObjectDao securedObjectDao;

	public void setSecuredObjectDao(SecuredObjectDao securedObjectDao) {
		this.securedObjectDao = securedObjectDao;
	}

	public LinkedHashMap<String, List<ConfigAttribute>> getResourceMap()
			throws Exception {
		LinkedHashMap<String, List<ConfigAttribute>> resultMap = new LinkedHashMap<String, List<ConfigAttribute>>();

		List<SecuredObject> list = securedObjectDao
				.getRolesAndMethod(new SecuredObject());

		String preResource = null;
		String currentResource = null;

		for (SecuredObject secureObject : list) {
			currentResource = secureObject.getPattern();
			List<ConfigAttribute> configList = new LinkedList<ConfigAttribute>();

			if (preResource != null
					&& secureObject.getPattern().equals(preResource)) {
				configList.addAll(resultMap.get(currentResource));
			}

			configList.add(new SecurityConfig(secureObject.getAuthority()));
			resultMap.put(currentResource, configList);
			preResource = secureObject.getPattern();

		}

		return resultMap;
	}

}
