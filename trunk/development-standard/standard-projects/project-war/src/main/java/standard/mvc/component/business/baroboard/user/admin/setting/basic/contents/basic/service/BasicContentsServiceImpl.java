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
package standard.mvc.component.business.baroboard.user.admin.setting.basic.contents.basic.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.user.admin.setting.basic.contents.basic.vo.BasicContents;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 10. 
 * @version 1.0
 * @see <pre>
 * Class Name  : BasicContentsServiceImpl.java
 * Description : 바로보드-회원관리 기본 컨텐츠 설정 Service 클래스
 * Infomation  : 바로보드-회원관리 기본 컨텐츠 설정 Service 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 5. 10.  류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service
public class BasicContentsServiceImpl implements BasicContentsService {

    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Override
    public BasicContents getBasicContents() throws Exception {
        
        BasicContents basicContents = new BasicContents();
        basicContents.setC_id(3);
        
        return coreService.getNode(basicContents);
    }

    @Override
    public int saveBasicContents(BasicContents basicContents) throws Exception {
        
        basicContents.setC_id(3);
        
        return coreService.alterNode(basicContents);
    }
}
