package standard.mvc.component.util;

import java.security.MessageDigest;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 *  Class Name : CrytoAsymmeticUtil.java
 *  Description :  비대칭 암호화(공개키 암호화) 관련된 부분을 해당 클래스에서 사용 한다. : sha, bcryt, RSA
 *  Modification Information
 * 
 *  @author 최대열
 *  @since 2014.07.10
 *  @version 1.0
 *  @see
 *
 *  <pre>
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.10                 최대열		   최초 생성
 *
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Component
public class CrytoAsymmeticUtil{
	private PasswordEncoder passwordEncoder;	//로그인 시 사용되는 password  암호화(Bcryto, SHA) 
	private static final String SHA_1 = "SHA-1";
	
	public CrytoAsymmeticUtil(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public CrytoAsymmeticUtil() {
		this(new BCryptPasswordEncoder());
	}
	
	
	//bcrypt는 입력 값으로 72 bytes character를 사용해야 하는 제약조건이 있다.
	public String encodePassword(String encTarget){
		if(StringUtils.isEmpty(encTarget)){return "";}

		return passwordEncoder.encode(encTarget);	
	}
	
	//sha1 방식 암호화를 base64인코딩 하여 결과값 추출
	public String encodeSha1(String encTarget) {
		if(StringUtils.isEmpty(encTarget)){return "";}

		try {
			MessageDigest digest = MessageDigest.getInstance(SHA_1);
			digest.update(encTarget.getBytes());
			return new String(Base64.encode(digest.digest()));
		} catch (Exception e) {
			return "";
		}
		
	}
	
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}


	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	//test
	public static void  main(String[] arg){
		CrytoAsymmeticUtil asymmeticCrytoUtil = new CrytoAsymmeticUtil();
		System.out.println(asymmeticCrytoUtil.encodePassword("1111"));//$2a$10$HT/3DoS1u4LVfKUMVJdtC.J5mMn2ItG7eq35ITL2jyXUxPQw2WUX6
		System.out.println(asymmeticCrytoUtil.encodeSha1("1111"));//ARyUXzDOLLr8RS85hA8CVpMznEI=

		
	}
}
