package standard.mvc.component.business.community.constraint.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
 * Modification Information
 * 
 * @author Hoseong.Son
 * @since 2015.01.25
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: PrimaryControllerInjectionTest.java
 * 	Description : Spring MockMvc 기반 Controller Test
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2015.01.25    Hoseong.Son           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ActiveProfiles("test")
@ContextConfiguration(classes = { WebApplicationContextConfig.class, WebMvcConfig.class })
public class PrimaryControllerInjectionTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = webAppContextSetup(this.context).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=AssertionError.class)
	public void getTest() throws Exception {
		this.mockMvc.perform(get("/constraint/primary/getChildNode.do")).andDo(print()).andExpect(status().isOk()).andExpect(forwardedUrl("/index.do"));
	}

	@Test
	public void postTest() throws Exception {
		this.mockMvc.perform(post("/constraint/primary/getChildNode.do").param("c_id", "70")).andDo(print()).andExpect(status().isOk());
	}

}
