package standard.mvc.component.business.baroboard.core.manage.setting.ftp.controller;

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
import org.springframework.test.context.ActiveProfiles;
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
 * @since 2015. 5. 29.
 * @version 1.0
 * @see <pre>
 *  Class Name  : FtpControllerTest.java
 *  Description : FtpController, FtpVO validation test
 *  Information :
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 5. 29.        손호성                  최초생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
public class FtpControllerTest {

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
        this.mockMvc.perform(get("/core/manage/setting/ftp/index.do")).andDo(print())
        .andExpect(status().isOk());
    }

    @Test
    public void testAlterNode() throws Exception {
        this.mockMvc
        .perform(
                post("/core/manage/setting/ftp/save.do").param("c_id", "4")
                .param("ftpId", "user2").param("ftpPassword", "2345")
                                .param("ftpUrl", "127.0.1.1").param("ftpPort", "21")
                .param("passiveFl", "0").param("sftpFl", "0")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedFtpUrl() throws Exception {
        String notAllowedUrl = "1277.0.0.1";
        this.mockMvc
        .perform(
                post("/core/manage/setting/ftp/save.do").param("c_id", "4")
                .param("ftpId", "user2").param("ftpPassword", "2345")
                .param("ftpUrl", notAllowedUrl).param("ftpPort", "21")
                .param("passiveFl", "0").param("sftpFl", "0")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedFtpPort() throws Exception {
        String notAllowedFtpPort = "임의ftp포트";
        this.mockMvc
        .perform(
                post("/core/manage/setting/ftp/save.do").param("c_id", "4")
                .param("ftpId", "user2").param("ftpPassword", "2345")
                                .param("ftpUrl", "127.0.1.1")
                .param("ftpPort", notAllowedFtpPort).param("passiveFl", "0")
                .param("sftpFl", "0")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedPassiveFl() throws Exception {
        String notAllowedPassiveFl = "3";
        this.mockMvc
        .perform(
                post("/core/manage/setting/ftp/save.do").param("c_id", "4")
                .param("ftpId", "user2").param("ftpPassword", "2345")
                                .param("ftpUrl", "127.0.1.1").param("ftpPort", "21")
                .param("passiveFl", notAllowedPassiveFl).param("sftpFl", "0"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedSftpFl() throws Exception {
        String notAllowedSftpFl = "3";
        this.mockMvc
        .perform(
                post("/core/manage/setting/ftp/save.do").param("c_id", "4")
                .param("ftpId", "user2").param("ftpPassword", "2345")
                                .param("ftpUrl", "127.0.1.1").param("ftpPort", "21")
                .param("passiveFl", "0").param("sftpFl", notAllowedSftpFl))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithUpdateConditionOnly() throws Exception {
        this.mockMvc.perform(post("/core/manage/setting/ftp/save.do").param("c_id", "4"))
        .andDo(print()).andExpect(status().isOk());
    }

}
