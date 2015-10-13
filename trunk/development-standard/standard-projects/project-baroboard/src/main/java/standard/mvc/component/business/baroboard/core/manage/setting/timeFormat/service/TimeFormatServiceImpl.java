package standard.mvc.component.business.baroboard.core.manage.setting.timeFormat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import standard.mvc.component.business.baroboard.core.manage.setting.timeFormat.vo.TimeFormatVO;

@Service
public class TimeFormatServiceImpl implements TimeFormatService {

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Override
	public List<TimeFormatVO> getTimeFormats() throws Exception {
		TimeFormatVO timeFormat = new TimeFormatVO();
		timeFormat.setC_id(2);
		
		return coreService.getChildNode(timeFormat);
	}

}
