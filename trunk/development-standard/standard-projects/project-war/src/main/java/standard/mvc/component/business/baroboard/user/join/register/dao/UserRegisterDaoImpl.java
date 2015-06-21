package standard.mvc.component.business.baroboard.user.join.register.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import standard.mvc.component.business.baroboard.user.vo.User;
/**
 * Modification Information
 * 
 * @author 오권우
 * @since 2015. 6. 03.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserRegisterDaoImpl.java
 * Description : 바로보드-사용자 정보 DAO 구현 클래스
 * Information : 바로보드-사용자 정보 DAO 구현 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일          수정자       수정내용
 * -------      ------------  -----------------------
 * 2015. 6. 03.      오권우       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Repository
public class UserRegisterDaoImpl extends EgovComAbstractDAO implements UserRegisterDao {
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public User getUserInfo(String nickName)
			throws Exception {
		// TODO Auto-generated method stub
		return (User)getSqlMapClientTemplate().queryForObject("userRegister.getUserInfo", nickName);
	}

	@Override
	public int getNickNameUseFl(String nickName) throws Exception {
		// TODO Auto-generated method stub
		return (int)getSqlMapClientTemplate().queryForObject("userRegister.getNickNameUseFl", nickName);
	}

	@Override
	public User getUserInfoByEmail(String email) throws Exception
	{
		return (User)selectByPk("userRegister.getUserInfoByEmail", email);
	}

	@Override
	public int setUserPassword(User user) throws Exception
	{
		return (int)update("userRegister.setUserPassword", user);
	}
}
