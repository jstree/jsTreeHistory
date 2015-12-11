package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreServiceImpl;

@Service("BTRVService")
public class BTRV_ServiceImpl extends CoreServiceImpl implements BTRV_Service{
	
	@Resource(name = "BTRVDao")
    private BTRV_DaoImpl btrvDao;
	
	@Transactional(readOnly = false, rollbackFor={Exception.class}, propagation=Propagation.REQUIRED)
    public <T extends BTRV_ComprehensiveTree>List<T> getNodeIds(T comprehensiveTree) throws Exception
    {
    	List<T>  getNodes = (List<T>)btrvDao.getNodeIDs(comprehensiveTree);
        return getNodes;
    }

	@Transactional(readOnly = false, rollbackFor={Exception.class}, propagation=Propagation.REQUIRED)
    public <T extends BTRV_ComprehensiveTree> int alterNodeBT(T comprehensiveTree) throws Exception
    {
        return btrvDao.alterNodeBT(comprehensiveTree);
    }

	@Transactional(readOnly = false, rollbackFor={Exception.class}, propagation=Propagation.REQUIRED)
	public <T extends BTRV_ComprehensiveTree>List<T> getSvnCommitLogs(T comprehensiveTree) throws Exception {
		List<T>  getNodes = (List<T>)btrvDao.getNodeIDs(comprehensiveTree);
        return getNodes;
	}

	@Transactional(readOnly = false, rollbackFor={Exception.class}, propagation=Propagation.REQUIRED)
	public <T extends BTRV_ComprehensiveTree> int updateSvnCommitLog(T comprehensiveTree) throws Exception {
		return btrvDao.alterNodeBT(comprehensiveTree);
	}

}
