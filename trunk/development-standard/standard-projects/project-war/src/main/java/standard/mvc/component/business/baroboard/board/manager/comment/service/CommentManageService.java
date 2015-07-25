package standard.mvc.component.business.baroboard.board.manager.comment.service;

import java.util.List;

import standard.mvc.component.business.baroboard.board.manager.comment.vo.CommentManageVO;
import standard.mvc.component.business.baroboard.board.manager.posts.vo.PostsManageVO;

public interface CommentManageService {

	List<CommentManageVO> getComment(CommentManageVO commentManageVo) throws Exception;
	CommentManageVO commentDelete(CommentManageVO commentManageVo) throws Exception;
}
