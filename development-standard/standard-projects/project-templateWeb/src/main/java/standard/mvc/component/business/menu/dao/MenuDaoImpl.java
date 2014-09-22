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
 *  2014. 9. 21.  김대근               removeNode 메소드 추가
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
	    return (MenuComprehensiveTree) selectByPk("menu.getNode", menuComprehensiveTree);
    }

    @Override
    public MenuComprehensiveTree getNodeByRef(MenuComprehensiveTree menuComprehensiveTree) {
        return (MenuComprehensiveTree) selectByPk("menu.getNodeByRef", menuComprehensiveTree);
    }

    @Override
    public int addMyselfFromJstree(MenuComprehensiveTree menuComprehensiveTree) {
        return (Integer) insert("menu.addMyselfFromJstree", menuComprehensiveTree);
    }
    
    @Override
    public int alterNode(MenuComprehensiveTree menuComprehensiveTree) {
        return (Integer) update("menu.alterNode", menuComprehensiveTree);
    }
	
    public void cutMyself(MenuComprehensiveTree p_OnlyCutMyselfFromJstree) {
        update("menu.cutMyselfPositionFix", p_OnlyCutMyselfFromJstree);
        update("menu.cutMyselfLeftFix",     p_OnlyCutMyselfFromJstree);
        update("menu.cutMyselfRightFix",    p_OnlyCutMyselfFromJstree);
    }
    
    public void stretchPositionForMyselfFromJstree(MenuComprehensiveTree comprehensiveTree) {
        update("menu.stretchPositionForMyself", comprehensiveTree);
    }
    
    public void stretchLeftRightForMyselfFromJstree(MenuComprehensiveTree comprehensiveTree) {
        update("menu.stretchLeftForMyselfFromJstree", comprehensiveTree);
        update("menu.stretchRightForMyselfFromJstree", comprehensiveTree);
    }
    
    public int pasteMyselfFromJstree(MenuComprehensiveTree p_OnlyPasteMyselfFromJstree) {
        return (Integer) insert("menu.pasteMyselfFromJstree", p_OnlyPasteMyselfFromJstree);
    }
    
    @SuppressWarnings("unchecked")
    public List<MenuComprehensiveTree> getChildNodeByLeftRight(MenuComprehensiveTree comprehensiveTree) {
        return list("menu.getChildNodeByLeftRight", comprehensiveTree );
    }
    
    public void enterMyselfFromJstree(MenuComprehensiveTree comprehensiveTree) {
        insert("menu.enterMyselfFromJstree", comprehensiveTree);
    }
    
    public void fixCopy(MenuComprehensiveTree comprehensiveTree) {
        update("menu.fixCopy", comprehensiveTree);
    }

    public void fixCopyIF(MenuComprehensiveTree comprehensiveTree) {
        update("menu.fixCopyIF", comprehensiveTree);
    }

	@Override
	public int removeNode(MenuComprehensiveTree comprehensiveTree) {
		return super.delete("menu.removeNode", comprehensiveTree);
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
