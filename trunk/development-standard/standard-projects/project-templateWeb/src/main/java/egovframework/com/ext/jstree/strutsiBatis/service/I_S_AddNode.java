package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_GenericDao;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import javax.servlet.http.HttpServletRequest;

public interface I_S_AddNode extends
        I_GenericDao<T_ComprehensiveTree, P_ComprehensiveTree>
{
    
    public void setRequest(HttpServletRequest request);
    
    public T_ComprehensiveTree addNode(P_ComprehensiveTree p_ComprehensiveTree);
    
}
