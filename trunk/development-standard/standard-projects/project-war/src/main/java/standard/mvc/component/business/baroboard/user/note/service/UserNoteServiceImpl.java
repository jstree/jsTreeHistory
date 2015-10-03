package standard.mvc.component.business.baroboard.user.note.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import standard.mvc.component.business.baroboard.user.manage.user.dao.UserManageDao;
import standard.mvc.component.business.baroboard.user.note.dao.UserNoteDao;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteAttachFile;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteByUser;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteDetail;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteTypeCode;
import standard.mvc.component.business.baroboard.user.vo.User;


import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLogin;
import egovframework.com.ext.jstree.support.util.DateUtils;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 5. 16.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserNoteServiceImpl.java
 * Description : 바로보드-쪽지 Service 구현 클래스
 * Information : 바로보드-쪽지 Service 구현 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015.5.16.    김대근            최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service
public class UserNoteServiceImpl implements UserNoteService{
	
	@Resource(name = "CoreService")
    private CoreService coreService;

	@Autowired
    private UserNoteDao userNoteDao;
	
	@Transactional
	@Override
	public void sendNote(UserNoteDetail userNoteDetail) throws Exception {
		UserNoteDetail resultSendNote = coreService.addNode(userNoteDetail);
		int noteDetailId = resultSendNote.getId();
		
		List<UserNoteByUser> userNoteByUserList = userNoteDetail.getUserNoteByUserList();
		if(userNoteByUserList != null){
			Date currentDay      = DateUtils.getCurrentDay();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String receDispDt    = sdf.format(currentDay); //수발신일시
			
			boolean isExistSender = false;
			for(UserNoteByUser user : userNoteByUserList){
				if(4 == user.getNoteTypeCode()){
					isExistSender = true;
				}
				user.setC_title(userNoteDetail.getC_title());
				user.setNoteDetailId(noteDetailId);
				user.setReceDispDt(receDispDt);
				coreService.addNode(user);
			}
			
			if(!isExistSender){
				UserNoteByUser user = new UserNoteByUser();
				user.setC_title(userNoteDetail.getC_title());
				user.setNoteTypeCode(4); //4 : 발신
				user.setNoteDetailId(noteDetailId);
				user.setReceDispDt(receDispDt);
				user.setUserId(3); //로그인자 id
				coreService.addNode(user);
			}
		}
		
		List<UserNoteAttachFile> userNoteAttachFileList = userNoteDetail.getUserNoteAttachFileList();
		if(userNoteAttachFileList != null){
			for(UserNoteAttachFile file : userNoteAttachFileList){
				file.setNoteDetailId(noteDetailId);
				coreService.addNode(file);
			}
		}
	}

	@Override
	public void setUserNoteCustody(UserNoteByUser userNoteByUser) throws Exception {
		if(3 == userNoteByUser.getNoteTypeCode()){
			userNoteByUser.setNoteTypeCode(5);
			coreService.alterNode(userNoteByUser);
		}
	}

	@Override
	public List<UserNoteTypeCode> inquiryNoteTypeCodeList() throws Exception {
		UserNoteTypeCode userNoteTypeCode = new UserNoteTypeCode();
		userNoteTypeCode.setC_id(2);
		
		 return coreService.getChildNode(userNoteTypeCode);
	}

	@Override
	public UserNoteByUser inquiryNoteDetail(UserNoteByUser userNoteByUser) throws Exception {
		UserNoteByUser rtnUserNoteByUser = coreService.getNode(userNoteByUser);
		if(StringUtils.isNotBlank(rtnUserNoteByUser.getContent())){
			rtnUserNoteByUser.setContent(rtnUserNoteByUser.getContent().replaceAll("/r/n", "<br>"));
		}
		
		UserNoteAttachFile attachFile = new UserNoteAttachFile();
		attachFile.setNoteDetailId(rtnUserNoteByUser.getNoteDetailId());
		
		List<UserNoteAttachFile> rtnAttachFileList = coreService.getChildNode(attachFile);
		
		rtnUserNoteByUser.setUserNoteAttachFileList(rtnAttachFileList);
		
		return rtnUserNoteByUser;
	}

	@Override
	public List<UserNoteByUser> inquiryNoteList(UserNoteByUser userNoteByUser) throws Exception {
		List<UserNoteByUser> noteList = coreService.getChildNode(userNoteByUser);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(UserNoteByUser note : noteList){
			note.setReceDispDt(format.parse(note.getReceDispDt()).toString());
		}
		
		return noteList;
	}

	@Override
	public void deleteNoteList(List<UserNoteByUser> userNoteByUserList) throws Exception {
		if(userNoteByUserList != null){
			for(UserNoteByUser userNoteByUser : userNoteByUserList){
				this.deleteNote(userNoteByUser);
			}
		}
	}

	@Override
	public void deleteNote(UserNoteByUser userNoteByUser) throws Exception {
		coreService.removeNode(userNoteByUser);
	}

	@Override
	public UserNoteAttachFile inquiryNoteFileInf(UserNoteAttachFile userNoteAttachFile) throws Exception {
		return coreService.getNode(userNoteAttachFile);
	}

	@Override
	public int getCountOfUser(Map<String, Object> paramMap) throws Exception {
        return userNoteDao.selectCountOfUser(paramMap);
	}

	@Override
	public List<UserNoteByUser> getUserListPaginated(Map<String, Object> paramMap) throws Exception {
		List<UserNoteByUser> noteList = userNoteDao.selectUserListPaginated(paramMap);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat StringFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(UserNoteByUser note : noteList){
			Date date = dateFormat.parse(note.getReceDispDt());
			note.setReceDispDt(StringFormat.format(date));
		}
		
		return noteList;
	}
	
	private int getLoginedUserID() throws Exception {
		int loginedUserID;
		
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof String) { // 익명 사용자
			String userStr = (String)user;
			if(userStr.equals("anonymousUser")) {
				loginedUserID = 0;
			} else {
				throw new Exception("허가되지 않은 사용자입니다.");
			}
		} else {	// 로그인 사용자
			SecureUserLogin loginedUser = (SecureUserLogin) user;
			loginedUserID = loginedUser.getId();
		}
		
		return loginedUserID;
	}
}