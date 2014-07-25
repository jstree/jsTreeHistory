package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dao.DB_GetChildNode;
import egovframework.com.ext.jstree.strutsiBatis.dao.I_DB_GetChildNode;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class S_GetChildNode implements I_S_GetChildNode {

	static Logger logger = Logger.getLogger(S_GetChildNode.class);

	I_DB_GetChildNode i_DB_GetChildNode;
	HttpServletRequest request;

	public S_GetChildNode() {
		i_DB_GetChildNode = new DB_GetChildNode();
	}

	@Override
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public List<T_ComprehensiveTree> getChildNode(
			P_ComprehensiveTree p_ComprehensiveTree) {
		String determineDBSetting = selectDBSetting("byID");

		return i_DB_GetChildNode.getChildNode(p_ComprehensiveTree,
				determineDBSetting);
	}

	@Override
	public List<T_ComprehensiveTree> getChildNodeByLeftRight(
			P_ComprehensiveTree p_ComprehensiveTree) {

		String determineDBSetting = selectDBSetting("byLeftRight");

		return i_DB_GetChildNode.getChildNodeByLeftRight(p_ComprehensiveTree,
				determineDBSetting);
	}

	public String selectDBSetting(String flag) {
		// TODO : 리퀘스트에 따라서 DB 설정파일을 불러와서 선택적 리턴을 해야 함.
		String returnStr = "";
		if (request.getRequestURI().equals(
				"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/getChildNode.action")
				&& flag.equals("byID")) {
			returnStr = "jstreeStrtusiBatis.getChildNode";
		} else if (request.getRequestURI().equals(
				"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/alterNodeType.action")
				&& flag.equals("byID")) {
			returnStr = "jstreeStrtusiBatis.getChildNode";
		} else if (request.getRequestURI().equals(
				"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/moveNode.action")
				&& flag.equals("byID")) {
			returnStr = "jstreeStrtusiBatis.getChildNode";
		} else if (request.getRequestURI().equals(
				"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/moveNode.action")
				&& flag.equals("byLeftRight")) {
			returnStr = "jstreeStrtusiBatis.getChildNodeByLeftRight";
		} else if (request.getRequestURI().equals(
				"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/addNode.action")
				&& flag.equals("byID")) {
			returnStr = "jstreeStrtusiBatis.getChildNode";
		} else if (request.getRequestURI().equals(
				"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/addNode.action")
				&& flag.equals("byLeftRight")) {
			returnStr = "jstreeStrtusiBatis.getChildNodeByLeftRight";
		} else {
			logger.debug(request.getRequestURI());
		}
		return returnStr;
	}

}
