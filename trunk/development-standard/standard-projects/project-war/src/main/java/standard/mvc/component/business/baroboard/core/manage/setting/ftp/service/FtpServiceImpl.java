package standard.mvc.component.business.baroboard.core.manage.setting.ftp.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.core.manage.setting.messages.ExceptionMessage;
import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.mvc.exception.GenericServiceRuntimeException;

/**
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 5. 29.
 * @version 1.0
 * @see <pre>
 *  Class Name  : FtpServiceImpl.java
 *  Description : 바로보드-코어-고급설정-FTP Service
 *  Infomation  :
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 5. 29.        손호성                  최초생성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service(value = "FtpService")
public class FtpServiceImpl implements CoreService {

    @Resource(name = "CoreDao")
    private CoreDao coreDao;

    @Override
    public <T extends ComprehensiveTree> T getNode(T comprehensiveTree) throws Exception {
        T node = coreDao.getNode(comprehensiveTree);
        return node;
    }

    @Override
    public <T extends ComprehensiveTree> List<T> getChildNode(T comprehensiveTree) throws Exception {
        List<T> bunchOfChildNodes = coreDao.getChildNode(comprehensiveTree);
        return bunchOfChildNodes;
    }

    @Override
    public <T extends ComprehensiveTree> List<String> searchNode(T comprehensiveTree)
            throws Exception {
        throw new GenericServiceRuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> T addNode(T comprehensiveTree) throws Exception {
        throw new GenericServiceRuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree) throws Exception {
        throw new GenericServiceRuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree) throws Exception {
        int alteredCount = coreDao.alterNode(comprehensiveTree);
        return alteredCount;
    }

    @Override
    public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree) throws Exception {
        // TODO Auto-generated method stub
        throw new GenericServiceRuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree, HttpServletRequest request)
            throws Exception {
        throw new GenericServiceRuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

}