package standard.mvc.component.business.menu.service;

import java.util.List;

import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

public interface MenuMngSerivce {
	
	public List<MenuComprehensiveTree> getEgovUpperMenu();

	public List<MenuComprehensiveTree> getEgovLeftMenu(MenuComprehensiveTree menuComprehensiveTree);
	
	public List<MenuComprehensiveTree> getCommunityMenu();
	
}
