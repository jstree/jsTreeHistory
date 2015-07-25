package standard.mvc.component.business.baroboard.user.scrap.service;

import java.util.List;

import standard.mvc.component.business.baroboard.user.scrap.vo.UserScrap;



/**
 * Modification Information
 * 
 * @author 오권우
 * @since 2015. 5. 30.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserRegisterService.java
 * Description : 바로보드-회원관리-회원가입  Service 인터페이스
 * Infomation  : 바로보드-회원관리-회원가입  Service 인터페이스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일           수정자             수정내용
 * ------------  ------------  -----------------------
 * 2015. 5. 30.     오권우             최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface UserScrapService {
	/**
     * 스크랩 리스트 출력
     * 
     * @param UserScrap 사용자 ID
     * @return UserScrap List
     */
	public List<UserScrap> scrapList(UserScrap userScrap) throws Exception;
	
	/**
     * 스크랩 삭제
     * 
     * @param UserScrap postingId 
     */
	public void scrapDelete(UserScrap userScrap) throws Exception;
	
	/**
     * 스크랩 리스트 카운트
     * 
     * @param UserScrap userId 
     * @return int
     */
	public int getScrapListTotalCnt(UserScrap userScrap) throws Exception;
	
	/**
     * 스크랩 삭제할 ID 가져오기
     * 
     * @param String postingId 
     * @return UserScrap
     */
	public UserScrap getDeleteScrapId(int postingId) throws Exception;
}
