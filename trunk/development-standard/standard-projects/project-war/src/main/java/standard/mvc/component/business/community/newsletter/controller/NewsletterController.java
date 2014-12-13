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
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014. 12. 09.  류강하                 최초 생성
 *  2014. 12. 13.  전경훈           EMail 검증부분 추가 및 jstree 필수 파라미터 설정
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
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
    @RequestMapping("/newsletter/addEmail.do")
    public ComprehensiveTree addNode(@ModelAttribute NewsletterComprehensiveTree newsletterComprehensiveTree) throws Exception {
        
        String email = newsletterComprehensiveTree.getEmail();
        
        // Email 검증
        String emailPattern = "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+";
		Pattern p = java.util.regex.Pattern.compile(emailPattern);
        Matcher m = p.matcher(email);
        if(!m.matches()){
        	throw new RuntimeException("EMail address is not valid");
        }
        // addNode를 위한 ComprehensiveTree 필수값 지정
        newsletterComprehensiveTree.setRef(2);
        newsletterComprehensiveTree.setC_title("Mail");
        newsletterComprehensiveTree.setC_type("Mail");
        	
        newsletterService.addNode(newsletterComprehensiveTree);
        
        return newsletterComprehensiveTree;
    }
}
