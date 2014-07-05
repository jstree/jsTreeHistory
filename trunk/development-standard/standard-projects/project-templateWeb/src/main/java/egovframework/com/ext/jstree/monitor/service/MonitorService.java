package egovframework.com.ext.jstree.monitor.service;

import java.util.List;

import egovframework.com.ext.jstree.monitor.vo.P_JqGrid;
import egovframework.com.ext.jstree.monitor.vo.T_JqGridCellData;

public interface MonitorService {

	public List<T_JqGridCellData> getJqGridCellData(P_JqGrid p_JqGrid);
}
