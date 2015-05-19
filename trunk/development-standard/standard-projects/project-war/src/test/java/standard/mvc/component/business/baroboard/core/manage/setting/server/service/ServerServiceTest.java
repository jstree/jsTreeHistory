package standard.mvc.component.business.baroboard.core.manage.setting.server.service;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
 * 
 *  Copyright (C) 2015 by MarkAny  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
public class ServerServiceTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

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
        Assert.assertNotNull(serverService);
    }

    @Test
    public void testUnsupportedOperation() throws Exception {
        try {
            serverService.addNode(comprehensiveTree);
        } catch (Exception e) {
            Assert.assertEquals(GenericServiceRuntimeException.class, e.getClass());
            Assert.assertEquals("현재 메뉴에서 지원되지 않는 기능입니다.", e.getMessage());
        }
    }

    @Test(expected = AssertionError.class)
    public void testAlterNode() throws Exception {
        Assert.assertEquals(1, serverService.alterNode(comprehensiveTree));
    }

    @Test
    public void testAnnotationDrivenMock() throws Exception {
        Mockito.when(comprehensiveTree.getC_id()).thenReturn(1);
        Assert.assertEquals(1, comprehensiveTree.getC_id());
        Mockito.verify(comprehensiveTree, Mockito.times(1)).getC_id();
    }

}
