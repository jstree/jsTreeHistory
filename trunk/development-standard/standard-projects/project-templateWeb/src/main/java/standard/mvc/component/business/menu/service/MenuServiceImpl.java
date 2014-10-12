package standard.mvc.component.business.menu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

@Service(value="MenuService")
public class MenuServiceImpl implements CoreService {

    @Override
    public <T extends ComprehensiveTree> List<T> getChildNode(
            T comprehensiveTree) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T extends ComprehensiveTree> List<String> searchNode(
            T comprehensiveTree) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T extends ComprehensiveTree> T addNode(T comprehensiveTree)
            throws InstantiationException, IllegalAccessException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree) {
        // TODO Auto-generated method stub
        return 0;
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
