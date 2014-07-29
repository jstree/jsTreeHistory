package standard.mvc.component.base.dao;

import org.apache.ibatis.session.ResultHandler;

public abstract class GenericAbstractDao {
	public void invokeSelect(String statementName, Object parameterBean, ResultHandler resulthandler) {
	}
}
