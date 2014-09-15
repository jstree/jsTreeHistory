package standard.mvc.component.business.menu.service;

import java.util.Collection;
import java.util.List;

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
        
//        MenuComprehensiveTree nodeById  = menuDao.getNode(menuComprehensiveTree);
//        MenuComprehensiveTree nodeByRef = menuDao.getNodeByRef(menuComprehensiveTree);
//
//        List<MenuComprehensiveTree> childNodesFromNodeByRef = menuDao.getChildNode(nodeByRef);
//        
//        MenuComprehensiveTree t_ComprehensiveTree = new MenuComprehensiveTree();
//        
//        int spaceOfTargetNode = 2;
//        Collection<Integer> c_idsByChildNodeFromNodeById = null;
//
//        if( nodeById != null && comprehensiveTree.getCopy() == 0 ) {
//            
//            this.cutMyself( nodeById, spaceOfTargetNode, c_idsByChildNodeFromNodeById );
//        }
//
//        this.stretchPositionForMyselfFromJstree( c_idsByChildNodeFromNodeById, nodeById, comprehensiveTree );
//
//        int rightPositionFromNodeByRef = nodeByRef.getC_right();
//        rightPositionFromNodeByRef = Math.max(rightPositionFromNodeByRef, 1);
//
//        int self = ( nodeById != null
//                  && !comprehensiveTree.getCopyBooleanValue()
//                  && nodeById.getC_parentid() == comprehensiveTree.getRef() 
//                  && comprehensiveTree.getC_position() > nodeById.getC_position() ) ? 1 : 0;
//
//        for (MenuComprehensiveTree child : childNodesFromNodeByRef) {
//            
//            if (child.getC_position() - self == comprehensiveTree.getC_position()) {
//                rightPositionFromNodeByRef = child.getC_left();
//                break;
//            }
//        }
//
//        if (nodeById != null && !comprehensiveTree.getCopyBooleanValue()
//                && nodeById.getC_left() < rightPositionFromNodeByRef) {
//            rightPositionFromNodeByRef -= spaceOfTargetNode;
//        }
//
//        this.stretchLeftRightForMyselfFromJstree( spaceOfTargetNode
//                                                , rightPositionFromNodeByRef
//                                                , comprehensiveTree.getCopy()
//                                                , c_idsByChildNodeFromNodeById );
//
//        int targetNodeLevel = comprehensiveTree.getRef() == 0 ? 0   : nodeByRef.getC_level() + 1;
//        int comparePosition = rightPositionFromNodeByRef;
//        
//        if (nodeById != null) {
//
//            targetNodeLevel = nodeById.getC_level() - (nodeByRef.getC_level() + 1);
//            comparePosition = nodeById.getC_left()  - rightPositionFromNodeByRef;
//            
//            if (comprehensiveTree.getCopyBooleanValue()) {
//                int ind = this.pasteMyselfFromJstree( comprehensiveTree.getRef()
//                                                    , comparePosition
//                                                    , spaceOfTargetNode
//                                                    , targetNodeLevel
//                                                    , rightPositionFromNodeByRef
//                                                    , c_idsByChildNodeFromNodeById
//                                                    , nodeById );
//                t_ComprehensiveTree.setId(ind);
//                this.fixCopy( ind, comprehensiveTree.getC_position() );
//            } else {
//                this.enterMyselfFromJstree( comprehensiveTree.getRef()
//                                          , comprehensiveTree.getC_position()
//                                          , comprehensiveTree.getC_id()
//                                          , comparePosition
//                                          , targetNodeLevel
//                                          , c_idsByChildNodeFromNodeById );
//            }
//        } else {
//            comprehensiveTree.setC_parentid(comprehensiveTree.getRef());
//            comprehensiveTree.setC_left(comparePosition);
//            comprehensiveTree.setC_right(comparePosition + 1);
//            comprehensiveTree.setC_level(targetNodeLevel);
//
//            int insertSeqResult = menuDao.addMyselfFromJstree(comprehensiveTree);
//
//            t_ComprehensiveTree.setId(insertSeqResult);
//            comprehensiveTree.setC_id(insertSeqResult);
//            int alterCountResult = menuDao.alterNode(comprehensiveTree);
//
//            if (insertSeqResult > 0 && alterCountResult == 1) {
//                t_ComprehensiveTree.setStatus(1);
//            } else {
//                throw new RuntimeException("심각한 오류 발생 - 삽입 노드");
//            }
//        }
//
//        if (comprehensiveTree.getCopyBooleanValue()) {
//            this.fixCopy( comprehensiveTree.getC_id(), comprehensiveTree.getC_position() );
//        }
//        return t_ComprehensiveTree;
        
        return null;
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
