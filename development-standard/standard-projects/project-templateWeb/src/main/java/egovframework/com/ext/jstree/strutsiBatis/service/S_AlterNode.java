package egovframework.com.ext.jstree.strutsiBatis.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_DB_AlterNode;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;

@Service("S_AlterNode")
public class S_AlterNode implements I_S_AlterNode {

	static Logger logger = Logger.getLogger(S_AlterNode.class);

	@Resource(name="DB_AlterNode")
	I_DB_AlterNode i_DB_AlterNode;
	HttpServletRequest request;

	public S_AlterNode() {
		//i_DB_AlterNode = new DB_AlterNode();
	}

	@Override
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public int alterNode(P_ComprehensiveTree p_ComprehensiveTree) {

		String determineDBSetting = selectDBSetting();

		return i_DB_AlterNode.alterNode(p_ComprehensiveTree, determineDBSetting);
	}

	public String selectDBSetting() {
		// TODO : 리퀘스트에 따라서 DB 설정파일을 불러와서 선택적 리턴을 해야 함.
		String returnStr = "";
		if (request.getRequestURI().equals(
				"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/alterNode.action")) {
			returnStr = "jstreeStrutsiBatis.alterNode";
		} else {
			logger.debug(request.getRequestURI());
		}
		return returnStr;
	}

}
