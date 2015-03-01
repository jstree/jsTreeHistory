package standard.mvc.component.business.community.log.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.community.menu.vo.MenuComprehensiveTree;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * Modification Information
 * 
 * @author JongRyul.Lee
 * @since 2014.11.15
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: CommunityController.java
 * 	Description : Community 메뉴 가져오는 Dao Class
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.11.15    이종렬           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Repository(value = "LogUrlDao")
public class LogUrlDaoImpl extends EgovAbstractDAO implements LogUrlDao
{
    
    @SuppressWarnings({ "deprecation", "unchecked" })
    @Override
    public String getLogUrl()
    {
        return (String)getSqlMapClientTemplate().queryForObject("log.getUrlLog");
    }
}
