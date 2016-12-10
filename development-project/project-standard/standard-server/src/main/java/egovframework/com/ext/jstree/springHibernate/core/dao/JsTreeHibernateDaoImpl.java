package egovframework.com.ext.jstree.springHibernate.core.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateDTO;

@Repository
public class JsTreeHibernateDaoImpl<T extends JsTreeHibernateDTO> extends JsTreeHibernateDaoSupport<T, Long>{
	
	
    @Resource(name = "sessionFactory")
    public void init(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
	
    @Override
    protected Class<T> getEntityClass() {
        return this.getClazz();
    }
    
    @Override
    public DetachedCriteria createDetachedCriteria() {
        DetachedCriteria detachedCriteria = super.createDetachedCriteria();
        return detachedCriteria;
    }
    
    private Class<T> clazz;
    public void setClazz(Class<T> clazzToSet) {
    	this.clazz = clazzToSet;
    }
    public Class<T> getClazz() {
    	return clazz;
    }
}
