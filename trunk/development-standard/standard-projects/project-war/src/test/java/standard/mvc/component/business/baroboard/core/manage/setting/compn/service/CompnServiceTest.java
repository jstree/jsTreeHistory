package standard.mvc.component.business.baroboard.core.manage.setting.compn.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import standard.mvc.component.business.baroboard.core.manage.setting.compn.vo.CompnVO;
import standard.mvc.component.business.baroboard.core.manage.setting.messages.ExceptionMessage;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;

/**
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 6. 13.
 * @version 1.0
 * @see <pre>
 * Class Name  : CompnServiceTest.java
 * Description : 바로보드-코어-고급설정-설치프로그램 관리 Service 테스트 클래스
 * Infomation  : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 13.         손호성                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
public class CompnServiceTest {

    @Resource(name = "CompnService")
    CoreService compnService;

    @Mock
    CompnVO mockCompnVO;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testAnnotationDrivenServiceInit() {
        assertThat(compnService, is(notNullValue()));
    }

    @Test
    public void testUnsupportedOperation() throws Exception {
        try {
            compnService.alterNode(mockCompnVO);
        } catch (Exception e) {
            assertThat(e, is(instanceOf(RuntimeException.class)));
            assertThat(e.getMessage(), is(equalTo(ExceptionMessage.UN_SUPPORTED.getValue())));
        }
    }

}