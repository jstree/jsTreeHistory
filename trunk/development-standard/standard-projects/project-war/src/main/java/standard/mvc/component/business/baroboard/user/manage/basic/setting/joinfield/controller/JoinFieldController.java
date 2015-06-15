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
package standard.mvc.component.business.baroboard.user.manage.basic.setting.joinfield.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.joinfield.service.JoinFieldService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.joinfield.vo.JoinField;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : JoinFieldController.java
 * Description : 바로보드-회원관리-기본설정-회원가입필드 Controller
 * Information : 바로보드-회원관리-기본설정-회원가입필드 Controller
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 25.      류강하       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping("/user/manage/basic/setting/joinfield")
public class JoinFieldController extends GenericAbstractController {

    @Autowired
    private JoinFieldService joinFieldService;
    
    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    @RequestMapping("/index.do")
    public String movePage(ModelMap model) throws Exception {
        
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                
                if ( "c_id".equals(f.getName()) || "c_title".equals(f.getName())
                  || "useFl".equals(f.getName()) || "infoOpenFl".equals(f.getName())
                  || "esseInputFl".equals(f.getName()) ) 
                {
                    return false;
                }
                
                return true;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
            
        }).create();
        
        model.addAttribute("joinFields", gson.toJson(joinFieldService.getJoinFields()));
        
        return "/jsp/user/manage/basic/setting/joinfield/index";
    }
    
    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody List<JoinField> joinFields) throws Exception {
        
        joinFieldService.saveJoinFields(joinFields);
        
        return "{}";
    }
}