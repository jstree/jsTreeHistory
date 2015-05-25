package standard.mvc.component.business.baroboard.user.manage.grade.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import standard.mvc.component.business.baroboard.user.manage.grade.vo.UserGradeManage;
import standard.mvc.component.business.baroboard.user.manage.grade.vo.UserMenuByGrade;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteAttachFile;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteByUser;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteDetail;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteTypeCode;


import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;
import egovframework.com.ext.jstree.support.util.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
@TransactionConfiguration(defaultRollback=true)
public class UserGradeServiceTest{
	
	@Resource(name = "CoreService")
    private CoreService coreService;

	public void inquiryUserGradeList() throws Exception {
		UserGradeManage userGradeManage = new UserGradeManage();
		List<UserGradeManage> userGradeManageList = coreService.getChildNode(userGradeManage);
	}

	public void inquiryUserGradeDetailInf(UserGradeManage userGradeManage) throws Exception {
		
	}

	public void saveUserGradeDetailInf(UserGradeManage userGradeManage) throws Exception {
		
	}

	public void inquiryUserMenuByGradeList(UserGradeManage userGradeManage) throws Exception {
		
	}
}
