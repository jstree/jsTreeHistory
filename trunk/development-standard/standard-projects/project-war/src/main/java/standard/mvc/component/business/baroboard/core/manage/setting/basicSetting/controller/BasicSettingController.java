package standard.mvc.component.business.baroboard.core.manage.setting.basicSetting.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.core.manage.setting.basicLanguage.service.BasicLanguageService;
import standard.mvc.component.business.baroboard.core.manage.setting.basicSetting.service.BasicSettingService;
import standard.mvc.component.business.baroboard.core.manage.setting.basicSetting.vo.BasicSettingVO;
import standard.mvc.component.business.baroboard.core.manage.setting.layout.service.LayoutService;
import standard.mvc.component.business.baroboard.core.manage.setting.localTime.service.LocalTimeService;
import standard.mvc.component.business.baroboard.core.manage.setting.thumCreateMethod.service.ThumCreateMethodService;
import standard.mvc.component.business.baroboard.core.manage.setting.timeFormat.service.TimeFormatService;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 5. 29.
 * @version 1.0
 * @see <pre>
 * Class Name  : BasicSettingController.java
 * Description : 바로보드-코어-일반설정-기본 Controller
 * Infomation  : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 5. 29.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = "/core/manage/setting/basicSetting")
public class BasicSettingController extends GenericAbstractController {

	@Autowired
	private BasicSettingService basicSettingService;

	@Autowired
	private BasicLanguageService basicLanguageService;
	
	@Autowired
	private LocalTimeService localTimeService;
	
	@Autowired
	private TimeFormatService timeFormatService;
	
	@Autowired
	private ThumCreateMethodService thumCreateMethodService;
	
	@Autowired
	private LayoutService layoutService;
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value = "/index.do")
	public String movepage(ModelMap model) throws Exception {
		
		BasicSettingVO basicSetting = basicSettingService.getBasicSetting();
		
		model.addAttribute("basicSetting", basicSetting);
		
		model.addAttribute("basicLanguageList", basicLanguageService.getBasicLanguages());
		
		model.addAttribute("localTimeList",localTimeService.getLocalTimes());
		
		model.addAttribute("timeFormatList", timeFormatService.getTimeFormats());
	
		model.addAttribute("thumCreateMethodList", thumCreateMethodService.getThumCreateMethods());
	
		model.addAttribute("layoutList",layoutService.getLayouts());
		
		return "/jsp/baroboard/core/manage/setting/basicSetting/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/save.do", method = {RequestMethod.POST})
	public BasicSettingVO alterBasicSetting(BasicSettingVO basicSetting,
            BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors()) {
            throw new RuntimeException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
		basicSetting.setStatus(basicSettingService.alterBasicSetting(basicSetting));
		
		return basicSetting;
	}

}
