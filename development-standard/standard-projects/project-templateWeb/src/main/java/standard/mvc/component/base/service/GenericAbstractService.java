package standard.mvc.component.base.service;

import java.text.DateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.base.exception.GenericServiceRuntimeException;
import standard.mvc.component.util.CrytoAsymmeticUtil;
import standard.mvc.component.util.CrytoSymmeticUtil;
import standard.mvc.component.util.DateUtils;

public abstract class GenericAbstractService<T, P> {

	@Autowired
	private CrytoSymmeticUtil crytoSymmeticUtil;
	@Autowired
	private CrytoAsymmeticUtil crytoAsymmeticUtil;
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	protected String encodeBothWay(String plain) throws GenericServiceRuntimeException {
//		TODO Override
		try {
			return crytoSymmeticUtil.encodeAes128(plain);
		} catch (Exception e) {
			String msg = "encryption failed (AES128)";
			logger.debug(msg);
			throw new GenericServiceRuntimeException(msg, e);
		}
	}

	protected String decodeBothWay(String encrypt) throws GenericServiceRuntimeException {
//		TODO Override
		try {
			return crytoSymmeticUtil.decodeAes128(encrypt);
		} catch (Exception e) {
			String msg = "decryption failed (AES128)";
			logger.debug(msg);
			throw new GenericServiceRuntimeException(msg, e);
		}
	}
	
	protected String encodeOneWay(String plain) throws GenericServiceRuntimeException {
//		TODO Override		
		return crytoAsymmeticUtil.encodeSha1(plain);
	}
	
	protected String getDateFormat(String pattern, Date date) {
		DateFormat df = DateUtils.getDateFormat(pattern);
		return df.format(date);
	}
	
	protected abstract T getExternalUriResource(P properties) throws GenericServiceRuntimeException;

}