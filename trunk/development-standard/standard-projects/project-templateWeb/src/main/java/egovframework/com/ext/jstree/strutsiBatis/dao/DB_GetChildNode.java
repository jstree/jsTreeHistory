package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 자식(하위)node들 가져오는 class
 * 
 * */
@Repository("DB_GetChildNode")
public class DB_GetChildNode extends EgovComAbstractDAO implements I_DB_GetChildNode {

	static Logger logger = Logger.getLogger(DB_GetChildNode.class);
	
	
	/**
	 * 자식(하위)node 가져오는 메소드
	 * */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<T_ComprehensiveTree> getChildNode(
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
	
	/**
	 * 자식(하위)node의 left와 right값을 가져오는 메소드
	 * 
	 * */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<T_ComprehensiveTree> getChildNodeByLeftRight(
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

}
