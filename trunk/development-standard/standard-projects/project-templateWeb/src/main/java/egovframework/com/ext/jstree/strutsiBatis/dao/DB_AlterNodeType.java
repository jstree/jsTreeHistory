package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("DB_AlterNodeType")
public class DB_AlterNodeType extends EgovComAbstractDAO implements
        I_DB_AlterNodeType
{
    
    static Logger logger = Logger.getLogger(DB_AlterNodeType.class);
    
    @SuppressWarnings("deprecation")
    @Override
    public int alterNodeType(P_ComprehensiveTree p_ComprehensiveTree,
            String determineDBSetting)
    {
        Integer returnInt = 0;
        try
        {
            getSqlMapClientTemplate().getSqlMapClient().startTransaction();
            returnInt = getSqlMapClientTemplate().getSqlMapClient()
                    .update(determineDBSetting, p_ComprehensiveTree);
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
