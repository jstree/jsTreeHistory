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
package standard.mvc.component.business.baroboard.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import standard.mvc.component.business.baroboard.user.service.UserService;
import standard.mvc.component.business.baroboard.user.vo.User;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 7. 1.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserController.java
 * Description : 바로보드-회원 컨트롤러
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 7. 1.   류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/info/index.do", method = RequestMethod.GET)
    public String userInfoIndex(ModelMap model, User user) throws Exception {
        
        model.addAttribute("passwordFindQuestions", userService.getPasswordFindQuestions());
        
        User userStored = userService.findUserByEmail(user);
        
        String[] split = userStored.getEmail().split("@");
        
        userStored.setEmailAccount(split[0]);
        userStored.setEmailHost(split[1]);
        
        model.addAttribute("user", userStored);
        
        return "/jsp/user/info/index";
    }
}