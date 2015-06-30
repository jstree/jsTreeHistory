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
package standard.mvc.component.business.baroboard.user.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.user.dao.UserDao;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service.GeneralSettingService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service.ProhibitionWordService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.ProhibitionWord;
import standard.mvc.component.business.baroboard.user.manage.grade.service.UserGradeService;
import standard.mvc.component.business.baroboard.user.manage.grade.vo.UserGradeManage;
import standard.mvc.component.business.baroboard.user.vo.PasswordFindQuestion;
import standard.mvc.component.business.baroboard.user.vo.User;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 6. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserServiceImpl.java
 * Description : 바로보드-회원 Service 클래스
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 25.   류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Autowired
    private UserGradeService userGradeService;
    
    @Autowired
    private GeneralSettingService generalSettingService;
    
    @Autowired
    private ProhibitionWordService prohibitionWordService;
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public User findUserByNickname(User user) throws Exception {
        
        return userDao.selectUserByNickname(user);
    }

    @Override
    public boolean isDuplicateNickname(User user) throws Exception {

        boolean duplicate = false;
        
        if (findUserByNickname(user) != null) {
            duplicate = true;
        }
        
        return duplicate;
    }
    
    @Override
    public User findUserByEmail(User user) throws Exception {
        
        return userDao.selectUserByEmail(user);
    }

    @Override
    public boolean isDuplicateEmail(User user) throws Exception {
        
        boolean duplicate = false;
        
        if (findUserByEmail(user) != null) {
            duplicate = true;
        }
        
        return duplicate;
    }
    
    @Override
    public String encryptPassword(String password) {
        
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
        
        return encoder.encodePassword(password, null);
    }
    
    private boolean isValidUserGradeCd(int userGradeCd) throws Exception {
        
        boolean validUserGradeCd = false;
        
        List<UserGradeManage> userGrades = userGradeService.inquiryUserGradeList(null);
        for (UserGradeManage userGrade : userGrades) {
            
            if (userGrade.getC_id() == userGradeCd) {
                validUserGradeCd = true;
                break;
            }
        }
        
        return validUserGradeCd;
    }
    
    @Override
    public User addUser(User user) throws Exception {
        
        user.setRef(2);
        user.setC_type("default");
        
        int userGradeCd = user.getUserGradeCd();
        
        if (userGradeCd == 0) {
            user.setUserGradeCd(3);
        } 
        else if (! isValidUserGradeCd(userGradeCd) ) {
            throw new RuntimeException("bb.user.error.001");
        }
        
        List<ProhibitionWord> emailProhibitionWords = prohibitionWordService.getEmailProhibitionWords();
        
        for (ProhibitionWord emailProhibitionWord : emailProhibitionWords) {
            
            if (emailProhibitionWord.getC_title().equals( user.getEmail() )) {
                throw new RuntimeException("bb.user.error.002");
            }
        }
        
        List<ProhibitionWord> nicknameProhibitionWords = prohibitionWordService.getNicknameProhibitionWords();
        
        for (ProhibitionWord nicknameProhibitionWord : nicknameProhibitionWords) {
            
            if (nicknameProhibitionWord.getC_title().equals( user.getC_title() )) {
                throw new RuntimeException("bb.user.error.003");
            }
        }
        
        if ("1".equals( generalSettingService.getGeneralSetting().getJoinApprovalFl() )) {
            user.setJoinStateCd(3); // 가입승인요청
        } else {
            user.setJoinStateCd(4); // 가입완료
        }
        
        user.setPassword( encryptPassword(user.getPassword()) );
        
        String currentdateTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        
        user.setPasswordChangeDt(currentdateTime);
        user.setLoginFailureCnt(0);
        user.setJoinDt(currentdateTime);
        user.setPasswordChangeDt(currentdateTime);
        
        return coreService.addNode(user);
    }

    @Override
    public int initUserPassword(User user) throws Exception {
        
        user.setPassword( encryptPassword(user.getPassword()) );
        user.setPasswordChangeDt( new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) );
        
        return userDao.updateUserPassword(user);
    }
    
    @Override
    public List<PasswordFindQuestion> getPasswordFindQuestions() throws Exception {
        
        PasswordFindQuestion passwordFindQuestion = new PasswordFindQuestion();
        passwordFindQuestion.setC_id(2);
        
        return coreService.getChildNode(passwordFindQuestion);
    }
}