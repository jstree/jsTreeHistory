package standard.mvc.component.business.menu.vo;

import java.util.HashMap;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

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
