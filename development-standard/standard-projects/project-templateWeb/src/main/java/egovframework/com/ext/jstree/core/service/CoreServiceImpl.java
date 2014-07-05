package egovframework.com.ext.jstree.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import egovframework.com.ext.jstree.core.dao.CoreDAO;
import egovframework.com.ext.jstree.core.util.Util_SwapNode;
import egovframework.com.ext.jstree.core.vo.P_ComprehensiveTree;
import egovframework.com.ext.jstree.core.vo.T_ComprehensiveTree;

@Service("CoreService")
public class CoreServiceImpl implements CoreService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="CoreDAO")
	private CoreDAO coreDAO;
	
	
	public List<T_ComprehensiveTree> getChildNode(P_ComprehensiveTree p_ComprehensiveTree){
		
		return coreDAO.getChildNode( p_ComprehensiveTree );
	}
	
	
	public List<String> searchNode(P_ComprehensiveTree p_ComprehensiveTree) {
		
		List<T_ComprehensiveTree> t_SearchNodeByStrings   = new ArrayList<T_ComprehensiveTree>();
		List<P_ComprehensiveTree> p_SearchNodeByPositions = new ArrayList<P_ComprehensiveTree>();
		
		t_SearchNodeByStrings.addAll(coreDAO.searchNodeByString(p_ComprehensiveTree));

		for (T_ComprehensiveTree nodeByString : t_SearchNodeByStrings) {
			p_SearchNodeByPositions.add(Util_SwapNode.swapTtoP(nodeByString));
		}
		
		List<String> returnList = new ArrayList<String>();
		
		for( String rowData : coreDAO.searchNodeByPosition(p_SearchNodeByPositions) ){
			rowData = "#node_" + rowData;
			returnList.add(rowData);
		}
		return returnList;
	}
	
	@Transactional
	public T_ComprehensiveTree addNode(P_ComprehensiveTree p_ComprehensiveTree) {

		T_ComprehensiveTree nodeById  = coreDAO.getNode(     p_ComprehensiveTree);
		T_ComprehensiveTree nodeByRef = coreDAO.getNodeByRef(p_ComprehensiveTree);

		List<T_ComprehensiveTree> childNodesFromNodeByRef = coreDAO.getChildNode(Util_SwapNode.swapTtoP(nodeByRef));
		
		T_ComprehensiveTree t_ComprehensiveTree = new T_ComprehensiveTree();
		
		int spaceOfTargetNode = 2;
		Collection<Integer> c_idsByChildNodeFromNodeById = null;

		if (nodeById != null && p_ComprehensiveTree.getCopy() == 0) {
			this.cutMyself(nodeById, spaceOfTargetNode,	c_idsByChildNodeFromNodeById);
		}

		this.stretchPositionForMyselfFromJstree(
				c_idsByChildNodeFromNodeById, nodeById, p_ComprehensiveTree);

		int rightPositionFromNodeByRef = nodeByRef.getC_right();
		rightPositionFromNodeByRef = Math.max(rightPositionFromNodeByRef, 1);

		int self = ( nodeById != null
				  && !p_ComprehensiveTree.getCopyBooleanValue()
				  && nodeById.getC_parentid() == p_ComprehensiveTree.getRef() 
				  && p_ComprehensiveTree.getC_position() > nodeById.getC_position() ) ? 1 : 0;

		for (T_ComprehensiveTree child : childNodesFromNodeByRef) {
			
			if (child.getC_position() - self == p_ComprehensiveTree.getC_position()) {
				rightPositionFromNodeByRef = child.getC_left();
				break;
			}
		}

		if (nodeById != null && !p_ComprehensiveTree.getCopyBooleanValue()
				&& nodeById.getC_left() < rightPositionFromNodeByRef) {
			rightPositionFromNodeByRef -= spaceOfTargetNode;
		}

		this.stretchLeftRightForMyselfFromJstree( spaceOfTargetNode
				                                , rightPositionFromNodeByRef
				                                , p_ComprehensiveTree.getCopy()
				                                , c_idsByChildNodeFromNodeById );

		int targetNodeLevel = p_ComprehensiveTree.getRef() == 0 ? 0	: nodeByRef.getC_level() + 1;
		int comparePosition = rightPositionFromNodeByRef;
		
		if (nodeById != null) {

			targetNodeLevel = nodeById.getC_level()	- (nodeByRef.getC_level() + 1);
			comparePosition = nodeById.getC_left()	- rightPositionFromNodeByRef;
			
			if (p_ComprehensiveTree.getCopyBooleanValue()) {
				int ind = this.pasteMyselfFromJstree( p_ComprehensiveTree.getRef()
						                            , comparePosition
						                            , spaceOfTargetNode
						                            , targetNodeLevel
						                            , rightPositionFromNodeByRef
						                            , c_idsByChildNodeFromNodeById
						                            , nodeById );
				t_ComprehensiveTree.setId(ind);
				this.fixCopy( ind, p_ComprehensiveTree.getC_position() );
			} else {
				this.enterMyselfFromJstree( p_ComprehensiveTree.getRef()
						                  , p_ComprehensiveTree.getC_position()
						                  ,	p_ComprehensiveTree.getC_id()
						                  , comparePosition
						                  ,	targetNodeLevel
						                  , c_idsByChildNodeFromNodeById );
			}
		} else {
			p_ComprehensiveTree.setC_parentid(p_ComprehensiveTree.getRef());
			p_ComprehensiveTree.setC_left(comparePosition);
			p_ComprehensiveTree.setC_right(comparePosition + 1);
			p_ComprehensiveTree.setC_level(targetNodeLevel);

			int insertSeqResult = coreDAO.addMyselfFromJstree(p_ComprehensiveTree);

			t_ComprehensiveTree.setId(insertSeqResult);
			p_ComprehensiveTree.setC_id(insertSeqResult);
			int alterCountResult = coreDAO.alterNode(p_ComprehensiveTree);

			if (insertSeqResult > 0 && alterCountResult == 1) {
				t_ComprehensiveTree.setStatus(1);
			} else {
				throw new RuntimeException("심각한 오류 발생 - 삽입 노드");
			}
		}

		if (p_ComprehensiveTree.getCopyBooleanValue()) {
			this.fixCopy( p_ComprehensiveTree.getC_id(), p_ComprehensiveTree.getC_position() );
		}
		return t_ComprehensiveTree;
	}
	
	private void cutMyself( T_ComprehensiveTree nodeById
			              , int                 spaceOfTargetNode
			              , Collection<Integer> c_idsByChildNodeFromNodeById ) {

		P_ComprehensiveTree p_OnlyCutMyselfFromJstree = new P_ComprehensiveTree();
		p_OnlyCutMyselfFromJstree = Util_SwapNode.swapTtoP(nodeById);
		p_OnlyCutMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
		p_OnlyCutMyselfFromJstree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);

		coreDAO.cutMyself(p_OnlyCutMyselfFromJstree);
	}
	
	private void stretchPositionForMyselfFromJstree( Collection<Integer> c_idsByChildNodeFromNodeById
			                                       , T_ComprehensiveTree nodeById
			                                       , P_ComprehensiveTree p_ComprehensiveTree ) {
		
		p_ComprehensiveTree.setC_idsByChildNodeFromNodeById( c_idsByChildNodeFromNodeById );
		p_ComprehensiveTree.setNodeById( nodeById );

		coreDAO.stretchPositionForMyselfFromJstree( p_ComprehensiveTree );

	}
	
	private void stretchLeftRightForMyselfFromJstree( int spaceOfTargetNode
			                                        , int rightPositionFromNodeByRef
			                                        , int copy
			                                        , Collection<Integer> c_idsByChildNodeFromNodeById ) {

		P_ComprehensiveTree p_OnlyStretchLeftRightForMyselfFromJstree = new P_ComprehensiveTree();

		p_OnlyStretchLeftRightForMyselfFromJstree.setSpaceOfTargetNode(            spaceOfTargetNode            );
		p_OnlyStretchLeftRightForMyselfFromJstree.setRightPositionFromNodeByRef(   rightPositionFromNodeByRef   );
		p_OnlyStretchLeftRightForMyselfFromJstree.setC_idsByChildNodeFromNodeById( c_idsByChildNodeFromNodeById );
		p_OnlyStretchLeftRightForMyselfFromJstree.setCopy(copy);
		
		coreDAO.stretchLeftRightForMyselfFromJstree(p_OnlyStretchLeftRightForMyselfFromJstree);
	}
	
	private int pasteMyselfFromJstree( int ref
			                         , int idif
			                         , int spaceOfTargetNode
			                         , int ldif
			                         , int rightPositionFromNodeByRef
			                         , Collection<Integer> c_idsByChildNodeFromNodeById
			                         , T_ComprehensiveTree nodeById) {

		P_ComprehensiveTree p_OnlyPasteMyselfFromJstree = new P_ComprehensiveTree();

		p_OnlyPasteMyselfFromJstree.setRef(ref);
		p_OnlyPasteMyselfFromJstree.setIdif(idif);
		p_OnlyPasteMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
		p_OnlyPasteMyselfFromJstree.setLdif(ldif);
		p_OnlyPasteMyselfFromJstree.setC_idsByChildNodeFromNodeById( c_idsByChildNodeFromNodeById );
		p_OnlyPasteMyselfFromJstree.setRightPositionFromNodeByRef(   rightPositionFromNodeByRef   );
		p_OnlyPasteMyselfFromJstree.setNodeById(nodeById);

		p_OnlyPasteMyselfFromJstree.setIdifLeft( idif + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode	: 0) );
		p_OnlyPasteMyselfFromJstree.setIdifRight(idif + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode	: 0) );

		return coreDAO.pasteMyselfFromJstree(p_OnlyPasteMyselfFromJstree);
	}
	
	private void fixCopy( int ind, int ref ) {
		
		P_ComprehensiveTree p_ComprehensiveTree = new P_ComprehensiveTree();
		p_ComprehensiveTree.setC_id(ind);

		T_ComprehensiveTree node = coreDAO.getNode(p_ComprehensiveTree);

		List<T_ComprehensiveTree> children = coreDAO.getChildNodeByLeftRight(Util_SwapNode.swapTtoP(node));

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = node.getC_left() + 1; i < node.getC_right(); i++) {
			map.put(i, ind);
		}

		for (int i = 0; i < children.size(); i++) {

			T_ComprehensiveTree child = children.get(i);

			if (child.getC_id() == ind) {
				logger.debug(">>>>>>>>>>>>>>>>> 기준노드가 잡혔음.");
				logger.debug("C_TITLE    = " + child.getC_title());
				logger.debug("C_ID       = " + ind);
				logger.debug("C_POSITION = " + ref);
				
				P_ComprehensiveTree p_OnlyFixCopyFromJstree = new P_ComprehensiveTree();
				p_OnlyFixCopyFromJstree.setFixCopyId(ind);
				p_OnlyFixCopyFromJstree.setFixCopyPosition(ref);
				
				coreDAO.fixCopyIF(p_OnlyFixCopyFromJstree);
				continue;
			}
			logger.debug(">>>>>>>>>>>>>>>>> 기준노드 아래 있는 녀석임");
			logger.debug("C_TITLE    = " + child.getC_title());
			logger.debug("C_ID       = " + ind);
			logger.debug("C_POSITION = " + ref);
			logger.debug("부모아이디값 = " + map.get(child.getC_left()));
			
			child.setFixCopyId(map.get(child.getC_left()));
			
			coreDAO.fixCopy(child);
			
			for (int j = child.getC_left() + 1; j < child.getC_right(); j++) {
				map.put(j, child.getC_id());
			}
		}
	}
	
	private void enterMyselfFromJstree( int ref
			                          , int c_position
			                          , int c_id
			                          , int idif
			                          , int ldif
			                          , Collection<Integer> c_idsByChildNodeFromNodeById ) {

		P_ComprehensiveTree p_OnlyPasteMyselfFromJstree = new P_ComprehensiveTree();
		p_OnlyPasteMyselfFromJstree.setRef(ref);
		p_OnlyPasteMyselfFromJstree.setC_position(c_position);
		p_OnlyPasteMyselfFromJstree.setC_id(c_id);
		p_OnlyPasteMyselfFromJstree.setIdif(idif);
		p_OnlyPasteMyselfFromJstree.setLdif(ldif);
		p_OnlyPasteMyselfFromJstree.setC_idsByChildNodeFromNodeById( c_idsByChildNodeFromNodeById );

		coreDAO.enterMyselfFromJstree(p_OnlyPasteMyselfFromJstree);
	}
	
	
	@Transactional
	public int executeRemoveNode(P_ComprehensiveTree p_ComprehensiveTree) {
		
		P_ComprehensiveTree removeNode = Util_SwapNode.swapTtoP( coreDAO.getNode(p_ComprehensiveTree) );
		
		coreDAO.removeNode(removeNode);
		
		return 0;
	}
	
	
	public int alterNode(P_ComprehensiveTree p_ComprehensiveTree) {

		return coreDAO.alterNode(p_ComprehensiveTree);
	}
	
	
	@Transactional
	public int alterNodeType(P_ComprehensiveTree p_ComprehensiveTree) {

		List<T_ComprehensiveTree> childNodesFromNodeById = coreDAO.getChildNode(p_ComprehensiveTree);

		T_ComprehensiveTree nodeById = coreDAO.getNode(p_ComprehensiveTree);

		int returnStatus = 0;
		if (p_ComprehensiveTree.getC_type().equals("default")) {

			if (childNodesFromNodeById.size() > 0) {
				throw new RuntimeException("하위에 노드가 있는데 디폴트로 바꾸려고 함");

			} else {
				p_ComprehensiveTree.setC_type("default");
				int temp = coreDAO.alterNodeType(p_ComprehensiveTree);

				if (temp == 1) {
					returnStatus = 1;
				} else {
					throw new RuntimeException("여러개의 노드가 업데이트 되었음");
				}
			}
		} else {
			if (nodeById.getC_type().equals("folder")) {
				returnStatus = 1;
			} else {
				returnStatus = coreDAO.alterNodeType(p_ComprehensiveTree);
			}
		}
		return returnStatus;
	}
	
	
	@Transactional
	public T_ComprehensiveTree moveNode(P_ComprehensiveTree p_ComprehensiveTree) {

		T_ComprehensiveTree nodeById = coreDAO.getNode(p_ComprehensiveTree);
		List<T_ComprehensiveTree> childNodesFromNodeById = coreDAO.getChildNodeByLeftRight(Util_SwapNode.swapTtoP(nodeById));

		T_ComprehensiveTree nodeByRef = coreDAO.getNodeByRef(p_ComprehensiveTree);
		List<T_ComprehensiveTree> childNodesFromNodeByRef = coreDAO.getChildNode(Util_SwapNode.swapTtoP(nodeByRef));

		T_ComprehensiveTree t_ComprehensiveTree = new T_ComprehensiveTree();
		
		int spaceOfTargetNode = 2;
		Collection<Integer> c_idsByChildNodeFromNodeById = null;

		if (nodeById == null) {
			throw new RuntimeException("nodeById is null");
		} else {
			c_idsByChildNodeFromNodeById = CollectionUtils.collect(
					childNodesFromNodeById,
					new Transformer<T_ComprehensiveTree, Integer>() {
						@Override
						public Integer transform(
								T_ComprehensiveTree childNodePerNodeById) {
							return childNodePerNodeById.getC_id();
						}
					});

			if (c_idsByChildNodeFromNodeById.contains(p_ComprehensiveTree
					.getRef())) {
				throw new RuntimeException(
						"myself contains already refTargetNode");
			}

			spaceOfTargetNode = nodeById.getC_right()
					- nodeById.getC_left() + 1;
		}

		if (nodeById != null
				&& p_ComprehensiveTree.getCopyBooleanValue() == false) {
			this.cutMyself(nodeById, spaceOfTargetNode,
					c_idsByChildNodeFromNodeById);
		}

		calculatePostion(p_ComprehensiveTree, nodeById,
				childNodesFromNodeByRef);

		this.stretchPositionForMyselfFromJstree(
				c_idsByChildNodeFromNodeById, nodeById, p_ComprehensiveTree);

		int rightPositionFromNodeByRef = nodeByRef.getC_right();
		rightPositionFromNodeByRef = Math
				.max(rightPositionFromNodeByRef, 1);

		int self = (nodeById != null
				&& !p_ComprehensiveTree.getCopyBooleanValue()
				&& nodeById.getC_parentid() == p_ComprehensiveTree.getRef() && p_ComprehensiveTree
				.getC_position() > nodeById.getC_position()) ? 1 : 0;

		for (T_ComprehensiveTree child : childNodesFromNodeByRef) {
			if (child.getC_position() - self == p_ComprehensiveTree
					.getC_position()) {
				rightPositionFromNodeByRef = child.getC_left();
				break;
			}
		}

		if (nodeById != null && !p_ComprehensiveTree.getCopyBooleanValue()
				&& nodeById.getC_left() < rightPositionFromNodeByRef) {
			rightPositionFromNodeByRef -= spaceOfTargetNode;
		}

		this.stretchLeftRightForMyselfFromJstree(spaceOfTargetNode,
				rightPositionFromNodeByRef, c_idsByChildNodeFromNodeById,
				p_ComprehensiveTree.getCopy());

		logger.debug(">>>>>>>>>>>>>>>>>>>>"
				+ rightPositionFromNodeByRef);
		int targetNodeLevel = nodeById.getC_level()
				- (nodeByRef.getC_level() + 1);
		int comparePosition = nodeById.getC_left()
				- rightPositionFromNodeByRef;
		logger.debug(">>>>>>>>>>>>>>>>>>>>" + comparePosition);

		if (p_ComprehensiveTree.getCopyBooleanValue()) {

			int ind = this.pasteMyselfFromJstree( p_ComprehensiveTree.getRef()
					                            , comparePosition
					                            , spaceOfTargetNode
					                            , targetNodeLevel
					                            , c_idsByChildNodeFromNodeById
					                            , rightPositionFromNodeByRef
					                            , nodeById );
			t_ComprehensiveTree.setId(ind);
			this.fixCopy(ind, p_ComprehensiveTree.getC_position());

		} else {
			this.enterMyselfFromJstree( p_ComprehensiveTree.getRef()
					                  ,	p_ComprehensiveTree.getC_position()
					                  ,	p_ComprehensiveTree.getC_id()
					                  , comparePosition
					                  ,	targetNodeLevel
					                  , c_idsByChildNodeFromNodeById );

		}
		return t_ComprehensiveTree;
	}
	
	private void calculatePostion( P_ComprehensiveTree p_ComprehensiveTree
			                     , T_ComprehensiveTree nodeById
			                     , List<T_ComprehensiveTree> childNodesFromNodeByRef ) {

		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();

		if (p_ComprehensiveTree.getRef() == nodeById.getC_parentid()) {
			logger.debug(">>>>>>>>>>>>>>>이동할 노드가 내 부모안에서 움직일때");

			if (p_ComprehensiveTree.getMultiCounter() == 0) {
				logger.debug(">>>>>>>>>>>>>>>멀티 카운터가 0 일때");
				session.put("settedPosition",
						p_ComprehensiveTree.getC_position());

				if (p_ComprehensiveTree.getC_position() > nodeById
						.getC_position()) {
					logger.debug(">>>>>>>>>>>>>>>이동 할 노드가 현재보다 뒤일때");
					logger.debug("노드값=" + nodeById.getC_title());
					logger.debug("노드의 초기 위치값=" + nodeById.getC_position());
					logger.debug("노드의 요청받은 위치값="
							+ p_ComprehensiveTree.getC_position());
					logger.debug("노드의 요청받은 멀티카운터="
							+ p_ComprehensiveTree.getMultiCounter());

					if (p_ComprehensiveTree.getC_position() > childNodesFromNodeByRef
							.size()) {
						logger.debug("노드 이동시 폴더를 대상으로 했을때 생기는 버그 발생 ="
								+ p_ComprehensiveTree.getC_position());
						p_ComprehensiveTree
								.setC_position(childNodesFromNodeByRef.size());
					}
					p_ComprehensiveTree.setC_position(p_ComprehensiveTree
							.getC_position() - 1);

					logger.debug("노드의 최종 위치값="
							+ p_ComprehensiveTree.getC_position());
					session.put("settedPosition",
							p_ComprehensiveTree.getC_position());
				}

			} else {
				logger.debug(">>>>>>>>>>>>>>>멀티 카운터가 0 이 아닐때");
				logger.debug("노드값=" + nodeById.getC_title());
				logger.debug("노드의 초기 위치값=" + nodeById.getC_position());
				logger.debug("노드의 요청받은 위치값="
						+ p_ComprehensiveTree.getC_position());
				logger.debug("노드의 요청받은 멀티카운터="
						+ p_ComprehensiveTree.getMultiCounter());
				logger.debug("0번 노드의 위치값=" + session.get("settedPosition"));

				int increasePosition = 0;

				if ((Integer) session.get("settedPosition") < nodeById
						.getC_position()) {
					logger.debug(">>>>>>>>>>>>>>>멀티 노드의 위치가 0번 노드보다 뒤일때");
					increasePosition = (Integer) session.get("settedPosition") + 1;
				} else {
					logger.debug(">>>>>>>>>>>>>>>멀티 노드의 위치가 0번 노드보다 앞일때");
					increasePosition = (Integer) session.get("settedPosition");
				}
				session.put("settedPosition", increasePosition);

				p_ComprehensiveTree.setC_position(increasePosition);

				if (nodeById.getC_position() == p_ComprehensiveTree
						.getC_position()) {
					logger.debug(">>>>>>>>>>>>>>>원래 노드 위치값과 최종 계산된 노드의 위치값이 동일한 경우");
					session.put("settedPosition", increasePosition - 1);
				}
				logger.debug("노드의 최종 위치값="
						+ p_ComprehensiveTree.getC_position());
			}
		} else {
			logger.debug(">>>>>>>>>>>>>>>이동할 노드가 내 부모밖으로 움직일때");

			if (p_ComprehensiveTree.getMultiCounter() == 0) {
				logger.debug(">>>>>>>>>>>>>>>멀티 카운터가 0 일때");
				logger.debug("노드값=" + nodeById.getC_title());
				logger.debug("노드의 초기 위치값=" + nodeById.getC_position());
				logger.debug("노드의 요청받은 위치값="
						+ p_ComprehensiveTree.getC_position());
				logger.debug("노드의 요청받은 멀티카운터="
						+ p_ComprehensiveTree.getMultiCounter());
				p_ComprehensiveTree.setC_position(p_ComprehensiveTree
						.getC_position());
				logger.debug("노드의 최종 위치값="
						+ p_ComprehensiveTree.getC_position());
				session.put("settedPosition",
						p_ComprehensiveTree.getC_position());
			} else {
				logger.debug(">>>>>>>>>>>>>>>멀티 카운터가 0 이 아닐때");
				logger.debug("노드값=" + nodeById.getC_title());
				logger.debug("노드의 초기 위치값=" + nodeById.getC_position());
				logger.debug("노드의 요청받은 위치값="
						+ p_ComprehensiveTree.getC_position());
				logger.debug("노드의 요청받은 멀티카운터="
						+ p_ComprehensiveTree.getMultiCounter());

				int increasePosition = 0;
				increasePosition = (Integer) session.get("settedPosition") + 1;
				session.put("settedPosition", increasePosition);

				p_ComprehensiveTree.setC_position(increasePosition);
				logger.debug("노드의 최종 위치값="
						+ p_ComprehensiveTree.getC_position());
				session.put("settedPosition",
						p_ComprehensiveTree.getC_position());
			}
		}
	}
	
	private void stretchLeftRightForMyselfFromJstree( int spaceOfTargetNode
			                                        , int rightPositionFromNodeByRef
			                                        , Collection<Integer> c_idsByChildNodeFromNodeById
			                                        , int copy ) {

		P_ComprehensiveTree p_OnlyStretchLeftRightForMyselfFromJstree = new P_ComprehensiveTree();

		p_OnlyStretchLeftRightForMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
		p_OnlyStretchLeftRightForMyselfFromJstree.setRightPositionFromNodeByRef(rightPositionFromNodeByRef);
		p_OnlyStretchLeftRightForMyselfFromJstree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
		p_OnlyStretchLeftRightForMyselfFromJstree.setCopy(copy);
		
		coreDAO.stretchLeftForMyselfFromJstree( p_OnlyStretchLeftRightForMyselfFromJstree);
		coreDAO.stretchRightForMyselfFromJstree(p_OnlyStretchLeftRightForMyselfFromJstree);
	}
	
	private int pasteMyselfFromJstree( int ref
			                         , int idif
			                         , int spaceOfTargetNode
			                         , int ldif
			                         , Collection<Integer> c_idsByChildNodeFromNodeById
			                         , int rightPositionFromNodeByRef
			                         , T_ComprehensiveTree nodeById ) {

		P_ComprehensiveTree p_OnlyPasteMyselfFromJstree = new P_ComprehensiveTree();

		p_OnlyPasteMyselfFromJstree.setRef(ref);
		p_OnlyPasteMyselfFromJstree.setIdif(idif);
		p_OnlyPasteMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
		p_OnlyPasteMyselfFromJstree.setLdif(ldif);
		p_OnlyPasteMyselfFromJstree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
		p_OnlyPasteMyselfFromJstree.setRightPositionFromNodeByRef(rightPositionFromNodeByRef);
		p_OnlyPasteMyselfFromJstree.setNodeById(nodeById);

		p_OnlyPasteMyselfFromJstree.setIdifLeft( idif + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode : 0));
		p_OnlyPasteMyselfFromJstree.setIdifRight(idif + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode	: 0));

		return coreDAO.pasteMyselfFromJstree(p_OnlyPasteMyselfFromJstree);
	}
}