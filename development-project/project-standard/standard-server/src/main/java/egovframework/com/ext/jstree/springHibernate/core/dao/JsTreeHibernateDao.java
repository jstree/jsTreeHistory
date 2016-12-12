package egovframework.com.ext.jstree.springHibernate.core.dao;

import java.io.Serializable;
import java.util.List;

public interface JsTreeHibernateDao<T, ID extends Serializable> {
	
	public Class<T> getClazz();
	public void setClazz(Class<T> clazzToSet);
	public List<T> getList(T searchSupport);
}
