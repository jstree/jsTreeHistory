package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDaoImpl;

@Repository("BTRVDao")
public class BTRV_DaoImpl extends CoreDaoImpl{
	@SuppressWarnings("unchecked")
	public <T extends BTRV_ComprehensiveTree> List<T> getNodeIDs( T comprehensiveTree ) throws Exception{
		
		return list(comprehensiveTree.getSqlMapSelector() + "." + "getNodeIDs", comprehensiveTree );
	}
	public <T extends BTRV_ComprehensiveTree> int alterNodeBT( T comprehensiveTree ) throws Exception{
		return (Integer)update(comprehensiveTree.getSqlMapSelector() + "." + "alterNodeBT", comprehensiveTree);
	}
}
