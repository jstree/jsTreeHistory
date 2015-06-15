package standard.mvc.component.business.baroboard.core.manage.setting.basicSetting.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.core.manage.setting.basicSetting.vo.BasicSettingVO;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 5. 19.
 * @version 1.0
 * @see <pre>
 * Class Name  : BasicSettingServiceTest.java
 * Description : 바로보드 코어 일반설정 service 테스트
 * Information : 바로보드 코어 일반설정 service 테스트
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 5. 19.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class BasicSettingServiceTest extends DbUnitTest<BasicSettingVO>{

	@Autowired
	private BasicSettingService basicSettingService;
	
	@Test
	@DatabaseSetup("BasicSettingServiceTest.xml")
	public void getBasicSettingWhenSettingDB() throws Exception {

		BasicSettingVO basicSetting = basicSettingService.getBasicSetting();
		
		assertThat(basicSetting.getC_id(), is(3));
		assertThat(basicSetting.getC_parentid(), is(2));
		assertThat(basicSetting.getC_position(), is(0));
		assertThat(basicSetting.getC_left(), is(3));
		assertThat(basicSetting.getC_right(), is(4));
		assertThat(basicSetting.getC_level(), is(2));
		assertThat(basicSetting.getFooterScript(), is("Copyright © Since 2013, 313 Developer Group"));
		
	}
	
	@Test
	@DatabaseSetup("BasicSettingServiceTest.xml")
    @ExpectedDatabase(value = "BasicSettingServiceTest_save.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void saveBasicSetting() throws Exception {
		
		BasicSettingVO basicSetting = basicSettingService.getBasicSetting();
		
		basicSetting.setAccesProhWords("GoodWords");
		basicSetting.setMobileIconApplyFl(1);
		basicSetting.setFaviconUseFl(0);
		assertThat(basicSettingService.alterBasicSetting(basicSetting),is(1));
	}
	

}
