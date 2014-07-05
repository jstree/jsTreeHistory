package egovframework.com.ext.jstree.core.service;

import java.util.List;

import egovframework.com.ext.jstree.core.vo.P_ComprehensiveTree;
import egovframework.com.ext.jstree.core.vo.T_ComprehensiveTree;

public interface CoreService {

	
	public List<T_ComprehensiveTree> getChildNode(P_ComprehensiveTree p_ComprehensiveTree);
	
	
	public List<String> searchNode(P_ComprehensiveTree p_ComprehensiveTree);
	
	
	public T_ComprehensiveTree addNode(P_ComprehensiveTree p_ComprehensiveTree);
	
	
	public int executeRemoveNode(P_ComprehensiveTree p_ComprehensiveTree);
	
	
	public int alterNode(P_ComprehensiveTree p_ComprehensiveTree);
	
	
	public int alterNodeType(P_ComprehensiveTree p_ComprehensiveTree);
	
	
	public T_ComprehensiveTree moveNode(P_ComprehensiveTree p_ComprehensiveTree);
}