package standard.mvc.component.business.baroboard.user.manage.point.setting.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.user.manage.point.setting.service.UserPointSettingService;
import standard.mvc.component.business.baroboard.user.manage.point.setting.vo.UserPointSetting;

import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 6. 13.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserGradeManageController.java
 * Description : 회원포인트설정관리 Controller
 * Infomation  : 회원포인트설정관리 Controller
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 6. 13.      김대근       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping("/user/manage/point/setting")
public class UserPointSettingController extends GenericAbstractController {

    @Autowired
    private UserPointSettingService userPointSettingService;
	
    @RequestMapping("/index.do")
    public String main(ModelMap model) throws Exception {
    	UserPointSetting userPointSetting = userPointSettingService.inquiryUserPointSettingInf();
    	model.addAttribute("userPointSetting", userPointSetting);
    	
        return "/jsp/user/manage/point/setting/index";
    }
    
    @RequestMapping(value="/saveUserPointSettingInf.do", method=RequestMethod.POST)
    @ResponseBody
    public String saveUserPointSettingInf(UserPointSetting userPointSetting, ModelMap model, HttpServletRequest request) throws Exception {
    	userPointSettingService.saveUserPointSettingInf(userPointSetting);
    	
        return "{}";
    }
    
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}
}