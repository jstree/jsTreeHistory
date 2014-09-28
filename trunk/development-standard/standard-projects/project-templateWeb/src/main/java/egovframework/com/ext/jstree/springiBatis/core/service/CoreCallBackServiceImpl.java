package egovframework.com.ext.jstree.springiBatis.core.service;

import org.cometd.java.annotation.Service;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

@Service("CoreCallBackService")
public class CoreCallBackServiceImpl implements CoreCallBackService {

    @Override
    public <T extends ComprehensiveTree> boolean excute(T comprehensiveTree) {
        // TODO Auto-generated method stub
        return false;
    }

}
