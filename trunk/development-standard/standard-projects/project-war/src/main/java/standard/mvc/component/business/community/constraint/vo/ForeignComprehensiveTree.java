package standard.mvc.component.business.community.constraint.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class ForeignComprehensiveTree extends ComprehensiveTree {

	@Override
	public String getSqlMapSelector() {
		// TODO Auto-generated method stub
		return "foreign";
	}

}
