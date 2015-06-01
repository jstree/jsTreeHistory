package standard.mvc.component.business.baroboard.core.manage.setting.upload.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

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
 * Class Name  : UploadControllerTest.java
 * Description : 바로보드-코어-고급설정-파일업로드 컨트롤러 테스트
 * Infomation  :
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
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
public class UploadControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(this.context).build();
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetNode() throws Exception {
        this.mockMvc.perform(get("/core/manage/setting/upload/index.do")).andDo(print())
        .andExpect(status().isOk());
    }

    @Test
    public void testAlterNode() throws Exception {
        this.mockMvc
        .perform(
                post("/core/manage/setting/upload/save.do").param("c_id", "4")
                .param("fileSizeLimit", "50").param("docSizeLimit", "5")
                .param("fileExtLimit", "*.*").param("extnlLnkFl", "0")
                .param("extnlLnkAllowedExt", "hwp,doc")
                .param("extnlLnkAllowedSite", "http://www.naver.com"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedFileSizeLimit() throws Exception {
        String notAllowedFileSizeLimit = "file리미트";
        this.mockMvc
        .perform(
                post("/core/manage/setting/upload/save.do").param("c_id", "4")
                .param("fileSizeLimit", notAllowedFileSizeLimit)
                .param("docSizeLimit", "5").param("fileExtLimit", "*.*")
                .param("extnlLnkFl", "0").param("extnlLnkAllowedExt", "hwp,doc")
                .param("extnlLnkAllowedSite", "http://www.naver.com"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedDocSizeLimit() throws Exception {
        String notAllowedDocSizeLimit = "doc리미트";
        this.mockMvc
        .perform(
                post("/core/manage/setting/upload/save.do").param("c_id", "4")
                .param("fileSizeLimit", "50")
                .param("docSizeLimit", notAllowedDocSizeLimit)
                .param("fileExtLimit", "*.*").param("extnlLnkFl", "0")
                .param("extnlLnkAllowedExt", "hwp,doc")
                .param("extnlLnkAllowedSite", "http://www.naver.com"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedExtnlLnkFl() throws Exception {
        String notAllowedExtnlLnkFl = "3";
        this.mockMvc
        .perform(
                post("/core/manage/setting/upload/save.do").param("c_id", "4")
                .param("fileSizeLimit", "50").param("docSizeLimit", "5")
                .param("fileExtLimit", "*.*")
                .param("extnlLnkFl", notAllowedExtnlLnkFl)
                .param("extnlLnkAllowedExt", "hwp,doc")
                .param("extnlLnkAllowedSite", "http://www.naver.com"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithUpdateConditionOnly() throws Exception {
        this.mockMvc.perform(post("/core/manage/setting/upload/save.do").param("c_id", "4"))
        .andDo(print()).andExpect(status().isOk());
    }

}
