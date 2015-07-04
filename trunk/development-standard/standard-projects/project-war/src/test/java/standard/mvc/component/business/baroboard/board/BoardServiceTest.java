package standard.mvc.component.business.baroboard.board;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import standard.mvc.component.business.baroboard.board.service.BoardService;
import standard.mvc.component.business.baroboard.board.vo.Article;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;

/**
 * 
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 *  Class Name  : BoardServiceTest.java
 *  Description : 바로보드-게시판 Service 테스트 클래스
 *  Information :
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 5. 25.      전경훈                  최초생성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebApplicationContextConfig.class, WebMvcConfig.class })
public class BoardServiceTest {

	@Resource(name = "BoardService")
	private BoardService boardService;

	@Before
	public void setUp() {

	}

	@Ignore
	@Test
	public void getAllArticles() {
		Article article = new Article();
		article.setBoardID("test");
		List<Article> list = null;
		try {
			list = boardService.getArticleList(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void getAnnouncementList() {
		Article article = new Article();
		article.setBoardID("test");
		List<Article> list = null;
		try {
			list = boardService.getAnnounceList(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
