package standard.mvc.component.business.baroboard.user.manage.grade.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.user.manage.grade.vo.UserGradeManage;
import standard.mvc.component.business.baroboard.user.manage.grade.vo.UserMenuByGrade;


import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 5. 30.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserGradeServiceImpl.java
 * Description : 바로보드-쪽지 Service 구현 클래스
 * Information : 바로보드-쪽지 Service 구현 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015.5.30.    김대근            최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service
public class UserGradeServiceImpl implements UserGradeService{
	
	@Resource(name = "CoreService")
    private CoreService coreService;

	@Override
	public List<UserGradeManage> inquiryUserGradeList(UserGradeManage userGradeManage) throws Exception {
		if(null == userGradeManage || 0 == userGradeManage.getC_id()){
			userGradeManage = new UserGradeManage();
			userGradeManage.setC_id(2);
		}
		return coreService.getChildNode(userGradeManage);
	}

	@Override
	public UserGradeManage inquiryUserGradeDetailInf(UserGradeManage userGradeManage) throws Exception {
		
		UserGradeManage rtnUserGradeManage = coreService.getNode(userGradeManage);
		
		List<UserMenuByGrade> userMenuByGradeList = this.inquiryUserMenuByGradeList(rtnUserGradeManage.getC_id());
		
		rtnUserGradeManage.setUserMenuByGradeList(userMenuByGradeList);
		
		return rtnUserGradeManage;
	}

	@Override
	public void saveUserGradeDetailInf(UserGradeManage userGradeManage) throws Exception {
		UserGradeManage rtnUserGradeManage = coreService.addNode(userGradeManage);
		int addGradeId = rtnUserGradeManage.getId();
		
		List<UserMenuByGrade> userMenuByGradeList = userGradeManage.getUserMenuByGradeList();
		if(addGradeId > 0 && userMenuByGradeList != null){
			for(UserMenuByGrade menu : userMenuByGradeList){
				menu.setUserGradeId(addGradeId);
				
				coreService.addNode(menu);
			}
		}	
	}

	@Override
	public List<UserMenuByGrade> inquiryUserMenuByGradeList(int refId) throws Exception {
		UserMenuByGrade userMenuByGrade = new UserMenuByGrade();
		userMenuByGrade.setUserGradeId(refId);
		
		return coreService.getChildNode(userMenuByGrade);
	}

	@Override
	public void updateUserGradeInf(UserGradeManage userGradeManage) throws Exception {
		coreService.alterNode(userGradeManage);
		
		List<UserMenuByGrade> userMenuByGradeList = userGradeManage.getUserMenuByGradeList();
		if(userMenuByGradeList != null){
			UserMenuByGrade rtnUserMenuByGrade = null;
			for(UserMenuByGrade menu : userMenuByGradeList){
				rtnUserMenuByGrade = coreService.getNode(menu);
				
				if(rtnUserMenuByGrade == null){
					menu.setUserGradeId(userGradeManage.getC_id());
					coreService.addNode(menu);
				}
			}
		}
	}

	@Override
	public void removeUserGradeInf(UserGradeManage userGradeManage) throws Exception {
		coreService.removeNode(userGradeManage);
	}
}
