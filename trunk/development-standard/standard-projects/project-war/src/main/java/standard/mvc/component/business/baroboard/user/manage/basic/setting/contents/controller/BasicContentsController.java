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
package standard.mvc.component.business.baroboard.user.manage.basic.setting.contents.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.contents.service.BasicContentsService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.contents.vo.BasicContents;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 12.
 * @version 1.0
 * @see <pre>
 * Class Name  : BasicContentsController.java
 * Description : 바로보드-회원관리 기본 컨텐츠 설정 Controller
 * Infomation  : 바로보드-회원관리 기본 컨텐츠 설정 Controller
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 5. 12.  류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping("/baroboard/user/admin/basicContents") // TODO baroboard 뺄 것
 // TODO admin -> manage로 변경 보안
public class BasicContentsController extends GenericAbstractController {
    
    @Autowired
    private BasicContentsService basicContentsService;
    
    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    @RequestMapping("/index.do")
    public String movePage(ModelMap model) throws Exception {
        
        model.addAttribute("basicContents", basicContentsService.getBasicContents());
        
        return "/jsp/baroboard/user/admin/basicContents/index";
    }
    
    @RequestMapping("/save.do")
    @ResponseBody
    public String save(BasicContents basicContents) throws Exception {
        
        basicContentsService.saveBasicContents(basicContents);
        
        return "{}";
    }
}