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

import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureGeneralSetting;

/**
 * Modification Information
 * 
 * @ author 김형채
 * 
 * @since 2015. 6. 16.
 * @version 1.0
 * @see <pre>
 * Class Name   : SecureGeneralSettingService.java
 * Description  : 로그인- 일반설정 Service 인터페이스
 * Information  : 로그인- 일반설정 Service 인터페이스
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

public interface SecureGeneralSettingService 
{
    /**
     * 일반설정을 조회한다.
     * 
     * @return 일반설정 DTO
     * @throws Exception
     */
    SecureGeneralSetting getGeneralSetting() throws Exception;
    
}