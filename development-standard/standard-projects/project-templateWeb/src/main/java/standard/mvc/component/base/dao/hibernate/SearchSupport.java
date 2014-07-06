package standard.mvc.component.base.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;

import standard.mvc.util.StringUtils;


public class SearchSupport {
	   private int pageNo = 1;
	    private int pageSize = 50;
	    private List<Order> order = new ArrayList<>();
	    private List<Criterion> criterions = new ArrayList<>();
	    private Projection projection;
	    private Map<String, Object> whereMap = new HashMap<>();
	    private int whereCount = 0;
	    
	    public int getPageNo() {
	        return pageNo;
	    }
	    
	    public void setPageNo(int pageNo) {
	        this.pageNo = pageNo;
	    }
	    
	    public int getPageSize() {
	        return pageSize;
	    }
	    
	    public void setPageSize(int pageSize) {
	        this.pageSize = pageSize;
	    }
	    
	    public List<Order> getOrder() {
	        if (order.size() == 0) {
	            setOrder(Order.desc("id"));
	        }
	        return order;
	    }
	    
	    public void setOrder(Order order) {
	        this.order.add(order);
	    }
	    
	    public List<Criterion> getCriterions() {
	        return criterions;
	    }
	    
	    public String getWhereMap(String key) {
	        if (this.whereMap.containsKey(key)) {
	            String value = (String) whereMap.get(key);
	            
	            return " \"" + StringUtils.replace(value, "\"", "\\\"") + "\"";
	        }
	        return " \"\"";
	    }
	    
	    public int getWhereCount() {
	        return whereCount;
	    }
	    
	    public void setWhere(String propertyName, Object value) {
	        if (null == value) {
	            return;
	        }
	        
	        this.whereMap.put(propertyName, value);
	        this.whereCount++;
	        
	        if (value instanceof String) {
	            String str = (String) value;
	            
	            if (!StringUtils.isEmpty(str)) {
	                if (StringUtils.startsWith(str, "*") && StringUtils.endsWith(str, "*")) {
	                    str = StringUtils.removeEnd(str, "*");
	                    str = StringUtils.removeStart(str, "*");
	                    criterions.add(Restrictions.like(propertyName, str, MatchMode.ANYWHERE));
	                } else if (StringUtils.startsWith(str, "*")) {
	                    str = StringUtils.removeStart(str, "*");
	                    criterions.add(Restrictions.like(propertyName, str, MatchMode.END));
	                } else if (StringUtils.endsWith(str, "*")) {
	                    str = StringUtils.removeEnd(str, "*");
	                    criterions.add(Restrictions.like(propertyName, str, MatchMode.START));
	                } else if (StringUtils.startsWith(str, "isNotNull")) {
	                    criterions.add(Restrictions.isNotNull(propertyName));
	                } else {
	                    criterions.add(Restrictions.eq(propertyName, str));
	                }
	            }
	        } else {
	            criterions.add(Restrictions.eq(propertyName, value));
	        }
	    }
	    
	    public void setWhereLike(String propertyName, String str) {
	        if (!StringUtils.isEmpty(str)) {
	            criterions.add(Restrictions.like(propertyName, str, MatchMode.ANYWHERE));
	        }
	    }
	    
	    public void setWhereOr(Criterion...criterions) {
	        Disjunction or = Restrictions.disjunction();
	        for (Criterion criterion : criterions) {
	            or.add(criterion);
	        }
	        this.criterions.add(or);
	    }
	    
	    public void setWhereOr(List<Criterion> criterions) {
	        Disjunction or = Restrictions.disjunction();
	        for (Criterion criterion : criterions) {
	            or.add(criterion);
	        }
	        this.criterions.add(or);
	    }
	    
	    public void setWhere(Criterion criterion) {
	        criterions.add(criterion);
	    }
	    
	    public void setWhere(Projection projection) {
	    	this.projection = projection;
	    }
	    
	    public Projection getProjection() {
			return projection;
		}

		public void setWhereBetween(String propertyName, Object lo, Object hi) {
	        if (null != lo && null != hi) {
	            criterions.add(Restrictions.between(propertyName, lo, hi));
	        }
	    }
	    
	    public void setWhereIn(String propertyName, Collection<?> values) {
	        criterions.add(Restrictions.in(propertyName, values));
	    }
	    
	    public void setWhereIn(String propertyName, Object[] values) {
	        criterions.add(Restrictions.in(propertyName, values));
	    }
	    
	    public static SearchSupport getInstance() {
	        SearchSupport searchSupport = new SearchSupport();
	        searchSupport.setPageSize(65535);
	        return searchSupport;
	    }
	    
	    public int getFirstResult() {
	        return getPageSize() * (getPageNo() - 1);
	    }
	    
	    public int getMaxResult() {
	        return getPageSize();
	    }
	    
	}
