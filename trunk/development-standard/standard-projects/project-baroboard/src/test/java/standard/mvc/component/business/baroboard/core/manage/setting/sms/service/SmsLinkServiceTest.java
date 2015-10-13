package standard.mvc.component.business.baroboard.core.manage.setting.sms.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;
import standard.mvc.component.business.baroboard.core.manage.setting.sms.vo.SmsVO;

public class SmsLinkServiceTest extends DbUnitTest<SmsVO> {

	@Autowired
	private SmsLinkService smsLinkService;
	
	@Test
	public void getSmsSetting() throws Exception {
		SmsVO vo = smsLinkService.getSmsSetting();
		assertThat(vo.getC_id(), is(3));
	}
	
	@Test
	public void saveSmsSetting() throws Exception {
		SmsVO vo = smsLinkService.getSmsSetting();
		assertThat(vo.getC_id(), is(3));
		vo.setSmsSubject("modified");
		assertThat(smsLinkService.alterSmsSetting(vo), is(1));
		assertThat(smsLinkService.getSmsSetting().getSmsSubject(), is("modified"));
	}
}
