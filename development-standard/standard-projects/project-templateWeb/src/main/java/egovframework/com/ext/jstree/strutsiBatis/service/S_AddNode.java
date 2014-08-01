package egovframework.com.ext.jstree.strutsiBatis.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_DB_AddNode;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

/**
 * node 추가 service
 * */
@Service("S_AddNode")
public class S_AddNode implements I_S_AddNode {

	static Logger logger = Logger.getLogger(S_AddNode.class);

	HttpServletRequest request;
	
	@Resource(name="S_GetNode")
	I_S_GetNode i_S_GetNode;
	
	@Resource(name="S_GetChildNode")
	I_S_GetChildNode i_S_GetChildNode;
	
	@Resource(name="DB_AddNode")
	I_DB_AddNode i_DB_AddNode;

	public S_AddNode() {

		//i_S_GetNode = new S_GetNode();
		//i_S_GetChildNode = new S_GetChildNode();
		//i_DB_AddNode = new DB_AddNode();
	}

	@Override
	public void setRequest(HttpServletRequest request) {

		this.request = request;
	}

	@Override
	public T_ComprehensiveTree addNode(P_ComprehensiveTree p_ComprehensiveTree) {

		i_S_GetNode.setRequest(request);
		T_ComprehensiveTree nodeById = i_S_GetNode.getNode(p_ComprehensiveTree,
				"getNode");

		T_ComprehensiveTree nodeByRef = i_S_GetNode.getNodeByRef(
				p_ComprehensiveTree, "getNodeByRef");

		i_S_GetChildNode.setRequest(request);
		List<T_ComprehensiveTree> childNodesFromNodeByRef = i_S_GetChildNode
				.getChildNode(Util_SwapNode.swapTtoP(nodeByRef));

		return i_DB_AddNode.addNode(p_ComprehensiveTree, nodeById, nodeByRef,
				childNodesFromNodeByRef);
	}

}
