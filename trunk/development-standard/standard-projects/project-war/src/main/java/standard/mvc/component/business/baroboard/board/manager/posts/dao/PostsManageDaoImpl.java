package standard.mvc.component.business.baroboard.board.manager.posts.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.baroboard.board.manager.posts.vo.PostsManageVO;
import standard.mvc.component.business.baroboard.board.vo.Article;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository(value="PostsManageDao")
public class PostsManageDaoImpl extends EgovAbstractDAO implements PostsManageDao{

	@Override
	public List<PostsManageVO> getPosts(PostsManageVO postsManageVo) throws Exception {
		return list(postsManageVo.getSqlMapSelector() + "." + "getPosts", postsManageVo);
	}

	@Override
	public int getPostsTotalCnt(PostsManageVO postsManageVo) throws Exception {
		return (int) selectByPk(postsManageVo.getSqlMapSelector() + "." + "getPostsTotalCnt", postsManageVo);
	}

	@Override
	public int postsDelete(PostsManageVO postsManageVo) throws Exception {
		return (int) delete(postsManageVo.getSqlMapSelector() + "." + "postsDelete", postsManageVo);
	}

}
