package standard.mvc.component.base.dao;

import java.util.List;

public interface GenericInterfaceDao<T, K, C, S> {
	public abstract T invokeSelectOne(T parameterBean);
	public abstract List<T> invokeSelect(T parameterBean);
	public abstract T invokeInsert(T parameterBean);
	public abstract S invokeInsert(T parameterBean, K sequenceKey);
	public abstract C invokeUpdate(T parameterBean);
	public abstract C invokeDelete(T parameterBean);
}
