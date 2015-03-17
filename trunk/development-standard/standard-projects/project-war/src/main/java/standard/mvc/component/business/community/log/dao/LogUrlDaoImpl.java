package standard.mvc.component.business.community.log.dao;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * Modification Information
 * 
 * @author GwonWoo.Oh
 * @since 2015.02.14
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: LogUrlDaoImpl.java
 * 	Description : 313 Log 가져오는  Dao Interface를 구현
 *  Infomation  : 313 Log 가져오는  Dao Interface를 구현
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                수정내용
 *  -------       ------------   -------------------------------
 *  2015.2.14.            오권우        최초 생성 - 로고 조회 Dao Interface 구현
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */


@Repository(value = "LogUrlDao")
public class LogUrlDaoImpl extends EgovAbstractDAO implements LogUrlDao
{
    
    @SuppressWarnings({ "deprecation" })
    @Override
    public String getLogUrl()
    {
        return (String)getSqlMapClientTemplate().queryForObject("log.getUrlLog");
    }
}
