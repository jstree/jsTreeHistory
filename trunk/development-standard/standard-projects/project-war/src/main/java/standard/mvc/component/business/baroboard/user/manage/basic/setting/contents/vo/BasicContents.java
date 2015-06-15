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
package standard.mvc.component.business.baroboard.user.manage.basic.setting.contents.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 9. 
 * @version 1.0
 * @see <pre>
 * Class Name  : BasicContents.java
 * Description : 바로보드-회원관리-기본 컨텐츠 DTO
 * Information : 바로보드-회원관리-기본 컨텐츠 DTO
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 5. 9.  류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class BasicContents extends ComprehensiveTree {

    /** 회사소개 */
    private String companyIntr;
    
    /** 이용약관 */
    private String termsOfUse;
    
    /** 개인정보취급방침 */
    private String privacyPolicy;

    public String getCompanyIntr() {
        return companyIntr;
    }

    public void setCompanyIntr(String companyIntr) {
        this.companyIntr = companyIntr;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public String getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(String privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    @Override
    public String getSqlMapSelector() {
        
        return "basicContents";
    }
}