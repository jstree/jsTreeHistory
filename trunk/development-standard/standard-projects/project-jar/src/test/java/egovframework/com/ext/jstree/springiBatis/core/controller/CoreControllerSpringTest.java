package egovframework.com.ext.jstree.springiBatis.core.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebApplicationContextConfig.class, WebMvcConfig.class })
public class CoreControllerSpringTest {

    @Autowired
    private CoreController controller;

    private MockMvc mockMvc;
    private String defaultUri;

    @Before
    public void setUp() {
        
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        defaultUri = "/egovframework/com/etc/jstree/springiBatis/core";
    }

    @Test
    public void getChildNodeTest() throws Exception {
        MvcResult result = mockMvc.perform(post(defaultUri + "/getChildNode.do")
                .param("c_id", "1"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();

        assertThat(StringUtils.contains(result.getResponse().getHeader("Content-type"),MediaType.APPLICATION_JSON_VALUE), is(true));
    }

    @Test
    public void getChildNodeFailTest() throws Exception {
        MvcResult failResult = mockMvc.perform(post(defaultUri + "/getChildNode.do")
                .param("c_id", "0"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();

        assertThat(StringUtils.contains(failResult.getResponse().getHeader("Content-type"), MediaType.TEXT_HTML_VALUE), is(true));
    }
    
    @Test
    public void searchNodeTest() throws Exception {
    	MvcResult failResult = mockMvc.perform(post(defaultUri + "/searchNode.do")
    			.param("searchString", "검색"))
    			.andDo(print())
    			.andExpect(status().isOk()).andReturn();
    	
    	assertThat(StringUtils.contains(failResult.getResponse().getHeader("Content-type"), MediaType.TEXT_HTML_VALUE), is(true));
    }
}