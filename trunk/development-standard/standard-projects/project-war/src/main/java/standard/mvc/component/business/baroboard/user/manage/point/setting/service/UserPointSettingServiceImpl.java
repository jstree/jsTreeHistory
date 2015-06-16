package standard.mvc.component.business.baroboard.user.manage.point.setting.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

import standard.mvc.component.business.baroboard.user.manage.point.setting.vo.UserPointSetting;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserGradeService.java
 * Description : 바로보드-회원등급관리 Service 구현 클래스
 * Infomation  : 바로보드-회원등급관리 Service 구현 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015.5.25.    김대근            최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service
public class UserPointSettingServiceImpl implements UserPointSettingService{

	@Resource(name = "CoreService")
    private CoreService coreService;
	
	@Override
	public UserPointSetting inquiryUserPointSettingInf() throws Exception {
		UserPointSetting userPointSetting = new UserPointSetting();
		userPointSetting.setC_id(3);
		
		return coreService.getNode(userPointSetting);
	}

	@Override
	public void saveUserPointSettingInf(UserPointSetting userPointSetting) throws Exception {
		UserPointSetting orgUserPointSetting = this.inquiryUserPointSettingInf();
		if(orgUserPointSetting == null || orgUserPointSetting.getC_id() == 0){
			userPointSetting.setRef(2);
			userPointSetting.setC_type("default");
			userPointSetting.setC_type("회원_포인트설정");
			coreService.addNode(userPointSetting);
		}else{
			userPointSetting.setC_id(3);
			coreService.alterNode(userPointSetting);
		}
	}
}
