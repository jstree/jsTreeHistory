package egovframework.com.ext.jstree.strutsiBatis.core.service;

import egovframework.com.ext.jstree.strutsiBatis.core.dao.I_GenericDao;
import egovframework.com.ext.jstree.strutsiBatis.core.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.core.vo.T_ComprehensiveTree;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Modification Information
 * 
 * @author 이동민
 * @since 2014.07.25
 * @version 1.0
 * @see <pre>
 * 
 * Class Name 	: I_S_RemoveNode.java
 * Description 	: JSTree의 node를 제거하는 service의 interface
 * Infomation	: 
 *
 * node 제거
 * 
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.25    Dongmin.Lee      최초 생성 
 * 
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 * */
public interface I_S_RemoveNode extends
		I_GenericDao<T_ComprehensiveTree, P_ComprehensiveTree> {

	static Logger logger = Logger.getLogger(I_S_SearchNode.class);

	public void setRequest(HttpServletRequest request);

	public int executeRemoveNode(P_ComprehensiveTree p_ComprehensiveTree);
	
	/**
	 * node의 제거 
	 * 
	 * @param P_ComprehensiveTree(p_ComprehensiveTree)
	 * @return node 제거 처리에 따른 결과값 (int)
	 * */
	public int removeNode(P_ComprehensiveTree p_RemoveNode);

}
