package egovframework.rivalwar.api.menu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springHibernate.core.service.JsTreeHibernateSerive;
import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateSearchDTO;

@Service("MenuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private JsTreeHibernateSerive jsTreeHibernateSerive;
	
	@Override
	public <T extends JsTreeHibernateSearchDTO> T getMenu(T jsTreeHibernateDTO) throws Exception {
		T menu = jsTreeHibernateSerive.getNode(jsTreeHibernateDTO);
		return menu;
	}

	@Override
	public <T extends JsTreeHibernateSearchDTO> List<T> getChildMenu(T jsTreeHibernateDTO) throws Exception {
		return jsTreeHibernateSerive.getChildNode(jsTreeHibernateDTO);
	}

	@Override
	public <T extends JsTreeHibernateSearchDTO> List<String> searchMenu(T jsTreeHibernateDTO) throws Exception {
		return jsTreeHibernateSerive.searchNode(jsTreeHibernateDTO);
	}

	@Override
	public <T extends JsTreeHibernateSearchDTO> T addMenu(T jsTreeHibernateDTO) throws Exception {
		return jsTreeHibernateSerive.addNode(jsTreeHibernateDTO);
	}

	@Override
	public <T extends JsTreeHibernateSearchDTO> int removeMenu(T jsTreeHibernateDTO) throws Exception {
		return jsTreeHibernateSerive.removeNode(jsTreeHibernateDTO);
	}

	@Override
	public <T extends JsTreeHibernateSearchDTO> int alterMenu(T jsTreeHibernateDTO) throws Exception {
		return jsTreeHibernateSerive.alterNode(jsTreeHibernateDTO);
	}

	@Override
	public <T extends JsTreeHibernateSearchDTO> int alterMenuType(T jsTreeHibernateDTO) throws Exception {
		return jsTreeHibernateSerive.alterNodeType(jsTreeHibernateDTO);
	}

	@Override
	public <T extends JsTreeHibernateSearchDTO> T moveMenu(T jsTreeHibernateDTO, HttpServletRequest request)
			throws Exception {
		return jsTreeHibernateSerive.moveNode(jsTreeHibernateDTO, request);
	}
}