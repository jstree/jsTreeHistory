package standard.mvc.security.util.cryto;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

/**
 * 대칭 암호화 관련된 부분을 해당 클래스에서 사용 한다. : AES, ARIA, SEED, MASK
 * @author choedaeyeol
 *	http://jo.centis1504.net/?p=137
 */
@Component
public class SymmeticCrytoUtil{
	private static String aesKey = "바로보드 aes key1";//aes 사용될 key  

	private Cipher cipher;
	SecretKeySpec aesSpec;
	
	public SymmeticCrytoUtil() {
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

		SymmeticCrytoUtil symmeticCrytoUtil = new SymmeticCrytoUtil();
		System.out.println(symmeticCrytoUtil.encodeAes128("test"));
		System.out.println(symmeticCrytoUtil.decodeAes128(symmeticCrytoUtil.encodeAes128("test")));

	}
	
}
