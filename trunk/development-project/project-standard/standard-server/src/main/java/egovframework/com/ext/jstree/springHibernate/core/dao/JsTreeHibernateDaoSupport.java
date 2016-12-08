package egovframework.com.ext.jstree.springHibernate.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.CacheMode;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import egovframework.com.ext.jstree.springHibernate.core.util.EventLogManager;
import egovframework.com.ext.jstree.springHibernate.core.util.LogSupport;
import egovframework.com.ext.jstree.springHibernate.core.util.LogSupportActionType;
import egovframework.com.ext.jstree.support.util.SearchSupport;


@SuppressWarnings("unchecked")
public abstract class JsTreeHibernateDaoSupport<T, ID extends Serializable> extends HibernateDaoSupport {
	@Autowired
    private EventLogManager eventLogManager;
    
    protected abstract Class<T> getEntityClass();
    
    public DetachedCriteria createDetachedCriteria(Class<?> clazz) {
        return DetachedCriteria.forClass(clazz);
    }
    
    public DetachedCriteria createDetachedCriteria() {
        return DetachedCriteria.forClass(getEntityClass());
    }
    
    public T getUnique(Criterion criterion) {
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        detachedCriteria.add(criterion);
        
        List<T> list = (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria);
        
        if (list.isEmpty()) {
            return null;
        }
        
        return (T) list.get(0);
    }
    
    public T getUnique(SearchSupport searchSupport) {
        
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        for (Criterion c : searchSupport.getCriterions()) {
            detachedCriteria.add(c);
        }
        
        List<T> list = (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria);
        
        if (list.isEmpty()) {
            return null;
        }
        
        return (T) list.get(0);
    }
    
    public T getUnique(Criterion... criterions) {
        
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        for (Criterion c : criterions) {
            detachedCriteria.add(c);
        }
        
        List<T> list = (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria);
        
        if (list.isEmpty()) {
            return null;
        }
        
        return (T) list.get(0);
    }
    
    public T getUnique(List<Criterion> criterion) {
        
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        for (Criterion c : criterion) {
            detachedCriteria.add(c);
        }
        
        List<T> list = (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria);
        
        if (list.isEmpty()) {
            return null;
        }
        
        return (T) list.get(0);
    }
    
    public List<T> getList(SearchSupport searchSupport) {
        
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        
        for (Order order : searchSupport.getOrder()) {
            detachedCriteria.addOrder(order);
        }
        
        for (Criterion criterion : searchSupport.getCriterions()) {
            detachedCriteria.add(criterion);
        }
        
        return (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria, searchSupport.getPageSize() * (searchSupport.getPageNo() - 1), searchSupport.getPageSize());
    }
    
    public List<T> getList(SearchSupport searchSupport, Criterion... criterion) {
        
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        
        for (Criterion c : criterion) {
            detachedCriteria.add(c);
        }
        
        for (Order order : searchSupport.getOrder()) {
            detachedCriteria.addOrder(order);
        }
        
        return (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria, searchSupport.getPageSize() * (searchSupport.getPageNo() - 1), searchSupport.getPageSize());
    }
    
    public List<T> getGroupByList(SearchSupport searchSupport, String target) {
        
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        
        for (Order order : searchSupport.getOrder()) {
            detachedCriteria.addOrder(order);
        }
        
        for (Criterion criterion : searchSupport.getCriterions()) {
            detachedCriteria.add(criterion);
        }
        
        ProjectionList projectList = Projections.projectionList();
        projectList.add(Projections.groupProperty(target));
        
        detachedCriteria.setProjection(projectList);
        
        return (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria, searchSupport.getPageSize() * (searchSupport.getPageNo() - 1), searchSupport.getPageSize());
    }
    
    public int getGroupByCount(SearchSupport searchSupport, String tagert) {
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        
        for (Criterion criterion : searchSupport.getCriterions()) {
            detachedCriteria.add(criterion);
        }
        
        ProjectionList projectList = Projections.projectionList();
        projectList.add(Projections.groupProperty(tagert));
        
        detachedCriteria.setProjection(projectList);
        
        List<?> l = getHibernateTemplate().findByCriteria(detachedCriteria);
        
        detachedCriteria.setProjection(null);
        
        if (null == l || l.size() == 0) {
            return 0;
        } else {
            return l.size();
        }
    }
    
    
    public Map<String, Long> getGroupByList(SearchSupport searchSupport, String groupProperty, String sumProperty) {
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        Map<String, Long> result = new HashMap<String, Long>();
        for (Criterion criterion : searchSupport.getCriterions()) {
            detachedCriteria.add(criterion);
        }
        
        ProjectionList projectList = Projections.projectionList();
        
        projectList.add(Projections.property(groupProperty));
        projectList.add(Projections.sum(sumProperty));
        projectList.add(Projections.groupProperty(groupProperty));
        
        detachedCriteria.setProjection(projectList);
        
        List<?> l = getHibernateTemplate().findByCriteria(detachedCriteria);
        
        detachedCriteria.setProjection(null);
        
        if (null == l || l.size() == 0) {
            return result;
        } else {
            Iterator<?> ite = l.iterator();
            while(ite.hasNext()){
                Object[] objects = (Object[])ite.next();
                result.put((String)objects[0], (Long)objects[1]);
            }
        }
        
        return result;
    }    
    
    public List<T> getListWithoutPaging(Order order) {
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        detachedCriteria.addOrder(order);
        
        return (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria);
    }
    
    public List<T> getListWithoutPaging(Order order, Criterion... criterion) {
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        for (Criterion c : criterion) {
            detachedCriteria.add(c);
        }
        detachedCriteria.addOrder(order);
        
        return (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria);
    }
    
    public List<T> getListWithoutPaging(DetachedCriteria detachedCriteria) {
        return (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria);
    }
    
    public List<T> getList(DetachedCriteria detachedCriteria, int limit, int offset) {
        return (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria, offset, limit);
    }
    
    public int getCount(Criterion... criterions) {
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        for (Criterion c : criterions) {
            detachedCriteria.add(c);
        }
        
        detachedCriteria.setProjection(Projections.rowCount());
        List<?> l = getHibernateTemplate().findByCriteria(detachedCriteria);
        
        Long total = (Long) l.get(0);
        detachedCriteria.setProjection(null);
        return total.intValue();
    }
    
    public int getCount(SearchSupport searchSupport) {
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        
        for (Criterion c : searchSupport.getCriterions()) {
            detachedCriteria.add(c);
        }
        
        detachedCriteria.setProjection(Projections.rowCount());
        List<?> l = getHibernateTemplate().findByCriteria(detachedCriteria);
        
        if (null == l || l.size() == 0) {
            return 0;
        }
        
        Long total = (Long) l.get(0);
        detachedCriteria.setProjection(null);
        return total.intValue();
    }
    
    public int getCount(SearchSupport searchSupport, List<Criterion> criterions) {
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        
        for (Criterion c : criterions) {
            detachedCriteria.add(c);
        }
        
        detachedCriteria.setProjection(Projections.rowCount());
        List<?> l = getHibernateTemplate().findByCriteria(detachedCriteria);
        
        Long total = (Long) l.get(0);
        detachedCriteria.setProjection(null);
        return total.intValue();
    }
    
    public int getCount(List<Criterion> criterions) {
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        for (Criterion c : criterions) {
            detachedCriteria.add(c);
        }
        
        detachedCriteria.setProjection(Projections.rowCount());
        List<?> l = getHibernateTemplate().findByCriteria(detachedCriteria);
        
        Long total = (Long) l.get(0);
        detachedCriteria.setProjection(null);
        return total.intValue();
    }
    
    public int getSum(List<Criterion> criterions, String propertyName) {
        DetachedCriteria detachedCriteria = createDetachedCriteria();
        detachedCriteria.add(Restrictions.isNotNull(propertyName));
        
        for (Criterion c : criterions) {
            detachedCriteria.add(c);
        }
        
        detachedCriteria.setProjection(Projections.sum(propertyName));
        List<?> l = getHibernateTemplate().findByCriteria(detachedCriteria);
        
        Long sum = (Long) l.get(0);
        detachedCriteria.setProjection(null);
        return sum != null ? sum.intValue() : 0;
    }    
    
    public T find(ID id, LockMode lockMode) {
        return (T) getHibernateTemplate().get(getEntityClass(), id, lockMode);
    }
    
    public T find(ID id, LockMode lockMode, boolean enableCache) {
        Object obj = getHibernateTemplate().get(getEntityClass(), id, lockMode);
        if (null != obj && !enableCache) {
            getHibernateTemplate().refresh(obj);
        }
        
        return (T) obj;
    }
    
    public void refresh(Object entity) {
        getHibernateTemplate().refresh(entity);
    }
    
    public ID store(T newInstance) {
        if (newInstance instanceof LogSupport) {
            LogSupport logSupport = (LogSupport) newInstance;
            eventLogManager.writeLog(LogSupportActionType.ADD, logSupport.getEventLogType(), newInstance, null);
        }
        return (ID) getHibernateTemplate().save(newInstance);
    }
    
    public void storeOrUpdate(T newInstance) {
        if (newInstance instanceof LogSupport) {
            Class<?> clazz = newInstance.getClass();
            long id = getId(newInstance);
            LogSupport logSupport = (LogSupport) newInstance;
            if (id == 0) {
                eventLogManager.writeLog(LogSupportActionType.ADD, logSupport.getEventLogType(), newInstance, null);
            } else {
                Session session = getSessionFactory().openSession();
                Object oldObject = session.get(clazz, id);
                if (null == oldObject) {
                    eventLogManager.writeLog(LogSupportActionType.ADD, logSupport.getEventLogType(), newInstance, null);
                } else {
                    eventLogManager.writeLog(LogSupportActionType.EDIT, logSupport.getEventLogType(), newInstance, oldObject);
                }
                session.close();
            }
            
        }
        getHibernateTemplate().saveOrUpdate(newInstance);
    }
    
    public void storeOrUpdateAdvanced(T newInstance , String columId) {
        if (newInstance instanceof LogSupport) {
            Class<?> clazz = newInstance.getClass();
            long id = getId(newInstance, columId);
            LogSupport logSupport = (LogSupport) newInstance;
            if (id == 0) {
                eventLogManager.writeLog(LogSupportActionType.ADD, logSupport.getEventLogType(), newInstance, null);
            } else {
                Session session = getSessionFactory().openSession();
                Object oldObject = session.get(clazz, id);
                if (null == oldObject) {
                    eventLogManager.writeLog(LogSupportActionType.ADD, logSupport.getEventLogType(), newInstance, null);
                } else {
                    eventLogManager.writeLog(LogSupportActionType.EDIT, logSupport.getEventLogType(), newInstance, oldObject);
                }
                session.close();
            }
            
        }
        getHibernateTemplate().saveOrUpdate(newInstance);
    }
    
    public void modify(T transientObject) {
        if (transientObject instanceof LogSupport) {
            
            Class<?> clazz = transientObject.getClass();
            long id = getId(transientObject);
            Session session = getSessionFactory().openSession();
            Object oldObject = session.get(clazz, id);
            LogSupport logSupport = (LogSupport) transientObject;
            if (null == oldObject) {
                eventLogManager.writeLog(LogSupportActionType.ADD, logSupport.getEventLogType(), transientObject, null);
            } else {
                eventLogManager.writeLog(LogSupportActionType.EDIT, logSupport.getEventLogType(), transientObject, oldObject);
            }
            session.close();
            getHibernateTemplate().merge(transientObject);
        } else {
            getHibernateTemplate().update(transientObject);
        }
    }
    
    public int bulkUpdate(String queryString, Object... value) {
        return getHibernateTemplate().bulkUpdate(queryString, value);
    }
    
    public void delete(T persistentObject) {
        // event log를 남긴다
        if (persistentObject instanceof LogSupport) {
            LogSupport logSupport = (LogSupport) persistentObject;
            eventLogManager.writeLog(LogSupportActionType.DEL, logSupport.getEventLogType(), persistentObject, null);
        }
        getHibernateTemplate().delete(persistentObject);
    }
    
    public void flush() {
        getHibernateTemplate().flush();
    }
    
    public void deleteAll(Collection<T> entities) {
        getHibernateTemplate().deleteAll(entities);
    }
    
    public void bulkInsert(Collection<T> entities) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        session.setCacheMode(CacheMode.IGNORE);
        Transaction tx = session.beginTransaction();
        
        int i = 0;
        for (T t : entities) {
            session.save(t);
            
            if (i % 50 == 0) { // batch size
                session.flush();
                session.clear();
            }
            i++;
        }
        
        tx.commit();
        session.close();
    }
    
    public T excute(HibernateCallback<T> callback) {
        return getHibernateTemplate().execute(callback);
    }
    
    
    private long getId(Object object) {
        String value = "";
        try {
            value = BeanUtils.getProperty(object, "id");
        } catch (Exception e) {
            logger.error("no search instace class id");
        }
        
        return Long.parseLong(value);
    }
    
    //overload
    private long getId(Object object, String columId) {
        String value = "";
        try {
            value = BeanUtils.getProperty(object, columId);
        } catch (Exception e) {
            logger.error("no search instace class id");
        }
        
        return Long.parseLong(value);
    }
    
}
