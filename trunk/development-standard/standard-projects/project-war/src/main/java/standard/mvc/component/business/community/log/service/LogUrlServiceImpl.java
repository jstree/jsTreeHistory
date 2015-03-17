package standard.mvc.component.business.community.log.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.community.log.dao.LogUrlDao;

/**
 * Modification Information
 * 
 * @author GwonWoo.Oh
 * @since 2015.02.14
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: LogUrlServiceImpl.java
 * 	Description : 313 Log 가져오는  Service Interface를 구현
 *  Infomation  : 313 Log 가져오는  Service Interface를 구현
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                수정내용
 *  -------       ------------   -----------------------------------
 *  2015.2.14.            오권우        최초 생성 - 로고 조회 Service Interface 구현
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Service(value="logUrlService")
public class LogUrlServiceImpl implements LogUrlSerivce {
	
	@Resource
	private LogUrlDao LogUrlDao;
	
	@Override
	public String getLogUrl() {
		return LogUrlDao.getLogUrl();
	}

}
