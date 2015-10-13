package standard.mvc.component.business.baroboard.core.manage.setting.mailing.service;

import java.util.List;

import standard.mvc.component.business.baroboard.core.manage.setting.mailing.vo.MailingVO;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 6. 13.
 * @version 1.0
 * @see <pre>
 * Class Name  : MailingService.java
 * Description : 바로보드-일반설정-메일링 Service Interface
 * Information :  
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 6. 13.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface MailingService {

	/**
	 * 메일링 목록을 조회한다.
	 * @param mailing
	 * @return
	 * @throws Exception
	 */
	List<MailingVO> getMailingList(MailingVO mailing) throws Exception;

	/**
	 * 메일링 정보를 가져온다 
	 * @param mailingParam
	 * @return
	 * @throws Exception 
	 */
	MailingVO getMailing(MailingVO mailingParam) throws Exception;

	/**
	 * 메일링 정보를 업데이트한다.
	 * @param mailingParam
	 * @return
	 * @throws Exception
	 */
	int alterMailing(MailingVO mailingParam) throws Exception;

	/**
	 * 메일링 단건을 삭제한다.
	 * @param paramVO
	 * @return
	 * @throws Exception
	 */
	int deleteMailing(MailingVO paramVO) throws Exception;

	/**
	 * 메일링 단건을 추가한다.
	 * @param paramVO
	 * @return
	 * @throws Exception
	 */
	MailingVO addMailing(MailingVO paramVO) throws Exception;
}
