package egovframework.com.ext.jstree.springHibernate.core.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springHibernate.core.dao.JsTreeHibernateDao;
import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateDTO;
import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateSearchDTO;

@Service("JsTreeHibernateSerive")
public class JsTreeHibernateSeriveImpl implements JsTreeHibernateSerive{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@SuppressWarnings("rawtypes")
	@Resource(name = "jsTreeHibernateDao")
	private JsTreeHibernateDao jsTreeHibernateDao;

	@SuppressWarnings("unchecked")
	@Override
	public <T extends JsTreeHibernateSearchDTO> T getNode(T jsTreeHibernateDTO) throws Exception {
		
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

	@Override
	public <T extends JsTreeHibernateSearchDTO> List<String> searchNode(T jsTreeHibernateDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends JsTreeHibernateSearchDTO> T addNode(T jsTreeHibernateDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
