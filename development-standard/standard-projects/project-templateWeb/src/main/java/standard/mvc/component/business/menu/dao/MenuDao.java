package standard.mvc.component.business.menu.dao;

import java.util.List;

import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

public interface MenuDao {

	public List<MenuComprehensiveTree> getChildNode( MenuComprehensiveTree comprehensiveTree );
	
	
}
