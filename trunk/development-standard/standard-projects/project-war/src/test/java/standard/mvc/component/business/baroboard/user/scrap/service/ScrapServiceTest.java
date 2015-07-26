package standard.mvc.component.business.baroboard.user.scrap.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.user.scrap.vo.UserScrap;

@Ignore("DB Unit 에러")
public class ScrapServiceTest extends initScrapTestBase {

    @Autowired
    private UserScrapService userScrapService;

    @Test
    public void scrapList() throws Exception {
        UserScrap userScrap = new UserScrap();
        userScrap.setUserId(3);

        List<UserScrap> userScrapList = userScrapService.scrapList(userScrap);

        new UserScrap();

        assertThat(userScrapList.size(),  is(1));

        userScrapList.get(0);

        assertThat(userScrap.getC_id(), is(270));
        assertThat(userScrap.getC_title(), is("테스트글입니다..111"));
        assertThat(userScrap.getNickName(), is("관리자"));
    }

    @Test
    public void getScrapListTotalCnt() throws Exception{
        UserScrap userScrap = new UserScrap();
        userScrap.setUserId(2);
        userScrapService.getScrapListTotalCnt(userScrap);
    }

}
