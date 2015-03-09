package standard.mvc.component.business.community.log.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.community.log.dao.LogUrlDao;
/**
 * Modification Information
 * 
 * @author JongRyul.Lee
 * @since 2014.11.15
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: CommunityController.java
 * 	Description : Community 메뉴 가져오는 Service Class
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.11.15    이종렬           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
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
