package standard.mvc.component.business.baroboard.core.manage.setting.thumCreateMethod.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.core.manage.setting.thumCreateMethod.vo.ThumCreateMethodVO;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

@Service
public class ThumCreateMethodServiceImpl implements ThumCreateMethodService {

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Override
	public List<ThumCreateMethodVO> getThumCreateMethods() throws Exception {
		ThumCreateMethodVO vo = new ThumCreateMethodVO();
		vo.setC_id(2);		
		
		return coreService.getChildNode(vo);
	}

}
