package standard.mvc.component.business.community.newsletter;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import standard.mvc.component.business.community.newsletter.controller.NewsletterAdminController;
import standard.mvc.component.business.community.newsletter.controller.NewsletterController;
import standard.mvc.component.business.community.newsletter.dao.NewsletterDao;
import standard.mvc.component.business.community.newsletter.service.NewsletterServiceImpl;
import standard.mvc.component.business.community.newsletter.vo.NewsletterComprehensiveTree;
import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebApplicationContextConfig.class, WebMvcConfig.class })
@Transactional
public class NewsletterTest {

    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private NewsletterController newsletterController;
    
    @Autowired
    private NewsletterAdminController newsletterAdminController;
    
    @Autowired
    private NewsletterServiceImpl newsletterService;
    
    @Autowired
    private NewsletterDao newsletterDao;
    
    @Autowired
    private CoreDao coreDao;
    
    private NewsletterComprehensiveTree testCategory;
    
    @Before
    public void ready() {

        assertThat(applicationContext, notNullValue());
        assertThat(newsletterController, notNullValue());
        assertThat(newsletterAdminController, notNullValue());
        assertThat(newsletterService, notNullValue());
        assertThat(newsletterDao, notNullValue());
        assertThat(coreDao, notNullValue());
    }
    
    @Before
    public void notExistTestCategoryAndAddTestCategory() throws Exception {
        
        testCategory = new NewsletterComprehensiveTree();
        testCategory.setC_title("TEST_CATEGORY_UNIQUE_NEVER_EXIST");
        
        assertThat(newsletterDao.searchNodeByTitle(testCategory), nullValue());
        
        testCategory.setC_type("folder");
        testCategory.setRef(3);

        newsletterService.addNode(testCategory);
        
        assertThat(newsletterDao.searchNodeByTitle(testCategory), notNullValue());
    }
    
    @Test
    public void addTestEmail() throws Exception {
     
        NewsletterComprehensiveTree testEmail1 = new NewsletterComprehensiveTree();
        testEmail1.setRef(testCategory.getC_id());
        testEmail1.setC_type("default");
        testEmail1.setC_title("test1@test.com");
        
        assertThat(newsletterDao.searchNodeByTitle(testEmail1), nullValue());
        
        newsletterService.addNode(testEmail1);
        
        assertThat(newsletterDao.searchNodeByTitle(testEmail1), notNullValue());
    }
}

/*
[전제 조건]
1. 초기 DML 조작으로 인해 id가 1인 Root Node, id가 2인 Newsletter 노드, id가 3인 Anonymous Users 폴더 노드가 존재한다.
> 이후 생성되는 노드들은 id가 3인 Anonymous Users 폴더 아래에서만 만들어져야 한다.

2. 컨트롤러 테스트(값 검증 등)는 추후에 연계한다.
> 값에 대해서 항상 positive

[현 시점의 목표 달성 수준]
1. 임의의 title과 일치하는 노드 찾기
2. 임의의 folder 노드 추가
3. 임의의 default 노드 추가
4. 임의의 노드 삭제

[추후 목표]
1. Mock DB 사용?
2. 보다 정밀한 테스트 성공에 대한 검증
3. 코어 칼럼들에 대한 값의 정합성 테스트
*/