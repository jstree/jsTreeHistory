package standard.mvc.component.business.community.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import standard.mvc.component.base.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @author Hoseong.Son
 * @since 2014.11.15
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: NeroCommunityController.java
 * 	Description : Nero 디자인 기준 SiteMesh 를 사용한 페이지 호출 컨트롤러 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.11.15    손호성           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
public class NeroCommunityController extends GenericAbstractController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping("/sitemesh/{page}.do")
	public String execute(@PathVariable("page") String page) throws Exception {
		logger.info("@PathVariable page is {}", new Object[] { page });
		return "/jsp/sitemesh/" + page;
	}

}
