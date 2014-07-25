package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dao.DB_GetNode;
import egovframework.com.ext.jstree.strutsiBatis.dao.I_DB_GetNode;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class S_GetNode implements I_S_GetNode {

	static Logger logger = Logger.getLogger(S_GetChildNode.class);

	I_DB_GetNode i_DB_GetNode;
	HttpServletRequest request;

	public S_GetNode() {
		i_DB_GetNode = new DB_GetNode();
	}

	@Override
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public T_ComprehensiveTree getNode(P_ComprehensiveTree p_ComprehensiveTree,
			String flag) {
		String determineDBSetting = this.selectDBSetting(flag);

		return i_DB_GetNode.getNode(p_ComprehensiveTree, determineDBSetting);
	}

	@Override
	public T_ComprehensiveTree getNodeByRef(
			P_ComprehensiveTree p_ComprehensiveTree, String flag) {
		String determineDBSetting = this.selectDBSetting(flag);

		return i_DB_GetNode.getNodeByRef(p_ComprehensiveTree,
				determineDBSetting);
	}

	public String selectDBSetting(String flag) {
		// TODO : 리퀘스트에 따라서 DB 설정파일을 불러와서 선택적 리턴을 해야 함.
		String returnStr = "";
		if (request.getRequestURI().equals(
				"/war/struts/www313cokr/index/menu/num3/removeNode.action")
				&& flag.equals("remove")) {
			returnStr = "jstreeStrtusiBatis.getNode";
		} else if (request.getRequestURI().equals(
				"/war/struts/www313cokr/index/menu/num3/moveNode.action")
				&& flag.equals("getNode")) {
			returnStr = "jstreeStrtusiBatis.getNode";
		} else if (request.getRequestURI().equals(
				"/war/struts/www313cokr/index/menu/num3/moveNode.action")
				&& flag.equals("getNodeByRef")) {
			returnStr = "jstreeStrtusiBatis.getNodeByRef";
		} else if (request.getRequestURI().equals(
				"/war/struts/www313cokr/index/menu/num3/addNode.action")
				&& flag.equals("getNode")) {
			returnStr = "jstreeStrtusiBatis.getNode";
		} else if (request.getRequestURI().equals(
				"/war/struts/www313cokr/index/menu/num3/addNode.action")
				&& flag.equals("getNodeByRef")) {
			returnStr = "jstreeStrtusiBatis.getNodeByRef";
		} else if (request.getRequestURI().equals(
				"/war/struts/www313cokr/index/menu/num3/alterNodeType.action")
				&& flag.equals("getNode")) {
			returnStr = "jstreeStrtusiBatis.getNode";
		} else {
			logger.debug(request.getRequestURI());
			throw new RuntimeException();
		}
		return returnStr;
	}

}
