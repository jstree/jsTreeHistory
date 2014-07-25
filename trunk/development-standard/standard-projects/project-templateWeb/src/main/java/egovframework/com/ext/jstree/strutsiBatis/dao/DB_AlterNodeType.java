package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DB_AlterNodeType implements I_DB_AlterNodeType {

	static Logger logger = Logger.getLogger(DB_AlterNodeType.class);

	@Override
	public int alterNodeType(P_ComprehensiveTree p_ComprehensiveTree,
			String determineDBSetting) {
		Integer returnInt = 0;
		try {
			Single_SqlMapClient.getSqlMapper().startTransaction();
			returnInt = Single_SqlMapClient.getSqlMapper().update(
					determineDBSetting, p_ComprehensiveTree);
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
