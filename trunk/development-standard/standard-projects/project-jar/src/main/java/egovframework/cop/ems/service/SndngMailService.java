package egovframework.cop.ems.service;

import org.apache.commons.mail.EmailException;

import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;

public interface SndngMailService {
	String sendEmail(UserInfo userInfo) throws EmailException;
}
