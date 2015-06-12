package standard.mvc.component.business.baroboard.core.manage.setting.sms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.core.manage.setting.sms.vo.SmsVO;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

@Service
public class SmsLinkServiceImpl implements SmsLinkService {

	@Resource(name ="CoreService")
	private CoreService coreService;
	
	@Override
	public SmsVO getSmsSetting() throws Exception {
		SmsVO vo = new SmsVO();
		vo.setC_id(3);
		
		return coreService.getNode(vo);
	}

	@Override
	public int alterSmsSetting(SmsVO sms) throws Exception {
		
		return coreService.alterNode(sms);
	}

	
}
