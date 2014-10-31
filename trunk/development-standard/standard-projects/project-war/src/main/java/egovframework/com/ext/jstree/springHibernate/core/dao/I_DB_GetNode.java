package egovframework.com.ext.jstree.springHibernate.core.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.ext.jstree.springHibernate.core.vo.P_JsTree;

public interface I_DB_GetNode extends I_GenericDao<P_JsTree>
{
    
    public Logger logger = LoggerFactory.getLogger(I_DB_GetNode.class);
    
    public P_JsTree getNode(P_JsTree p_ComprehensiveTree,
            String determineDBSetting);
    
    public P_JsTree getNodeByRef(P_JsTree p_ComprehensiveTree,
            String determineDBSetting);
    
}