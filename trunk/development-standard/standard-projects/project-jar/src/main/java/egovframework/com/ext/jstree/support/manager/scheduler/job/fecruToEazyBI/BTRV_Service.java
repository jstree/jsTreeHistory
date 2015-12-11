package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import java.util.List;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

public interface BTRV_Service extends CoreService{
	
	public <T extends BTRV_ComprehensiveTree> List<T> getSvnCommitLogs( T comprehensiveTree ) throws Exception;
	public <T extends BTRV_ComprehensiveTree> int updateSvnCommitLog( T comprehensiveTree ) throws Exception;

}
