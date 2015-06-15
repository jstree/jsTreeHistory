package standard.mvc.component.business.baroboard.core.manage.setting.basicLanguage.service;

import java.util.List;

import standard.mvc.component.business.baroboard.core.manage.setting.basicLanguage.vo.BasicLanguageVO;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : BasicLanguageService.java
 * Description : 바로보드-코어-일반설정-기본언어 Service 인터페이스
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 5. 25.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface BasicLanguageService {
	
	/**
	 * 기본언어 목록 조회
	 * @return 
	 * @throws Exception
	 */
	public List<BasicLanguageVO> getBasicLanguages() throws Exception;
	
}
