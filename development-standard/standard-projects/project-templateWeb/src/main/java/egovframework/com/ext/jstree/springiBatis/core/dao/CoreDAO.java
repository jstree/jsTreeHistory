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
public class CoreDAO extends EgovComAbstractDAO {

	/**
	 * 자식노드를 요청한다.
	 * 
	 * @param comprehensiveTree
	 * @return List<ComprehensiveTree>
	 */
	@SuppressWarnings("unchecked")
	public List<ComprehensiveTree> getChildNode( ComprehensiveTree comprehensiveTree ){
		
		return list("core.getChildNode", comprehensiveTree );
	}

	
	@SuppressWarnings("unchecked")
	public List<ComprehensiveTree> searchNodeByString( ComprehensiveTree comprehensiveTree ){
		
		return list("core.searchNodeByString", comprehensiveTree );
	}
	
	@SuppressWarnings("unchecked")
	public List<String> searchNodeByPosition(List<ComprehensiveTree> searchNodeByPositions){
		
		return list("core.searchNodeByPosition", searchNodeByPositions );
	}
	
	
	public ComprehensiveTree getNode( ComprehensiveTree comprehensiveTree ){
		return (ComprehensiveTree)selectByPk("core.getNode", comprehensiveTree);
	}
	
	public ComprehensiveTree getNodeByRef( ComprehensiveTree comprehensiveTree ){
		return (ComprehensiveTree)selectByPk("core.getNodeByRef", comprehensiveTree);
	}
	
	public void cutMyself(ComprehensiveTree p_OnlyCutMyselfFromJstree){
		update("core.cutMyselfPositionFix", p_OnlyCutMyselfFromJstree);
		update("core.cutMyselfLeftFix",     p_OnlyCutMyselfFromJstree);
		update("core.cutMyselfRightFix",    p_OnlyCutMyselfFromJstree);
	}
	
	public void stretchPositionForMyselfFromJstree( ComprehensiveTree comprehensiveTree ){
		update("core.stretchPositionForMyself", comprehensiveTree);
	}
	
	public void stretchLeftRightForMyselfFromJstree( ComprehensiveTree comprehensiveTree ){
		update("core.stretchLeftForMyselfFromJstree",  comprehensiveTree);
		update("core.stretchRightForMyselfFromJstree", comprehensiveTree);
	}
	
	public int pasteMyselfFromJstree(ComprehensiveTree p_OnlyPasteMyselfFromJstree){
		return (Integer)insert("core.pasteMyselfFromJstree", p_OnlyPasteMyselfFromJstree);
	}
	
	@SuppressWarnings("unchecked")
	public List<ComprehensiveTree> getChildNodeByLeftRight( ComprehensiveTree comprehensiveTree ){
		
		return list("core.getChildNodeByLeftRight", comprehensiveTree );
	}
	
	public void fixCopy(ComprehensiveTree comprehensiveTree){
		update("core.fixCopy", comprehensiveTree);
	}

	public void fixCopyIF( ComprehensiveTree comprehensiveTree ){
		update("core.fixCopyIF", comprehensiveTree);
	}
	
	public void enterMyselfFromJstree( ComprehensiveTree comprehensiveTree ){
		insert("core.enterMyselfFromJstree", comprehensiveTree);
	}
	
	public int addMyselfFromJstree( ComprehensiveTree comprehensiveTree ){
		return (Integer)insert("core.addMyselfFromJstree", comprehensiveTree);
	}
	
	public int alterNode( ComprehensiveTree comprehensiveTree ){
		return (Integer)update("core.alterNode", comprehensiveTree);
	}
	
	public int removeNode( ComprehensiveTree comprehensiveTree ){
		
		delete("core.removeNode",              comprehensiveTree);
		update("core.removedAfterLeftFix",     comprehensiveTree);
		delete("core.removedAfterRightFix",    comprehensiveTree);
		delete("core.removedAfterPositionFix", comprehensiveTree);
		
		return 0;
	}
	
	public int alterNodeType( ComprehensiveTree comprehensiveTree ){
		return (Integer)update("core.alterNodeType", comprehensiveTree);
	}
	
	public void stretchLeftForMyselfFromJstree( ComprehensiveTree comprehensiveTree ){
		update("core.stretchLeftForMyselfFromJstree", comprehensiveTree);
	}
	
	public void stretchRightForMyselfFromJstree( ComprehensiveTree comprehensiveTree ){
		update("core.stretchRightForMyselfFromJstree", comprehensiveTree);
	}
}