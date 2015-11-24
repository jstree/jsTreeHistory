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
package standard.mvc.component.business.community.newsletter.service;

import java.io.File;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.community.newsletter.vo.Newsletter;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import egovframework.com.ext.jstree.support.test.DbUnitTest;
import egovframework.com.ext.jstree.support.util.test.DatabaseOperations;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 2. 26.
 * @version 1.0
 * @see <pre>
 * Class Name  : NewsletterServiceTest.java
 * Description : 313 커뮤니티 뉴스레터 Service 테스트 클래스
 * Information : 313 커뮤니티 뉴스레터 Service 테스트 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 2. 26.  류강하                 최초 생성
 * 2015. 5. 15.  류강하                 테스트 환경에 맞게 리팩토링
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Ignore("TEST 실패 작성자 고칠것.")
@DatabaseSetup("NewsletterServiceTest.xml")
public class NewsletterServiceTest extends DbUnitTest<Newsletter> {

    @Autowired
    private NewsletterServiceImpl newsletterService;
    
    private static Newsletter anonymousUsersBranch;
    
    private final int INIT_SEQ = 4;
    
    @BeforeClass
    public static void setUpOnce() {
        
        anonymousUsersBranch = new Newsletter();
        anonymousUsersBranch.setC_id(3);
    }
    
    @Before
    public void setUp() throws Exception {
        
        IDatabaseConnection connection = null;
        
        try {
            databaseTester = new DataSourceDatabaseTester(dataSource);
            
            File dataSetFile = new File(getClass().getResource(".").getPath() + getClass().getSimpleName() + ".xml");
            
            IDataSet dataSet = new FlatXmlDataSetBuilder().build(dataSetFile);
            
            connection = databaseTester.getConnection();
            
            DatabaseOperations.INIT_SEQ.execute(connection, dataSet, INIT_SEQ);
            
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    @Test
    @ExpectedDatabase(value = "NewsletterServiceTest_addEmail.xml", assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void addEmail() throws Exception {
     
        Newsletter email = new Newsletter();
        email.setRef(anonymousUsersBranch.getC_id());
        email.setC_type("default");
        email.setC_title("test1@test.com");
        
        newsletterService.addNode(email);
    }
}