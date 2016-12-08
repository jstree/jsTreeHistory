package egovframework.com.ext.jstree.springHibernate.core.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateBaseDTO;

@Repository
public class JsTreeHibernateDao extends JsTreeHibernateDaoSupport<JsTreeHibernateBaseDTO, Long>{
	
    @Resource(name = "sessionFactory")
    public void init(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
    @Override
    protected Class<JsTreeHibernateBaseDTO> getEntityClass() {
        return JsTreeHibernateBaseDTO.class;
    }
    
    @Override
    public DetachedCriteria createDetachedCriteria() {
        DetachedCriteria detachedCriteria = super.createDetachedCriteria();
        return detachedCriteria;
    }
}
