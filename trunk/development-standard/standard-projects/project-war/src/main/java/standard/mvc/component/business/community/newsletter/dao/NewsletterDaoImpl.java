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
package standard.mvc.component.business.community.newsletter.dao;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 01. 04.
 * @version 1.0
 * @see <pre>
 *  Class Name  : NewsletterDaoImpl.java
 *  Description : Newsletter DAO 인터페이스를 구현한 클래스
 *  Infomation  : Newsletter DAO 인터페이스를 구현한 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일                 수정자                 수정내용
 *  -------        ------------   -----------------------
 *  2015. 01. 04.  류강하                 최초 생성
 *  2015. 01. 07.  류강하                 searchNodeByTitle() 추가
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Repository("NewsletterDao")
public class NewsletterDaoImpl extends EgovComAbstractDAO implements NewsletterDao
{
    
    @SuppressWarnings("deprecation")
    @Override
    public <T extends ComprehensiveTree> int getMaxPositionForAddNode(T comprehensiveTree)
    {
        
        return (int) getSqlMapClientTemplate().queryForObject(comprehensiveTree.getSqlMapSelector()
                                                                      + ".getMaxPositionForAddNode", comprehensiveTree);
    }
    
    @SuppressWarnings({ "deprecation", "unchecked" })
    @Override
    public <T extends ComprehensiveTree> T searchNodeByTitle(T comprehensiveTree)
    {
        
        return (T) getSqlMapClientTemplate().queryForObject(comprehensiveTree.getSqlMapSelector()
                                                                    + ".searchNodeByTitle", comprehensiveTree);
    }
}
