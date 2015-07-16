package standard.mvc.component.business.baroboard.user.note.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import standard.mvc.component.business.baroboard.user.note.vo.UserNoteAttachFile;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteByUser;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteDetail;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteTypeCode;


import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
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

	@Transactional
	@Override
	public void sendNote(UserNoteDetail userNoteDetail) throws Exception {
		userNoteDetail.setRef(2);
		userNoteDetail.setC_type("default");
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
				user.setRef(2);
				user.setC_type("default");
				user.setC_title(userNoteDetail.getC_title());
				user.setNoteDetailId(noteDetailId);
				user.setReceDispDt(receDispDt);
				coreService.addNode(user);
			}
			
			if(!isExistSender){
				UserNoteByUser user = new UserNoteByUser();
				user.setRef(2);
				user.setC_type("default");
				user.setC_title(userNoteDetail.getC_title());
				user.setNoteTypeCode(4); //4 : 발신
				user.setNoteDetailId(noteDetailId);
				user.setReceDispDt(receDispDt);
				user.setUserId(3); //로그인자 id 현재는 하드코딩
				coreService.addNode(user);
			}
		}
		
		List<UserNoteAttachFile> userNoteAttachFileList = userNoteDetail.getUserNoteAttachFileList();
		if(userNoteAttachFileList != null){
			for(UserNoteAttachFile file : userNoteAttachFileList){
				file.setRef(2);
				file.setC_type("default");
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
	public UserNoteDetail inquiryNoteDetail(UserNoteDetail userNoteDetail) throws Exception {
		UserNoteDetail rtnUserNoteDetail = coreService.getNode(userNoteDetail);
		
		UserNoteAttachFile attachFile = new UserNoteAttachFile();
		attachFile.setNoteDetailId(rtnUserNoteDetail.getC_id());
		
		List<UserNoteAttachFile> rtnAttachFileList = coreService.getChildNode(attachFile);
		
		rtnUserNoteDetail.setUserNoteAttachFileList(rtnAttachFileList);
		
		return rtnUserNoteDetail;
	}

	@Override
	public List<UserNoteByUser> inquiryNoteList(UserNoteByUser userNoteByUser) throws Exception {
		List<UserNoteByUser> noteList = coreService.getChildNode(userNoteByUser);
		
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		for(UserNoteByUser note : noteList){
//			
//			String s = DateUtils.getDate(note.getReceDispDt()).toString();
//		}
		
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
}
