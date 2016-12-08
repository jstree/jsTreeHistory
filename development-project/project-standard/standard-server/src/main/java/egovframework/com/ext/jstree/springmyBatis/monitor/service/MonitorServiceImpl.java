package egovframework.com.ext.jstree.springmyBatis.monitor.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springmyBatis.monitor.dao.MonitorDAO;
import egovframework.com.ext.jstree.springmyBatis.monitor.vo.P_JqGrid;
import egovframework.com.ext.jstree.springmyBatis.monitor.vo.T_JqGridCellData;

@Service("MonitorService")
public class MonitorServiceImpl implements MonitorService {
	
	@Resource(name="MonitorDAO")
	private MonitorDAO monitorDAO;
	
	@Override
	public List<T_JqGridCellData> getJqGridCellData(P_JqGrid p_JqGrid) {
		// TODO Auto-generated method stub
		return monitorDAO.getJqGridCellData(p_JqGrid);
	}
}