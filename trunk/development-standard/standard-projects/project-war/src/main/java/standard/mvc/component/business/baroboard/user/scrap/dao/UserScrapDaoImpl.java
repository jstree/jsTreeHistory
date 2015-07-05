package standard.mvc.component.business.baroboard.user.scrap.dao;

import java.util.List;

import org.springframework.stereotype.Repository;



import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.user.scrap.vo.UserScrap;
/**
 * Modification Information
 * 
 * @author 오권우
 * @since 2015. 6. 03.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserRegisterDaoImpl.java
 * Description : 바로보드-사용자 정보 DAO 구현 클래스
 * Information : 바로보드-사용자 정보 DAO 구현 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일          수정자       수정내용
 * -------      ------------  -----------------------
 * 2015. 6. 03.      오권우       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Repository
public class UserScrapDaoImpl extends EgovComAbstractDAO implements UserScrapDao {

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<UserScrap> getUserScrapList(UserScrap userScrap) throws Exception {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("userScrap.getScrapListByPage", userScrap);
	}

	@Override
	public UserScrap getScrapDetailView(UserScrap userScrap) throws Exception {
		// TODO Auto-generated method stub
		return (UserScrap)getSqlMapClientTemplate().queryForObject("userScrap.scrapDetailView", userScrap);
	}

	@Override
	public int getScrapListTotalCnt(UserScrap userScrap) {
		// TODO Auto-generated method stub
		return (int)selectByPk(userScrap.getSqlMapSelector() + "." + "getScrapListCnt", userScrap);
	}

}
