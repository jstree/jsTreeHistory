package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DB_RemoveNode implements I_DB_RemoveNode {

	static Logger logger = Logger.getLogger(DB_RemoveNode.class);

	@Override
	public int removeNode(P_ComprehensiveTree p_RemoveNode,
			String determineDBSetting) {
		int retrunResultCount = 0;

		try {
			Single_SqlMapClient.getSqlMapper().startTransaction();
			Single_SqlMapClient.getSqlMapper().delete("solution.removeNode",
					p_RemoveNode);
			Single_SqlMapClient.getSqlMapper().update(
					"solution.removedAfterLeftFix", p_RemoveNode);
			Single_SqlMapClient.getSqlMapper().delete(
					"solution.removedAfterRightFix", p_RemoveNode);
			Single_SqlMapClient.getSqlMapper().delete(
					"solution.removedAfterPositionFix", p_RemoveNode);
			Single_SqlMapClient.getSqlMapper().commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				Single_SqlMapClient.getSqlMapper().endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retrunResultCount;
	}

}
