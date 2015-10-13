package standard.mvc.component.business.baroboard.core.manage.setting.sms.service;

import standard.mvc.component.business.baroboard.core.manage.setting.sms.vo.SmsVO;

public interface SmsLinkService {

	public SmsVO getSmsSetting() throws Exception;
	
	public int alterSmsSetting(SmsVO sms) throws Exception;
}
