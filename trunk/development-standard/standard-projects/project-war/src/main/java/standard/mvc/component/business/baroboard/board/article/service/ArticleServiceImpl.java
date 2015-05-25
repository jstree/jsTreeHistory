package standard.mvc.component.business.baroboard.board.article.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : ArticleServiceImpl.java
 * Description : 바로보드-게시판-글관리 Service 구현체
 * Infomation  : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 25.      전경훈        최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Service(value = "ArticleService")
public class ArticleServiceImpl implements CoreService {

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Resource(name = "CoreDao")
	private CoreDao coreDao;
	
	@Override
	public <T extends ComprehensiveTree> T getNode(T comprehensiveTree)	throws Exception {
		T node = coreDao.getNode(comprehensiveTree);
		return node;
	}

	@Override
	public <T extends ComprehensiveTree> List<T> getChildNode(T comprehensiveTree) throws Exception {
		List<T> childNodes = coreDao.getChildNode(comprehensiveTree);
		return childNodes;
	}

	@Override
	public <T extends ComprehensiveTree> List<String> searchNode(T comprehensiveTree) throws Exception {
		return null;
	}

	@Override
	public <T extends ComprehensiveTree> T addNode(T comprehensiveTree)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
