package standard.mvc.component.business.baroboard.board.manager.boardmanagement.dao;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.baroboard.board.manager.boardmanagement.vo.BoardManagementVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
/**
 * Modification Information
 * 
 * @author 정원기
 * @since 2015. 7. 05.
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardManagementDaoImpl.java
 * Description : 바로보드-게시판-admin-게시판설정 DAO 구현 클래스
 * Information : 바로보드-게시판-admin-게시판설정 DAO 구현 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                      수정자                         수정내용
 * -------      ------------  -----------------------
 * 2015. 7. 05. 정원기                         최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Repository
public class BoardManagementDaoImpl extends EgovComAbstractDAO implements BoardManagementDao {

	@Override
	public void createBoardTable( BoardManagementVO boardManagementVO )
			throws Exception{
		// 테이블 생성
		update(boardManagementVO.getSqlMapSelector() + ".createBoardTable", boardManagementVO);
		createAdditionalTables( boardManagementVO );
	}
	
	private void createAdditionalTables( BoardManagementVO boardManagementVO ) throws Exception{
		update(boardManagementVO.getSqlMapSelector() + ".createLogTable", boardManagementVO);
		update(boardManagementVO.getSqlMapSelector() + ".createTrigger",  boardManagementVO);
		update(boardManagementVO.getSqlMapSelector() + ".createSequence", boardManagementVO);
	}

	@Override
	public void createLikeTable(BoardManagementVO boardManagementVO)
			throws Exception {
		update(boardManagementVO.getSqlMapSelector() + ".createLikeTable", boardManagementVO);
		createAdditionalTables( boardManagementVO );
	}

	@Override
	public void createCommentTable(BoardManagementVO boardManagementVO)
			throws Exception {
		update(boardManagementVO.getSqlMapSelector() + ".createCommentTable", boardManagementVO);
		createAdditionalTables( boardManagementVO );
	}

	@Override
	public void createFileTable(BoardManagementVO boardManagementVO)
			throws Exception {
		update(boardManagementVO.getSqlMapSelector() + ".createFileTable", boardManagementVO);
		createAdditionalTables( boardManagementVO );
	}
	
	@Override
	public int getTableSeq(BoardManagementVO boardManagementVO) throws Exception{
		return (Integer)selectByPk(boardManagementVO.getSqlMapSelector() + ".getTableSeq", boardManagementVO);
	}
}