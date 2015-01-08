package standard.mvc.component.business.community.constraint.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author Hoseong.Son
 * @since 2014.12.21
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: ForeignComprehensiveTree.java
 * 	Description : 제약조건 예제 외래키 트리 VO
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.12.21    Hoseong.Son           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class ForeignComprehensiveTree extends ComprehensiveTree {

	@Override
	public String getSqlMapSelector() {
		// TODO Auto-generated method stub
		return "foreign";
	}

}
