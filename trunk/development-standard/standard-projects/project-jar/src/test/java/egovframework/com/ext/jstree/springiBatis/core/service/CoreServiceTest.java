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
package egovframework.com.ext.jstree.springiBatis.core.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import scala.annotation.meta.getter;
import egovframework.com.ext.jstree.springiBatis.core.mock.MockCoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreServiceImpl;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 1. 27.
 * @version 1.0
 * @see <pre>
 *  Class Name  : CoreServiceTest.java
 *  Description : JsTree Spring+iBatis 버젼의 JUnit4 테스트 클래스
 *  Infomation  : 애플리케이션 컨텍스트를 사용하지 않고, DB를 사용하지 않는 Mock DAO를 사용하여 JsTree 코어 서비스를 검증하는 테스트
 * 
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2015. 1. 27.  류강하                 최초 생성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class CoreServiceTest {

    private static CoreServiceImpl coreService = new CoreServiceImpl();
    private static MockCoreDao<ComprehensiveTree> mockCoreDao = new MockCoreDao<>();
    
    private static ComprehensiveTree rootNodeStored;
    private static ComprehensiveTree firstChildNodeStored;
    
    @BeforeClass
    public static void setUp() throws Exception {

        Field coreDaoField = coreService.getClass().getDeclaredField("coreDao");
        
        coreDaoField.setAccessible(true);
        coreDaoField.set(coreService, mockCoreDao);
        
        ComprehensiveTree pRootNode = new ComprehensiveTree();
        pRootNode.setC_id(1);
        
        // TODO Core Service에 getNode()가 없기 때문에 Core DAO를 직접 사용해야 함.
        rootNodeStored = mockCoreDao.getNode(pRootNode);
        
        assertSame(rootNodeStored.getC_id(), 1);
        assertSame(rootNodeStored.getC_type(), null);
        assertSame(rootNodeStored.getC_left(), 1);
        assertSame(rootNodeStored.getC_right(), 4);
        assertSame(rootNodeStored.getC_position(), 0);
        assertEquals(rootNodeStored.getC_title(), "Root Node");
        assertSame(rootNodeStored.getC_parentid(), 0);
        
        // TODO 또는 getChildNode()의 index 0을 사용해서 getNode()의 기능을 대신해야 함.
        List<ComprehensiveTree> childNodes = coreService.getChildNode(pRootNode);
        
        assertSame(childNodes.size(), 1);
        
        firstChildNodeStored = childNodes.get(0);
        
        assertSame(firstChildNodeStored.getC_id(), 2);
        assertEquals(firstChildNodeStored.getC_type(), "drive");
        assertSame(firstChildNodeStored.getC_left(), 2);
        assertSame(firstChildNodeStored.getC_right(), 3);
        assertSame(firstChildNodeStored.getC_position(), 0);
        assertEquals(firstChildNodeStored.getC_title(), "First Child Node");
        assertSame(firstChildNodeStored.getC_parentid(), 1);
    }
    
    @Test
    public void simpleAddNode() throws Exception {
        
        /* leaf 노드 추가 테스트 */
        // TODO position을 생성해줄 유틸이 필요하여 만듦.
        int position = mockCoreDao.generatePosition(firstChildNodeStored);
        
        ComprehensiveTree defaultNode = new ComprehensiveTree();
        defaultNode.setC_type("default");
        defaultNode.setC_position(position);
        defaultNode.setC_title("defaultNode");
        defaultNode.setRef(firstChildNodeStored.getC_id());
        
        coreService.addNode(defaultNode);
        
        ComprehensiveTree defaultNodeStored = coreService.getChildNode(firstChildNodeStored).get(0);
        
        assertSame(defaultNodeStored.getC_id(), 3);
        assertEquals(defaultNodeStored.getC_type(), "default");
        assertSame(defaultNodeStored.getC_left(), 3);
        assertSame(defaultNodeStored.getC_right(), 4);
        assertSame(defaultNodeStored.getC_position(), 1);
        assertEquals(defaultNodeStored.getC_title(), "defaultNode");
        assertSame(defaultNodeStored.getC_parentid(), firstChildNodeStored.getC_id());
        
        assertSame(rootNodeStored.getC_left(), 1);
        assertSame(rootNodeStored.getC_right(), 6);
        
        assertSame(firstChildNodeStored.getC_left(), 2);
        assertSame(firstChildNodeStored.getC_right(), 5);
        
        /* branch 노드 추가 테스트 */
        ComprehensiveTree folderNode = new ComprehensiveTree();
        folderNode.setC_type("folder");
        folderNode.setC_position( mockCoreDao.generatePosition(firstChildNodeStored) );
        folderNode.setC_title("folderNode");
        folderNode.setRef(firstChildNodeStored.getC_id());
        
        coreService.addNode(folderNode);
        
        ComprehensiveTree folderNodeStored = coreService.getChildNode(firstChildNodeStored).get(1);
        
        assertSame(folderNodeStored.getC_id(), 4);
        assertEquals(folderNodeStored.getC_type(), "folder");
        assertSame(folderNodeStored.getC_left(), 5);
        assertSame(folderNodeStored.getC_right(), 6);
        assertSame(folderNodeStored.getC_position(), 2);
        assertEquals(folderNodeStored.getC_title(), "folderNode");
        assertSame(folderNodeStored.getC_parentid(), firstChildNodeStored.getC_id());
        
        assertSame(rootNodeStored.getC_left(), 1);
        assertSame(rootNodeStored.getC_right(), 8);
        
        assertSame(firstChildNodeStored.getC_left(), 2);
        assertSame(firstChildNodeStored.getC_right(), 7);
        
        /* leaf 노드 삭제 테스트 */
        coreService.removeNode(defaultNodeStored);

        assertNull(mockCoreDao.getNode(defaultNodeStored));
        
        assertSame(coreService.getChildNode(firstChildNodeStored).size(), 1);
        
        assertSame(folderNodeStored.getC_left(), 3);
        assertSame(folderNodeStored.getC_right(), 4);
        assertSame(folderNodeStored.getC_position(), 1);
        
        assertSame(rootNodeStored.getC_left(), 1);
        assertSame(rootNodeStored.getC_right(), 6);
        
        assertSame(firstChildNodeStored.getC_left(), 2);
        assertSame(firstChildNodeStored.getC_right(), 5);
        
        /* branch 노드에 노드 추가 테스트 */
        
    }
    
    @Test
    public void simpleNegativeAddNode() throws Exception {
        
//        int position = mockCoreDao.generatePosition(firstChildNodeStored);
//        
//        ComprehensiveTree defaultNode = new ComprehensiveTree();
//        defaultNode.setC_type("default");
//        defaultNode.setC_position(position);
//        defaultNode.setC_title("defaultNode");
//        defaultNode.setRef(firstChildNodeStored.getC_id());
//        
//        coreService.addNode(defaultNode);
    }
}