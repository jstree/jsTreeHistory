package standard.mvc.component.business.baroboard.core.manage.setting.basicLanguage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.core.manage.setting.basicLanguage.vo.BasicLanguageVO;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 5. 30.
 * @version 1.0
 * @see <pre>
 * Class Name  : BasicLanguageServiceImpl.java
 * Description : 바로보드-코어-일반설정-기본언어 Service 구현
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
@Service
public class BasicLanguageServiceImpl implements BasicLanguageService {

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Override
	public List<BasicLanguageVO> getBasicLanguages() throws Exception {

		BasicLanguageVO basicLanguageVO = new BasicLanguageVO();
		basicLanguageVO.setC_id(2);
		
		return coreService.getChildNode(basicLanguageVO);
	}

}
