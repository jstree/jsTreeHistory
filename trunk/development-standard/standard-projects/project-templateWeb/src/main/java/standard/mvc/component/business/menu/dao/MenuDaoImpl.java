package standard.mvc.component.business.menu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 이동민
 * @since 2014. 9. 05.
 * @version 1.0
 * @see <pre>
 *  Class Name  : MenuDaoImpl.java
 *  Description : Menu jstree Spring + iBatis 버젼의 DAO 인터페이스 구현체
 *  Infomation  : MenuDao.java 를 구현한 클래스로 실제 작업이 이루어지는 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014. 9. 05.  이동민               최초 생성
 *  2014. 9. 16.  류강하               메서드 추가 및 주석
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Repository("MenuDao")
public class MenuDaoImpl extends EgovComAbstractDAO implements MenuDao {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MenuComprehensiveTree> getChildNode(MenuComprehensiveTree menuComprehensiveTree) {
		return list("menu.getChildNode", menuComprehensiveTree );
	}
	
	@Override
    public MenuComprehensiveTree getNode(MenuComprehensiveTree menuComprehensiveTree) {
	    return (MenuComprehensiveTree) selectByPk("core.getNode", menuComprehensiveTree);
    }

    @Override
    public MenuComprehensiveTree getNodeByRef(MenuComprehensiveTree menuComprehensiveTree) {
        return (MenuComprehensiveTree) selectByPk("core.getNodeByRef", menuComprehensiveTree);
    }

    @Override
    public int addMyselfFromJstree(MenuComprehensiveTree menuComprehensiveTree) {
        return (Integer) insert("core.addMyselfFromJstree", menuComprehensiveTree);
    }
    
    @Override
    public int alterNode(MenuComprehensiveTree menuComprehensiveTree) {
        return (Integer)update("core.alterNode", menuComprehensiveTree);
    }
	
//	@Override
//	@SuppressWarnings("unchecked")
//	public List<MenuComprehensiveTree> searchNodeByString( MenuComprehensiveTree menuComprehensiveTree ){
//		
//		return list("menu.searchNodeByString", menuComprehensiveTree );
//	}
//	
//	@Override
//	@SuppressWarnings("unchecked")
//	public List<String> searchNodeByPosition(List<MenuComprehensiveTree> searchNodeByPositions){
//		
//		return list("menu.searchNodeByPosition", searchNodeByPositions );
//	}
}
