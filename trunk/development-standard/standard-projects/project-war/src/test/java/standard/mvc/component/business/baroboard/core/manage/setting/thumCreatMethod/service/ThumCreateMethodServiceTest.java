package standard.mvc.component.business.baroboard.core.manage.setting.thumCreatMethod.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.core.manage.setting.thumCreateMethod.service.ThumCreateMethodService;
import standard.mvc.component.business.baroboard.core.manage.setting.thumCreateMethod.vo.ThumCreateMethodVO;
import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

public class ThumCreateMethodServiceTest extends DbUnitTest<ThumCreateMethodVO> {

	@Autowired
	private ThumCreateMethodService thumCreateMethodService;
	
	@Test
	public void test() throws Exception {
		
		List<ThumCreateMethodVO> thumCreateMethods = thumCreateMethodService.getThumCreateMethods();
		assertThat(thumCreateMethods.get(0).getC_title(),is("Crop"));
	}
	
}
