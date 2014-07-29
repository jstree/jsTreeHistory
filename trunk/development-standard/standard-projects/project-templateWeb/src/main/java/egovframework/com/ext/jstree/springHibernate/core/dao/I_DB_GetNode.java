package egovframework.com.ext.jstree.springHibernate.core.dao;

import org.apache.log4j.Logger;

import egovframework.com.ext.jstree.springHibernate.core.vo.P_JsTree;


public interface I_DB_GetNode extends I_GenericDao<P_JsTree> {

	static Logger logger = Logger.getLogger(I_DB_GetNode.class);

	public P_JsTree getNode(P_JsTree p_ComprehensiveTree,
			String determineDBSetting);

	public P_JsTree getNodeByRef(
			P_JsTree p_ComprehensiveTree, String determineDBSetting);

}