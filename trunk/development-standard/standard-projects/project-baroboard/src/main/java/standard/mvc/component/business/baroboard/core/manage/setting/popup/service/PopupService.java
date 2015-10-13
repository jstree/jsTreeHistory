package standard.mvc.component.business.baroboard.core.manage.setting.popup.service;

import java.util.List;

import standard.mvc.component.business.baroboard.core.manage.setting.popup.vo.PopupVO;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 6. 18.
 * @version 1.0
 * @see <pre>
 * Class Name  : PopupService.java
 * Description : 바로보드 - 일반설정 - 팝업설정 서비스 Interface
 * Information : Have To Write Information
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 6. 18.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface PopupService {

	/**
	 * 팝업정보를 조회한다.
	 * @param popupParam
	 * @return
	 * @throws Exception 
	 */
	PopupVO getPopup(PopupVO popupParam) throws Exception;

	/**
	 * 팝업정보를 수정한다.
	 * @param popup
	 * @return
	 * @throws Exception
	 */
	int alterPopup(PopupVO popup) throws Exception;
	
	/**
	 * 팝업리스트를 조회한다.
	 * @param popupParam
	 * @return
	 * @throws Exception
	 */
	List<PopupVO> getPopupList(PopupVO popupParam) throws Exception;

	
	/**
	 * 팝업정보를 추가한다.
	 * @param popup
	 * @return
	 */
	PopupVO addPopup(PopupVO popup) throws Exception;

	/**
	 * 팝업정보를 삭제한다.
	 * @param removePopups
	 * @return
	 * @throws Exception
	 */
	int removePopups(List<PopupVO> removePopups) throws Exception;

}
