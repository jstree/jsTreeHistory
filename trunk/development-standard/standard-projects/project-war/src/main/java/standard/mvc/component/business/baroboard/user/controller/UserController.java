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

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service.GeneralSettingService;
import standard.mvc.component.business.baroboard.user.service.UserService;
import standard.mvc.component.business.baroboard.user.vo.User;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLogin;

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
public class UserController extends GenericAbstractController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private GeneralSettingService generalSettingService;
    
    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @RequestMapping(value = "/info/index.do", method = RequestMethod.GET)
    public String userInfoIndex(ModelMap model, User user) throws Exception {
        
        model.addAttribute("generalSetting", generalSettingService.getGeneralSetting());
        model.addAttribute("passwordFindQuestions", userService.getPasswordFindQuestions());
        
        User userStored = userService.findUserByEmail(user);
        
        String[] split = userStored.getEmail().split("@");
        
        userStored.setEmailAccount(split[0]);
        userStored.setEmailHost(split[1]);
        
        model.addAttribute("user", userStored);
        
        return "/jsp/user/info/index";
    }
    
    @RequestMapping(value = "/info/isDuplicateEmail.do", method = RequestMethod.POST)
    @ResponseBody
    public String isDuplicateEmail(@RequestBody User user) throws Exception {
        
        if ( userService.isDuplicateEmail(user) ) {
            user.setStatus(1);
        } else {
            user.setStatus(0);
        }
        
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                
                if ("status".equals(f.getName())) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
            
        }).create();
        
        return gson.toJson(user);
    }
    
    @RequestMapping(value = "/info/isDuplicateNickname.do", method = RequestMethod.POST)
    @ResponseBody
    public String isDuplicateNickname(@RequestBody User user) throws Exception {
        
        if ( userService.isDuplicateNickname(user) ) {
            user.setStatus(1);
        } else {
            user.setStatus(0);
        }
        
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                
                if ("status".equals(f.getName())) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
            
        }).create();
        
        return gson.toJson(user);
    }
    
    @RequestMapping(value = "/info/modify.do", method = RequestMethod.POST)
    @ResponseBody
    public String modifyUserInfo(@Valid User user) throws Exception {
        
        user.setEmail(user.getEmailAccount() + "@" + user.getEmailHost());
        
        SecureUserLogin userSession = (SecureUserLogin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (! userSession.getUsername().equals( user.getEmail() )) {
            throw new RuntimeException("bb.com.error.004");
        }
        
        userService.modifyUserInfo(user);
        
        return "{ \"status\" : \"1\" }";
    }
}