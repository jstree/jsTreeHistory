package egovframework.com.ext.jstree.support.manager.mvc.dao;

import org.springframework.dao.DataAccessException;

public abstract class GenericAbstractDao<T, C> {

	@SuppressWarnings("unchecked")
	public void invokeSelect(String statementName, T parameterBean, C ... command) throws DataAccessException {
	}

}
