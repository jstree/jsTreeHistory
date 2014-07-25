package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DB_GetNode implements I_DB_GetNode {

	static Logger logger = Logger.getLogger(DB_GetNode.class);

	@Override
	public T_ComprehensiveTree getNode(P_ComprehensiveTree p_ComprehensiveTree,
			String determineDBSetting) {

		T_ComprehensiveTree t_ComprehensiveTree = new T_ComprehensiveTree();

		try {
			t_ComprehensiveTree = (T_ComprehensiveTree) Single_SqlMapClient
					.getSqlMapper().queryForObject(determineDBSetting,
							p_ComprehensiveTree);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return t_ComprehensiveTree;
	}

	@Override
	public T_ComprehensiveTree getNodeByRef(
			P_ComprehensiveTree p_ComprehensiveTree, String determineDBSetting) {

		T_ComprehensiveTree t_ComprehensiveTree = new T_ComprehensiveTree();

		try {
			t_ComprehensiveTree = (T_ComprehensiveTree) Single_SqlMapClient
					.getSqlMapper().queryForObject(determineDBSetting,
							p_ComprehensiveTree);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return t_ComprehensiveTree;
	}
}
