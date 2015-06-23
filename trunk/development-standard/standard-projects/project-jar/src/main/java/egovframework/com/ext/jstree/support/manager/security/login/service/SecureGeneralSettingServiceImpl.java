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
package egovframework.com.ext.jstree.support.manager.security.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureGeneralSetting;

/**
 * Modification Information
 * 
 * @ author 김형채
 * 
 * @since 2015. 6. 16.
 * @version 1.0
 * @see <pre>
 * Class Name   : SecureGeneralSettingServiceImpl.java
 * Description  : 로그인- 일반설정 Service 
 * Information  : 로그인- 일반설정 Service
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                 수정내용
 * ------------  ------------  -----------------------
 * 2015. 06.16.  김형채 		      최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Service
public class SecureGeneralSettingServiceImpl implements SecureGeneralSettingService {
    
    @Resource(name = "CoreService")
    private CoreService coreService;
    

    @Override
    public SecureGeneralSetting getGeneralSetting() throws Exception {
        
        SecureGeneralSetting paramObj = new SecureGeneralSetting();
        paramObj.setC_id(3);
        
        SecureGeneralSetting generalSetting = coreService.getNode(paramObj);
        
        String[] webMasterEmail = generalSetting.getWebMasterEmail().split("@");
        
        generalSetting.setWebMasterEmailAccount( webMasterEmail[0] );
        generalSetting.setWebMasterEmailHost( webMasterEmail[1] );
        
        return generalSetting;
    }
}