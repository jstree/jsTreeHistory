package standard.mvc.component.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

/**
 *  Class Name : CrytoSymmeticUtil.java
 *  Description :  대칭 암호화 관련된 부분을 해당 클래스에서 사용 한다. : AES, ARIA, SEED, MASK(http://jo.centis1504.net/?p=137)
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
public class CrytoSymmeticUtil{
	private static String aesKey = "바로보드 aes key1";//aes 사용될 key  

	private Cipher cipher;
	SecretKeySpec aesSpec;
	
	public CrytoSymmeticUtil() {
		if(aesKey.length()%16!=0){
			aesKey = StringUtils.rightPad(aesKey, 16*(aesKey.length()/16+1), "\0");
		}

		aesSpec=new SecretKeySpec(aesKey.getBytes(), "AES");
	}

	//aes128 결과 값을 base64로 한번더 인코딩
	public String encodeAes128(String encTarget) throws Exception{
		if(StringUtils.isEmpty(encTarget)){return "";}
		
	    cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.ENCRYPT_MODE, aesSpec);
		return new String(Base64.encode(cipher.doFinal(encTarget.getBytes())));
	}
	
	//aes128 결과 값을 base64로 한번더 디코딩	
	public String decodeAes128(String decTarget) throws Exception{
		if(StringUtils.isEmpty(decTarget)){return "";}
		
	    cipher.init(Cipher.DECRYPT_MODE, aesSpec);
		return new String(cipher.doFinal(Base64.decode(decTarget.getBytes())));
	}
	
	
	public static void main(String[] args) throws Exception {

		CrytoSymmeticUtil symmeticCrytoUtil = new CrytoSymmeticUtil();
		System.out.println(symmeticCrytoUtil.encodeAes128("test"));
		System.out.println(symmeticCrytoUtil.decodeAes128(symmeticCrytoUtil.encodeAes128("test")));

	}
	
}
