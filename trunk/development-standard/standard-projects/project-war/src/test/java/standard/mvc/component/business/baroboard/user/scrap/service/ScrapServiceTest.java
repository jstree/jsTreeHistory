package standard.mvc.component.business.baroboard.user.scrap.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.user.scrap.vo.UserScrap;

public class ScrapServiceTest extends initScrapTestBase {

	@Autowired
    private UserScrapService userScrapService;

	@Test
    public void scrapList() throws Exception {
    	UserScrap userScrap = new UserScrap();
    	userScrap.setUserId(3);
        
    	List<UserScrap> userScrapList = userScrapService.scrapList(userScrap);
    	
        UserScrap userScrapResult = new UserScrap();
        
        assertThat(userScrapList.size(),  is(1));
        
        userScrapResult = userScrapList.get(0);
        
        assertThat(userScrap.getC_id(), is(270));
		assertThat(userScrap.getC_title(), is("테스트글입니다..111"));
		assertThat(userScrap.getNickName(), is("관리자"));
		assertThat(userScrap.getRegDt(), is("20150621145724"));
		assertThat(userScrap.getBoardTitle(), is(""));
		assertThat(userScrap.getBoardTitle(), is(""));
		
        <td class="dt-center">${scrap.c_id}</td>
		<td class="dt-center">일반 게시판</td>
		<td><a href="${pageContext.request.contextPath}/user/scrap/readScrap.do?boardId=${scrap.boardId}">${scrap.c_title} &nbsp; (${scrap.commentCnt})</a></td>
		<td class="dt-center">${scrap.nickName}</td>
		<td class="dt-center">${scrap.regDt}</td>
		<td class="dt-center">${scrap.viewCnt}</td>
		<td class="dt-center">${scrap.likeCount}</td>
        
    }

	@Test
	public void getScrapListTotalCnt() throws Exception{
		UserScrap userScrap = new UserScrap();
		userScrap.setUserId(2);
		int totalScrapCount =userScrapService.getScrapListTotalCnt(userScrap);
	}

}
