package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_GenericDao;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import org.apache.log4j.Logger;

/**
 * node type 수정 interface
 * 
 * nodetype은 drive /  folder /default (file) 이렇게 3종류로 현재는 구성되어있다
 * 
 * */
public interface I_DB_AlterNodeType extends
		I_GenericDao<T_ComprehensiveTree, P_ComprehensiveTree> {

	static Logger logger = Logger.getLogger(I_DB_GetChildNode.class);

	public int alterNodeType(P_ComprehensiveTree p_ComprehensiveTree,
			String determineDBSetting);

}
