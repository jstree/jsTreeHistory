package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_GenericDao;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * node검색 interface
 * */
public interface I_DB_SearchNode extends
		I_GenericDao<T_ComprehensiveTree, P_ComprehensiveTree> {

	static Logger logger = Logger.getLogger(I_DB_GetChildNode.class);

	public List<T_ComprehensiveTree> searchNodeByString(
			P_ComprehensiveTree p_ComprehensiveTree, String determineDBSetting);

	public List<String> searchNodeByPosition(
			List<P_ComprehensiveTree> p_SearchNodeByPositions,
			String determineDBSetting);

}
