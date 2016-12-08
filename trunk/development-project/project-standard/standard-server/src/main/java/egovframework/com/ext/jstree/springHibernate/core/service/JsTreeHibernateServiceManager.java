package egovframework.com.ext.jstree.springHibernate.core.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.ext.jstree.springHibernate.core.dao.JsTreeHibernateDao;
import egovframework.com.ext.jstree.support.util.SearchSupport;
import egovframework.com.ext.jstree.support.util.StringUtils;

@Component
public class JsTreeHibernateServiceManager {

	@Autowired
	private JsTreeHibernateDao jsTreeHibernateDao;

	public <T> T get(Class<T> entityClass, long id) {
		return jsTreeHibernateDao.getHibernateTemplate().get(entityClass, id);
	}

	private <T> DetachedCriteria getCriteria(Class<T> entityClass, SearchSupport searchSupport) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

		for (Criterion criterion : searchSupport.getCriterions()) {
			criteria.add(criterion);
		}

		return criteria;
	}

	public <T> int getSum(Class<T> entityClass, SearchSupport searchSupport, String propertyName) {
		DetachedCriteria criteria = getCriteria(entityClass, searchSupport);
		criteria.add(Restrictions.isNotNull(propertyName));
		criteria.setProjection(Projections.sum(propertyName));
		List<?> l = jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria);

		if (CollectionUtils.isEmpty(l)) {
			return 0;
		}

		Long total = (Long) l.get(0);
		criteria.setProjection(null);
		return total != null ? total.intValue() : 0;
	}

	public <T> List<T> getList(Class<T> entityClass) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria);

		if (list.isEmpty()) {
			return null;
		}

		return list;
	}

	public <T> int getCount(Class<T> entityClass, SearchSupport searchSupport) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

		for (Criterion criterion : searchSupport.getCriterions()) {
			criteria.add(criterion);
		}

		criteria.setProjection(Projections.rowCount());
		List<?> l = jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria);

		if (l.size() == 0) {
			return 0;
		}

		Long total = (Long) l.get(0);
		criteria.setProjection(null);
		return total.intValue();
	}

	public <T> int getCountGroupBy(Class<T> entityClass, SearchSupport searchSupport, String groupByCoulum) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

		for (Criterion criterion : searchSupport.getCriterions()) {
			criteria.add(criterion);
		}

		criteria.setProjection(Projections.projectionList().add(
				Projections.groupProperty(groupByCoulum).as(groupByCoulum)));
		List<?> l = jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria);

		if (l.isEmpty()) {
			return 0;
		}

		return l.size();
	}

	public <T> List<T> getList(Class<T> entityClass, Criterion... criterions) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}

		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria);

		if (list.isEmpty()) {
			return null;
		}

		return list;
	}

	public <T> List<T> getList(Class<T> entityClass, List<Criterion> criterions) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}

		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria);

		if (list.isEmpty()) {
			return new ArrayList<>();
		}

		return list;
	}

	public <T> List<T> getList(Class<T> entityClass, List<Criterion> criterions, List<Order> orders) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}

		for (Order order : orders) {
			criteria.addOrder(order);
		}

		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria);

		if (list.isEmpty()) {
			return new ArrayList<>();
		}

		return list;
	}

	public <T> int getCount(Class<T> entityClass, List<Criterion> criterions) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}

		criteria.setProjection(Projections.rowCount());
		List<?> l = jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria);

		if (l.size() == 0) {
			return 0;
		}

		Long total = (Long) l.get(0);
		criteria.setProjection(null);
		return total.intValue();
	}

	public <T> int getSum(Class<T> entityClass, List<Criterion> criterions, String propertyName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}

		criteria.add(Restrictions.isNotNull(propertyName));

		criteria.setProjection(Projections.sum(propertyName));
		List<?> l = jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria);

		if (l.size() == 0) {
			return 0;
		}

		Long total = (Long) l.get(0);
		criteria.setProjection(null);
		return total != null ? total.intValue() : 0;
	}

	public <T> List<T> getList(Class<T> entityClass, SearchSupport searchSupport) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

		for (Criterion criterion : searchSupport.getCriterions()) {
			criteria.add(criterion);
		}

		for (Order order : searchSupport.getOrder()) {
			criteria.addOrder(order);
		}

		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria,
				searchSupport.getPageSize() * (searchSupport.getPageNo() - 1), searchSupport.getPageSize());

		if (list.isEmpty()) {
			return new ArrayList<>();
		}

		return list;
	}

	public <T> T getUnique(Class<T> entityClass, long key) {
		// 커스터마이징한 view table에서 key가 중복될 수 있어 예외 처리함
		if (StringUtils.equals(entityClass.getSimpleName(), "PolViewForTg")) {
			return getUnique(entityClass, Restrictions.eq("id", key));
		}

		return jsTreeHibernateDao.getHibernateTemplate().get(entityClass, key);
	}

	public <T> T getUnique(Class<T> entityClass, String name) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.eq("name", name));

		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria);

		if (list.isEmpty()) {
			return null;
		}

		return list.get(0);
	}

	public <T> T getUnique(Class<T> entityClass, Criterion... criterions) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}

		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria);

		if (list.isEmpty()) {
			return null;
		}

		return list.get(0);
	}

	public <T> T getUnique(Class<T> entityClass, SearchSupport searchSupport) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		for (Criterion criterion : searchSupport.getCriterions()) {
			criteria.add(criterion);
		}

		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) jsTreeHibernateDao.getHibernateTemplate().findByCriteria(criteria);

		if (list.isEmpty()) {
			return null;
		}

		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public <T> T update(Class<T> entityClass) {
		jsTreeHibernateDao.getHibernateTemplate().update(entityClass);
		return (T) entityClass;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public <T> T save(Class<T> entityClass) {
		return (T) jsTreeHibernateDao.getHibernateTemplate().save(entityClass);
	}

}
