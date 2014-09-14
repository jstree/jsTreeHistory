package standard.mvc.component.business.menu.dao;

import java.util.List;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

public interface MenuDao {

	public List<MenuComprehensiveTree> getChildNode( MenuComprehensiveTree comprehensiveTree );
	
	public List<MenuComprehensiveTree> searchNodeByString( MenuComprehensiveTree comprehensiveTree );
	
	public List<String> searchNodeByPosition(List<MenuComprehensiveTree> searchNodeByPositions);
	
}
