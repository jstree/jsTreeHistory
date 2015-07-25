package standard.mvc.component.business.baroboard.board.manager.comment.dao;

import java.util.List;

import standard.mvc.component.business.baroboard.board.manager.comment.vo.CommentManageVO;

public interface CommentManageDao {

	List<CommentManageVO> getComment(CommentManageVO commentManageVo) throws Exception;
}
