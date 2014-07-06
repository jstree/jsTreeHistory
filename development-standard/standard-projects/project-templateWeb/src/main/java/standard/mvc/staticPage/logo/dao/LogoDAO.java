package standard.mvc.staticPage.logo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import standard.mvc.staticPage.logo.vo.LogoVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository("LogoDAO")
public class LogoDAO extends EgovComAbstractDAO {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public LogoVO getLogo(LogoVO logoVO) {
		
		LogoVO resultVO = new LogoVO();
		
		if( "DEFAULT".equals(logoVO.getFileType()) ){
			logger.debug("DEFFAULT IMAGE");
			resultVO.setFileName("logo.png");
			resultVO.setFilePath("http://nas.313.co.kr:5002/Design/image/");
		}
		else{
			logger.debug(logoVO.getFileType() + " IMAGE");
			resultVO.setFileName("logo.png");
			resultVO.setFilePath("http://nas.313.co.kr:5002/Design/image/");
		}
		return resultVO;
	}
}