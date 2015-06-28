package standard.mvc.component.business.baroboard.user.scrap.dao;

import java.util.List;

import standard.mvc.component.business.baroboard.user.scrap.vo.UserScrap;

/**
 * Modification Information
 * 
 * @author 오권우
 * @since 2015. 6. 03.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserRegisterDao.java
 * Description : 바로보드-사용자 정보 DAO 인터페이스
 * Information : 바로보드-사용자 정보 DAO 인터페이스
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

public interface UserScrapDao {
	List<UserScrap> getUserScrapList(UserScrap userScrap) throws Exception;
	
	UserScrap getScrapDetailView(UserScrap userScrap) throws Exception;

	int getScrapListTotalCnt(UserScrap userScrap);
}


