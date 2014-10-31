package standard.mvc.component.base.dao;

import org.springframework.dao.DataAccessException;

public abstract class GenericAbstractDao<T, C> {

	@SuppressWarnings("unchecked")
	public void invokeSelect(String statementName, T parameterBean, C ... command) throws DataAccessException {
	}

}
