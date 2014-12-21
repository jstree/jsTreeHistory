package standard.mvc.component.business.community.constraint.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.ext.jstree.springiBatis.monitor.vo.P_JqGrid;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.T_JqGridCellData;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("ConstraintMonitorDAO")
public class ConstraintMonitorDAO extends EgovAbstractDAO {

	@SuppressWarnings("unchecked")
	public List<T_JqGridCellData> getJqGridCellData(P_JqGrid p_JstreeMonitor) {
		return list("constraintMonitor.getJstreeMonitor", p_JstreeMonitor);
	}
	
}
