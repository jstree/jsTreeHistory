package standard.mvc.component.manager.foundation.flex.base;

import java.util.List;

public interface IGenericService<S, C> {

	public List<S> getResult(C clientVO);

	abstract void validate(C clientVO);

}
