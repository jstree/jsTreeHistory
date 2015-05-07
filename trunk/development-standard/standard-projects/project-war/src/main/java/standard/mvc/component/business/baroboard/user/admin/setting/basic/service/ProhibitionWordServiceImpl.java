/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package standard.mvc.component.business.baroboard.user.admin.setting.basic.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.user.admin.setting.basic.vo.ProhibitionWord;
import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 3.
 * @version 1.0
 * @see <pre>
 * Class Name  : ProhibitionWordServiceImpl.java
 * Description : 바로보드-회원관리-금지단어 Service 클래스
 * Infomation  : 바로보드-회원관리-금지단어 Service 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 5.  3.  류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service
public class ProhibitionWordServiceImpl implements ProhibitionWordService {

    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Resource(name = "CoreDao")
    private CoreDao coreDao;
    
    @Override
    public <T extends ComprehensiveTree> List<T> getChildNode(
            T comprehensiveTree) throws Exception {
        
        return coreService.getChildNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> List<String> searchNode(
            T comprehensiveTree) throws Exception {
        
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends ComprehensiveTree> T addNode(T comprehensiveTree)
            throws Exception {
        
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree)
            throws Exception {
        
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree)
            throws Exception {
        
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree)
            throws Exception {
        
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree,
            HttpServletRequest request) throws Exception {
        
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends ComprehensiveTree> List<T> getEmailProhibitionWords() throws Exception {
        
        ProhibitionWord emailBranchNode = new ProhibitionWord();
        emailBranchNode.setC_id(3);
        
        return (List<T>) coreDao.getNodeByRef(emailBranchNode);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends ComprehensiveTree> List<T> getNicknameProhibitionWords() throws Exception {
        
        ProhibitionWord emailBranchNode = new ProhibitionWord();
        emailBranchNode.setC_id(4);
        
        return (List<T>) coreDao.getNodeByRef(emailBranchNode);
    }

    @Override
    public <T extends ComprehensiveTree> T addEmailProhibitionWord(T comprehensiveTree) 
            throws Exception {
        
        if (comprehensiveTree.getRef() != 3) {
            throw new RuntimeException("이메일 브랜치 노드의 자식이 아닙니다.");
        }
        
        if (!"default".equals(comprehensiveTree.getC_type())) {
            throw new RuntimeException("리프 노드만 추가될 수 있습니다.");
        }
        
        return coreService.addNode(comprehensiveTree);
    }
    
    @Override
    public <T extends ComprehensiveTree> T addNicknameProhibitionWord(T comprehensiveTree) 
            throws Exception {
        
        if (comprehensiveTree.getRef() != 4) {
            throw new RuntimeException("닉네임 브랜치 노드의 자식이 아닙니다.");
        }
        
        if (!"default".equals(comprehensiveTree.getC_type())) {
            throw new RuntimeException("리프 노드만 추가될 수 있습니다.");
        }
        
        return coreService.addNode(comprehensiveTree);
    }

    @Override
    public int deleteEmailProhibitionWords() throws Exception {

        ProhibitionWord emailBranchNode = new ProhibitionWord();
        emailBranchNode.setC_id(3);
        
        return deleteCommonProhibitionWords(emailBranchNode);
    }

    @Override
    public int deleteNicknameProhibitionWords() throws Exception {
        
        ProhibitionWord nicknameBranchNode = new ProhibitionWord();
        nicknameBranchNode.setC_id(4);
        
        return deleteCommonProhibitionWords(nicknameBranchNode);
    }
    
    private int deleteCommonProhibitionWords(ProhibitionWord branchNode) throws Exception {
        
        List<ProhibitionWord> children = coreService.getChildNode(branchNode);
        
        int affectedRowCount = 0;
        
        for (ProhibitionWord nodeToDelete : children) {
            
            coreService.removeNode(nodeToDelete);
            ++affectedRowCount;
        }
        
        return affectedRowCount;
    }
    
    @Override
    public int saveEmailProhibitionWords(List<ProhibitionWord> emailProhibitionWords) 
            throws Exception {
        
        int affectedRowCount = 0;
        
        deleteEmailProhibitionWords();
        
        for (ProhibitionWord emailProhibitionWord : emailProhibitionWords) {
            
            addEmailProhibitionWord( emailProhibitionWord );
            ++affectedRowCount;
        }
        
        return affectedRowCount;
    }
    
    @Override
    public int saveNicknameProhibitionWords(List<ProhibitionWord> nicknameProhibitionWords) 
            throws Exception {
        
        int affectedRowCount = 0;
        
        deleteNicknameProhibitionWords();
        
        for (ProhibitionWord nicknameProhibitionWord : nicknameProhibitionWords) {
            
            addNicknameProhibitionWord( nicknameProhibitionWord );
            ++affectedRowCount;
        }
        
        return affectedRowCount;
    }
}