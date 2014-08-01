package egovframework.com.ext.jstree.strutsiBatis.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_DB_AlterNodeType;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

@Service("S_AlterNodeType")
public class S_AlterNodeType implements I_S_AlterNodeType
{
    
    static Logger logger = Logger.getLogger(S_AlterNodeType.class);
    
    HttpServletRequest request;
    
    @Resource(name = "S_GetChildNode")
    I_S_GetChildNode i_S_GetChildNode;
    
    @Resource(name = "S_GetNode")
    I_S_GetNode i_S_GetNode;
    
    @Resource(name = "DB_AlterNodeType")
    I_DB_AlterNodeType i_DB_AlterNodeType;
    
    public S_AlterNodeType()
    {
        // i_S_GetChildNode = new S_GetChildNode();
        // i_S_GetNode = new S_GetNode();
        // i_DB_AlterNodeType = new DB_AlterNodeType();
    }
    
    @Override
    public void setRequest(HttpServletRequest request)
    {
        this.request = request;
        
    }
    
    @Override
    public int alterNodeType(P_ComprehensiveTree p_ComprehensiveTree)
    {
        
        i_S_GetChildNode.setRequest(request);
        List<T_ComprehensiveTree> childNodesFromNodeById = i_S_GetChildNode
                .getChildNode(p_ComprehensiveTree);
        
        i_S_GetNode.setRequest(request);
        T_ComprehensiveTree nodeById = i_S_GetNode.getNode(p_ComprehensiveTree,
                                                           "getNode");
        
        int returnStatus = 0;
        if (p_ComprehensiveTree.getC_type().equals("default"))
        {
            
            if (childNodesFromNodeById.size() > 0)
            {
                throw new RuntimeException("하위에 노드가 있는데 디폴트로 바꾸려고 함");
                
            }
            else
            {
                p_ComprehensiveTree.setC_type("default");
                String determineDBSetting = selectDBSetting();
                int temp = i_DB_AlterNodeType
                        .alterNodeType(p_ComprehensiveTree, determineDBSetting);
                
                if (temp == 1)
                {
                    returnStatus = 1;
                }
                else
                {
                    throw new RuntimeException("여러개의 노드가 업데이트 되었음");
                }
            }
        }
        else
        {
            if (nodeById.getC_type().equals("folder"))
            {
                returnStatus = 1;
            }
            else
            {
                String determineDBSetting = selectDBSetting();
                returnStatus = i_DB_AlterNodeType
                        .alterNodeType(p_ComprehensiveTree, determineDBSetting);
            }
            
        }
        
        return returnStatus;
    }
    
    public String selectDBSetting()
    {
        // TODO : 리퀘스트에 따라서 DB 설정파일을 불러와서 선택적 리턴을 해야 함.
        String returnStr = "";
        if (request
                .getRequestURI()
                .equals("/templateWeb/egovframework/com/ext/jstree/strutsiBatis/alterNodeType.action"))
        {
            returnStr = "jstreeStrutsiBatis.alterNodeType";
        }
        else
        {
            logger.debug(request.getRequestURI());
        }
        return returnStr;
    }
    
}
