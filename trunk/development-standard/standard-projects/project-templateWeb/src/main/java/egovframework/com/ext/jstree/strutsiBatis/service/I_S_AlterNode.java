package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_GenericDao;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * node를 수정하는 interface class
 * 
 * */
public interface I_S_AlterNode extends
		I_GenericDao<T_ComprehensiveTree, P_ComprehensiveTree> {

	static Logger logger = Logger.getLogger(I_S_AlterNode.class);

	public void setRequest(HttpServletRequest request);
	
	/**
	 * node정보를 수정
	 * */
	public int alterNode(P_ComprehensiveTree p_ComprehensiveTree);

}
