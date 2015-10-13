package standard.mvc.component.business.baroboard.core.manage.setting.layout.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class LayoutVO extends ComprehensiveTree {

	@Override
	public String getSqlMapSelector() {
		return "layout";
	}

	
}
