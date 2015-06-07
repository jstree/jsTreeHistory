package standard.mvc.component.business.baroboard.user.join.agreement.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.contents.service.BasicContentsService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.contents.vo.BasicContents;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @ author 오권우
 * 
 * @since 2015. 6. 02.
 * @version 1.0
 * @see <pre>
 * Class Name  : ApprovalAndTermsController.java
 * Description : 회원가입- 이용 약관 및 개인정보처리 Controller 
 * Infomation  : 서비스 이용약관 및 개인정보처리방침등을 관리하는 컨트롤러
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 6. 02.      오권우        최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Controller
@RequestMapping(value = "/user/join/agreement")
public class ApprovalAndTermsController extends GenericAbstractController {

	//@Resource(name = "ApprovalAndTermsService")
	//private ApprovalAndTermsService approvalAndTermsService;

	@Autowired
    private BasicContentsService basicContentsService;
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/index.do")
	public String apprTermsPage(ModelMap modelMap) throws Exception{
		BasicContents bs = basicContentsService.getBasicContents();
		modelMap.addAttribute("basicContents", basicContentsService.getBasicContents());
        return "/jsp/user/join/agreement/index";
	}
	@RequestMapping(value = "/next.do")
	public String registerUserIndexPage(ModelMap modelMap) throws Exception{
        return "/jsp/user/join/register/index";
	}

	
}
