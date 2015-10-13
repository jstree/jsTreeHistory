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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
 * @since 2015. 01. 03.
 * @version 1.0
 * @see <pre>
 *  Class Name  : NewsletterAdminController.java
 *  Description : Newsletter 관리 컨트롤러 클래스
 *  Information : Newsletter 관리 컨트롤러 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일                 수정자                 수정내용
 *  -------        ------------   -----------------------
 *  2015. 01. 03.  류강하                 최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping("/newsletterAdmin")
public class NewsletterAdminController extends GenericAbstractController {
    
    @Resource(name = "NewsletterService")
    CoreService newsletterService;
    
    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        // TODO Auto-generated method stub
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
        String ref = request.getParameter("ref");
        String c_position = request.getParameter("c_position");
        String c_title = request.getParameter("c_title");
        String c_type = request.getParameter("c_type");
        
        if ( ref == null || c_position == null || c_title == null || c_type == null ) {
            throw new RuntimeException("addNode()'s essential parameter is not set.");
        }
        
        if ( !ref.matches("\\d+") || !c_position.matches("\\d+") ) {
            throw new RuntimeException("addNode()'s ref or c_position parameter value is not valid.");
        }
        
        if ("drive".equals(c_type)) {
            throw new RuntimeException("addNode()'s c_type parameter value is drive.");
        }
        else if ( !("default".equals(c_type) || "folder".equals(c_type)) ) {
            throw new RuntimeException("addNode()'s c_type parameter value is not valid.");
        }
        
        
        if ( "default".equals(newsletterComprehensiveTree.getC_type()) ) {
            
            if ( !newsletterComprehensiveTree.getC_title().matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+") ) {
                throw new RuntimeException("Email address is not valid.");
            }
        }
        
        return newsletterService.addNode(newsletterComprehensiveTree);
    }
    
    /**
     * 이메일 목록을 가져온다.
     * @param newsletterComprehensiveTree Newsletter VO
     * @return List<Newsletter> Newsletter VO List
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getEmailList.do", method = RequestMethod.GET)
    public List<Newsletter> getChildNode(@ModelAttribute Newsletter newsletterComprehensiveTree)
             throws Exception {
        
        if (newsletterComprehensiveTree.getC_id() == 0) {
            throw new RuntimeException();
        }
        
        return newsletterService.getChildNode(newsletterComprehensiveTree);
    }
    
    /**
     * 이메일을 지운다.
     * @param newsletterComprehensiveTree Newsletter VO
     * @return Newsletter VO
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/removeEmail.do", method = RequestMethod.POST)
    public ComprehensiveTree removeNode(@ModelAttribute Newsletter newsletterComprehensiveTree
                                        , HttpServletRequest request) 
            throws Exception {
        
        String c_id = request.getParameter("c_id");
        
        if (c_id == null) {
            throw new RuntimeException("removeNode()'s essential parameter is not set.");
        }
        
        if (!c_id.matches("\\d+")) {
            throw new RuntimeException("removeNode()'s c_id parameter value is not valid.");
        }
        
        if (Integer.parseInt(c_id) < 4) {
            throw new RuntimeException("removeNode()'s c_id parameter value is not acceptable.");
        }
        
        newsletterComprehensiveTree.setStatus(newsletterService.removeNode(newsletterComprehensiveTree));
        
        return newsletterComprehensiveTree;
    }
    
    /**
     * 이메일 주소를 변경한다.
     * @param newsletterComprehensiveTree Newsletter VO
     * @return alterd count
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/renameEmail.do", method = RequestMethod.POST)
    public ComprehensiveTree alterNode(@ModelAttribute Newsletter newsletterComprehensiveTree
                                                     , HttpServletRequest request)
             throws Exception {
        
        String c_id = request.getParameter("c_id");
        String c_title = request.getParameter("c_title");
        String c_type = request.getParameter("c_type");
        
        if ( c_id == null || c_title == null || c_type == null ) {
            throw new RuntimeException("alterNode()'s essential parameter is not set.");
        }
        
        if (!c_id.matches("\\d+")) {
            throw new RuntimeException("alterNode()'s c_id parameter value is not valid.");
        }
        
        if (Integer.parseInt(c_id) < 4) {
            throw new RuntimeException("alterNode()'s c_id parameter value is not acceptable.");
        }
        
        if ("drive".equals(c_type)) {
            throw new RuntimeException("alterNode()'s c_type parameter value is drive.");
        }
        else if ( !("default".equals(c_type) || "folder".equals(c_type)) ) {
            throw new RuntimeException("alterNode()'s c_type parameter value is not valid.");
        }
        
        
        if ( "default".equals(newsletterComprehensiveTree.getC_type()) ) {
            
            if ( !newsletterComprehensiveTree.getC_title().matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+") ) {
                throw new RuntimeException("Email address is not valid.");
            }
        }
        
        newsletterComprehensiveTree.setStatus(newsletterService.alterNode(newsletterComprehensiveTree));

        return newsletterComprehensiveTree;
    }
    
    /**
     * 이메일 타입을 변경한다.
     * @param newsletterComprehensiveTree Newsletter VO
     * @return Newsletter VO
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/alterNodeType.do", method = RequestMethod.POST)
    public ComprehensiveTree alterNodeType(@ModelAttribute Newsletter newsletterComprehensiveTree
                                                         , HttpServletRequest request) 
            throws Exception {
        
        String c_id = request.getParameter("c_id");
        String c_title = request.getParameter("c_title");
        String c_type = request.getParameter("c_type");
        
        if ( c_id == null || c_title == null || c_type == null ) {
            throw new RuntimeException("alterNodeType()'s essential parameter is not set.");
        }
        
        if (!c_id.matches("\\d+")) {
            throw new RuntimeException("alterNodeType()'s ref or c_position parameter value is not valid.");
        }
        
        if (Integer.parseInt(c_id) < 4) {
            throw new RuntimeException("alterNodeType()'s c_id parameter value is not acceptable.");
        }
        
        if ("drive".equals(c_type)) {
            throw new RuntimeException("alterNodeType()'s c_type parameter value is drive.");
        }
        else if ( !("default".equals(c_type) || "folder".equals(c_type)) ) {
            throw new RuntimeException("alterNodeType()'s c_type parameter value is not valid.");
        }
        
        
        if ( "default".equals(newsletterComprehensiveTree.getC_type()) ) {
            
            if ( !newsletterComprehensiveTree.getC_title().matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+") ) {
                throw new RuntimeException("Email address is not valid.");
            }
        }
        
        newsletterService.alterNodeType(newsletterComprehensiveTree);
        
        return newsletterComprehensiveTree;
    }
    
    /**
     * 이메일을 검색한다.
     * @param newsletterComprehensiveTree Newsletter VO
     * @return TODO
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/searchEmail.do", method = RequestMethod.GET)
    public List<String> searchNode(@ModelAttribute Newsletter newsletterComprehensiveTree
                                                 , HttpServletRequest request) 
            throws Exception {
        
        String searchString = request.getParameter("searchString");
        
        if (searchString == null) {
            throw new RuntimeException("searchNode()'s essential parameter is not set.");
        }
        
        if (!StringUtils.hasText(searchString)) {
            throw new RuntimeException("searchNode()'s searchString parameter is empty.");
        }
        
        return newsletterService.searchNode(newsletterComprehensiveTree);
    }
    
    /**
     * 이메일을 이동한다.
     * @param newsletterComprehensiveTree Newsletter VO
     * @param request Request
     * @return Newsletter VO
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/moveEmail.do", method = RequestMethod.POST)
    public ComprehensiveTree moveNode(@ModelAttribute Newsletter newsletterComprehensiveTree
                                                    , HttpServletRequest request)
            throws Exception {
        
        newsletterService.moveNode(newsletterComprehensiveTree, request);
        
        return newsletterComprehensiveTree;
    }
}
