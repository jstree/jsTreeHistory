package egovframework.com.ext.jstree.springHibernate.core.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.ext.jstree.springHibernate.core.vo.P_JsTree;

public interface I_DB_GetChildNode extends I_GenericDao<P_JsTree> 
{
    public Logger logger = LoggerFactory.getLogger(I_DB_GetNode.class);
    
    public List<P_JsTree> getChildNode(
            P_JsTree p_ComprehensiveTree);
    
    public List<P_JsTree> getChildNodeByLeftRight(
            P_JsTree p_ComprehensiveTree);
}
