package standard.mvc.component.business.baroboard.core.manage.setting.basicSetting.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import standard.mvc.component.business.baroboard.core.manage.setting.basicSetting.vo.BasicSettingVO;

@Service
public class BasicSettingServiceImpl implements BasicSettingService {

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Override
	public BasicSettingVO getBasicSetting() throws Exception {
		
		BasicSettingVO basicSetting = new BasicSettingVO();
		basicSetting.setC_id(3);
		
		return coreService.getNode(basicSetting);
	}

	@Override
	public int alterBasicSetting(BasicSettingVO basicSetting) throws Exception {
		
		return coreService.alterNode(basicSetting);
	}
	
	

}
