package standard.mvc.component.business.menu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.menu.dao.MenuMngDao;
import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

@Service(value="menuMngService")
public class MenuMngServiceImpl implements MenuMngSerivce {

	@Resource
	private MenuMngDao menuDao;

	public List<MenuComprehensiveTree> getEgovUpperMenu() {
		return menuDao.getEgovUpperMenu();
	}

	public List<MenuComprehensiveTree> getEgovLeftMenu(MenuComprehensiveTree menuComprehensiveTree) {
		return menuDao.getEgovLeftMenu(menuComprehensiveTree);
	}

	@Override
	public List<MenuComprehensiveTree> getCommunityMenu() {
		return menuDao.getCommunityMenu();
	}
}
