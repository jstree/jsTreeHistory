package egovframework.com.ext.jstree.springHibernate.core.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import standard.mvc.component.manager.foundation.hibernate.CustomHibernateDaoSupport;
import egovframework.com.ext.jstree.springHibernate.core.vo.P_JsTree;
import egovframework.com.ext.jstree.support.manager.mvc.dao.hibernate.SearchSupport;

@Repository(value="Hibernate_DB_GetChildNode")
public class DB_GetChildNode extends CustomHibernateDaoSupport<P_JsTree, Long>
implements I_DB_GetChildNode 
{

    @Resource(name = "sessionFactory")
    public void init(SessionFactory sessionFactory)
    {
        this.setSessionFactory(sessionFactory);
    }
    
    @Override
    protected Class<P_JsTree> getEntityClass()
    {
        return P_JsTree.class;
    }
    
    @Override
    public List<P_JsTree> getChildNode(P_JsTree p_ComprehensiveTree)
    {
        SearchSupport searchSupport = SearchSupport.getInstance();
        searchSupport.setWhere("C_ID", p_ComprehensiveTree.getC_id());
        return getList(searchSupport);
    }

    @Override
    public List<P_JsTree> getChildNodeByLeftRight(P_JsTree p_ComprehensiveTree)
    {
        SearchSupport searchSupport = SearchSupport.getInstance();
        
        Criterion lhs = Restrictions.gt("C_LEFT", p_ComprehensiveTree.getC_left());
        Criterion rhs = Restrictions.gt("C_RIGHT", p_ComprehensiveTree.getC_right());
        Criterion criterion = Restrictions.and(lhs, rhs);
        
        searchSupport.setWhere(criterion);
        return getList(searchSupport);
    }

    
}
