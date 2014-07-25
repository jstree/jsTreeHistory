package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("DB_SearchNode")
public class DB_SearchNode extends EgovComAbstractDAO implements I_DB_SearchNode {

	static Logger logger = Logger.getLogger(DB_GetChildNode.class);

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<T_ComprehensiveTree> searchNodeByString(
			P_ComprehensiveTree p_ComprehensiveTree, String determineDBSetting) {

		List<T_ComprehensiveTree> t_ComprehensiveTrees = new ArrayList<T_ComprehensiveTree>();

		try {
			t_ComprehensiveTrees = getSqlMapClientTemplate().getSqlMapClient()
					.queryForList(determineDBSetting, p_ComprehensiveTree);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return t_ComprehensiveTrees;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<String> searchNodeByPosition(
			List<P_ComprehensiveTree> p_SearchNodeByPositions,
			String determineDBSetting) {
		List<String> returnList = new ArrayList<String>();

		try {
			List<String> dbList = getSqlMapClientTemplate().getSqlMapClient()
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
