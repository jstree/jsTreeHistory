package standard.mvc.component.business.community.constraint.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author Hoseong.Son
 * @since 2014.12.25
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: ForeignServiceImpl.java
 * 	Description : 제약조건 예제 중 주키 트리 서비스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.12.25    Hoseong.Son           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service(value = "ForeignService")
public class ForeignServiceImpl implements CoreService {

	@Resource(name = "CoreService")
	private CoreService coreService;

	@Override
	public <T extends ComprehensiveTree> List<T> getChildNode(
			T comprehensiveTree) throws Exception {
		// TODO Auto-generated method stub
		return coreService.getChildNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> List<String> searchNode(
			T comprehensiveTree) throws Exception {
		// TODO Auto-generated method stub
		return coreService.searchNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> T addNode(T comprehensiveTree)
			throws Exception {
		// TODO Auto-generated method stub
		return coreService.addNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree)
			throws Exception {
		// TODO Auto-generated method stub
		return coreService.removeNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree)
			throws Exception {
		// TODO Auto-generated method stub
		return coreService.alterNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree)
			throws Exception {
		// TODO Auto-generated method stub
		return coreService.alterNodeType(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return coreService.moveNode(comprehensiveTree, request);
	}

}
