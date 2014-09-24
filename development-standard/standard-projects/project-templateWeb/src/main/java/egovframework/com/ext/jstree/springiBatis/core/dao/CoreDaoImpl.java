package egovframework.com.ext.jstree.springiBatis.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author ?
 * @since 2014. 7. 31.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: CoreDAO.java
 * 	Description : jsTree Spring + iBatis 버젼의 DAO 클래스
 * 	Infomation	: Dao의 역할을 하는 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014. 7. 31.      ?         최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Repository("CoreDAO")
public class CoreDaoImpl extends EgovComAbstractDAO implements CoreDao{

	/**
	 * 자식노드를 요청한다.
	 * 
	 * @param comprehensiveTree
	 * @return List<ComprehensiveTree>
	 */
	@SuppressWarnings("unchecked")
	public <T extends ComprehensiveTree> List<T> getChildNode( T comprehensiveTree ){
		
		return list("core.getChildNode", comprehensiveTree );
	}

	
	@SuppressWarnings("unchecked")
	public <T extends ComprehensiveTree> List<T> searchNodeByString( T comprehensiveTree ){
		
		return list("core.searchNodeByString", comprehensiveTree );
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ComprehensiveTree>List<String> searchNodeByPosition(List<T> searchNodeByPositions){
		
		return list("core.searchNodeByPosition", searchNodeByPositions );
	}
	
	
	@SuppressWarnings("unchecked")
	public <T extends ComprehensiveTree> T getNode( T comprehensiveTree ){
		return ((T)selectByPk("core.getNode", comprehensiveTree));
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ComprehensiveTree> T getNodeByRef( T comprehensiveTree ){
		return ((T)selectByPk("core.getNodeByRef", comprehensiveTree));
	}
	
	public <T extends ComprehensiveTree> void cutMyself(T p_OnlyCutMyselfFromJstree){
		update("core.cutMyselfPositionFix", p_OnlyCutMyselfFromJstree);
		update("core.cutMyselfLeftFix",     p_OnlyCutMyselfFromJstree);
		update("core.cutMyselfRightFix",    p_OnlyCutMyselfFromJstree);
	}
	
	public <T extends ComprehensiveTree>void stretchPositionForMyselfFromJstree( T comprehensiveTree ){
		update("core.stretchPositionForMyself", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> void stretchLeftRightForMyselfFromJstree( T comprehensiveTree ){
		update("core.stretchLeftForMyselfFromJstree",  comprehensiveTree);
		update("core.stretchRightForMyselfFromJstree", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> int pasteMyselfFromJstree(T p_OnlyPasteMyselfFromJstree){
		return (Integer)insert("core.pasteMyselfFromJstree", p_OnlyPasteMyselfFromJstree);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ComprehensiveTree> List<T> getChildNodeByLeftRight( T comprehensiveTree ){
		
		return list("core.getChildNodeByLeftRight", comprehensiveTree );
	}
	
	public <T extends ComprehensiveTree> void fixCopy( T comprehensiveTree){
		update("core.fixCopy", comprehensiveTree);
	}

	public <T extends ComprehensiveTree> void fixCopyIF( T comprehensiveTree ){
		update("core.fixCopyIF", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> void enterMyselfFromJstree( T comprehensiveTree ){
		insert("core.enterMyselfFromJstree", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> int addMyselfFromJstree( T comprehensiveTree ){
		return (Integer)insert("core.addMyselfFromJstree", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> int alterNode( T comprehensiveTree ){
		return (Integer)update("core.alterNode", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> int removeNode( T comprehensiveTree ){
		
		delete("core.removeNode",              comprehensiveTree);
		update("core.removedAfterLeftFix",     comprehensiveTree);
		delete("core.removedAfterRightFix",    comprehensiveTree);
		delete("core.removedAfterPositionFix", comprehensiveTree);
		
		return 0;
	}
	
	public <T extends ComprehensiveTree> int alterNodeType( T comprehensiveTree ){
		return (Integer)update("core.alterNodeType", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> void stretchLeftForMyselfFromJstree( T comprehensiveTree ){
		update("core.stretchLeftForMyselfFromJstree", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> void stretchRightForMyselfFromJstree( T comprehensiveTree ){
		update("core.stretchRightForMyselfFromJstree", comprehensiveTree);
	}
}