package egovframework.com.ext.jstree.strutsiBatis.service;

/**
 * 
 * Util_TitleChecker 
 * 
 * 데이터에 포함된 특수문자 제거하는 class
 * 
 * */
public class Util_TitleChecker {
	
	/**
	 *  StringReplace 
	 * 
	 * 데이터에 포함된 특수문자 제거
	 * 
	 * @param String
	 * @return String
	 * */
	public static String StringReplace(String str) {
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		str = str.replaceAll(match, " ");
		return str;
	}

}
