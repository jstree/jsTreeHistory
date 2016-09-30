package egovframework.com.ext.jstree.strutsiBatis.core.dao;

import egovframework.com.ext.jstree.strutsiBatis.core.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.core.vo.T_ComprehensiveTree;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Modification Information
 * 
 * @author 이동민
 * @since 2014.07.25
 * @version 1.0
 * @see <pre>
 * 
 * Class Name 	: I_DB_MoveNode.java
 * Description 	: JSTree의 node를 이동하는 dao 의 interface 
 * Infomation	: 
 *
 * node를 이동한다.
 * 
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.25    Dongmin.Lee      최초 생성 
 * 
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 * */
public interface I_DB_MoveNode {

	public void setRequest(HttpServletRequest request);
	
	/**
	 * node를 이동한다.
	 * 
	 * @param P_ComprehensiveTree(p_ComprehensiveTree)
	 * @param T_ComprehensiveTree(nodeById)
	 * @param List&lt;T_ComprehensiveTree&gt(childNodesFromNodeById)
	 * @param T_ComprehensiveTree(nodeByRef)
	 * @param List&lt;T_ComprehensiveTree&gt(childNodesFromNodeByRef)
	 * @return T_ComprehensiveTree
	 * */
	T_ComprehensiveTree moveNode(P_ComprehensiveTree p_ComprehensiveTree,
			T_ComprehensiveTree nodeById,
			List<T_ComprehensiveTree> childNodesFromNodeById,
			T_ComprehensiveTree nodeByRef,
			List<T_ComprehensiveTree> childNodesFromNodeByRef);

}
