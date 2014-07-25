package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dao.DB_SearchNode;
import egovframework.com.ext.jstree.strutsiBatis.dao.I_DB_SearchNode;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class S_SearchNode implements I_S_SearchNode {

	P_ComprehensiveTree p_SearchNodeByPosition;
	List<T_ComprehensiveTree> t_SearchNodeByStrings;
	List<P_ComprehensiveTree> p_SearchNodeByPositions;

	I_DB_SearchNode i_DB_SearchNode;
	HttpServletRequest request;

	public S_SearchNode() {

		p_SearchNodeByPosition = new P_ComprehensiveTree();

		t_SearchNodeByStrings = new ArrayList<T_ComprehensiveTree>();
		p_SearchNodeByPositions = new ArrayList<P_ComprehensiveTree>();

		i_DB_SearchNode = new DB_SearchNode();
	}

	@Override
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public List<String> searchNode(P_ComprehensiveTree p_ComprehensiveTree) {

		t_SearchNodeByStrings.addAll(searchNodeByString(p_ComprehensiveTree));

		for (T_ComprehensiveTree nodeByString : t_SearchNodeByStrings) {
			p_SearchNodeByPositions.add(Util_SwapNode.swapTtoP(nodeByString));
		}

		return searchNodeByPosition(p_SearchNodeByPositions);
	}

	@Override
	public List<T_ComprehensiveTree> searchNodeByString(
			P_ComprehensiveTree p_ComprehensiveTree) {

		String determineDBSetting = selectDBSetting("step1");

		return i_DB_SearchNode.searchNodeByString(p_ComprehensiveTree,
				determineDBSetting);
	}

	@Override
	public List<String> searchNodeByPosition(
			List<P_ComprehensiveTree> p_SearchNodeByPositions) {

		String determineDBSetting = selectDBSetting("step2");

		return i_DB_SearchNode.searchNodeByPosition(p_SearchNodeByPositions,
				determineDBSetting);
	}

	public String selectDBSetting(String step) {
		// TODO : 리퀘스트에 따라서 DB 설정파일을 불러와서 선택적 리턴을 해야 함.
		String returnStr = "";
		if (request.getRequestURI().equals(
				"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/searchNode.action")
				&& step.equals("step1")) {
			returnStr = "jstreeStrtusiBatis.searchNodeByString";
		} else if (request.getRequestURI().equals(
				"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/searchNode.action")
				&& step.equals("step2")) {
			returnStr = "jstreeStrtusiBatis.searchNodeByPosition";
		} else {
			logger.debug(request.getRequestURI());
		}
		return returnStr;
	}

}
