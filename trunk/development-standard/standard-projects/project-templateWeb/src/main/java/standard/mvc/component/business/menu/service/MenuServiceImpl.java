package standard.mvc.component.business.menu.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import standard.mvc.component.business.menu.dao.MenuDao;
import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 이동민
 * @since 2014. 9. 05.
 * @version 1.0
 * @see <pre>
 *  Class Name  : MenuServiceImpl.java
 *  Description : Menu jstree Spring + iBatis 버젼의 서비스 구현체
 *  Infomation  : MenuService.java 를 구현한 클래스로 실제 작업이 이루어지는 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014. 9. 05.  이동민               최초 생성
 *  2014. 9. 15.  류강하               노드 추가 메서드 추가 및 주석
 *  2014. 9. 20.  류강하               노드 추가 관련 메서드 추가
 *  2014. 9. 21.  김대근               removeNode 메소드 추가
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service("MenuService")
public class MenuServiceImpl implements MenuService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="MenuDao")
	private MenuDao menuDao;
	
	@Override
	public List<MenuComprehensiveTree> getChildNode(MenuComprehensiveTree menuComprehensiveTree) {
		return menuDao.getChildNode(menuComprehensiveTree);
	}

    @Override
   public MenuComprehensiveTree addNode(MenuComprehensiveTree menuComprehensiveTree) {
        
        MenuComprehensiveTree nodeById = menuDao.getNode(menuComprehensiveTree);
        MenuComprehensiveTree nodeByRef = menuDao.getNodeByRef(menuComprehensiveTree);

        List<MenuComprehensiveTree> childNodesFromNodeByRef = menuDao.getChildNode(nodeByRef);
        
        MenuComprehensiveTree t_ComprehensiveTree = new MenuComprehensiveTree();
        
        int spaceOfTargetNode = 2;
        Collection<Integer> c_idsByChildNodeFromNodeById = null;

        if (nodeById != null && menuComprehensiveTree.getCopy() == 0) {
            this.cutMyself(nodeById, spaceOfTargetNode, c_idsByChildNodeFromNodeById);
        }

        this.stretchPositionForMyselfFromJstree(c_idsByChildNodeFromNodeById, nodeById, menuComprehensiveTree);

        int rightPositionFromNodeByRef = nodeByRef.getC_right();
        rightPositionFromNodeByRef = Math.max(rightPositionFromNodeByRef, 1);

        int self = ( nodeById != null
                  && !menuComprehensiveTree.getCopyBooleanValue()
                  && nodeById.getC_parentid() == menuComprehensiveTree.getRef() 
                  && menuComprehensiveTree.getC_position() > nodeById.getC_position() ) ? 1 : 0;

        for (MenuComprehensiveTree child : childNodesFromNodeByRef) {
            
            if (child.getC_position() - self == menuComprehensiveTree.getC_position()) {
                rightPositionFromNodeByRef = child.getC_left();
                break;
            }
        }

        if (nodeById != null && !menuComprehensiveTree.getCopyBooleanValue()
                && nodeById.getC_left() < rightPositionFromNodeByRef) {
            rightPositionFromNodeByRef -= spaceOfTargetNode;
        }

        this.stretchLeftRightForMyselfFromJstree( spaceOfTargetNode
                                                , rightPositionFromNodeByRef
                                                , menuComprehensiveTree.getCopy()
                                                , c_idsByChildNodeFromNodeById );

        int targetNodeLevel = menuComprehensiveTree.getRef() == 0 ? 0   : nodeByRef.getC_level() + 1;
        int comparePosition = rightPositionFromNodeByRef;
        
        if (nodeById != null) {

            targetNodeLevel = nodeById.getC_level() - (nodeByRef.getC_level() + 1);
            comparePosition = nodeById.getC_left()  - rightPositionFromNodeByRef;
            
            if (menuComprehensiveTree.getCopyBooleanValue()) {
                int ind = this.pasteMyselfFromJstree( menuComprehensiveTree.getRef()
                                                    , comparePosition
                                                    , spaceOfTargetNode
                                                    , targetNodeLevel
                                                    , rightPositionFromNodeByRef
                                                    , c_idsByChildNodeFromNodeById
                                                    , nodeById );
                t_ComprehensiveTree.setId(ind);
                this.fixCopy( ind, menuComprehensiveTree.getC_position() );
            } else {
                this.enterMyselfFromJstree( menuComprehensiveTree.getRef()
                                          , menuComprehensiveTree.getC_position()
                                          , menuComprehensiveTree.getC_id()
                                          , comparePosition
                                          , targetNodeLevel
                                          , c_idsByChildNodeFromNodeById );
            }
        } else {
            menuComprehensiveTree.setC_parentid(menuComprehensiveTree.getRef());
            menuComprehensiveTree.setC_left(comparePosition);
            menuComprehensiveTree.setC_right(comparePosition + 1);
            menuComprehensiveTree.setC_level(targetNodeLevel);

            int insertSeqResult = menuDao.addMyselfFromJstree(menuComprehensiveTree);

            t_ComprehensiveTree.setId(insertSeqResult);
            menuComprehensiveTree.setC_id(insertSeqResult);
            int alterCountResult = menuDao.alterNode(menuComprehensiveTree);

            if (insertSeqResult > 0 && alterCountResult == 1) {
                t_ComprehensiveTree.setStatus(1);
            } else {
                throw new RuntimeException("심각한 오류 발생 - 삽입 노드");
            }
        }

        if (menuComprehensiveTree.getCopyBooleanValue()) {
            this.fixCopy( menuComprehensiveTree.getC_id(), menuComprehensiveTree.getC_position() );
        }
        return t_ComprehensiveTree;
    }
	
    
    private void cutMyself(MenuComprehensiveTree nodeById, int spaceOfTargetNode,
            Collection<Integer> c_idsByChildNodeFromNodeById) {

        nodeById.setSpaceOfTargetNode(spaceOfTargetNode);
        nodeById.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);

        menuDao.cutMyself(nodeById);
    }
    
    private void stretchPositionForMyselfFromJstree(Collection<Integer> c_idsByChildNodeFromNodeById,
            MenuComprehensiveTree nodeById, MenuComprehensiveTree comprehensiveTree) {

        comprehensiveTree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
        comprehensiveTree.setNodeById(nodeById);

        menuDao.stretchPositionForMyselfFromJstree(comprehensiveTree);
    }
    
    private void stretchLeftRightForMyselfFromJstree(int spaceOfTargetNode, int rightPositionFromNodeByRef, int copy,
            Collection<Integer> c_idsByChildNodeFromNodeById) {
        
        MenuComprehensiveTree onlyStretchLeftRightForMyselfFromJstree = new MenuComprehensiveTree();
        
        onlyStretchLeftRightForMyselfFromJstree.setSpaceOfTargetNode(            spaceOfTargetNode            );
        onlyStretchLeftRightForMyselfFromJstree.setRightPositionFromNodeByRef(   rightPositionFromNodeByRef   );
        onlyStretchLeftRightForMyselfFromJstree.setC_idsByChildNodeFromNodeById( c_idsByChildNodeFromNodeById );
        onlyStretchLeftRightForMyselfFromJstree.setCopy(copy);
        
        menuDao.stretchLeftRightForMyselfFromJstree(onlyStretchLeftRightForMyselfFromJstree);
    }
    
    private int pasteMyselfFromJstree(int ref, int idif, int spaceOfTargetNode, int ldif, int rightPositionFromNodeByRef,
            Collection<Integer> c_idsByChildNodeFromNodeById, MenuComprehensiveTree nodeById) {

        MenuComprehensiveTree onlyPasteMyselfFromJstree = new MenuComprehensiveTree();
        
        onlyPasteMyselfFromJstree.setRef(ref);
        onlyPasteMyselfFromJstree.setIdif(idif);
        onlyPasteMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
        onlyPasteMyselfFromJstree.setLdif(ldif);
        onlyPasteMyselfFromJstree.setC_idsByChildNodeFromNodeById( c_idsByChildNodeFromNodeById );
        onlyPasteMyselfFromJstree.setRightPositionFromNodeByRef(   rightPositionFromNodeByRef   );
        onlyPasteMyselfFromJstree.setNodeById(nodeById);
        
        onlyPasteMyselfFromJstree.setIdifLeft( idif + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode   : 0) );
        onlyPasteMyselfFromJstree.setIdifRight(idif + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode   : 0) );
        
        return menuDao.pasteMyselfFromJstree(onlyPasteMyselfFromJstree);
    }   

    private void enterMyselfFromJstree(int ref, int c_position, int c_id, int idif, int ldif, 
            Collection<Integer> c_idsByChildNodeFromNodeById) {

        MenuComprehensiveTree onlyPasteMyselfFromJstree = new MenuComprehensiveTree();
        onlyPasteMyselfFromJstree.setRef(ref);
        onlyPasteMyselfFromJstree.setC_position(c_position);
        onlyPasteMyselfFromJstree.setC_id(c_id);
        onlyPasteMyselfFromJstree.setIdif(idif);
        onlyPasteMyselfFromJstree.setLdif(ldif);
        onlyPasteMyselfFromJstree.setC_idsByChildNodeFromNodeById( c_idsByChildNodeFromNodeById );

        menuDao.enterMyselfFromJstree(onlyPasteMyselfFromJstree);
    }  
    
    private void fixCopy(int ind, int ref) {
        
        MenuComprehensiveTree comprehensiveTree = new MenuComprehensiveTree();
        comprehensiveTree.setC_id(ind);

        MenuComprehensiveTree node = menuDao.getNode(comprehensiveTree);

        List<MenuComprehensiveTree> children = menuDao.getChildNodeByLeftRight(node);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = node.getC_left() + 1; i < node.getC_right(); i++) {
            map.put(i, ind);
        }

        for (int i = 0; i < children.size(); i++) {

            MenuComprehensiveTree child = children.get(i);

            if (child.getC_id() == ind) {
                logger.debug(">>>>>>>>>>>>>>>>> 기준노드가 잡혔음.");
                logger.debug("C_TITLE    = " + child.getC_title());
                logger.debug("C_ID       = " + ind);
                logger.debug("C_POSITION = " + ref);
                
                MenuComprehensiveTree onlyFixCopyFromJstree = new MenuComprehensiveTree();
                onlyFixCopyFromJstree.setFixCopyId(ind);
                onlyFixCopyFromJstree.setFixCopyPosition(ref);
                
                menuDao.fixCopyIF(onlyFixCopyFromJstree);
                continue;
            }
            logger.debug(">>>>>>>>>>>>>>>>> 기준노드 아래 있는 녀석임");
            logger.debug("C_TITLE    = " + child.getC_title());
            logger.debug("C_ID       = " + ind);
            logger.debug("C_POSITION = " + ref);
            logger.debug("부모아이디값 = " + map.get(child.getC_left()));
            
            child.setFixCopyId(map.get(child.getC_left()));
            
            menuDao.fixCopy(child);
            
            for (int j = child.getC_left() + 1; j < child.getC_right(); j++) {
                map.put(j, child.getC_id());
            }
        }
    }

	@Override
	public int removeNode(MenuComprehensiveTree menuComprehensiveTree) {
		MenuComprehensiveTree removeNode = menuDao.getNode(menuComprehensiveTree);
		
		int nSpaceOfTargetNode = removeNode.getC_right() - removeNode.getC_left() + 1;
		removeNode.setSpaceOfTargetNode(nSpaceOfTargetNode);
        
		return menuDao.removeNode(removeNode);
	}
    
  
    
    
    
    
    
    
//	@Override
//	public List<String> searchNode(MenuComprehensiveTree menuComprehensiveTree) {
//		
//		List<MenuComprehensiveTree> searchNodeByStrings = menuDao.searchNodeByString(menuComprehensiveTree);
//		List<String> rowDatas = menuDao.searchNodeByPosition(searchNodeByStrings);
//		
//		List<String> returnList = new ArrayList<String>();
//		
//		for( String rowData : rowDatas ){
//			rowData = "#node_" + rowData;
//			returnList.add(rowData);
//		}
//		return returnList;
//	}
}
