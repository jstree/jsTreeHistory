package standard.mvc.component.business.baroboard.user.manage.note.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import standard.mvc.component.business.baroboard.user.manage.user.note.vo.UserNoteAttachFile;
import standard.mvc.component.business.baroboard.user.manage.user.note.vo.UserNoteByUser;
import standard.mvc.component.business.baroboard.user.manage.user.note.vo.UserNoteDetail;
import standard.mvc.component.business.baroboard.user.manage.user.note.vo.UserNoteTypeCode;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.config.WebApplicationContextConfig;
import egovframework.com.ext.jstree.support.manager.config.WebMvcConfig;
import egovframework.com.ext.jstree.support.util.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApplicationContextConfig.class, WebMvcConfig.class})
@TransactionConfiguration(defaultRollback=true)
public class UserNoteServiceTest {
	
	@Resource(name = "CoreService")
    private CoreService coreService;
	
	@Ignore
	public void sendNote() throws Exception {
		String noteTitle    = "쪽지 제목입니다.444"; //쪽지제목
		String noteContent  = "쪽지 내용입니다..金大根"; //쪽지내용
		String attachFileNm = "김대근 테스트.jpg"; //첨부파일명
				
		//회원쪽지 상세
		UserNoteDetail userNoteDetail = new UserNoteDetail();
		userNoteDetail.setRef(2);
		userNoteDetail.setC_type("default");
		
		userNoteDetail.setC_title(noteTitle);
		userNoteDetail.setContent(noteContent);
		
		//회원별쪽지 리스트
		List<UserNoteByUser> userNoteByUserList = new ArrayList<UserNoteByUser>();
		UserNoteByUser sendUser = new UserNoteByUser();
		sendUser.setRef(2);
		sendUser.setC_type("default");
		sendUser.setC_title(noteTitle);
		sendUser.setUserId(5);
		sendUser.setNoteTypeCode(4); //4 : 발신
		userNoteByUserList.add(sendUser);
		
		UserNoteByUser recvUser = new UserNoteByUser();
		recvUser.setRef(2);
		recvUser.setC_type("default");
		recvUser.setC_title(noteTitle);
		recvUser.setUserId(6);
		recvUser.setNoteTypeCode(3); //3 : 수신
		userNoteByUserList.add(recvUser);
		
		recvUser = new UserNoteByUser();
		recvUser.setRef(2);
		recvUser.setC_type("default");
		recvUser.setC_title(noteTitle);
		recvUser.setUserId(7);
		recvUser.setNoteTypeCode(3); //3 : 수신
		userNoteByUserList.add(recvUser);
		
		userNoteDetail.setUserNoteByUserList(userNoteByUserList);
		
		//회원쪽지첨부파일 리스트
		List<UserNoteAttachFile> userNoteAttachFileList = new ArrayList<UserNoteAttachFile>();
		UserNoteAttachFile attachFile = new UserNoteAttachFile();
		attachFile.setRef(2);
		attachFile.setC_type("default");
		attachFile.setC_title(attachFileNm);
		attachFile.setStoreFileNm(attachFileNm); //추후 실제 파일명 변환이 필요하다
		userNoteAttachFileList.add(attachFile);
		
		userNoteDetail.setUserNoteAttachFileList(userNoteAttachFileList);
		
		/*
		 *쪽지 발송 시작.. 
		 */
		UserNoteDetail resultSendNote = coreService.addNode(userNoteDetail);
		int noteDetailId = resultSendNote.getId();
		
		if(userNoteByUserList != null){
			Date currentDay      = DateUtils.getCurrentDay();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String receDispDt    = sdf.format(currentDay); //수발신일시
			
			for(UserNoteByUser user : userNoteByUserList){
				user.setNoteDetailId(noteDetailId);
				user.setReceDispDt(receDispDt);
				coreService.addNode(user);
			}
		}
		
		if(userNoteAttachFileList != null){
			for(UserNoteAttachFile file : userNoteAttachFileList){
				file.setNoteDetailId(noteDetailId);
				coreService.addNode(file);
			}
		}
	}
	
	@Ignore
	public void setUserNoteCustody() throws Exception {
		UserNoteByUser userNoteByUser = new UserNoteByUser();
		userNoteByUser.setC_id(5);
		userNoteByUser.setC_title("쪽지 제목입니다.222");
		userNoteByUser.setC_type("default");
		userNoteByUser.setUserId(7);
		userNoteByUser.setNoteDetailId(4);
		userNoteByUser.setReceDispDt("20150523124208");
		
		//달랑 유형코드 하나만 바꾸는데 화면에서 컬럼값을 너무 많이 받아와야함..
		userNoteByUser.setNoteTypeCode(3);
		
		if(3 == userNoteByUser.getNoteTypeCode()){
			userNoteByUser.setNoteTypeCode(5);
			coreService.alterNode(userNoteByUser);
		}
	}
	
	@Ignore
	public void inquiryNoteTypeCodeList() throws Exception {
		UserNoteTypeCode userNoteTypeCode = new UserNoteTypeCode();
		userNoteTypeCode.setC_id(2);
		
		List<UserNoteTypeCode> userNoteTypeCodeList = coreService.getChildNode(userNoteTypeCode);
	}
	
	@Ignore
	public void inquiryNoteDetail() throws Exception {
		int noteDetailId = 5; //쪽지상세 C_ID
		
		UserNoteDetail userNoteDetail = new UserNoteDetail();
		userNoteDetail.setC_id(noteDetailId);
		
		UserNoteDetail rtnUserNoteDetail = coreService.getNode(userNoteDetail);
		
		UserNoteAttachFile attachFile = new UserNoteAttachFile();
		attachFile.setNoteDetailId(rtnUserNoteDetail.getC_id());
		
		List<UserNoteAttachFile> rtnAttachFileList = coreService.getChildNode(attachFile);
		
		rtnUserNoteDetail.setUserNoteAttachFileList(rtnAttachFileList);
	}

	@Test
	public void inquiryNoteList() throws Exception {
		UserNoteByUser userNoteByUser = new UserNoteByUser();
		userNoteByUser.setUserId(7);
		userNoteByUser.setNoteTypeCode(3); //3:수신, 4:발신, 5:보관
		
		List<UserNoteByUser> rtnUsrNoteByUserList = coreService.getChildNode(userNoteByUser);
	}
	
	@Ignore
	public void deleteNoteList() throws Exception {
		List<UserNoteByUser> userNoteByUserList = new ArrayList<UserNoteByUser>();
		
		UserNoteByUser deleteUserNoteByUser = new UserNoteByUser();
		deleteUserNoteByUser.setC_id(4);
		userNoteByUserList.add(deleteUserNoteByUser);
		
		deleteUserNoteByUser = new UserNoteByUser();
		deleteUserNoteByUser.setC_id(7);
		userNoteByUserList.add(deleteUserNoteByUser);
		
		if(userNoteByUserList != null){
			for(UserNoteByUser userNoteByUser : userNoteByUserList){
				this.deleteNote(userNoteByUser);
			}
		}
	}

	public void deleteNote(UserNoteByUser userNoteByUser) throws Exception {
		coreService.removeNode(userNoteByUser);
	}
}
