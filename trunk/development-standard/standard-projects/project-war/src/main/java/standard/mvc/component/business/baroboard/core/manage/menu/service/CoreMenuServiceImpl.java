package standard.mvc.component.business.baroboard.core.manage.menu.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.core.manage.setting.messages.ExceptionMessage;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * 
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 7. 5.
 * @version 1.0
 * @see <pre>
 * Class Name  : CoreMenuServiceImpl.java
 * Description : 바로보드-코어-메뉴 Service
 * Infomation  :
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 7. 5.          손호성                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service(value = "CoreMenuService")
public class CoreMenuServiceImpl implements CoreService {

    @Resource(name = "CoreService")
    CoreService coreService;

    @Override
    public <T extends ComprehensiveTree> T getNode(T comprehensiveTree) throws Exception {
		return coreService.getNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> List<T> getChildNode(T comprehensiveTree) throws Exception {
		List<T> bunchOfChildNodes = coreService.getChildNode(comprehensiveTree);
		return bunchOfChildNodes;
    }

    @Override
    public <T extends ComprehensiveTree> List<String> searchNode(T comprehensiveTree)
            throws Exception {
        throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> T addNode(T comprehensiveTree) throws Exception {
		return coreService.addNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree) throws Exception {
        return coreService.removeNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree) throws Exception {
        return coreService.alterNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree) throws Exception {
        throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree, HttpServletRequest request)
            throws Exception {
        return coreService.moveNode(comprehensiveTree, request);
    }
}
