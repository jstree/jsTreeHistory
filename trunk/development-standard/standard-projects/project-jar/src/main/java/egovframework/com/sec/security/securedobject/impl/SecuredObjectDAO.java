package egovframework.com.sec.security.securedobject.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.security.ConfigAttributeDefinition;
//import org.springframework.security.SecurityConfig;
import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.intercept.web.RequestKey;


import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.AntPathRequestMatcher;
//import org.springframework.security.web.util.RequestMatcher;

import egovframework.com.sec.security.securedobject.ISecuredObjectService;

/**
 * DB 기반의 Secured Object 정보를 제공하기 위한 DAO 로 default 쿼리를
 * 제공하며 사용자 DB 에 맞는 각 유형의 DB 쿼리는 재설정 가능하다.
 * namedParameterJdbcTemplate 를 사용하여 DB 조회를 처리한다.
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
 *   2009.03.10  ByungHun Woo    최초 생성
 *   2009.03.20  이문준          UPDATE
 *	 2014.06.27     최대열			 sucurity 3.0 에서 재공되지 않는 클래스(ConfigAttributeDefinition) 변경, 제너릭 추가
 * </pre>
 */
public class SecuredObjectDAO {

    /**
     * url 형식인 보호자원 - Role 맵핑정보를 조회하는 default 쿼리이다.
     */
    public static final String DEF_ROLES_AND_URL_QUERY =                                 
     "SELECT a.ROLE_PTTRN url, b.AUTHOR_CODE authority     "
    +"  FROM COMTNROLEINFO a, COMTNAUTHORROLERELATE b    "
    +" WHERE a.ROLE_CODE = b.ROLE_CODE                   "
    +"   AND a.ROLE_TY = 'url'  ORDER BY a.ROLE_SORT    ";
    
    /**
     * method 형식인 보호자원 - Role 맵핑정보를 조회하는 default 쿼리이다.
     */
    public static final String DEF_ROLES_AND_METHOD_QUERY =
        "SELECT a.ROLE_PTTRN \"method\", b.AUTHOR_CODE authority   "
        +"  FROM COMTNROLEINFO a, COMTNAUTHORROLERELATE b    "
        +" WHERE a.ROLE_CODE = b.ROLE_CODE                   "
        +"   AND a.ROLE_TY = 'method'  ORDER BY a.ROLE_SORT ";    	
    	
    /**
     * pointcut 형식인 보호자원 - Role 맵핑정보를 조회하는 default
     * 쿼리이다.
     */
    public static final String DEF_ROLES_AND_POINTCUT_QUERY =
        "SELECT a.ROLE_PTTRN pointcut, b.AUTHOR_CODE authority   "
        +"  FROM COMTNROLEINFO a, COMTNAUTHORROLERELATE b    "
        +" WHERE a.ROLE_CODE = b.ROLE_CODE                   "
        +"   AND a.ROLE_TY = 'pointcut'  ORDER BY a.ROLE_SORT ";    
    
    /**
     * 매 request 마다 best matching url 보호자원 - Role 맵핑정보를
     * 얻기위한 default 쿼리이다. (Oracle 10g specific)
     */
    public static final String DEF_REGEX_MATCHED_REQUEST_MAPPING_QUERY_ORACLE10G =
        "SELECT a.resource_pattern uri, b.authority authority   "
        + " FROM COMTNSECURED_RESOURCES a, COMTNSECURED_RESOURCES_ROLE b   "
        + " WHERE a.resource_id = b.resource_id   "
        + " AND a.resource_type = 'url' ";

    
    /*****************************************************************
	    "SELECT a.resource_pattern uri, b.authority authority "
	    + "FROM secured_resources a, secured_resources_role b "
	    + "WHERE a.resource_id = b.resource_id "
	    + "AND a.resource_id =  "
	    + " ( SELECT resource_id FROM "
	    + "    ( SELECT resource_id, ROW_NUMBER() OVER (ORDER BY sort_order) resource_order FROM secured_resources c "
	    + "      WHERE REGEXP_LIKE ( :url, c.resource_pattern ) "
	    + "      AND c.resource_type = 'url' "
	    + "      ORDER BY c.sort_order ) "
	    + "   WHERE resource_order = 1 ) ";
    */
    
    
    /**
     * Role 의 계층(Hierarchy) 관계를 조회하는 default 쿼리이다.
     */
    public static final String DEF_HIERARCHICAL_ROLES_QUERY =
        "SELECT a.CHLDRN_ROLE child, a.PARNTS_ROLE parent "
        + "FROM COMTNROLES_HIERARCHY a LEFT JOIN COMTNROLES_HIERARCHY b on (a.CHLDRN_ROLE = b.PARNTS_ROLE) ";

    private String sqlRolesAndUrl;

    private String sqlRolesAndMethod;

    private String sqlRolesAndPointcut;

    private String sqlRegexMatchedRequestMapping;

    private String sqlHierarchicalRoles;
    
	/**
	 * SecuredObjectDAO 생성자
	 */
    public SecuredObjectDAO() {
        this.sqlRolesAndUrl = DEF_ROLES_AND_URL_QUERY;
        this.sqlRolesAndMethod = DEF_ROLES_AND_METHOD_QUERY;
        this.sqlRolesAndPointcut = DEF_ROLES_AND_POINTCUT_QUERY;
        this.sqlRegexMatchedRequestMapping = DEF_REGEX_MATCHED_REQUEST_MAPPING_QUERY_ORACLE10G;
        this.sqlHierarchicalRoles = DEF_HIERARCHICAL_ROLES_QUERY;
    }

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
	/**
	 * setDataSource
	 * @param dataSource DataSource
	 */
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate =
            new NamedParameterJdbcTemplate(dataSource);
    }

	/**
	 * getSqlRolesAndUrl
	 * @return String
	 */
    public String getSqlRolesAndUrl() {
        return sqlRolesAndUrl;
    }

	/**
	 * setSqlRolesAndUrl
	 * @param sqlRolesAndUrl String
	 */
    public void setSqlRolesAndUrl(String sqlRolesAndUrl) {
        this.sqlRolesAndUrl = sqlRolesAndUrl;
    }

	/**
	 * getSqlRolesAndMethod
	 * @return String
	 */
    public String getSqlRolesAndMethod() {
        return sqlRolesAndMethod;
    }

	/**
	 * setSqlRolesAndMethod
	 * @param sqlRolesAndMethod String
	 */
    public void setSqlRolesAndMethod(String sqlRolesAndMethod) {
        this.sqlRolesAndMethod = sqlRolesAndMethod;
    }

	/**
	 * getSqlRolesAndPointcut
	 * @return String
	 */
    public String getSqlRolesAndPointcut() {
        return sqlRolesAndPointcut;
    }

	/**
	 * setSqlRolesAndPointcut
	 * @param sqlRolesAndPointcut String
	 */
    public void setSqlRolesAndPointcut(String sqlRolesAndPointcut) {
        this.sqlRolesAndPointcut = sqlRolesAndPointcut;
    }

	/**
	 * getSqlRegexMatchedRequestMapping
	 * @return String
	 */
    public String getSqlRegexMatchedRequestMapping() {
        return sqlRegexMatchedRequestMapping;
    }

	/**
	 * setSqlRegexMatchedRequestMapping
	 * @param sqlRegexMatchedRequestMapping String
	 */
    public void setSqlRegexMatchedRequestMapping(
            String sqlRegexMatchedRequestMapping) {
        this.sqlRegexMatchedRequestMapping = sqlRegexMatchedRequestMapping;
    }

	/**
	 * getSqlHierarchicalRoles
	 * @return String
	 */
    public String getSqlHierarchicalRoles() {
        return sqlHierarchicalRoles;
    }

	/**
	 * setSqlHierarchicalRoles
	 * @param sqlHierarchicalRoles String
	 */
    public void setSqlHierarchicalRoles(String sqlHierarchicalRoles) {
        this.sqlHierarchicalRoles = sqlHierarchicalRoles;
    }
    
	/**
	 * getRolesAndResources
	 * @param resourceType String
	 * @return LinkedHashMap
	 * @exception Exception
	 */
    public LinkedHashMap<Object, List<ConfigAttribute>> getRolesAndResources(String resourceType)
            throws Exception {


        LinkedHashMap<Object, List<ConfigAttribute>> resourcesMap = new LinkedHashMap<Object, List<ConfigAttribute>>();

        String sqlRolesAndResources;
        boolean isResourcesUrl = true;
        if ("method".equals(resourceType)) {
            sqlRolesAndResources = getSqlRolesAndMethod();
            isResourcesUrl = false;
        } else if ("pointcut".equals(resourceType)) {
            sqlRolesAndResources = getSqlRolesAndPointcut();
            isResourcesUrl = false;
        } else {
            sqlRolesAndResources = getSqlRolesAndUrl();
        }

        List<Map<String, Object>> resultList = this.namedParameterJdbcTemplate.queryForList(sqlRolesAndResources, new HashMap<String, String>());

        Iterator<Map<String, Object>> itr = resultList.iterator();
        Map<String, Object> tempMap;
        String preResource = null;
        String presentResourceStr;
        Object presentResource;
        while (itr.hasNext()) {
            tempMap = itr.next();

            presentResourceStr = (String) tempMap.get(resourceType);
            // url 인 경우 RequestKey 형식의 key를 Map에 담아야 함
            presentResource = isResourcesUrl ? new AntPathRequestMatcher(presentResourceStr) : presentResourceStr;
            List<ConfigAttribute> configList = new LinkedList<ConfigAttribute>();

            // 이미 requestMap 에 해당 Resource 에 대한 Role 이 하나 이상 맵핑되어 있었던 경우, 
            // sort_order 는 resource(Resource) 에 대해 매겨지므로 같은 Resource 에 대한 Role 맵핑은 연속으로 조회됨.
            // 해당 맵핑 Role List (SecurityConfig) 의 데이터를 재활용하여 새롭게 데이터 구축
            if (preResource != null && presentResourceStr.equals(preResource)) {
                List<ConfigAttribute> preAuthList = resourcesMap.get(presentResource);
                Iterator<ConfigAttribute> preAuthItr = preAuthList.iterator();
                while (preAuthItr.hasNext()) {
                    SecurityConfig tempConfig = (SecurityConfig) preAuthItr.next();
                    configList.add(tempConfig);
                }
            }

            configList.add(new SecurityConfig((String) tempMap.get("authority")));
            
            // 만약 동일한 Resource 에 대해 한개 이상의 Role 맵핑 추가인 경우 
            // 이전 resourceKey 에 현재 새로 계산된 Role 맵핑 리스트로 덮어쓰게 됨.
            resourcesMap.put(presentResource, configList);

            // 이전 resource 비교위해 저장
            preResource = presentResourceStr;
        }

        return resourcesMap;
    }
    
	/**
	 * getRolesAndUrl
	 * @return LinkedHashMap
	 * @exception Exception
	 */
    public LinkedHashMap<Object, List<ConfigAttribute>> getRolesAndUrl() throws Exception {
        return getRolesAndResources("url");
    }
    
	/**
	 * getRolesAndMethod
	 * @return LinkedHashMap
	 * @exception Exception
	 */
    public LinkedHashMap<Object, List<ConfigAttribute>> getRolesAndMethod() throws Exception {
        return getRolesAndResources("method");
    }
    
	/**
	 * getRolesAndPointcut
	 * @return LinkedHashMap
	 * @exception Exception
	 */
    public LinkedHashMap<Object, List<ConfigAttribute>> getRolesAndPointcut() throws Exception {
        return getRolesAndResources("pointcut");
    }
    
	/**
	 * getRegexMatchedRequestMapping
	 * @param url String
	 * @return List<ConfigAttribute>
	 * @exception Exception
	 */
    public List<ConfigAttribute> getRegexMatchedRequestMapping(String url)
            throws Exception {

        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("url", url);
        List<Map<String, Object>> resultList = this.namedParameterJdbcTemplate.queryForList(getSqlRegexMatchedRequestMapping(), paramMap);

        Iterator<Map<String, Object>> itr = resultList.iterator();
        Map<String, Object> tempMap;
        List<ConfigAttribute> configList = new LinkedList<ConfigAttribute>();
        // 같은 Uri 에 대한 Role 맵핑이므로 무조건 configList 에 add 함
        while (itr.hasNext()) {
            tempMap = itr.next();
            configList.add(new SecurityConfig((String)tempMap.get("authority")));
        }

        if (configList.size() > 0) {
    
            ISecuredObjectService.LOGGER.debug(
            		"Request Uri : " + url
                + ", matched Uri : " + resultList.get(0).get("uri")
                + ", mapping Roles : " + configList);
        }

        return configList;
    }
    
	/**
	 * getHierarchicalRoles
	 * @return String
	 * @exception Exception
	 */
    public String getHierarchicalRoles() throws Exception {

        List resultList =
            this.namedParameterJdbcTemplate.queryForList(
                getSqlHierarchicalRoles(), new HashMap());

        Iterator itr = resultList.iterator();
        StringBuffer concatedRoles = new StringBuffer();
        Map tempMap;
        while (itr.hasNext()) {
            tempMap = (Map) itr.next();
            concatedRoles.append(tempMap.get("child"));
            concatedRoles.append(" > ");
            concatedRoles.append(tempMap.get("parent"));
            concatedRoles.append("\n");
        }

        return concatedRoles.toString();
    }
}
