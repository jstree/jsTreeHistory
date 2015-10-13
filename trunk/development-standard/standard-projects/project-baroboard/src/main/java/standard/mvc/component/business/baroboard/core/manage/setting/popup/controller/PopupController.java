package standard.mvc.component.business.baroboard.core.manage.setting.popup.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.core.manage.setting.popup.service.PopupService;
import standard.mvc.component.business.baroboard.core.manage.setting.popup.vo.PopupVO;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.let.utl.fcc.service.EgovDateUtil;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 6. 21.
 * @version 1.0
 * @see <pre>
 * Class Name  : PopupController.java
 * Description : 바로보드-일반설정-팝업설정 Controller
 * Information  : Have To Write Information
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 6. 21.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = "/core/manage/setting/popup")
public class PopupController extends GenericAbstractController {

	@Autowired
	private PopupService popupService;
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value = "/index.do")
	public String movePage(ModelMap model) throws Exception{
		model.addAttribute("popupList", popupService.getPopupList(null));
		return "/jsp/baroboard/core/manage/setting/popup/index";	
	}
	
	@RequestMapping(value = "/addPopupConfig.do")
	public String addPopupConfig(ModelMap model) throws Exception{
		return "/jsp/baroboard/core/manage/setting/popup/addPopupConfig";
	}
	
	@RequestMapping(value = "/savePopupConfig.do")
	public @ResponseBody PopupVO savePopupConfig(ModelMap model,PopupVO popup) throws Exception{
		
		popup.setExpiryDe(popup.getExpiryDe().replaceAll("-", "")); 
		popup = popupService.addPopup(popup);
		return popup;
	}

	@RequestMapping(value = "/modifyPopupConfig.do")
	public String modifyPopupConfig(ModelMap model,PopupVO popupParam) throws Exception{
		model.addAttribute("popup",popupService.getPopup(popupParam));
		
		return "/jsp/baroboard/core/manage/setting/popup/modifyPopupConfig";
	}
	
	@RequestMapping(value = "/alterPopupConfig.do")
	public @ResponseBody String alterPopupConfige(ModelMap model,@Valid PopupVO popup,BindingResult bindingResult) throws Exception{
		if (bindingResult.hasErrors()) {
            throw new RuntimeException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
		popupService.alterPopup(popup);
		return "{ \"status\" : \"1\" }";
	}

	@RequestMapping(value = "/delete.do")
	public String removePopup(@RequestBody List<PopupVO> popups) throws Exception {
		popupService.removePopups(popups);
		return "{ \"status\" : \"1\" }";
	}
}
