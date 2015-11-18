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

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
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
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service.ProhibitionWordService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.ProhibitionWord;
import standard.mvc.component.business.baroboard.user.service.UserService;
import standard.mvc.component.business.baroboard.user.vo.User;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
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
    
    @Resource(name="CoreService")
    private CoreService coreService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private GeneralSettingService generalSettingService;
    
    @Autowired
    private ProhibitionWordService prohibitionWordService;
    
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @RequestMapping(value = "/info/index.do", method = RequestMethod.POST)
    public String userInfoIndex(ModelMap model, User user) throws Exception {
        
        model.addAttribute("generalSetting", generalSettingService.getGeneralSetting());
        model.addAttribute("passwordFindQuestions", userService.getPasswordFindQuestions());
        
        User userStored = coreService.getNode(user);
        
        String[] split = userStored.getEmail().split("@");
        
        userStored.setEmailAccount(split[0]);
        userStored.setEmailHost(split[1]);
        
        model.addAttribute("user", userStored);
        
        return "/jsp/user/info/index";
    }
    
    @RequestMapping(value = "/info/isAvailableEmail.do", method = RequestMethod.POST)
    @ResponseBody
    public String isAvailableEmail(@RequestBody User user) throws Exception {
        
        List<ProhibitionWord> emailProhibitionWords = prohibitionWordService.getEmailProhibitionWords();
        Set<String> prohibitionWords = new HashSet<String>();
        
        for (ProhibitionWord prohibitionWord : emailProhibitionWords) {
            prohibitionWords.add(prohibitionWord.getC_title());
        }
        
        if ( prohibitionWords.contains(user.getEmail()) ) {
            user.setStatus(0);
            user.setAjaxMessage( egovMessageSource.getMessage("bb.user.error.002") );
        }
        else if ( userService.isDuplicateEmail(user) ) {
            user.setStatus(0);
            user.setAjaxMessage( egovMessageSource.getMessage("bb.user.error.004") );
        }
        else {
            user.setStatus(1);
            user.setAjaxMessage( egovMessageSource.getMessage("bb.user.info.001") );
        }
        
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                
                if ( "status".equals(f.getName()) || "ajaxMessage".equals(f.getName()) ) {
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
    
    @RequestMapping(value = "/info/isAvailableNickname.do", method = RequestMethod.POST)
    @ResponseBody
    public String isAvailableNickname(@RequestBody User user) throws Exception {
        
        List<ProhibitionWord> nicknameProhibitionWords = prohibitionWordService.getNicknameProhibitionWords();
        Set<String> prohibitionWords = new HashSet<String>();
        
        for (ProhibitionWord prohibitionWord : nicknameProhibitionWords) {
            prohibitionWords.add(prohibitionWord.getC_title());
        }
        
        if ( prohibitionWords.contains(user.getC_title()) ) {
            user.setStatus(0);
            user.setAjaxMessage( egovMessageSource.getMessage("bb.user.error.003") );
        }
        else if ( userService.isDuplicateNickname(user) ) {
            user.setStatus(0);
            user.setAjaxMessage( egovMessageSource.getMessage("bb.user.error.005") );
        }
        else {
            user.setStatus(1);
            user.setAjaxMessage( egovMessageSource.getMessage("bb.user.info.002") );
        }
        
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                
                if ( "status".equals(f.getName()) || "ajaxMessage".equals(f.getName()) ) {
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
        
        SecureUserLogin userSession = (SecureUserLogin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (userSession.getId() != user.getC_id()) {
            throw new RuntimeException("bb.com.error.004");
        }
        
        user.setEmail(user.getEmailAccount() + "@" + user.getEmailHost());
        
        userService.modifyUserInfo(user);
        
        return "{ \"status\" : \"1\" }";
    }
}