package standard.mvc.component.business.baroboard.core.manage.setting.server.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import standard.mvc.component.business.baroboard.core.manage.setting.messages.ExceptionMessage;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;
import egovframework.com.ext.jstree.support.manager.mvc.exception.GenericServiceRuntimeException;


/**
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 5. 19.
 * @version 1.0
 * @see <pre>
 *  Class Name  : ServerServiceTest.java
 *  Description : 바로보드-코어-고급설정-서버 Service 테스트 클래스
 *  Infomation  :
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 5. 19.        손호성                  최초생성
 *  2015. 5. 20.        손호성                  import static Mockito, CoreMatchers
 * 
 *  Copyright (C) 2015 by MarkAny  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
public class ServerServiceTest {

    @Resource(name = "ServerService")
    CoreService serverService;

    @Mock
    ComprehensiveTree comprehensiveTree;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testAnnotationDrivenServiceInit() {
        assertThat(serverService, is(notNullValue()));
    }

    @Test
    public void testUnsupportedOperation() throws Exception {
        try {
            serverService.addNode(comprehensiveTree);
        } catch (Exception e) {
            assertThat(e, is(instanceOf(GenericServiceRuntimeException.class)));
            assertThat(e.getMessage(), is(equalTo(ExceptionMessage.UN_SUPPORTED.getValue())));
        }
    }

    @Test(expected = AssertionError.class)
    public void testAlterNode() throws Exception {
        assertThat(serverService.alterNode(comprehensiveTree), is(1));
    }

    @Test
    public void testAnnotationDrivenMock() throws Exception {
        when(comprehensiveTree.getC_id()).thenReturn(1);
        assertThat(comprehensiveTree.getC_id(), is(1));
        verify(comprehensiveTree).getC_id();
    }

}
