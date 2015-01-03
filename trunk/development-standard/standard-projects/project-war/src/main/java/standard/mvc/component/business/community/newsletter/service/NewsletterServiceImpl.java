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
package standard.mvc.component.business.community.newsletter.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.community.newsletter.dao.NewsletterDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2014. 12. 09.
 * @version 1.0
 * @see <pre>
 *  Class Name  : NewsletterServiceImpl.java
 *  Description : Newsletter Service 클래스
 *  Infomation  : Newsletter Service 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일                 수정자                 수정내용
 *  -------        ------------   -----------------------
 *  2014. 12. 09.  류강하                 최초 생성
 *  2014. 12. 13   전경훈                 removeNode 구현
 *  2014. 12. 15.  류강하                 getChildNode 추가
 *  2014. 12. 20.  류강하                 alterNode, alterNodeType 추가
 *  2014. 12. 28.  류강하                 searchNode, moveNode 추가
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service("NewsletterService")
public class NewsletterServiceImpl implements CoreService {
    
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Resource(name = "NewsletterDao")
    private NewsletterDao newsletterDao;
    
    @Override
    public <T extends ComprehensiveTree> List<T> getChildNode(T comprehensiveTree) 
            throws Exception {
        
        return coreService.getChildNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> List<String> searchNode(T comprehensiveTree) 
            throws Exception {
        
        return coreService.searchNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> T addNode(T comprehensiveTree)
            throws Exception {

        // TODO searchNode 메서드는 LIKE 검색을 하기 때문에 대체 메서드가 필요함.
//        if (중복 이메일이 존재하면) {
//            throw new RuntimeException("The email address already exist.");
//        }
        
        comprehensiveTree.setC_position( getMaxPositionForAddNode(comprehensiveTree) + 1 );
        
        return coreService.addNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree)
            throws Exception {
        
        return coreService.removeNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree)
            throws Exception {
        
        return coreService.alterNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree)
            throws Exception {
        
        return coreService.alterNodeType(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree,
            HttpServletRequest request) throws Exception {
        
        return coreService.moveNode(comprehensiveTree, request);
    }

    /**
     * 
     * @param newsletterComprehensiveTree NewsletterVO
     * @return 특정 부모의 자식들 중 position 값이 가장 큰, 가장 최근에 추가된 노드의 position 값을 반환한다.
     * @throws Exception
     */
    private <T extends ComprehensiveTree> int getMaxPositionForAddNode(T comprehensiveTree) throws Exception {
        
        return newsletterDao.getMaxPositionForAddNode(comprehensiveTree);
    }
}