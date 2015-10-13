package standard.mvc.component.business.baroboard.core.manage.setting.localTime.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import standard.mvc.component.business.baroboard.core.manage.setting.localTime.vo.LocalTimeVO;

@Service
public class LocalTimeServiceImpl implements LocalTimeService {

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Override
	public List<LocalTimeVO> getLocalTimes() throws Exception {
		LocalTimeVO localTimeVO = new LocalTimeVO();
		localTimeVO.setC_id(2);
		
		return coreService.getChildNode(localTimeVO);
	}

	
}
