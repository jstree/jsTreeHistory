package standard.mvc.component.business.menu.dao;

import java.util.List;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 이동민
 * @since 2014. 9. 05.
 * @version 1.0
 * @see <pre>
 *  Class Name  : MenuDao.java
 *  Description : Menu jstree Spring + iBatis 버젼의 DAO 인터페이스
 *  Infomation  : Menu jstree 에서 node를 CRUD
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014. 9. 05.  이동민               최초 생성
 *  2014. 9. 15.  류강하               메서드 추가 및 주석
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface MenuDao {

    /**
     * 자식노드를 요청한다.
     * 
     * @param menuComprehensiveTree
     * @return List<ComprehensiveTree>
     */
	public List<MenuComprehensiveTree> getChildNode(MenuComprehensiveTree menuComprehensiveTree);
	
    public MenuComprehensiveTree getNode(MenuComprehensiveTree menuComprehensiveTree);
    
    public MenuComprehensiveTree getNodeByRef(MenuComprehensiveTree menuComprehensiveTree);

    public int addMyselfFromJstree(MenuComprehensiveTree menuComprehensiveTree);
    
    public int alterNode(MenuComprehensiveTree menuComprehensiveTree);
    
//	public List<MenuComprehensiveTree> searchNodeByString(MenuComprehensiveTree menuComprehensiveTree);
	
//	public List<String> searchNodeByPosition(List<MenuComprehensiveTree> searchNodeByPositions);
}
