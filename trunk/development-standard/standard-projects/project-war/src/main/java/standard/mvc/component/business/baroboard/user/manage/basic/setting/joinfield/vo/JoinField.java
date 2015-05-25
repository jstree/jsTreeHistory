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
package standard.mvc.component.business.baroboard.user.manage.basic.setting.joinfield.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : JoinField.java
 * Description : 바로보드-회원관리-기본설정-회원가입필드  DTO
 * Infomation  : 바로보드-회원관리-기본설정-회원가입필드  DTO
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
public class JoinField extends ComprehensiveTree {

    /** 사용여부 */
    private String useFl;

    /** 정보공개여부 */
    private String infoOpenFl;

    /** 필수입력여부 */
    private String esseInputFl;

    public String getUseFl() {
        return useFl;
    }

    public void setUseFl(String useFl) {
        this.useFl = useFl;
    }

    public String getInfoOpenFl() {
        return infoOpenFl;
    }

    public void setInfoOpenFl(String infoOpenFl) {
        this.infoOpenFl = infoOpenFl;
    }

    public String getEsseInputFl() {
        return esseInputFl;
    }

    public void setEsseInputFl(String esseInputFl) {
        this.esseInputFl = esseInputFl;
    }

    @Override
    public String getSqlMapSelector() {

        return "joinField";
    }
}