package egovframework.com.ext.jstree.support.manager.mvc.service;

import java.util.List;

import egovframework.com.ext.jstree.support.manager.mvc.exception.GenericServiceRuntimeException;

public interface GenericInterfaceService<V, T, C> {
	
	List<V> getResults(V modelVO) throws GenericServiceRuntimeException;
	
	void validate(V modelVO) throws GenericServiceRuntimeException;

	T invokeSelectOne(T parameterBean);
	
	List<T> invokeSelect(T parameterBean);
	
	T invokeInsert(T parameterBean);
	
	C invokeUpdate(T parameterBean);
	
	C invokeDelete(T parameterBean);

}
