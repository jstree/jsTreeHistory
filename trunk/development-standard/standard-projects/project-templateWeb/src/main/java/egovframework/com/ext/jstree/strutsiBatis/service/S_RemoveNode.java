package egovframework.com.ext.jstree.strutsiBatis.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_DB_RemoveNode;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;

@Service("S_RemoveNode")
public class S_RemoveNode implements I_S_RemoveNode {

	HttpServletRequest request;

	@Resource(name="DB_RemoveNode")
	I_DB_RemoveNode i_DB_RemoveNode;
	
	@Resource(name="S_GetNode")
	I_S_GetNode i_s_GetNode;

	public S_RemoveNode() {
		//i_DB_RemoveNode = new DB_RemoveNode();
	}

	@Override
	public void setRequest(HttpServletRequest request) {
		this.request = request;

	}

	@Override
	public int executeRemoveNode(P_ComprehensiveTree p_ComprehensiveTree) {

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
				"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/removeNode.action")) {
			returnStr = "jstreeStrutsiBatis.removeNode";
		} else {
			logger.debug(request.getRequestURI());
			throw new RuntimeException();
		}
		return returnStr;
	}

}