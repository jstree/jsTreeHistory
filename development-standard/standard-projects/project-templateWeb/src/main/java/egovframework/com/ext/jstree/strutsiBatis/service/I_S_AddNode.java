package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_GenericDao;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import javax.servlet.http.HttpServletRequest;

/**
 * addNode interface
 * 노드 추가 인터페이스
 * @param P_ComprehensiveTree
 * @return T_ComprehensiveTree
 * 
 * */
public interface I_S_AddNode extends
		I_GenericDao<T_ComprehensiveTree, P_ComprehensiveTree> {

	public void setRequest(HttpServletRequest request);
	
	/**
	 * node를 추가
	 * */
	public T_ComprehensiveTree addNode(P_ComprehensiveTree p_ComprehensiveTree);

}
