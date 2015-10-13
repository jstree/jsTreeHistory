package standard.mvc.component.business.baroboard.user.manage.grade.service;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Resource(name = "fileUploadProperties")
	private Properties fileUploadProperties;
	
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
		
		if(StringUtils.isNotBlank(rtnUserGradeManage.getStoreFileNm())){
			String filePath = fileUploadProperties.getProperty("grade.upload.dir");
			filePath = filePath.replace("\\", "/");
			
			rtnUserGradeManage.setStoreFileNm(filePath + rtnUserGradeManage.getStoreFileNm());
		}
		
		List<UserMenuByGrade> userMenuByGradeList = this.inquiryUserMenuByGradeList(rtnUserGradeManage.getC_id());
		
		rtnUserGradeManage.setUserMenuByGradeList(userMenuByGradeList);
		
		return rtnUserGradeManage;
	}

	@Transactional
	@Override
	public void saveUserGradeDetailInf(UserGradeManage userGradeManage) throws Exception {
		UserGradeManage rtnUserGradeManage = coreService.addNode(userGradeManage);
		int newGradeId = rtnUserGradeManage.getId();
		
		String[] menuList = userGradeManage.getAccessMenuList();
		
		if(menuList != null){
			UserMenuByGrade userMenuByGrade = null;
			for(String addMenu : menuList){
				userMenuByGrade = new UserMenuByGrade();
				
				userMenuByGrade.setC_title(addMenu.substring(0, addMenu.indexOf("|")));
				userMenuByGrade.setUserGradeId(newGradeId);
				userMenuByGrade.setMenuId(Integer.parseInt(addMenu.substring(addMenu.indexOf("|") + 1)));
				
				coreService.addNode(userMenuByGrade);
			}
		}
	}

	@Override
	public List<UserMenuByGrade> inquiryUserMenuByGradeList(int refId) throws Exception {
		UserMenuByGrade userMenuByGrade = new UserMenuByGrade();
		userMenuByGrade.setUserGradeId(refId);
		
		return coreService.getChildNode(userMenuByGrade);
	}

	@Transactional
	@Override
	public void updateUserGradeInf(UserGradeManage userGradeManage) throws Exception {
		coreService.alterNode(userGradeManage);
		
		UserMenuByGrade userMenuByGrade = new UserMenuByGrade();
		userMenuByGrade.setUserGradeId(userGradeManage.getC_id());
		List<UserMenuByGrade> userMenuByGradeList = coreService.getChildNode(userMenuByGrade);
		
		String[] userMenuByGradeIdArr = userGradeManage.getAccessMenuList();
		if(userMenuByGradeList != null && userMenuByGradeIdArr != null){
			UserMenuByGrade newMenu = null;
			
			//기존에 저장되어 있는 메뉴 리스트에 삭제된 메뉴를 찾아 삭제처리
			for(UserMenuByGrade menu : userMenuByGradeList){
				boolean isExistsMenu = false;
				
				for(String addMenu : userMenuByGradeIdArr){
					if(menu.getC_id() == Integer.parseInt(addMenu.substring(addMenu.indexOf("|") + 1))){
						isExistsMenu = true;
						break;
					}
				}
				
				if(!isExistsMenu){
					coreService.removeNode(menu);
				}
			}
			
			//기존에 저장되어 있지 않는 메뉴인지 판별하여 신규 추가
			for(String addMenu : userMenuByGradeIdArr){
				boolean isExistsMenu = false;
				for(UserMenuByGrade menu : userMenuByGradeList){
					if(menu.getC_id() == Integer.parseInt(addMenu.substring(addMenu.indexOf("|") + 1))){
						isExistsMenu = true;
						break;
					}
				}
				
				if(!isExistsMenu){
					newMenu = new UserMenuByGrade();
					newMenu.setC_title(addMenu.substring(0, addMenu.indexOf("|")));
					newMenu.setUserGradeId(userGradeManage.getC_id());
					newMenu.setMenuId(Integer.parseInt(addMenu.substring(addMenu.indexOf("|") + 1)));
					coreService.addNode(newMenu);
				}
			}
		}
	}

	@Transactional
	@Override
	public void removeUserGradeInf(UserGradeManage userGradeManage) throws Exception {
		if(userGradeManage.getC_id() > 6){
			coreService.removeNode(userGradeManage);
		}else{
			throw new RuntimeException("기본 제공 등급은 삭제할 수 없습니다.");
		}		
	}
}
