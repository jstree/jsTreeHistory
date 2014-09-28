package egovframework.com.ext.jstree.springiBatis.core.service;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public interface CoreCallBackService {

	/*
	 * core Service 호출시 넘어간 파라미터 클래스를 그대로 이어받아서 처리하게끔 하는 콜백 서비스.
	 */
	<T extends ComprehensiveTree> boolean excute(T comprehensiveTree);
}
