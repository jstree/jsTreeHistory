package standard.mvc.component.business.menu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

@Repository("MenuDao")
public class MenuDaoImpl extends EgovComAbstractDAO implements MenuDao {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MenuComprehensiveTree> getChildNode(MenuComprehensiveTree menuComprehensiveTree) {
		return list("menu.getChildNode", menuComprehensiveTree );
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MenuComprehensiveTree> searchNodeByString( MenuComprehensiveTree menuComprehensiveTree ){
		
		return list("menu.searchNodeByString", menuComprehensiveTree );
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<String> searchNodeByPosition(List<MenuComprehensiveTree> searchNodeByPositions){
		
		return list("menu.searchNodeByPosition", searchNodeByPositions );
	}

}
