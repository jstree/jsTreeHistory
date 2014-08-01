package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_GenericDao;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * 하위node들의 정보를 가져오는 interface
 * */
public interface I_DB_GetChildNode extends
		I_GenericDao<T_ComprehensiveTree, P_ComprehensiveTree> {

	static Logger logger = Logger.getLogger(I_DB_GetChildNode.class);
	
	/**
	 * 하위 node의 정보를 가져오는 메소드
	 * */
	public List<T_ComprehensiveTree> getChildNode(
			P_ComprehensiveTree p_ComprehensiveTree, String determineDBSetting);
	/**
	 * 하위 node의 left와 right값을 가지고 오는 메소드
	 * */
	public List<T_ComprehensiveTree> getChildNodeByLeftRight(
			P_ComprehensiveTree p_ComprehensiveTree, String determineDBSetting);

}
