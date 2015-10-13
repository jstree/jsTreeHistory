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
package standard.mvc.component.business.community.newsletter.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.community.newsletter.vo.Newsletter;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2014. 12. 09.
 * @version 1.0
 * @see <pre>
 *  Class Name  : NewsletterController.java
 *  Description : Newsletter 컨트롤러 클래스
 *  Information : Newsletter 컨트롤러 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일                 수정자                 수정내용
 *  -------        ------------   -----------------------
 *  2014. 12. 09.  류강하                 최초 생성
 *  2014. 12. 13.  전경훈                 Email 검증부분 추가 및 jstree 필수 파라미터 설정
 *  2014. 12. 15.  류강하                 getChildNode() 추가
 *  2014. 12. 19.  류강하                 사용자 및 관리자 화면을 동시 처리하게끔 addNode() 보완, removeNode() 추가
 *  2014. 12. 20.  류강하                 alterNode(), alterNodeType() 추가
 *  2014. 12. 28.  류강하                 searchNode(), moveNode() 추가
 *  2015. 01. 03   류강하                 사용자와 관리자를 위한 로직을 분리하기 위해 관리자 관련 메서드들을 NewsletterAdminController로 옮김.
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping("/newsletter")
public class NewsletterController extends GenericAbstractController {

    @Resource(name = "NewsletterService")
    CoreService newsletterService;
    
    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        
        return null;
    }
    
    /**
     * 이메일을 추가한다.
     * @param newsletterComprehensiveTree Newsletter VO
     * @return Newsletter VO
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/addEmail.do", method = RequestMethod.POST)
    public ComprehensiveTree addNode(@ModelAttribute Newsletter newsletterComprehensiveTree
                                                   , HttpServletRequest request)
            throws Exception {
        
        // 굳이 VO가 아닌 request에서 파라미터를 가져오는 이유는 추후 적용할 값 검증 기술이 어느 것이 될지 모르기 때문임.
        String c_title = request.getParameter("c_title");
        
        if (c_title == null) {
            throw new RuntimeException("addNode()'s essential parameter not set.");
        }
        
        if ( !c_title.matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+") ) {
            throw new RuntimeException("Email address is not valid.");
        }
        
        
        /* 현 시점에는 익명 사용자에 대한 이메일만 접수한다. */
        newsletterComprehensiveTree.setRef(3); // Anonymous Users folder
        newsletterComprehensiveTree.setC_type("default");
        
        newsletterService.addNode(newsletterComprehensiveTree);
        
        return newsletterComprehensiveTree;
    }
    
    /**
     * 이메일을 지운다.
     * @param newsletterComprehensiveTree Newsletter VO
     * @return removed count
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/removeEmail.do")
    public int removeNode(@ModelAttribute Newsletter newsletterComprehensiveTree
                                        , HttpServletRequest request) 
            throws Exception {
        
        String c_id = request.getParameter("c_id");
        
        if (c_id == null) {
            throw new RuntimeException("removeNode()'s essential parameter not set.");
        }
        
        if (!c_id.matches("\\d+")) {
            throw new RuntimeException("removeNode()'s c_id parameter value is not valid.");
        }
        
        if (Integer.parseInt(c_id) < 4) {
            throw new RuntimeException("removeNode()'s c_id parameter value is predefined value.");
        }
        
        return newsletterService.removeNode(newsletterComprehensiveTree);
    }
}
