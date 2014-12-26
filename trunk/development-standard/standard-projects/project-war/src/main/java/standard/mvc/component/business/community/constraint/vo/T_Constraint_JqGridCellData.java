package standard.mvc.component.business.community.constraint.vo;

import java.util.List;

import egovframework.com.ext.jstree.springiBatis.monitor.vo.T_JqGridCellData;

public class T_Constraint_JqGridCellData extends T_JqGridCellData {
	private int f_c_id;

	public int getF_c_id() {
		return f_c_id;
	}

	public void setF_c_id(int f_c_id) {
		this.f_c_id = f_c_id;
	}

	@Override
	public List<String> getCellData() {
		// TODO Auto-generated method stub
		List<String> cellData = super.getCellData();
		cellData.add(Integer.toString(f_c_id));
		return cellData;
	}
	
	

}
