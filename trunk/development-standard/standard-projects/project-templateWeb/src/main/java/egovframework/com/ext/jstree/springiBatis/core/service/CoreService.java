package egovframework.com.ext.jstree.springiBatis.core.service;

import java.util.List;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author ?
 * @since 2014. 7. 31.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: CoreService.java
 * 	Description : jstree Spring + iBatis 버젼의 서비스 인터페이스
 * 	Infomation	: jstree 에서 node를 add,search,delete 등의 행동을 하는 서비스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014. 7. 31.      ?        최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface CoreService {

	
	/**
	 * 자식노드를 요청한다.
	 * 
	 * @param comprehensiveTree - jstree에서 사용되는 tree VO
	 * @return List<ComprehensiveTree> 자식 노드들
	 */
	public List<ComprehensiveTree> getChildNode( ComprehensiveTree comprehensiveTree );
	
	
	/**
	 * 노드를 검색한다.
	 * 
	 * @param comprehensiveTree - jstree에서 사용되는 tree VO 
	 * @return List<String> - 검색된 노드들
	 */
	public List<String> searchNode( ComprehensiveTree comprehensiveTree );
	
	
	/**
	 * 노드를 추가한다.
	 * 
	 * @param comprehensiveTree - jstree에서 사용되는 tree VO 
	 * @return ComprehensiveTree
	 */
	public ComprehensiveTree addNode( ComprehensiveTree comprehensiveTree );
	
	
	/**
	 * 노드를 삭제한다.
	 * 
	 * @param comprehensiveTree - jstree에서 사용되는 tree VO 
	 * @return int
	 */
	public int executeRemoveNode( ComprehensiveTree comprehensiveTree );
	
	
	/**
	 * 노드를 변경한다.
	 * 
	 * @param comprehensiveTree - jstree에서 사용되는 tree VO 
	 * @return int
	 */
	public int alterNode( ComprehensiveTree comprehensiveTree );
	
	
	/**
	 * 노드의 타입을 변경한다.
	 * 
	 * @param comprehensiveTree - jstree에서 사용되는 tree VO 
	 * @return int
	 */
	public int alterNodeType( ComprehensiveTree comprehensiveTree );
	
	
	/**
	 * 노드를 이동한다.
	 * 
	 * @param comprehensiveTree - jstree에서 사용되는 tree VO 
	 * @return ComprehensiveTree
	 */
	public ComprehensiveTree moveNode( ComprehensiveTree comprehensiveTree );
}