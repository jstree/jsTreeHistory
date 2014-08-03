package standard.mvc.component.base.dao;

import org.springframework.dao.DataAccessException;

public abstract class GenericAbstractDao<T, C, P> {

	protected T legacyConnection;
	
	@SuppressWarnings("unchecked")
	public void invokeSelect(String statementName, Object parameterBean, C ... command) throws DataAccessException {
	}
	
	public void initLegacyConnection(P properties) throws DataAccessException {
	}

}
