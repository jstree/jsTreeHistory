package standard.mvc.component.business.baroboard.core.manage.setting.basicLanguage.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : BasicLanguageVO.java
 * Description : 바로보드 코어
 * Infomation  : Have To Write Information
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
public class BasicLanguageVO extends ComprehensiveTree {

	@Override
	public String getSqlMapSelector() {

		return "basicLanguage";
	}
	
	
}
