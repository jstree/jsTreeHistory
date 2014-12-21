package standard.mvc.component.business.community.constraint.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class ConstraintComprehensiveTree extends ComprehensiveTree {
	/** Foreign Key Scheme Node 의 고유 ID, 1부터 시작 */
	private int f_c_id;
	/** Foreign Key Scheme 조회 여부 */
	private boolean queryUsingFk;

	public int getF_c_id() {
		return f_c_id;
	}

	public void setF_c_id(int f_c_id) {
		this.f_c_id = f_c_id;
	}

	public boolean isQueryUsingFk() {
		return queryUsingFk;
	}

	public void setQueryUsingFk(boolean queryUsingFk) {
		this.queryUsingFk = queryUsingFk;
	}

	@Override
	public String getSqlMapSelector() {
		// TODO Auto-generated method stub
		return "constraint";
	}

}
