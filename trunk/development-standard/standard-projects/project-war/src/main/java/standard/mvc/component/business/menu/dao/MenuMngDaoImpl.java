package standard.mvc.component.business.menu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository(value="menuMngDao")
public class MenuMngDaoImpl extends EgovAbstractDAO implements MenuMngDao{

	@Override
	public List<MenuComprehensiveTree> getEgovUpperMenu() {
		return getSqlMapClientTemplate().queryForList("menuMng.getEgovUpperMenu");
	}

	@Override
	public List<MenuComprehensiveTree> getEgovLeftMenu(MenuComprehensiveTree menuComprehensiveTree) {
		// TODO Auto-generated method stub
		return list("menuMng.getEgovLeftMenu", menuComprehensiveTree);
	}

	@Override
	public List<MenuComprehensiveTree> getCommunityMenu() {
		return getSqlMapClientTemplate().queryForList("menuMng.getCommunityMenu");
	}

}
