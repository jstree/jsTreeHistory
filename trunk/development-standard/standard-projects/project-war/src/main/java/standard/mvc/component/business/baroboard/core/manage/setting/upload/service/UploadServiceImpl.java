package standard.mvc.component.business.baroboard.core.manage.setting.upload.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.core.manage.setting.messages.ExceptionMessage;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.mvc.exception.GenericServiceRuntimeException;

@Service(value = "UploadService")
public class UploadServiceImpl implements CoreService {

    @Resource(name = "CoreService")
    private CoreService coreService;

    @Override
    public <T extends ComprehensiveTree> T getNode(T comprehensiveTree) throws Exception {
        T node = coreService.getNode(comprehensiveTree);
        return node;
    }

    @Override
    public <T extends ComprehensiveTree> List<T> getChildNode(T comprehensiveTree) throws Exception {
        List<T> bunchOfChildNodes = coreService.getChildNode(comprehensiveTree);
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
        int alteredCount = coreService.alterNode(comprehensiveTree);
        return alteredCount;
    }

    @Override
    public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree) throws Exception {
        throw new GenericServiceRuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree, HttpServletRequest request)
            throws Exception {
        throw new GenericServiceRuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

}
