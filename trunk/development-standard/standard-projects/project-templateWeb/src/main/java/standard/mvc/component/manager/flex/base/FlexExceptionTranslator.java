package standard.mvc.component.manager.flex.base;

import java.sql.SQLException;

import org.springframework.flex.core.ExceptionTranslator;
import org.springframework.jdbc.UncategorizedSQLException;

import flex.messaging.MessageException;

public class FlexExceptionTranslator implements ExceptionTranslator {

	public boolean handles(Class<?> clazz) {

		return true;
	}

	public MessageException translate(Throwable t) {

		t.printStackTrace();
		MessageException ex = new MessageException();

		if (t instanceof FlexException) {
			ex.setCode(t.getLocalizedMessage());
		} else if (t instanceof UncategorizedSQLException
				|| t instanceof SQLException) {
			ex.setCode(FlexException.ERROR_SQL);
		} else {
			ex.setCode(FlexException.ERROR_ETC);
		}

		ex.setMessage(t.getLocalizedMessage());
		ex.setRootCause(t);

		return ex;
	}

}
