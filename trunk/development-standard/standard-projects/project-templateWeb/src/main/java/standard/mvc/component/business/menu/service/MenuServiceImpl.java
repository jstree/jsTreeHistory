package standard.mvc.component.business.menu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2014. 10. 12.
 * @version 1.0
 * @see <pre>
 *  Class Name  : MenuServiceImpl.java
 *  Description : jstree Spring + iBatis 버젼의 메뉴 서비스 구현체
 *  Infomation  : jstree 코어 기능은 코어 서비스를 사용하고, 추가적인 메뉴 관련 작업을 처리하는 클래스이다.
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014. 10. 12.  류강하                 최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service("MenuService")
public class MenuServiceImpl implements CoreService {

    @Resource(name = "CoreService")
    CoreService coreService;
    
    @Override
    public <T extends ComprehensiveTree> List<T> getChildNode(
            T comprehensiveTree) {
        
        List<T> childNodes = coreService.getChildNode(comprehensiveTree);
        
        return childNodes;
    }

    @Override
    public <T extends ComprehensiveTree> List<String> searchNode(
            T comprehensiveTree) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T extends ComprehensiveTree> T addNode(T comprehensiveTree)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        return coreService.addNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree) {
        
        return coreService.removeNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree) {
        
        return coreService.alterNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree)
            throws InstantiationException, IllegalAccessException,
            ReflectiveOperationException {
        // TODO Auto-generated method stub
        return null;
    }

}
