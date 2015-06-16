package standard.mvc.component.business.baroboard.user.manage.point.setting.service;

import standard.mvc.component.business.baroboard.user.manage.point.setting.vo.UserPointSetting;

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
public interface UserPointSettingService {
	public UserPointSetting inquiryUserPointSettingInf() throws Exception;
	public void saveUserPointSettingInf(UserPointSetting userPointSetting) throws Exception;
}
