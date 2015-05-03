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
package egovframework.com.ext.jstree.support.manager.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.dbunit.IDatabaseTester;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 3.
 * @version 1.0
 * @see <pre>
 * Class Name  : DbUnitTest.java
 * Description : 바로보드-회원관리 테스트 클래스의 부모 클래스
 * Infomation  : Root Node, First Child Node 검증과 같은 공통적인 요소를 포함하고 있음.
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 5.  3.  류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class DbUnitTest<T> {
    
    @Resource(name = "CoreService")
    protected CoreService coreService;
    
    @Autowired
    protected CoreDao coreDao;
    
    @Resource(name = "dataSource-${Globals.DbType}")
    protected DataSource testDataSource;
    
    protected IDatabaseTester databaseTester;
    
    private Class<T> voClass;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public DbUnitTest() {
        
        Class<? extends DbUnitTest> cl = getClass();
        
        ParameterizedType genericSuperclass = null;
        
        try {
            genericSuperclass = (ParameterizedType) cl.getGenericSuperclass();
        } catch (Exception e) {
            genericSuperclass = (ParameterizedType) cl.getSuperclass().getGenericSuperclass();
        }
        
        Type actualTypeArgument = genericSuperclass.getActualTypeArguments()[0];
        
        if (actualTypeArgument instanceof ParameterizedType) {
            
            throw new UnsupportedOperationException(); 
        }
        else {
            voClass = (Class<T>) actualTypeArgument;
        }
    }
    
    @SuppressWarnings("unchecked")
    protected void assertThatTotalNumberOfNodesIs(int size) throws Exception {
        
        ComprehensiveTree nodeForSearching = (ComprehensiveTree) voClass.newInstance();
        nodeForSearching.setSearchStr("");
        
        List<T> allNodes = (List<T>) coreDao.searchNodeByString(nodeForSearching);
        
        assertThat(allNodes.size(), is(size));
    }
    
    protected ComprehensiveTree getRootNode() throws Exception {
        
        ComprehensiveTree rootNode = (ComprehensiveTree) voClass.newInstance();
        rootNode.setC_id(1);
        
        return rootNode;
    }
    
    @SuppressWarnings("unchecked")
    protected T getRootNodeStored() throws Exception {
        
        return (T) coreDao.getNode( getRootNode() );
    }
    
    protected ComprehensiveTree getFirstChildNode() throws Exception {
        
        ComprehensiveTree firstChildNode = (ComprehensiveTree) voClass.newInstance();
        firstChildNode.setC_id(2);
        
        return firstChildNode;
    }
    
    @SuppressWarnings("unchecked")
    protected T getFirstChildNodeStored() throws Exception {
        
        return (T) coreDao.getNode( getFirstChildNode() );
    }
}