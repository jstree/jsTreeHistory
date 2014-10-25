package egovframework.com.ext.jstree.springiBatis.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 이동민
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
 *  2014. 7. 31.      이동민         최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Repository("CoreDao")
public class CoreDaoImpl extends EgovComAbstractDAO implements CoreDao{

	@SuppressWarnings("unchecked")
	public <T extends ComprehensiveTree> List<T> getChildNode( T comprehensiveTree ) throws Exception{
		
		return list(comprehensiveTree.getSqlMapSelector() + "." + "getChildNode", comprehensiveTree );
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ComprehensiveTree> List<T> searchNodeByString( T comprehensiveTree ) throws Exception{
		
		return list(comprehensiveTree.getSqlMapSelector() + "." + "searchNodeByString", comprehensiveTree );
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ComprehensiveTree>List<String> searchNodeByPosition(List<T> searchNodeByPositions) throws Exception{
		//TODO: searchNodeByPositions 는 최소 1개 이상이어야 한다.
		return list(searchNodeByPositions.get(0).getSqlMapSelector() + "." + "searchNodeByPosition", searchNodeByPositions );
	}
	
	
	@SuppressWarnings("unchecked")
	public <T extends ComprehensiveTree> T getNode( T comprehensiveTree ) throws Exception{
		return ((T)selectByPk(comprehensiveTree.getSqlMapSelector() + "." + "getNode", comprehensiveTree));
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ComprehensiveTree> T getNodeByRef( T comprehensiveTree ) throws Exception{
		return ((T)selectByPk(comprehensiveTree.getSqlMapSelector() + "." + "getNodeByRef", comprehensiveTree));
	}
	
	public <T extends ComprehensiveTree> void cutMyself(T p_OnlyCutMyselfFromJstree) throws Exception{
		update(p_OnlyCutMyselfFromJstree.getSqlMapSelector() + "." + "cutMyselfPositionFix", p_OnlyCutMyselfFromJstree);
		update(p_OnlyCutMyselfFromJstree.getSqlMapSelector() + "." + "cutMyselfLeftFix",     p_OnlyCutMyselfFromJstree);
		update(p_OnlyCutMyselfFromJstree.getSqlMapSelector() + "." + "cutMyselfRightFix",    p_OnlyCutMyselfFromJstree);
	}
	
	public <T extends ComprehensiveTree>void stretchPositionForMyselfFromJstree( T comprehensiveTree ) throws Exception{
		update(comprehensiveTree.getSqlMapSelector() + "." + "stretchPositionForMyself", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> void stretchLeftRightForMyselfFromJstree( T comprehensiveTree ) throws Exception{
		update(comprehensiveTree.getSqlMapSelector() + "." + "stretchLeftForMyselfFromJstree",  comprehensiveTree);
		update(comprehensiveTree.getSqlMapSelector() + "." + "stretchRightForMyselfFromJstree", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> int pasteMyselfFromJstree(T p_OnlyPasteMyselfFromJstree) throws Exception{
		return (Integer)insert(p_OnlyPasteMyselfFromJstree.getSqlMapSelector() + "." + "pasteMyselfFromJstree", p_OnlyPasteMyselfFromJstree);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ComprehensiveTree> List<T> getChildNodeByLeftRight( T comprehensiveTree ) throws Exception{
		
		return list(comprehensiveTree.getSqlMapSelector() + "." + "getChildNodeByLeftRight", comprehensiveTree );
	}
	
	public <T extends ComprehensiveTree> void fixCopy( T comprehensiveTree) throws Exception{
		update(comprehensiveTree.getSqlMapSelector() + "." + "fixCopy", comprehensiveTree);
	}

	public <T extends ComprehensiveTree> void fixCopyIF( T comprehensiveTree ) throws Exception{
		update(comprehensiveTree.getSqlMapSelector() + "." + "fixCopyIF", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> void enterMyselfFromJstree( T comprehensiveTree ) throws Exception{
		insert(comprehensiveTree.getSqlMapSelector() + "." + "enterMyselfFromJstree", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> int addMyselfFromJstree( T comprehensiveTree ) throws Exception{
		return (Integer)insert(comprehensiveTree.getSqlMapSelector() + "." + "addMyselfFromJstree", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> int alterNode( T comprehensiveTree ) throws Exception{
		return (Integer)update(comprehensiveTree.getSqlMapSelector() + "." + "alterNode", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> int removeNode( T comprehensiveTree ) throws Exception{
		
		delete(comprehensiveTree.getSqlMapSelector() + "." + "removeNode",              comprehensiveTree);
		update(comprehensiveTree.getSqlMapSelector() + "." + "removedAfterLeftFix",     comprehensiveTree);
		delete(comprehensiveTree.getSqlMapSelector() + "." + "removedAfterRightFix",    comprehensiveTree);
		delete(comprehensiveTree.getSqlMapSelector() + "." + "removedAfterPositionFix", comprehensiveTree);
		
		return 0;
	}
	
	public <T extends ComprehensiveTree> int alterNodeType( T comprehensiveTree ) throws Exception{
		return (Integer)update(comprehensiveTree.getSqlMapSelector() + "." + "alterNodeType", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> void stretchLeftForMyselfFromJstree( T comprehensiveTree ) throws Exception{
		update(comprehensiveTree.getSqlMapSelector() + "." + "stretchLeftForMyselfFromJstree", comprehensiveTree);
	}
	
	public <T extends ComprehensiveTree> void stretchRightForMyselfFromJstree( T comprehensiveTree ) throws Exception{
		update(comprehensiveTree.getSqlMapSelector() + "." + "stretchRightForMyselfFromJstree", comprehensiveTree);
	}
}