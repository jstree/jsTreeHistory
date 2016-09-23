package egovframework.com.ext.jstree.springHibernate.core.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springHibernate.core.dao.DB_GetChildNode;
import egovframework.com.ext.jstree.springHibernate.core.vo.P_JsTree;

@Service("Hibernate_S_GetChildNode")
public class S_GetChildNode implements I_S_GetChildNode
{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    HttpServletRequest request;
    
    @Autowired
    DB_GetChildNode i_DB_GetChildNode;
    
    @Override
    public void setRequest(HttpServletRequest request)
    {
        this.request = request;
        
    }

    @Override
    public List<P_JsTree> getChildNode(P_JsTree p_ComprehensiveTree)
    {
        logger.info(this.getClass() + " call getChildNode");
        return  i_DB_GetChildNode.getChildNode(p_ComprehensiveTree);
    }

    @Override
    public List<P_JsTree> getChildNodeByLeftRight(P_JsTree p_ComprehensiveTree)
    {
        logger.info(this.getClass() + " call getChildNodeByLeftRight");
        return i_DB_GetChildNode.getChildNodeByLeftRight(p_ComprehensiveTree);
    }
    
}
