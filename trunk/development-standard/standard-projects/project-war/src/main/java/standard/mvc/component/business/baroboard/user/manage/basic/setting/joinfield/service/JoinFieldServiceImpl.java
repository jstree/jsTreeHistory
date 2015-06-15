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
package standard.mvc.component.business.baroboard.user.manage.basic.setting.joinfield.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.joinfield.dao.JoinFieldDao;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.joinfield.vo.JoinField;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : JoinFieldServiceImpl.java
 * Description : 바로보드-회원관리-기본설정-회원가입필드 Service 클래스
 * Information : 바로보드-회원관리-기본설정-회원가입필드 Service 클래스
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
@Service
public class JoinFieldServiceImpl implements JoinFieldService {
    
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Autowired
    private JoinFieldDao joinFieldDao;
    
    @Override
    public List<JoinField> getJoinFields() throws Exception {
        
        JoinField joinField = new JoinField();
        joinField.setC_id(2);
        
        return coreService.getChildNode(joinField);
    }

    @Override
    public int saveJoinFields(List<JoinField> joinFields) throws Exception {
        
        int affectedRowCount = 0;
        
        for (JoinField joinField : joinFields) {

            if ( joinField.getC_id() == 3 || joinField.getC_id() == 4 || joinField.getC_id() == 5) {
                
                affectedRowCount += joinFieldDao.alterEssentialJoinField(joinField);
            }
            else {
                affectedRowCount += joinFieldDao.alterOptionalJoinField(joinField);
            }
        }
        
        return affectedRowCount;
    }
}