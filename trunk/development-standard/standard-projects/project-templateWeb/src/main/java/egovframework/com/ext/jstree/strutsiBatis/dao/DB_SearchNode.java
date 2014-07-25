package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DB_SearchNode implements I_DB_SearchNode {

	static Logger logger = Logger.getLogger(DB_GetChildNode.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<T_ComprehensiveTree> searchNodeByString(
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
	public List<String> searchNodeByPosition(
			List<P_ComprehensiveTree> p_SearchNodeByPositions,
			String determineDBSetting) {
		List<String> returnList = new ArrayList<String>();

		try {
			List<String> dbList = Single_SqlMapClient.getSqlMapper()
					.queryForList(determineDBSetting, p_SearchNodeByPositions);
			for (String rowData : dbList) {
				rowData = "#node_" + rowData;
				returnList.add(rowData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return returnList;
	}

}
