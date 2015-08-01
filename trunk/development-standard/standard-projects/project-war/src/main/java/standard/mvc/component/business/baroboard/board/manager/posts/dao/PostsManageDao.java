package standard.mvc.component.business.baroboard.board.manager.posts.dao;

import java.util.List;
import java.util.Map;

import standard.mvc.component.business.baroboard.board.manager.posts.vo.PostsManageVO;
import standard.mvc.component.business.baroboard.board.vo.Article;

public interface PostsManageDao {

	List<PostsManageVO> getPosts(PostsManageVO postsManageVo) throws Exception;
	int getPostsTotalCnt(PostsManageVO postsManageVo) throws Exception;
	int postsDelete(PostsManageVO postsManageVo) throws Exception;
}
