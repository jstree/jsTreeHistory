package standard.mvc.component.business.community.menu.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
            T comprehensiveTree) throws Exception {
        
        List<T> childNodes = coreService.getChildNode(comprehensiveTree);
        
        return childNodes;
    }

    @Override
    public <T extends ComprehensiveTree> List<String> searchNode( T comprehensiveTree ) throws Exception {
        // TODO Auto-generated method stub
        return coreService.searchNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> T addNode(T comprehensiveTree)
    		 throws Exception {

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
        // TODO Auto-generated method stub
        return coreService.alterNodeType(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> T moveNode( T                  comprehensiveTree
                                                   , HttpServletRequest request ) throws Exception{
        // TODO Auto-generated method stub
        return coreService.moveNode(comprehensiveTree, request);
    }

    @Override
    public <T extends ComprehensiveTree> T getNode(T comprehensiveTree) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
}