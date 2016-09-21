package egovframework.com.ext.jstree.springiBatis.monitor.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.monitor.dao.MonitorDAO;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.P_JqGrid;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.T_JqGridCellData;

@Service("MonitorService")
public class MonitorServiceImpl implements MonitorService {
	
	@Resource(name="MonitorDAO")
	private MonitorDAO monitorDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T_JqGridCellData> getJqGridCellData(P_JqGrid p_JqGrid) {
		// TODO Auto-generated method stub
		return (List<T_JqGridCellData>) monitorDAO.getJqGridCellData(p_JqGrid);
	}
}