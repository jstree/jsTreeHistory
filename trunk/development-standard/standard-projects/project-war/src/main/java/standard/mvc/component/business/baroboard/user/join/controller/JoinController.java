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
package standard.mvc.component.business.baroboard.user.join.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import standard.mvc.component.business.baroboard.user.vo.User;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 6. 22.
 * @version 1.0
 * @see <pre>
 * Class Name  : JoinController.java
 * Description : 회원가입-회원가입 컨트롤러
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 22.   류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping("/user/join")
public class JoinController extends GenericAbstractController {

    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.POST)
    public String index() throws Exception {
        
        return "/jsp/user/join/index";
    }
    
    @RequestMapping(value = "/join.do", method = RequestMethod.POST)
    public String join(@Valid User user) throws Exception{
        
        
        
//        String mailId = req.getParameter("mailId");
//        String mailUrl = req.getParameter("mailUrl");
//        
//        
//        User user = new User();
//        user.setC_title(req.getParameter("nickName"));
//        user.setPassword(req.getParameter("password"));
//        user.setEmail(mailId + "@" + mailUrl );
//        
//        userRegisterService.userRegister(user);
        
        return "{}";
    }
}