package egovframework.com.ext.jstree.core.service;

import java.util.List;

import egovframework.com.ext.jstree.core.vo.ComprehensiveTree;

public interface CoreService {

	
	public List<ComprehensiveTree> getChildNode( ComprehensiveTree comprehensiveTree );
	
	
	public List<String> searchNode( ComprehensiveTree comprehensiveTree );
	
	
	public ComprehensiveTree addNode( ComprehensiveTree comprehensiveTree );
	
	
	public int executeRemoveNode( ComprehensiveTree comprehensiveTree );
	
	
	public int alterNode( ComprehensiveTree comprehensiveTree );
	
	
	public int alterNodeType( ComprehensiveTree comprehensiveTree );
	
	
	public ComprehensiveTree moveNode( ComprehensiveTree comprehensiveTree );
}