package standard.mvc.component.business.baroboard.core.manage.setting.basicLanguage.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.core.manage.setting.basicLanguage.vo.BasicLanguageVO;
import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : BasicLanguageServiceTest.java
 * Description : 바로보드-코어-일반설정-기본언어 Service 테스트
 * Infomation  : Have To Write Information
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 5. 25.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class BasicLanguageServiceTest extends DbUnitTest<BasicLanguageVO> {

	@Autowired
	private BasicLanguageService basicLanguageService; 
	
	@Test
	public void getBasicLanguage() throws Exception {
		
		List<BasicLanguageVO> basicLanguages = basicLanguageService.getBasicLanguages();
		
		assertThat(basicLanguages.size(), is(1));
	}
}
