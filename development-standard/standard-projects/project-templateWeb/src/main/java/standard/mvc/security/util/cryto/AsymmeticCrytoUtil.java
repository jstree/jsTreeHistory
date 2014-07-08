package standard.mvc.security.util.cryto;

import java.security.MessageDigest;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * 비대칭 암호화(공개키 암호화) 관련된 부분을 해당 클래스에서 사용 한다. : sha, bcryt, RSA
 * @author choedaeyeol
 * 
 */
@Component
public class AsymmeticCrytoUtil{
	private PasswordEncoder passwordEncoder;	//로그인 시 사용되는 password  암호화(Bcryto, SHA) 
	private static final String SHA_1 = "SHA-1";
	
	public AsymmeticCrytoUtil(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public AsymmeticCrytoUtil() {
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
		AsymmeticCrytoUtil asymmeticCrytoUtil = new AsymmeticCrytoUtil();
		System.out.println(asymmeticCrytoUtil.encodePassword("1111"));//$2a$10$HT/3DoS1u4LVfKUMVJdtC.J5mMn2ItG7eq35ITL2jyXUxPQw2WUX6
		System.out.println(asymmeticCrytoUtil.encodeSha1("1111"));//ARyUXzDOLLr8RS85hA8CVpMznEI=

		
	}
}
