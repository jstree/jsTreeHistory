package standard.mvc.component.business.menu.vo;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

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
		temp.put("href", getUrl());
		temp.put("test", "jkw");
		return temp;
	}
	
}
