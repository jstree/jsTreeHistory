package standard.mvc.component.business.baroboard.core.manage.setting.layout.service;

import java.util.List;

import standard.mvc.component.business.baroboard.core.manage.setting.layout.vo.LayoutVO;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 5. 30.
 * @version 1.0
 * @see <pre>
 * Class Name  : LayoutService.java
 * Description : 바로보드-코어-일반-기본설정에서 사용되는 레이아웃 Service 
 * Infomation  : 
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
public interface LayoutService {
	
	public List<LayoutVO> getLayouts() throws Exception;
	
}
