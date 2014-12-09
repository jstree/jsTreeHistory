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
package standard.mvc.component.business.community.newsletter.vo;

import java.util.HashMap;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2014. 12. 09.
 * @version 1.0
 * @see <pre>
 *  Class Name  : Newsletter.java
 *  Description : Newsletter VO 클래스
 *  Infomation  : Newsletter VO 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014. 12. 09.  류강하                 최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
//@JsonInclude(Include.NON_EMPTY)
public class Newsletter extends ComprehensiveTree {

    private String email;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public HashMap<String, String> getAttr() {
        
        HashMap<String, String> attrs = super.getAttr();
        
        return attrs;
    }
    
    @Override
    public String getSqlMapSelector() {
        return "newsletter";
    }
}
