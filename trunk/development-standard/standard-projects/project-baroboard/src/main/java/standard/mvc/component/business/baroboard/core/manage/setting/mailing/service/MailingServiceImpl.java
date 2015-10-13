package standard.mvc.component.business.baroboard.core.manage.setting.mailing.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.core.manage.setting.mailing.vo.MailingVO;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 6. 13.
 * @version 1.0
 * @see <pre>
 * Class Name  : MailingServiceImpl.java
 * Description : 바로보드-일반설정-메일링설정 Servie 클래스
 * Information : Have To Write Information
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
@Service
public class MailingServiceImpl implements MailingService {

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Override
	public List<MailingVO> getMailingList(MailingVO mailingParam) throws Exception {
		return coreService.getChildNode(mailingParam);
	}

	@Override
	public MailingVO getMailing(MailingVO paramVO) throws Exception {
		return coreService.getNode(paramVO);
	}

	@Override
	public int alterMailing(MailingVO mailingParam) throws Exception {
		return coreService.alterNode(mailingParam);
	}

	@Override
	public int deleteMailing(MailingVO mailingParam) throws Exception {
		return coreService.removeNode(mailingParam);
	}

	@Override
	public MailingVO addMailing(MailingVO newMailing) throws Exception {
		return coreService.addNode(newMailing);
	}
	
}
