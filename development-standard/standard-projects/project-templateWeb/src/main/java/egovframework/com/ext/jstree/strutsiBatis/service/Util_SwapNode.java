package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class Util_SwapNode
{
    
    public static P_ComprehensiveTree swapTtoP(T_ComprehensiveTree originNode)
    {
        
        P_ComprehensiveTree destNode = new P_ComprehensiveTree();
        
        try
        {
            BeanUtils.copyProperties(destNode, originNode);
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        
        return destNode;
    }
    
    public static T_ComprehensiveTree swapPtoT(P_ComprehensiveTree originNode)
    {
        
        T_ComprehensiveTree destNode = new T_ComprehensiveTree();
        
        try
        {
            BeanUtils.copyProperties(destNode, originNode);
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        
        return destNode;
    }
    
    public static T_ComprehensiveTree copyTtoT(T_ComprehensiveTree originNode,
            T_ComprehensiveTree destNode)
    {
        
        try
        {
            BeanUtils.copyProperties(destNode, originNode);
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        
        return destNode;
    }
    
}
