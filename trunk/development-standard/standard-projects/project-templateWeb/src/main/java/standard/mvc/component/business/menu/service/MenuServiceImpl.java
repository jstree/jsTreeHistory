package standard.mvc.component.business.menu.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import standard.mvc.component.business.menu.dao.MenuDao;
import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

@Service("MenuService")
public class MenuServiceImpl implements MenuService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="MenuDao")
	private MenuDao menuDao;
	
	@Override
	public List<MenuComprehensiveTree> getChildNode(MenuComprehensiveTree menuComprehensiveTree) {
		return menuDao.getChildNode( menuComprehensiveTree );
	}
	
	@Override
	public List<String> searchNode( MenuComprehensiveTree menuComprehensiveTree ) {
		
		List<MenuComprehensiveTree> searchNodeByStrings = menuDao.searchNodeByString(   menuComprehensiveTree   );
		List<String>            rowDatas            = menuDao.searchNodeByPosition( searchNodeByStrings );
		
		List<String> returnList = new ArrayList<String>();
		
		for( String rowData : rowDatas ){
			rowData = "#node_" + rowData;
			returnList.add(rowData);
		}
		return returnList;
	}

}
