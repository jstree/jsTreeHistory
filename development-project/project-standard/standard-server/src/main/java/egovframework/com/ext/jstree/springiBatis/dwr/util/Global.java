package egovframework.com.ext.jstree.springiBatis.dwr.util;

import java.util.LinkedHashSet;
import java.util.Set;

import egovframework.com.ext.jstree.springiBatis.dwr.domain.User;
import egovframework.com.ext.jstree.springiBatis.dwr.service.Chat;

/**
 * 全局变量
 * 
 * @author Cweili
 * @version 2013-5-7 下午5:20:20
 * 
 */
public class Global {

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String USERNAME = "username";
	public static final Set<User> onlineSet = new LinkedHashSet<User>();
	public static Chat chat;
}
