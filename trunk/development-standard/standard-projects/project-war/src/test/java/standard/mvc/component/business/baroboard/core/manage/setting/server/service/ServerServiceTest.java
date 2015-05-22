package standard.mvc.component.business.baroboard.core.manage.setting.server.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

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
import standard.mvc.component.business.baroboard.core.manage.setting.server.vo.ServerVO;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
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
 *  2015. 5. 21.        손호성                  testGetChildNode, testGetNode 추가
 *  2015. 5. 22.        손호성                  testAlterNode 테스트 성공하도록 수정
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
public class ServerServiceTest {

    @Resource(name = "ServerService")
    CoreService serverService;

    @Mock
    ServerVO mockServerVO;

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
            serverService.addNode(mockServerVO);
        } catch (Exception e) {
            assertThat(e, is(instanceOf(GenericServiceRuntimeException.class)));
            assertThat(e.getMessage(), is(equalTo(ExceptionMessage.UN_SUPPORTED.getValue())));
        }
    }

    @Test
    public void testAlterNode() throws Exception {
        when(mockServerVO.getC_id()).thenReturn(4);
        when(mockServerVO.getSqlMapSelector()).thenReturn("server");
        when(mockServerVO.getUrl()).thenReturn("http://192.168.0.1");
        when(mockServerVO.getSslFl()).thenReturn("1");
        when(mockServerVO.getHttpPort()).thenReturn("80");
        when(mockServerVO.getHttpsPort()).thenReturn("9443");
        when(mockServerVO.getShortUrlFl()).thenReturn("1");
        when(mockServerVO.getSsoFl()).thenReturn("1");

        assertThat(serverService.alterNode(mockServerVO), is(1));

        ServerVO resultServerVO = serverService.getNode(mockServerVO);

        assertThat(resultServerVO.getC_id(), is(4));
        assertThat(resultServerVO.getUrl(), is(equalTo("http://192.168.0.1")));
        assertThat(resultServerVO.getSslFl(), is(equalTo("1")));
        assertThat(resultServerVO.getHttpPort(), is(equalTo("80")));
        assertThat(resultServerVO.getHttpsPort(), is(equalTo("9443")));
        assertThat(resultServerVO.getShortUrlFl(), is(equalTo("1")));
        assertThat(resultServerVO.getSsoFl(), is(equalTo("1")));

        verify(mockServerVO, times(2)).getC_id();
        verify(mockServerVO, times(2)).getSqlMapSelector();
        verify(mockServerVO).getUrl();
        verify(mockServerVO).getSslFl();
        verify(mockServerVO).getHttpPort();
        verify(mockServerVO).getHttpsPort();
        verify(mockServerVO).getShortUrlFl();
        verify(mockServerVO).getSsoFl();
    }

    @Test
    public void testAnnotationDrivenMock() throws Exception {
        when(mockServerVO.getC_id()).thenReturn(1);
        assertThat(mockServerVO.getC_id(), is(1));
        verify(mockServerVO).getC_id();
    }

    @Test
    public void testGetChildNode() throws Exception {
        when(mockServerVO.getC_id()).thenReturn(3);
        when(mockServerVO.getSqlMapSelector()).thenReturn("server");

        List<ServerVO> bunchOfResultServerVO = serverService.getChildNode(mockServerVO);

        assertThat(bunchOfResultServerVO.size(), is(1));

        for (ServerVO resultServerVO : bunchOfResultServerVO) {
            assertThat(resultServerVO.getC_id(), is(4));
            assertThat(resultServerVO.getC_parentid(), is(3));
            assertThat(resultServerVO.getC_position(), is(0));
            assertThat(resultServerVO.getC_left(), is(4));
            assertThat(resultServerVO.getC_right(), is(5));
            assertThat(resultServerVO.getC_level(), is(3));
            assertThat(resultServerVO.getC_title(), is(equalTo("서버설정")));
            assertThat(resultServerVO.getC_type(), is(equalTo("default")));
            assertThat(resultServerVO.getChildcount(), is(equalTo("NoChild")));
        }

        verify(mockServerVO).getC_id();
        verify(mockServerVO).getSqlMapSelector();
    }

    @Test
    public void testGetNode() throws Exception {
        when(mockServerVO.getC_id()).thenReturn(4);
        when(mockServerVO.getSqlMapSelector()).thenReturn("server");

        ServerVO resultServerVO = serverService.getNode(mockServerVO);

        assertThat(resultServerVO.getC_id(), is(4));
        assertThat(resultServerVO.getC_parentid(), is(3));
        assertThat(resultServerVO.getC_position(), is(0));
        assertThat(resultServerVO.getC_left(), is(4));
        assertThat(resultServerVO.getC_right(), is(5));
        assertThat(resultServerVO.getC_level(), is(3));
        assertThat(resultServerVO.getC_title(), is(equalTo("서버설정")));
        assertThat(resultServerVO.getC_type(), is(equalTo("default")));

        verify(mockServerVO).getC_id();
        verify(mockServerVO).getSqlMapSelector();
    }

}
