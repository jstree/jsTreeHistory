package standard.mvc.component.business.baroboard.core.manage.setting.mailing.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Ignore;
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
	
	@Test
	public void alterMailing() throws Exception{
		MailingVO paramVO = new MailingVO();
		paramVO.setC_id(3);
		MailingVO mailing = mailingService.getMailing(paramVO);
		assertThat(mailing.getManagerNm(), is("메일관리자"));
		
		mailing.setManagerNm("변경된메일관리자");
		int alterResult = mailingService.alterMailing(mailing);
		assertThat(alterResult,is(1));
		
		paramVO = new MailingVO();
		paramVO.setC_id(3);
		
		MailingVO mailingAfterModified = mailingService.getMailing(paramVO);
		assertThat(mailingAfterModified.getManagerNm(), is("변경된메일관리자"));
	}
	
	@Test
	public void getMailings() throws Exception{
		MailingVO paramVO = new MailingVO();
		paramVO.setC_id(2);
		List<MailingVO> mailings = mailingService.getMailingList(paramVO);
		assertThat(mailings.size(), is(1));
		
		MailingVO mailingVO = mailings.get(0);
		assertThat(mailingVO.getC_id(), is(3));
		assertThat(mailingVO.getManagerEmailId(), is("mailAdmin"));
	}
	
	@Test
	public void deleteMailing() throws Exception{
		MailingVO paramVO = new MailingVO();
		paramVO.setC_id(3);
		MailingVO mailing = mailingService.getMailing(paramVO);
		int deleteResult = mailingService.deleteMailing(mailing);
		assertThat(deleteResult, is(0));
		
		List<MailingVO> mailings = mailingService.getMailingList(paramVO);
		assertThat(mailings.size(), is(0));
	}
	
	@Ignore
	@Test
	public void addMailing() throws Exception{
		MailingVO paramVO = new MailingVO();
		paramVO.setRef(2);
		paramVO.setC_title("추가된메일");
		paramVO.setEmailCn("추가된메일컨텐츠");
		paramVO.setEmailSendTargetId(0);
		mailingService.addMailing(paramVO);

		List<MailingVO> mailings = mailingService.getMailingList(paramVO);
		assertThat(mailings.size(), is(2));
	}
}
