package standard.mvc.component.business.menu.service;

import java.util.List;

import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 이동민
 * @since 2014. 9. 05.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: MenuService.java
 * 	Description : Menu jstree Spring + iBatis 버젼의 서비스 인터페이스
 * 	Infomation	: Menu jstree 에서 node를 CRUD하는 서비스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014. 9. 05.  이동민               최초 생성
 *  2014. 9. 15.  류강하               노드 추가 메서드 추가 및 주석
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface MenuService {

    /**
     * 자식 노드를 요청한다.
     * 
     * @param menuComprehensiveTree - Menu jstree에서 사용되는 tree VO
     * @return List<MenuComprehensiveTree> 자식 노드들
     */
	public List<MenuComprehensiveTree> getChildNode(MenuComprehensiveTree menuComprehensiveTree);
	
	/**
     * 노드를 추가한다.
     * 
     * @param menuComprehensiveTree - Menu jstree에서 사용되는 tree VO 
     * @return MenuComprehensiveTree
     */
    public MenuComprehensiveTree addNode(MenuComprehensiveTree menuComprehensiveTree);
    
//  public List<String> searchNode(MenuComprehensiveTree menuComprehensiveTree);
}
