package standard.mvc.component.business.community.constraint.service;

import java.util.List;

import standard.mvc.component.business.community.constraint.vo.T_Constraint_JqGridCellData;
import egovframework.com.ext.jstree.springiBatis.monitor.service.MonitorService;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.P_JqGrid;

public interface ConstraintMonitorService extends MonitorService {
	public List<T_Constraint_JqGridCellData> getExtendedJqGridCellData(P_JqGrid p_JqGrid);
}
