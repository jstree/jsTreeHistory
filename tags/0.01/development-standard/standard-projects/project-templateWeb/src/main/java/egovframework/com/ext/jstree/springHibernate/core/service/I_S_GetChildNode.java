package egovframework.com.ext.jstree.springHibernate.core.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.ext.jstree.springHibernate.core.vo.P_JsTree;

public interface I_S_GetChildNode
{
    public Logger logger = LoggerFactory.getLogger(I_S_GetChildNode.class);
    
    public void setRequest(HttpServletRequest request);
    
    public List<P_JsTree> getChildNode(P_JsTree p_ComprehensiveTree);
    
    public List<P_JsTree> getChildNodeByLeftRight(P_JsTree p_ComprehensiveTree);
}
