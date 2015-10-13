package standard.mvc.component.business.baroboard.core.manage.setting.basicSetting.service;

import standard.mvc.component.business.baroboard.core.manage.setting.basicSetting.vo.BasicSettingVO;

public interface BasicSettingService {

	public BasicSettingVO getBasicSetting() throws Exception;

	public int alterBasicSetting(BasicSettingVO basicSetting) throws Exception;

}
