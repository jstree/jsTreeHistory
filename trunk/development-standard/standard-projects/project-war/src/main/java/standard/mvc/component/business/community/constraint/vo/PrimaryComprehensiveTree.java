package standard.mvc.component.business.community.constraint.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author Hoseong.Son
 * @since 2014.12.21
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: PrimaryComprehensiveTree.java
 * 	Description : 제약조건 예제 주키 트리 VO
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
public class PrimaryComprehensiveTree extends ComprehensiveTree {
	/** Foreign Key Scheme Node 의 고유 ID, 1부터 시작 */
	private int f_c_id;

	public int getF_c_id() {
		return f_c_id;
	}

	public void setF_c_id(int f_c_id) {
		this.f_c_id = f_c_id;
	}

	@Override
	public String getSqlMapSelector() {
		// TODO Auto-generated method stub
		return "primary";
	}

}
