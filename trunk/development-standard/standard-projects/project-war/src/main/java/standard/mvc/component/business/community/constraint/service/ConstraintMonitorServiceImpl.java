package standard.mvc.component.business.community.constraint.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.community.constraint.dao.ConstraintMonitorDAO;
import egovframework.com.ext.jstree.springiBatis.monitor.service.MonitorService;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.P_JqGrid;

@Service(value = "ConstraintMonitorService")
public class ConstraintMonitorServiceImpl implements MonitorService {

	@Resource(name = "ConstraintMonitorDAO")
	private ConstraintMonitorDAO constraintMonitorDAO;

	@Override
	public List<egovframework.com.ext.jstree.springiBatis.monitor.vo.T_JqGridCellData> getJqGridCellData(
			P_JqGrid p_JqGrid) {
		// TODO Auto-generated method stub
		return constraintMonitorDAO.getJqGridCellData(p_JqGrid);
	}

}
