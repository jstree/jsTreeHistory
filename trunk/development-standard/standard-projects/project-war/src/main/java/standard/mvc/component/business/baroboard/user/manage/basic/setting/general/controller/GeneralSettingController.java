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
package standard.mvc.component.business.baroboard.user.manage.basic.setting.general.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service.GeneralSettingService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service.ProhibitionWordService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.GeneralSetting;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.ProhibitionWord;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 20.
 * @version 1.0
 * @see <pre>
 * Class Name  : GeneralSettingController.java
 * Description : 바로보드-회원관리-기본설정-일반설정 Controller
 * Information : 바로보드-회원관리-기본설정-일반설정 Controller
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 20.      류강하       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping("/user/manage/basic/setting/general")
public class GeneralSettingController extends GenericAbstractController {

    @Autowired
    private GeneralSettingService generalSettingService;
    
    @Autowired
    private ProhibitionWordService prohibitionWordService;
    
    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @RequestMapping("/index.do")
    public String index(ModelMap model) throws Exception {
        
        model.addAttribute("passwordSecurityLevels", generalSettingService.getPasswordSecurityLevels());
        
        model.addAttribute("generalSetting", generalSettingService.getGeneralSetting());
        
        model.addAttribute("emailProhibitionWords", prohibitionWordService.getEmailProhibitionWords());
        
        model.addAttribute("nicknameProhibitionWords", prohibitionWordService.getNicknameProhibitionWords());
        
        return "/jsp/user/manage/basic/setting/general/index";
    }
    
    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    @ResponseBody
    public String save(@Valid GeneralSetting generalSetting, BindingResult bindingResult) throws Exception {
        
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("bb.com.error.001");
        }
        
        String webMasterEmail = generalSetting.getWebMasterEmailAccount() + "@" + generalSetting.getWebMasterEmailHost();
        
        if (!webMasterEmail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            throw new RuntimeException("bb.com.error.001");
        }
        
        generalSetting.setWebMasterEmail(webMasterEmail);
        
        generalSettingService.saveGeneralSetting(generalSetting);
        
        List<ProhibitionWord> emailProhibitionWordList = prohibitionWordService.extractProhibitionWords( generalSetting.getEmailProhibitionWords() );
        
        if (emailProhibitionWordList.size() > 0) {
            prohibitionWordService.saveEmailProhibitionWords(emailProhibitionWordList);
        }
        
        List<ProhibitionWord> nicknameProhibitionWordList = prohibitionWordService.extractProhibitionWords( generalSetting.getNicknameProhibitionWords() );
        
        if (nicknameProhibitionWordList.size() > 0) {
            prohibitionWordService.saveNicknameProhibitionWords(nicknameProhibitionWordList);
        }
        
        return "{}";
    }
}