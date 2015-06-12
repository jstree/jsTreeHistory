package standard.mvc.component.business.baroboard.core.manage.setting.localTime.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class LocalTimeVO extends ComprehensiveTree {

	@Override
	public String getSqlMapSelector() {
		return "localTime";
	}
}
