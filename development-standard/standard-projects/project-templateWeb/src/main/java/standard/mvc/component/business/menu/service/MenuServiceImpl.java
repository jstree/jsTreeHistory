package standard.mvc.component.business.menu.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import standard.mvc.component.business.menu.dao.MenuDao;
import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

@Service("MenuService")
public class MenuServiceImpl implements MenuService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="MenuDao")
	private MenuDao menuDAO;
	
	@Override
	public List<MenuComprehensiveTree> getChildNode(MenuComprehensiveTree menuComprehensiveTree) {
		return menuDAO.getChildNode( menuComprehensiveTree );
	}

}
