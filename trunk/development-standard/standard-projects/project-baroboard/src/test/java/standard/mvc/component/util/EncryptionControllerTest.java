package standard.mvc.component.util;

import org.junit.Test;

import egovframework.com.ext.jstree.support.util.controller.EncryptionController;

public class EncryptionControllerTest {

	@Test
	public void test() throws Exception {
		EncryptionController ec = new EncryptionController();
		ec.sha256("today226");
//		String encodingValue = ec.encryptText("/common/EncryptionSample.do");
//		String decodingValue = ec.decryptText(encodingValue);
		
	}
}