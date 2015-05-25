package standard.mvc.component.business.baroboard.user.manage.grade.service;

import java.util.List;

import standard.mvc.component.business.baroboard.user.manage.grade.vo.UserGradeManage;
import standard.mvc.component.business.baroboard.user.manage.grade.vo.UserMenuByGrade;



/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserGradeService.java
 * Description : 바로보드-회원등급관리 Service 인터페이스
 * Infomation  : 바로보드-회원등급관리 Service 인터페이스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015.5.25.    김대근            최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface UserGradeService {
	
	/**
	 * 회원등급리스트 조회
	 * @return
	 * @throws Exception
	 */
	public List<UserGradeManage> inquiryUserGradeList() throws Exception;

	/**
	 * 회원등급상세정보 조회
	 * @return
	 * @throws Exception
	 */
	public UserGradeManage inquiryUserGradeDetailInf(UserGradeManage userGradeManage) throws Exception;

	/**
	 * 회원등급상세정보 저장
	 * @return
	 * @throws Exception
	 */
	public void saveUserGradeDetailInf(UserGradeManage userGradeManage) throws Exception;

	/**
	 * 회원등급별메뉴 리스트 조회
	 * @return
	 * @throws Exception
	 */
	public List<UserMenuByGrade> inquiryUserMenuByGradeList(UserGradeManage userGradeManage) throws Exception;
}
