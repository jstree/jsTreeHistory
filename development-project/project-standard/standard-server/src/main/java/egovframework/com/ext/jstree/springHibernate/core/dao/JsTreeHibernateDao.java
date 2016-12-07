package egovframework.com.ext.jstree.springHibernate.core.dao;

import java.util.List;

import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateBaseDTO;


public interface JsTreeHibernateDao{
	
	/**
	 * 자식노드를 요청한다.
	 * 
	 * @param T_JsTree
	 * @return List<T_JsTree>
	 */
	public <T extends JsTreeHibernateBaseDTO> List<T> getChildNode( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> List<T> searchNodeByString( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> List<String> searchNodeByPosition(List<T> searchNodeByPositions) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> T getNode( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> T getNodeByRef( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> int getChildCountByParentId( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> void cutMyself(T p_OnlyCutMyselfFromJstree) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> void stretchPositionForMyselfFromJstree( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> void stretchLeftRightForMyselfFromJstree( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> int pasteMyselfFromJstree(T p_OnlyPasteMyselfFromJstree) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> List<T> getChildNodeByLeftRight( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> void fixCopy(T T_JsTree) throws Exception;

	public <T extends JsTreeHibernateBaseDTO> void fixCopyIF( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> void enterMyselfFromJstree( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> int addMyselfFromJstree( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> int alterNode( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> int removeNode( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> int alterNodeType( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> void enterMyselfFixPosition( T T_JsTree ) throws Exception;
	
	public <T extends JsTreeHibernateBaseDTO> void enterMyselfFixLeftRight( T T_JsTree ) throws Exception;

	public <T extends JsTreeHibernateBaseDTO> int getCountOfDescendantNodes( T T_JsTree );
    
	/**
	 * Root node를 제외한 노드들 중 페이징 처리된 노드들을 조회한다.
	 * 
	 * @param T_JsTree
	 * @return
	 */
    public <T extends JsTreeHibernateBaseDTO> List<T> getDescendantNodesPaginated(T T_JsTree);
}
