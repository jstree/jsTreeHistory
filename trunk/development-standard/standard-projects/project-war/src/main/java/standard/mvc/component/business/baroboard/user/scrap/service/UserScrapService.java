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
     * @param userRegisterInfo 사용자 입력 가입 정보
     * @return userRegisterComplateFlag
     */
	public List<UserScrap> scrapList(UserScrap userScrap) throws Exception;
	
	/**
     * 스크랩 상세 정보 가져오기
     * 
     * @param email 
     * @return UserRegisterInfo
     */
	public UserScrap getScrapDetailView(UserScrap userScrap) throws Exception;
	
	/**
     * 스크랩 삭제
     * 
     * @param title 
     * @return nickUseVerificationFlag
     */
	public void scrapDelete(UserScrap userScrap) throws Exception;
	
	public int getScrapListTotalCnt(UserScrap userScrap) throws Exception;
}