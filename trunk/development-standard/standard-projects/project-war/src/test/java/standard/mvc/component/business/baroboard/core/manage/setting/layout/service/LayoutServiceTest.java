package standard.mvc.component.business.baroboard.core.manage.setting.layout.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.core.manage.setting.layout.vo.LayoutVO;
import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

public class LayoutServiceTest extends DbUnitTest<LayoutVO>{

	@Autowired
	private LayoutService layoutService;
	
	@Test
	public void getLayouts() throws Exception {
		List<LayoutVO> layouts = layoutService.getLayouts();
		assertThat(layouts.get(0).getC_title(),is("BaroDefault"));
	}
	
}
