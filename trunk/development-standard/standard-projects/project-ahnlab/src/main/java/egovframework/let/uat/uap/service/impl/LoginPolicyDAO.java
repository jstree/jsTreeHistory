package egovframework.let.uat.uap.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import egovframework.let.uat.uap.service.LoginPolicy;
import egovframework.let.uat.uap.service.LoginPolicyVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
/**
 * 로그인정책에 대한 DAO 클래스를 정의한다.
 * 로그인정책에 대한 등록, 수정, 삭제, 조회, 반영확인 기능을 제공한다.
 * 로그인정책의 조회기능은 목록조회, 상세조회로 구분된다.
 * @author 공통서비스개발팀 lee.m.j
 * @since 2009.08.03
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.08.03  lee.m.j        최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성 
 *
 * </pre>
 */
@Repository("loginPolicyDAO")
public class LoginPolicyDAO extends EgovAbstractDAO {
	
    /** Log Info */
    protected Log log = LogFactory.getLog(this.getClass());
	/**
	 * 로그인정책 목록을 조회한다.
	 * @param loginPolicyVO - 로그인정책 VO
	 * @return List - 로그인정책 목록
	 */
	@SuppressWarnings("unchecked")
	public List<LoginPolicyVO> selectLoginPolicyList(LoginPolicyVO loginPolicyVO) throws Exception {
		return list("loginPolicyDAO.selectLoginPolicyList", loginPolicyVO);
	}

	/**
	 * 로그인정책 목록 수를 조회한다.
	 * @param loginPolicyVO - 로그인정책 VO
	 * @return int
	 */
	public int selectLoginPolicyListTotCnt(LoginPolicyVO loginPolicyVO) throws Exception {
		return (Integer)getSqlMapClientTemplate().queryForObject("loginPolicyDAO.selectLoginPolicyListTotCnt", loginPolicyVO);
	}

	/**
	 * 로그인정책 목록의 상세정보를 조회한다.
	 * @param loginPolicyVO - 로그인정책 VO
	 * @return LoginPolicyVO - 로그인정책 VO
	 */
	public LoginPolicyVO selectLoginPolicy(LoginPolicyVO loginPolicyVO) throws Exception {
		return (LoginPolicyVO)selectByPk("loginPolicyDAO.selectLoginPolicy", loginPolicyVO);
	}

	/**
	 * 로그인정책 정보를 신규로 등록한다.
	 * @param loginPolicy - 로그인정책 model
	 */
	public void insertLoginPolicy(LoginPolicy loginPolicy) throws Exception {
        insert("loginPolicyDAO.insertLoginPolicy", loginPolicy);
	}

	/**
	 * 기 등록된 로그인정책 정보를 수정한다.
	 * @param loginPolicy - 로그인정책 model
	 */
	public void updateLoginPolicy(LoginPolicy loginPolicy) throws Exception {
		update("loginPolicyDAO.updateLoginPolicy", loginPolicy);
	}

	/**
	 * 기 등록된 로그인정책 정보를 삭제한다.
	 * @param loginPolicy - 로그인정책 model
	 */
	public void deleteLoginPolicy(LoginPolicy loginPolicy) throws Exception {
		delete("loginPolicyDAO.deleteLoginPolicy", loginPolicy);
	}

	/**
	 * 로그인정책에 대한 현재 반영되어 있는 결과를 조회한다.
	 * @param loginPolicyVO - 로그인정책 VO
	 * @return LoginPolicyVO - 로그인정책 VO
	 */
	public LoginPolicyVO selectLoginPolicyResult(LoginPolicyVO loginPolicyVO) throws Exception {
		return null;
	}
}
