package egovframework.com.ext.jstree.strutsiBatis.dao;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import egovframework.com.ext.jstree.strutsiBatis.service.I_S_GetChildNode;
import egovframework.com.ext.jstree.strutsiBatis.service.I_S_GetNode;
import egovframework.com.ext.jstree.strutsiBatis.service.S_GetChildNode;
import egovframework.com.ext.jstree.strutsiBatis.service.S_GetNode;
import egovframework.com.ext.jstree.strutsiBatis.service.Util_SwapNode;

import com.opensymphony.xwork2.ActionContext;


/**
 * 
 * @author 이동민      
 * @since 2014.07.25
 * @version 1.0.0   
 * 
 * */
@Repository("DB_AddNode")
public class DB_AddNode extends EgovComAbstractDAO implements I_DB_AddNode {

	static Logger logger = Logger.getLogger(DB_AddNode.class);

	HttpServletRequest request;
	I_S_GetNode i_S_GetNode;
	I_S_GetChildNode i_S_GetChildNode;

	public DB_AddNode() {

		i_S_GetNode = new S_GetNode();
		i_S_GetChildNode = new S_GetChildNode();

	}

	@Override
	public void setRequest(HttpServletRequest request) {

		this.request = request;

	}
	
	
	/**
	 * node 추가
	 * 
	 * @return t_ComprehensiveTree
	 * 
	 * */
	@SuppressWarnings("deprecation")
	@Override
	public T_ComprehensiveTree addNode(P_ComprehensiveTree p_ComprehensiveTree,
			T_ComprehensiveTree nodeById, T_ComprehensiveTree nodeByRef,
			List<T_ComprehensiveTree> childNodesFromNodeByRef) {

		T_ComprehensiveTree t_ComprehensiveTree = new T_ComprehensiveTree();

		try {
			getSqlMapClientTemplate().getSqlMapClient().startTransaction();

			int spaceOfTargetNode = 2;
			Collection<Integer> c_idsByChildNodeFromNodeById = null;

			if (nodeById != null && p_ComprehensiveTree.getCopy() == 0) {
				this.cutMyself(nodeById, spaceOfTargetNode,
						c_idsByChildNodeFromNodeById);
			}

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

			int targetNodeLevel = p_ComprehensiveTree.getRef() == 0 ? 0
					: nodeByRef.getC_level() + 1;
			int comparePosition = rightPositionFromNodeByRef;
			if (nodeById != null) {

				targetNodeLevel = nodeById.getC_level()
						- (nodeByRef.getC_level() + 1);
				comparePosition = nodeById.getC_left()
						- rightPositionFromNodeByRef;
				if (p_ComprehensiveTree.getCopyBooleanValue()) {
					int ind = this.pasteMyselfFromJstree(
							p_ComprehensiveTree.getRef(), comparePosition,
							spaceOfTargetNode, targetNodeLevel,
							c_idsByChildNodeFromNodeById,
							rightPositionFromNodeByRef, nodeById);
					t_ComprehensiveTree.setId(ind);
					this.fixCopy(ind, p_ComprehensiveTree.getC_position());

				} else {
					this.enterMyselfFromJstree(p_ComprehensiveTree.getRef(),
							p_ComprehensiveTree.getC_position(),
							p_ComprehensiveTree.getC_id(), comparePosition,
							targetNodeLevel, c_idsByChildNodeFromNodeById);

				}
			} else {
				p_ComprehensiveTree.setC_parentid(p_ComprehensiveTree.getRef());
				p_ComprehensiveTree.setC_left(comparePosition);
				p_ComprehensiveTree.setC_right(comparePosition + 1);
				p_ComprehensiveTree.setC_level(targetNodeLevel);

				int insertSeqResult = this
						.addMyselfFromJstree(p_ComprehensiveTree);

				t_ComprehensiveTree.setId(insertSeqResult);
				p_ComprehensiveTree.setC_id(insertSeqResult);
				int alterCountResult = this.alterNode(p_ComprehensiveTree);

				if (insertSeqResult > 0 && alterCountResult == 1) {
					t_ComprehensiveTree.setStatus(1);
				} else {
					throw new RuntimeException("심각한 오류 발생 - 삽입 노드");
				}
			}

			if (p_ComprehensiveTree.getCopyBooleanValue()) {
				this.fixCopy(p_ComprehensiveTree.getC_id(),
						p_ComprehensiveTree.getC_position());
			}

			getSqlMapClientTemplate().getSqlMapClient().commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				getSqlMapClientTemplate().getSqlMapClient().endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return t_ComprehensiveTree;

	}
	
	
	/**
	 * node 수정하기
	 * 
	 * node의 type(UI  종류로는 drive/ folder/ default(file) ) / title(사용자 지정 node 명칭) 등을 수정한다. 
	 * */
	@SuppressWarnings("deprecation")
	private int alterNode(P_ComprehensiveTree p_ComprehensiveTree)
			throws SQLException {

		return getSqlMapClientTemplate().getSqlMapClient().update("jstreeStrutsiBatis.alterNode",
				p_ComprehensiveTree);
	}
	/**
	 * node 값 추가하기 
	 * 
	 * */
	@SuppressWarnings("deprecation")
	private int addMyselfFromJstree(P_ComprehensiveTree p_ComprehensiveTree)
			throws SQLException {
		return (Integer) getSqlMapClientTemplate().getSqlMapClient().insert(
				"jstreeStrutsiBatis.addMyselfFromJstree", p_ComprehensiveTree);
	}
	
	
	/**
	 * node 잘라내기
	 * 
	 * 잘라낸 node가 차지하고 있던 공간의 position값과 left/right 값을 줄인다.  
	 * 
	 * */
	@SuppressWarnings("deprecation")
	public void cutMyself(T_ComprehensiveTree nodeById, int spaceOfTargetNode,
			Collection<Integer> c_idsByChildNodeFromNodeById)
			throws SQLException {

		P_ComprehensiveTree p_OnlyCutMyselfFromJstree = new P_ComprehensiveTree();
		p_OnlyCutMyselfFromJstree = Util_SwapNode.swapTtoP(nodeById);
		p_OnlyCutMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
		p_OnlyCutMyselfFromJstree
				.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);

		getSqlMapClientTemplate().getSqlMapClient().update(
				"jstreeStrutsiBatis.cutMyselfPositionFix", p_OnlyCutMyselfFromJstree);
		getSqlMapClientTemplate().getSqlMapClient().update("jstreeStrutsiBatis.cutMyselfLeftFix",
				p_OnlyCutMyselfFromJstree);
		getSqlMapClientTemplate().getSqlMapClient().update("jstreeStrutsiBatis.cutMyselfRightFix",
				p_OnlyCutMyselfFromJstree);
	}
	
	
	/**
	 * position값 계산하기
	 * 
	 * 조건은 
	 * 이동할 노드가 동일 부모에서 움직이는지 외부로 움직이는지
	 * 멀티 카운터(움직이는 node의 갯수 0은 하나)가 0인지 아닌지
	 * 현재의 positon값보다 앞인지/ 뒤인지 / 현재 위치인지
	 * 
	 * */
	public void calculatePostion(P_ComprehensiveTree p_ComprehensiveTree,
			T_ComprehensiveTree nodeById,
			List<T_ComprehensiveTree> childNodesFromNodeByRef) {

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
	
	/**
	 * node 추가를 위해서 node가 들어갈 공간을 만듬 (postion)
	 * 
	 * */
	@SuppressWarnings("deprecation")
	public void stretchPositionForMyselfFromJstree(
			Collection<Integer> c_idsByChildNodeFromNodeById,
			T_ComprehensiveTree nodeById,
			P_ComprehensiveTree p_ComprehensiveTree) throws SQLException {

		p_ComprehensiveTree
				.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
		p_ComprehensiveTree.setNodeById(nodeById);

		getSqlMapClientTemplate().getSqlMapClient().update(
				"jstreeStrutsiBatis.stretchPositionForMyself", p_ComprehensiveTree);

	}
	
	/**
	 * node 추가를 위해 left값과 right 값의 공간을 만듬
	 * 
	 * 들어갈 node들의 크기 만큼 left와 right값을 늘린다
	 * */
	@SuppressWarnings("deprecation")
	public void stretchLeftRightForMyselfFromJstree(int spaceOfTargetNode,
			int rightPositionFromNodeByRef,
			Collection<Integer> c_idsByChildNodeFromNodeById, int copy)
			throws SQLException {

		P_ComprehensiveTree p_OnlyStretchLeftRightForMyselfFromJstree = new P_ComprehensiveTree();

		p_OnlyStretchLeftRightForMyselfFromJstree
				.setSpaceOfTargetNode(spaceOfTargetNode);
		p_OnlyStretchLeftRightForMyselfFromJstree
				.setRightPositionFromNodeByRef(rightPositionFromNodeByRef);
		p_OnlyStretchLeftRightForMyselfFromJstree
				.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
		p_OnlyStretchLeftRightForMyselfFromJstree.setCopy(copy);
		getSqlMapClientTemplate().getSqlMapClient().update(
				"jstreeStrutsiBatis.stretchLeftForMyselfFromJstree",
				p_OnlyStretchLeftRightForMyselfFromJstree);
		getSqlMapClientTemplate().getSqlMapClient().update(
				"jstreeStrutsiBatis.stretchRightForMyselfFromJstree",
				p_OnlyStretchLeftRightForMyselfFromJstree);
	}
	
	
	/**
	 * node를 붙여넣는다.
	 * 
	 * */
	@SuppressWarnings("deprecation")
	public int pasteMyselfFromJstree(int ref, int idif, int spaceOfTargetNode,
			int ldif, Collection<Integer> c_idsByChildNodeFromNodeById,
			int rightPositionFromNodeByRef, T_ComprehensiveTree nodeById)
			throws SQLException {

		P_ComprehensiveTree p_OnlyPasteMyselfFromJstree = new P_ComprehensiveTree();

		p_OnlyPasteMyselfFromJstree.setRef(ref);
		p_OnlyPasteMyselfFromJstree.setIdif(idif);
		p_OnlyPasteMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
		p_OnlyPasteMyselfFromJstree.setLdif(ldif);
		p_OnlyPasteMyselfFromJstree
				.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
		p_OnlyPasteMyselfFromJstree
				.setRightPositionFromNodeByRef(rightPositionFromNodeByRef);
		p_OnlyPasteMyselfFromJstree.setNodeById(nodeById);

		p_OnlyPasteMyselfFromJstree
				.setIdifLeft(idif
						+ (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode
								: 0));
		p_OnlyPasteMyselfFromJstree
				.setIdifRight(idif
						+ (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode
								: 0));

		return (Integer) getSqlMapClientTemplate().getSqlMapClient().insert(
				"jstreeStrutsiBatis.pasteMyselfFromJstree", p_OnlyPasteMyselfFromJstree);
	}
	
	/**
	 * 쿼리가 없다....현재는 사용을 안하는건가;;
	 * */
	@SuppressWarnings("deprecation")
	public void enterMyselfFromJstree(int ref, int c_position, int c_id,
			int idif, int ldif, Collection<Integer> c_idsByChildNodeFromNodeById)
			throws SQLException {

		P_ComprehensiveTree p_OnlyPasteMyselfFromJstree = new P_ComprehensiveTree();
		p_OnlyPasteMyselfFromJstree.setRef(ref);
		p_OnlyPasteMyselfFromJstree.setC_position(c_position);
		p_OnlyPasteMyselfFromJstree.setC_id(c_id);
		p_OnlyPasteMyselfFromJstree.setIdif(idif);
		p_OnlyPasteMyselfFromJstree.setLdif(ldif);
		p_OnlyPasteMyselfFromJstree
				.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);

		getSqlMapClientTemplate().getSqlMapClient().insert(
				"jstreeStrutsiBatis.enterMyselfFromJstree", p_OnlyPasteMyselfFromJstree);

	}
	
	/**
	 * node의 position 값과 parentId 값을 수정한다.
	 * 
	 * */
	@SuppressWarnings("deprecation")
	public void fixCopy(int ind, int ref) throws SQLException {
		logger.debug("SUDO : 카피뜬 녀석의 하위 노드들에 대한 고민.");
		P_ComprehensiveTree p_ComprehensiveTree = new P_ComprehensiveTree();
		p_ComprehensiveTree.setC_id(ind);

		i_S_GetNode.setRequest(request);
		T_ComprehensiveTree node = i_S_GetNode.getNode(p_ComprehensiveTree,
				"getNode");

		i_S_GetChildNode.setRequest(request);
		List<T_ComprehensiveTree> children = i_S_GetChildNode
				.getChildNodeByLeftRight(Util_SwapNode.swapTtoP(node));

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = node.getC_left() + 1; i < node.getC_right(); i++) {
			map.put(i, ind);
		}

		logger.debug(">>>>>>>>>>>>>>>>> 이미 노드는 다 인서트 되 있는 상태이고 그 하위를 잡아라!");
		for (int i = 0; i < children.size(); i++) {

			T_ComprehensiveTree child = children.get(i);

			if (child.getC_id() == ind) {
				logger.debug(">>>>>>>>>>>>>>>>> 기준노드가 잡혔음.");
				logger.debug("C_TITLE = " + child.getC_title());
				logger.debug("C_ID = " + ind);
				logger.debug("C_POSITION = " + ref);
				P_ComprehensiveTree p_OnlyFixCopyFromJstree = new P_ComprehensiveTree();
				p_OnlyFixCopyFromJstree.setFixCopyId(ind);
				p_OnlyFixCopyFromJstree.setFixCopyPosition(ref);
				getSqlMapClientTemplate().getSqlMapClient().update("jstreeStrutsiBatis.fixCopyIF",
						p_OnlyFixCopyFromJstree);
				continue;
			}
			logger.debug(">>>>>>>>>>>>>>>>> 기준노드 아래 있는 녀석임");
			logger.debug("C_TITLE = " + child.getC_title());
			logger.debug("C_ID = " + ind);
			logger.debug("C_POSITION = " + ref);
			logger.debug("부모아이디값 = " + map.get(child.getC_left()));
			child.setFixCopyId(map.get(child.getC_left()));
			getSqlMapClientTemplate().getSqlMapClient()
					.update("jstreeStrutsiBatis.fixCopy", child);
			for (int j = child.getC_left() + 1; j < child.getC_right(); j++) {
				map.put(j, child.getC_id());
			}

		}

	}

}
