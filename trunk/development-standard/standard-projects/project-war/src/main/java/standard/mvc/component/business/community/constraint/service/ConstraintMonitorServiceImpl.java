package standard.mvc.component.business.community.constraint.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.community.constraint.dao.ConstraintMonitorDAO;
import standard.mvc.component.business.community.constraint.vo.T_Primary_JqGridCellData;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.P_JqGrid;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.T_JqGridCellData;

@Service(value = "ConstraintMonitorService")
public class ConstraintMonitorServiceImpl implements ConstraintMonitorService {

	@Resource(name = "ConstraintMonitorDAO")
	private ConstraintMonitorDAO constraintMonitorDAO;

	@Override
	public List<T_JqGridCellData> getJqGridCellData(P_JqGrid p_JqGrid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T_Primary_JqGridCellData> getPrimaryJqGridCellData(
			P_JqGrid p_JqGrid) {
		// TODO Auto-generated method stub
		return constraintMonitorDAO.getJqGridCellData(p_JqGrid);
	}

	

}
