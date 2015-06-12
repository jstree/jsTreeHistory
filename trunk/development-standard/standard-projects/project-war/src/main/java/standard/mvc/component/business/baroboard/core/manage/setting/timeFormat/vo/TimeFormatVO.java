package standard.mvc.component.business.baroboard.core.manage.setting.timeFormat.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 5. 30.
 * @version 1.0
 * @see <pre>
 * Class Name  : TimeFormatVO.java
 * Description : 바로보드-코어-일반설정-시간포맷 VO
 * Infomation  : Have To Write Information
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
public class TimeFormatVO extends ComprehensiveTree {

	@Override
	public String getSqlMapSelector() {
		
		return "timeFormat";
	}
	
}
