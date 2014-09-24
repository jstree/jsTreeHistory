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
	public <T extends ComprehensiveTree> List<T> getChildNode( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> List<T> searchNodeByString( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> List<String> searchNodeByPosition(List<T> searchNodeByPositions);
	
	public <T extends ComprehensiveTree> T getNode( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> T getNodeByRef( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> void cutMyself(T p_OnlyCutMyselfFromJstree);
	
	public <T extends ComprehensiveTree> void stretchPositionForMyselfFromJstree( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> void stretchLeftRightForMyselfFromJstree( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> int pasteMyselfFromJstree(T p_OnlyPasteMyselfFromJstree);
	
	public <T extends ComprehensiveTree> List<T> getChildNodeByLeftRight( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> void fixCopy(T comprehensiveTree);

	public <T extends ComprehensiveTree> void fixCopyIF( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> void enterMyselfFromJstree( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> int addMyselfFromJstree( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> int alterNode( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> int removeNode( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> int alterNodeType( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> void stretchLeftForMyselfFromJstree( T comprehensiveTree );
	
	public <T extends ComprehensiveTree> void stretchRightForMyselfFromJstree( T comprehensiveTree );
}
