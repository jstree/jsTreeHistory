package standard.mvc.component.business.baroboard.user.join.register.service;

import standard.mvc.component.business.baroboard.user.vo.User;


/**
 * Modification Information
 * 
 * @author 오권우
 * @since 2015. 5. 30.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserRegisterService.java
 * Description : 바로보드-회원관리-회원가입  Service 인터페이스
 * Information : 바로보드-회원관리-회원가입  Service 인터페이스
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
public interface UserRegisterService {
	/**
     * 사용자 등록
     * 
     * @param userRegisterInfo 사용자 입력 가입 정보
     * @return userRegisterComplateFlag
     */
	public User userRegister(User user) throws Exception;
	
	/**
     * 회원 정보 가져오기
     * 
     * @param email 
     * @return UserRegisterInfo
     */
	public User getUserInfo(String nickName) throws Exception;
	
	/**
     * 닉네임 중복 체크
     * 
     * @param title 
     * @return nickUseVerificationFlag
     */
	public int nickNameUseVerification(String title) throws Exception;
	
	/**
     * 휴대폰 인증
     * 
     * @param title 
     * @return mobilePhonVerificationFlag
     */
	public int mobilePhoneVerification(String mobilePhone) throws Exception;
	
	/**
     * 패스워드 암호화
     * 
     * @param password 
     * @return EncPassword
     */
	public String encPassword(String password) throws Exception;
	
	/**
     * 이메일 찾기- 휴대폰 인증을 통한 패스워드 찾기
     * 
     * @param password 
     * @return EncPassword
     */
	public String emailSearch(String mobilePhoneNumber) throws Exception;
	
	/**
     * 비밀번호 찾기- 휴대폰 인증을 통한 비밀번호 찾기
     * 
     * @param password 
     * @return EncPassword
     */
	public String passwordSearch(String mobilePhoneNumber) throws Exception;
	

}
