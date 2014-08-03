package standard.mvc.component.base.service;

import java.util.List;

import standard.mvc.component.base.exception.GenericServiceRuntimeException;

public interface GenericInterfaceService<T> {
	List<T> getResults(T modelVO) throws GenericServiceRuntimeException;
	void validate(T modelVO) throws GenericServiceRuntimeException;
}
