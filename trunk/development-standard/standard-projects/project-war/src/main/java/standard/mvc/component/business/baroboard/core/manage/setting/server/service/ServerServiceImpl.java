package standard.mvc.component.business.baroboard.core.manage.setting.server.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.mvc.exception.GenericServiceRuntimeException;

@Service(value = "ServerService")
public class ServerServiceImpl implements CoreService {

    @Resource(name = "CoreService")
    private CoreService coreService;

    @Override
    public <T extends ComprehensiveTree> T getNode(T comprehensiveTree) throws Exception {
        return null;
    }

    @Override
    public <T extends ComprehensiveTree> List<T> getChildNode(T comprehensiveTree) throws Exception {
        return null;
    }

    @Override
    public <T extends ComprehensiveTree> List<String> searchNode(T comprehensiveTree)
            throws Exception {
        throw new GenericServiceRuntimeException("현재 메뉴에서 지원되지 않는 기능입니다.");
    }

    @Override
    public <T extends ComprehensiveTree> T addNode(T comprehensiveTree) throws Exception {
        throw new GenericServiceRuntimeException("현재 메뉴에서 지원되지 않는 기능입니다.");
    }

    @Override
    public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree) throws Exception {
        throw new GenericServiceRuntimeException("현재 메뉴에서 지원되지 않는 기능입니다.");
    }

    @Override
    public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree) throws Exception {
        return 0;
    }

    @Override
    public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree) throws Exception {
        throw new GenericServiceRuntimeException("현재 메뉴에서 지원되지 않는 기능입니다.");
    }

    @Override
    public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree, HttpServletRequest request)
            throws Exception {
        throw new GenericServiceRuntimeException("현재 메뉴에서 지원되지 않는 기능입니다.");
    }

}
