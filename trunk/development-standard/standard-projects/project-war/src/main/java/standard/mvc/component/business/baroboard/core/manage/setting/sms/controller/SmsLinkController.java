package standard.mvc.component.business.baroboard.core.manage.setting.sms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.core.manage.setting.sms.service.SmsLinkService;
import standard.mvc.component.business.baroboard.core.manage.setting.sms.vo.SmsVO;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 5. 31.
 * @version 1.0
 * @see <pre>
 * Class Name  : SmsLinkController.java
 * Description : 바로보드-코어-일반설정-SMS Controller
 * Infomation  : Have To Write Information
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 5. 31.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = "/core/manage/setting/sms")
public class SmsLinkController extends GenericAbstractController {

	@Autowired
	private SmsLinkService smsLinkService;
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value = "/index.do")
	public String movePage(ModelMap model) throws Exception {
		
		model.addAttribute("sms", smsLinkService.getSmsSetting());
		
		return "/jsp/baroboard/core/manage/setting/sms/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/save.do", method = {RequestMethod.POST})
	public SmsVO alterSmsSetting(SmsVO sms,
            BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors()) {
            throw new RuntimeException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
		sms.setStatus(smsLinkService.alterSmsSetting(sms));
		
		return sms;
	}
}
