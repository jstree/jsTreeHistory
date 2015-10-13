package standard.mvc.component.business.baroboard.core.manage.setting.upload.service;

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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import standard.mvc.component.business.baroboard.core.manage.setting.messages.ExceptionMessage;
import standard.mvc.component.business.baroboard.core.manage.setting.upload.vo.UploadVO;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;

/**
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 5. 31.
 * @version 1.0
 * @see <pre>
 * Class Name  : UploadServiceTest.java
 * Description : 바로보드-코어-고급설정-파일업로드 서비스 테스트
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 5. 31.         손호성                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
public class UploadServiceTest {

    @Resource(name = "UploadService")
    CoreService uploadService;

    @Mock
    UploadVO mockUploadVO;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testAnnotationDrivenServiceInit() {
        assertThat(uploadService, is(notNullValue()));
    }

    @Test
    public void testUnsupportedOperation() throws Exception {
        try {
            uploadService.addNode(mockUploadVO);
        } catch (Exception e) {
            assertThat(e, is(instanceOf(RuntimeException.class)));
            assertThat(e.getMessage(), is(equalTo(ExceptionMessage.UN_SUPPORTED.getValue())));
        }
    }

    @Test
    public void testAlterNode() throws Exception {
        when(mockUploadVO.getC_id()).thenReturn(4);
        when(mockUploadVO.getSqlMapSelector()).thenReturn("upload");
        when(mockUploadVO.getFileSizeLimit()).thenReturn("50");
        when(mockUploadVO.getDocSizeLimit()).thenReturn("5");
        when(mockUploadVO.getFileExtLimit()).thenReturn("*.*");
        when(mockUploadVO.getExtnlLnkFl()).thenReturn("0");
        when(mockUploadVO.getExtnlLnkAllowedExt()).thenReturn("hwp,doc");
        when(mockUploadVO.getExtnlLnkAllowedSite()).thenReturn("http://www.naver.com");

        assertThat(uploadService.alterNode(mockUploadVO), is(1));

        UploadVO resultServerVO = uploadService.getNode(mockUploadVO);

        assertThat(resultServerVO.getC_id(), is(4));

        verify(mockUploadVO, times(2)).getC_id();
        verify(mockUploadVO, times(2)).getSqlMapSelector();
        verify(mockUploadVO).getFileSizeLimit();
        verify(mockUploadVO).getDocSizeLimit();
        verify(mockUploadVO).getFileExtLimit();
        verify(mockUploadVO).getExtnlLnkFl();
        verify(mockUploadVO).getExtnlLnkAllowedExt();
        verify(mockUploadVO).getExtnlLnkAllowedSite();
    }

    @Test
    public void testAnnotationDrivenMock() throws Exception {
        when(mockUploadVO.getC_id()).thenReturn(1);
        assertThat(mockUploadVO.getC_id(), is(1));
        verify(mockUploadVO).getC_id();
    }

    @Test
    public void testGetChildNode() throws Exception {
        when(mockUploadVO.getC_id()).thenReturn(3);
        when(mockUploadVO.getSqlMapSelector()).thenReturn("upload");

        List<UploadVO> bunchOfResultServerVO = uploadService.getChildNode(mockUploadVO);

        assertThat(bunchOfResultServerVO.size(), is(1));

        for (UploadVO resultServerVO : bunchOfResultServerVO) {
            assertThat(resultServerVO.getC_id(), is(4));
            assertThat(resultServerVO.getC_parentid(), is(3));
            assertThat(resultServerVO.getC_position(), is(0));
            assertThat(resultServerVO.getC_left(), is(4));
            assertThat(resultServerVO.getC_right(), is(5));
            assertThat(resultServerVO.getC_level(), is(3));
            assertThat(resultServerVO.getC_title(), is(equalTo("파일업로드설정")));
            assertThat(resultServerVO.getC_type(), is(equalTo("default")));
            assertThat(resultServerVO.getChildcount(), is(equalTo("NoChild")));
        }

        verify(mockUploadVO).getC_id();
        verify(mockUploadVO).getSqlMapSelector();
    }

    @Test
    public void testGetNode() throws Exception {
        when(mockUploadVO.getC_id()).thenReturn(4);
        when(mockUploadVO.getSqlMapSelector()).thenReturn("upload");

        UploadVO resultServerVO = uploadService.getNode(mockUploadVO);

        assertThat(resultServerVO.getC_id(), is(4));
        assertThat(resultServerVO.getC_parentid(), is(3));
        assertThat(resultServerVO.getC_position(), is(0));
        assertThat(resultServerVO.getC_left(), is(4));
        assertThat(resultServerVO.getC_right(), is(5));
        assertThat(resultServerVO.getC_level(), is(3));
        assertThat(resultServerVO.getC_title(), is(equalTo("파일업로드설정")));
        assertThat(resultServerVO.getC_type(), is(equalTo("default")));

        verify(mockUploadVO).getC_id();
        verify(mockUploadVO).getSqlMapSelector();
    }

}
