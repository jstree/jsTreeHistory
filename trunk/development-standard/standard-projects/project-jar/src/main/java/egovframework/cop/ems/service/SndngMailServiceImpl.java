package egovframework.cop.ems.service;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.support.manager.security.login.vo.UserInfo;

@Service
public class SndngMailServiceImpl implements SndngMailService{
	
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public String sendEmail(UserInfo userInfo) throws EmailException {
        
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(userInfo.getEmail());
		smm.setSubject("이메일 인증");
		smm.setText("http://www.313.co.kr/egovframework/com/cop/ems/santMailConfirm.do/uuid=" +userInfo.getUuid());
		try {
			mailSender.send(smm);	
		} catch (Exception e){
			return "{ \"status\" : \"0\" }";
		}
		return "{ \"status\" : \"1\" }";
		
		
	}
}
