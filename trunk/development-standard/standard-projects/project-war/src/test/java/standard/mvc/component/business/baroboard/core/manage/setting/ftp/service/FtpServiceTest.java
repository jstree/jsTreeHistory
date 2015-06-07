package standard.mvc.component.business.baroboard.core.manage.setting.ftp.service;

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

import standard.mvc.component.business.baroboard.core.manage.setting.ftp.vo.FtpVO;
import standard.mvc.component.business.baroboard.core.manage.setting.messages.ExceptionMessage;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;


/**
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 5. 29.
 * @version 1.0
 * @see <pre>
 *  Class Name  : FtpServiceTest.java
 *  Description : 바로보드-코어-고급설정-FTP Service 테스트 클래스
 *  Infomation  :
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 5. 29.        손호성                  최초생성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
public class FtpServiceTest {

    @Resource(name = "FtpService")
    CoreService ftpService;

    @Mock
    FtpVO mockFtpVO;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testAnnotationDrivenServiceInit() {
        assertThat(ftpService, is(notNullValue()));
    }

    @Test
    public void testUnsupportedOperation() throws Exception {
        try {
            ftpService.addNode(mockFtpVO);
        } catch (Exception e) {
            assertThat(e, is(instanceOf(RuntimeException.class)));
            assertThat(e.getMessage(), is(equalTo(ExceptionMessage.UN_SUPPORTED.getValue())));
        }
    }

    @Test
    public void testAlterNode() throws Exception {
        when(mockFtpVO.getC_id()).thenReturn(4);
        when(mockFtpVO.getSqlMapSelector()).thenReturn("ftp");
        when(mockFtpVO.getFtpId()).thenReturn("user1");
        when(mockFtpVO.getFtpPassword()).thenReturn("4321");
        when(mockFtpVO.getFtpUrl()).thenReturn("192.168.0.1");
        when(mockFtpVO.getFtpPort()).thenReturn("22");
        when(mockFtpVO.getPassiveFl()).thenReturn("1");
        when(mockFtpVO.getSftpFl()).thenReturn("1");

        assertThat(ftpService.alterNode(mockFtpVO), is(1));

        FtpVO resultFtpVO = ftpService.getNode(mockFtpVO);

        assertThat(resultFtpVO.getC_id(), is(4));

        verify(mockFtpVO, times(2)).getC_id();
        verify(mockFtpVO, times(2)).getSqlMapSelector();
        verify(mockFtpVO).getFtpId();
        verify(mockFtpVO).getFtpPassword();
        verify(mockFtpVO).getFtpUrl();
        verify(mockFtpVO).getFtpPort();
        verify(mockFtpVO).getPassiveFl();
        verify(mockFtpVO).getSftpFl();
    }

    @Test
    public void testGetChildNode() throws Exception {
        when(mockFtpVO.getC_id()).thenReturn(3);
        when(mockFtpVO.getSqlMapSelector()).thenReturn("ftp");

        List<FtpVO> bunchOfResultFtpVO = ftpService.getChildNode(mockFtpVO);

        assertThat(bunchOfResultFtpVO.size(), is(1));

        for (FtpVO resultFtpVO : bunchOfResultFtpVO) {
            assertThat(resultFtpVO.getC_id(), is(4));
            assertThat(resultFtpVO.getC_parentid(), is(3));
            assertThat(resultFtpVO.getC_position(), is(0));
            assertThat(resultFtpVO.getC_left(), is(4));
            assertThat(resultFtpVO.getC_right(), is(5));
            assertThat(resultFtpVO.getC_level(), is(3));
            assertThat(resultFtpVO.getC_title(), is(equalTo("FTP설정")));
            assertThat(resultFtpVO.getC_type(), is(equalTo("default")));
            assertThat(resultFtpVO.getChildcount(), is(equalTo("NoChild")));
        }

        verify(mockFtpVO).getC_id();
        verify(mockFtpVO).getSqlMapSelector();
    }

    @Test
    public void testGetNode() throws Exception {
        when(mockFtpVO.getC_id()).thenReturn(4);
        when(mockFtpVO.getSqlMapSelector()).thenReturn("ftp");

        FtpVO resultFtpVO = ftpService.getNode(mockFtpVO);

        assertThat(resultFtpVO.getC_id(), is(4));
        assertThat(resultFtpVO.getC_parentid(), is(3));
        assertThat(resultFtpVO.getC_position(), is(0));
        assertThat(resultFtpVO.getC_left(), is(4));
        assertThat(resultFtpVO.getC_right(), is(5));
        assertThat(resultFtpVO.getC_level(), is(3));
        assertThat(resultFtpVO.getC_title(), is(equalTo("FTP설정")));
        assertThat(resultFtpVO.getC_type(), is(equalTo("default")));

        verify(mockFtpVO).getC_id();
        verify(mockFtpVO).getSqlMapSelector();
    }

}
