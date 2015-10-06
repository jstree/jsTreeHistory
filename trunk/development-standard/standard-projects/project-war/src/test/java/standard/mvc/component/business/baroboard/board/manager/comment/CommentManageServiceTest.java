package standard.mvc.component.business.baroboard.board.manager.comment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import standard.mvc.component.business.baroboard.board.manager.comment.service.CommentManageService;
import standard.mvc.component.business.baroboard.board.manager.comment.vo.CommentManageVO;

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
@DatabaseSetup("/standard/mvc/component/business/baroboard/board/manage/comment/CommentManageServiceTest.xml")
public class CommentManageServiceTest {

	@Autowired
	CommentManageService commentManageService;
	
	@Test
	public void getCommentTest() throws Exception {
		CommentManageVO commentManageVo = new CommentManageVO();
		
		List<CommentManageVO> commentList = commentManageService.getComment(commentManageVo);
		assertThat(commentList.size(), is(1));
		
	}
	
	@Test
	public void getCommentTotalCntTest() throws Exception {
		CommentManageVO commentManageVo = new CommentManageVO();
		
		int commentCnt = commentManageService.getCommentTotalCnt(commentManageVo);
		assertThat(commentCnt, is(1));
	}
	
	@Test(expected=Exception.class)
	@DatabaseSetup("/standard/mvc/component/business/baroboard/board/manage/comment/CommentManageServiceTest.xml")
	public void commentDeleteNullTest_chk() throws Exception{
		CommentManageVO commentManageVo = new CommentManageVO();
		commentManageVo.setChk(null);
		commentManageService.commentDelete(commentManageVo);
	}
	
	@Test
	@DatabaseSetup("/standard/mvc/component/business/baroboard/board/manage/comment/CommentManageServiceTest.xml")
	public void commentDeleteTest() throws Exception{
		CommentManageVO commentManageVo = new CommentManageVO();
		List<String> list = new ArrayList<String>();
		list.add("3@3");
		commentManageVo.setChk(list);
		CommentManageVO result = commentManageService.commentDelete(commentManageVo);
		assertThat(1, is(result.getStatus()));
		
		CommentManageVO commentManageVo2 = new CommentManageVO();
		int commentCnt = commentManageService.getCommentTotalCnt(commentManageVo2);
		assertThat(commentCnt, is(0));
		
	}

}
