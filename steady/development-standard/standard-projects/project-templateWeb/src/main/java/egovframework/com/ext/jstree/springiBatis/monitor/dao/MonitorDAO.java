package egovframework.com.ext.jstree.springiBatis.monitor.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.P_JqGrid;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.T_JqGridCellData;

@Repository("MonitorDAO")
public class MonitorDAO extends EgovComAbstractDAO {

	@SuppressWarnings("unchecked")
	public List<T_JqGridCellData> getJqGridCellData(P_JqGrid p_JstreeMonitor) {

		return list("monitor.getJstreeMonitor", p_JstreeMonitor);
	}
}