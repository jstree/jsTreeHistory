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

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.base.controller.GenericAbstractController;
import standard.mvc.component.business.community.newsletter.vo.NewsletterComprehensiveTree;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2014. 12. 09.
 * @version 1.0
 * @see <pre>
 *  Class Name  : NewsletterController.java
 *  Description : Newsletter 컨트롤러 클래스
 *  Infomation  : Newsletter 컨트롤러 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일                 수정자                 수정내용
 *  -------        ------------   -----------------------
 *  2014. 12. 09.  류강하                 최초 생성
 *  2014. 12. 13.  전경훈                 Email 검증부분 추가 및 jstree 필수 파라미터 설정
 *  2014. 12. 15.  류강하                 getChildNode 추가
 *  2014. 12. 19.  류강하                 사용자 및 관리자 화면을 동시 처리하게끔 addNode 보완, removeNode 추가
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
    @RequestMapping("/addEmail.do")
    public ComprehensiveTree addNode(@ModelAttribute NewsletterComprehensiveTree newsletterComprehensiveTree) 
            throws Exception {
        
        String email = newsletterComprehensiveTree.getC_title();
        
        if (!"folder".equals(newsletterComprehensiveTree.getC_type())) {
            
            // Email 검증
            String emailPattern = "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+";
            Pattern p = java.util.regex.Pattern.compile(emailPattern);
            Matcher m = p.matcher(email);
            if (!m.matches()) {
                throw new RuntimeException("Email address is not valid");
            }
            
            // addNode를 위한 ComprehensiveTree 필수값 지정
            if (newsletterComprehensiveTree.getRef() == 0) {
                newsletterComprehensiveTree.setRef(3);
            }
            if (newsletterComprehensiveTree.getC_type() == null) {
                newsletterComprehensiveTree.setC_type("default");
            }
        }
        	
        newsletterService.addNode(newsletterComprehensiveTree);
        
        return newsletterComprehensiveTree;
    }
    
    /**
     * 이메일 목록을 가져온다.
     * @param newsletterComprehensiveTree Newsletter VO
     * @return List<NewsletterComprehensiveTree> Newsletter VO List
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getEmailList.do")
    public List<NewsletterComprehensiveTree> getChildNode(@ModelAttribute NewsletterComprehensiveTree newsletterComprehensiveTree)
             throws Exception {
        
        if (newsletterComprehensiveTree.getC_id() == 0) {
            throw new RuntimeException();
        }
        
        return newsletterService.getChildNode(newsletterComprehensiveTree);
    }
    
    /**
     * 이메일을 지운다.
     * @param newsletterComprehensiveTree Newsletter VO
     * @return removed count
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/removeEmail.do")
    public int removeNode(@ModelAttribute NewsletterComprehensiveTree newsletterComprehensiveTree) 
            throws Exception {
        
        return newsletterService.removeNode(newsletterComprehensiveTree);
    } 
}
