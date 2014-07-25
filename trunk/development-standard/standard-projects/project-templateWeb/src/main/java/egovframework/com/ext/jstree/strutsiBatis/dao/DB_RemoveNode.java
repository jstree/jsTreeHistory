package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("DB_RemoveNode")
public class DB_RemoveNode extends EgovComAbstractDAO implements I_DB_RemoveNode {

	static Logger logger = Logger.getLogger(DB_RemoveNode.class);

	@SuppressWarnings("deprecation")
	@Override
	public int removeNode(P_ComprehensiveTree p_RemoveNode,
			String determineDBSetting) {
		int retrunResultCount = 0;

		try {
			getSqlMapClientTemplate().getSqlMapClient().startTransaction();
			getSqlMapClientTemplate().getSqlMapClient().delete("jstreeStrtusiBatis.removeNode",
					p_RemoveNode);
			getSqlMapClientTemplate().getSqlMapClient().update(
					"jstreeStrtusiBatis.removedAfterLeftFix", p_RemoveNode);
			getSqlMapClientTemplate().getSqlMapClient().delete(
					"jstreeStrtusiBatis.removedAfterRightFix", p_RemoveNode);
			getSqlMapClientTemplate().getSqlMapClient().delete(
					"jstreeStrtusiBatis.removedAfterPositionFix", p_RemoveNode);
			getSqlMapClientTemplate().getSqlMapClient().commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				getSqlMapClientTemplate().getSqlMapClient().endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retrunResultCount;
	}

}
