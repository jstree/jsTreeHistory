package egovframework.com.ext.jstree.springiBatis.core.service;

import java.lang.reflect.Method;
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

import standard.mvc.component.base.exception.GenericServiceRuntimeException;

import com.opensymphony.xwork2.ActionContext;

import egovframework.com.ext.jstree.springiBatis.core.annotation.ExecutionSwitching;
import egovframework.com.ext.jstree.springiBatis.core.constant.ExecutionOrder;
import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author ?
 * @since 2014. 7. 31.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: CoreServiceImpl.java
 * 	Description : jstree Spring + iBatis 버젼의 서비스 구현체
 * 	Infomation	: CoreService.java 를 구현한 클래스 로 실제 작업이 이루어지는 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014. 7. 31.      ?        최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service("CoreService")
public class CoreServiceImpl implements CoreService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="CoreDAO")
	private CoreDao coreDAO;
	
	/* (non-Javadoc)
	 * @see egovframework.com.ext.jstree.springiBatis.core.service.CoreService#getChildNode(egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
	 */
	public <T extends ComprehensiveTree> List<T> getChildNode( T comprehensiveTree, CoreCallBackService coreCallBackService ){
		
		try {
			Class<? extends CoreCallBackService> clazz = coreCallBackService.getClass();
			if (clazz.isAnnotationPresent(ExecutionSwitching.class)) {
				String order = clazz.getAnnotation(ExecutionSwitching.class).order();

//				무한루프 발생. 수정중
				if (ExecutionOrder.AROUND.value().equals(order)) {
//					Method before = clazz.getMethod(order, ComprehensiveTree.class);
//					before.invoke(coreCallBackService, comprehensiveTree);
//					
//					if (!coreCallBackService.excute(comprehensiveTree)) {
//						throw new RuntimeException();
//					}
//
//					List<T> childNode = (List<T>) coreDAO.getChildNode(comprehensiveTree);
//					
//					Method after = clazz.getMethod(order, ComprehensiveTree.class);
//					after.invoke(coreCallBackService, comprehensiveTree);
//					
//					return childNode;
				}
				
//				로그가 두번씩 찍힘
//				감시절처리에 문제가 없는 지 확인 필요
				if (ExecutionOrder.BEFORE.value().equals(order)) {
					Method method = clazz.getMethod(order, ComprehensiveTree.class);
					method.invoke(coreCallBackService, comprehensiveTree);
				}

				if (!coreCallBackService.excute(comprehensiveTree)) {
					throw new RuntimeException();
				}

				List<T> childNode = (List<T>) coreDAO.getChildNode(comprehensiveTree);

				if (ExecutionOrder.AFTER.value().equals(order)) {
					Method method = clazz.getMethod(order, ComprehensiveTree.class);
					method.invoke(coreCallBackService, comprehensiveTree);
				}

				return childNode;
			}
		} catch (Exception e) {
			throw new GenericServiceRuntimeException(e.getMessage(), e);
		}
		
		if( ! coreCallBackService.excute(comprehensiveTree) ){
			throw new RuntimeException();
		}
		
		List<T> childNode = (List<T>) coreDAO.getChildNode(comprehensiveTree);
		
		return childNode;
	}
	
	
	/* (non-Javadoc)
	 * @see egovframework.com.ext.jstree.springiBatis.core.service.CoreService#searchNode(egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
	 */
	public <T extends ComprehensiveTree> List<String> searchNode( T comprehensiveTree, CoreCallBackService coreCallBackService ) {
		
		List<T> searchNodeByStrings = (List<T>) coreDAO.searchNodeByString( comprehensiveTree );
		
		if(searchNodeByStrings.isEmpty()){
			return new ArrayList<String>();
		}else{
			List<String> rowDatas   = coreDAO.searchNodeByPosition( searchNodeByStrings );
			List<String> returnList = new ArrayList<String>();
			
			for( String rowData : rowDatas ){
				rowData = "#node_" + rowData;
				returnList.add(rowData);
			}
			return returnList;
		}
		
	}
	
	/* (non-Javadoc)
	 * @see egovframework.com.ext.jstree.springiBatis.core.service.CoreService#addNode(egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
	 */
	@SuppressWarnings({ "null" })
	@Transactional
	public <T extends ComprehensiveTree> T addNode( T comprehensiveTree, CoreCallBackService coreCallBackService ) throws InstantiationException, IllegalAccessException {

		T nodeById  = ((T) coreDAO.getNode(      comprehensiveTree ));
		T nodeByRef = ((T) coreDAO.getNodeByRef( comprehensiveTree ));

		List<T> childNodesFromNodeByRef = ((List<T>) coreDAO.getChildNode( nodeByRef ));
		
		Class<T> target = null;
		T t_ComprehensiveTree = target.newInstance();
		
		int spaceOfTargetNode = 2;
		Collection<Integer> c_idsByChildNodeFromNodeById = null;

		if( nodeById != null && comprehensiveTree.getCopy() == 0 ) {
			
			this.cutMyself( nodeById, spaceOfTargetNode, c_idsByChildNodeFromNodeById );
		}

		this.stretchPositionForMyselfFromJstree( c_idsByChildNodeFromNodeById, nodeById, comprehensiveTree );

		int rightPositionFromNodeByRef = nodeByRef.getC_right();
		rightPositionFromNodeByRef = Math.max(rightPositionFromNodeByRef, 1);

		int self = ( nodeById != null
				  && !comprehensiveTree.getCopyBooleanValue()
				  && nodeById.getC_parentid() == comprehensiveTree.getRef() 
				  && comprehensiveTree.getC_position() > nodeById.getC_position() ) ? 1 : 0;

		for (T child : childNodesFromNodeByRef) {
			
			if (child.getC_position() - self == comprehensiveTree.getC_position()) {
				rightPositionFromNodeByRef = child.getC_left();
				break;
			}
		}

		if (nodeById != null && !comprehensiveTree.getCopyBooleanValue()
				&& nodeById.getC_left() < rightPositionFromNodeByRef) {
			rightPositionFromNodeByRef -= spaceOfTargetNode;
		}

		this.stretchLeftRightForMyselfFromJstree( spaceOfTargetNode
				                                , rightPositionFromNodeByRef
				                                , comprehensiveTree.getCopy()
				                                , c_idsByChildNodeFromNodeById );

		int targetNodeLevel = comprehensiveTree.getRef() == 0 ? 0	: nodeByRef.getC_level() + 1;
		int comparePosition = rightPositionFromNodeByRef;
		
		if (nodeById != null) {

			targetNodeLevel = nodeById.getC_level()	- (nodeByRef.getC_level() + 1);
			comparePosition = nodeById.getC_left()	- rightPositionFromNodeByRef;
			
			if (comprehensiveTree.getCopyBooleanValue()) {
				int ind = this.pasteMyselfFromJstree( comprehensiveTree.getRef()
						                            , comparePosition
						                            , spaceOfTargetNode
						                            , targetNodeLevel
						                            , rightPositionFromNodeByRef
						                            , c_idsByChildNodeFromNodeById
						                            , nodeById );
				t_ComprehensiveTree.setId(ind);
				this.fixCopy( ind, comprehensiveTree.getC_position() );
			} else {
				this.enterMyselfFromJstree( comprehensiveTree.getRef()
						                  , comprehensiveTree.getC_position()
						                  ,	comprehensiveTree.getC_id()
						                  , comparePosition
						                  ,	targetNodeLevel
						                  , c_idsByChildNodeFromNodeById );
			}
		} else {
			comprehensiveTree.setC_parentid(comprehensiveTree.getRef());
			comprehensiveTree.setC_left(comparePosition);
			comprehensiveTree.setC_right(comparePosition + 1);
			comprehensiveTree.setC_level(targetNodeLevel);

			int insertSeqResult = coreDAO.addMyselfFromJstree(comprehensiveTree);

			t_ComprehensiveTree.setId(insertSeqResult);
			comprehensiveTree.setC_id(insertSeqResult);
			int alterCountResult = coreDAO.alterNode(comprehensiveTree);

			if (insertSeqResult > 0 && alterCountResult == 1) {
				t_ComprehensiveTree.setStatus(1);
			} else {
				throw new RuntimeException("심각한 오류 발생 - 삽입 노드");
			}
		}

		if (comprehensiveTree.getCopyBooleanValue()) {
			this.fixCopy( comprehensiveTree.getC_id(), comprehensiveTree.getC_position() );
		}
		return t_ComprehensiveTree;
	}
	
	private <T extends ComprehensiveTree> void cutMyself( T   nodeById
			              , int                 spaceOfTargetNode
			              , Collection<Integer> c_idsByChildNodeFromNodeById ) {

		nodeById.setSpaceOfTargetNode(spaceOfTargetNode);
		nodeById.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);

		coreDAO.cutMyself(nodeById);
	}
	
	private <T extends ComprehensiveTree> void stretchPositionForMyselfFromJstree( Collection<Integer> c_idsByChildNodeFromNodeById
			                                       , T   nodeById
			                                       , T   comprehensiveTree ) {
		
		comprehensiveTree.setC_idsByChildNodeFromNodeById( c_idsByChildNodeFromNodeById );
		comprehensiveTree.setNodeById( nodeById );

		coreDAO.stretchPositionForMyselfFromJstree( comprehensiveTree );
	}
	
	@SuppressWarnings("null")
	private <T extends ComprehensiveTree> void stretchLeftRightForMyselfFromJstree( int spaceOfTargetNode
			                                        , int rightPositionFromNodeByRef
			                                        , int copy
			                                        , Collection<Integer> c_idsByChildNodeFromNodeById ) throws InstantiationException, IllegalAccessException {
		Class<T> target = null;
		T onlyStretchLeftRightForMyselfFromJstree = target.newInstance();

		onlyStretchLeftRightForMyselfFromJstree.setSpaceOfTargetNode(            spaceOfTargetNode            );
		onlyStretchLeftRightForMyselfFromJstree.setRightPositionFromNodeByRef(   rightPositionFromNodeByRef   );
		onlyStretchLeftRightForMyselfFromJstree.setC_idsByChildNodeFromNodeById( c_idsByChildNodeFromNodeById );
		onlyStretchLeftRightForMyselfFromJstree.setCopy(copy);
		
		coreDAO.stretchLeftRightForMyselfFromJstree(onlyStretchLeftRightForMyselfFromJstree);
	}
	
	@SuppressWarnings("null")
	private <T extends ComprehensiveTree> int pasteMyselfFromJstree( int ref
			                         , int idif
			                         , int spaceOfTargetNode
			                         , int ldif
			                         , int rightPositionFromNodeByRef
			                         , Collection<Integer> c_idsByChildNodeFromNodeById
			                         , T   nodeById) throws InstantiationException, IllegalAccessException {

		Class<T> target = null;
		T onlyPasteMyselfFromJstree = target.newInstance();

		onlyPasteMyselfFromJstree.setRef(ref);
		onlyPasteMyselfFromJstree.setIdif(idif);
		onlyPasteMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
		onlyPasteMyselfFromJstree.setLdif(ldif);
		onlyPasteMyselfFromJstree.setC_idsByChildNodeFromNodeById( c_idsByChildNodeFromNodeById );
		onlyPasteMyselfFromJstree.setRightPositionFromNodeByRef(   rightPositionFromNodeByRef   );
		onlyPasteMyselfFromJstree.setNodeById(nodeById);

		onlyPasteMyselfFromJstree.setIdifLeft( idif + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode	: 0) );
		onlyPasteMyselfFromJstree.setIdifRight(idif + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode	: 0) );

		return coreDAO.pasteMyselfFromJstree(onlyPasteMyselfFromJstree);
	}
	
	@SuppressWarnings({ "null" })
	private <T extends ComprehensiveTree> void fixCopy( int ind, int ref ) throws InstantiationException, IllegalAccessException {
		
		Class<T> target = null;
		T comprehensiveTree = target.newInstance();
		comprehensiveTree.setC_id(ind);

		T node = ((T) coreDAO.getNode(comprehensiveTree));

		List<T> children = ((List<T>) coreDAO.getChildNodeByLeftRight(node));

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = node.getC_left() + 1; i < node.getC_right(); i++) {
			map.put(i, ind);
		}

		for (int i = 0; i < children.size(); i++) {

			T child = children.get(i);

			if (child.getC_id() == ind) {
				logger.debug(">>>>>>>>>>>>>>>>> 기준노드가 잡혔음.");
				logger.debug("C_TITLE    = " + child.getC_title());
				logger.debug("C_ID       = " + ind);
				logger.debug("C_POSITION = " + ref);
				
				Class<T> targetTemp = null;
				T onlyFixCopyFromJstree = targetTemp.newInstance();
				onlyFixCopyFromJstree.setFixCopyId(ind);
				onlyFixCopyFromJstree.setFixCopyPosition(ref);
				
				coreDAO.fixCopyIF(onlyFixCopyFromJstree);
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
	
	@SuppressWarnings("null")
	private <T extends ComprehensiveTree> void enterMyselfFromJstree( int ref
			                          , int c_position
			                          , int c_id
			                          , int idif
			                          , int ldif
			                          , Collection<Integer> c_idsByChildNodeFromNodeById ) throws InstantiationException, IllegalAccessException {
		Class<T> target = null;
		T onlyPasteMyselfFromJstree = target.newInstance();
		onlyPasteMyselfFromJstree.setRef(ref);
		onlyPasteMyselfFromJstree.setC_position(c_position);
		onlyPasteMyselfFromJstree.setC_id(c_id);
		onlyPasteMyselfFromJstree.setIdif(idif);
		onlyPasteMyselfFromJstree.setLdif(ldif);
		onlyPasteMyselfFromJstree.setC_idsByChildNodeFromNodeById( c_idsByChildNodeFromNodeById );

		coreDAO.enterMyselfFromJstree(onlyPasteMyselfFromJstree);
	}
	
	
	/* (non-Javadoc)
	 * @see egovframework.com.ext.jstree.springiBatis.core.service.CoreService#executeRemoveNode(egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
	 */
	@Transactional
	public <T extends ComprehensiveTree> int executeRemoveNode( T comprehensiveTree , CoreCallBackService coreCallBackService) {
		
		T removeNode = ((T) coreDAO.getNode(comprehensiveTree));
		
		coreDAO.removeNode(removeNode);
		
		return 0;
	}
	
	
	/* (non-Javadoc)
	 * @see egovframework.com.ext.jstree.springiBatis.core.service.CoreService#alterNode(egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
	 */
	@Transactional
	public <T extends ComprehensiveTree> int alterNode( T comprehensiveTree, CoreCallBackService coreCallBackService ) {

		return coreDAO.alterNode(comprehensiveTree);
	}
	
	
	/* (non-Javadoc)
	 * @see egovframework.com.ext.jstree.springiBatis.core.service.CoreService#alterNodeType(egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
	 */
	@Transactional
	public <T extends ComprehensiveTree> int alterNodeType( T comprehensiveTree, CoreCallBackService coreCallBackService ) {

		List<T> childNodesFromNodeById = ((List<T>) coreDAO.getChildNode(comprehensiveTree));

		T nodeById = ((T) coreDAO.getNode(comprehensiveTree));

		int returnStatus = 0;
		if (comprehensiveTree.getC_type().equals("default")) {

			if (childNodesFromNodeById.size() > 0) {
				throw new RuntimeException("하위에 노드가 있는데 디폴트로 바꾸려고 함");

			} else {
				comprehensiveTree.setC_type("default");
				int temp = coreDAO.alterNodeType(comprehensiveTree);

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
				returnStatus = coreDAO.alterNodeType(comprehensiveTree);
			}
		}
		return returnStatus;
	}
	
	
	/* (non-Javadoc)
	 * @see egovframework.com.ext.jstree.springiBatis.core.service.CoreService#moveNode(egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
	 */
	@SuppressWarnings({ "null" })
	@Transactional
	public <T extends ComprehensiveTree> T moveNode( T comprehensiveTree, CoreCallBackService coreCallBackService ) throws ReflectiveOperationException {

		T nodeById = (T) coreDAO.getNode(comprehensiveTree);
		List<T> childNodesFromNodeById = ((List<T>) coreDAO.getChildNodeByLeftRight( nodeById ));

		T nodeByRef = (T) coreDAO.getNodeByRef(comprehensiveTree);
		List<T> childNodesFromNodeByRef = ((List<T>) coreDAO.getChildNode(nodeByRef));

		Class<T> target = null;
		T t_ComprehensiveTree = target.newInstance();
		
		int spaceOfTargetNode = 2;
		Collection<Integer> c_idsByChildNodeFromNodeById = null;

		if (nodeById == null) {
			throw new RuntimeException("nodeById is null");
		} else {
			c_idsByChildNodeFromNodeById = CollectionUtils.collect(
					childNodesFromNodeById,
					new Transformer<T, Integer>() {
						@Override
						public Integer transform(
								T childNodePerNodeById) {
							return childNodePerNodeById.getC_id();
						}
					});

			if (c_idsByChildNodeFromNodeById.contains(comprehensiveTree
					.getRef())) {
				throw new RuntimeException(
						"myself contains already refTargetNode");
			}

			spaceOfTargetNode = nodeById.getC_right()
					- nodeById.getC_left() + 1;
		}

		if (nodeById != null
				&& comprehensiveTree.getCopyBooleanValue() == false) {
			this.cutMyself(nodeById, spaceOfTargetNode,
					c_idsByChildNodeFromNodeById);
		}

		calculatePostion(comprehensiveTree, nodeById,
				childNodesFromNodeByRef);

		this.stretchPositionForMyselfFromJstree(
				c_idsByChildNodeFromNodeById, nodeById, comprehensiveTree);

		int rightPositionFromNodeByRef = nodeByRef.getC_right();
		rightPositionFromNodeByRef = Math
				.max(rightPositionFromNodeByRef, 1);

		int self = (nodeById != null
				&& !comprehensiveTree.getCopyBooleanValue()
				&& nodeById.getC_parentid() == comprehensiveTree.getRef() && comprehensiveTree
				.getC_position() > nodeById.getC_position()) ? 1 : 0;

		for (T child : childNodesFromNodeByRef) {
			if (child.getC_position() - self == comprehensiveTree
					.getC_position()) {
				rightPositionFromNodeByRef = child.getC_left();
				break;
			}
		}

		if (nodeById != null && !comprehensiveTree.getCopyBooleanValue()
				&& nodeById.getC_left() < rightPositionFromNodeByRef) {
			rightPositionFromNodeByRef -= spaceOfTargetNode;
		}

		this.stretchLeftRightForMyselfFromJstree(spaceOfTargetNode,
				rightPositionFromNodeByRef, c_idsByChildNodeFromNodeById,
				comprehensiveTree.getCopy());

		logger.debug(">>>>>>>>>>>>>>>>>>>>"
				+ rightPositionFromNodeByRef);
		int targetNodeLevel = nodeById.getC_level()
				- (nodeByRef.getC_level() + 1);
		int comparePosition = nodeById.getC_left()
				- rightPositionFromNodeByRef;
		logger.debug(">>>>>>>>>>>>>>>>>>>>" + comparePosition);

		if (comprehensiveTree.getCopyBooleanValue()) {

			int ind = this.pasteMyselfFromJstree( comprehensiveTree.getRef()
					                            , comparePosition
					                            , spaceOfTargetNode
					                            , targetNodeLevel
					                            , c_idsByChildNodeFromNodeById
					                            , rightPositionFromNodeByRef
					                            , nodeById );
			t_ComprehensiveTree.setId(ind);
			this.fixCopy(ind, comprehensiveTree.getC_position());

		} else {
			this.enterMyselfFromJstree( comprehensiveTree.getRef()
					                  ,	comprehensiveTree.getC_position()
					                  ,	comprehensiveTree.getC_id()
					                  , comparePosition
					                  ,	targetNodeLevel
					                  , c_idsByChildNodeFromNodeById );

		}
		return t_ComprehensiveTree;
	}
	
	private <T extends ComprehensiveTree> void calculatePostion( T comprehensiveTree
			                     , T nodeById
			                     , List<T> childNodesFromNodeByRef ) {

		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();

		if (comprehensiveTree.getRef() == nodeById.getC_parentid()) {
			logger.debug(">>>>>>>>>>>>>>>이동할 노드가 내 부모안에서 움직일때");

			if (comprehensiveTree.getMultiCounter() == 0) {
				logger.debug(">>>>>>>>>>>>>>>멀티 카운터가 0 일때");
				session.put("settedPosition",
						comprehensiveTree.getC_position());

				if (comprehensiveTree.getC_position() > nodeById
						.getC_position()) {
					logger.debug(">>>>>>>>>>>>>>>이동 할 노드가 현재보다 뒤일때");
					logger.debug("노드값=" + nodeById.getC_title());
					logger.debug("노드의 초기 위치값=" + nodeById.getC_position());
					logger.debug("노드의 요청받은 위치값="
							+ comprehensiveTree.getC_position());
					logger.debug("노드의 요청받은 멀티카운터="
							+ comprehensiveTree.getMultiCounter());

					if (comprehensiveTree.getC_position() > childNodesFromNodeByRef
							.size()) {
						logger.debug("노드 이동시 폴더를 대상으로 했을때 생기는 버그 발생 ="
								+ comprehensiveTree.getC_position());
						comprehensiveTree
								.setC_position(childNodesFromNodeByRef.size());
					}
					comprehensiveTree.setC_position(comprehensiveTree
							.getC_position() - 1);

					logger.debug("노드의 최종 위치값="
							+ comprehensiveTree.getC_position());
					session.put("settedPosition",
							comprehensiveTree.getC_position());
				}

			} else {
				logger.debug(">>>>>>>>>>>>>>>멀티 카운터가 0 이 아닐때");
				logger.debug("노드값=" + nodeById.getC_title());
				logger.debug("노드의 초기 위치값=" + nodeById.getC_position());
				logger.debug("노드의 요청받은 위치값="
						+ comprehensiveTree.getC_position());
				logger.debug("노드의 요청받은 멀티카운터="
						+ comprehensiveTree.getMultiCounter());
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

				comprehensiveTree.setC_position(increasePosition);

				if (nodeById.getC_position() == comprehensiveTree
						.getC_position()) {
					logger.debug(">>>>>>>>>>>>>>>원래 노드 위치값과 최종 계산된 노드의 위치값이 동일한 경우");
					session.put("settedPosition", increasePosition - 1);
				}
				logger.debug("노드의 최종 위치값="
						+ comprehensiveTree.getC_position());
			}
		} else {
			logger.debug(">>>>>>>>>>>>>>>이동할 노드가 내 부모밖으로 움직일때");

			if (comprehensiveTree.getMultiCounter() == 0) {
				logger.debug(">>>>>>>>>>>>>>>멀티 카운터가 0 일때");
				logger.debug("노드값=" + nodeById.getC_title());
				logger.debug("노드의 초기 위치값=" + nodeById.getC_position());
				logger.debug("노드의 요청받은 위치값="
						+ comprehensiveTree.getC_position());
				logger.debug("노드의 요청받은 멀티카운터="
						+ comprehensiveTree.getMultiCounter());
				comprehensiveTree.setC_position(comprehensiveTree
						.getC_position());
				logger.debug("노드의 최종 위치값="
						+ comprehensiveTree.getC_position());
				session.put("settedPosition",
						comprehensiveTree.getC_position());
			} else {
				logger.debug(">>>>>>>>>>>>>>>멀티 카운터가 0 이 아닐때");
				logger.debug("노드값=" + nodeById.getC_title());
				logger.debug("노드의 초기 위치값=" + nodeById.getC_position());
				logger.debug("노드의 요청받은 위치값="
						+ comprehensiveTree.getC_position());
				logger.debug("노드의 요청받은 멀티카운터="
						+ comprehensiveTree.getMultiCounter());

				int increasePosition = 0;
				increasePosition = (Integer) session.get("settedPosition") + 1;
				session.put("settedPosition", increasePosition);

				comprehensiveTree.setC_position(increasePosition);
				logger.debug("노드의 최종 위치값="
						+ comprehensiveTree.getC_position());
				session.put("settedPosition",
						comprehensiveTree.getC_position());
			}
		}
	}
	
	@SuppressWarnings("null")
	private <T extends ComprehensiveTree> void stretchLeftRightForMyselfFromJstree( int spaceOfTargetNode
			                                        , int rightPositionFromNodeByRef
			                                        , Collection<Integer> c_idsByChildNodeFromNodeById
			                                        , int copy ) throws InstantiationException, ReflectiveOperationException {
		Class<T> target = null;
		T onlyStretchLeftRightForMyselfFromJstree = target.newInstance();

		onlyStretchLeftRightForMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
		onlyStretchLeftRightForMyselfFromJstree.setRightPositionFromNodeByRef(rightPositionFromNodeByRef);
		onlyStretchLeftRightForMyselfFromJstree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
		onlyStretchLeftRightForMyselfFromJstree.setCopy(copy);
		
		coreDAO.stretchLeftForMyselfFromJstree( onlyStretchLeftRightForMyselfFromJstree);
		coreDAO.stretchRightForMyselfFromJstree(onlyStretchLeftRightForMyselfFromJstree);
	}
	
	@SuppressWarnings("null")
	private <T extends ComprehensiveTree> int pasteMyselfFromJstree( int ref
			                         , int idif
			                         , int spaceOfTargetNode
			                         , int ldif
			                         , Collection<Integer> c_idsByChildNodeFromNodeById
			                         , int rightPositionFromNodeByRef
			                         , T nodeById ) throws InstantiationException, IllegalAccessException {

		Class<T> target = null;
		T onlyPasteMyselfFromJstree = target.newInstance();

		onlyPasteMyselfFromJstree.setRef(ref);
		onlyPasteMyselfFromJstree.setIdif(idif);
		onlyPasteMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
		onlyPasteMyselfFromJstree.setLdif(ldif);
		onlyPasteMyselfFromJstree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
		onlyPasteMyselfFromJstree.setRightPositionFromNodeByRef(rightPositionFromNodeByRef);
		onlyPasteMyselfFromJstree.setNodeById(nodeById);

		onlyPasteMyselfFromJstree.setIdifLeft( idif + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode : 0));
		onlyPasteMyselfFromJstree.setIdifRight(idif + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode	: 0));

		return coreDAO.pasteMyselfFromJstree(onlyPasteMyselfFromJstree);
	}
}