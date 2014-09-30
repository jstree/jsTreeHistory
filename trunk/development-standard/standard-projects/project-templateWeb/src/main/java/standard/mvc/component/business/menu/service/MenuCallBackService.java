package standard.mvc.component.business.menu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;
import egovframework.com.ext.jstree.springiBatis.core.annotation.ExecutionSwitching;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreCallBackService;
import egovframework.com.ext.jstree.springiBatis.core.service.ExecutionAfterService;
import egovframework.com.ext.jstree.springiBatis.core.service.ExecutionBeforeService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

@ExecutionSwitching(order = "executeBefore")
@Service(value = "MenuCallBackService")
public class MenuCallBackService implements CoreCallBackService,
		ExecutionBeforeService, ExecutionAfterService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public <T extends ComprehensiveTree> boolean excute(T comprehensiveTree) {
		logger.info("{} > {}", new Object[] { "MenuCallBackService", "excute" });
		
		if (comprehensiveTree instanceof MenuComprehensiveTree) {
			// 형변환을 해서. url 을 가져올수있다.
		}

		return true;
	}

	@Override
	public <T extends ComprehensiveTree> boolean executeBefore(T ComprehensiveTree) {
		// TODO Auto-generated method stub
		logger.info("{} > {}", new Object[] { "MenuCallBackService", "executeBefore" });
		return true;
	}

	@Override
	public <T extends ComprehensiveTree> boolean executeAfter(T ComprehensiveTree) {
		// TODO Auto-generated method stub
		logger.info("{} > {}", new Object[] { "MenuCallBackService", "executeAfter" });
		return true;
	}

}
