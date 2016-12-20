package egovframework.com.ext.jstree.springHibernate.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.ext.jstree.springHibernate.core.dao.JsTreeHibernateDao;
import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateDTO;
import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateSearchDTO;

@Service("JsTreeHibernateSerive")
public class JsTreeHibernateSeriveImpl implements JsTreeHibernateSerive {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("rawtypes")
	@Resource(name = "jsTreeHibernateDao")
	private JsTreeHibernateDao jsTreeHibernateDao;

	@SuppressWarnings("unchecked")
	@Override
	public <T extends JsTreeHibernateSearchDTO> T getNode(T jsTreeHibernateDTO) throws Exception {
		logger.info("getNode");
		jsTreeHibernateDao.setClazz(JsTreeHibernateDTO.class);
		Object uniqueObj = jsTreeHibernateDao.getUnique(jsTreeHibernateDTO.getC_id());
		return (T) uniqueObj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends JsTreeHibernateSearchDTO> List<T> getChildNode(T jsTreeHibernateDTO) throws Exception {
		jsTreeHibernateDao.setClazz(JsTreeHibernateDTO.class);
		List<JsTreeHibernateDTO> list = jsTreeHibernateDao.getList(jsTreeHibernateDTO);
		return (List<T>) list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends JsTreeHibernateSearchDTO> List<String> searchNode(T jsTreeHibernateDTO) throws Exception {
		jsTreeHibernateDao.setClazz(JsTreeHibernateDTO.class);
		List<JsTreeHibernateDTO> collectionObjects = jsTreeHibernateDao.getList(jsTreeHibernateDTO);
		List<String> returnList = new ArrayList<String>();
		for (JsTreeHibernateDTO rowObject : collectionObjects) {
			String rowData = "#node_" + rowObject.getC_id();
			returnList.add(rowData);
		}
		return returnList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
	public <T extends JsTreeHibernateSearchDTO> T addNode(T jsTreeHibernateDTO) throws Exception {

		jsTreeHibernateDao.setClazz(JsTreeHibernateDTO.class);
		if (jsTreeHibernateDTO.getRef() < 0) {
			throw new RuntimeException("ref is minus");
		} else {
			JsTreeHibernateDTO nodeByRef = (JsTreeHibernateDTO) jsTreeHibernateDao.getUnique(jsTreeHibernateDTO
					.getRef());

			if ("default".equals(nodeByRef.getC_type())) {
				throw new RuntimeException("nodeByRef is default Type");
			}
			nodeByRef.setWhere("c_parentid", nodeByRef.getC_id());
			final long lastPosiotionOfNodeByRef = jsTreeHibernateDao.getCount(nodeByRef);

			jsTreeHibernateDTO.setC_position(lastPosiotionOfNodeByRef);

			long rightPointFromNodeByRef = nodeByRef.getC_right();
			rightPointFromNodeByRef = Math.max(rightPointFromNodeByRef, 1);

			long spaceOfTargetNode = 2;

			this.stretchLeftRightForMyselfFromJstree(spaceOfTargetNode, rightPointFromNodeByRef,
					jsTreeHibernateDTO.getCopy(), null, jsTreeHibernateDTO);

			long targetNodeLevel = jsTreeHibernateDTO.getRef() == 0 ? 0 : nodeByRef.getC_level() + 1;

			jsTreeHibernateDTO.setC_parentid(jsTreeHibernateDTO.getRef());
			jsTreeHibernateDTO.setC_left(rightPointFromNodeByRef);
			jsTreeHibernateDTO.setC_right(rightPointFromNodeByRef + 1);
			jsTreeHibernateDTO.setC_level(targetNodeLevel);

			long insertSeqResult = (long) jsTreeHibernateDao.insert(jsTreeHibernateDTO);
			if(insertSeqResult > 0){
				final long SUCCESS = 1;
				jsTreeHibernateDTO.setStatus(SUCCESS);
			} else {
				throw new RuntimeException("심각한 오류 발생 - 삽입 노드");
			}
		}
		return jsTreeHibernateDTO;
	}

	private <T extends JsTreeHibernateSearchDTO> void stretchLeftRightForMyselfFromJstree(long spaceOfTargetNode,
			long rightPositionFromNodeByRef, long copy, Collection<Long> c_idsByChildNodeFromNodeById,
			T jsTreeHibernateDTO) throws Exception {
		T onlyStretchLeftRightForMyselfFromJstree = newInstance(jsTreeHibernateDTO);

		onlyStretchLeftRightForMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
		onlyStretchLeftRightForMyselfFromJstree.setRightPositionFromNodeByRef(rightPositionFromNodeByRef);
		onlyStretchLeftRightForMyselfFromJstree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
		onlyStretchLeftRightForMyselfFromJstree.setCopy(copy);

		DetachedCriteria detachedRightCriteria = DetachedCriteria.forClass(jsTreeHibernateDTO.getClass());
		stretchRight(spaceOfTargetNode, rightPositionFromNodeByRef, copy, c_idsByChildNodeFromNodeById,
				detachedRightCriteria);
		DetachedCriteria detachedLeftCriteria = DetachedCriteria.forClass(jsTreeHibernateDTO.getClass());
		stretchLeft(spaceOfTargetNode, rightPositionFromNodeByRef, copy, c_idsByChildNodeFromNodeById,
				detachedLeftCriteria);
	}

	@SuppressWarnings("unchecked")
	private void stretchRight(long spaceOfTargetNode, long rightPositionFromNodeByRef, long copy,
			Collection<Long> c_idsByChildNodeFromNodeById, DetachedCriteria detachedCriteria) {
		Criterion where = Restrictions.ge("c_right", rightPositionFromNodeByRef);
		detachedCriteria.add(where);
		if (copy == 0) {
			if (c_idsByChildNodeFromNodeById != null && c_idsByChildNodeFromNodeById.size() > 0) {
				detachedCriteria.add(Restrictions.and(Restrictions.not(Restrictions.in("c_id",
						c_idsByChildNodeFromNodeById))));
			}
		}
		detachedCriteria.addOrder(Order.asc("c_id"));
		List<JsTreeHibernateDTO> updateTargetList = jsTreeHibernateDao.getListWithoutPaging(detachedCriteria);

		for (JsTreeHibernateDTO perJsTreeHibernateDTO : updateTargetList) {
			perJsTreeHibernateDTO.setC_right(perJsTreeHibernateDTO.getC_right() + spaceOfTargetNode);
			try {
				jsTreeHibernateDao.storeOrUpdate(perJsTreeHibernateDTO);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void stretchLeft(long spaceOfTargetNode, long rightPositionFromNodeByRef, long copy,
			Collection<Long> c_idsByChildNodeFromNodeById, DetachedCriteria detachedCriteria) {
		Criterion where = Restrictions.ge("c_left", rightPositionFromNodeByRef);
		detachedCriteria.add(where);
		if (copy == 0) {
			if (c_idsByChildNodeFromNodeById != null && c_idsByChildNodeFromNodeById.size() > 0) {
				detachedCriteria.add(Restrictions.and(Restrictions.not(Restrictions.in("c_id",
						c_idsByChildNodeFromNodeById))));
			}
		}
		detachedCriteria.addOrder(Order.asc("c_id"));
		List<JsTreeHibernateDTO> updateTargetList = jsTreeHibernateDao.getListWithoutPaging(detachedCriteria);

		for (JsTreeHibernateDTO perJsTreeHibernateDTO : updateTargetList) {
			perJsTreeHibernateDTO.setC_left(perJsTreeHibernateDTO.getC_left() + spaceOfTargetNode);
			try {
				jsTreeHibernateDao.storeOrUpdate(perJsTreeHibernateDTO);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * 파라미터로 넘겨진 인스턴스의 정보를 이용해 리플렉션하여 새로운 인스턴스를 만들어 반환한다.
	 * 
	 * @param comprehensiveTree
	 *            리플렉션을 위한 타입 정보를 제공하기 위한 인스턴스
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	private <T extends JsTreeHibernateSearchDTO> T newInstance(T jsTreeHibernateDTO) throws Exception {
		Class<T> target = (Class<T>) Class.forName(jsTreeHibernateDTO.getClass().getCanonicalName());
		return target.newInstance();
	}

	@Override
	public <T extends JsTreeHibernateSearchDTO> int removeNode(T jsTreeHibernateDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends JsTreeHibernateSearchDTO> int alterNode(T jsTreeHibernateDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends JsTreeHibernateSearchDTO> int alterNodeType(T jsTreeHibernateDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends JsTreeHibernateSearchDTO> T moveNode(T jsTreeHibernateDTO, HttpServletRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
