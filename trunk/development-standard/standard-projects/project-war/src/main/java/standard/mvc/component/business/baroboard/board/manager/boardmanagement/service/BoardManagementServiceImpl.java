package standard.mvc.component.business.baroboard.board.manager.boardmanagement.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.core.manage.setting.messages.ExceptionMessage;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * 
 * Modification Information
 * 
 * @author 정원기
 * @since 2015. 6. 24.
 * @version 1.0
 * @see <pre>
 *  Class Name  : BoardManagementServiceImpl.java
 *  Description : 바로보드-게시판-admin-게시판설정 Service
 *  Information :
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 6. 24.     정원기                  최초생성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service(value = "BoardManagementService")
public class BoardManagementServiceImpl implements CoreService {

    @Resource(name = "CoreService")
    private CoreService boardManagementService;

    @Override
    public <T extends ComprehensiveTree> T getNode(T comprehensiveTree) throws Exception {
        T node = boardManagementService.getNode(comprehensiveTree);
        return node;
    }
    
    @Override
    public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree) throws Exception {
    	int alteredCount = boardManagementService.alterNode(comprehensiveTree);
    	return alteredCount;
    }

    @Override
    public <T extends ComprehensiveTree> List<T> getChildNode(T comprehensiveTree) throws Exception {
    	return boardManagementService.getChildNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> List<String> searchNode(T comprehensiveTree)
            throws Exception {
        throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> T addNode(T comprehensiveTree) throws Exception {
        throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree) throws Exception {
        throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree) throws Exception {
        throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree, HttpServletRequest request)
            throws Exception {
        throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

}
