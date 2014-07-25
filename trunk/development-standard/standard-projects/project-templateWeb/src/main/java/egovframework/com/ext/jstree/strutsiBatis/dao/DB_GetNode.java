package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("DB_GetNode")
public class DB_GetNode extends EgovComAbstractDAO implements I_DB_GetNode {

	static Logger logger = Logger.getLogger(DB_GetNode.class);

	@SuppressWarnings("deprecation")
	@Override
	public T_ComprehensiveTree getNode(P_ComprehensiveTree p_ComprehensiveTree,
			String determineDBSetting) {

		T_ComprehensiveTree t_ComprehensiveTree = new T_ComprehensiveTree();

		try {
			t_ComprehensiveTree = (T_ComprehensiveTree) getSqlMapClientTemplate().getSqlMapClient().queryForObject(determineDBSetting,
							p_ComprehensiveTree);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return t_ComprehensiveTree;
	}

	@SuppressWarnings("deprecation")
	@Override
	public T_ComprehensiveTree getNodeByRef(
			P_ComprehensiveTree p_ComprehensiveTree, String determineDBSetting) {

		T_ComprehensiveTree t_ComprehensiveTree = new T_ComprehensiveTree();

		try {
			t_ComprehensiveTree = (T_ComprehensiveTree) getSqlMapClientTemplate().getSqlMapClient().queryForObject(determineDBSetting,
							p_ComprehensiveTree);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return t_ComprehensiveTree;
	}
}
