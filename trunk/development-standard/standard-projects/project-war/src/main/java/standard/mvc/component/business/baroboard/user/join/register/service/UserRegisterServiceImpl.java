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
    
	@Override
	public User userRegister(User user) throws Exception {
		Date currentDay      = DateUtils.getCurrentDay();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentDate = sdf.format(currentDay);
		
		user.setC_position(1);
        user.setC_type("default");
        user.setRef(2);
        
        user.setUserGrade(1); //회원 등급
		user.setJoinStateCd(2); //가입 상태 코드
        user.setPasswordFindQuestion("초등학교 이름은");
        user.setPasswordFindAnswer("부원초등학교");
        user.setMailingServiceUseFl("0");
        user.setIndiInfoOpenFl("0");
        user.setJoinDt(currentDate); //가입 일시
        user.setLoginFailureCnt(0);
        user.setPasswordChangeDt(currentDate); //비밀번호 변경 일시
       
        user.setHomepageUrl(" ");
        user.setBlogUrl(" ");
        user.setSign(" ");
        user.setProfilePhoto(" ");
        user.setImageIcon(" ");
		
		//String encConverterPwd = encPassword(user.getPassword());
		//user.setPassword(encConverterPwd);
		
		
		
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
