package egovframework.com.ext.jstree.support.manager.security.roles.service.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import egovframework.com.ext.jstree.support.manager.security.roles.dao.SecuredObjectDao;
import egovframework.com.ext.jstree.support.manager.security.roles.service.SecuredObjectService;
import egovframework.com.ext.jstree.support.manager.security.roles.vo.SecuredObject;

public class UrlResourceMapServiceImpl implements SecuredObjectService<RequestMatcher, List<ConfigAttribute>> {

	private SecuredObjectDao securedObjectDao;

	private String requestMatcherType;

	public void setSecuredObjectDao(SecuredObjectDao securedObjectDao) {
		this.securedObjectDao = securedObjectDao;
	}

	public void setRequestMatcherType(String requestMatcherType) {
		this.requestMatcherType = requestMatcherType;
	}

	public SecuredObjectDao getSecuredObjectDao() {
		return securedObjectDao;
	}

	public String getRequestMatcherType() {
		return requestMatcherType;
	}

	@Override
	public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getResourceMap()
			throws Exception {
		LinkedHashMap<RequestMatcher, List<ConfigAttribute>> resultMap = new LinkedHashMap<RequestMatcher, List<ConfigAttribute>>();

		List<SecuredObject> list = securedObjectDao
				.getRolesAndUrl(new SecuredObject());

		String preResource = null;
		RequestMatcher currentResource = null;

		for (SecuredObject secureObject : list) {
			if (requestMatcherType.equalsIgnoreCase("regex")) {
				currentResource = new RegexRequestMatcher(
						secureObject.getPattern(), null, false);
			} else if (requestMatcherType.equalsIgnoreCase("ant")) {
				currentResource = new AntPathRequestMatcher(
						secureObject.getPattern());
			}

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
