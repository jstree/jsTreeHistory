package egovframework.com.ext.jstree.springHibernate.core.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import standard.mvc.component.base.dao.hibernate.SearchSupport;
import standard.mvc.component.manager.foundation.hibernate.CustomHibernateDaoSupport;
import egovframework.com.ext.jstree.springHibernate.core.vo.P_JsTree;

@Repository(value="Hibernate_DB_GetNode")
public class DB_GetNode extends CustomHibernateDaoSupport<P_JsTree, Long>
		implements I_DB_GetNode {

	@Resource(name = "sessionFactory")
	public void init(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	protected Class<P_JsTree> getEntityClass() {
		return P_JsTree.class;
	}
	
	@Override
    public DetachedCriteria createDetachedCriteria() {
        DetachedCriteria detachedCriteria = super.createDetachedCriteria();
        return detachedCriteria;
    }

	@Override
	public P_JsTree getNode(P_JsTree p_ComprehensiveTree,
			String determineDBSetting) {
		
		SearchSupport searchSupport = SearchSupport.getInstance();
		searchSupport.setWhere("C_ID", p_ComprehensiveTree.getC_id());
		
		return getUnique(searchSupport);
	}

	@Override
	public P_JsTree getNodeByRef(P_JsTree p_ComprehensiveTree,
			String determineDBSetting) {
		
		SearchSupport searchSupport = SearchSupport.getInstance();
		searchSupport.setWhere("C_ID", p_ComprehensiveTree.getRef());
		
		return getUnique(searchSupport);
	}

}
