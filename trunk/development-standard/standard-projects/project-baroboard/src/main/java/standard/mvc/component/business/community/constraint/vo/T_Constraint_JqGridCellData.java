package standard.mvc.component.business.community.constraint.vo;

import java.util.List;

import egovframework.com.ext.jstree.springiBatis.monitor.vo.T_JqGridCellData;

/**
 * Modification Information
 * 
 * @author Hoseong.Son
 * @since 2014.12.21
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: T_Constraint_JqGridCellData.java
 * 	Description : 1. 제약조건 예제 주키, 외래키 모니터링 VO
 * 	              2. 차후 JqGrid 교체 예정
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.12.21    Hoseong.Son           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
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
