package egovframework.com.ext.jstree.springHibernate.core.dao;

import java.io.Serializable;

public interface JsTreeHibernateDao<T, ID extends Serializable> {
	
	public void setClazz(Class<T> clazzToSet);
	public Class<T> getClazz();

}
