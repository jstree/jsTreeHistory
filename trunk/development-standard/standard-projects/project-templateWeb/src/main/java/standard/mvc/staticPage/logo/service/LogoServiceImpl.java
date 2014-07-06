package standard.mvc.staticPage.logo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.staticPage.logo.dao.LogoDAO;
import standard.mvc.staticPage.logo.vo.LogoVO;

@Service("LogoService")
public class LogoServiceImpl implements LogoService {

	@Resource(name="LogoDAO")
	LogoDAO logoDAO;
	
	@Override
	public LogoVO getLogo(LogoVO logoVO) {
		// TODO Auto-generated method stub
		return logoDAO.getLogo(logoVO);
	}
}