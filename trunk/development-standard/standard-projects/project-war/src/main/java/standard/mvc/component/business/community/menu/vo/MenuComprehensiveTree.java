package standard.mvc.component.business.community.menu.vo;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 이동민
 * @since 2014. 7. 05.
 * @version 1.0
 * @see <pre>
 *  Class Name  : MenuComprehensiveTree.java
 *  Description : 메뉴 jstree에서 사용되는 VO 
 *  Information : 메뉴 jstree에서 사용되는 VO
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.  7. 05. 이동민                 최초 생성
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@JsonInclude(Include.NON_EMPTY)
public class MenuComprehensiveTree extends ComprehensiveTree{

	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public HashMap<String, String> getAttr() {
		HashMap<String, String> temp = super.getAttr();
		temp.put("href"    , getUrl());
		temp.put("left"    , String.valueOf(super.getC_left()));
		temp.put("right"   , String.valueOf(super.getC_right()));
		temp.put("position", String.valueOf(super.getC_position()));
		
		return temp;
	}
	
	@Override
	public String getSqlMapSelector(){
		return "menu";
	}
}
