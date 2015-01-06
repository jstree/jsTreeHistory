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

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 01. 04.
 * @version 1.0
 * @param <T>
 * @see <pre>
 *  Class Name  : NewsletterDao.java
 *  Description : Newsletter DAO 인터페이스
 *  Infomation  : Newsletter DAO 인터페이스
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
public interface NewsletterDao {
    
    /**
     * 하나의 부모 노드에 대해 새로운 노드 추가 시 필요한 position 값을 생성한다.
     * @param comprehensiveTree ComprehensiveTree 또는 그것을 상속한 어떤 클래스의 인스턴스
     * @return 특정 부모의 자식들의 position 중 가장 큰 position
     */
    <T extends ComprehensiveTree> int getMaxPositionForAddNode(T comprehensiveTree);
    
    /**
     * title이 동일한 노드를 찾는다.
     * @param comprehensiveTree
     * @return ComprehensiveTree 또는 그것을 상속한 어떤 클래스의 인스턴스
     */
    <T extends ComprehensiveTree> T searchNodeByTitle(T comprehensiveTree);
}