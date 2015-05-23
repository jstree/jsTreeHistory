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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service.GeneralSettingService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service.ProhibitionWordService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.GeneralSetting;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.ProhibitionWord;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.util.StringUtils;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 20.
 * @version 1.0
 * @see <pre>
 * Class Name  : GeneralSettingController.java
 * Description : 바로보드-회원관리-기본설정-일반설정 Controller
 * Infomation  : 바로보드-회원관리-기본설정-일반설정 Controller
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
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
    public String movePage(ModelMap model) throws Exception {
        
        model.addAttribute("passwordSecurityLevels", generalSettingService.getPasswordSecurityLevels());
        
        model.addAttribute("generalSetting", generalSettingService.getGeneralSetting());
        
        model.addAttribute("nicknameProhibitionWords", prohibitionWordService.getNicknameProhibitionWords());
        
        return "/jsp/user/manage/basic/setting/general/index";
    }
    
    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    @ResponseBody
    public String save(GeneralSetting generalSetting) throws Exception {
        
        logger.debug("generalSetting : " + generalSetting);
        
        generalSettingService.saveGeneralSetting(generalSetting);

        String[] nicknameProhibitionWordArray = StringUtils.splitStringByNewLineOrTab( generalSetting.getNicknameProhibitionWords() );
        
        if ( ! (nicknameProhibitionWordArray.length == 1 && "".equals(nicknameProhibitionWordArray[0])) ) {
            
            List<ProhibitionWord> nicknameProhibitionWordList = new ArrayList<ProhibitionWord>();
            
            for (int i = 0; i < nicknameProhibitionWordArray.length; i++) {
                
                ProhibitionWord prohibitionWord = new ProhibitionWord();
                prohibitionWord.setC_title( nicknameProhibitionWordArray[i] );
                
                if ("".equals(prohibitionWord.getC_title())) {
                    continue;
                }
                
                nicknameProhibitionWordList.add(prohibitionWord);
            }
            
            if (nicknameProhibitionWordList.size() > 0) {
                prohibitionWordService.saveNicknameProhibitionWords(nicknameProhibitionWordList);
            }
            
            logger.debug("nicknameProhibitionWordList : " + nicknameProhibitionWordList);
        }
        
        return "{}";
    }
}