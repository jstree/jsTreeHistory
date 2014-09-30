package egovframework.com.ext.jstree.springiBatis.core.service;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public interface ExecutionAfterService {
	public <T extends ComprehensiveTree> boolean executeAfter(T ComprehensiveTree);
}
