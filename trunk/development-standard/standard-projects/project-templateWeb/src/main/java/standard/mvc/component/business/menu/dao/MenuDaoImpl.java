package standard.mvc.component.business.menu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository("MenuDao")
public class MenuDaoImpl extends EgovComAbstractDAO implements MenuDao {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MenuComprehensiveTree> getChildNode(MenuComprehensiveTree comprehensiveTree) {
		return list("menu.getChildNode", comprehensiveTree );
	}

}
