package standard.mvc.component.business.menu.service;


import org.springframework.stereotype.Service;

import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreCallBackService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

@Service(value="MenuCallBackService")
public class MenuCallBackService implements CoreCallBackService {

    @Override
    public <T extends ComprehensiveTree> boolean excute(T comprehensiveTree) {
        
        if(comprehensiveTree instanceof MenuComprehensiveTree){
            //형변환을 해서. url 을 가져올수있다.
        }
        
        return true;
    }

}
