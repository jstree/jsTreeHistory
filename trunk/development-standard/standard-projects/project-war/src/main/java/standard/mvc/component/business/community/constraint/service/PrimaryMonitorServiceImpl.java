package standard.mvc.component.business.community.constraint.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.community.constraint.dao.ConstraintMonitorDAO;
import standard.mvc.component.business.community.constraint.vo.T_Constraint_JqGridCellData;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.P_JqGrid;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.T_JqGridCellData;

/**
 * Modification Information
 * 
 * @author Hoseong.Son
 * @since 2014.12.25
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: PrimaryMonitorServiceImpl.java
 * 	Description : 제약조건 예제 중 주키 트리 모니터링 서비스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.12.25    Hoseong.Son           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service(value = "PrimaryMonitorService")
public class PrimaryMonitorServiceImpl implements ConstraintMonitorService {

	@Resource(name = "ConstraintMonitorDAO")
	private ConstraintMonitorDAO constraintMonitorDAO;

	@Override
	public List<T_JqGridCellData> getJqGridCellData(P_JqGrid p_JqGrid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T_Constraint_JqGridCellData> getExtendedJqGridCellData(
			P_JqGrid p_JqGrid) {
		// TODO Auto-generated method stub
		return constraintMonitorDAO.getPrimaryJqGridCellData(p_JqGrid);
	}

	

}
