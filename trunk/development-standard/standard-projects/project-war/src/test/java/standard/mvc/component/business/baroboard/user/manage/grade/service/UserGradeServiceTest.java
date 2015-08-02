package standard.mvc.component.business.baroboard.user.manage.grade.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import standard.mvc.component.business.baroboard.user.manage.grade.vo.UserGradeManage;


import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ActiveProfiles("test")
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
@TransactionConfiguration(defaultRollback=true)
public class UserGradeServiceTest{
	
	@Resource(name = "CoreService")
    private CoreService coreService;

	@Test
	public void inquiryUserGradeList() throws Exception {
		UserGradeManage userGradeManage = new UserGradeManage();
		List<UserGradeManage> userGradeManageList = coreService.getChildNode(userGradeManage);
	}

	@Ignore
	public void inquiryUserGradeDetailInf(UserGradeManage userGradeManage) throws Exception {
		
	}

	@Ignore
	public void saveUserGradeDetailInf(UserGradeManage userGradeManage) throws Exception {
		
	}

	@Ignore
	public void inquiryUserMenuByGradeList(UserGradeManage userGradeManage) throws Exception {
		
	}
}
