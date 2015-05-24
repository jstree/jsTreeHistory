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
package standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.GeneralSetting;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.PasswordSecurityLevel;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 19.
 * @version 1.0
 * @see <pre>
 * Class Name  : GeneralSettingServiceImpl.java
 * Description : 바로보드-회원관리-기본설정-일반설정  Service 클래스
 * Infomation  : 바로보드-회원관리-기본설정-일반설정  Service 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 19.      류강하       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service
public class GeneralSettingServiceImpl implements GeneralSettingService {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Override
    public List<PasswordSecurityLevel> getPasswordSecurityLevels() throws Exception {
        
        PasswordSecurityLevel passwordSecurityLevel = new PasswordSecurityLevel();
        passwordSecurityLevel.setC_id(2);
        
        return coreService.getChildNode(passwordSecurityLevel);
    }

    @Override
    public GeneralSetting getGeneralSetting() throws Exception {
        
        GeneralSetting paramObj = new GeneralSetting();
        paramObj.setC_id(3);
        
        GeneralSetting generalSetting = coreService.getNode(paramObj);
        
        String[] webMasterEmail = generalSetting.getWebMasterEmail().split("@");
        
        generalSetting.setWebMasterEmailAccount( webMasterEmail[0] );
        generalSetting.setWebMasterEmailHost( webMasterEmail[1] );
        
        return generalSetting;
    }

    @Override
    public int saveGeneralSetting(GeneralSetting generalSetting) throws Exception {
        
        generalSetting.setC_id(3);
        
        GeneralSetting original = coreService.getNode(generalSetting);
        
        generalSetting.setC_type( original.getC_type() );
        generalSetting.setC_title( original.getC_title() );
        
        return coreService.alterNode(generalSetting);
    }
}