package egovframework.com.ext.jstree.springiBatis.core.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import egovframework.com.ext.jstree.springiBatis.core.controller.CoreController;
import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebApplicationContextConfig.class, WebMvcConfig.class })
public class CoreServiceTest {

	@Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private CoreController coreController;

    @Autowired
    private CoreServiceImpl coreServiceImpl;
	    
    @Autowired
    private CoreDao coreDao;
	   
    @Before
    public void ready() {

        assertThat(applicationContext, notNullValue());
        assertThat(coreController, notNullValue());
        assertThat(coreServiceImpl, notNullValue());
        assertThat(coreDao, notNullValue());
    }
       
	@Test
	public void test() throws Exception{
		ComprehensiveTree comprehensiveTree = new ComprehensiveTree();
		comprehensiveTree.setSearchStr("First Child");
		List<String> testResult = coreServiceImpl.searchNode(comprehensiveTree);
		if(testResult.isEmpty()){
			assertEquals(testResult.size(), 0);
		}else{
			assertEquals(testResult.get(0).indexOf("#node_"), 0);
		}
	}
}
