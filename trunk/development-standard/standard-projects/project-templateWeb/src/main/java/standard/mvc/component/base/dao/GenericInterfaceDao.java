package standard.mvc.component.base.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface GenericInterfaceDao<T, K, C, S> {
	
	T invokeSelectOne(String statementName, T parameterBean) throws DataAccessException;
	
	List<T> invokeSelect(String statementName, T parameterBean) throws DataAccessException;
	
	T invokeInsert(String statementName, T parameterBean) throws DataAccessException;
	
	S invokeInsert(String statementName, T parameterBean, K sequenceKey) throws DataAccessException;
	
	C invokeUpdate(String statementName, T parameterBean) throws DataAccessException;
	
	C invokeDelete(String statementName, T parameterBean) throws DataAccessException;

}
