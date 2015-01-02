/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package egovframework.com.sec.security.securedobject;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.springframework.security.ConfigAttributeDefinition;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.RequestMatcher;

/**
 * Provides interfaces that ISecuredObjectService is an
 * interface for enabling applications to approach the
 * data of secured object resources from DataBase which
 * is refered to initial data of Spring Security.
 * 
 * @author ByungHun Woo
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    -------------    ----------------------
 *   2009.03.20  ByungHun Woo    최초 생성
 *	 2014.06.27     최대열			  sucurity 3.0 에서 재공되지 않는 클래스(ConfigAttributeDefinition) 변경, 제너릭 추가
 * </pre>
 */

public interface ISecuredObjectService {
    Log LOGGER = LogFactory.getLog(ISecuredObjectService.class);
    
	/**
	 * url 형식의 role 권한 획득
	 * @return LinkedHashMap<RequestMatcher, List<ConfigAttribute>>
	 * @exception Exception
	 */
    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getRolesAndUrl() throws Exception;
    
	/**
	 * method 형식의 role 권한 획득
	 * @return LinkedHashMap<RequestMatcher, List<ConfigAttribute>>
	 * @exception Exception
	 */
    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getRolesAndMethod() throws Exception;

	/**
	 * pointcut 형식의 role 권한 획득
	 * @return LinkedHashMap<RequestMatcher, List<ConfigAttribute>>
	 * @exception Exception
	 */
    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getRolesAndPointcut() throws Exception;

	/**
	 * getMatchedRequestMapping
	 * @return List<ConfigAttribute>
	 * @exception Exception
	 */    
    public List<ConfigAttribute> getMatchedRequestMapping(String url) throws Exception;
    //public ConfigAttributeDefinition getMatchedRequestMapping(String url)  throws Exception;
    
	/**
	 * role 의 계층(Hierarchy) 관계를 조회
	 * @return String
	 * @exception Exception
	 */   
    public String getHierarchicalRoles() throws Exception;

}
