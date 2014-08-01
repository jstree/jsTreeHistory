package egovframework.com.ext.jstree.strutsiBatis.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_DB_GetNode;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

@Service("S_GetNode")
public class S_GetNode implements I_S_GetNode
{
    
    static Logger logger = Logger.getLogger(S_GetChildNode.class);
    
    HttpServletRequest request;
    
    @Resource(name = "DB_GetNode")
    I_DB_GetNode i_DB_GetNode;
    
    public S_GetNode()
    {
        // i_DB_GetNode = new DB_GetNode();
    }
    
    @Override
    public void setRequest(HttpServletRequest request)
    {
        this.request = request;
    }
    
    @Override
    public T_ComprehensiveTree getNode(P_ComprehensiveTree p_ComprehensiveTree,
            String flag)
    {
        String determineDBSetting = this.selectDBSetting(flag);
        
        return i_DB_GetNode.getNode(p_ComprehensiveTree, determineDBSetting);
    }
    
    @Override
    public T_ComprehensiveTree getNodeByRef(
            P_ComprehensiveTree p_ComprehensiveTree, String flag)
    {
        String determineDBSetting = this.selectDBSetting(flag);
        
        return i_DB_GetNode.getNodeByRef(p_ComprehensiveTree,
                                         determineDBSetting);
    }
    
    public String selectDBSetting(String flag)
    {
        // TODO : 리퀘스트에 따라서 DB 설정파일을 불러와서 선택적 리턴을 해야 함.
        String returnStr = "";
        if (request
                .getRequestURI()
                .equals("/templateWeb/egovframework/com/ext/jstree/strutsiBatis/removeNode.action")
                && flag.equals("remove"))
        {
            returnStr = "jstreeStrutsiBatis.getNode";
        }
        else if (request
                .getRequestURI()
                .equals("/templateWeb/egovframework/com/ext/jstree/strutsiBatis/moveNode.action")
                && flag.equals("getNode"))
        {
            returnStr = "jstreeStrutsiBatis.getNode";
        }
        else if (request
                .getRequestURI()
                .equals("/templateWeb/egovframework/com/ext/jstree/strutsiBatis/moveNode.action")
                && flag.equals("getNodeByRef"))
        {
            returnStr = "jstreeStrutsiBatis.getNodeByRef";
        }
        else if (request
                .getRequestURI()
                .equals("/templateWeb/egovframework/com/ext/jstree/strutsiBatis/addNode.action")
                && flag.equals("getNode"))
        {
            returnStr = "jstreeStrutsiBatis.getNode";
        }
        else if (request
                .getRequestURI()
                .equals("/templateWeb/egovframework/com/ext/jstree/strutsiBatis/addNode.action")
                && flag.equals("getNodeByRef"))
        {
            returnStr = "jstreeStrutsiBatis.getNodeByRef";
        }
        else if (request
                .getRequestURI()
                .equals("/templateWeb/egovframework/com/ext/jstree/strutsiBatis/alterNodeType.action")
                && flag.equals("getNode"))
        {
            returnStr = "jstreeStrutsiBatis.getNode";
        }
        else
        {
            logger.debug(request.getRequestURI());
            throw new RuntimeException();
        }
        return returnStr;
    }
    
}
