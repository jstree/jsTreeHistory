package standard.mvc.component.business.menu.service;

import java.util.List;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

/**
 * Modification Information
 * 
 * @author ?
 * @since 2014. 7. 31.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: CoreService.java
 * 	Description : jstree Spring + iBatis 버젼의 서비스 인터페이스
 * 	Infomation	: jstree 에서 node를 add,search,delete 등의 행동을 하는 서비스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014. 7. 31.      ?        최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

public interface MenuService{

	public List<MenuComprehensiveTree> getChildNode(MenuComprehensiveTree menuComprehensiveTree);
	
	public List<String> searchNode( MenuComprehensiveTree menuComprehensiveTree );
}
