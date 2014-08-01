package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("DB_AlterNode")
public class DB_AlterNode extends EgovComAbstractDAO implements I_DB_AlterNode
{
    
    static Logger logger = Logger.getLogger(DB_AlterNode.class);
    
    @SuppressWarnings("deprecation")
    @Override
    public int alterNode(P_ComprehensiveTree p_AlterNode,
            String determineDBSetting)
    {
        Integer returnInt = 0;
        try
        {
            getSqlMapClientTemplate().getSqlMapClient().startTransaction();
            returnInt = getSqlMapClientTemplate().getSqlMapClient()
                    .update(determineDBSetting, p_AlterNode);
            getSqlMapClientTemplate().getSqlMapClient().commitTransaction();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                getSqlMapClientTemplate().getSqlMapClient().endTransaction();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return returnInt;
    }
    
}
