package standard.mvc.component.business.baroboard.core.manage.setting.localTime.service;

import java.util.List;

import standard.mvc.component.business.baroboard.core.manage.setting.localTime.vo.LocalTimeVO;

public interface LocalTimeService {

	public List<LocalTimeVO> getLocalTimes() throws Exception;
	
}
