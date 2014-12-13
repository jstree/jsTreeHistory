package jkh.emailvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;


/**
 * Modification Information
 * 
 * @author 전경
 * @since 2014. 12. 13.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: EmailValidationUsingRegEX
 * 	Description : 이메일 검증 테스트를 위한 테스트케이스
 * 	Infomation	: 참고 페이지 - http://docs.oracle.com/javase/7/docs/api/ regex 항목
 *
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014. 12. 13.  전경훈           최초생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */ class EmailValidationUsingRegEX {

	@Test
	public void testEmailValidation(){
		String [] testEmails = {
				"kh@kh.com"
				, "a1.a2@a2.com"
				, "!A@s.com"
				, "f+a@c.om"
				, "313.co.kr@313.co.kr"
				, "@asdf.com"
				, "asdf@asdf.com.au"
		};
		
//		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		String emailPattern = "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+";
		Pattern p = java.util.regex.Pattern.compile(emailPattern);
        Matcher m;
        for(int i=0;i<testEmails.length;i++){
        	m = p.matcher(testEmails[i]);
        	System.out.println(testEmails[i] + " : " + m.matches());
        }
	}
}
