package standard.mvc.component.business.baroboard.core.manage.menu.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * 
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 7. 5.
 * @version 1.0
 * @see <pre>
 * Class Name  : CoreMenuVO.java
 * Description : 바로보드-코어-메뉴 VO
 * Infomation  :
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 7. 5.          손호성                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class CoreMenuVO extends ComprehensiveTree {

	@Override
	public String getSqlMapSelector() {
		return "coreMenu";
	}

}
