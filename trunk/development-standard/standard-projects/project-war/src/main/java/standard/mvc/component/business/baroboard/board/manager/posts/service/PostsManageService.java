package standard.mvc.component.business.baroboard.board.manager.posts.service;

import java.util.List;

import standard.mvc.component.business.baroboard.board.manager.posts.vo.PostsManageVO;
import standard.mvc.component.business.baroboard.board.vo.Article;

public interface PostsManageService {

	List<PostsManageVO> getPosts(PostsManageVO postsManageVo) throws Exception;
	PostsManageVO postsDelete(PostsManageVO postsManageVo) throws Exception;
	PostsManageVO postsBoardMove(PostsManageVO postsManageVo) throws Exception;
	int getPostsRightPage(PostsManageVO postsManageVo) throws Exception;
}
