package standard.mvc.component.business.menu.dao;

import java.util.List;

import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

public interface MenuMngDao {

	public List<MenuComprehensiveTree> getEgovUpperMenu();
	
	public List<MenuComprehensiveTree> getEgovLeftMenu(MenuComprehensiveTree menuComprehensiveTree);
	
	public List<MenuComprehensiveTree> getCommunityMenu();
}
