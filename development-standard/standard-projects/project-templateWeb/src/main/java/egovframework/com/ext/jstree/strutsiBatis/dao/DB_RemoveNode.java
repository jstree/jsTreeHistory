package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * node 제거
 * 
 * node를 제거하고 left와 right를 좁히고 position값을 수정하여 node가 있던 빈 공간을 매꾼다.
 * */
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
			getSqlMapClientTemplate().getSqlMapClient().delete("jstreeStrutsiBatis.removeNode",
					p_RemoveNode);
			getSqlMapClientTemplate().getSqlMapClient().update(
					"jstreeStrutsiBatis.removedAfterLeftFix", p_RemoveNode);
			getSqlMapClientTemplate().getSqlMapClient().delete(
					"jstreeStrutsiBatis.removedAfterRightFix", p_RemoveNode);
			getSqlMapClientTemplate().getSqlMapClient().delete(
					"jstreeStrutsiBatis.removedAfterPositionFix", p_RemoveNode);
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
