package egovframework.com.ext.jstree.springHibernate.core.service;

import java.util.List;

import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateDTO;
import egovframework.com.ext.jstree.support.util.SearchSupport;

public interface JsTreeHibernateService {
	
	public <T extends JsTreeHibernateDTO> T getNode(SearchSupport searchSupport) throws Exception;

	/**
	 * 자식노드를 요청한다.
	 * 
	 * @param <T>
	 * 
	 * @param JsTreeHibernateDTO
	 *            - jstree에서 사용되는 tree VO
	 * @return List<JsTreeHibernateDTO> 자식 노드들
	 */
	public <T extends JsTreeHibernateDTO> List<T> getChildNode(SearchSupport searchSupport) throws Exception;

	/**
	 * 노드를 검색한다.
	 * 
	 * @param JsTreeHibernateDTO
	 *            - jstree에서 사용되는 tree VO
	 * @return List<String> - 검색된 노드들
	 */
	public <T extends JsTreeHibernateDTO> List<String> searchNode(SearchSupport searchSupport) throws Exception;

	/**
	 * 노드를 추가한다.
	 * 
	 * @param JsTreeHibernateDTO
	 *            - jstree에서 사용되는 tree VO
	 * @return JsTreeHibernateDTO
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public <T extends JsTreeHibernateDTO> T addNode(SearchSupport searchSupport) throws Exception;

	/**
	 * 노드를 삭제한다.
	 * 
	 * @param JsTreeHibernateDTO
	 *            - jstree에서 사용되는 tree VO
	 * @return int
	 */
	public <T extends JsTreeHibernateDTO> int removeNode(SearchSupport searchSupport) throws Exception;

	/**
	 * 노드를 변경한다.
	 * 
	 * @param JsTreeHibernateDTO
	 *            - jstree에서 사용되는 tree VO
	 * @return int
	 */
	public <T extends JsTreeHibernateDTO> int alterNode(SearchSupport searchSupport) throws Exception;

	/**
	 * 노드의 타입을 변경한다.
	 * 
	 * @param JsTreeHibernateDTO
	 *            - jstree에서 사용되는 tree VO
	 * @return int
	 */
	public <T extends JsTreeHibernateDTO> int alterNodeType(SearchSupport searchSupport) throws Exception;

	/**
	 * 노드를 이동한다.
	 * 
	 * @param JsTreeHibernateDTO
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public <T extends JsTreeHibernateDTO> T moveNode(SearchSupport searchSupport) throws Exception;

}
