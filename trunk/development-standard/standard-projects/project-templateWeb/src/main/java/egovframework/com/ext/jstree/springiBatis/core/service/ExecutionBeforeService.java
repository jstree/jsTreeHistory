package egovframework.com.ext.jstree.springiBatis.core.service;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public interface ExecutionBeforeService {
	public <T extends ComprehensiveTree> boolean executeBefore(T ComprehensiveTree);
}
