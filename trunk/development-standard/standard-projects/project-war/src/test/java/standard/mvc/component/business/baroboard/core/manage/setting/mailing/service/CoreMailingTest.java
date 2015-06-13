package standard.mvc.component.business.baroboard.core.manage.setting.mailing.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.core.manage.setting.mailing.vo.MailingVO;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

@DatabaseSetup("CoreMailingServiceTest.xml")
public class CoreMailingTest extends DbUnitTest<MailingVO>{

	@Autowired
	private MailingService mailingService;
	
	@Test
	public void getMailingTest() throws Exception{
		MailingVO paramVO = new MailingVO();
		paramVO.setC_id(3);
		
		MailingVO mailing = mailingService.getMailing(paramVO);
		assertThat(mailing.getC_id(),is(3));
		assertThat(mailing.getC_title(),is("이메일제목"));
		assertThat(mailing.getManagerEmailId(),is("mailAdmin"));
		assertThat(mailing.getManagerEmailUrl(),is("313.co.kr"));
	}
	
}
