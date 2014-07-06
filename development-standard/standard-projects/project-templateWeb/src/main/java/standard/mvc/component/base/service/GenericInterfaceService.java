package standard.mvc.component.base.service;

import java.util.List;

public interface GenericInterfaceService<T> {

	public List<T> getResults(T VO_model);

	abstract void validate(T VO_model);

}
