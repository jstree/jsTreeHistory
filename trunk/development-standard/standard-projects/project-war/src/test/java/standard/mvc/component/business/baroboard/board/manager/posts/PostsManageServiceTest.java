package standard.mvc.component.business.baroboard.board.manager.posts;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import standard.mvc.component.business.baroboard.board.manager.posts.service.PostsManageService;
import standard.mvc.component.business.baroboard.board.manager.posts.vo.PostsManageVO;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ActiveProfiles("test")
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
public class PostsManageServiceTest {

	@Autowired
	PostsManageService postsManageService;
	
	@Test
	@DatabaseSetup("/standard/mvc/component/business/baroboard/board/manage/posts/PostsManageServiceTest.xml")
	public void getPostsTest() throws Exception {
		PostsManageVO postsManageVo = new PostsManageVO();
		
		List<PostsManageVO> postsList = postsManageService.getPosts(postsManageVo);
		assertThat(postsList.size(), is(2));
		
	}
	
	@Test
	@DatabaseSetup("/standard/mvc/component/business/baroboard/board/manage/posts/PostsManageServiceTest.xml")
	public void getPostsTotalCntTest() throws Exception {
		PostsManageVO postsManageVo = new PostsManageVO();
		
		int postsCnt = postsManageService.getPostsTotalCnt(postsManageVo);
		assertThat(postsCnt, is(2));
	}
	
	@Test(expected=Exception.class)
	@DatabaseSetup("/standard/mvc/component/business/baroboard/board/manage/posts/PostsManageServiceTest.xml")
	public void postsDeleteNullTest_chk() throws Exception{
		PostsManageVO postsManageVo = new PostsManageVO();
		postsManageVo.setChk(null);
		postsManageService.postsDelete(postsManageVo);
	}
	
	@Test
	@DatabaseSetup("/standard/mvc/component/business/baroboard/board/manage/posts/PostsManageServiceTest.xml")
	public void postsDeleteTest() throws Exception{
		PostsManageVO postsManageVo = new PostsManageVO();
		List<String> list = new ArrayList<String>();
		list.add("3@3");
		postsManageVo.setChk(list);
		PostsManageVO result = postsManageService.postsDelete(postsManageVo);
		
		assertThat(1, is(result.getStatus()));
		
		PostsManageVO postsManageVo2 = new PostsManageVO();
		int postsCnt = postsManageService.getPostsTotalCnt(postsManageVo2);
		assertThat(postsCnt, is(1));
		
	}
	
	@Test(expected=Exception.class)
	@DatabaseSetup("/standard/mvc/component/business/baroboard/board/manage/posts/PostsManageServiceTest.xml")
	public void postsBoardMoveNullTest_chk() throws Exception{
		PostsManageVO postsManageVo = new PostsManageVO();
		postsManageVo.setChk(null);
		postsManageService.postsBoardMove(postsManageVo);
	}
	
	@Test
	@DatabaseSetup("/standard/mvc/component/business/baroboard/board/manage/posts/PostsManageServiceTest.xml")
	public void postsBoardMoveTest() throws Exception{
		PostsManageVO postsManageVo = new PostsManageVO();
		List<String> list = new ArrayList<String>();
		list.add("3@3@4");
		postsManageVo.setChk(list);
		PostsManageVO result = postsManageService.postsBoardMove(postsManageVo);
		assertThat(1, is(result.getStatus()));
		List<PostsManageVO> postsList = postsManageService.getPosts(new PostsManageVO());
		assertThat(2, is(postsList.size()));
		assertThat("4", is(postsList.get(0).getBoardId()));
		assertThat("4", is(postsList.get(1).getBoardId()));
	}
}
