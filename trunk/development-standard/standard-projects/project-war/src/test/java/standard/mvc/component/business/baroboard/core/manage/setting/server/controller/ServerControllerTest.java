package standard.mvc.component.business.baroboard.core.manage.setting.server.controller;

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
 * @since 2015. 5. 24.
 * @version 1.0
 * @see <pre>
 * Class Name  : ServerControllerTest.java
 * Description : ServerController, ServerVO validation test
 * Information :
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 5. 24.       손호성                 최초 생성
 * 2015. 5. 25.       손호성                 validator 적용 테스트
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
public class ServerControllerTest {

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
        this.mockMvc.perform(get("/core/manage/setting/server/index.do")).andDo(print())
        .andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithoutC_type() throws Exception {
        this.mockMvc
        .perform(
                post("/core/manage/setting/server/save.do").param("c_id", "4")
                .param("url", "http://127.0.1.1").param("sslFl", "0")
                .param("httpPort", "18080").param("httpsPort", "18443")
                .param("shortUrlFl", "0").param("ssoFl", "0")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedUrl() throws Exception {
        String notAllowedUrl = "임의URL";
        this.mockMvc
        .perform(
                post("/core/manage/setting/server/save.do").param("c_id", "4")
                .param("url", notAllowedUrl).param("sslFl", "0")
                .param("httpPort", "18080").param("httpsPort", "18443")
                .param("shortUrlFl", "0").param("ssoFl", "0")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedSslFl() throws Exception {
        String notAllowedSslFl = "3";
        this.mockMvc
        .perform(
                post("/core/manage/setting/server/save.do").param("c_id", "4")
                .param("url", "http://127.0.1.1").param("sslFl", notAllowedSslFl)
                .param("httpPort", "18080").param("httpsPort", "18443")
                .param("shortUrlFl", "0").param("ssoFl", "0")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedHttpPort() throws Exception {
        String notAllowedHttpPort = "문자열http포트번호";
        this.mockMvc
        .perform(
                post("/core/manage/setting/server/save.do").param("c_id", "4")
                .param("url", "http://127.0.1.1").param("sslFl", "0")
                .param("httpPort", notAllowedHttpPort).param("httpsPort", "18443")
                .param("shortUrlFl", "0").param("ssoFl", "0")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedHttpsPort() throws Exception {
        String notAllowedHttpsPort = "문자열https포트번호";
        this.mockMvc
        .perform(
                post("/core/manage/setting/server/save.do").param("c_id", "4")
                .param("url", "http://127.0.1.1").param("sslFl", "0")
                .param("httpPort", "18080").param("httpsPort", notAllowedHttpsPort)
                .param("shortUrlFl", "0").param("ssoFl", "0")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedShortUrlFl() throws Exception {
        String notAllowedShortUrlFl = "3";
        this.mockMvc
        .perform(
                post("/core/manage/setting/server/save.do").param("c_id", "4")
                .param("url", "http://127.0.1.1").param("sslFl", "0")
                .param("httpPort", "18080").param("httpsPort", "18443")
                .param("shortUrlFl", notAllowedShortUrlFl).param("ssoFl", "0"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithNotAllowedSsoFl() throws Exception {
        String notAllowedSsoFl = "3";
        this.mockMvc
        .perform(
                post("/core/manage/setting/server/save.do").param("c_id", "4")
                .param("url", "http://127.0.1.1").param("sslFl", "0")
                .param("httpPort", "18080").param("httpsPort", "18443")
                .param("shortUrlFl", "0").param("ssoFl", notAllowedSsoFl))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAlterNodeWithUpdateConditionOnly() throws Exception {
        this.mockMvc.perform(post("/core/manage/setting/server/save.do").param("c_id", "4"))
        .andDo(print()).andExpect(status().isOk());
    }

}
