package standard.mvc.component.business.community.constraint.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.community.constraint.dao.ConstraintMonitorDAO;
import standard.mvc.component.business.community.constraint.vo.T_Constraint_JqGridCellData;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.P_JqGrid;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.T_JqGridCellData;

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
