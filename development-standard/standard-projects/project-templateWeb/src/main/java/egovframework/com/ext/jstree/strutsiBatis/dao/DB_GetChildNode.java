package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("DB_GetChildNode")
public class DB_GetChildNode extends EgovComAbstractDAO implements
        I_DB_GetChildNode
{
    public Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    public List<T_ComprehensiveTree> getChildNode(
            P_ComprehensiveTree p_ComprehensiveTree, String determineDBSetting)
    {
        List<T_ComprehensiveTree> t_ComprehensiveTrees = new ArrayList<T_ComprehensiveTree>();
        try
        {
            t_ComprehensiveTrees = getSqlMapClientTemplate().getSqlMapClient()
                    .queryForList(determineDBSetting, p_ComprehensiveTree);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            
        }
        return t_ComprehensiveTrees;
    }
    
    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    public List<T_ComprehensiveTree> getChildNodeByLeftRight(
            P_ComprehensiveTree p_ComprehensiveTree, String determineDBSetting)
    {
        List<T_ComprehensiveTree> t_ComprehensiveTrees = new ArrayList<T_ComprehensiveTree>();
        try
        {
            t_ComprehensiveTrees = getSqlMapClientTemplate().getSqlMapClient()
                    .queryForList(determineDBSetting, p_ComprehensiveTree);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            
        }
        return t_ComprehensiveTrees;
    }
}
