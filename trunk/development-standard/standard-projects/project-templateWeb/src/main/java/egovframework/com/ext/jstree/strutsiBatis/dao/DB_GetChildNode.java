package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DB_GetChildNode implements I_DB_GetChildNode {

	static Logger logger = Logger.getLogger(DB_GetChildNode.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<T_ComprehensiveTree> getChildNode(
			P_ComprehensiveTree p_ComprehensiveTree, String determineDBSetting) {
		List<T_ComprehensiveTree> t_ComprehensiveTrees = new ArrayList<T_ComprehensiveTree>();
		try {
			t_ComprehensiveTrees = Single_SqlMapClient.getSqlMapper()
					.queryForList(determineDBSetting, p_ComprehensiveTree);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return t_ComprehensiveTrees;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T_ComprehensiveTree> getChildNodeByLeftRight(
			P_ComprehensiveTree p_ComprehensiveTree, String determineDBSetting) {
		List<T_ComprehensiveTree> t_ComprehensiveTrees = new ArrayList<T_ComprehensiveTree>();
		try {
			t_ComprehensiveTrees = Single_SqlMapClient.getSqlMapper()
					.queryForList(determineDBSetting, p_ComprehensiveTree);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return t_ComprehensiveTrees;
	}

}
