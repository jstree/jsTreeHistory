package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DB_AlterNode implements I_DB_AlterNode {

	static Logger logger = Logger.getLogger(DB_AlterNode.class);

	@Override
	public int alterNode(P_ComprehensiveTree p_AlterNode,
			String determineDBSetting) {
		Integer returnInt = 0;
		try {
			Single_SqlMapClient.getSqlMapper().startTransaction();
			returnInt = Single_SqlMapClient.getSqlMapper().update(
					determineDBSetting, p_AlterNode);
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
		return returnInt;
	}

}
