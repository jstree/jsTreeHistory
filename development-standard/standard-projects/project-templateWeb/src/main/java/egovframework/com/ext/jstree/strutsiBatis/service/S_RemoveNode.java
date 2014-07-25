package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dao.DB_RemoveNode;
import egovframework.com.ext.jstree.strutsiBatis.dao.I_DB_RemoveNode;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;

import javax.servlet.http.HttpServletRequest;

public class S_RemoveNode implements I_S_RemoveNode {

	I_DB_RemoveNode i_DB_RemoveNode;
	HttpServletRequest request;

	public S_RemoveNode() {
		i_DB_RemoveNode = new DB_RemoveNode();
	}

	@Override
	public void setRequest(HttpServletRequest request) {
		this.request = request;

	}

	@Override
	public int executeRemoveNode(P_ComprehensiveTree p_ComprehensiveTree) {

		I_S_GetNode i_s_GetNode = new S_GetNode();
		i_s_GetNode.setRequest(request);
		return removeNode(Util_SwapNode.swapTtoP(i_s_GetNode.getNode(
				p_ComprehensiveTree, "remove")));
	}

	@Override
	public int removeNode(P_ComprehensiveTree p_RemoveNode) {

		int spaceOfTargetNode = p_RemoveNode.getC_right()
				- p_RemoveNode.getC_left() + 1;
		p_RemoveNode.setSpaceOfTargetNode(spaceOfTargetNode);

		String determineDBSetting = selectDBSetting();

		i_DB_RemoveNode.removeNode(p_RemoveNode, determineDBSetting);

		return 0;
	}

	public String selectDBSetting() {
		// TODO : 리퀘스트에 따라서 DB 설정파일을 불러와서 선택적 리턴을 해야 함.
		String returnStr = "";
		if (request.getRequestURI().equals(
				"/war/struts/www313cokr/index/menu/num3/removeNode.action")) {
			returnStr = "solution.removeNode";
		} else {
			logger.debug(request.getRequestURI());
			throw new RuntimeException();
		}
		return returnStr;
	}

}
