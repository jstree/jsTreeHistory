package egovframework.com.ext.jstree.support.manager.security.login.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUser;
/**
 * Modification Information
 * 
 * @author 김형채
 * @since 2015. 06. 24.
 * @version 1.0
 * @see <pre>
 * Class Name  : SecureUserLoginDaoTest.java
 * Description : SecureUserLoginDaoTest 테스트 클래스
 * Information  : SecureUserLoginDao 테스트 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               	  수정자                         수정내용
 * ------------  ------------   -----------------------
 * 2015. 6. 24   김형채                   최초 생성
 * 2015. 6. 24   김형채                   테스트 메소드 추가
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@WebAppConfiguration
@ContextConfiguration(classes = { WebApplicationContextConfig.class, WebMvcConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,DbUnitTestExecutionListener.class })
@DatabaseSetup(value = "SecureUserLoginDaoTest_InitialDataset.xml", type = DatabaseOperation.CLEAN_INSERT)
public class SecureUserLoginDaoTest
{
	@Autowired
	private SecureUserLoginDao secureUserLoginDao;
	private SecureUser user;
	
	@Before
	public void setUp()
	{
		user = new SecureUser();
		user.setC_id(2);
		user.setEmail("admin@313.co.kr");
		user.setLoginDt("201506241125");
	}
	
	@Test
	public void testGetUserInfoByEmail()
	{
		SecureUser secureUser = this.secureUserLoginDao.getUserInfoByEmail(user);
		
        assertThat(secureUser.getC_id()).isEqualTo(2);
        assertThat(secureUser.getC_parentid()).isEqualTo(1);
        assertThat(secureUser.getC_position()).isEqualTo(0);
        assertThat(secureUser.getC_left()).isEqualTo(2);
        assertThat(secureUser.getC_right()).isEqualTo(3);
        assertThat(secureUser.getC_level()).isEqualTo(1);
        assertThat(secureUser.getC_title()).isEqualTo("관리자");
        assertThat(secureUser.getC_type()).isEqualTo("drive");
        
        assertThat(secureUser.getUserGrade()).isEqualTo("1");
        assertThat(secureUser.getJoinStateCd()).isEqualTo(2);
        assertThat(secureUser.getPassword()).isEqualTo("bbd7182cd0ee95488f1a1e6f3fe0d8f94ed0d14e4db1dce713fe82a3231c523d");
        assertThat(secureUser.getEmail()).isEqualTo("admin@313.co.kr");
        assertThat(secureUser.getLoginFailureCnt()).isEqualTo((0));
        
        assertThat(secureUser.getPwdFindQuestionCd()).isEqualTo(5);
        assertThat(secureUser.getPwdFindAnswer()).isEqualTo("부원초등학교");
        assertThat(secureUser.getMailingServiceUseFl()).isEqualTo("0");
        assertThat(secureUser.getIndiInfoOpenFl()).isEqualTo("0");
        assertThat(secureUser.getJoinDt()).isEqualTo("20150425205811");
        
        assertThat(secureUser.getPasswordChangeDt()).isEqualTo("20150425205811");
        assertThat(secureUser.getHomepageUrl()).isEqualTo(" ");
        assertThat(secureUser.getBlogUrl()).isEqualTo(" ");
        assertThat(secureUser.getSign()).isEqualTo(" ");
        assertThat(secureUser.getProfilePhoto()).isEqualTo(" ");
        assertThat(secureUser.getImageIcon()).isEqualTo(" ");
	}
	
	@Test(expected=NullPointerException.class)
	public void testExceptionGetUserInfoByEmail()
	{
		user.setEmail("cdmin@313.co.kr");
		SecureUser secureUser = this.secureUserLoginDao.getUserInfoByEmail(user);
		assertThat(secureUser.getC_id()).isNotNull();
	}
	
	@Test
	public void testSetUserLoginFailureCntZero()
	{
		int returnCnt = this.secureUserLoginDao.setUserLoginFailureCntZero(user);
		assertThat(returnCnt).isEqualTo(1);
		
		SecureUser secureUser = this.secureUserLoginDao.getUserInfoByEmail(user);
		assertThat(secureUser.getLoginFailureCnt()).isEqualTo(0);
	}
	
	@Test
	@ExpectedDatabase(value = "SecureUserLoginDaoTest_TestSetUserLastLoginDt_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testSetUserLastLoginDt()
	{
		int returnCnt = this.secureUserLoginDao.setUserLastLoginDt(user);
		assertThat(returnCnt).isEqualTo(1);
	}
	
	@Test
	@ExpectedDatabase(value = "SecureUserLoginDaoTest_TestSetUserLoginFailureCntIncrease_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testSetUserLoginFailureCntIncrease()
	{
		int returnCnt = this.secureUserLoginDao.setUserLoginFailureCntZero(user);
		assertThat(returnCnt).isEqualTo(1);
	}
	
	@Test
	@ExpectedDatabase(value = "SecureUserLoginDaoTest_TestSetUserLoginJoinStateCd_ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testSetUserLoginJoinStateCd()
	{
		int returnCnt = this.secureUserLoginDao.setUserLoginJoinStateCd(user);
		assertThat(returnCnt).isEqualTo(1);
	}
}
