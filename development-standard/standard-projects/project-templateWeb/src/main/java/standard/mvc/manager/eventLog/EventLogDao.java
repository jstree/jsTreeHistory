package standard.mvc.manager.eventLog;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import standard.mvc.dao.hibernate.CustomHibernateDaoSupport;


@Repository
public class EventLogDao extends CustomHibernateDaoSupport<EventLog, Long> {
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