package standard.mvc.component.business.baroboard.core.manage.setting.layout.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import standard.mvc.component.business.baroboard.core.manage.setting.layout.vo.LayoutVO;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 5. 30.
 * @version 1.0
 * @see <pre>
 * Class Name  : LayoutServiceImpl.java
 * Description : 바로보드-코어-일반-기본설정에서 사용되는 레이아웃 Service 구현
 * Information :  
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 5. 30.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service
public class LayoutServiceImpl implements LayoutService {

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Override
	public List<LayoutVO> getLayouts() throws Exception {
		LayoutVO vo = new LayoutVO();
		vo.setC_id(2);
		
		return coreService.getChildNode(vo);
	}

}
