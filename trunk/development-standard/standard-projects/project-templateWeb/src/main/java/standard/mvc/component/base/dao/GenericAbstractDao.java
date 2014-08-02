package standard.mvc.component.base.dao;

import org.springframework.dao.DataAccessException;

public abstract class GenericAbstractDao {

	public void invokeSelect(String statementName, Object parameterBean, Object resultHandler) throws DataAccessException {
	}
	
}
