package standard.mvc.component.business.community.constraint.service;

import java.util.List;

import standard.mvc.component.business.community.constraint.vo.T_Constraint_JqGridCellData;
import egovframework.com.ext.jstree.springiBatis.monitor.service.MonitorService;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.P_JqGrid;

/**
 * Modification Information
 * 
 * @author Hoseong.Son
 * @since 2014.12.21
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: ForeignMonitorServiceImpl.java
 * 	Description : 제약조건 예제 중 주키, 외래키 트리 모니터링 서비스 인터페이스
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
public interface ConstraintMonitorService extends MonitorService {
	public List<T_Constraint_JqGridCellData> getExtendedJqGridCellData(P_JqGrid p_JqGrid);
}
