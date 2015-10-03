package standard.mvc.component.business.baroboard.user.note.service;

import java.util.List;
import java.util.Map;

import standard.mvc.component.business.baroboard.user.note.vo.UserNoteAttachFile;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteByUser;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteDetail;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteTypeCode;
import standard.mvc.component.business.baroboard.user.vo.User;



/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 5. 16.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserNoteService.java
 * Description : 바로보드-쪽지 Service 인터페이스
 * Information : 바로보드-쪽지 Service 인터페이스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015.5.16.    김대근            최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface UserNoteService {
	/**
     * 쪽지 발송
     * 
     * @return 
     * @throws Exception
     */
	public void sendNote(UserNoteDetail userNoteDetail) throws Exception;
	
	/**
	 * 수신쪽지 보관함 설정
	 * @param userNoteByUser
	 * @throws Exception
	 */
	public void setUserNoteCustody(UserNoteByUser userNoteByUser) throws Exception;
	
	/**
	 * 쪽지 유형코드 리스트 조회
	 * @throws Exception
	 */
	public List<UserNoteTypeCode> inquiryNoteTypeCodeList() throws Exception;
	
	/**
     * 쪽지 상세 조회
     * 
     * @return 
     * @throws Exception
     */
	public UserNoteByUser inquiryNoteDetail(UserNoteByUser userNoteByUser) throws Exception;
	
	/**
     * 쪽지 리스트 조회
     * 
     * @return 
     * @throws Exception
     */
	public List<UserNoteByUser> inquiryNoteList(UserNoteByUser userNoteByUser) throws Exception;
	
	/**
	 * 쪽지 파일 정보 조회
	 * @param userNoteByUser
	 * @throws Exception
	 */
	public UserNoteAttachFile inquiryNoteFileInf(UserNoteAttachFile userNoteAttachFile) throws Exception;
	
	/**
     * 쪽지 일괄 삭제
     * 
     * @return 
     * @throws Exception
     */
	public void deleteNoteList(List<UserNoteByUser> userNoteByUserList) throws Exception;
	
	/**
     * 쪽지 삭제
     * 
     * @return 
     * @throws Exception
     */
	public void deleteNote(UserNoteByUser userNoteByUser) throws Exception;
	
	/**
	 * 페이징 처리를 위한 회원별 쪽지 총 수를 구한다.
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	int getCountOfUser(Map<String, Object> paramMap) throws Exception;
	
	/**
     * 페이징 처리된, 검색 조건에 부합하는 회원 목록을 조회한다.
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    List<UserNoteByUser> getUserListPaginated(Map<String, Object> paramMap) throws Exception;
}