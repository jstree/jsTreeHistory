package egovframework.com.ext.jstree.springHibernate.core.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class JsTreeGenericHibernateDaoImpl<T extends Serializable> extends JsTreeAbstractHibernateDao<T> {
	
	@Resource(name = "sessionFactory")
    public void init(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
    @Override
    protected Class<T> getEntityClass() {
        return super.getClazz();
    }
    
    @Override
    public DetachedCriteria createDetachedCriteria() {
        DetachedCriteria detachedCriteria = super.createDetachedCriteria();
        return detachedCriteria;
    }
    
	protected final Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
}