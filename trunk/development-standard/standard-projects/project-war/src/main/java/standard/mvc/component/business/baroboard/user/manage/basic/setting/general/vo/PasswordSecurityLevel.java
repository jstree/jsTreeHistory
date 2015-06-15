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
package standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 19.
 * @version 1.0
 * @see <pre>
 * Class Name  : PasswordSecurityLevel.java
 * Description : 바로보드-회원관리-기본설정-비밀번호보안수준 DTO
 * Information : 바로보드-회원관리-기본설정-비밀번호보안수준 DTO
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
public class PasswordSecurityLevel extends ComprehensiveTree {

    @Override
    public String getSqlMapSelector() {
        
        return "passwordSecurityLevel";
    }
}