package standard.mvc.component.business.baroboard.core.manage.setting.timeFormat.service;

import java.util.List;

import standard.mvc.component.business.baroboard.core.manage.setting.timeFormat.vo.TimeFormatVO;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 5. 30.
 * @version 1.0
 * @see <pre>
 * Class Name  : TimeFormatService.java
 * Description : 바로보드-코어-일반설정-시간포맷 Service
 * Information : Have To Write Information
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 5. 30.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface TimeFormatService {
	
	/**
	 * 시간포맷 목록 조회
	 * @return
	 * @throws Exception
	 */
	public List<TimeFormatVO> getTimeFormats() throws Exception;
}
