package standard.mvc.component.business.baroboard.user.join.register;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.user.join.register.service.UserRegisterService;
import standard.mvc.component.business.baroboard.user.vo.User;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

/**
 * Modification Information
 * 
 * @author 오권우
 * @since 2015. 6. 2.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserRegisterServiceTest.java
 * Description : 바로보드-회원관리-회원가입 Service 테스트 클래스
 * Information : 바로보드-회원관리-회원가입 Service 테스트 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 6. 2.  오권우                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@DatabaseSetup("User_Register.xml")
public class UserRegisterServiceTest extends DbUnitTest<User> {
    
    
    @Autowired
    private UserRegisterService userRegisterService;
	
	@Test
    public void getUserInfo() throws Exception {
        
		User user = userRegisterService.getUserInfo("관리자");
		
        assertThat(user.getC_id(), is(2));
        assertThat(user.getC_parentid(), is(1));
        assertThat(user.getC_position(), is(0));
        assertThat(user.getC_left(), is(2));
        assertThat(user.getC_right(), is(3));
        assertThat(user.getC_level(), is(1));
        assertThat(user.getC_title(), is(equalTo("관리자")));
        assertThat(user.getC_type(), is(equalTo("drive"))); // TODO Enumeration 도입 필요
        
        assertThat(user.getUserGradeCd(), is(1));
        assertThat(user.getJoinStateCd(), is(equalTo(2)));
        assertThat(user.getPassword(), is(equalTo("bbd7182cd0ee95488f1a1e6f3fe0d8f94ed0d14e4db1dce713fe82a3231c523d")));
        assertThat(user.getEmail(), is(equalTo("admin@313.co.kr")));
        assertThat(user.getLoginFailureCnt(), is(equalTo(0)));
        
        assertThat(user.getPasswordFindQuestion(), is(equalTo("초등학교 이름은")));
        assertThat(user.getPasswordFindAnswer(), is(equalTo("부원초등학교")));
        assertThat(user.getMailingServiceUseFl(), is(equalTo("0")));
        assertThat(user.getIndiInfoOpenFl(), is(equalTo("0")));
        assertThat(user.getJoinDt(), is(equalTo("20150425205811")));
        
        assertThat(user.getPasswordChangeDt(), is(equalTo("20150425205811")));
        assertThat(user.getHomepageUrl(), is(equalTo(" ")));
        assertThat(user.getBlogUrl(), is(equalTo(" ")));
        assertThat(user.getSign(), is(equalTo(" ")));
        assertThat(user.getProfilePhoto(), is(equalTo(" ")));
        assertThat(user.getImageIcon(), is(equalTo(" ")));
    
    }
	
	@Test
    public void addUser() throws Exception {
		User user = new User();
		user.setC_position(1);
	    user.setC_title("사용자");
        user.setC_type("default");
        user.setRef(2);
        
        user.setUserGradeCd(1);
        user.setJoinStateCd(2);
        user.setPassword("bbd7182cd0ee95488f1a1e6f3fe0d8f94ed0d14e4db1dce713fe82a3231c523d");
        user.setEmail("user@313.co.kr");
        user.setLoginFailureCnt(0);
        
        user.setPasswordFindQuestion("초등학교 이름은");
        user.setPasswordFindAnswer("부원초등학교");
        user.setMailingServiceUseFl("0");
        user.setIndiInfoOpenFl("0");
        //user.setJoinDt("20150425205811");
        
        //user.setPasswordChangeDt("20150425205811")));
        user.setHomepageUrl(" ");
        user.setBlogUrl(" ");
        user.setSign(" ");
        user.setProfilePhoto(" ");
        user.setImageIcon(" ");
        
        User user1 = userRegisterService.userRegister(user);
		
        
        User userComplate = userRegisterService.getUserInfo("사용자");
        
        assertThat(userComplate.getEmail(),  is(equalTo(user.getEmail())));
	}
	
	@Test
    public void nickNameUseVerification() throws Exception {
		int nickNameFl = userRegisterService.nickNameUseVerification("관리자");
		
		assertThat(nickNameFl, is(1));
	}
	
}
