package standard.mvc.component.business.baroboard.board.manager.comment.dao;

import java.util.List;

import standard.mvc.component.business.baroboard.board.manager.comment.vo.CommentManageVO;
import standard.mvc.component.business.baroboard.board.manager.posts.vo.PostsManageVO;

public interface CommentManageDao {

	List<CommentManageVO> getComment(CommentManageVO commentManageVo) throws Exception;
	int getCommentTotalCnt(CommentManageVO commentManageVo) throws Exception;
}
