package egovframework.com.ext.jstree.springiBatis.core.util;

public class Util_TitleChecker {

	public static String StringReplace(String str) {
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		str = str.replaceAll(match, " ");
		return str;
	}
}