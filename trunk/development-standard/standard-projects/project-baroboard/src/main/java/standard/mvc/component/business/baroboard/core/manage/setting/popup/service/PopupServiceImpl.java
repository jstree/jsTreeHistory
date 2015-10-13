package standard.mvc.component.business.baroboard.core.manage.setting.popup.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.core.manage.setting.popup.vo.PopupVO;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 6. 21.
 * @version 1.0
 * @see <pre>
 * Class Name  : PopupServiceImpl.java
 * Description : 바로보드 - 일반설정 - 팝업설정 Service
 * Information  : Have To Write Information
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 6. 21.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service
public class PopupServiceImpl implements PopupService {

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Override
	public PopupVO getPopup(PopupVO popupParam) throws Exception {
		return coreService.getNode(popupParam);
	}

	@Override
	public int alterPopup(PopupVO popup) throws Exception {
		return coreService.alterNode(popup);
	}

	@Override
	public List<PopupVO> getPopupList(PopupVO popupParam) throws Exception {
		if(null == popupParam || 0 == popupParam.getC_id()){
			popupParam = new PopupVO();
			popupParam.setC_id(2);
		}
		return coreService.getChildNode(popupParam);
	}

	@Override
	public PopupVO addPopup(PopupVO popup) throws Exception {
		popup.setRef(2);
		popup.setWritngDe(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		return coreService.addNode(popup);
	}

	@Override
	public int removePopups(List<PopupVO> removePopups) throws Exception {
		int removeCount = 0;
		for (PopupVO popupVO : removePopups) {
			coreService.removeNode(popupVO);
		}
		return removeCount;
	}
}
