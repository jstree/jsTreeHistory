package standard.mvc.component.business.community.menu.dao;

import java.util.List;

import standard.mvc.component.business.community.menu.vo.MenuComprehensiveTree;

/**
 * Modification Information
 * 
 * @author JongRyul.Lee
 * @since 2014.11.15
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: CommunityController.java
 * 	Description : Community 메뉴 가져오는 Dao Interface
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.11.15    이종렬           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

public interface MenuMngDao {

	public List<MenuComprehensiveTree> getEgovUpperMenu();
	
	public List<MenuComprehensiveTree> getEgovLeftMenu(MenuComprehensiveTree menuComprehensiveTree);
	
	public List<MenuComprehensiveTree> getCommunityMenu();
}
