package standard.mvc.component.business.baroboard.board.manager.boardmanagement.dao;

import standard.mvc.component.business.baroboard.board.manager.boardmanagement.vo.BoardManagementVO;


/**
 * Modification Information
 * 
 * @author 정원기
 * @since 2015. 7. 05.
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardManagementDao.java
 * Description : 바로보드-게시판-admin-게시판설정 DAO 인터페이스
 * Information : 바로보드-게시판-admin-게시판설정 DAO 인터페이스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일          		수정자       		     수정내용
 * -------      ------------  -----------------------
 * 2015. 7. 05. 정원기                         최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

public interface BoardManagementDao {
	
	void createBoardTable( BoardManagementVO boardManagementVO ) throws Exception;
	void createLikeTable( BoardManagementVO boardManagementVO ) throws Exception;
	void createCommentTable( BoardManagementVO boardManagementVO ) throws Exception;
	void createFileTable( BoardManagementVO boardManagementVO ) throws Exception;
}