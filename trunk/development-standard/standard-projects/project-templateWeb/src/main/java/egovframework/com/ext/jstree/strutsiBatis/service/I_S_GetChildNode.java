package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dao.I_GenericDao;
import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * 하위 node의 정보를 가져오는 interface class
 * */
public interface I_S_GetChildNode extends
		I_GenericDao<T_ComprehensiveTree, P_ComprehensiveTree> {

	static Logger logger = Logger.getLogger(I_S_GetChildNode.class);

	public void setRequest(HttpServletRequest request);
	
	/**
	 * 해당 node의 하위 node들을 가져온다.
	 * */
	public List<T_ComprehensiveTree> getChildNode(
			P_ComprehensiveTree p_ComprehensiveTree);
	
	
	/**
	 * 하위 node들의 left와 right값들을 가져온다.
	 * */
	public List<T_ComprehensiveTree> getChildNodeByLeftRight(
			P_ComprehensiveTree p_ComprehensiveTree);

}
