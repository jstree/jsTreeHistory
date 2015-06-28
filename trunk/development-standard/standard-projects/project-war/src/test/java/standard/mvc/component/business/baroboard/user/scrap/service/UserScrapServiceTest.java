package standard.mvc.component.business.baroboard.user.scrap.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.user.scrap.vo.UserScrap;

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
 * Infomation  : 바로보드-회원관리-회원가입 Service 테스트 클래스
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
@Ignore("dataset 초기화에 문제가 생겨서 빌드가 깨지므로 배제")
@DatabaseSetup("User_Scrap.xml")
public class UserScrapServiceTest extends DbUnitTest<UserScrap> {
    
    @Autowired
    private UserScrapService userScrapService;

    @Test
    public void scrapList() throws Exception {
    	UserScrap userScrap = new UserScrap();
    	userScrap.setC_id(3);
        
    	List<UserScrap> userScrapList = userScrapService.scrapList(userScrap);
    	
        UserScrap userScrapResult = new UserScrap();
        
        assertThat(userScrapList.size(),  is(1));
        
        userScrapResult = userScrapList.get(0);
        
        assertThat(userScrap.getBoardId(),  is(2));
        assertThat(userScrap.getPostingId(),  is(270));
        assertThat(userScrap.getScrapDt(),  is(""));
        assertThat(userScrap.getRegID(),  is(3));
        assertThat(userScrap.getRegDT(),  is("20150621145724"));
        assertThat(userScrap.getViewCnt(),  is(0));
        assertThat(userScrap.getLikeCount(),  is(0));
    }
	
	@Test
    public void scapDelete() throws Exception {
		UserScrap userScrap = new UserScrap();
		
		userScrap.setC_id(3);
		userScrapService.scrapDelete(userScrap);
	}
	
	@Test
    public void scrapDetailView() throws Exception {
		UserScrap userScrap = new UserScrap();
		userScrap = userScrapService.getScrapDetailView(userScrap);
		
		assertThat(userScrap.getBoardTitle(), is(""));
		assertThat(userScrap.getContent(), is(""));
		//assertThat(userScrap.get, is(""));
		assertThat(userScrap.getBoardTitle(), is(""));
	}
}
