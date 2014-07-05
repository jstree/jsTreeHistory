package egovframework.com.ext.jstree.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.core.vo.P_ComprehensiveTree;
import egovframework.com.ext.jstree.core.vo.T_ComprehensiveTree;

@Repository("CoreDAO")
public class CoreDAO extends EgovComAbstractDAO {

	@SuppressWarnings("unchecked")
	public List<T_ComprehensiveTree> getChildNode(P_ComprehensiveTree p_ComprehensiveTree){
		
		return list("core.getChildNode", p_ComprehensiveTree );
	}

	
	@SuppressWarnings("unchecked")
	public List<T_ComprehensiveTree> searchNodeByString(P_ComprehensiveTree p_ComprehensiveTree){
		
		return list("core.searchNodeByString", p_ComprehensiveTree );
	}
	
	@SuppressWarnings("unchecked")
	public List<String> searchNodeByPosition(List<P_ComprehensiveTree> p_SearchNodeByPositions){
		
		return list("core.searchNodeByPosition", p_SearchNodeByPositions );
	}
	
	
	public T_ComprehensiveTree getNode(P_ComprehensiveTree p_ComprehensiveTree){
		return (T_ComprehensiveTree)selectByPk("core.getNode", p_ComprehensiveTree);
	}
	
	public T_ComprehensiveTree getNodeByRef(P_ComprehensiveTree p_ComprehensiveTree){
		return (T_ComprehensiveTree)selectByPk("core.getNodeByRef", p_ComprehensiveTree);
	}
	
	public void cutMyself(P_ComprehensiveTree p_OnlyCutMyselfFromJstree){
		update("core.cutMyselfPositionFix", p_OnlyCutMyselfFromJstree);
		update("core.cutMyselfLeftFix",     p_OnlyCutMyselfFromJstree);
		update("core.cutMyselfRightFix",    p_OnlyCutMyselfFromJstree);
	}
	
	public void stretchPositionForMyselfFromJstree(P_ComprehensiveTree p_ComprehensiveTree){
		update("core.stretchPositionForMyself", p_ComprehensiveTree);
	}
	
	public void stretchLeftRightForMyselfFromJstree(P_ComprehensiveTree p_ComprehensiveTree){
		update("core.stretchLeftForMyselfFromJstree",  p_ComprehensiveTree);
		update("core.stretchRightForMyselfFromJstree", p_ComprehensiveTree);
	}
	
	public int pasteMyselfFromJstree(P_ComprehensiveTree p_OnlyPasteMyselfFromJstree){
		return (Integer)insert("core.pasteMyselfFromJstree", p_OnlyPasteMyselfFromJstree);
	}
	
	@SuppressWarnings("unchecked")
	public List<T_ComprehensiveTree> getChildNodeByLeftRight(P_ComprehensiveTree p_ComprehensiveTree){
		
		return list("core.getChildNodeByLeftRight", p_ComprehensiveTree );
	}
	
	public void fixCopy(T_ComprehensiveTree t_ComprehensiveTree){
		update("core.fixCopy", t_ComprehensiveTree);
	}

	public void fixCopyIF(P_ComprehensiveTree p_ComprehensiveTree){
		update("core.fixCopyIF", p_ComprehensiveTree);
	}
	
	public void enterMyselfFromJstree(P_ComprehensiveTree p_ComprehensiveTree){
		insert("core.enterMyselfFromJstree", p_ComprehensiveTree);
	}
	
	public int addMyselfFromJstree(P_ComprehensiveTree p_ComprehensiveTree){
		return (Integer)insert("core.addMyselfFromJstree", p_ComprehensiveTree);
	}
	
	public int alterNode(P_ComprehensiveTree p_ComprehensiveTree){
		return (Integer)update("core.alterNode", p_ComprehensiveTree);
	}
	
	public int removeNode(P_ComprehensiveTree p_ComprehensiveTree){
		
		delete("core.removeNode",              p_ComprehensiveTree);
		update("core.removedAfterLeftFix",     p_ComprehensiveTree);
		delete("core.removedAfterRightFix",    p_ComprehensiveTree);
		delete("core.removedAfterPositionFix", p_ComprehensiveTree);
		
		return 0;
	}
	
	public int alterNodeType(P_ComprehensiveTree p_ComprehensiveTree){
		return (Integer)update("core.alterNodeType", p_ComprehensiveTree);
	}
	
	public void stretchLeftForMyselfFromJstree(P_ComprehensiveTree p_ComprehensiveTree){
		update("core.stretchLeftForMyselfFromJstree", p_ComprehensiveTree);
	}
	
	public void stretchRightForMyselfFromJstree(P_ComprehensiveTree p_ComprehensiveTree){
		update("core.stretchRightForMyselfFromJstree", p_ComprehensiveTree);
	}
}