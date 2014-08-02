package standard.mvc.component.base.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface GenericInterfaceDao<T, K, C, S> {
	public abstract T invokeSelectOne(String statementName, T parameterBean) throws DataAccessException;
	public abstract List<T> invokeSelect(String statementName, T parameterBean) throws DataAccessException;
	public abstract T invokeInsert(String statementName, T parameterBean) throws DataAccessException;
	public abstract S invokeInsert(String statementName, T parameterBean, K sequenceKey) throws DataAccessException;
	public abstract C invokeUpdate(String statementName, T parameterBean) throws DataAccessException;
	public abstract C invokeDelete(String statementName, T parameterBean) throws DataAccessException;
}
