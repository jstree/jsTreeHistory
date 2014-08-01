package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_GenericDao;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import org.apache.log4j.Logger;

/**
 * node를 제거하는 interface
 * 
 * */
public interface I_DB_RemoveNode extends
		I_GenericDao<T_ComprehensiveTree, P_ComprehensiveTree> {

	static Logger logger = Logger.getLogger(I_DB_RemoveNode.class);

	public int removeNode(P_ComprehensiveTree p_RemoveNode,
			String determineDBSetting);

}
