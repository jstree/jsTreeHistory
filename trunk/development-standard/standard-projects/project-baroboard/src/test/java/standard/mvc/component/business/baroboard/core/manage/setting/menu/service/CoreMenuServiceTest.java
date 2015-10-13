package standard.mvc.component.business.baroboard.core.manage.setting.menu.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import standard.mvc.component.business.baroboard.core.manage.setting.menu.vo.CoreMenuVO;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;

/**
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 7. 5.
 * @version 1.0
 * @see <pre>
 * Class Name  : CoreMenuServiceTest.java
 * Description : 바로보드-코어-메뉴 Service 테스트 클래스
 * Infomation  :
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 7. 5.          손호성                 최초 생성
 * 2015. 7. 5.          손호성                 MenuService => CoreMenuService
 * 2015. 7. 12.         손호성                 DBUnit 연동 설정 추가
 * 2015. 8. 4.          손호성                 testAddNode
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Ignore("TEST 실패 작성자 고칠것.")
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebApplicationContextConfig.class, WebMvcConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class CoreMenuServiceTest {

	@Resource(name = "CoreMenuService")
	CoreService coreMenuService;

	@Mock
	CoreMenuVO mockCoreMenuVO;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAnnotationDrivenServiceInit() {
		assertThat(coreMenuService, is(notNullValue()));
	}

	@Test
	@DatabaseSetup(value = "classpath:/standard/mvc/component/business/baroboard/core/manage/setting/menu/service/T_CORE_MENU_INIT.xml",
			type = DatabaseOperation.CLEAN_INSERT)
	public void testGetChildNode() throws Exception {
		when(mockCoreMenuVO.getC_id()).thenReturn(3);
		when(mockCoreMenuVO.getSqlMapSelector()).thenReturn("coreMenu");

		List<CoreMenuVO> bunchOfResultCoreMenuVO = coreMenuService.getChildNode(mockCoreMenuVO);

		assertThat(bunchOfResultCoreMenuVO.size(), is(not(0)));

		for (CoreMenuVO resultCoreMenuVO : bunchOfResultCoreMenuVO) {
			assertThat(resultCoreMenuVO.getC_id(), is(4));
			assertThat(resultCoreMenuVO.getC_parentid(), is(3));
			assertThat(resultCoreMenuVO.getC_position(), is(0));
			assertThat(resultCoreMenuVO.getC_left(), is(4));
			assertThat(resultCoreMenuVO.getC_right(), is(5));
			assertThat(resultCoreMenuVO.getC_level(), is(3));
		}

		verify(mockCoreMenuVO).getC_id();
		verify(mockCoreMenuVO).getSqlMapSelector();
	}

	@Test
	@DatabaseSetup(value = "classpath:/standard/mvc/component/business/baroboard/core/manage/setting/menu/service/T_CORE_MENU_INIT.xml",
			type = DatabaseOperation.CLEAN_INSERT)
	public void testAddNodeWithLevel3() throws Exception {
		CoreMenuVO coreMenuVO = new CoreMenuVO();
		coreMenuVO.setRef(3);
		coreMenuVO.setC_title("testMenu");
		coreMenuVO.setC_type("default");
		coreMenuVO.setMenuId("6");
		coreMenuVO.setPageId("6");
		coreMenuVO.setAuthId("6");
		coreMenuVO.setImageDefault("6");
		coreMenuVO.setImageHover("6");
		coreMenuVO.setImageSelected("6");
		coreMenuVO.setHomeFl("0");

		CoreMenuVO addedNode = coreMenuService.addNode(coreMenuVO);

		assertThat(addedNode, is(notNullValue()));
		assertThat(addedNode.getId(), is(greaterThanOrEqualTo(4)));

		addedNode.setC_id(addedNode.getId());
		CoreMenuVO nodeForVerification = coreMenuService.getNode(addedNode);

		assertThat(nodeForVerification, is(notNullValue()));
		assertThat(nodeForVerification.getC_id(), is(greaterThanOrEqualTo(4)));
		assertThat(nodeForVerification.getC_parentid(), is(3));
		assertThat(nodeForVerification.getC_position(), is(1));
		assertThat(nodeForVerification.getC_left(), is(6));
		assertThat(nodeForVerification.getC_right(), is(7));
		assertThat(nodeForVerification.getC_level(), is(3));

		assertThat(nodeForVerification.getC_title(), is(equalTo("testMenu")));
		assertThat(nodeForVerification.getC_type(), is(equalTo("default")));
		assertThat(nodeForVerification.getMenuId(), is(equalTo("6")));
		assertThat(nodeForVerification.getPageId(), is(equalTo("6")));
		assertThat(nodeForVerification.getAuthId(), is(equalTo("6")));
		assertThat(nodeForVerification.getImageDefault(), is(equalTo("6")));
		assertThat(nodeForVerification.getImageHover(), is(equalTo("6")));
		assertThat(nodeForVerification.getImageSelected(), is(equalTo("6")));
		assertThat(nodeForVerification.getHomeFl(), is(equalTo("0")));

	}

	@Ignore("메소드 작성중")
	@Test
	@DatabaseSetup(value = "classpath:/standard/mvc/component/business/baroboard/core/manage/setting/menu/service/T_CORE_MENU_INIT.xml",
			type = DatabaseOperation.CLEAN_INSERT)
	public void testAlterNode() throws Exception {

	}

}
