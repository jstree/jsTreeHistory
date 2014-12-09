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

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.base.controller.GenericAbstractController;
import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;
import egovframework.com.ext.jstree.springiBatis.core.util.Util_TitleChecker;
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
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
//@RequestMapping(value = { "**/**/community" })
public class NewsletterController extends GenericAbstractController {

//    @Resource(name = "MenuService")
//    private CoreService menuService;
    
    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        
        return null;
    }
    
//    /**
//     * 노드를 추가한다.
//     * 
//     * @param menuComprehensiveTree
//     * @param request
//     * @return
//     * @throws InstantiationException
//     * @throws IllegalAccessException
//     */
//    @ResponseBody
//    @RequestMapping("/newsletter/addEmail.do")
//    public ComprehensiveTree addNode(MenuComprehensiveTree menuComprehensiveTree, HttpServletRequest request) throws Exception { // TODO Exception으로 변경
//        
//        // TODO 공통적 파라미터 값 검증 적용
//        
//        String ref = request.getParameter("ref");
//        String c_position = request.getParameter("c_position");
//        String c_title = request.getParameter("c_title");
//        String c_type = request.getParameter("c_type");
//        
//        if (ref == null || c_position == null || c_title == null || c_type == null) {
//            throw new RuntimeException("addNode parameter null");
//        } 
//        
//        if ("0".equals(ref)) {
//            throw new RuntimeException("addNode ref value is 0");
//        }
//    
//        if (Integer.parseInt(c_position) < 0) {
//            throw new RuntimeException("addNode c_postion less 0");
//        }
//        
//        if ("drive".equals(c_type)) {
//            throw new RuntimeException("addNode c_type value is drive");
//        } 
//        else if ( !("default".equals(c_type) || "folder".equals(c_type)) ) {
//            throw new RuntimeException("addNode c_position value is another");
//        }
//        
//        menuComprehensiveTree.setC_title(Util_TitleChecker.StringReplace(menuComprehensiveTree.getC_title()));
//        menuService.addNode(menuComprehensiveTree);
//    
//        return menuComprehensiveTree;
//    }

    
}
