package standard.mvc.component.business.baroboard.core.manage.setting.localTime.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.core.manage.setting.localTime.vo.LocalTimeVO;
import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

public class LocalTimeServiceTest extends DbUnitTest<LocalTimeVO>{

	@Autowired
	private LocalTimeService localTimeService;
	
	@Test
	public void test() throws Exception{
		List<LocalTimeVO> localTimes = localTimeService.getLocalTimes();
		assertThat(localTimes.get(0).getC_title(),is("[GMT -12:00] Baker Island Time"));
	}
	
}
