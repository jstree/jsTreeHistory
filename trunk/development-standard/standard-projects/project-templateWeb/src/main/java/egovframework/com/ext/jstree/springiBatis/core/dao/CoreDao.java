package egovframework.com.ext.jstree.springiBatis.core.dao;

import java.util.List;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public interface CoreDao {

	/**
	 * 자식노드를 요청한다.
	 * 
	 * @param comprehensiveTree
	 * @return List<ComprehensiveTree>
	 */
	public List<ComprehensiveTree> getChildNode( ComprehensiveTree comprehensiveTree );
	
	public List<ComprehensiveTree> searchNodeByString( ComprehensiveTree comprehensiveTree );
	
	public List<String> searchNodeByPosition(List<ComprehensiveTree> searchNodeByPositions);
	
	public ComprehensiveTree getNode( ComprehensiveTree comprehensiveTree );
	
	public ComprehensiveTree getNodeByRef( ComprehensiveTree comprehensiveTree );
	
	public void cutMyself(ComprehensiveTree p_OnlyCutMyselfFromJstree);
	
	public void stretchPositionForMyselfFromJstree( ComprehensiveTree comprehensiveTree );
	
	public void stretchLeftRightForMyselfFromJstree( ComprehensiveTree comprehensiveTree );
	
	public int pasteMyselfFromJstree(ComprehensiveTree p_OnlyPasteMyselfFromJstree);
	
	public List<ComprehensiveTree> getChildNodeByLeftRight( ComprehensiveTree comprehensiveTree );
	
	public void fixCopy(ComprehensiveTree comprehensiveTree);

	public void fixCopyIF( ComprehensiveTree comprehensiveTree );
	
	public void enterMyselfFromJstree( ComprehensiveTree comprehensiveTree );
	
	public int addMyselfFromJstree( ComprehensiveTree comprehensiveTree );
	
	public int alterNode( ComprehensiveTree comprehensiveTree );
	
	public int removeNode( ComprehensiveTree comprehensiveTree );
	
	public int alterNodeType( ComprehensiveTree comprehensiveTree );
	
	public void stretchLeftForMyselfFromJstree( ComprehensiveTree comprehensiveTree );
	
	public void stretchRightForMyselfFromJstree( ComprehensiveTree comprehensiveTree );
}
