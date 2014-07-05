package egovframework.com.ext.jstree.monitor.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.ext.jstree.monitor.service.MonitorService;
import egovframework.com.ext.jstree.monitor.vo.P_JqGrid;
import egovframework.com.ext.jstree.monitor.vo.T_JqGridCellData;
import egovframework.com.ext.jstree.monitor.vo.T_JqGridRowData;
import egovframework.com.ext.jstree.monitor.vo.T_JqgridJson;

@Controller
public class MonitorController {

	@Resource(name = "MonitorService")
	MonitorService monitorService;
	
	@ResponseBody
	@RequestMapping("/egovframework/com/etc/jstree/monitor/list.do")
	public String list( ModelMap model ) throws JsonProcessingException {
		
		T_JqgridJson t_JqgridJson = new T_JqgridJson();
		t_JqgridJson.setPage("1");
		t_JqgridJson.setRecords("1");
		t_JqgridJson.setTotal("1");

		List<T_JqGridRowData> rows = new ArrayList<T_JqGridRowData>();

		List<T_JqGridCellData> t_JqGridCellDatas = monitorService.getJqGridCellData(new P_JqGrid());
		
		for (T_JqGridCellData t_JqGridCellData : t_JqGridCellDatas) {
			T_JqGridRowData rowData = new T_JqGridRowData();

			rowData.setId(Integer.toString(t_JqGridCellData.getC_id()));
			rowData.setCell(t_JqGridCellData.getCellData());

			rows.add(rowData);
		}
		t_JqgridJson.setRows(rows);
		
		return new ObjectMapper().writeValueAsString(t_JqgridJson);
	}
}