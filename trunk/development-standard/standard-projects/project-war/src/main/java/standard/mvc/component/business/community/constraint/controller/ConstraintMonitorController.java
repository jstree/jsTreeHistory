package standard.mvc.component.business.community.constraint.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.base.controller.GenericAbstractController;
import standard.mvc.component.business.community.constraint.service.ConstraintMonitorService;
import standard.mvc.component.business.community.constraint.vo.T_Primary_JqGridCellData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.ext.jstree.springiBatis.monitor.vo.P_JqGrid;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.T_JqGridRowData;
import egovframework.com.ext.jstree.springiBatis.monitor.vo.T_JqgridJson;

@Controller
public class ConstraintMonitorController extends GenericAbstractController {

	@Resource(name = "PrimaryMonitorService")
	private ConstraintMonitorService primaryMonitorService;
	
	@Resource(name = "ForeignMonitorService")
	private ConstraintMonitorService foreignMonitorService;

	@ResponseBody
	@RequestMapping("/constraint/monitor/primary/list.do")
	public String getPrimaryList(ModelMap model) throws JsonProcessingException {

		return list(primaryMonitorService);
	}
	
	@ResponseBody
	@RequestMapping("/constraint/monitor/foreign/list.do")
	public String getForeignList(ModelMap model) throws JsonProcessingException {

		return list(foreignMonitorService);
	}

	private String list(ConstraintMonitorService constraintMonitorService) throws JsonProcessingException {
		T_JqgridJson t_JqgridJson = new T_JqgridJson();
		t_JqgridJson.setPage("1");
		t_JqgridJson.setRecords("1");
		t_JqgridJson.setTotal("1");

		List<T_JqGridRowData> rows = new ArrayList<T_JqGridRowData>();

		List<T_Primary_JqGridCellData> t_JqGridCellDatas = constraintMonitorService.getExtendedJqGridCellData(new P_JqGrid());

		for (T_Primary_JqGridCellData t_JqGridCellData : t_JqGridCellDatas) {
			T_JqGridRowData rowData = new T_JqGridRowData();

			rowData.setId(Integer.toString(t_JqGridCellData.getC_id()));
			rowData.setCell(t_JqGridCellData.getCellData());

			rows.add(rowData);
		}
		t_JqgridJson.setRows(rows);

		return new ObjectMapper().writeValueAsString(t_JqgridJson);
	}

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
