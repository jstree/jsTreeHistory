package standard.mvc.component.util;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class EncryptionControllerTest {

	@Test
	public void test() throws Exception {
		EncryptionController ec = new EncryptionController();
		ec.sha256("today226");
		String encodingValue = ec.encryptText("/common/EncryptionSample.do");
		String decodingValue = ec.decryptText(encodingValue);
	}
}
