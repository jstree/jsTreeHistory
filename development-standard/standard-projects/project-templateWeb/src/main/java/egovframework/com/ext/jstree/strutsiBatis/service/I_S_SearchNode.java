package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_GenericDao;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public interface I_S_SearchNode extends
		I_GenericDao<T_ComprehensiveTree, P_ComprehensiveTree> {

	static Logger logger = Logger.getLogger(I_S_SearchNode.class);

	public void setRequest(HttpServletRequest request);

	public List<String> searchNode(P_ComprehensiveTree p_ComprehensiveTree);

	public List<T_ComprehensiveTree> searchNodeByString(
			P_ComprehensiveTree p_SearchNodeByString);

	public List<String> searchNodeByPosition(
			List<P_ComprehensiveTree> p_SearchNodeByPositions);

}
