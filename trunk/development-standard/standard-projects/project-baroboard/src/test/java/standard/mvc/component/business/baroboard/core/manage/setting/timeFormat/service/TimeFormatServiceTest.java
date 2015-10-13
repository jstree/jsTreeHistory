package standard.mvc.component.business.baroboard.core.manage.setting.timeFormat.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.core.manage.setting.timeFormat.vo.TimeFormatVO;
import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

public class TimeFormatServiceTest extends DbUnitTest<TimeFormatVO>{
	
	@Autowired
	private TimeFormatService timeFormatService;

	@Test
	public void getTimeFormats() throws Exception {
		
		List<TimeFormatVO> timeFormats = timeFormatService.getTimeFormats();
		TimeFormatVO vo = timeFormats.get(0);
		assertThat(vo.getC_id(),is(3));
		assertThat(vo.getC_parentid(),is(2));
		assertThat(vo.getC_position(),is(0));
		assertThat(vo.getC_level(),is(2));
		assertThat(vo.getC_left(),is(3));
		assertThat(vo.getC_right(),is(4));
		
	}
}
