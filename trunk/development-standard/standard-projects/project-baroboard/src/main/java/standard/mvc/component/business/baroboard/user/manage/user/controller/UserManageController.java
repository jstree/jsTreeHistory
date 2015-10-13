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
package standard.mvc.component.business.baroboard.user.manage.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.user.manage.grade.service.UserGradeService;
import standard.mvc.component.business.baroboard.user.manage.user.service.UserManageService;
import standard.mvc.component.business.baroboard.user.vo.User;

import com.google.gson.GsonBuilder;

import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.mvc.tags.ui.pagination.AsyncPaginationTextRenderer;
import egovframework.let.utl.fcc.service.EgovDateUtil;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 6. 6.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserManageController.java
 * Description : 바로보드-회원관리-회원관리 Controller
 * Information : 바로보드-회원관리-회원관리 Controller
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 6.   류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping("/user/manage/user")
public class UserManageController extends GenericAbstractController {

    @Autowired
    private UserManageService userManageService;
    
    @Autowired
    private UserGradeService userGradeService;
    
    @Autowired
    private AsyncPaginationTextRenderer asyncPaginaionTexRenderer;
    
    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    @RequestMapping("/index.do")
    public String movePage(ModelMap model, User user) throws Exception {
        
        model.addAttribute("userGrades", userGradeService.inquiryUserGradeList(null));
        
        return "/jsp/user/manage/user/index";
    }
    
    @RequestMapping(value = "/list.do", method = RequestMethod.POST)
    @ResponseBody
    public String list(@RequestBody User user) throws Exception {
        
        user.setJoinDeBegi( user.getJoinDeBegi().replaceAll("-", "") );
        user.setJoinDeEnd( user.getJoinDeEnd().replaceAll("-", "") );
        user.setLoginDeBegi( user.getLoginDeBegi().replaceAll("-", "") );
        user.setLoginDeEnd( user.getLoginDeEnd().replaceAll("-", "") );
        
        List<User> userList = userManageService.getUserListPaginated(user);
        
        for (User u : userList) {
            
            u.setJoinDe( EgovDateUtil.formatDate(u.getJoinDe(), "-") );
            
            if (u.getLastLoginDe() != null) {
                u.setLastLoginDe( EgovDateUtil.formatDate(u.getLastLoginDe(), "-") );
            }
        }
        
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("userList", userList);
        returnMap.put("pageList", asyncPaginaionTexRenderer.renderPagination(user.getPaginationInfo(), user.getJsFunction()));
        
        return new GsonBuilder().setPrettyPrinting().create().toJson(returnMap);
    }
    
    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    public String delete(@RequestBody List<User> users) throws Exception {
        
        userManageService.deleteUserInfos(users);
        
        return "{}";
    }
    
    @RequestMapping(value = "/approveJoining.do", method = RequestMethod.POST)
    @ResponseBody
    public String approveJoining(@RequestBody User user) {
        
        user.setJoinStateCd(4);
        
        userManageService.updateJoinState(user);
        
        return "{ \"status\" : \"1\" }";
    }
}