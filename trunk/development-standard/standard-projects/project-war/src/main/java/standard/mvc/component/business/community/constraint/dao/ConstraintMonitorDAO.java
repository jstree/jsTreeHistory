package standard.mvc.component.business.community.constraint.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.community.constraint.vo.T_Constraint_JqGridCellData;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.P_JqGrid;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * Modification Information
 * 
 * @author Hoseong.Son
 * @since 2014.12.21
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: ConstraintMonitorDAO.java
 * 	Description : 1. 제약조건 예제 주키, 외래키 모니터링 DAO
 * 	              2. 차후 JqGrid 교체 예정
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.12.21    Hoseong.Son           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Repository("ConstraintMonitorDAO")
public class ConstraintMonitorDAO extends EgovAbstractDAO {

	@SuppressWarnings("unchecked")
	public List<T_Constraint_JqGridCellData> getPrimaryJqGridCellData(P_JqGrid p_JstreeMonitor) {
		return list("constraintMonitor.getPrimaryJstreeMonitor", p_JstreeMonitor);
	}
	
	@SuppressWarnings("unchecked")
	public List<T_Constraint_JqGridCellData> getForeignJqGridCellData(P_JqGrid p_JstreeMonitor) {
		return list("constraintMonitor.getForeignJstreeMonitor", p_JstreeMonitor);
	}
	
}
