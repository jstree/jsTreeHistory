package egovframework.com.ext.jstree.springHibernate.core.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.ext.jstree.springHibernate.core.dao.JsTreeGenericHibernateDao;
import egovframework.com.ext.jstree.springHibernate.core.dao.JsTreeGenericHibernateDaoImpl;
import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateDTO;
import egovframework.com.ext.jstree.springmyBatis.core.vo.PaginatedComprehensiveTree;
import egovframework.com.ext.jstree.support.util.ParameterParser;
import egovframework.com.ext.jstree.support.util.SearchSupport;

@Service("jsTreeHibernateService")
@SuppressWarnings("unused")
public class JsTreeHibernateServiceImpl{

	JsTreeGenericHibernateDaoImpl<JsTreeHibernateDTO> jsTreeGenericHibernateDao;
	
	@Autowired
	public void setJsTreeGenericHibernateDao(JsTreeGenericHibernateDaoImpl<JsTreeHibernateDTO> jsTreeGenericHibernateDao) {
		this.jsTreeGenericHibernateDao = jsTreeGenericHibernateDao;
		jsTreeGenericHibernateDao.setClazz(JsTreeHibernateDTO.class);
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see egovframework.com.ext.jstree.springmyBatis.core.service.CoreService#
	 * getNode
	 * (egovframework.com.ext.jstree.springmyBatis.core.vo.JsTreeHibernateDTO)
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
	public <T extends JsTreeHibernateDTO> T getNode(SearchSupport searchSupport) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see egovframework.com.ext.jstree.springmyBatis.core.service.CoreService#
	 * getChildNode
	 * (egovframework.com.ext.jstree.springmyBatis.core.vo.JsTreeHibernateDTO)
	 */
	public <T extends JsTreeHibernateDTO> List<JsTreeHibernateDTO> getChildNode(SearchSupport searchSupport)
			throws Exception {

		return jsTreeGenericHibernateDao.getList(searchSupport);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see egovframework.com.ext.jstree.springmyBatis.core.service.CoreService#
	 * searchNode
	 * (egovframework.com.ext.jstree.springmyBatis.core.vo.JsTreeHibernateDTO)
	 */
	public <T extends JsTreeHibernateDTO> List<String> searchNode(SearchSupport searchSupport)
			throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see egovframework.com.ext.jstree.springmyBatis.core.service.CoreService#
	 * executeRemoveNode
	 * (egovframework.com.ext.jstree.springmyBatis.core.vo.JsTreeHibernateDTO)
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
	public <T extends JsTreeHibernateDTO> int removeNode(SearchSupport searchSupport)
			throws Exception {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * egovframework.com.ext.jstree.springmyBatis.core.service.CoreService#alterNode
	 * (egovframework.com.ext.jstree.springmyBatis.core.vo.JsTreeHibernateDTO)
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
	public <T extends JsTreeHibernateDTO> int alterNode(SearchSupport searchSupport)
			throws Exception {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see egovframework.com.ext.jstree.springmyBatis.core.service.CoreService#
	 * alterNodeType
	 * (egovframework.com.ext.jstree.springmyBatis.core.vo.JsTreeHibernateDTO)
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
	public <T extends JsTreeHibernateDTO> int alterNodeType(SearchSupport searchSupport)
			throws Exception {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * egovframework.com.ext.jstree.springmyBatis.core.service.CoreService#addNode
	 * (egovframework.com.ext.jstree.springmyBatis.core.vo.JsTreeHibernateDTO)
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
	public <T extends JsTreeHibernateDTO> T addNode(SearchSupport searchSupport) throws Exception {
		return null;
	}

	private <T extends JsTreeHibernateDTO> void stretchLeftRightForMyselfFromJstree(int spaceOfTargetNode,
			int rightPositionFromNodeByRef, int copy, Collection<Integer> c_idsByChildNodeFromNodeById,
			T JsTreeHibernateDTO) throws Exception {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * egovframework.com.ext.jstree.springmyBatis.core.service.CoreService#moveNode
	 * (egovframework.com.ext.jstree.springmyBatis.core.vo.JsTreeHibernateDTO)
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
	public <T extends JsTreeHibernateDTO> T moveNode(SearchSupport searchSupport)
			throws Exception {
		return null;
	}

	private <T extends JsTreeHibernateDTO> void cutMyself(T nodeById, int spaceOfTargetNode,
			Collection<Integer> c_idsByChildNodeFromNodeById) throws Exception {
	}

	private <T extends JsTreeHibernateDTO> void calculatePostion(T nodeById,
			List<T> childNodesFromNodeByRef, HttpServletRequest request) throws Exception {
	}

	private <T extends JsTreeHibernateDTO> void stretchPositionForMyselfFromJstree(
			Collection<Integer> c_idsByChildNodeFromNodeById, T JsTreeHibernateDTO) throws Exception {
	}

	private <T extends JsTreeHibernateDTO> int pasteMyselfFromJstree(int ref, int idif, int spaceOfTargetNode,
			int ldif, Collection<Integer> c_idsByChildNodeFromNodeById, int rightPositionFromNodeByRef, T nodeById)
			throws Exception {
		return 0;
	}

	private <T extends JsTreeHibernateDTO> void enterMyselfFromJstree(int ref, int c_position, int c_id, int idif,
			int ldif, Collection<Integer> c_idsByChildNodeFromNodeById, T JsTreeHibernateDTO) throws Exception {
	}

	private <T extends JsTreeHibernateDTO> void fixPositionParentIdOfCopyNodes(int insertSeqResult, int position,
			T t_JsTreeHibernateDTO) throws Exception {
	}

	/**
	 * 파라미터로 넘겨진 인스턴스의 정보를 이용해 리플렉션하여 새로운 인스턴스를 만들어 반환한다.
	 * 
	 * @param JsTreeHibernateDTO
	 *            리플렉션을 위한 타입 정보를 제공하기 위한 인스턴스
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private <T extends JsTreeHibernateDTO> T newInstance(T JsTreeHibernateDTO) throws Exception {
		return null;
	}
}
