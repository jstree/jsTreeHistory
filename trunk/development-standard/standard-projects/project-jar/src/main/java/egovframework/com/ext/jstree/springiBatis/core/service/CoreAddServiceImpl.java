package egovframework.com.ext.jstree.springiBatis.core.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

@Service("CoreAddService")
public class CoreAddServiceImpl implements CoreAddService
{
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource(name = "CoreDao")
    private CoreDao coreDao;
    
    @Transactional(readOnly = false, rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
    public void txTest() throws Exception
    {
        logger.info("txTest Runnung");
        ComprehensiveTree comprehensiveTree = new ComprehensiveTree();
        comprehensiveTree.setC_id(100);
        comprehensiveTree.setC_parentid(1);
        comprehensiveTree.setC_position(0);
        comprehensiveTree.setC_left(100);
        comprehensiveTree.setC_right(101);
        comprehensiveTree.setC_level(100);
        comprehensiveTree.setC_title("test");
        comprehensiveTree.setC_type("default");
        int seqResult = coreDao.addMyselfFromJstree(comprehensiveTree);
        if (seqResult > 0) { throw new RuntimeException("tx test"); }
    }
}
