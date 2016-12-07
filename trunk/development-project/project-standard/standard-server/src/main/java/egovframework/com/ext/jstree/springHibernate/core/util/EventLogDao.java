package egovframework.com.ext.jstree.springHibernate.core.util;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import egovframework.com.ext.jstree.springHibernate.core.dao.JsTreeHibernateDaoSupport;


@Repository
public class EventLogDao extends JsTreeHibernateDaoSupport<EventLog, Long> {
    @Resource(name = "sessionFactory")
    public void init(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
    @Override
    protected Class<EventLog> getEntityClass() {
        return EventLog.class;
    }
    
    @Override
    public DetachedCriteria createDetachedCriteria() {
        DetachedCriteria detachedCriteria = super.createDetachedCriteria();
        return detachedCriteria;
    }
}