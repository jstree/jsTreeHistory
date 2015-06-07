package standard.mvc.component.business.baroboard.user.join.register.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.util.DateUtils;
import standard.mvc.component.business.baroboard.user.join.register.dao.UserRegisterDao;
import standard.mvc.component.business.baroboard.user.vo.User;

/**
 * Modification Information
 * 
 * @author 오권우
 * @since 2015. 6. 03.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserRegisterServiceImpl.java
 * Description : 바로보드- 회원가입-사용자 등록 Service 구현체
 * Infomation  : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 6. 2.       오권우        최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Service(value="UserRegisterService")
public class UserRegisterServiceImpl implements UserRegisterService {
	
	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Resource(name = "CoreDao")
	private CoreDao coreDao;

	@Autowired
	private UserRegisterDao userRegisterDao;
	
    //@Resource(name = "UserRegisterDao")
    //private UserRegisterDao userRegisterDao;
    
	@Override
	public User userRegister(User user) throws Exception {
		
		user.setUserGrade(0); //회원 등급
		user.setJoinStateCd(2); //가입 상태 코드
		
		//String encConverterPwd = encPassword(user.getPassword());
		//user.setPassword(encConverterPwd);
		user.setLoginFailureCnt(0);
		Date currentDay      = DateUtils.getCurrentDay();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentDate = sdf.format(currentDay);
		
		user.setJoinDt(currentDate); //가입 일시
		user.setPasswordChangeDt(currentDate); //비밀번호 변경 일시
		
		coreService.addNode(user);
		
		return null;
	}

	@Override
	public int nickNameUseVerification(String title) throws Exception {
		int nickUseCount = userRegisterDao.getNickNameUseFl(title);
		return nickUseCount;
	}

	@Override
	public int mobilePhoneVerification(String mobilePhone) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String encPassword(String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserInfo(String nickName) throws Exception {
		User userInfo = userRegisterDao.getUserInfo(nickName);
		
		return userInfo;
	}

	@Override
	public String emailSearch(String mobilePhoneNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String passwordSearch(String mobilePhoneNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
