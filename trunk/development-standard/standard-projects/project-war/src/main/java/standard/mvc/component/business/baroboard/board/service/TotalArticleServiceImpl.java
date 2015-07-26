package standard.mvc.component.business.baroboard.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.board.dao.TotalArticleDao;
import standard.mvc.component.business.baroboard.board.vo.TotalArticle;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 7. 26
 * @version 1.0
 * @see <pre>
 * Class Name  : TotalArticleServiceImpl.java
 * Description : 바로보드-게시판 모든 글관리 Service 구현체
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 7. 26     전경훈        최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Service(value = "TotalArticleService")
public class TotalArticleServiceImpl implements TotalArticleService {

	@Autowired
	private TotalArticleDao totalArticleDao;
	
	@Override
	public List<TotalArticle> getArticlesByRegIDAndPage(TotalArticle totalArticle) throws Exception {
		return totalArticleDao.getArticlesByRegIDAndPage(totalArticle);
	}

	@Override
	public int getTotalArticleCountByRegID(TotalArticle totalArticle) throws Exception {
		return totalArticleDao.getTotalArticleCountByRegID(totalArticle);
	}

	@Override
	public int updateTitleByBoardIdAndArticleID(TotalArticle totalArticle) throws Exception {
		return totalArticleDao.updateTitleByBoardIdAndArticleID(totalArticle);
	}

	@Override
	public int updateIsDeletedFLByBoardIdAndArticleID(TotalArticle totalArticle) throws Exception {
		return totalArticleDao.updateIsDeletedFLByBoardIdAndArticleID(totalArticle);
	}

}