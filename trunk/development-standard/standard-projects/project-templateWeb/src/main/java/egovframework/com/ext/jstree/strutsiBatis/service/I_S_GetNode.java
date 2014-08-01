package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_GenericDao;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import javax.servlet.http.HttpServletRequest;


/**
 * node 정보 가져오기 interface
 * */
public interface I_S_GetNode extends
		I_GenericDao<T_ComprehensiveTree, P_ComprehensiveTree> {

	public T_ComprehensiveTree getNode(P_ComprehensiveTree p_ComprehensiveTree,
			String flag);

	public T_ComprehensiveTree getNodeByRef(
			P_ComprehensiveTree p_ComprehensiveTree, String flag);

	public void setRequest(HttpServletRequest request);
}
