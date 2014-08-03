package standard.mvc.component.base.service;

import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.base.exception.GenericServiceRuntimeException;
import standard.mvc.component.util.CrytoAsymmeticUtil;
import standard.mvc.component.util.CrytoSymmeticUtil;
import standard.mvc.component.util.DateUtils;

public abstract class GenericAbstractService<T> {

	@Autowired
	private CrytoSymmeticUtil crytoSymmeticUtil;
	@Autowired
	private CrytoAsymmeticUtil crytoAsymmeticUtil;
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public String encrypt(String plain) throws GenericServiceRuntimeException {
		try {
			return crytoSymmeticUtil.encodeAes128(plain);
		} catch (Exception e) {
			String msg = "encryption failed (AES128)";
			logger.debug(msg);
			throw new GenericServiceRuntimeException(msg, e);
		}
	}

	public String decrypt(String encrypt) throws GenericServiceRuntimeException {
		try {
			return crytoSymmeticUtil.decodeAes128(encrypt);
		} catch (Exception e) {
			String msg = "decryption failed (AES128)";
			logger.debug(msg);
			throw new GenericServiceRuntimeException(msg, e);
		}
	}
	
	public String encode(String plain) throws GenericServiceRuntimeException {
		return crytoAsymmeticUtil.encodeSha1(plain);
	}
	
	public String getDateFormat(String pattern, Date date) {
		DateFormat df = DateUtils.getDateFormat(pattern);
		return df.format(date);
	}
	
	public abstract T externalResourceGet();

}
