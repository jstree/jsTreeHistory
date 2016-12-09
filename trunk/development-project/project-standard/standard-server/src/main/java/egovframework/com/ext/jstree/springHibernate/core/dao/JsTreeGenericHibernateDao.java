package egovframework.com.ext.jstree.springHibernate.core.dao;

import java.io.Serializable;
import java.util.List;

import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateDTO;

@SuppressWarnings("hiding")
public interface JsTreeGenericHibernateDao<T extends Serializable> {

	public <T extends JsTreeHibernateDTO> List<T> getChildNode( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> List<T> searchNodeByString( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> List<String> searchNodeByPosition(List<T> searchNodeByPositions) throws Exception;
	
	public <T extends JsTreeHibernateDTO> T getNode( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> T getNodeByRef( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> int getChildCountByParentId( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> void cutMyself(T p_OnlyCutMyselfFromJstree) throws Exception;
	
	public <T extends JsTreeHibernateDTO> void stretchPositionForMyselfFromJstree( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> void stretchLeftRightForMyselfFromJstree( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> int pasteMyselfFromJstree(T p_OnlyPasteMyselfFromJstree) throws Exception;
	
	public <T extends JsTreeHibernateDTO> List<T> getChildNodeByLeftRight( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> void fixCopy(T jsTreeHibernateDTO) throws Exception;

	public <T extends JsTreeHibernateDTO> void fixCopyIF( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> void enterMyselfFromJstree( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> int addMyselfFromJstree( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> int alterNode( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> int removeNode( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> int alterNodeType( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> void enterMyselfFixPosition( T jsTreeHibernateDTO ) throws Exception;
	
	public <T extends JsTreeHibernateDTO> void enterMyselfFixLeftRight( T jsTreeHibernateDTO ) throws Exception;

	public <T extends JsTreeHibernateDTO> int getCountOfDescendantNodes( T jsTreeHibernateDTO );
    
    public <T extends JsTreeHibernateDTO> List<T> getDescendantNodesPaginated(T jsTreeHibernateDTO);
}
