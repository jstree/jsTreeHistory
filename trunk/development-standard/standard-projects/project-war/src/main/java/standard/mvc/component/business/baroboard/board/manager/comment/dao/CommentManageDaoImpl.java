package standard.mvc.component.business.baroboard.board.manager.comment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import standard.mvc.component.business.baroboard.board.manager.comment.vo.CommentManageVO;

@Repository(value="CommentManageDao")
public class CommentManageDaoImpl extends EgovAbstractDAO implements CommentManageDao{

	@Override
	public List<CommentManageVO> getComment(CommentManageVO commentManageVo)
			throws Exception {
		return list(commentManageVo.getSqlMapSelector() + "." + "getComment", commentManageVo);
	}
}
