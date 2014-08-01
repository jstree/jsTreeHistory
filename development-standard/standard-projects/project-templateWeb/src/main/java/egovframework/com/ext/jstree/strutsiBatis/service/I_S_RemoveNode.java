package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_GenericDao;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public interface I_S_RemoveNode extends
		I_GenericDao<T_ComprehensiveTree, P_ComprehensiveTree> {

	static Logger logger = Logger.getLogger(I_S_SearchNode.class);

	public void setRequest(HttpServletRequest request);

	public int executeRemoveNode(P_ComprehensiveTree p_ComprehensiveTree);
	
	/**
	 * node의 제거 
	 * */
	public int removeNode(P_ComprehensiveTree p_RemoveNode);

}
